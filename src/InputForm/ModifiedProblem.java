package InputForm;

import java.util.ArrayList;
import java.util.List;

public class ModifiedProblem {
    private List<Double> sphereB;
    private List<Double> sphereA;
    private List<Double> centreB;
    private List<Double> centreA;

    private ArrayList<Double> Plane;
    private ArrayList<Double> normalPlaneVector;
    private ArrayList<ArrayList<Double>> Line;

    private Double RadiusA;
    private Double RadiusB;

    public ArrayList<ArrayList<Double>> resDots;
    private ArrayList<Double> resDot;

    public ModifiedProblem(ArrayList<ArrayList<Double>> data) {
        this.sphereA = data.get(0);
        this.sphereB = data.get(1);

        this.centreA = data.get(0).subList(0, 3);
        this.centreB = data.get(1).subList(0, 3);

        this.RadiusA = data.get(0).get(3);
        this.RadiusB = data.get(1).get(3);

        this.Line = new ArrayList<>();
        this.normalPlaneVector = new ArrayList<>();
    }


    public void countDot() {
        countDirVector(); // направляющий и нормальный вектор
        countLine();
        countCoeffs();

        try {

            if (resDots.size() == 2) {
                double len1 = getLength(resDots.get(0).get(0), resDots.get(0).get(1), resDots.get(0).get(2));
                double len2 = getLength(resDots.get(1).get(0), resDots.get(1).get(1), resDots.get(1).get(2));
                resDot = len1 > len2 ? resDots.get(0) : resDots.get(1);

            } else resDot = resDots.get(0);

            //System.out.printf("(%.7f, %.7f, %.7f)%n",resDot.get(0),resDot.get(1),resDot.get(2));

            //System.out.println("(" + resDot.get(0) + ", " + resDot.get(1) + ", " + resDot.get(2) + ")");

        } catch (NullPointerException e) {
            System.out.println("Прямая не пересекает сферу.");
        }
    }


    private void countCoeffs() {
        double a, b, c;

        double x1 = Line.get(0).get(0);
        double y1 = Line.get(1).get(0);
        double z1 = Line.get(2).get(0);

//        System.out.println("x1 = " + x1);
//        System.out.println("y1 = " + y1);
//        System.out.println("z1 = " + z1);

        double i = Line.get(0).get(1);
        double j = Line.get(1).get(1);
        double k = Line.get(2).get(1);

//        System.out.println("i = " + i);
//        System.out.println("j = " + j);
//        System.out.println("k = " + k);

        double l = centreB.get(0);
        double m = centreB.get(1);
        double n = centreB.get(2);

        a = Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(k, 2);
        b = 2 * (i * (x1 - l) + j * (y1 - m) + k * (z1 - n));
        c = Math.pow((x1 - l), 2) + Math.pow((y1 - m), 2) + Math.pow((z1 - n), 2) - Math.pow(RadiusB, 2);

        quadraticEquation(a, b, c);
    }

    public void countDirVector() {
        for (int i = 0; i < 3; i++) {
            normalPlaneVector.add(centreB.get(i) - centreA.get(i));
        }
    }

    private void quadraticEquation(double a, double b, double c) {
        double d, x1, x2;
        d = Math.pow(b, 2) - (4 * a * c);

        if (d > 0) {
            x1 = ((-1) * b + Math.sqrt(d)) / 2 / a;
            x2 = ((-1) * b - Math.sqrt(d)) / 2 / a;
            //System.out.println("x1 = " + x1 + " x2 = " + x2);
            getDots(x1, x2);
        } else if (d == 0) {
            x1 = -b / (2 * a);
            //System.out.println("x1 = x2 = " + x1);
            getDots(x1, x1);
        }
    }

    private void getDots(double t1, double t2) {

        if (t1 == t2) {
            resDots = new ArrayList<>();
            resDots.add(new ArrayList<>());

            resDots.get(0).add(Line.get(0).get(0) + Line.get(0).get(1) * t1);
            resDots.get(0).add(Line.get(1).get(0) + Line.get(1).get(1) * t1);
            resDots.get(0).add(Line.get(2).get(0) + Line.get(2).get(1) * t1);
        } else {
            resDots = new ArrayList<>();
            resDots.add(new ArrayList<>());
            resDots.add(new ArrayList<>());

            resDots.get(0).add(Line.get(0).get(0) + Line.get(0).get(1) * t1);
            resDots.get(0).add(Line.get(1).get(0) + Line.get(1).get(1) * t1);
            resDots.get(0).add(Line.get(2).get(0) + Line.get(2).get(1) * t1);

            resDots.get(1).add(Line.get(0).get(0) + Line.get(0).get(1) * t2);
            resDots.get(1).add(Line.get(1).get(0) + Line.get(1).get(1) * t2);
            resDots.get(1).add(Line.get(2).get(0) + Line.get(2).get(1) * t2);
        }
    }

    private void countLine() {
        for (int i = 0; i < 3; i++) {
            Line.add(new ArrayList<>(2));
            Line.get(i).add(centreB.get(i));
            Line.get(i).add(normalPlaneVector.get(i));
        }
    }

    private double getLength(double x, double y, double z) {
        return Math.sqrt(Math.pow(centreB.get(0) - x, 2) + Math.pow(centreB.get(1) - y, 2) + Math.pow(centreB.get(2) - z, 2));
    }

    public ArrayList<Double> getResult() {
        return resDot;
    }

    public ArrayList<Double> getLineDir() {
        return normalPlaneVector;
    }

}

//найти напрвляющий вектор
//найти точку пересечения прямой и окружности
//выбрать нужную точку

package InputForm;

import java.util.ArrayList;

/**
 * Created by mariakovega on 19/11/2018.
 */
public class DirectProblem {
    private ArrayList<Double> dirVector;
    private ArrayList<Double> DotA;
    private ArrayList<Double> DotB;
    private ArrayList<Double> canonicVector;

    public DirectProblem(ArrayList<ArrayList<Double>> data) {
        this.DotA = data.get(0);
        this.DotB = data.get(1);
        this.dirVector = new ArrayList<>(3);
        this.canonicVector = new ArrayList<>(4);
    }

    //поиск направляющего вектора
    public void countDirVector() {
        for (int i = 0; i < 3; i++) {
            dirVector.add(DotA.get(i) - DotB.get(i));
        }
        countPlane();
    }

    private void countPlane() {
        canonicVector.addAll(dirVector);
        canonicVector.add(DotA.get(0) * (-1) * dirVector.get(0) + DotA.get(1) * (-1) * dirVector.get(1)
                + DotA.get(2) * (-1) * dirVector.get(2));

        //canonicVector.forEach(System.out::println);
        System.out.println("(" + canonicVector.get(0) + ", " + canonicVector.get(1) +
                ", " + canonicVector.get(2) + ", " + canonicVector.get(3) + ")");
    }

    private int CheckSign(double a) {
        int res = 0;
        if (a < 0)
            res = -1;
        else if (a == 0)
            res = 0;
        else if (a > 0)
            res = 1;
        return res;
    }
}

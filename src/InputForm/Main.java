package InputForm;

import java.util.ArrayList;

/**
 * Created by mariakovega on 19/11/2018.
 */
public class Main {

    //<editor-fold desc="Tests">
    //1 задача test
    private void test1(String[] args) {
        ReadData read = new ReadData(args);
        ArrayList<ArrayList<Double>> data = read.readDots();
        DirectProblem problem = new DirectProblem(data);
        problem.countDirVector();
    }

    //2 задача test1
    private void test2(String[] args) {
        ReadData read = new ReadData(args);
        ArrayList<ArrayList<Double>> data = read.readElems();
        InverseProblem problem1 = new InverseProblem(data);
        problem1.countDot();
    }

    //3 задача test2
    private void test3(String[] args) {
        ReadData read = new ReadData(args);
        ArrayList<ArrayList<Double>> data;
        data = read.readModData();

        ModifiedProblem problem = new ModifiedProblem(data);
        problem.countDot();

        ChangingData cd = new ChangingData(read.getCentreB(), read.getAllData());
        cd.solve();

//        PrintTable pt = new InputForm.PrintTable(cd.getResDelta());
//
//
//        System.out.printf("(alpha = %f, beta = %.7f, gamma = %.7f)%n", degreeRange(Math.toDegrees(Math.atan(-problem.getResult().get(0) / problem.getResult().get(1)))),
//               degreeRange(Math.toDegrees(Math.atan(-problem.getResult().get(2) / problem.getResult().get(0)))), degreeRange(Math.toDegrees(Math.atan(-problem.getResult().get(1) / problem.getResult().get(2)))));
//        System.out.printf("(alpha = %f, beta = %.7f, gamma = %.7f)%n", Math.toDegrees(Math.atan(-problem.getResult().get(0) / problem.getResult().get(1))),
//                Math.toDegrees(Math.atan(-problem.getResult().get(2) / problem.getResult().get(0))), Math.toDegrees(Math.atan(-problem.getResult().get(1) / problem.getResult().get(2))));
    }
    //</editor-fold>

    public static void main(String[] args) {
        InputForm app = new InputForm();
        app.setVisible(true);
    }

}


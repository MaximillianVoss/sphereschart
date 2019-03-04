import java.util.ArrayList;

/**
 * Created by mariakovega on 19/11/2018.
 */
public class Main {
    public static void main(String[] args) {
        Interface app = new Interface();
        app.setVisible(true);

        ReadData read = new ReadData(args);

        //1 задача test
//        ArrayList<ArrayList<Double>> data;
//        data = read.readDots();
//
//        DirectProblem problem = new DirectProblem(data);
//        problem.countDirVector();

        //2 задача test1
//        ArrayList<ArrayList<Double>> data1;
//        data1 = read.readElems();
//
//        InverseProblem problem1 = new InverseProblem(data1);
//        problem1.countDot();

        //3 задача test2
        ArrayList<ArrayList<Double>> data2;
        data2 = read.readModData();

        ModifiedProblem problem2 = new ModifiedProblem(data2);
        problem2.countDot();

        ChangingData cd = new ChangingData(read.getCentreB(), read.getAllData());
        cd.solve();

        PrintTable pt = new PrintTable(cd.getResDelta());
    }
}

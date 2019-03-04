import java.util.ArrayList;

public class PrintTable {

    public PrintTable() {}

    public PrintTable(ArrayList<Double> data) {
        System.out.printf("(delta = %f, Delta = %.7f)%n", data.get(0), data.get(1));
    }
}

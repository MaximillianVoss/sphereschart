package InputForm;

import java.util.ArrayList;
import java.util.List;


public class ChangingData {
    private List<Double> centreB;
    private ArrayList<ArrayList<Double>> data2;
    private ArrayList<ArrayList<Double>> finalData;
    private ArrayList<Double> resDelta;
    private final double DELTA = 0.01;


    public ChangingData(List<Double> centreB, ArrayList<ArrayList<Double>> data2) {
        this.centreB = centreB;
        this.data2 = data2;
        this.finalData  = new ArrayList<>();
        this.resDelta = new ArrayList<>();
    }

    public void solve() {
        AddDelta(centreB, data2);
    }

    private void AddDelta(List<Double> centre, ArrayList<ArrayList<Double>> data2) {
        ModifiedProblem problem1 = new ModifiedProblem(data2);
        problem1.countDot();

        ArrayList<Double> newData =  new ArrayList<>();

        List<Double> centre1 =  centre;

        double delta = DELTA;
        //цикл по точкам
        for (int j = 0; j < centre.size(); j += 1) {
            centre1.set(j, centre.get(j) + delta);
        }

        newData.addAll(centre1);
        newData.add(data2.get(1).get(3)); //добавили радиус

        finalData.add(data2.get(0));
        finalData.add(newData);

        //решаем задачу с изменненными данными
        ModifiedProblem problem2 = new ModifiedProblem(finalData);
        problem2.countDot();

        resDelta.add(delta);
        CountDelta(problem1, problem2);
        centre1.clear();
    }

    private void CountDelta(ModifiedProblem mp1, ModifiedProblem mp2) {
        resDelta.add(Math.sqrt(Math.pow(mp1.getResult().get(0) - mp2.getResult().get(0), 2) +
                Math.pow(mp1.getResult().get(1) - mp2.getResult().get(1), 2) +
                Math.pow(mp1.getResult().get(2) - mp2.getResult().get(2), 2)));
    }

    public ArrayList<Double> getResDelta() {
        return resDelta;
    }
}

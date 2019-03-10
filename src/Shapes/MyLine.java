package Shapes;

public class MyLine {
    public MyPoint p1, p2;

    public MyLine() {
        this.p1 = new MyPoint();
        this.p2 = new MyPoint();
    }

    public MyLine(MyPoint p1, MyPoint p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}

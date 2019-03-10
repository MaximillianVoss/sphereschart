package Shapes;

public class MyPoint {
    public double x, y, z;

    public MyPoint() {
        Init(0, 0, 0);
    }

    public MyPoint(double x, double y, double z) {
        Init(x, y, z);
    }

    private void Init(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

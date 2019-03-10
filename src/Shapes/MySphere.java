package Shapes;

public class MySphere {
    public double x, y, z;
    public MyPoint p;
    public double r;

    public MySphere() {
        this.Init(0, 0, 0, 10);
    }

    public MySphere(MyPoint p, double r) {
        Init(p, r);
    }

    public MySphere(double x, double y, double z, double r) {
        Init(x, y, z, r);
    }

    private void Init(MyPoint p, double r) {
        this.p = p;
        Init(p.x, p.y, p.z, r);
    }

    private void Init(double x, double y, double z, double r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }
}

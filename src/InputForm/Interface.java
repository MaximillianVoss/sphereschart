package InputForm;

import Data.CommonData;
import DrawFrom.DrawApp;
import Shapes.MyLine;
import Shapes.MyPoint;
import Shapes.MySphere;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Interface extends JFrame {
    //<editor-fold desc="Public Fields">
    public MySphere spheres[];
    public MySphere points[];
    public MyLine line;
    public Boolean dataReady = false;
    //</editor-fold>

    //<editor-fold desc="Private fields">
    private final String ft = "#0.0000";
    private JButton button = new JButton("Press");
    private JTextField inputXA = new JTextField("", 5);
    private JTextField inputXB = new JTextField("", 5);
    private JTextField inputYA = new JTextField("", 5);
    private JTextField inputYB = new JTextField("", 5);
    private JTextField inputZA = new JTextField("", 5);
    private JTextField inputZB = new JTextField("", 5);
    private JTextField inputRA = new JTextField("", 5);
    private JTextField inputRB = new JTextField("", 5);
    private JTextField outputAngleX = new JTextField("", 5);
    private JTextField outputAngleY = new JTextField("", 5);
    private JTextField outputAngleZ = new JTextField("", 5);
    private JTextField outputX = new JTextField("", 5);
    private JTextField outputY = new JTextField("", 5);
    private JTextField outputZ = new JTextField("", 5);


    private JLabel sphereA = new JLabel("InputForm.Sphere A:");
    private JLabel sphereB = new JLabel("InputForm.Sphere B:");
    private JLabel radiusA = new JLabel("r = ");
    private JLabel radiusB = new JLabel("r = ");

    private JLabel coordXA = new JLabel("x = ");
    private JLabel coordYA = new JLabel("y = ");
    private JLabel coordZA = new JLabel("z = ");

    private JLabel coordXB = new JLabel("x = ");
    private JLabel coordYB = new JLabel("y = ");
    private JLabel coordZB = new JLabel("z = ");

    private JLabel coordXRes = new JLabel("x = ");
    private JLabel coordYRes = new JLabel("y = ");
    private JLabel coordZRes = new JLabel("z = ");

    private JLabel output = new JLabel("Result: ");
    private JLabel angleX = new JLabel("angle alpha ");
    private JLabel angleY = new JLabel("angle beta ");
    private JLabel angleZ = new JLabel("angle gamma ");

    private JLabel label = new JLabel("Input:");

    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select that");
    private JCheckBox check = new JCheckBox("Check", false);
    //</editor-fold>

    public Interface() {
        super("TPF");
        this.setBounds(100, 100, 300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Container container = this.getContentPane();
        container.setBackground(Color.LIGHT_GRAY);
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(sphereA, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 3;
        gbc.gridy = 0;
        container.add(sphereB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        //gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(coordXA, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        container.add(inputXA, gbc);

        gbc.insets = new Insets(0, 10, 10, 0);
        gbc.gridx = 2;
        gbc.gridy = 1;
        container.add(coordXB, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 3;
        gbc.gridy = 1;
        container.add(inputXB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        container.add(coordYA, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        container.add(inputYA, gbc);

        gbc.insets = new Insets(0, 10, 10, 0);
        gbc.gridx = 2;
        gbc.gridy = 2;
        container.add(coordYB, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 3;
        gbc.gridy = 2;
        container.add(inputYB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        container.add(coordZA, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        container.add(inputZA, gbc);

        gbc.insets = new Insets(0, 10, 10, 0);
        gbc.gridx = 2;
        gbc.gridy = 3;
        container.add(coordZB, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 3;
        gbc.gridy = 3;
        container.add(inputZB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        container.add(radiusA, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        container.add(inputRA, gbc);

        gbc.insets = new Insets(0, 10, 10, 0);
        gbc.gridx = 2;
        gbc.gridy = 4;
        container.add(radiusB, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridx = 3;
        gbc.gridy = 4;
        container.add(inputRB, gbc);


        button = new JButton("RUN");
        button.addActionListener(new ButtonEventListener());

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;   //make this component tall
        gbc.weightx = 0.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        container.add(button, gbc);

        gbc.ipady = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 6;
        output.setFont(new Font(null, Font.BOLD, 15));
        container.add(output, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        container.add(coordXRes, gbc);

        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 7;
        container.add(outputX, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 8;
        container.add(coordYRes, gbc);

        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 8;
        container.add(outputY, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 9;
        container.add(coordZRes, gbc);

        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 9;
        container.add(outputZ, gbc);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            ArrayList<ArrayList<Double>> data;
            ArrayList<Double> dotA;
            ArrayList<Double> dotB;

            data = new ArrayList<>();
            dotA = new ArrayList<>();
            dotB = new ArrayList<>();

            //координаты точки A (центр первой окружности)
            dotA.add(Double.parseDouble(inputXA.getText()));
            dotA.add(Double.parseDouble(inputYA.getText()));
            dotA.add(Double.parseDouble(inputZA.getText()));
            dotA.add(Double.parseDouble(inputRA.getText()));

            //координаты точки B (центр второй окружности)
            dotB.add(Double.parseDouble(inputXB.getText()));
            dotB.add(Double.parseDouble(inputYB.getText()));
            dotB.add(Double.parseDouble(inputZB.getText()));
            dotB.add(Double.parseDouble(inputRB.getText()));

            data.add(dotA);
            data.add(dotB);

            ModifiedProblem problem2 = new ModifiedProblem(data);
            problem2.countDot();

            //координаты найденной точки пересечения
            outputX.setText(format(problem2.getResult().get(0)));
            outputY.setText(format(problem2.getResult().get(1)));
            outputZ.setText(format(problem2.getResult().get(2)));

            //угол наклона прямой (направляющей остнастки)
            outputAngleX.setText(format(countAngle(problem2.getResult().get(0), problem2.getResult().get(1))));
            outputAngleY.setText(format(countAngle(problem2.getResult().get(2), problem2.getResult().get(0))));
            outputAngleZ.setText(format(countAngle(problem2.getResult().get(1), problem2.getResult().get(2))));


            //направляющий вектор прямой, которая пересекает окружности.
            System.out.println(problem2.getLineDir());


            MyPoint p1 = new MyPoint(
                    data.get(0).get(0),
                    data.get(0).get(1),
                    data.get(0).get(2)
            );
            MyPoint p2 = new MyPoint(
                    data.get(1).get(0),
                    data.get(1).get(1),
                    data.get(1).get(2)
            );
            MyPoint p3 = new MyPoint(
                    problem2.resDots.get(0).get(0),
                    problem2.resDots.get(0).get(1),
                    problem2.resDots.get(0).get(2)
            );
            MyPoint p4 = new MyPoint(
                    problem2.resDots.get(1).get(0),
                    problem2.resDots.get(1).get(1),
                    problem2.resDots.get(1).get(2)
            );
            spheres = new MySphere[]{
                    new MySphere(
                            p1,
                            data.get(0).get(3)
                    ),
                    new MySphere(
                            p2,
                            data.get(1).get(3)
                    )
            };
            points = new MySphere[]{
                    new MySphere(p3, 5),
                    new MySphere(p4, 5)
            };
            line = new MyLine(p3, p4);
            dataReady = true;

            CommonData.dataReady = dataReady;
            CommonData.line = line;
            CommonData.points = points;
            CommonData.spheres = spheres;
        }

        public double countAngle(double a, double b) {
            return degreeRange(Math.toDegrees(Math.atan(-a / b)));
        }

        private double degreeRange(double x) {
            return (x > 0 ? x : x + 360);
        }

        private String format(double x) {
            return new DecimalFormat(ft).format(x);
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    private JButton button = new JButton("Press");
    private JTextField inputXA = new JTextField("", 5);
    private JTextField inputXB = new JTextField("", 5);
    private JTextField inputYA = new JTextField("", 5);
    private JTextField inputYB = new JTextField("", 5);
    private JTextField inputZA = new JTextField("", 5);
    private JTextField inputZB = new JTextField("", 5);

    private JLabel sphereA = new JLabel("Sphere A:");
    private JLabel sphereB = new JLabel("Sphere B:");
    private JLabel coordXA = new JLabel("x = ");
    private JLabel coordYA = new JLabel("y = ");
    private JLabel coordZA = new JLabel("z = ");

    private JLabel coordXB = new JLabel("x = ");
    private JLabel coordYB = new JLabel("y = ");
    private JLabel coordZB = new JLabel("z = ");
    private JLabel label = new JLabel("Input:");

    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select that");
    private JCheckBox check = new JCheckBox("Check", false);

    public Interface() {
        super("TPF");
        this.setBounds(100,100,250,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setBackground(Color.LIGHT_GRAY);
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0 ,10, 0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(sphereA, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 3;
        gbc.gridy = 0;
        container.add(sphereB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0 ,10, 0);
        //gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(coordXA, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        container.add(inputXA, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        container.add(coordXB, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        container.add(inputXB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0 ,10, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        container.add(coordYA, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        container.add(inputYA, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        container.add(coordYB, gbc);

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

        gbc.gridx = 2;
        gbc.gridy = 3;
        container.add(coordZB, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        container.add(inputZB, gbc);



//
//        ButtonGroup group = new ButtonGroup();
//        group.add(radio1);
//        group.add(radio2);
//        container.add(radio1);
//
//        radio1.setSelected(true);
//        container.add(radio2);
//        container.add(check);

        button = new JButton("RUN");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 40;      //make this component tall
        gbc.weightx = 0.0;
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 4;
        container.add(button, gbc);

//        button.addActionListener(new ButtonEventListener());
//        container.add(button);

    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";
            message += "Text is " + inputXA.getText() + "\n";
            message += (radio1.isSelected()?"Radio #1":"Radio #2")
                    + " is selected\n";
            message += "CheckBox is " + ((check.isSelected())
                    ?"checked":"unchecked");
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}
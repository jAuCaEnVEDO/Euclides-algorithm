package mcd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GUI extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel text = new JPanel();
    private JPanel mcd = new JPanel();
    private ImageIcon imagen = new ImageIcon("C:/Users/Acevedo/Desktop/Games/Material UD/Semestre 2/Teoria de numeros/MCD/src/mcd/back.png");
    private JLabel image = new JLabel();
    private String pross = "";
    private JLabel process = new JLabel("<html><body>" + pross + "</html></body>");
    private JLabel onlyNum = new JLabel("<html><body style=text-align:center;>Type a number (minimum 4) </body></html>");
    private String dispNum = "MCD";
    private JLabel numbers = new JLabel("<html><body>" + dispNum + "</html></body>");
    private JTextField number = new JTextField();
    private MyButton add = new MyButton("<html><body style=vertical-align:top; >Add Number</html></body>");
    private MyButton reset = new MyButton("<html><body style=vertical-align:top; >Reset</html></body>");
    private MyButton maxCom = new MyButton("¡Do It!");
    private ArrayList<Integer> array = new ArrayList<>();
    private MaxCom numb = new MaxCom(array);
    private JScrollPane scroll = new JScrollPane(numbers);
    private JScrollPane scrollPros = new JScrollPane(process);

    public GUI() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MCD");
        setSize(new Dimension(900, 500));
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        text.setLayout(null);
        mcd.setLayout(null);
        text.add(number);
        text.add(onlyNum);
        text.add(add);
        text.add(reset);
        panel.setBackground(new Color(255, 255, 255));
        mcd.setBackground(new Color(255, 255, 255));
        panel2.setBackground(new Color(45, 45, 68));
        text.setBackground(new Color(45, 45, 68));
        panel.add(panel2, BorderLayout.WEST);
        panel.add(mcd, BorderLayout.CENTER);
        panel2.add(image, BorderLayout.SOUTH);
        panel2.add(text, BorderLayout.CENTER);
        mcd.add(scroll);
        mcd.add(maxCom);
        mcd.add(scrollPros);
        scrollPros.setBounds(15, 50, 612, 350);
        scroll.setBounds(15, 2, 612, 45);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setBorder(new LineBorder(Color.WHITE));
        scrollPros.getViewport().setBackground(Color.WHITE);
        scrollPros.setBorder(new LineBorder(Color.WHITE));
        labels();
        buttons();
        textFields();
    }

    private void labels() {
        image.setSize(250, 220);
        image.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH)));
        onlyNum.setBounds(15, 20, 220, 60);
        onlyNum.setFont(new Font("corbel", Font.BOLD, 20));
        onlyNum.setHorizontalAlignment(JLabel.CENTER);
        onlyNum.setForeground(Color.white);
        numbers.setBounds(0, 0, 613, 46);
        numbers.setHorizontalAlignment(JLabel.CENTER);
        numbers.setVerticalAlignment(JLabel.TOP);
        numbers.setFont(new Font("Segoe UI", Font.BOLD, 20));
        numbers.setForeground(new Color(51, 225, 237));
        process.setBounds(15, mcd.getHeight() / 4 + 20, mcd.getWidth() - 10, mcd.getHeight() - 10);
        process.setHorizontalAlignment(JLabel.CENTER);
        process.setVerticalAlignment(JLabel.TOP);
        process.setFont(new Font("Segoe UI", Font.BOLD, 20));
        process.setForeground(Color.BLACK);
    }

    private void buttons() {
        add.setBounds(15, 150, 220, 40);
        add.setBackground(new Color(51, 225, 237));
        add.setFont(new Font("corbel", Font.BOLD, 25));
        add.setForeground(Color.white);
        add.setBorder(BorderFactory.createLineBorder(new Color(45, 45, 68)));
        add.setFocusPainted(false);
        add.setHorizontalAlignment(SwingConstants.CENTER);
        reset.setBounds(15, 200, 220, 40);
        reset.setBackground(new Color(51, 225, 237));
        reset.setFont(new Font("corbel", Font.BOLD, 25));
        reset.setForeground(Color.white);
        reset.setBorder(BorderFactory.createLineBorder(new Color(45, 45, 68)));
        reset.setFocusPainted(false);
        reset.setHorizontalAlignment(SwingConstants.CENTER);
        maxCom.setBounds(530, 415, 100, 40);
        maxCom.setBackground(new Color(51, 225, 237));
        maxCom.setFont(new Font("corbel", Font.BOLD, 25));
        maxCom.setForeground(Color.white);
        maxCom.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        maxCom.setFocusPainted(false);
        maxCom.setHorizontalAlignment(SwingConstants.CENTER);
        maxCom.setEnabled(false);
        maxCom.addActionListener((ActionEvent ae) -> {
            pross = numb.mcd();
            process.setText("<html><body style=text-align:center;>" + pross + "</html></body>");
        });
        add.addActionListener((ActionEvent ae) -> {
            if (!"".equals(number.getText())) {
                addNumber();
            }
        });
        reset.addActionListener((ActionEvent ae) -> {
            resetDisp();
        });
    }

    private void textFields() {
        number.setBounds(15, 100, 220, 40);
        number.setBorder(BorderFactory.createLineBorder(Color.white));
        number.setHorizontalAlignment(JTextField.CENTER);
        number.setFont(new Font("corbel", Font.BOLD, 30));
        number.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = number.getText();
                int l = value.length();
                if (ke.getKeyChar() == KeyEvent.VK_ENTER && !"".equals(number.getText())) {
                    addNumber();
                }
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE || ke.getKeyChar() == KeyEvent.VK_SHIFT || ke.getKeyChar() == KeyEvent.VK_ENTER) {
                    number.setEditable(true);
                    onlyNum.setText("<html><body style=text-align:center;>Type a number (minimum 4) </body></html>");
                    onlyNum.setForeground(Color.white);
                } else {
                    number.setEditable(false);
                    onlyNum.setText("<html><body style=text-align:center;>Enter only numeric digits</body></html>");
                    onlyNum.setForeground(Color.red);
                }
            }
        });
    }

    private void addNumber() {
        dispNum = dispNum + " " + number.getText();
        numbers.setText("<html><body>" + dispNum + "</html></body>");
        array.add(Integer.parseInt(number.getText()));
        number.setText("");
        maxCom.setEnabled(true);
    }

    private void resetDisp() {
        dispNum = "MCD";
        numbers.setText("<html><body>" + dispNum + "</html></body>");
        number.setText("");
        process.setText("");
        array.clear();
        maxCom.setEnabled(false);
    }
}

class MyButton extends JButton {

    private Color hoverBackgroundColor = new Color(167, 225, 237);
    private Color pressedBackgroundColor = new Color(0, 184, 237);

    public MyButton() {
        this(null);
    }

    public MyButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}

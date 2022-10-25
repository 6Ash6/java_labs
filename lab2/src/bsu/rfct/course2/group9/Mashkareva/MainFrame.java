package bsu.rfct.course2.group9.Mashkareva;

// Импортируются классы, используемые в приложении
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

@SuppressWarnings("serial")

public class MainFrame extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;

    private  JTextField textFieldX;
    private  JTextField textFieldY;
    private JTextField textFieldZ;

    private  JTextField textFieldResult;
    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioButtons2 = new ButtonGroup();
    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hboxMem = Box.createHorizontalBox();

    private double[] mem = new double[3];
    private int formulaId = 1;
    private int memId = 1;
    public Double calculate1 (Double x, Double y, Double z){
        return Math.sin(Math.sin(y)+ Math.pow(2.718,Math.cos(y)+z*z) )*Math.pow(Math.sin(3.14*y*y)+Math.log(x*x),1/4);
    }

    public Double calculate2 (Double x, Double y, Double z){
        return (Math.pow(x,x))/(Math.sqrt(y*y*y+1)+Math.log(z));
    }

    private void addRadioButton(String buttonName, final int formulaId){
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
                //imagePane.updateUI();
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }

    private void addRadioButtonMem (String buttonName, final int memId){
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.memId = memId;
                //imagePane.updateUI();
            }
        });

        radioButtons2.add(button);
        hboxMem.add(button);
    }

    public MainFrame(){
        super ("Вычисление формулы");
        setSize(WIDTH,HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width-WIDTH)/2, (kit.getScreenSize().height-HEIGHT)/2);

        hboxMem.add(Box.createHorizontalGlue());
        addRadioButtonMem("Переменная 1", 1);
        addRadioButtonMem("Переменная 2", 2);
        addRadioButtonMem("Переменная 3", 3);
        radioButtons2.setSelected(radioButtons2.getElements().nextElement().getModel(), true);
        hboxMem.add(Box.createHorizontalGlue());
        hboxMem.setBorder(BorderFactory.createLineBorder(Color.PINK));

        JButton buttonM = new JButton("M+");
        buttonM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                try{
                    mem[memId-1]+=Double.parseDouble(textFieldResult.getText());
                    textFieldResult.setText(Double.toString(mem[memId-1]));
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(
                            MainFrame.this, "Ошибка в формате записи числа с плавающей точкой",
                            "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonMC = new JButton("MC");
        buttonMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                mem[memId - 1] = 0;
            }
        });
        Box MButtons = Box.createHorizontalBox();
        MButtons.add(Box.createHorizontalGlue());
        MButtons.add(buttonMC);
        MButtons.add(Box.createHorizontalStrut(30));
        MButtons.add(buttonM);
        MButtons.add(Box.createHorizontalGlue());
        MButtons.setBorder(
                BorderFactory.createLineBorder(Color.ORANGE));
        getContentPane().add(MButtons, BorderLayout.NORTH);

        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0",10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());

        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0",10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());

        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0",10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());

        JLabel labelForResult = new JLabel("Результат");
        textFieldResult = new JTextField("0",20);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(20));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                try{
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId==1)
                        result = calculate1(x, y, z);
                    else
                        result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(
                            MainFrame.this, "Ошибка в формате записи числа с плавающей точкой",
                            "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });



        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(
                BorderFactory.createLineBorder(Color.GREEN));
        getContentPane().add(hboxButtons, BorderLayout.SOUTH);
        
        Box contentBox = Box.createVerticalBox();
        contentBox.add(hboxMem);
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }
    

}

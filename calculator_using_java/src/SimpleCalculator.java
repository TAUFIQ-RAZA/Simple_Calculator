import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JButton[] numbers= new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton add,sub,mul,div,dot,equal,clear,delete;
    JPanel panel;

    Font myFont= new Font("Times New Roman",Font.BOLD,24);

    double num1=0,num2=0,result=0;
    char operator;

    public SimpleCalculator(){

        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLocation(1200,200);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        textField= new JTextField();
        textField.setBounds(50,25,300,45);
        textField.setFont(myFont);
        textField.setEditable(false);

        add= new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        dot=new JButton(".");
        equal=new JButton("=");
        clear=new JButton("Clear");
        delete=new JButton("Delete");

        functionButton[0]= add;
        functionButton[1]= sub;
        functionButton[2]= mul;
        functionButton[3]= div;
        functionButton[4]= dot;
        functionButton[5]= equal;
        functionButton[6]= clear;
        functionButton[7]= delete;

        for (int i=0;i<8; i++){
            functionButton[i] .addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setBackground(Color.white);
            functionButton[i].setFocusable(false);
        }

        for (int i=0;i<10; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setBackground(Color.white);
            numbers[i].setFocusable(false);
        }

        delete.setBounds(50,430,135,40);
        delete.setBackground(Color.gray);
        delete.setForeground(Color.black);

        clear.setBounds(205,430,135,40);
        clear.setBackground(Color.gray);
        clear.setForeground(Color.black);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.setBackground(Color.black);

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(sub);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mul);
        panel.add(dot);
        panel.add(numbers[0]);
        panel.add(equal);
        panel.add(div);

        frame.add(panel);
        frame.add(delete);
        frame.add(clear);
        frame.add(textField);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        for (int i=0 ; i<10; i++){
            if (ae.getSource() == numbers[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(ae.getSource()== dot){
            textField.setText(textField.getText().concat(String.valueOf(".")));
        }

        if (ae.getSource()== add){
            num1=Double.parseDouble(textField.getText());
            operator ='+';
            textField.setText("");
        }

        if (ae.getSource()== sub){
            num1=Double.parseDouble(textField.getText());
            operator ='-';
            textField.setText("");
        }

        if (ae.getSource()== mul){
            num1=Double.parseDouble(textField.getText());
            operator ='*';
            textField.setText("");
        }

        if (ae.getSource()== div){
            num1=Double.parseDouble(textField.getText());
            operator ='/';
            textField.setText("");
        }


        if (ae.getSource()== equal){
            num2=Double.parseDouble(textField.getText());

            switch (operator){
                case '+': result=num1+num2; break;
                case '-': result=num1-num2; break;
                case '*': result=num1*num2; break;
                case '/': result=num1/num2; break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }

        if (ae.getSource()==clear){
            textField.setText("");
        }

        if (ae.getSource()==delete){
            String st= textField.getText();
            textField.setText("");
            for (int i=0; i<st.length()-1 ; i++){
                textField.setText(textField.getText()+st.charAt(i));
            }
        }


    }


    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
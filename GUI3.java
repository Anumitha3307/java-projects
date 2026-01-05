package SWINGS;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class GUI3 {
    public static void main(String[] args) {
        Registration r = new Registration();
    }
}
class Registration extends JFrame{
    JTextField Name;
    JTextField Email;
    JPasswordField Password;
    JButton b;
    JLabel name;
    JLabel password,email;

    public Registration(){
        Name = new JTextField(15);
        Email = new JTextField(15);
        Password = new JPasswordField(15);
        b = new JButton("Submit");
        name = new JLabel("enter your name");
        email = new JLabel("enter yor email");
        password = new JLabel("enter password");

        setVisible(true);
        setSize(100, 100);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        add(name);
        add(Name);
        add(email);
        add(Email);
        add(password);
        add(Password);
        add(b);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                String RegName = Name.getText();
                String RegEmail = Email.getText();
                String RegPassword = new String(Password.getPassword());

                if(RegName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter the name","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(!RegEmail.contains("@")||!RegEmail.contains(".com")){
                    JOptionPane.showMessageDialog(null, "enter valid email","Error",JOptionPane.WARNING_MESSAGE);
                }
                else if(RegPassword.length()<6){
                    JOptionPane.showMessageDialog(null, "enter valid password","Error",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "registration completed","Succesfull",JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });

    }
}

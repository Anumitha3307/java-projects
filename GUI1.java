package SWINGS;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI1{
    public static void main(String args[]){

        Library ob = new Library();
    }
}

class Library extends JFrame{
    JTextField Name,Id,Title,Issue;
    JButton b;
    JOptionPane op;
    JLabel name,id,title,issue;

    public Library(){
        Name = new JTextField(20);
        Id = new JTextField(20);
        Title = new JTextField(20);
        Issue = new JTextField(20);
        b = new JButton("SUBMIT");
        name = new JLabel("Enter your Name");
        id = new JLabel("enter your id");
        title = new JLabel("Enter book title");
        issue = new JLabel("Issue date");

        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(name);
        add(Name);
        add(id);
        add(Id);
        add(title);
        add(Title);
        add(issue);
        add(Issue);
        add(b);
        
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String StudentName = Name.getText();
                String StudentId = Id.getText();
                String BookTitle = Title.getText();
                String Date = Issue.getText();

                if(StudentName.isEmpty()||StudentId.isEmpty()||BookTitle.isEmpty()||Date.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill all the details","Error",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    String msg = StudentName+" ,"+StudentId+" ,"+BookTitle+" ,"+Date;
                    JOptionPane.showMessageDialog(null,"Book issued"+"\n"+msg,"confirmation",JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
        

    }
}
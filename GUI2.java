package SWINGS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI2 {
    public static void main(String[] args) {
        Feedback fb = new Feedback();
    }

    
}
class Feedback extends JFrame{
    JTextField Name,Course;
    JRadioButton excbtn,goodbtn,avgbtn,poorbtn;
    JTextArea Comments;
    JButton a,clear;
    JOptionPane op;
    JLabel name,course,comment;
    ButtonGroup bg;

    public Feedback(){
        Name = new JTextField(20);
        Course = new JTextField(20);
        Comments = new JTextArea(35,35);
        a = new JButton("Submit");
        name = new JLabel("Enter your name");
        course = new JLabel("Enter your course");
        comment = new JLabel("Enter any comments");
        excbtn = new JRadioButton("Excellent");
        goodbtn = new JRadioButton("Good");
        avgbtn = new JRadioButton("Average");
        poorbtn = new JRadioButton("Poor");
        bg = new ButtonGroup();
        clear = new JButton("Clear");

        
        setVisible(true);
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(name);
        add(Name);
        add(course);
        add(Course);
        add(comment);
        add(Comments);
        bg.add(excbtn);
        bg.add(goodbtn);
        bg.add(avgbtn);
        bg.add(poorbtn);
        add(excbtn);
        add(goodbtn);
        add(avgbtn);
        add(poorbtn);

        add(a);
        add(clear);

        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String StudentName = Name.getText();
                String CourseName = Course.getText();
                String ExtraComments = Comments.getText();
                String experience = null;

                if(excbtn.isSelected()) experience = "excellent";
                else if(goodbtn.isSelected()) experience = "good";
                else if(avgbtn.isSelected()) experience = "average";
                else if(poorbtn.isSelected()) experience = "poor";
                
                

                if(StudentName.isEmpty()||CourseName.isEmpty()||ExtraComments.isEmpty()||experience==null){
                    JOptionPane.showMessageDialog(null,"enter all details","Error",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, " succesfull ","feedback submitted",JOptionPane.INFORMATION_MESSAGE);
                    

                }

            }
            
        });

        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                Name.setText(" ");
                Course.setText(" ");
                Comments.setText(" ");
                bg.clearSelection();

            }
        });

        


    }
}

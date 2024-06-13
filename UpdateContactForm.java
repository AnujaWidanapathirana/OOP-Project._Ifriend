import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateContactForm extends JFrame {
    private JLabel titleLabel;

    private JButton btnUpdateName;
    private JButton btnUpdateSalary;
    private JButton btnUpdatePhoneNumber;
    private JButton cancel;
    
    UpdateContactbyName updateContactbyName;
    UpdateContactbySalary updateContactbySalary;
    UpdateContactbyPhoneNumber updateContactbyPhoneNumber;

    public UpdateContactForm() {
        makingUI();
        setListeners();
    }

    private void makingUI() {
        setSize(600,400);
        setTitle("Contact Organizer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        titleLabel=new JLabel("<Update Contact>");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(Color.GRAY);
        titleLabel.setOpaque(true);
        add("North", titleLabel);
		
		JPanel leftPanel=new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(300,getHeight()));
        leftPanel.setBackground(Color.LIGHT_GRAY);
			
			JLabel image=new JLabel();
			image.setIcon(new ImageIcon("D:/Icet/Contact Organizer/image1.jpeg"));
			image.setHorizontalAlignment(JLabel.CENTER);
			image.setVerticalAlignment(JLabel.BOTTOM);
			image.setOpaque(true);
			image.setBackground(Color.LIGHT_GRAY);
			leftPanel.add(image,BorderLayout.SOUTH);
			
			JTextArea textArea=new JTextArea("IFRIEND_UPDATE");
			textArea.setFont(new Font("",2, 30));
			textArea.setBackground(Color.LIGHT_GRAY);
			textArea.setForeground(Color.BLACK);
			textArea.setEditable(false);
			leftPanel.add(textArea, BorderLayout.CENTER);
			add(leftPanel, BorderLayout.WEST);
       
		JPanel rightPanel=new JPanel(new GridLayout(3,1,30,30));
  
			
			btnUpdateName=new JButton("Update Name");
			btnUpdateName.setFont(new Font("",1,25));
			rightPanel.add(btnUpdateName);

			btnUpdateSalary=new JButton("Update Salary");
			btnUpdateSalary.setFont(new Font("",1,25));
		   
			rightPanel.add(btnUpdateSalary);

			btnUpdatePhoneNumber=new JButton("Update Phone Number");
			btnUpdatePhoneNumber.setFont(new Font("",1,25));
			rightPanel.add(btnUpdatePhoneNumber);

        add(rightPanel,BorderLayout.CENTER);
        JPanel numberPanel=new JPanel(new GridLayout(3,1,3,3));

   
        JPanel lower=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        cancel=new JButton("Cancel");
        cancel.setFont(new Font("",1,18));
        cancel.setBackground(Color.LIGHT_GRAY);
        lower.add(cancel);
        add("South",lower);
    }
    private void setListeners(){
        btnUpdateName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
               updateContactbyName=new UpdateContactbyName();
               updateContactbyName.setVisible(true);
            }
        });
		cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                UpdateContactForm.this.dispose();
            }
        });
        btnUpdateSalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                updateContactbySalary=new UpdateContactbySalary();
				updateContactbySalary.setVisible(true);
            }
        });

        btnUpdatePhoneNumber.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                updateContactbyPhoneNumber=new UpdateContactbyPhoneNumber();
				updateContactbyPhoneNumber.setVisible(true);
            }
        });
    }
}

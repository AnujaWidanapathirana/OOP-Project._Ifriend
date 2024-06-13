import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewContactForm extends JFrame {
    private JLabel Listcon;
    private JButton listbyName;
    private JButton listbySalary;
    private JButton listbyBirthday;
    private JButton cancel;

	ListbyName listbyN;
	ListbySalary listbyS;
	ListbyBirthday listbyB;
	
    public ViewContactForm() {
        makeUI();
        setListeners();
    }
    private void makeUI(){
        setSize(600,400);
        setTitle("List Contacts");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Listcon=new JLabel("<List Contacts>");
        Listcon.setFont(new Font("",1,35));
        Listcon.setHorizontalAlignment(JLabel.CENTER);
        Listcon.setBackground(Color.GRAY);
        Listcon.setOpaque(true);
        add("North",Listcon);
		
		JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(300,getHeight()));
        leftPanel.setBackground(Color.LIGHT_GRAY);
		
				JLabel image=new JLabel();
				image.setIcon(new ImageIcon("D:/Icet/Contact Organizer/image1.jpeg"));
				image.setHorizontalAlignment(JLabel.CENTER);
				image.setVerticalAlignment(JLabel.BOTTOM);
				image.setOpaque(true);
				image.setBackground(Color.LIGHT_GRAY);
				leftPanel.add(image,BorderLayout.SOUTH);
				
				JTextArea textArea=new JTextArea("IFRIEND_SORT");
				textArea.setFont(new Font("",2,30));
				textArea.setBackground(Color.LIGHT_GRAY);
				textArea.setForeground(Color.BLACK);
				textArea.setEditable(false);
				leftPanel.add(textArea,BorderLayout.NORTH);

        add(leftPanel,BorderLayout.WEST);
        JPanel rightPanel=new JPanel(new GridLayout(3,1,27,27));

			listbyName=new JButton("List by Name");
			listbyName.setFont(new Font("",1,25));
			rightPanel.add(listbyName);

			listbySalary=new JButton("List by Salary");
			listbySalary.setFont(new Font("",1,25));
			rightPanel.add(listbySalary);

			listbyBirthday=new JButton("List by Birthday");
			listbyBirthday.setFont(new Font("",1,25));
			rightPanel.add(listbyBirthday);

        add(rightPanel,BorderLayout.CENTER);
        
        JPanel lower=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        cancel=new JButton("Cancel");
        cancel.setFont(new Font("",1,18));
        cancel.setBackground(Color.LIGHT_GRAY);
        lower.add(cancel);
        add("South",lower);
    }

    private void setListeners(){
        listbyName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                listbyN=new ListbyName();
                listbyN.setVisible(true);
            }
        });
		cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                ViewContactForm.this.dispose();
            }
        });
        listbySalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                listbyS=new ListbySalary();
                listbyS.setVisible(true);
            }
        });

        listbyBirthday.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                listbyB=new ListbyBirthday();
                listbyB.setVisible(true);
            }
        });
    }
}

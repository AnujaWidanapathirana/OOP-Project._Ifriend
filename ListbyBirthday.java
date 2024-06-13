
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;


public class ListbyBirthday extends JFrame{
	private JLabel titleLabel;
	private JTable details;
	private DefaultTableModel defaulttable;
	
	private JButton close;

	ListbyBirthday(){
		makeUI();
		setListeners();

		}
	private void makeUI(){
		setSize(900,550);
        setTitle("<List Contacts By Birthday>");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0,0,900,450);
        panel1.setBackground(Color.GRAY);

        String[] columns={"Contact ID","Name","Contact Number","Company Name","Salary","Birthday"};
        defaulttable=new DefaultTableModel(columns,0);
        details=new JTable(defaulttable);

        for (Contact contact : ContactController.birthdaySort()) {
            Object[] arr={contact.getId(),contact.getName(),contact.getPhoneNumber(),contact.getCompanyName(),contact.getSalary(),contact.getBirthday()};
            defaulttable.addRow(arr);
        }

        JScrollPane tablePane=new JScrollPane(details);
        tablePane.setBounds(0, 0, 890, 450);
        panel1.add(tablePane);

        JPanel lower=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        close=new JButton("Close");
        close.setFont(new Font("",1, 18));
        close.setBackground(Color.LIGHT_GRAY);
        lower.add(close);

        add(panel1,BorderLayout.CENTER);
        add(lower,BorderLayout.SOUTH);
		}
		private void setListeners(){
			close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
	}
}
   
		

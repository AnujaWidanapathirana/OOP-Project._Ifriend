import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class AddContactForm extends JFrame{
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btohome;
	
	private JLabel titleLabel;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblphonenumber;
	private JLabel lblcompanyname;
	private JLabel lblSalary;
	private JLabel lblBirthday;
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtphonenumber;
	private JTextField txtcompanyname;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	AddContactForm addContactForm1;
	
	AddContactForm(){
		makeUI();
		setListeners();
	}
	private void makeUI(){
		setSize(500,300);
		setTitle("Add Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		titleLabel=new JLabel("<Add Contact>");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.GRAY);
        titleLabel.setOpaque(true);
		titleLabel.setFont(new Font("",1,30));
		add("North",titleLabel);
		
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdd=new JButton("Add Contact");
		btnAdd.setFont(new Font("",1,20));
		btnAdd.setBackground(Color.LIGHT_GRAY);
		
		buttonPanel.add(btnAdd);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20));
		btnCancel.setBackground(Color.LIGHT_GRAY);
		
		buttonPanel.add(btnCancel);
		
		btohome=new JButton("Back To HomePage");
		btohome.setFont(new Font("",1,20));
		btohome.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(btohome);
		
		add("South",buttonPanel);
		JPanel labelPanel=new JPanel(new GridLayout(6,1));
		
		lblId=new JLabel("Contact Id");
		lblId.setFont(new Font("",1,15));
		labelPanel.add(lblId);	
		
		lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20));
		labelPanel.add(lblName);
		
		lblphonenumber=new JLabel("Phone_Number");
		lblphonenumber.setFont(new Font("",1,20));
		labelPanel.add(lblphonenumber);
		
		
		lblcompanyname=new JLabel("Company_Name");
		lblcompanyname.setFont(new Font("",1,20));
		labelPanel.add(lblcompanyname);
		
		lblSalary=new JLabel("Salary");
		lblSalary.setFont(new Font("",1,20));
		labelPanel.add(lblSalary);
		
		lblBirthday=new JLabel("Birthday");
		lblBirthday.setFont(new Font("",1,20));
		labelPanel.add(lblBirthday);
		
		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(6,1));
		
		txtId=new JTextField(ContactController.generateId());
		txtId.setFont(new Font("",1,15));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		txtId.setEditable(false);
		
		txtName=new JTextField(20);
		txtName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtphonenumber=new JTextField(20);
		txtphonenumber.setFont(new Font("",1,20));
		JPanel phonenumberTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		phonenumberTextPanel.add(txtphonenumber);

		textPanel.add(phonenumberTextPanel);
		
		txtcompanyname=new JTextField(20);
		txtcompanyname.setFont(new Font("",1,20));
		JPanel companynameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		companynameTextPanel.add(txtcompanyname);
		textPanel.add(companynameTextPanel);
		
		txtSalary=new JTextField(20);
		txtSalary.setFont(new Font("",1,20));
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		salaryTextPanel.add(txtSalary);

		textPanel.add(salaryTextPanel);
		
		txtBirthday=new JTextField(20);
		txtBirthday.setFont(new Font("",1,20));
		JPanel BirthdayTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		BirthdayTextPanel.add(txtBirthday);
		textPanel.add(BirthdayTextPanel);
		add("Center",textPanel);
		}
	private void setListeners(){
		btnCancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
				txtName.setText("");
				txtphonenumber.setText("");
				txtcompanyname.setText("");
				txtSalary.setText("");
				txtBirthday.setText("");
				txtName.requestFocus();
			}
		});
		btohome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AddContactForm.this.dispose();
			}
		});
		
		btnAdd.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
				String id=ContactController.generateId();
				String name=txtName.getText();
				String birthday=null;
				String phoneNumber=null;
				String companyName=txtcompanyname.getText();
				double salary=0.0;
				Boolean bool1,bool2,bool3;
				salary=Double.parseDouble(txtSalary.getText());
				birthday=txtBirthday.getText();
				phoneNumber=txtphonenumber.getText();
				if(!ContactController.isValidSalary(salary)){
					checkSalary();
				}
				if(!ContactController.isValidPhoneNumber(phoneNumber)){
					checkphone();
				}
				if(!ContactController.isValidBirthday(birthday)){
					checkBirthday();
					}
				
				bool1=ContactController.isValidSalary(salary);
				bool2=ContactController.isValidPhoneNumber(phoneNumber);
				bool3=ContactController.isValidBirthday(birthday);
				
				if(bool1 && bool2 && bool3){
				ArrayList<Contact> contactList=ContactDBConnection.getInstance().getContactList();
				Contact contact=new Contact(id,name,phoneNumber,companyName,birthday,salary);
				int y=contactList.size();
				contactList.add(contact);
				if(contactList.size()==++y){
					int option=JOptionPane.showConfirmDialog(null,"Contact has been Added...Do you want to add another Contact?");
						if(option==JOptionPane.YES_OPTION){
							txtId.setText(ContactController.generateId());
							txtName.setText("");
							txtphonenumber.setText("");
							txtcompanyname.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							txtName.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							AddContactForm.this.dispose();
						}
					}	
				}
			}
		});	
	}
		private void checkSalary(){	
				int option=JOptionPane.showConfirmDialog(null,"Invalid Salary...Do you want to input the salary again?");
				if(option==JOptionPane.YES_OPTION){
					txtSalary.setText("");
					txtSalary.requestFocus();
				}else if(option==JOptionPane.NO_OPTION){
					txtName.setText("");
					txtphonenumber.setText("");
					txtcompanyname.setText("");
					txtSalary.setText("");
					txtBirthday.setText("");
					dispose();
				}	
			}
		private void checkphone(){
					int option=JOptionPane.showConfirmDialog(null,"Invalid phone Number...Do you want to input the number again?");
					if(option==JOptionPane.YES_OPTION){
						txtphonenumber.setText("");
						txtphonenumber.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						txtName.setText("");
						txtphonenumber.setText("");
						txtcompanyname.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
				}
			}
		private void checkBirthday(){
					int option=JOptionPane.showConfirmDialog(null,"Invalid date...Do you want to input the date again?");
					if(option==JOptionPane.YES_OPTION){
						txtBirthday.setText("");
						txtBirthday.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						txtName.setText("");
						txtphonenumber.setText("");
						txtcompanyname.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
							}
					}
	}
	
	
	

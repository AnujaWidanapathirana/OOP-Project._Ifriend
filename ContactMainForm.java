import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class ContactMainForm extends JFrame{
	public static final ArrayList<Contact>contactlist=new ArrayList<>();
	private JButton btnAddContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnUpdateContact;
	private JButton btnViewContact;
	private JButton btnExit;
	
	
	private AddContactForm addContactForm;
	private ViewContactForm viewContactForm;
	private DeleteContactForm deleteContactForm;
	private SearchContactForm searchContactForm;
	private UpdateContactForm updateContactForm;
	
	ContactMainForm(){
		makeUI();
		setListners();
	}
	private void makeUI(){
		setSize(600,400);
		setTitle("Contact Organizer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel titleLabel=new JLabel("<Contact Organizer>");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.GRAY);
        titleLabel.setOpaque(true);
		add("North",titleLabel);
		
		JPanel leftPanel=new JPanel();
		leftPanel.setPreferredSize(new Dimension(300,getHeight()));
        leftPanel.setBackground(Color.LIGHT_GRAY);
		
			JLabel image=new JLabel();
			image.setIcon(new ImageIcon("D:/Icet/Contact Organizer/image1.jpeg"));
			image.setHorizontalAlignment(JLabel.CENTER);
			image.setVerticalAlignment(JLabel.BOTTOM);
			image.setOpaque(true);
			image.setBackground(Color.LIGHT_GRAY);
			leftPanel.add(image,BorderLayout.SOUTH);
			
			JTextArea textArea=new JTextArea("      IFRIEND");
			textArea.setFont(new Font("",1, 30));
			textArea.setBackground(Color.LIGHT_GRAY);
			textArea.setForeground(Color.BLACK);
			textArea.setEditable(false);
			leftPanel.add(textArea,BorderLayout.NORTH);
			add(leftPanel,BorderLayout.WEST);
       
       JPanel rightPanel=new JPanel();
			JPanel buttonPanel=new JPanel(new GridLayout(6,1,25,25));
				btnAddContact=new JButton("Add Contact");
				btnAddContact.setFont(new Font("",1,20));
				buttonPanel.add(btnAddContact);
			
				btnSearchContact=new JButton("Search Contact");
				btnSearchContact.setFont(new Font("",1,20));
				buttonPanel.add(btnSearchContact);
				
				btnUpdateContact=new JButton("Update Contact");
				btnUpdateContact.setFont(new Font("",1,20));
				buttonPanel.add(btnUpdateContact);
				
				btnDeleteContact=new JButton("Delete Contact");
				btnDeleteContact.setFont(new Font("",1,20));
				buttonPanel.add(btnDeleteContact);
				
				btnViewContact=new JButton("View Contact");
				btnViewContact.setFont(new Font("",1,20));
				buttonPanel.add(btnViewContact);
			rightPanel.add(buttonPanel,BorderLayout.CENTER);
			
		add(rightPanel,BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(rightPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(Color.LIGHT_GRAY);
        add(scrollPane, BorderLayout.CENTER);
		JPanel lastPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,20));	
		btnExit.setBackground(Color.GRAY);
		lastPanel.add(btnExit);
		add("South",lastPanel);
		
		  
		}
	private void setListners(){
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				addContactForm=new AddContactForm();
				addContactForm.setVisible(true);
				}
			});
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
				updateContactForm=new UpdateContactForm();
				updateContactForm.setVisible(true);
				}
			});
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
				}
			});
		btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				viewContactForm=new ViewContactForm();
				viewContactForm.setVisible(true);
				}
			});
		btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					deleteContactForm=new DeleteContactForm();
					deleteContactForm.setVisible(true);
				}
			});	
		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				searchContactForm=new SearchContactForm();
				searchContactForm.setVisible(true);
				}
			});
		
		}
	
}	


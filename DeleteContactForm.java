import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteContactForm extends JFrame {
    private int index;
    private JLabel titleLabel;
    private JLabel txtId;
    private JLabel txtName;
    private JLabel txtPhoneNumber;
    private JLabel txtCompanyname;
    private JLabel txtSalary;
    private JLabel txtBirthday;
    
    private JButton btnSearch;
    private JButton cancel;
    private JButton delete;

	JPanel contactPanel;
    JPanel namPanel;
    JPanel phonePanel;
    JPanel companyPanel;
    JPanel salaryPanel;
    JPanel birthdayPanel;

    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblPhoneNumber;
    private JLabel lblCompanyname;
    private JLabel lblSalary;
    private JLabel lblBirthday;
    
    private JTextField txtSearch;

	DeleteContactForm deleteContactForm;

    public DeleteContactForm() {
        makingUI();
        setupListeners();
        String str=ContactController.getSearch();
        if (str!=null && !str.trim().isEmpty()){
            displaySearch(str);
        }
    }

    private void  makingUI(){
        setSize(600,400);
        setTitle("Contact Organizer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        titleLabel=new JLabel("<Delete Contacts>");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(Color.GRAY);
        titleLabel.setOpaque(true);
        add("North",titleLabel);

        JPanel labelPanel=new JPanel(new GridLayout(7, 1));
        JPanel searchBar=new JPanel(new FlowLayout());

        txtSearch=new JTextField(10);
        txtSearch.setFont(new Font("",Font.PLAIN,20));
        JPanel searchTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchTextPanel.add(txtSearch);
        searchBar.add(searchTextPanel);

        btnSearch=new JButton("Search");
        btnSearch.setFont(new Font("",Font.PLAIN,20));
        btnSearch.setBackground(Color.LIGHT_GRAY);
		searchBar.add(btnSearch);
        labelPanel.add(searchBar);

        contactPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				
				lblId=new JLabel("      Contact Id              -");
				lblId.setFont(new Font("",Font.PLAIN,20));
			contactPanel.add(lblId);
		labelPanel.add(contactPanel);
		
			namPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		
				lblName=new JLabel("      Name                     -");
				lblName.setFont(new Font("",Font.PLAIN,20));
			namPanel.add(lblName);
		labelPanel.add(namPanel);

			phonePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));

				lblPhoneNumber=new JLabel("      Phone Number       -");
				lblPhoneNumber.setFont(new Font("",Font.PLAIN,20));
			phonePanel.add(lblPhoneNumber);
		labelPanel.add(phonePanel);

			companyPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
 
				lblCompanyname=new JLabel("      Company Name     -");
				lblCompanyname.setFont(new Font("",Font.PLAIN,20));
				companyPanel.add(lblCompanyname);
		labelPanel.add(companyPanel);

			salaryPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));

				lblSalary=new JLabel("      Salary                     -");
				lblSalary.setFont(new Font("",Font.PLAIN,20));
			salaryPanel.add(lblSalary);
		labelPanel.add(salaryPanel);
			
			birthdayPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));	

				lblBirthday=new JLabel("      Birthday                  -");
				lblBirthday.setFont(new Font("",Font.PLAIN,20));
			birthdayPanel.add(lblBirthday);
		labelPanel.add(birthdayPanel);
	
		
        add("West",labelPanel);

        JPanel lower=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
		delete=new JButton("Delete");
        delete.setFont(new Font("",1,18));
        delete.setBackground(Color.LIGHT_GRAY);
        lower.add(delete);
        
        cancel=new JButton("Cancel");
        cancel.setFont(new Font("",1,18));
        cancel.setBackground(Color.LIGHT_GRAY);
        lower.add(cancel);
        add("South",lower);
    }

    private void setupListeners(){
        btnSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                searchMec();
            }
        });

        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
				normalize();
                DeleteContactForm.this.dispose();
            }
        });
		delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
				ContactController.deleteContact(index);
				normalize();
				popup();
				}
			});
    }
    private void normalize(){
		lblId.setText("      Contact Id              - " );
		lblName.setText("      Name                     - " );
		lblPhoneNumber.setText("      Phone Number       - " );
		lblCompanyname.setText("      Company Name     - " );
		lblSalary.setText("      Salary                     - ");
		lblBirthday.setText("      Birthday                  - ");
		}
	private void popup(){
			int option=JOptionPane.showConfirmDialog(null,"Contact deleted Successfully..Do you want to delete another contact?");
            if(option==JOptionPane.YES_OPTION) {
                    txtSearch.setText("");
                    txtSearch.requestFocus();
            }else if(option==JOptionPane.NO_OPTION) {
                    txtSearch.setText("");
                    DeleteContactForm.this.dispose();
                }
	}	
   private void searchMec(){
        String str=txtSearch.getText();
        if (str==null || str.trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Search text cannot be empty.");
            txtSearch.requestFocus();
            return;
        }
        index=ContactController.getindex(str);
        if(index!=-1){
            displaySearch(str);
        }else{
            int option=JOptionPane.showConfirmDialog(null,"Contact does not exist. Do you want to search again?");
            if (option==JOptionPane.YES_OPTION){
                txtSearch.setText("");
                txtSearch.requestFocus();
            } else if (option==JOptionPane.NO_OPTION){
                txtSearch.setText("");
                dispose();
            }
        }
    }
    private void displaySearch(String str){
        Contact temp=ContactController.getContact(index);
        if(temp!=null){
            lblId.setText("      Contact Id              - " + temp.getId());
            lblName.setText("      Name                     - " + temp.getName());
            lblPhoneNumber.setText("      Phone Number       - " + temp.getPhoneNumber());
            lblCompanyname.setText("      Company Name     - " + temp.getCompanyName());
            lblSalary.setText("      Salary                     - " + temp.getSalary());
            lblBirthday.setText("      Birthday                  - " + temp.getBirthday());
        }
    }
}




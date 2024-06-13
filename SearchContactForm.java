import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchContactForm extends JFrame {
    private JLabel titleLabel;
    private JButton btnSearch;
    private JButton cancel;
    
    JPanel contactPanel;
    JPanel namPanel;
    JPanel phonePanel;
    JPanel companyPanel;
    JPanel salaryPanel;
    JPanel birthdayPanel;

    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblPhoneNumber;
    private JLabel lblCompanyName;
    private JLabel lblSalary;
    private JLabel lblBirthday;
    private JLabel New;

    private JTextField txtSearch;

    private SearchContactForm searchContactForm;

    public SearchContactForm() {
        makingUI();
        setupListener();
        String str = ContactController.getSearch();
        if (str != null && !str.trim().isEmpty()) {
            displaySearch(str);
        }
    }

    private void  makingUI(){
        setSize(600,400);
        setTitle("Contact Organizer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        titleLabel=new JLabel("<Search Contact>");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(Color.GRAY);
        titleLabel.setOpaque(true);
        add("North",titleLabel);

        JPanel labelPanel=new JPanel(new GridLayout(7, 1));
			JPanel searchBar=new JPanel(new FlowLayout());

				txtSearch=new JTextField(20);
				txtSearch.setFont(new Font("",Font.PLAIN,20));
				JPanel searchTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
				searchTextPanel.add(txtSearch);
				searchBar.add(searchTextPanel);

					
				btnSearch=new JButton("Search");
				btnSearch.setFont(new Font("",Font.PLAIN,20));
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
 
				lblCompanyName=new JLabel("      Company Name     -");
				lblCompanyName.setFont(new Font("",Font.PLAIN,20));
				companyPanel.add(lblCompanyName);
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
        cancel=new JButton("Cancel");
        cancel.setFont(new Font("",1,18));
        cancel.setBackground(Color.LIGHT_GRAY);
        lower.add(cancel);
        add("South",lower);
    }

    private void setupListener(){
        btnSearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                searchMec();
            }
        });

        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                SearchContactForm.this.dispose();
            }
        });
    }

    private void searchMec() {
        String str = txtSearch.getText();
        if (str == null || str.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Search text cannot be empty.");
            txtSearch.requestFocus();
            return;
			}
        
            int index=ContactController.getindex(str);
            if(index!=-1){
                ContactController.storeSearch(str);
                SearchContactForm.this.dispose();
                searchContactForm=new SearchContactForm();
                searchContactForm.setVisible(true);
            }else{
                int option = JOptionPane.showConfirmDialog(null, "Contact does not exist... Do you want to search again?");
                if (option == JOptionPane.YES_OPTION) {
                    txtSearch.setText("");
                    txtSearch.requestFocus();
                } else if (option == JOptionPane.NO_OPTION) {
                    txtSearch.setText("");
                    dispose();
                }
            }
    }

    private void displaySearch(String str) {
        int index=ContactController.getindex(str);
        if (index!=-1){
            Contact temp=ContactController.getContact(index);


            JLabel txtId=new JLabel(temp.getId());
            txtId.setFont(new Font("",1, 20));
            JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
            idTextPanel.add(txtId);
            contactPanel.add(idTextPanel);

            JLabel txtName=new JLabel(temp.getName());
            txtName.setFont(new Font("",1, 20));
            JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
            nameTextPanel.add(txtName);
            namPanel.add(nameTextPanel);

            JLabel txtPhoneNumber=new JLabel(temp.getPhoneNumber());
            txtPhoneNumber.setFont(new Font("",1,20));
            JPanel phoneNumberTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
            phoneNumberTextPanel.add(txtPhoneNumber);
            phonePanel.add(phoneNumberTextPanel);

            JLabel txtCompanyName=new JLabel(temp.getCompanyName());
            txtCompanyName.setFont(new Font("",1, 20));
            JPanel companyNameTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            companyNameTextPanel.add(txtCompanyName);
            companyPanel.add(companyNameTextPanel);

            JLabel txtSalary=new JLabel(Double.toString(temp.getSalary()));
            txtSalary.setFont(new Font("",1, 20));
            JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
            salaryTextPanel.add(txtSalary);
            salaryPanel.add(salaryTextPanel);

            JLabel txtBirthday=new JLabel(temp.getBirthday());
            txtBirthday.setFont(new Font("",1,20));
            JPanel birthdayTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
            birthdayTextPanel.add(txtBirthday);
            birthdayPanel.add(birthdayTextPanel);

 
            validate(); 
        }
    }
}


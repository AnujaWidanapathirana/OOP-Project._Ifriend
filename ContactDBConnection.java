import java.util.ArrayList;
class ContactDBConnection{
	private ArrayList<Contact> contactList;
	private static ContactDBConnection contactDBConnection;
	private ContactDBConnection(){
		contactList=new ArrayList<>();
		}
	public static ContactDBConnection getInstance(){
		if(contactDBConnection==null){
			contactDBConnection=new ContactDBConnection();
		} 	
		return contactDBConnection;
	}
	public ArrayList<Contact>getContactList(){
		return contactList;
		}	
}

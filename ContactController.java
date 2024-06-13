import java.util.ArrayList;
import java.util.Comparator;
import java.time.*;
class ContactController{
	private static String ar=null;
	private static int count=0;
	//---------------------ADD CONTACT----------------------------
	public static boolean addContact(Contact contact){
		ArrayList<Contact>contactList=ContactDBConnection.getInstance().getContactList();
		return contactList.add(contact);	
	}
	//----------------DELETE CONTACT-----------------------------
	public static void deleteContact(int index){
		count++;
		ContactDBConnection.getInstance().getContactList().remove(index);
	}
	  //------------------------VALIDATE PHONENUMBER---------------------------
    public static boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
            for(int i=1; i<phoneNumber.length(); i++){
                if(!Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    //-----------------------SORT CONTACT------------------------
    public static  ArrayList<Contact>nameSort(){
		ArrayList<Contact>contactList=ContactDBConnection.getInstance().getContactList();
		contactList.sort(Comparator.comparing(Contact::getName));
		return contactList;
		}
	 public static  ArrayList<Contact>salarySort(){
		ArrayList<Contact>contactList=ContactDBConnection.getInstance().getContactList();
		contactList.sort(Comparator.comparingDouble(Contact::getSalary));
		return contactList;
		}
	 public static  ArrayList<Contact>birthdaySort(){
		ArrayList<Contact>contactList=ContactDBConnection.getInstance().getContactList();
		contactList.sort(Comparator.comparing(Contact::getBirthday));
		return contactList;
		}		
    //-----------------------Update Contacts--------------------------------------
    public static void updateName(String name,int index){
		Contact contact=getContact(index);
		contact.setName(name);
		}
	public static void updatePhonenumber(String phone,int index){
		Contact contact=getContact(index);
		contact.setPhoneNumber(phone);
		}
	public static void updateSalary(double salary,int index){
		Contact contact=getContact(index);
		contact.setSalary(salary);
		}		
	//--------------------------GENERATE ID--------------------------------------------	
     public static String generateId(){
		 ArrayList<Contact>contactList=ContactDBConnection.getInstance().getContactList();
		if(contactList.size()+1==0){
			return "C0001";
		}else{
			int x=contactList.size()+count;
            return String.format("C%04d",x+1);
        }
	}
	//---------------------------GET INDEX----------------------------------------
    public static int getindex(String text){
		ArrayList<Contact>contactList=ContactDBConnection.getInstance().getContactList();
		if (!contactList.isEmpty()) {
            for (int i = 0; i < contactList.size(); i++) {
                Contact contact = contactList.get(i);
                if (text.equalsIgnoreCase(contact.getName()) || text.equalsIgnoreCase(contact.getPhoneNumber())) {
                    return i;
                }
            }
          }
       return -1;
       }   
    //------------------------STORE SEARCH---------------------------------
	public static void storeSearch(String a){
		ar=a;
		}
	//-------------------------GET SEARCH----------------------------------	
	public static String getSearch(){
		return ar;
		}
	//------------------------GET CONTACT OBJECT----------------------------		
	public static Contact getContact(int index){
		ArrayList<Contact>contactList=ContactDBConnection.getInstance().getContactList();
		return contactList.get(index);
	}	
    //-------------------VALIDATE SALARY----------------------
    public static boolean isValidSalary(double salary){
        return salary>0;
    }
    // -------------------BIRTHDAY VALIDATION----------------
	public static boolean isValidBirthday(String birthday){
        String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if((year%400==0 || year%4!=0) & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if((year%400==0 || year%4==0) & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
			}else if(year==currentYear){
									
				if(month>currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
									
					if(day<=currentMonthDate){
						return true;
					}
				}
			}
				return false;
    }
	
}


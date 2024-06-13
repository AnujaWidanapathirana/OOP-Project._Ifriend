class Contact{
	private String id;
	private String name;
	private String phonenumber;
	private String companyname;
	private String birthday;
	private double salary;
	
	public Contact(){}
	public Contact(String id,String name,String phonenumber,String companyname,String birthday,double salary) {
        this.id =id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.companyname = companyname;
        this.birthday =birthday; 
        this.salary = salary;
		}
    public void setId(String data){
				this.id=data;
		}
    public void setName(String data){
				this.name=data;
		}
    public void setPhoneNumber(String data){
				this.phonenumber=data;
		}
    public void setCompanyName(String data){
				this.companyname=data;
		}
    public void setBirthday(String data){
				this.birthday=data;
		}
	public void setSalary(double salary){
				this.salary=salary;
		}	
	public String getId(){
				return this.id;
		}
	public String getName(){
				return this.name;
		}
	public String getPhoneNumber(){
				return this.phonenumber;
		}
	public String getCompanyName(){
				return this.companyname;
		}
	public String getBirthday(){
				return this.birthday;
		}
	public double getSalary(){
		return this.salary;
		}			

}


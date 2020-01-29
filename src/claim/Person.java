package claim;

import java.util.Arrays;
import java.util.Date;

public class Person {
	private String fullName, firstName, middleName="", lastName, email, strTelephone;
	private Address address;
	private PhoneNumber telephoneNum;
	private Date bday, anniversary;
		
	
	
	public Person(){}//OverLoading is in the same class
	public Person(String fn, String ln, PhoneNumber t){
		firstName = fn;
		lastName = ln;
		telephoneNum = t;
	}
	public Person(String fulln, String a, String c, String s, String zc, String t){
		fullName = fulln;
		address = new Address(a, c, s, zc);
		strTelephone = t.replace(" ", "");
		breakUpName(fulln);
		telephoneNum = breakUpTelePhoneNum(t);		
	}
	public Person(String fn, String ln, Address a, PhoneNumber t){
		firstName = fn;
		lastName = ln;
		address = a;
		telephoneNum = t;
	}
	public Person(String fn, String ln, Address a, PhoneNumber t, Date bd, Date anv){
		firstName = fn;
		lastName = ln;
		address = a;
		telephoneNum = t;
		bday = bd;
		anniversary = anv;
	}


	public PhoneNumber breakUpTelePhoneNum(String t) {
		String areaCode, first3Num, last4Num;
		areaCode = t.substring(0, 3);
		first3Num = t.substring(3,6);
		last4Num = t.substring(6, 10);
		
		if(t.length()>10){// incase there is an extension that goes with the phone number
			String extension = t.substring(11);
			telephoneNum =new PhoneNumber(areaCode, first3Num, last4Num, extension);
		}else{
			telephoneNum =new PhoneNumber(areaCode, first3Num, last4Num);
		}
		return telephoneNum;
	}

	public void breakUpName(String fulln) {
		String[] names;
		names = fullName.split(" ");
		
		if(names.length ==2){
			firstName = names[0];
			lastName = names[names.length-1];
		}else if(names.length>2){
			firstName = names[0];
			lastName = names[names.length-1];
			for(int i=0; i<names.length; i++){
				if(i!=0 && i!=names.length-1){//checking for the first and last name then adding the middle name
					middleName += names[i];
					if(i !=names.length-2 ){//if the input has 2 or more middle names they get a space between them
						middleName += " ";
					}
				}	
			}
		}
	}

	public static Person[] addPerson(Person[] source, Person value){
		Person[] temp = new Person[source.length +1];
		for(int i =0; i<source.length; i++){
			temp[i] = source[i];
		}
		temp[source.length] = value;
		
		if(temp.length>1){
			Arrays.sort(temp, new sortArray());
		}
		
		return temp;
	}
	
	public boolean equalsFName(String fn){
		return fn.equals(firstName);
	}
	public boolean equalsLName(String ln){
		return ln.equals(lastName);
	}
	public boolean equalsC(String c){
		//System.out.println(getAddress().getCity()+"<--getAddress().getCity() p-->"+p);
		return c.equalsIgnoreCase(getAddress().getCity());
	}
	public boolean equalsS(String s){
		return s.equals(getAddress().getState());
	}
	public boolean equalsPhoneString(String pNum){
		//System.out.println(strTelephone+"<-strTelephone p->"+p);
		//System.out.println(p.equals(strTelephone));
		return pNum.equals(strTelephone);
	}
//	public boolean equalsPhone(String p){ //this working on this/////////////////////////////////
//		PhoneNumber temp = breakUpTelePhoneNum(p);
//		return temp.equals(telephoneNum);
//	}
	public boolean equals(Person p){
		//System.out.println(p.firstName + " "+firstName);
		//System.out.println(p.firstName == firstName);
		return p.firstName == firstName;
	}
	
	//OverWriting parent class's methods
	public String toString(){//this is to way to **Over Writing** the method from the parent class
		String statement;
		if(middleName.isEmpty()){
			statement = ("Name: "+firstName+" "+lastName+"\nPhone Number: ("+strTelephone.substring(0,3)+") "+
						strTelephone.substring(3,6)+"-"+strTelephone.substring(6)+ "\nAddress: "+address.toString());
		}else{
			statement = ("Name: "+firstName+" "+middleName+" "+lastName+"\nPhone Number: ("+strTelephone.substring(0,3)+") "+
					strTelephone.substring(3,6)+"-"+strTelephone.substring(6)+"\nAddress: "+address.toString());
		}
		return statement;
	}
	//End of the the OverWriting parents class
	
	
	////////////////Setters and Getters/////////////
	
	public String getStrTelephone() {
		return strTelephone;
	}
	public void setStrTelephone(String strT) {
		strTelephone = strT;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fn) {
		firstName = fn;
	}

	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String mn) {
		middleName = mn;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String ln) {
		lastName = ln;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullN) {
		fullName = fullN;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String em) {
		email = em;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address a) {
		address = a;
	}
	
	public Date getBday() {
		return bday;
	}
	public void setBday(Date bd) {
		bday = bd;
	}
	
	public Date getAnniversary() {
		return anniversary;
	}
	public void setAnniversary(Date a) {
		anniversary = a;
	}	
	
	public PhoneNumber getTelephoneNum() {
		return telephoneNum;
	}
	public void setTelephoneNum(PhoneNumber t) {
		telephoneNum = t;
	}

}

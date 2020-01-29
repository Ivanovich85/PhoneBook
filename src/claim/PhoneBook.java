package claim;

import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int userInput;
		PhoneNumber searchPhoneNum;
		String searchName;
		boolean again = true;
		Person[] persons= new Person[0];
		Person[] searchListPersons= new Person[0];
		Person tempPerson=null;	
		
		while(again){
			
			userInput = mainMenu(scanner);
			
			switch(userInput){
				case 1://add a person
					tempPerson = getPersonInfo(scanner);
					persons = Person.addPerson(persons, tempPerson);
					break;
					
				case 2:// delete a person
					persons = removePerson(persons, scanner);
					//delete by phone numbers
					break;
					
				case 3://search Menu
					userInput = searchMenuDisplay(scanner);
					searchListPersons = searchingForAPerson(persons, userInput, scanner);
					System.out.println("Search results: ");
					displayResults(searchListPersons);
					break;
					
				case 4://update a phone number
					persons = updatePhoneNum(persons, scanner);
					break;
					
				case 5://print all people in the array
					System.out.println("People on PhNumoogle:");
					displayResults(persons);
					break;
					
				case 6://exit the program
					System.out.println("Thank you for visiting PhNumoogle");
					again = false;
					break;
					
				default:
					System.out.println("You entered a value that is not on the menu");
					break;
			}
			System.out.println("");

		}		
		scanner.close();
	}

	
	private static void displayResults(Person[] persons) {
		if(persons.length ==0){
			System.out.println("No one found.");
		}else{
			for(int i=0; i<persons.length; i++){
				System.out.println("("+(i+1)+")");
				System.out.println(persons[i].toString());
			}
		}		
	}


	public static Person[] updatePhoneNum(Person[] persons, Scanner scanner) {
		Person[] tempArray = new Person[persons.length];
		Person tempPerson = new Person();
		System.out.println("please enter the phone number you would like to update:");
		String search = scanner.next();
		for(int i=0;i<persons.length; i++){
			tempPerson = persons[i];
			if(tempPerson.equalsPhoneString(search)){
				System.out.println("Phone number found please enter the new phone number:");
				String updatePhone =scanner.next();
				tempPerson.setStrTelephone(updatePhone);
				tempArray[i]= tempPerson;
			}else{
				tempArray[i]=tempPerson;
			}
		}
		return tempArray;
	}


	private static Person[] removePerson(Person[] persons, Scanner scanner) {
		Person[] tempArray = new Person[0];
		Person tempPerson;
		String toSearch;
		System.out.println("Enter the phone number you would like to search for: ");
		toSearch = scanner.next();
		
		for(int i=0; i<persons.length; i++){
			tempPerson = persons[i];
			if(!tempPerson.equalsPhoneString(toSearch)){
				tempArray = Person.addPerson(tempArray, tempPerson);
			}
		}
		
		return tempArray;
	}


	public static Person[] searchingForAPerson(Person[] persons, int userInput, Scanner scanner) {
		Person[] searchResult= new Person[0];
		String toSearch = scanner.nextLine();

		switch(userInput){
			case 1://search by first name
				System.out.println("Enter the first name you would like to search for: ");
				toSearch = scanner.next();
				searchResult = findPersonByFirstName(persons, toSearch);
				break;
			case 2://search by last name
				System.out.println("Enter the last name you would like to search for: ");
				toSearch = scanner.next();
				searchResult = findPersonByLastName(persons, toSearch);
				break;
			case 3://search by full name
				System.out.println("Enter the full name you would like to search for: ");
				toSearch = scanner.nextLine();
				searchResult = findPersonByFullName(persons, toSearch);
				break;
			case 4://search by phone number
				System.out.println("Enter the phone number you would like to search for: ");
				toSearch = scanner.next();
				searchResult = findPersonByPhoneNum(persons, toSearch);
				//scanner.next();
				break;
			case 5://search by city
				System.out.println("Enter the city you would like to search for: ");
				toSearch = scanner.nextLine();
				searchResult = findPersonByCity(persons, toSearch);
				break;
			case 6://search by state
				System.out.println("Enter the state you would like to search for: ");
				toSearch = scanner.next();
				searchResult = findPersonByState(persons, toSearch);
				break;
			default:
				System.out.println("You entered a value outside the give menu");
		}
		return searchResult;
	}
	
	public static Person[] findPersonByState(Person[] persons, String lookingFor) {
		Person[] tempArray= new Person[0];
		Person tempPerson;
		for(int i=0;i<persons.length;i++){
			tempPerson = persons[i];
			if(tempPerson.getAddress().getState().equals(lookingFor.replace(" ", ""))){
				tempArray = Person.addPerson(tempArray, persons[i]);
			}
		}
		return tempArray;	
	}


	public static Person[] findPersonByCity(Person[] persons, String lookingFor) {
		Person[] tempArray= new Person[0];
		Person tempPerson;
		for(int i=0;i<persons.length;i++){
			tempPerson = persons[i];
			if(tempPerson.getAddress().getCity().equalsIgnoreCase(lookingFor)){
				tempArray = Person.addPerson(tempArray, persons[i]);
			}
		}
		return tempArray;
	}


	public static Person[] findPersonByPhoneNum(Person[] persons, String toSearch) {
		Person[] tempArray = new Person[0];
		Person tempPerson;
		for(int i=0; i<persons.length; i++){
			tempPerson = persons[i];
			if(tempPerson.equalsPhoneString(toSearch)){
				tempArray = Person.addPerson(tempArray, tempPerson);
			}
		}
		return tempArray;
	}


	public static Person[] findPersonByFullName(Person[] persons, String toSearch) {
		Person[] tempArray = new Person[0];
		Person tempPerson;
		for(int i=0; i<persons.length; i++){
			tempPerson = persons[i];
			if(tempPerson.getFullName().equalsIgnoreCase(toSearch)){
				tempArray = Person.addPerson(tempArray, tempPerson);
			}
		}
		return tempArray;
	}


	public static Person[] findPersonByLastName(Person[] persons, String toSearch) {
		Person[] tempArray = new Person[0];
		Person tempPerson;
		for(int i=0; i<persons.length; i++){
			tempPerson = persons[i];
			if(tempPerson.equalsLName(toSearch)){
				tempArray = Person.addPerson(tempArray, tempPerson);
			}
		}
		return tempArray;
	}

	public static Person[] findPersonByFirstName(Person[] persons , String lookingFor){
		Person[] tempArray= new Person[0];// use expan Array method
		Person tempPerson;
		for(int i=0; i<persons.length; i++){
			tempPerson = persons[i];
			if(tempPerson.equalsFName(lookingFor)){
				tempArray = Person.addPerson(tempArray, persons[i]);
			}
		}
		return tempArray;
	}

	public static Person getPersonInfo(Scanner scanner) {
		Person temp;
		String[] strInfo;
		String info= scanner.nextLine();
		String fullName, address, city, state, zipCode, phoneNumber;
		System.out.println("\nPlease Enter the person's information you would like to add:\nExample: (Full name, address, city, "
						+ "state, zip code, phone number)");
		//System.out.println("");
		info = scanner.nextLine();
		
		strInfo = info.split(",");
		
		fullName =strInfo[0];
		address = strInfo[1];
		if(address.charAt(0)==' '){
			address = strInfo[1].substring(1);
		}
		city =  strInfo[2];
		if(city.charAt(0)==' '){
			city = strInfo[2].substring(1);
		}
		state = strInfo[3];
		if(state.charAt(0)==' '){
			state = strInfo[3].substring(1);
		}
		zipCode =  strInfo[4].replace(" ", "");
		phoneNumber = strInfo[5].replace(" ", "");
		temp = new Person(fullName, address, city, state, zipCode, phoneNumber);
		return temp;
	}

	public static int mainMenu(Scanner scanner) {
		int userInput=0;
		
		System.out.println("*****PhoneBook******--PhNumoogle--******PhoneBook*****");
		System.out.println("\nMain Menu:            ");
		System.out.println("Enter '1' to add a person\nEnter '2' to remove a person\nEnter '3' to search for a person"+
						"\nEnter '4' to update a telephone number\nEnter '5' to show all of the people in the system "+
						"\nEnter '6' to quit the program");
		
		userInput = scanner.nextInt();

		return userInput;
	}

	public static int searchMenuDisplay(Scanner scanner) {
		int userInput;
		System.out.println("*****PhoneBook******--PhNumoogle--******PhoneBook*****");
		System.out.println("\nSearch Menu:            ");
		System.out.print("Enter '1' to search by first Name\nEnter '2' to search by last Name\nEnter '3' to search by full Name"+
							"\nEnter '4' to search by Phone Number\nEnter '5' to search by city\nEnter '6' to search by state."+
							"\nEnter '7' to quit the program\nEnter your chocie: ");
		userInput = scanner.nextInt();
		
		return userInput;
	}

}
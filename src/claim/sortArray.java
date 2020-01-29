package claim;

import java.util.Comparator;

public class sortArray implements Comparator<Person>{
	public int compare(Person personObj1, Person personObj2){
		return personObj1.getFirstName().compareTo(personObj2.getFirstName());
	}
}


//public class sortArryByLastName implements Comparator<Person>{
//	public int compare(Person personObj1, Person personObj2){
//		return personObj1.getLastName().compareTo(personObj2.getLastName());
//	}
//}
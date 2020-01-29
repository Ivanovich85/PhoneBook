package claim;

public class PhoneNumber {
	private String areaCode, firstNums, lastNums, extension;
	
	public PhoneNumber(){}
	public PhoneNumber(String ac, String fNum, String lNum){
		areaCode = ac;
		firstNums = fNum;
		lastNums = lNum;
	}
	public PhoneNumber(String ac, String fNum, String lNum, String ex){
		areaCode = ac;
		firstNums = fNum;
		lastNums = lNum;
		extension = ex;
	}
	
	public String getFullPhoneNum(){
		return areaCode+firstNums+lastNums;
	}
	
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String ac) {
		areaCode = ac;
	}

	public String getFirstNums() {
		return firstNums;
	}
	public void setFirstNums(String fn) {
		firstNums = fn;
	}
	
	public String getLastNums() {
		return lastNums;
	}	
	public void setLastNums(String ln) {
		lastNums = ln;
	}

	public String getExtension() {
		return extension;
	}
	public void setExtension(String ex) {
		extension = ex;
	}
	//public
}

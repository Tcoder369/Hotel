package bl;

import exceptions.InvalidInfoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a class used to contain the details of a person
 * set as a class in order to allow flexibility 
*/

class PersonalDetails {
	String id;
	String fname;
	String mname;
	String lname;
	String phone;
	String phone2;
	String email;
	String billingAdress;
	static Integer ids = 100;
	
	
	PersonalDetails(String id, String fname, String mname, String lname, String phone, String phone2, String email, String billingAdress) {
		setId(id);
		setFname(fname);
		setMname(mname);
		setLname(lname);
		setPhone(phone);
		setPhone2(phone2);
		setEmail(email);
		setBillingAdress(billingAdress);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) throws InvalidInfoException{
		if(id == null || (id.length() < 9 || id.length() > 10)) {
			throw new InvalidInfoException("invalid Id - trying to create Personal Info");
		}
		int bikoret =  0;
		int sum = 0, sumID = 0;
		
		for(int i = 0; i < 8; i ++) {
			try {
				if(i % 2 != 0) {
					sum = 2 * Integer.parseInt("" + id.charAt(i));
				}
				else {
					sum = Integer.parseInt("" + id.charAt(i));
				}
			}
			catch(NumberFormatException ex) {
				return;
			}
			if(sum > 9) {
				sum = ((sum % 10) + (sum / 10));
			}
			sumID += sum;
			sum = 0;
		}
		
		bikoret = (10 - (sumID % 10));
		if(bikoret == 10)
			bikoret = 0;
		
		if(!(bikoret == Integer.parseInt("" + id.charAt(id.length() - 1))))
			throw new InvalidInfoException("invalid Id - trying to create Personal Info");
		this.id = id;	
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) throws InvalidInfoException{
		if(fname == null || fname.length() == 0) {
			throw new InvalidInfoException("invalid first name - trying to create Personal Info");
		}
		Pattern pattern = Pattern.compile("^[A-Z][a-z]*");
	    Matcher matcher = pattern.matcher(fname);
	    boolean matchFound = matcher.find();
	    
	    if(!matchFound) {
	    	throw new InvalidInfoException("invalid first name - trying to create Personal Info");
	    }
		this.fname = fname;
	}
	
	public String getMname() {
		return mname;
		
	}
	
	public void setMname(String mname) {
		Pattern pattern = Pattern.compile("^[A-Z][a-z ]*[A-Z][a-z ]*");
	    Matcher matcher = pattern.matcher(mname);
	    boolean matchFound = matcher.find();
	    
	    if(!matchFound && mname!=null && mname.length() != 0) {
	    	throw new InvalidInfoException("invalid middle name - trying to create Personal Info");
	    }
		this.mname = mname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		if(lname == null || lname.length() == 0) {
			throw new InvalidInfoException("invalid last name - trying to create Personal Info");
		}
		Pattern pattern = Pattern.compile("^[A-Z][a-z]*");
	    Matcher matcher = pattern.matcher(mname);
	    boolean matchFound = matcher.find();
	    
	    if(!matchFound && mname!=null && mname.length() != 0) {
	    	throw new InvalidInfoException("invalid last name - trying to create Personal Info");
	    }
		this.lname = lname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		
		if(phone == null || phone.length() == 0) {
			throw new InvalidInfoException("invalid last name - trying to create Personal Info");
		}
		Pattern pattern = Pattern.compile("/^(?:(?:(\\+?972|\\(\\+?972\\)|\\+?\\(972\\))(?:\\s|\\.|-)?([1-9]\\d?))|(0[23489]{1})|(0[57]{1}[0-9]))(?:\\s|\\.|-)?([^0\\D]{1}\\d{2}(?:\\s|\\.|-)?\\d{4})$/gm"
				);
	    Matcher matcher = pattern.matcher(phone);
	    boolean matchFound = matcher.find();
	    
	    if(!matchFound && phone!=null && phone.length() != 0) {
	    	throw new InvalidInfoException("invalid phone number - trying to create Personal Info");
	    }
		this.phone = phone;
	}
	
	public String getPhone2() {
		return phone2;
	}
	
	public void setPhone2(String phone) {

		Pattern pattern = Pattern.compile("/^(?:(?:(\\+?972|\\(\\+?972\\)|\\+?\\(972\\))(?:\\s|\\.|-)?([1-9]\\d?))|(0[23489]{1})|(0[57]{1}[0-9]))(?:\\s|\\.|-)?([^0\\D]{1}\\d{2}(?:\\s|\\.|-)?\\d{4})$/gm"
				);
	    Matcher matcher = pattern.matcher(phone);
	    boolean matchFound = matcher.find();
	    
	    if(!matchFound && phone!=null && phone.length() != 0) {
	    	throw new InvalidInfoException("invalid phone number (2) - trying to create Personal Info");
	    }
		this.phone2 = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		Pattern pattern = Pattern.compile("/^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/gi",
				Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(phone);
	    boolean matchFound = matcher.find();
	    
	    if(!matchFound && phone!=null && phone.length() != 0) {
	    	throw new InvalidInfoException("invalid email - trying to create Personal Info");
	    }
		this.email = email.toLowerCase();
	}
	public String getBillingAdress() {
		return billingAdress;
	}
	
	public void setBillingAdress(String billingAdress) {
		this.billingAdress = billingAdress;
	}
	
	
	
	
	
	
	
}

package BL;

import exceptions.InvalidInfoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a class used to contain the details of a person
 * set as a class in order to allow flexibility */
class PersonalDetails {
	String id;
	String fname;
	String mname;
	String lname;
	String phone;
	String phone2;
	String email;
	String biilingAdress;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) throws InvalidInfoException{
		if(id == null || id.length() < 9) {
			throw new InvalidInfoException("invalid Id - trying to create Personal Info");
		}
		// more checks for validity
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
		if(phone == null || phone.length() == 0) {
			throw new InvalidInfoException("invalid last name - trying to create Personal Info");
		}
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
		if(email == null || email.length() == 0) {
			throw new InvalidInfoException("invalid email - trying to create Personal Info");
		}
		Pattern pattern = Pattern.compile("/^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/gi",
				Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(phone);
	    boolean matchFound = matcher.find();
	    
	    if(!matchFound && phone!=null && phone.length() != 0) {
	    	throw new InvalidInfoException("invalid email - trying to create Personal Info");
	    }
		this.email = email.toLowerCase();
	}
	public String getBiilingAdress() {
		return biilingAdress;
	}
	
	public void setBiilingAdress(String biilingAdress) {
		if(biilingAdress == null || biilingAdress.length() == 0) {
			throw new InvalidInfoException("invalid billing address - trying to create Personal Info");
		}
		this.biilingAdress = biilingAdress;
	}
	
	
	
	
	
	
	
}

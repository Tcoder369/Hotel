package bl;

import exceptions.InvalidInfoException;

/**
 * A class that represents a guest of the hotel.
 * Properties:
 * 	- PersonalDetails details - an object that represents the details of the guest.
 * 	- int numVisit - keeps track of how many times the guest stayed at the hotel 
 * */
class Guest {
	private PersonalDetails details;
	private int numVisit;
	
	Guest(PersonalDetails details) {
		setDetails(details);
	}
	
	Guest(PersonalDetails details, int numVisit) {
		setDetails(details);
		setNumVisit(numVisit);
	}

	public PersonalDetails getDetails() {
		return details;
	}

	void setDetails(PersonalDetails details) {
		if(details == null) {
			throw new InvalidInfoException("missing personal details - trying to create guest");
		}
		this.details = details;
	}

	public int getNumVisit() {
		return numVisit;
	}

	void setNumVisit(int numVisit) {
		if(numVisit < 0)
			throw new InvalidInfoException("invalid number of visits - trying to create guest");
		this.numVisit = numVisit;
	}
	
	
}

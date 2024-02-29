package BL;
/**
 * A class that represents a guest of the hotel.
 * Properties:
 * 	- PersonalDetails details - an object that represents the details of the guest.
 * 	- int numVisit - keeps tracks of how many times the guest stayed at the hotel */
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
		this.details = details;
	}

	public int getNumVisit() {
		return numVisit;
	}

	void setNumVisit(int numVisit) {
		this.numVisit = numVisit  >= 0? numVisit: 0;
	}
	
	
}
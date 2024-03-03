package bl;

public class BusinessGuest extends Guest {

	static int code = 100;
	static double discountPercentage;
	int guestCode;
	

	BusinessGuest(PersonalDetails details, int numVisit) {
		super(details, numVisit);
		setGuestCode();
		
	}
	
	BusinessGuest(PersonalDetails details) {
		super(details);
		setGuestCode();
	}
	
	public int getGuestCode() {
		return guestCode;
	}

	synchronized void setGuestCode() {
		this.guestCode = code++;
	}

}

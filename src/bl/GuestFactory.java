package bl;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import exceptions.InvalidInfoException;

public class GuestFactory {
	public ArrayList<Guest> guests;
	
	GuestFactory() {
		this.guests = new ArrayList<Guest>();
	}
	
	public void addGuest() {
		String id;
		String fname;
		String mname;
		String lname;
		String phone;
		String phone2;
		String email;
		String billingAdress;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Id (Reguired): ");
		id = in.next();
		System.out.println("Enter First Name (Required): ");
		fname = in.next();
		System.out.println("Enter Middle Name (Optional - enter to skip): ");
		mname = in.next();
		System.out.println("Enter Last Name (Required): ");
		lname = in.next();
		System.out.println("Enter Phone Number (Required): ");
		phone = in.nextLine();
		System.out.println("Enter Second Phone Number (Optional - enter to skip): ");
		phone2 = in.nextLine();
		System.out.println("Notice! Either email or Billing Adress are required!");
		System.out.println("Enter Email (Optional - enter to skip): ");
		email = in.next();
		
		if(email == null || email.length() == 0) {
			do {
				System.out.println("Enter Billing Adress (Required - enter the word email to enter email (in lowercaps) instead): ");
				billingAdress = in.next();
			}
			while(billingAdress == null || billingAdress.length() == 0);
			
			if(billingAdress.equals("email")) {
				do {
					System.out.println("Enter Email (Required): ");
					billingAdress = in.next();
				}
				while((billingAdress == null || billingAdress.length() == 0));
			}
		}
		
		else {
			System.out.println("Enter Billing Adress (Optional - enter to skip): ");
			billingAdress = in.next();
		}
			

		char business = ' ';
		do {
			System.out.println("Is this a business guest? [y/n]");
		}
		while(business!=' ' && business != 'y' && business != 'n');
		
		
		try {
			PersonalDetails details = new PersonalDetails(
					id,
					fname,
					mname,
					lname,
					phone,
					phone2,
					email,
					billingAdress);
			
			Guest guest;
			if(business == 'y') 
				guest = new BusinessGuest(details);
			else 
				guest = new Guest(details);
			this.guests.add(guest);		
		}
		
		catch (InvalidInfoException ex) {
			System.out.println("Woops! looks like some of the information you provided was incorrect: ");
			System.out.println(ex.getMessage());
			System.out.println("would you like to try again? [y/n]");
			char res = in.next().charAt(0);
			if(res == 'y') {
				this.addGuest();
			}
			else {
				System.out.println("Good Bye!");
				return;
			}
		}
		
		System.out.println("Guest Added Successfully!");
	}
	
	public ArrayList<Guest> findById(String id) {
		ArrayList<Guest> results = (ArrayList<Guest>) this.guests.stream()
								.filter(g -> id.equals(g.getDetails().getId()))
								.collect(Collectors.toList());
		
		return results;
	}
	
	public ArrayList<Guest> findByFname(String fname) {
		ArrayList<Guest> results = (ArrayList<Guest>) this.guests.stream()
				.filter(g -> fname.equals(g.getDetails().getFname()))
				.collect(Collectors.toList());
		
		return results;
	}
	
	public ArrayList<Guest> findByLname(String lname) {
		ArrayList<Guest> results = (ArrayList<Guest>) this.guests.stream()
				.filter(g -> lname.equals(g.getDetails().getLname()))
				.collect(Collectors.toList());
		
		return results;
	}
	
	public void deleteGuest() {
		// to do when order factory is done!
	}
	
	public void printGuestById(String id) {
		ArrayList<Guest> results = findById(id);
		if(results == null || results.size() == 0) {
			System.out.println("couldn't find any results, sorry");
			return;
		}
		if(results.size() > 1) {
			System.out.println("we found more then one match");
		}
		results.forEach(System.out::println);
	}
	
	public void printGuestByFname(String fname) {
		ArrayList<Guest> results = findByFname(fname);
		if(results == null || results.size() == 0) {
			System.out.println("couldn't find any results, sorry");
			return;
		}
		if(results.size() > 1) {
			System.out.println("we found more then one match");
		}
		results.forEach(System.out::println);
	}
	
	public void printGuestByLname(String lname) {
		ArrayList<Guest> results = findByLname(lname);
		if(results == null || results.size() == 0) {
			System.out.println("couldn't find any results, sorry");
			return;
		}
		if(results.size() > 1) {
			System.out.println("we found more then one match");
		}
		results.forEach(System.out::println);
	}
	
	public void produceActiveGuestsReport() {
		// to do when order factory is done!
	}
}

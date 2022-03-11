<<<<<<< Updated upstream:src/main/java/domain/Customer.java
package domain;

import java.util.Vector;
import java.util.Enumeration;

public class Customer 
{
	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.addElement (rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String statement () {
		double 				totalAmount 			= 0;
		int					frequentRenterPoints 	= 0;
		Enumeration 		rentals 				= this.rentals.elements ();
		String 				result 					= "Rental Record for " + getName () + "\n";
		
		while (rentals.hasMoreElements ()) {
			double 		thisAmount = 0;
			Rental each = (Rental)rentals.nextElement ();
			
			// determines the amount for each line
			switch (each.getMovie ().getPriceCode ()) {
				case Movie.REGULAR:
					thisAmount += 2;
					if (each.getDaysRented () > 2)
						thisAmount += (each.getDaysRented () - 2) * 1.5;
					break;
				case Movie.NEW_RELEASE:
					thisAmount += each.getDaysRented () * 3;
					break;
				case Movie.CHILDRENS:
					thisAmount += 1.5;
					if (each.getDaysRented () > 3)
						thisAmount += (each.getDaysRented () - 3) * 1.5;
					break;
			}
			
			frequentRenterPoints++;
			
			if (each.getMovie ().getPriceCode () == Movie.NEW_RELEASE 
					&& each.getDaysRented () > 1)
				frequentRenterPoints++;
				
			result += "\t" + each.getMovie ().getTitle () + "\t"
								+ String.valueOf (thisAmount) + "\n";
			totalAmount += thisAmount;
				
		}
		
		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";
		
		
		return result;
	}
	

	private String name;
	private Vector rentals = new Vector ();
=======
package nl.han.ica.oose.dea;

import java.util.Vector;
import java.util.Enumeration;

public class Customer

{
	private String name;
	private Vector rentals = new Vector ();

	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.addElement (rental);
	}
	
	public String getName () {
		return name;
	}

	private boolean getExtraRenterPoints(Rental rental){
		return (rental.getMovie ().getPriceCode () == Movie.NEW_RELEASE && rental.getDaysRented () > 1);
	}

	private double totalAmount(Enumeration enumeration){
		double thisAmount = 0;
		while (enumeration.hasMoreElements()){
			Rental each = (Rental) enumeration.nextElement ();
			switch (each.getMovie ().getPriceCode ()) {
				case Movie.REGULAR:
					thisAmount += 2;
					if (each.getDaysRented () > 2)
						thisAmount += (each.getDaysRented () - 2) * 1.5;
					break;
				case Movie.NEW_RELEASE:
					thisAmount += each.getDaysRented () * 3;
					break;
				case Movie.CHILDRENS:
					thisAmount += 1.5;
					if (each.getDaysRented () > 3)
						thisAmount += (each.getDaysRented () - 3) * 1.5;
					break;
			}
		}
		return thisAmount;
	}

	private int frequentRenterPoints (Enumeration enumeration) {
		int	frequentRenterPoints 	= 0;
		Rental each = (Rental) enumeration.nextElement();
		while (enumeration.hasMoreElements()) {
			frequentRenterPoints++;
		}
		if(getExtraRenterPoints(each)) {
			frequentRenterPoints++;
		}
		return  frequentRenterPoints;
	}

//	private String result(Rental rental, double thisAmount){
//		String result = "Rental Record for " + getName () + "\n";
//		result+= "\t" + rental.getMovie ().getTitle () + "\t"
//				+ String.valueOf (thisAmount) + "\n";
//		return  r
//	}
	public String statement () {
		double 	totalAmount;
		int	frequentRenterPoints 	= 0;
		Enumeration 		rentals 				= this.rentals.elements();
		String 				result 					= "Rental Record for " + getName () + "\n";
		totalAmount = totalAmount(rentals);
		frequentRenterPoints = frequentRenterPoints(rentals);

		
		result += "\t" + each.getMovie ().getTitle () + "\t"
								+ String.valueOf (thisAmount) + "\n";

		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";
		
		
		return result;
	}

>>>>>>> Stashed changes:src/main/java/nl/han/ica/oose/dea/Customer.java
}
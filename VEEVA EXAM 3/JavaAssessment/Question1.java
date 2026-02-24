package JavaAssessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Capital {
    String name;
    String season;

    public Capital(String name, String season) {
        this.name = name;
        this.season = season;
    }
}

class Country {
    String name;
    List<Capital> capitals;

    public Country(String name) {
        this.name = name;
        this.capitals = new ArrayList<>();
    }

    public void addCapital(String capitalName, String season) {
        capitals.add(new Capital(capitalName, season));
    }

    public int getCapitalCount() {
        return capitals.size();
    }
}
public class Question1 {

	    public static boolean startsWithVowel(String s) {
	        char ch = Character.toLowerCase(s.charAt(0));
	        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        List<Country> countries = new ArrayList<>();

	        System.out.print("Enter number of countries: ");
	        int n = sc.nextInt();
	        sc.nextLine();

	        for (int i = 0; i < n; i++) {
	            System.out.println("\nEnter country name:");
	            String cname = sc.nextLine();

	            Country country = new Country(cname);

	            System.out.print("Enter number of capitals (1 / 2 / 3): ");
	            int capCount = sc.nextInt();
	            sc.nextLine();

	            for (int j = 0; j < capCount; j++) {
	                System.out.print("Enter capital name: ");
	                String capName = sc.nextLine();

	                System.out.print("Enter season (Winter / Summer / Rainy): ");
	                String season = sc.nextLine();

	                country.addCapital(capName, season);
	            }

	            countries.add(country);
	        }

	        while (true) {
	            System.out.println("\n--------- MENU ---------");
	            System.out.println("1. Print all countries with capitals");
	            System.out.println("2. Print capitals of a given country");
	            System.out.println("3. Print countries having 2 capitals");
	            System.out.println("4. Print countries having 3 capitals");
	            System.out.println("5. Find countries without summer capital");
	            System.out.println("6. Find capitals of countries starting with vowel");
	            System.out.println("7. Print summer capitals of countries starting with vowel");
	            System.out.println("8. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {

	                case 1:
	                    for (Country c : countries) {
	                        System.out.println("\nCountry: " + c.name);
	                        System.out.println("No of Capitals: " + c.getCapitalCount());
	                        for (Capital cap : c.capitals) {
	                            System.out.println("  Capital: " + cap.name + " | Season: " + cap.season);
	                        }
	                    }
	                    break;

	                case 2:
	                    System.out.print("Enter country name: ");
	                    String search = sc.nextLine();
	                    boolean found = false;

	                    for (Country c : countries) {
	                        if (c.name.equalsIgnoreCase(search)) {
	                            found = true;
	                            System.out.println("Country: " + c.name);
	                            System.out.println("No of Capitals: " + c.getCapitalCount());
	                            for (Capital cap : c.capitals) {
	                                System.out.println("Capital: " + cap.name + " | Season: " + cap.season);
	                            }
	                        }
	                    }
	                    if (!found)
	                        System.out.println("Country not found!");
	                    break;

	                case 3:
	                    System.out.println("Countries having 2 capitals:");
	                    for (Country c : countries) {
	                        if (c.getCapitalCount() == 2) {
	                            System.out.println(c.name);
	                        }
	                    }
	                    break;

	                case 4:
	                    System.out.println("Countries having 3 capitals:");
	                    for (Country c : countries) {
	                        if (c.getCapitalCount() == 3) {
	                            System.out.println(c.name);
	                        }
	                    }
	                    break;

	                case 5:
	                    System.out.println("Countries without summer capital:");
	                    for (Country c : countries) {
	                        boolean hasSummer = false;
	                        for (Capital cap : c.capitals) {
	                            if (cap.season.equalsIgnoreCase("summer")) {
	                                hasSummer = true;
	                                break;
	                            }
	                        }
	                        if (!hasSummer) {
	                            System.out.println(c.name);
	                        }
	                    }
	                    break;

	                case 6:
	                    System.out.println("Capitals of countries starting with vowel:");
	                    for (Country c : countries) {
	                        if (startsWithVowel(c.name)) {
	                            for (Capital cap : c.capitals) {
	                                System.out.println(c.name + " -> " + cap.name);
	                            }
	                        }
	                    }
	                    break;

	                case 7:
	                    System.out.println("Summer capitals of countries starting with vowel:");
	                    for (Country c : countries) {
	                        if (startsWithVowel(c.name)) {
	                            for (Capital cap : c.capitals) {
	                                if (cap.season.equalsIgnoreCase("summer")) {
	                                    System.out.println(c.name + " -> " + cap.name);
	                                }
	                            }
	                        }
	                    }
	                    break;

	                case 8:
	                    System.out.println("Thank you!");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice!");
	            }
	        }
	    }
	}


import java.util.*;

class ClubManager{
	static String name;
	static String srn;
	public static void main(String args[]){
		Database db = Database.getdb();
	    Scanner sc = new Scanner(System.in);
        int valid = 0;
        while (valid==0){
		    System.out.println("Enter your name.");
	        name = sc.nextLine();
	        System.out.println("Enter your SRN.");
	        srn = sc.nextLine();
        	valid = db.findStudentInDatabase(name, srn);
        }
		if (valid==1)
			studentInterface();
		else if (valid==2)
			modInterface();
		else
			System.out.println("Error: This is not a valid level of authority.");
			
		System.out.println("Exiting.");
		return;
	}
	
	static void studentInterface(){
		while(1==1){
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("What would you like to do?\n1. View details for an event\n2. Register for an event\n3. Join a club\n4. Exit");
			Scanner sc = new Scanner(System.in);
			int n = Integer.valueOf(sc.nextLine());
			switch(n){
				case(1):
					Student.viewDetails();
					break;
				case(2):
					Student.joinEvent();
					break;
				case(3):
					Student.joinClub();
					break;
				default:
					return;
			}
		}	
	}
	
	static void modInterface(){
		while(1==1){
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("What would you like to do?\n1. Create a club\n2. Create an event\n3. Create an external event\n4. Ask for refund\n5. Exit");
			Scanner sc = new Scanner(System.in);
			int n = Integer.valueOf(sc.nextLine());
			switch(n){
				case(1):
					ClubModerator.createClub();
					break;
				case(2):
					ClubModerator.createEvent();
					break;
				case(3):
					ClubModerator.createExtEvent();
					break;
				case(4):
					ClubModerator.askRefund();
					break;
				default:
					return;
			}
		}	
	}
}

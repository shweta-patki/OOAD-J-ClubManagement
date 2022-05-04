import java.util.*;
public class ClubModerator{
	static Database db= Database.getdb();
	static Admin a = Admin.getAdmin();
	public static void createClub(){
		Club c = new Club();
		db.setClub(c);
	}
	public static void createEvent(){
		ClubFaculty cf = new ClubFaculty();
		String room = String.valueOf(cf.provideRoom());
		Event e = new Event(room);
		db.setEvent(e);
	}
	public static void createExtEvent(){
		ClubFaculty cf = new ClubFaculty();
		String room = String.valueOf(cf.provideRoom());
		ExternalEvent e = new ExternalEvent(room);
		db.setExtEvent(e);
	}
	public static void askRefund(){
		System.out.println("Enter value of refund.");
		Scanner sc = new Scanner(System.in);
		int val = Integer.valueOf(sc.nextLine());
		if (val>10000)
			System.out.println("Refund rejected.");
		else if (val>1000)
			System.out.println("Please submit proofs of purchase.");
		else
		{
			System.out.println("Your application has been recieved.");
			int app = a.isApproved();
			if (app==0)
				System.out.println("Rejected.");
			else
				System.out.println("Approved.");
		}
	}
}

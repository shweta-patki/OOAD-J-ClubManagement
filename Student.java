import java.util.*;
public class Student{
	private String SRN;
	private String Name;
	private int mod;
	public Student(String s, String n, int m){
		this.SRN = s;
		this.Name = n;
		this.mod = m;
	}
	public String getname(){return Name;}
	public String getsrn(){return SRN;}
	public int getmod(){return mod;}
	
	public static void viewDetails()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter event name.");
		String n = sc.nextLine();
		Database db = Database.getdb();
		db.findEventInDatabase(n);
	}
	
    public static void joinClub()
    {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter club name.");
		String n = sc.nextLine();
        System.out.println("Thank you for applying to "+n+". Your application is being processed.");
        try{
        	Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
           Thread.currentThread().interrupt();
        }
        System.out.println("Your application succesfully submitted.");
    }
    
    public static void joinEvent()
    {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter event name.");
		String n = sc.nextLine();
        System.out.println("Thank you for applying to "+n+". Please wait while your request is being processed.");
        try
        {
           Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
           Thread.currentThread().interrupt();
        }
        System.out.println("Registration complete.");
    }
}

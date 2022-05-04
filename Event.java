import java.util.*;

public class Event{
	private String name = "";
	private String club = "";
	private String location = "";
	private String schedule = "";

    Scanner sc = new Scanner(System.in);

	public Event(String l){
		System.out.println("Enter event name: ");
        this.name = sc.nextLine();
        System.out.println("Enter conducting club ");
        this.club = sc.nextLine();
        this.location = l;
        System.out.println("Enter date of event: ");
        this.schedule = sc.nextLine();
	}

	public String getname() {return this.name;}
	public String getloc() {return this.location;}
	public String getclub() {return this.club;}
	public String getschedule() {return this.schedule;}

}


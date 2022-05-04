import java.util.*;

public class Club{
	private String name = "";
	private String FacAdvisor = "";
	private String objectives = "";
	private String email = "";
	private String head = "";
	private String dateOfCreation = "";
	private String socials = "";

    Scanner sc = new Scanner(System.in);

	public Club(){
		System.out.println("Enter club name: ");
        this.name = sc.nextLine();
        System.out.println("Enter faculty advisor: ");
        this.FacAdvisor = sc.nextLine();
        System.out.println("Enter objectives: ");
        this.objectives = sc.nextLine();
        System.out.println("Enter email: ");
        this.email = sc.nextLine();
        System.out.println("Enter head name: ");
        this.head = sc.nextLine();
        System.out.println("Enter creation date: ");
        this.dateOfCreation = sc.nextLine();
        System.out.println("Enter social media: ");
        this.socials = sc.nextLine();
	}

	public String getname() {return this.name;}
	public String getfacadv() {return this.FacAdvisor;}
	public String getobjectives() {return this.objectives;}
	public String gethead() {return this.head;}
	public String getemail() {return this.email;}
	public String getsocmed() {return this.socials;}
	public String getcreated() {return this.dateOfCreation;}

}

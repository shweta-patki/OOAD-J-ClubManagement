import java.util.*;

public class ExternalEvent extends Event{
	private String transportation;
	private String host;

    Scanner sc = new Scanner(System.in);

	public ExternalEvent(String r){
		super(r);
        System.out.println("Enter transportation: ");
        this.transportation = sc.nextLine();
        System.out.println("Enter host: ");
        this.host = sc.nextLine();
	}

	public String gettransportation() {return this.transportation;}
	public String gethost() {return this.host;}
}

import java.util.*;
import java.sql.*;

public class Database{

	private Club club;
	private Event event;
	private ExternalEvent eev;
	private Student st;
	private static Database db=null; 
	
	public static Database getdb(){
		if (db==null)
			db= new Database();
		return db;
	}

    private Database(){    
    	buildDB();
    }
    
    public void buildDB(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clubmanager", "postgres", "postgres");
            stmt = c.createStatement();
            String sql1 = "create table club(name text primary key, facadv text not null, objectives text, head text not null, email text not null, socmed text, created text not null);";
            String sql2 = "create table event(name text primary key, location text not null, club text not null, schedule text not null, transportation text, host text);";
            String sql3 = "create table student(name text not null, srn text primary key, moderator int not null);";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.close();
            c.close();
        } 
        catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        System.out.println("Created Tables successfully");
    }
    
    
    public void setClub(Club c){
    	this.club = c;
    	storeClub();
    }
    public void storeClub(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clubmanager", "postgres", "postgres");
            PreparedStatement st = c.prepareStatement("insert into club(name, facadv, objectives, head, email, socmed, created) VALUES (?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, club.getname());
            st.setString(2, club.getfacadv());
            st.setString(3, club.getobjectives());
            st.setString(4, club.gethead());
            st.setString(5, club.getemail());
            st.setString(6, club.getsocmed());
            st.setString(7, club.getcreated());
            st.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Error"+e);
        }
    }
    

    public void setEvent(Event e){
    	this.event = e;
    	storeEvent();
    }
    public void storeEvent(){
    	Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clubmanager", "postgres", "postgres");
            PreparedStatement st = c.prepareStatement("insert into event(name, location, club, schedule, transportation, host) VALUES (?, ?, ?, ?, ?, ?);");
            st.setString(1, event.getname());
            st.setString(2, event.getloc());
            st.setString(3, event.getclub());
            st.setString(4, event.getschedule());
            st.setString(5, " ");
            st.setString(6, " ");
            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error"+e);
        }

    }
    

    public void setExtEvent(ExternalEvent e){
    	this.eev = e;
    	storeExtEvent();
    }
    public void storeExtEvent(){
    	Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clubmanager", "postgres", "postgres");
            PreparedStatement st = c.prepareStatement("insert into event(name, location, club, schedule, transportation, host) VALUES (?, ?, ?, ?, ?, ?);");
            st.setString(1, eev.getname());
            st.setString(2, eev.getloc());
            st.setString(3, eev.getclub());
            st.setString(4, eev.getschedule());
            st.setString(5, eev.gettransportation());
            st.setString(6, eev.gethost());
            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error"+e);
        }
    }


    public void setStudent(Student s){
    	this.st = s;
    	storeStudent();
    }
    public void storeStudent(){
    	Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clubmanager", "postgres", "postgres");
            PreparedStatement stt = c.prepareStatement("insert into student(name, srn, moderator) VALUES (?, ?, ?);");
            stt.setString(1, st.getname());
            stt.setString(2, st.getsrn());
            stt.setInt(3, st.getmod());
            stt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error"+e);
        }
    }
    
    public int findStudentInDatabase(String name, String srn){
    	Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clubmanager", "postgres", "postgres");
            PreparedStatement stt = c.prepareStatement("select * from student where srn=?;");
            stt.setString(1, srn);
            ResultSet rs = stt.executeQuery();
            if (rs.next())
            {
				System.out.println("~~~~~~~~~~~Welcome, "+name+"~~~~~~~~~~~~");
            	return rs.getInt("moderator");
            }
            else
            {
            	System.out.println("This student does not exist, creating student. Please enter authority level");
            	Scanner sc = new Scanner(System.in);
            	int auth = sc.nextInt();
            	Student s = new Student(srn, name, auth);
            	setStudent(s);
            	return auth;
            }
        }
        catch(Exception e){
            System.out.println("Error"+e);
        }
        return 0;
        }
    
       public void findEventInDatabase(String name){
    	Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clubmanager", "postgres", "postgres");
            PreparedStatement stt = c.prepareStatement("select * from event where name=?;");
            stt.setString(1, name);
            ResultSet rs = stt.executeQuery();
            if (rs.next())
            {
            	for (int i=1; i<7; i++)
	            	System.out.println(rs.getString(i)+"\n");
            	return;
            }
            else
            {
            	System.out.println("There is no event by that name.");
            	return;
            }
        }
        catch(Exception e){
            System.out.println("Error"+e);
        }
    }
}

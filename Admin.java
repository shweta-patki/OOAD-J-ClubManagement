public class Admin {
    private Admin() {}
	private static Admin ad=null;
	
	public static Admin getAdmin(){
		if (ad==null)
			ad=new Admin();
		return ad;
	}

    public int isApproved() {
	    int app = (int) (Math.random()*10);
	    if (app==0)
	    	SuggestChanges();
	    return app;
    }

    private void SuggestChanges() {
        System.out.println("Changes will be suggested via email. Please look into it.");
    }
}

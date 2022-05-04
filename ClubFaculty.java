class ClubFaculty{
	public int provideRoom(){
    	int rno = (int) (Math.random() * (12 - 1 + 1) + 1);
    	int fno = (int) (Math.random() * (12 - 1 + 1) + 1);
    	return fno*100 + rno;
	}
}

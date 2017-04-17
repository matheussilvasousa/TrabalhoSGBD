public interface Buffer {
	
	String fetch(int key);	
		
	int evict();

	void displayCache();
	
	void displayStats();
	       
}
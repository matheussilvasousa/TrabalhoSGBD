public interface Buffer {
	
	void fetch(int key);	
		
	int evict();

	void displayCache();
	
	void displayStats();
	       
}
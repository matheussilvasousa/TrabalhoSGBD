import java.util.LinkedList;

public class Fifo extends Buffer{
	
	protected int pageFaults;
	protected int numFrames;
	LinkedList<String> frames;
    protected int miss;
    protected int hit;
    protected boolean vazia;
	
	public Fifo(){
        this.vazia = true;
		this.numFrames = 8;
		pageFaults = 0;
		this.frames = new LinkedList<String>();
	}
    
    public void evict(){
        
    }
        
	/*public void insert(String pageNumber){
		if(!frames.contains(pageNumber)){
			if(frames.size() < numFrames){
				System.out.println("Mem�ria dispon�vel! Adicionando " + pageNumber + "...");
				frames.add(pageNumber);
			} else{
				System.out.println("Mem�ria cheia! Removendo mais antigo...");
				frames.removeFirst();
				System.out.println("Mem�ria dispon�vel! Adicionando " + pageNumber + "...");
				frames.add(pageNumber);
				/*i++;
				if(i == numFrames){
					i = 0;
				}
			}
			printFrames();
			pageFaults++;
			System.out.println("Page Faults: " + pageFaults);
		}
	}*/

  	public void displayStats(){
  		System.out.printf("Cache Miss: %s\n"+this.miss);
		System.out.printf("Cache Hit: %s\n"+this.hit);
  	}
  			  			
  	public void printFrames(){
  		for(int i = 0; i < frames.size(); i++){
  			System.out.println(frames.get(i));
  		}
  	}
 
}
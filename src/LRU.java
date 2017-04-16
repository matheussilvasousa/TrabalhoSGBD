import java.util.LinkedList;

public class LRU{
		
	protected int pageFaults;
	protected int numFrames;
	LinkedList<String> frames;
		
	public LRU(int numFrames){
		if(numFrames < 0){
			throw new IllegalArgumentException();
		}
		this.numFrames = numFrames;
		pageFaults = 0;
		frames = new LinkedList<String>();
	}
		
	public void insert(String pageNumber){
		int tmp = frames.indexOf(pageNumber);
		if(tmp == -1){
			if(frames.size() < numFrames){
				System.out.println("Memória disponível! Adicionando " + pageNumber + "...");
				frames.add(pageNumber);
			} else{
				System.out.println("Memória cheia! Removendo " + frames.get(0) + "...");
				frames.remove(0);
				System.out.println("Memória disponível! Adicionando " + pageNumber + "...");
				frames.add(pageNumber);
			}
			pageFaults++;
		} else{
			System.out.println(pageNumber + " já está na memória!");
			frames.remove(tmp);
			frames.add(pageNumber);
		}
		printFrames();
	}
	
	public int getPageFaultCount(){
		return pageFaults;
	}
		
	public void printFrames(){
		for(int i = 0; i < frames.size(); i++){
			System.out.println(frames.get(i));
		}
	}
		
}
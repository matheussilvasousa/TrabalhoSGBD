import java.util.LinkedList;

public class Fifo{
	
	private static int i = 0;
	protected int pageFaults;
	protected int numFrames;
	LinkedList frames;
	
	public Fifo(int numFrames){
		if(numFrames < 0){
			throw new IllegalArgumentException();
		}
		this.numFrames = numFrames;
		pageFaults = 0;
		this.frames = new LinkedList();
	}
	
	public void insert(String pageNumber){
		if(!frames.contains(pageNumber)){
			if(frames.size() < numFrames){
				System.out.println("Memória disponível! Adicionando " + pageNumber + "...");
				frames.add(pageNumber);
			} else{
				System.out.println("Memória cheia! Removendo mais antigo...");
				frames.remove(i);
				System.out.println("Memória disponível! Adicionando " + pageNumber + "...");
				frames.add(i, pageNumber);
				i++;
				if(i == numFrames){
					i = 0;
				}
			}
			printFrames();
			pageFaults++;
			System.out.println("Page Faults: " + pageFaults);
		}
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

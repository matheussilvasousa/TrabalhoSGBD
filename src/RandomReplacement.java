import java.util.LinkedList;
import java.util.Random;

public class RandomReplacement{
	
	int i = 0;
	protected int pageFaults;
	protected int numFrames;
	LinkedList<String> frames;
	
	public RandomReplacement(int numFrames){
		if(numFrames < 0){
			throw new IllegalArgumentException();
		}
		this.numFrames = numFrames;
		pageFaults = 0;
		this.frames = new LinkedList<String>();
	}
	
	public void insert(String pageNumber){
		Random random = new Random();
		if(frames.size() < numFrames){
			System.out.println("Memória disponível! Adicionando " + pageNumber + "...");
			frames.add(pageNumber);
			i++;
		} else{
			i = random.nextInt(numFrames);
			System.out.println("Memória cheia! Removendo aleatoriamente na posição " + i + "...");
			frames.remove(i);
			System.out.println("Memória disponível! Adicionando " + pageNumber + "...");
			frames.add(i, pageNumber);
		}
		printFrames();
		pageFaults++;
		System.out.println("Page Faults: " + pageFaults);
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

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
  		  
	public class Fifo extends Buffer{
  			  	
	private static int i = 0;
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
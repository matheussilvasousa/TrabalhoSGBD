import java.util.HashMap;

public class Fifo implements Buffer{
	
	//protected int pageFaults;
	protected int numFrames;
	HashMap<Integer,String> cache;
    protected int miss;
    protected int hit;
    protected boolean empty;
	
	public Fifo(){
        this.empty = true;
		this.numFrames = 8;
		//pageFaults = 0;
		this.cache = new HashMap<Integer,String>();
	}
	
	public String fetch(int key){
		String value = null;
  		if(cache.containsKey(key)){
  			value = cache.get(key);
  			this.hit++;
  		} else if(!cache.containsKey(key) && cache.size() < numFrames){
  			//verificar a aplicação desse método
  			value = catchValue(key);
  			this.miss++;
  		} else{
  			key = evict();
  			value = catchValue(key);
  			this.miss++;
  		}
  		return value;
  	}		
	
	public String catchValue(int key){
		cache.put(key, File.deserializeFile(key));
		return cache.get(key);
	}
    
    public int evict(){
		return 0;
    }
        
	/*public void insert(String pageNumber){
		if(!frames.contains(pageNumber)){
			if(frames.size() < numFrames){
				System.out.println("Memï¿½ria disponï¿½vel! Adicionando " + pageNumber + "...");
				frames.add(pageNumber);
			} else{
				System.out.println("Memï¿½ria cheia! Removendo mais antigo...");
				frames.removeFirst();
				System.out.println("Memï¿½ria disponï¿½vel! Adicionando " + pageNumber + "...");
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
    
    public void displayCache(){
		for(int value : cache.keySet()){
			System.out.println("Chave: " + value + ", valor: " + cache.get(value));
		}
	}

  	public void displayStats(){
  		System.out.printf("Cache Miss: %s\n"+this.miss);
		System.out.printf("Cache Hit: %s\n"+this.hit);
  	}
  			  			
  	public void printFrames(){
  		for(int i = 0; i < cache.size(); i++){
  			System.out.println(cache.get(i));
  		}
  	}
 
}
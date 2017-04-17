import java.util.LinkedList;

public class Fifo implements Buffer{
	
    protected int numFrames;
    LinkedList<Page> cache;
    protected int miss;
    protected int hit;
    protected int pos; 
	
        public Fifo(){
            this.numFrames = 8;
            this.cache = new LinkedList<Page>();
	}
	
        @Override
	public void fetch(int key){
                Page p = new Page();
                p.setKey(key);
                if(cache.isEmpty()){
                    cache.add(File.deserializeFile(key));
                    this.miss++;
                } else if(cache.contains(p)){
                    this.hit++;
  		} else if(!cache.contains(p) && cache.size() < numFrames){
                    cache.add(File.deserializeFile(key));
                    this.miss++;
  		} else{
                    pos = evict();
                    cache.add(pos, File.deserializeFile(key));
                    this.miss++;
  		}
  	}		
    
    @Override
    public int evict(){
            cache.removeFirst();
            return 0;
    }
    
    @Override
    public void displayCache(){
		for(Page p : cache){
			System.out.println("Chave: " + p.getKey() + ", valor: " + p.getValue());
		}
	}

    @Override
    public void displayStats(){
            System.out.printf("Cache Miss: " + this.miss + "\n");
            System.out.printf("Cache Hit: " + this.hit + "\n");
    }
 
}
import java.util.LinkedList;

public class Fifo implements Buffer{
	
    protected int numFrames;
    LinkedList<Page> cache;
    protected int miss;
    protected int hit;
    protected int pos;
    int cont;
	
        public Fifo(){
            this.numFrames = 8;
            this.cache = new LinkedList<Page>();
            cont=0;
	}
	
    @Override
	public void fetch(int key){
                
                if(contain(cache, key)){
                    this.hit++;
		} else if(!contain(cache, key) && cache.size() < numFrames){
		    cache.add(File.deserializeFile(key));
		    this.miss++;
		} else {
		    pos = evict();
		    cache.add(pos, File.deserializeFile(key));
		    this.miss++;
                }
        }
				
    public boolean contain(LinkedList<Page> cache, int key){
        boolean bool=false;
        for(Page p: cache){
            if(p.getKey()==(key)){
               bool = true;
            }
        }
        return bool;
    }
                
    @Override
    public int evict(){
            if(cont==numFrames){
                cont=0;
            }
            cache.remove(cont);
            cont++;
            return cont-1;
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

import java.util.LinkedList;

public class MRU implements Buffer{
		
	protected int numFrames;
        LinkedList<Page> cache;
        protected int miss;
        protected int hit;
        protected int pos;
        LinkedList<Integer> index;
        protected int cont;
        
		
	public MRU(){
		this.numFrames = 8;
                this.cache = new LinkedList<Page>();
                index = new LinkedList<Integer>();
                cont = 1;
	}

    @Override
	public void fetch(int key){
            
                if(contain(cache, key)){
                    this.hit++;
                    for(int i=0; i<cache.size();i++){
                        if (cache.get(i).getKey()==key){
                            pos=i;
                        }
                    }
                    for(int i=0; i<index.size();i++){
                        if(index.get(i)==pos){
                            int cont=i;
                        }
                    }
                    index.remove(cont);
                    index.add(pos);
                    System.out.println(pos);

		} else if(!contain(cache, key) && cache.size() < numFrames){
		    cache.add(File.deserializeFile(key));
		    this.miss++;
                    for(int i=0; i<cache.size();i++){
                        if (cache.get(i).getKey()==key){
                            pos=i;
                        }
                    }
                    index.add(pos);
		} else {
		    pos = evict();
		    cache.add(pos,File.deserializeFile(key));
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
    public int evict() {
        pos = index.getLast();
        index.removeFirst();
        index.addLast(pos);
        return pos;
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
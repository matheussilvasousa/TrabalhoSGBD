import java.util.LinkedList;

public class LFU implements Buffer{
		
	protected int numFrames;
    LinkedList<Page> cache;
    protected int miss;
    protected int hit;
    protected int pos;
    LinkedList<Integer> index;
    protected int cont;
		
	public LFU(){
		this.numFrames = 8;
        this.cache = new LinkedList<Page>();
        this.index = new LinkedList<Integer>();
	}

	@Override
	public void fetch(int key) {
		if(contains(cache, key)){
            this.hit++;
            pos = findPosition(cache, key);
            cont = index.get(pos);
            cont++;
            index.set(pos, cont);
		} else if(!contains(cache, key) && cache.size() < numFrames){
		    cache.add(File.deserializeFile(key));
		    this.miss++;
            pos = findPosition(cache, key);
            index.add(pos, 0);
		} else {
		    pos = evict();
		    cache.set(pos,File.deserializeFile(key));
		    this.miss++;
        }		
	}
	
	public int findPosition(LinkedList<Page> cache, int key){
    	for(int i=0; i<cache.size();i++){
            if (cache.get(i).getKey()==key){
                pos=i+1;
            }
        }
    	return pos;
    }
	
	public boolean contains(LinkedList<Page> cache, int key){
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
		pos = index.get(0);
		for(int i = 1; i < index.size(); i++){
			if(index.get(i) < pos){
				pos = index.get(i);
			}
		}
		return pos-1;
	}

	@Override
    public void displayCache(){
		for(Page p : cache){
			System.out.println("Chave: " + p.getKey() + ", valor: " + p.getValue());
		}
		for(int i = 0; i < index.size(); i++){
			System.out.println("Index[" + i + "]: " + index.get(i));
		}
	}

    @Override
    public void displayStats(){
            System.out.printf("Cache Miss: " + this.miss + "\n");
            System.out.printf("Cache Hit: " + this.hit + "\n");
    }
		
}
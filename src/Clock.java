import java.util.LinkedList;

public class Clock implements Buffer{

	protected int numFrames;
    LinkedList<Page> cache;
    protected int miss;
    protected int hit;
    protected int pos;
		
	public Clock(){
		this.numFrames = 8;
        this.cache = new LinkedList<Page>();
	}
	
	@Override
	public void fetch(int key) {
		if(contains(cache, key)){
            this.hit++;
		} else if(!contains(cache, key) && cache.size() < numFrames){
		    cache.add(File.deserializeFile(key));
		    this.pos++;
		    this.miss++;
		} else {
		    pos = evict();
		    cache.add(pos, File.deserializeFile(key));
		    this.pos++;
		    this.miss++;
		}
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
		if(pos == numFrames){
			pos = 0;
		}
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

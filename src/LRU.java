import java.util.LinkedList;

public class LRU implements Buffer{
		
	protected int numFrames;
        LinkedList<Page> cache;
        protected int miss;
        protected int hit;
        protected int pos;
        int[] acess;
		
	public LRU(){
		this.numFrames = 8;
                this.cache = new LinkedList<Page>();
	}
		
	/*public void insert(String pageNumber){
		int tmp = frames.indexOf(pageNumber);
		if(tmp == -1){
			if(frames.size() < numFrames){
				System.out.println("Mem�ria dispon�vel! Adicionando " + pageNumber + "...");
				frames.add(pageNumber);
			} else{
				System.out.println("Mem�ria cheia! Removendo " + frames.get(0) + "...");
				frames.remove(0);
				System.out.println("Mem�ria dispon�vel! Adicionando " + pageNumber + "...");
				frames.add(pageNumber);
			}
			pageFaults++;
		} else{
			System.out.println(pageNumber + " j� est� na mem�ria!");
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
	}*/

    @Override
    public void fetch(int key) {
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
    public int evict() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
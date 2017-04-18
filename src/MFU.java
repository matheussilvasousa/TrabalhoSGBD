import java.util.LinkedList;

public class MFU{
		
	protected int pageFaults;
	protected int numFrames;
	protected int id = 0;
	protected int i = 0;
	LinkedList<Page> frames;
		
	public MFU(int numFrames){
		if(numFrames < 0){
			throw new IllegalArgumentException();
		}
		this.numFrames = numFrames;
		pageFaults = 0;
		frames = new LinkedList<Page>();
	}
		
	/*public void insert(String pageNumber){
		int tmp = -1;
		Page page = new Page(pageNumber);
		for(int i = 0; i < frames.size(); i++){
			if(pageNumber.equals(frames.get(i).getPage())){
				tmp = i;
			}
		}
		System.out.println("tmp = " + tmp);
		if(tmp == -1){
			if(frames.size() < numFrames){
				System.out.println("Memória disponível! Adicionando " + pageNumber + "...");
				page.setId(id);
				page.setPos(i);
				frames.add(page);
				i++;
			} else{
				Page p = frames.get(0);
				for(int i = 1; i < frames.size(); i++){
					if(p.getId() < frames.get(i).getId()){
						p = frames.get(i);
					}
				}
				System.out.println("Memória cheia! Removendo a mais referenciada...");
				id = p.getId();
				frames.remove(p.getPos());
				System.out.println("Memória disponível! Adicionando " + pageNumber + "...");
				id++;
				page.setId(id);
				page.setPos(p.getPos());
				frames.add(p.getPos(), page);
				pageFaults++;
			}
		} else{
			System.out.println(pageNumber + " já está na memória!");
			id = frames.get(tmp).getId();
			page.setPos(frames.get(tmp).getPos());
			frames.remove(tmp);
			id++;
			page.setId(id);
			frames.add(tmp, page);
		}
		printFrames();
	}
	
	public int getPageFaultCount(){
		return pageFaults;
	}
		
	public void printFrames(){
		for(int i = 0; i < frames.size(); i++){
			System.out.println("Page = " + frames.get(i).getPage() + ", id = " + frames.get(i).getId());
		}
	}*/
		
}
import java.util.LinkedList;

public class Otimo{
		
	protected int pageFaults;
	protected int numFrames;
	protected int id = 0;
	protected int pos = 0;
	protected String pageNumber;
	LinkedList<Page> frames;
		
	public Otimo(int numFrames){
		if(numFrames < 0){
			throw new IllegalArgumentException();
		}
		this.numFrames = numFrames;
		pageFaults = 0;
		frames = new LinkedList<Page>();
	}
		
	/*public void insert(String[] stringPages){
		for(int i = 0; i < stringPages.length; i++){
			Page page = new Page(stringPages[i]);
			if(frames.size() < numFrames){
				System.out.println("Memória disponível! Adicionando " + page.getPage() + "...");
				page.setId(id);
				page.setPos(pos);
				frames.add(page);
				pos++;
			} else{
				for(int j = 0; j < frames.size(); j++){
					id = 0;
					int k = Integer.parseInt(stringPages[i]);
					//System.out.println(k);
					//for(int k = Integer.parseInt(stringPages[i]); k < stringPages.length; k++){
						while(!frames.get(j).getPage().equals(stringPages[k])){
							id++;
							k++;
						}
					//}
					frames.get(j).setId(id);
				}
				Page p = frames.get(0);
				for(int j = 1; j < frames.size(); j++){
					if(p.getId() < frames.get(j).getId()){
						p = frames.get(j);
					}
				}
				System.out.println("Memória cheia! Removendo a página que ficará mais tempo sem ser usada...");
				id = p.getId();
				frames.remove(p.getPos());
				System.out.println("Memória disponível! Adicionando " + page.getPage() + "...");
				id++;
				page.setId(id);
				page.setPos(p.getPos());
				frames.add(p.getPos(), page);
				pageFaults++;
			}
			printFrames();
		}
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
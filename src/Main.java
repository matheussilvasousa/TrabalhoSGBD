import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Digite as paginas selecionadas, separando-as por ',': ");
		Scanner scan1 = new Scanner(System.in);
		String file = scan1.nextLine();
                String[] page = file.split(",");

		System.out.println("Escolha o algoritmo a ser usado:");
		System.out.println("1 - FIFO");
		System.out.println("2 - LRU");
		System.out.println("3 - LFU");
		System.out.println("4 - MFU");
		System.out.println("5 - �timo");
		System.out.println("6 - Random Replacement");
		Scanner scan2 = new Scanner(System.in);
		
		int opt = scan2.nextInt();
		switch(opt){
		case 1:
			Fifo fifo = new Fifo();
            for(int i = 0; i < page.length; i++){
                fifo.fetch(Integer.parseInt(page[i]));
            }
            fifo.displayStats();
            fifo.displayCache();
            break;
		case 2:
			LRU lru = new LRU();
            for(int i = 0; i < page.length; i++){
                lru.fetch(Integer.parseInt(page[i]));
            }
            lru.displayStats();
            lru.displayCache();
            break;
		/*case 3:
			LFU lfu = new LFU();
			for(int i = 0; i < (stringPages.length); i++){
				lfu.insert(stringPages[i]);
			}
			System.out.println("Page Faults: " + lfu.getPageFaultCount());
			break;
		case 4:
			MFU mfu = new MFU();
			for(int i = 0; i < (stringPages.length); i++){
				mfu.insert(stringPages[i]);
			}
			System.out.println("Page Faults: " + mfu.getPageFaultCount());
			break;
		case 5:
			Otimo otimo = new Otimo();
			for(int i = 0; i < (stringPages.length); i++){
				otimo.insert(stringPages);
			}
			System.out.println("Page Faults: " + otimo.getPageFaultCount());
			break;*/
		case 6:
			RandomReplacement random = new RandomReplacement();
            for(int i = 0; i < page.length; i++){
                random.fetch(Integer.parseInt(page[i]));
            }
            random.displayStats();
            random.displayCache();
			
		}
		scan2.close();
		scan1.close();
	}

}

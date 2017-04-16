import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Digite as paginas selecionadas, separando-as por ',': ");
		Scanner scan1 = new Scanner(System.in);
		String page = scan1.nextLine();
		
		System.out.println("Digite a quantidade de frames de memória disponíveis: ");
		Scanner scan2 = new Scanner(System.in);
		int quant = scan2.nextInt();
		String[] stringPages = page.split(",");
		
		System.out.println("Escolha a função desejada:");
		System.out.println("1 - Fetch");
		System.out.println("2 - Evict");
		System.out.println("3 - Display Cache");
		System.out.println("4 - Display Stats");
		Scanner scan3 = new Scanner(System.in);
		
		System.out.println("Escolha o algoritmo a ser usado:");
		System.out.println("1 - FIFO");
		System.out.println("2 - LRU");
		System.out.println("3 - LFU");
		System.out.println("4 - MFU");
		System.out.println("5 - Ótimo");
		System.out.println("6 - Random Replacement");
		Scanner scan4 = new Scanner(System.in);
		
		int opt = scan4.nextInt();
		switch(opt){
		case 1:
			Fifo fifo = new Fifo(quant);
			for(int i = 0; i < (stringPages.length); i++){
				fifo.insert(stringPages[i]);
			}
			System.out.println("Page Faults: " + fifo.getPageFaultCount());
			break;
		case 2:
			LRU lru = new LRU(quant);
			for(int i = 0; i < (stringPages.length); i++){
				lru.insert(stringPages[i]);
			}
			System.out.println("Page Faults: " + lru.getPageFaultCount());
			break;
		case 3:
			LFU lfu = new LFU(quant);
			for(int i = 0; i < (stringPages.length); i++){
				lfu.insert(stringPages[i]);
			}
			System.out.println("Page Faults: " + lfu.getPageFaultCount());
			break;
		case 4:
			MFU mfu = new MFU(quant);
			for(int i = 0; i < (stringPages.length); i++){
				mfu.insert(stringPages[i]);
			}
			System.out.println("Page Faults: " + mfu.getPageFaultCount());
			break;
		case 5:
			Otimo otimo = new Otimo(quant);
			for(int i = 0; i < (stringPages.length); i++){
				otimo.insert(stringPages);
			}
			System.out.println("Page Faults: " + otimo.getPageFaultCount());
			break;
		case 6:
			RandomReplacement random = new RandomReplacement(quant);
			for(int i = 0; i < (stringPages.length); i++){
				random.insert(stringPages[i]);
			}
			System.out.println("Page Faults: " + random.getPageFaultCount());
			break;
		}
	}

}

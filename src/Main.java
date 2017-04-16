import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Digite as paginas selecionadas, separando-as por ',': ");
		Scanner scanner1 = new Scanner(System.in);
		String page = scanner1.nextLine();
		System.out.println("Digite a quantidade de frames de memória disponíveis: ");
		Scanner scanner2 = new Scanner(System.in);
		int quant = scanner2.nextInt();
		String[] stringPages = page.split(",");
		System.out.println("Escolha o algoritmo a ser usado:");
		System.out.println("1 - FIFO");
		System.out.println("2 - LRU");
		System.out.println("3 - LFU");
		System.out.println("4 - MFU");
		System.out.println("5 - Ótimo");
		Scanner scanner3 = new Scanner(System.in);
		int opt = scanner3.nextInt();
		switch(opt){
		case 1:
			Fifo fifo = new Fifo(quant);
			for(int i = 0; i < (stringPages.length - 1); i++){
				fifo.insert(stringPages[i]);
			}
			System.out.println("Page Faults: " + fifo.getPageFaultCount());
			break;
		case 2:
			LRU lru = new LRU(quant);
			for(int i = 0; i < (stringPages.length - 1); i++){
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
			for(int i = 0; i < (stringPages.length - 1); i++){
				mfu.insert(stringPages[i]);
			}
			System.out.println("Page Faults: " + mfu.getPageFaultCount());
			break;
		case 5:
			Otimo otimo = new Otimo(quant);
			for(int i = 0; i < (stringPages.length - 1); i++){
				otimo.insert(stringPages);
			}
			System.out.println("Page Faults: " + otimo.getPageFaultCount());
			break;
		}
	}

}

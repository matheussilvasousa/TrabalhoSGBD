import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Digite as paginas selecionadas, separando-as por ',': ");
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		String file = scan1.nextLine();
        String[] page = file.split(",");
        int loop = 1;
        while(loop == 1){
			System.out.println("Escolha o algoritmo a ser usado:");
			System.out.println("1 - FIFO");
			System.out.println("2 - LRU");
			System.out.println("3 - LFU");
			System.out.println("4 - MRU");
			System.out.println("5 - Clock");
			System.out.println("6 - Random Replacement");			
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
			case 3:
				LFU lfu = new LFU();
				for(int i = 0; i < page.length; i++){
		            lfu.fetch(Integer.parseInt(page[i]));
		        }
		        lfu.displayStats();
		        lfu.displayCache();
		        break;
			case 4:
				MRU mru = new MRU();
				for(int i = 0; i < page.length; i++){
		            mru.fetch(Integer.parseInt(page[i]));
		        }
		        mru.displayStats();
		        mru.displayCache();
		        break;
			case 5:
				Clock clock = new Clock();
		        for(int i = 0; i < page.length; i++){
		            clock.fetch(Integer.parseInt(page[i]));
		        }
		        clock.displayStats();
		        clock.displayCache();
		        break;
			case 6:
				RandomReplacement random = new RandomReplacement();
		        for(int i = 0; i < page.length; i++){
		            random.fetch(Integer.parseInt(page[i]));
		        }
		        random.displayStats();
		        random.displayCache();
				
			}
			System.out.println("Deseja escolher uma nova política? 1-Sim, 2-Não");
			loop = scan3.nextInt();
			while(loop != 1 && loop != 2){
				System.out.println("Opção inválida! Digite novamente: ");
				scan3 = new Scanner(System.in);
				loop = scan3.nextInt();
			}
			
        }
        scan3.close();
        scan2.close();
		scan1.close();
	}

}

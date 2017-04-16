import java.util.HashMap;

public class Buffer {
	
	HashMap<Integer,String> cache;
	
	public Buffer(){
		cache = new HashMap<Integer,String>();
	}

	public String fetch(int chave){
		String valor = null;
		if(cache.containsKey(chave)){
			valor = cache.get(chave);
		} else{
			//Aqui é onde ele faz a busca no arquivo
		}
		return valor;
	}
	
	public void evict(){
		
	}
	
	public void displayCache(){
		for(int valor : cache.keySet()){
			System.out.println("Chave: " + valor + ", valor: " + cache.get(valor));
		}
	}
	
	public void displayStats(){
		
	}
	
}

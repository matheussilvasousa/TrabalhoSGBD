import java.util.HashMap;
  		  
abstract class Buffer {
  			  	
	HashMap<Integer,String> cache;
  			  	
	public String fetch(int chave){
		String valor = null;
  		if(cache.containsKey(chave)){
  			valor = cache.get(chave);
  		} else{
 			//Aqui é onde ele faz a busca no arquivo
  		}
  		return valor;
  	}		  	
  			  	
	abstract void evict();

	public void displayCache(){

	}
	 
	abstract void displayStats();

}
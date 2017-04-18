
public class Page {

	protected int key;
	protected String value;
	
    public Page(){}
        
	public Page(int key, String value){
            this.key = key;
            this.value = value;
	}

	public int getKey() {
            return key;
	}

	public void setKey(int key) {
            this.key = key;
	}
	
	public String getValue(){
            return value;
	}
	
	public void setValue(String value){
            this.value = value;
	}

}

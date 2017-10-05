public class servercheck{
	public static void main(String[] args){
	
		String hostname = "isprod2";

		String PRODHOST1="isprod1";
		String PRODHOST2="isprod2";

		if(hostname.contains(PRODHOST1) || hostname.contains(PRODHOST2)){
			System.out.println("PROD:"+hostname);
		}


	}
}

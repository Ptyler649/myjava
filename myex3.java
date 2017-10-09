public class myex3{
	static {
		x=15;
	}
	myex3(){
		x=5;
	}
	static int x = 0;

	public static void main(String[] args){
		myex3 mec = new myex3();
		System.out.println(x);
	}

	static {
		x = 10;
	}

}

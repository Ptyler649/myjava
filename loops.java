import java.util.*;

public class loops{
	public static void main(String[] args){
		
		int a = 0;
		while (a < 10){
			System.out.println(a);
			a++;	
		}

		int b = 0;
		do{
			System.out.println("do while:"+b);
			b++;
		}	
		while(b < 10);

		for(int x = 0; x < 10; x++){
			System.out.println("for:"+x);
		};

		List<Integer> xx = new ArrayList<Integer>();
		xx.add(1);
		xx.add(20);
		xx.add(500);

		int count = 0;
		for(Integer test : xx){
			System.out.println("new for loop:"+test+":"+count);
			count++;
		}
		System.out.println("how big is array:"+xx.size());		

		// break and continue ?

		label:
		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				System.out.println("y:"+y);
				if(y > 5){
					continue label;
				}
			}
		};


		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				System.out.println("y:"+y);
				if(y > 5){
					System.out.println("break");
					break;
				}
			}
		};

 int x = 0;
    x += 1.1;    // just fine; hidden cast, x = 1 after assignment
   // x = x + 1.1; // won't compile! Eclipse says 'cannot convert from double to int



	}
}

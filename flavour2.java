public class flavour2{
	public static void main(String[] args)
	{
		System.out.println("anonynmous class flavour 2");
		
		// traditional
		//flavour2 f = new flavour2();
		//f.gogo(f);
		
		// flav 2
		flavour2 f = new flavour2();
		f.gogo(new flavour2()
		{
			void go()
			{
				System.out.println("mmmm");
			}
		}
		);
		
	}
	
	void go()
	{
		System.out.println("go");
	}
	
	void gogo(flavour2 f)
	{
		f.go();
	}
}
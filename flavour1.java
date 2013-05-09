public class flavour1{
	public static void main(String[] args)
	{
		System.out.println("flavour 1 of anonymous class");
				
		flavour1 my = new flavour1()
		{
			void go()
			{
				System.out.println("gogog");
			}
		};
		
		my.go();
	}
	
	void go()
	{
		System.out.println("go");
	}

}
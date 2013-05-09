interface test
{
	public void method1();
}

public class flavour3{
	public static void main(String[] args)
	{
		System.out.println("flavour3");
		t.method1();
	}
	
	static test t = new test()
	{
		public void method1()
		{
			System.out.println("heyyyyyyyyyyyyyyyyyyyyy");
		}
	};
}
interface test {public void method1();}

public class scrappy{
	public static void main(String[] args)
	{
		System.out.println("main");

		// Call anonymous class flavour 1
		scrappy a = new scrappy()
		{
			void flav1()
			{
				System.out.println("Flavour 1 NEW!");
			}
		};
		a.flav1();

		// Call anonymous class flavour 2 using args
		scrappy b = new scrappy();
		b.gogo(new scrappy()
		{
			void go()
			{
				System.out.println("Flavour 2 NEW!");
			}
		}
		);

		// Call anonymous class flavour 3 using interface and 
		// static variable
		t.method1();
	}

	static test t = new test()
	{
		public void method1()
		{
			System.out.println("Flavour 3 NEW!");
		}
	};


	void flav1()
	{
		System.out.println("Flavour 1");
	}

	void flav2()
	{
		System.out.println("Flavour 2");
	}

	void flav3()
	{
		System.out.println("Flavour 3");		
	}


	void go()
	{
		System.out.println("go");
	}

	void gogo(scrappy s)
	{
		s.go();
	}




}

public class meteor{
	public static void main(String[] args)
	{
		System.out.println("Meteor - fireball");
		
		// Traditional
		//meteor mymeteor = new meteor();
		//mymeteor.go();
		
		// Anonymous inner class call
		meteor mymeteor = new meteor()
		{
			void go()
			{
				System.out.println("very very big fireball viewing, my first ever");
			}
		};
		
		mymeteor.go();
		
	}

	void go()
	{
		System.out.println("big fireball");
	}
	
}
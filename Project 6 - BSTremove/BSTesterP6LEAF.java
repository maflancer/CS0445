public class BSTesterP6LEAF
{
	public static void main( String[] args ) throws Exception
	{
		BSTreeP6<String> tree1 = new BSTreeP6<String>( args[0] );
		System.out.format( "\ntree1: loaded from %s contains %d nodes on %d levels:\n", args[0], tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();
		int[] levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );
		
		
		// REMOVE LEAF
		tree1.remove( "Z" );
		
		System.out.format( "\ntree1: after removing Z contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );
		

		tree1.remove( "X" );



				System.out.format( "\ntree1: after removing X contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );

				tree1.remove( "V" );



				System.out.format( "\ntree1: after removing V contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );


				tree1.remove( "S" );



				System.out.format( "\ntree1: after removing S contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );

				tree1.remove( "Q" );



				System.out.format( "\ntree1: after removing Q contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );

				tree1.remove( "O" );



				System.out.format( "\ntree1: after removing O contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );

				tree1.remove( "L" );



				System.out.format( "\ntree1: after removing L contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );

				tree1.remove( "J" );



				System.out.format( "\ntree1: after removing J contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );

				tree1.remove( "H" );



				System.out.format( "\ntree1: after removing H contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );
		

				tree1.remove( "E" );



				System.out.format( "\ntree1: after removing E contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );


				tree1.remove( "B" );



				System.out.format( "\ntree1: after removing B contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );


				tree1.remove( "Y" );



				System.out.format( "\ntree1: after removing Y contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );

		tree1.remove( "W" );



				System.out.format( "\ntree1: after removing W contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );


		tree1.remove( "A" );



				System.out.format( "\ntree1: after removing A contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );

		tree1.remove( "C" );



				System.out.format( "\ntree1: after removing C contains %d nodes on %d levels:\n", tree1.countNodes(), tree1.countLevels() );
		System.out.print("IN ORDER tree1:    "); tree1.printInOrder();
		System.out.print("LEVEL ORDER tree1: "); tree1.printLevelOrder();	
		levelCounts = tree1.calcLevelCounts();
		System.out.println();
		for (int i = 0 ; i<levelCounts.length; ++i )
			System.out.format("level:%2d   %d\n",i,levelCounts[i] );

	}
}
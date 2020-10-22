import java.io.*;
import java.util.*;

public class Knapsack
{
	private static int[] numbers;
	private static int sum;
	private static int total;

	public static void main( String [] args) throws Exception
	{
		loadFromFile(args[0]);

		int bitmap = 0;

		while(bitmap < 0xffff)
		{
			total = 0;
			for(int i = 0; i < 16; i++)
			{
				if(  (bitmap >> i) % 2  == 1)
				{
					total += numbers[i];
				}
			}
			if(total == sum)
			{
				for(int i = 0; i < 16; i++)
				{
					if( (bitmap >> i) % 2 ==1)
					{
						System.out.print(numbers[i] + " ");
					}
				}
				System.out.print("\n");
			}
			bitmap++;
		}
	}

	public static void loadFromFile(String filename ) throws Exception
    {
        Scanner infile = new Scanner( new File( filename) );
        numbers = new int [16];

        for(int i = 0; i < 16; i++)
        {
        	numbers[i] = Integer.parseInt(infile.next());
        	System.out.print(numbers[i] + " ");
        }

        sum = Integer.parseInt(infile.next());
        System.out.println("\n" + sum);
    }
}


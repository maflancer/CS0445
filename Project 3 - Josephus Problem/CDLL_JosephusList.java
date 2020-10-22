import java.io.*;
import java.util.*;

public class CDLL_JosephusList<T>
{
	private CDLL_Node<T> head;  // pointer to the front (first) element of the list
	private int count=0;
	// private Scanner kbd = new Scanner(System.in); // FOR DEBUGGING. See executeRitual() method 
	public CDLL_JosephusList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FORM INCOMING FILE
	
	public CDLL_JosephusList( String infileName ) throws Exception
	{
		BufferedReader infile = new BufferedReader( new FileReader( infileName ) );	
		while ( infile.ready() )
		{	@SuppressWarnings("unchecked") 
			T data = (T) infile.readLine(); // CAST CUASES WARNING (WHICH WE CONVENIENTLY SUPPRESS)
			insertAtTail( data ); 
		}
		infile.close();
	}
	

	
	// ########################## Y O U   W R I T E / F I L L   I N   T H E S E   M E T H O D S ########################
	
	// TACK ON NEW NODE AT END OF LIST
	@SuppressWarnings("unchecked")
	public void insertAtTail(T data)
	{
		CDLL_Node<T> newNode = new CDLL_Node( data,null,null);
		if (head==null)
		{
			newNode.next=newNode;
			newNode.prev=newNode;
			head = newNode;
			return;
		}

		newNode.next = head;
		newNode.prev = head.prev;

		newNode.prev.next = newNode;
		newNode.next.prev = newNode;

		head = newNode;	

		head = head.next;
	}

	
	public int size()
	{	
		count = 0;
		if(head == null)
		{
			return 0;
		}
		CDLL_Node<T> curr = head;

		do
		{
			count++;
			curr = curr.next;
		}
		while(curr != head);

		return count;
	}
	
	// RETURN REF TO THE FIRST NODE CONTAINING  KEY. ELSE RETURN NULL
	public CDLL_Node<T> search( T key )
	{	
		CDLL_Node<T> curr = head;
		do
		{
			if(curr.data.equals(key))
			{
				return curr;
			}
			curr = curr.next;
		}
		while(curr != head);

		return null;
	}
	
	// RETURNS CONATENATION OF CLOCKWISE TRAVERSAL
	@SuppressWarnings("unchecked")
	public String toString()
	{
		CDLL_Node<T> curr = head;
		String concat = "";

		do
		{	
			concat += curr.data;
			if(curr.next != head)
			{
				concat += "<=>";
			}
			curr = curr.next;
		}
		while(curr != head);

		return concat;
		
	}
	
	void removeNode( CDLL_Node<T> deadNode )
	{
		deadNode.prev.next = deadNode.next;
		deadNode.next.prev = deadNode.prev;
	}
	
	public void executeRitual( T first2Bdeleted, int skipCount )
	{
		int direction = 0;
		String d = "";
		if (size() < 1 ) return;
		CDLL_Node<T> curr = search( first2Bdeleted );
		if ( curr==null ) return;

		if(skipCount > 0)
		{
			direction = 0;
			d = "CLOCKWISE";
		}
		else
		{
			direction = 1;
			d = "COUNTER_CLOCKWISE";
		}
		
		// OK THERE ARE AT LEAST 2 NODES AND CURR IS SITING ON first2Bdeleted
		do
		{
			CDLL_Node<T> deadNode = curr;
			T deadName = deadNode.data;

			if(direction == 0)
			{
				curr = curr.next;
			}
			if(direction == 1)
			{
				curr = curr.prev;
			}
			
			if(head == deadNode)
			{
				head = curr;
			}
			// ** println( "stopping on Misurda to delete Misurda");

			System.out.println("stopping on " + deadName + " to delete " + deadName);
			
			// remove the deadNode
			this.removeNode(deadNode);

			System.out.println("deleted. list now:   " + this.toString());
			
			// if the list size has reached 1 break out of this loop YOU ARE DONE 
			if(this.size() == 1)
			{
				break;
			}
			
			// ** println("resuming at Mosse, skipping Mosse + 4 nodes CLOCKWISE after");
			System.out.println("resuming at " + curr.data + ", skipping " + curr.data + " + " + (Math.abs(skipCount) - 1) + " nodes " + d + " after");

			// write loop that advance curr skipCount times (be sure of CLOCKWISE or COUNTER)
			int count = skipCount;
			if(direction == 0)
			{
				while(count > 0)
				{
					curr = curr.next;
					count--;
				}
			}
			if(direction == 1)
			{
				while(count < 0)
				{
					curr = curr.prev;
					count++;
				}
			}
			
			// String junk = kbd.nextLine();  <= MIGHT FIND THis HELPFUL. FOR DEBUGGING. WAITS FOR YOU TO HIT RETUN KEY
			
		}
		while (size() > 1 );

	}
	
} // END CDLL_LIST CLASS

class CDLL_Node<T>
{
  T data; // DONT DEFINE MEMBERS AS PUBLIC OR PRIVATE
  CDLL_Node<T> prev, next; //
  CDLL_Node() 		{ this( null, null, null ); }
  CDLL_Node(T data) { this( data, null, null);  }
  CDLL_Node(T data, CDLL_Node<T> prev, CDLL_Node<T> next)
  {	this.data=data; this.prev=prev; this.next=next;
  }
  public String toString() // TOSTRING MUST BE PUBLIC
  {	return ""+data;
  }
}

import java.io.*;
import java.util.*;

public class LinkedList<T> 
{
	private Node<T> head;  // pointer to the front (first) element of the list

	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FORM INCOMING FILE
	@SuppressWarnings("unchecked")	
	public LinkedList( String fileName, boolean orderedFlag )
	{
		head=null;
		try
		{
			BufferedReader infile = new BufferedReader( new FileReader( fileName ) );
			while ( infile.ready() )
			{
				if (orderedFlag)
					insertInOrder( (T)infile.readLine() );  // WILL INSERT EACH ELEM INTO IT'S SORTED POSITION
				else
					insertAtTail( (T)infile.readLine() );  // TACK EVERY NEWELEM ONTO END OF LIST. ORIGINAL ORDER PRESERVED
			}
			infile.close();
		}
		catch( Exception e )
		{
			System.out.println( "FATAL ERROR CAUGHT IN C'TOR: " + e );
			System.exit(0);
		}
	}

	//-------------------------------------------------------------

	// inserts new elem at front of list - pushing old elements back one place
	public void insertAtFront(T data)
	{
		head = new Node<T>(data,head);
	}

	// we use toString as our print


	public String toString()
	{
		String toString = "";

		for (Node curr = head; curr != null; curr = curr.getNext())
		{
			toString += curr.getData();		// WE ASSUME OUR T TYPE HAS toString() DEFINED
			if (curr.getNext() != null)
				toString += " ";
		}

		return toString;
	}

	// ########################## Y O U   W R I T E    T H E S E    M E T H O D S ########################

	
	public int size() // OF COURSE MORE EFFICIENT TO MAINTAIN COUNTER. BUT YOU WRITE LOOP!
	{
		int count = 0;
		for(Node<T> curr = head; curr != null; curr = curr.getNext())
		{
			count++;
		}

		return count;
	}


	public boolean empty()
	{
		return (size() == 0);
	}

	
	public boolean contains( T key )
	{
		return !(search(key) == null);
	}

	
	public Node<T> search( T key )
	{
		for(Node<T> curr = head; curr != null; curr = curr.getNext())
		{
			if(curr.getData().equals(key))
			{
				return curr;
			}		
		}

		return null;
	}

	
	public void insertAtTail(T data) // TACK A NEW NODE (CABOOSE) ONTO THE END OF THE LIST
	{
		Node<T> newNode = new Node<T>(data);
		if(head == null)
		{ 
			head = new Node<T>(newNode.getData());
		}
		else
		{
			Node<T> last = head;
			for(Node<T> curr = head; curr.getNext() != null; curr = curr.getNext())
			{
				last = curr.getNext();
			}

			last.setNext(newNode);

		}
	}

	@SuppressWarnings("unchecked")
	public void insertInOrder(T  data) // PLACE NODE IN LIST AT ITS SORTED ORDER POSTIOPN
	{
		Comparable cmpKey = (Comparable) data;

		if(this.empty() || cmpKey.compareTo(head.getData()) < 0)
		{
			insertAtFront(data);
			return;
		}

		Node<T> curr = head;

		while( curr.getNext() != null && cmpKey.compareTo(curr.getNext().getData()) > 0)
		{
			curr = curr.getNext();
		}

		if(curr.getNext() == null)
		{
			this.insertAtTail(data);
			return;
		}

		Node<T> newElement = new Node<T>(data, curr.getNext());
		curr.setNext(newElement);
	}
	
	
	public boolean remove(T key) // FIND/REMOVE 1st OCCURANCE OF A NODE CONTAINING KEY
	{
		if(this.empty())
		{
			return false;
		}
		if(head.getData().equals(key))
		{
			this.removeAtFront();
			return true;
		}
		for(Node<T> curr = head; curr.getNext() != null; curr = curr.getNext())
		{
			if(curr.getNext().getData().equals(key) && curr.getNext().getNext() == null)
			{
				this.removeAtTail();
				return true;
			}
			if(curr.getNext().getData().equals(key))
			{
				curr.setNext(curr.getNext().getNext());
				return true;
			}
		}
		return false;

	}

	
	public boolean removeAtTail()	// RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{
		Node <T> curr = head;

		if(curr.getNext() == null)
		{
			head = null;
			return true;
		}

		while(curr.getNext().getNext() != null)
		{
			curr = curr.getNext();
		} 

		curr.setNext(null);
		return true;
	}

	
	public boolean removeAtFront() // RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{
		head = head.getNext();
		return true;
	}


	public LinkedList<T> union( LinkedList<T> other )
	{
		LinkedList<T> union = new LinkedList<T> ();

		for(Node<T> curr = head; curr != null; curr = curr.getNext())
		{
			union.insertInOrder(curr.getData());
		}
		for(Node<T> curr = other.head; curr != null; curr = curr.getNext())
		{
			if(!union.contains(curr.getData()))
			{
				union.insertInOrder(curr.getData());
			}
		}

		return union;
		
	}
	
	
	public LinkedList<T> inter( LinkedList<T> other )
	{
		LinkedList<T> inter = new LinkedList<T> ();

		for(Node<T> curr = head; curr != null; curr = curr.getNext())
		{
			if(other.contains(curr.getData()))
			{
				inter.insertInOrder(curr.getData());
			}
		}

		return inter;

	}


	public LinkedList<T> diff( LinkedList<T> other )
	{
		LinkedList<T> diff = new LinkedList<T> ();
		for(Node<T> curr = head; curr != null; curr = curr.getNext())
		{
			if(!other.contains(curr.getData()))
			{
				diff.insertInOrder(curr.getData());
			}
		}

		return diff;
	}

	
	public LinkedList<T> xor( LinkedList<T> other )
	{
		return union(other).diff(inter(other));
	}

} //END LINKEDLIST CLASS

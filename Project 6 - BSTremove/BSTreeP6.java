import java.io.*;
import java.util.*;

///////////////////////////////////////////////////////////////////////////////
class BSTNode<T>
{	T key;
	BSTNode<T> left,right;
	BSTNode( T key, BSTNode<T> left, BSTNode<T> right )
	{	this.key = key;
		this.left = left;
		this.right = right;
	}
}
///////////////////////////////////////////////////////////////////////////////////////
class Queue<T>
{	LinkedList<BSTNode<T>> queue;
	Queue() { queue =  new LinkedList<BSTNode<T>>(); }
	boolean empty() { return queue.size() == 0; }
	void enqueue( BSTNode<T>  node ) { queue.addLast( node ); }
	BSTNode<T>  dequeue() { return queue.removeFirst(); }
	// THROWS NO SUCH ELEMENT EXCEPTION IF Q EMPTY
}
////////////////////////////////////////////////////////////////////////////////
class BSTreeP6<T>
{
	private BSTNode<T> root;
	private int nodeCount;
	private boolean addAttemptWasDupe=false;
	private int check;

	public BSTreeP6()
	{
		nodeCount = 0;
		root=null;
	}

	@SuppressWarnings("unchecked")
	public BSTreeP6( String infileName ) throws Exception
	{
		nodeCount = 0;
		root=null;
		Scanner infile = new Scanner( new File( infileName ) );
		while ( infile.hasNext() )
			add( (T) infile.next() ); // THIS CAST RPODUCES THE WARNING
		infile.close();
	}

	// DUPES BOUNCE OFF & RETURN FALSE ELSE INCR COUNT & RETURN TRUE
	@SuppressWarnings("unchecked")
	public boolean add( T key )
	{	addAttemptWasDupe=false;
		root = addHelper( this.root, key );
		return !addAttemptWasDupe;
	}
	@SuppressWarnings("unchecked")
	private BSTNode<T> addHelper( BSTNode<T> root, T key )
	{
		if (root == null) return new BSTNode<T>(key,null,null);
		int comp = ((Comparable)key).compareTo( root.key );
		if ( comp == 0 )
			{ addAttemptWasDupe=true; return root; }
		else if (comp < 0)
			root.left = addHelper( root.left, key );
		else
			root.right = addHelper( root.right, key );

		return root;
  } // END addHelper

	public int size()
	{
		return nodeCount; // LOCAL VAR KEEPING COUNT
	}

	public int countNodes() // DYNAMIC COUNT ON THE FLY TRAVERSES TREE
	{
		return countNodes( this.root );
	}
	private int countNodes( BSTNode<T> root )
	{
		if (root==null) return 0;
		return 1 + countNodes( root.left ) + countNodes( root.right );
	}

	// INORDER TRAVERSAL REQUIRES RECURSION
	public void printInOrder()
	{
		printInOrder( this.root );
		System.out.println();
	}
	private void printInOrder( BSTNode<T> root )
	{
		if (root == null) return;
		printInOrder( root.left );
		System.out.print( root.key + " " );
		printInOrder( root.right );
	}

	public void printLevelOrder()
	{
		if (this.root == null) return;
		Queue<T> q = new Queue<T>();
		q.enqueue( this.root ); // this. just for emphasis/clarity
		while ( !q.empty() )
		{	BSTNode<T> n = q.dequeue();
			System.out.print( n.key + " " );
			if ( n.left  != null ) q.enqueue( n.left );
			if ( n.right != null ) q.enqueue( n.right );
		}
	}

  public int countLevels()
  {
    return countLevels( root );
  }
  private int countLevels( BSTNode root)
  {
    if (root==null) return 0;
    return 1 + Math.max( countLevels(root.left), countLevels(root.right) );
  }

  public int[] calcLevelCounts()
  {
    int levelCounts[] = new int[countLevels()];
    calcLevelCounts( root, levelCounts, 0 );
    return levelCounts;
  }
  private void calcLevelCounts( BSTNode root, int levelCounts[], int level )
  {
    if (root==null)return;
    ++levelCounts[level];
    calcLevelCounts( root.left, levelCounts, level+1 );
    calcLevelCounts( root.right, levelCounts, level+1 );
  }

  /////////////////////////////////////////////////
  // WRITE THE REMOVE METHOD 
  // return true only if it finds/removes the node
  public boolean remove( T key2remove )
  {
  	check = 1;
  	BSTNode<T> parent = findRefToParent(key2remove);
  	BSTNode<T> curr;
	int direction;

  	if(parent == null)
  	{
  		return false;
  	}

  	if(parent.left != null && parent.left.key.equals(key2remove))
  	{
  		curr = parent.left;
  		direction = 0;
  	}
  	else
  	{
  		curr = parent.right;
  		direction = 1;
  	}

  	if(root.left == null && root.right == null && root.key.equals(key2remove))
  	{
  		root = null;
  	}

  	if(parent.key.equals(key2remove))
  	{
  		curr = parent;
  	}

  	if(curr.left == null && curr.right == null) //checks if curr is a leaf  -  CASE 1
  	{
  		if(parent.right != null && parent.right.key.equals(key2remove))
  		{
  			parent.right = null;
  		}
  		else
  		{
  			parent.left = null;
  		}

  		return true;
	}


	if(curr.left != null && curr.right == null || curr.right != null && curr.left == null || parent == root) //checks if curr has one child  -  CASE 2
	{
		if(parent == root && direction == 0 && check == 0)
		{
			root = root.left; 
		}
		else if(parent == root && direction == 1 && check == 0)
		{
			root = root.right;
		}
		else
		{
			if(direction == 0)
			{
				if(curr.right != null)
				{
					parent.left = curr.right;
				}
				else
				{
					parent.left = curr.left;
				}
			}
			else
			{
				if(curr.right != null)
				{
					parent.right = curr.right;
				}
				else
				{
					parent.right = curr.left;
				}
			}	
		}
		return true;
	}

	if(curr.left != null && curr.right != null) //checks if curr has two children  -  CASE 3 
	{
		BSTNode<T> replacementNode = findPredecessor(curr.left);

		T temp = replacementNode.key;

		remove(temp);

		curr.key = temp;

		return true;
	}

	return false;

  }

  @SuppressWarnings("unchecked")
  public BSTNode<T> findRefToParent(T key)
  {
  	BSTNode<T> parent = null;

  	BSTNode<T> curr = root;

  	while(curr != null && !curr.key.equals(key))
  	{
  		parent = curr;

  		if(((Comparable)key).compareTo(curr.key) < 0)
  		{
  			curr = curr.left;
  		}
  		else
  		{
  			curr = curr.right;
  		}
  	}

  	if(curr == null)
  	{
  		return null;
  	}
  	if(curr == root)
  	{
  		check = 0;
  		return root;
  	}
  	return parent;
  }
  
  public BSTNode<T> findPredecessor(BSTNode<T> curr)
  {
  	while(curr.right != null)
  	{
  		curr = curr.right;
  	}
  	return curr;
  }


} // END BSTREEP6 CLASS
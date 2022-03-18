
import java.util.ArrayList;
import java.util.Iterator;

abstract public class GenericList<I> implements CreateIterator<I>, Iterable<I> {
	private int length;   //two private data member
	private Node<I> head;
	
	//Inner class Node
	class Node<T>{
		T data;
		Node<T> next;
		Node(T a){
			data =a;
			next =null;
		}
	}
    public GenericList(){
    	length =0;
    	
    }
    // 2 abstract methods that child classes should overwrite. 
    public abstract I delete();
    public abstract void add(I data);
    
    //  abstract methods in interface clarified 
    public Iterator<I> createIterator() {
    	Iterator<I> iter = new GLIterator<I>(head); // implement Iterator<I> with our head pass
    	return iter;
    }
    public Iterator<I> iterator(){
    	System.out.println("iterator()");
    	return new GLIterator<I>(head);
    }   
    
    //put elements of nodes in list, and set head = null;
    public ArrayList<I> dumpList(){
    	Node<I> h = head;
    	ArrayList<I> list = new ArrayList<I>();
    	while(h!=null) {
    		list.add(h.data);
    		h = h.next;
    	}
    	head =null;
    	setLength(0);
    	return list;
    	
    }
    public int getLength() {
    	return length;
    }
    public void setLength(int l) {
    	length =l;
    }
    public Node<I> getHead(){
    	return head;
    }
    public void setHead(Node<I> h) {
    	head =h;
    }
   
    
    
}

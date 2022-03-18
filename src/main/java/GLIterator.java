import java.util.Iterator;
public class GLIterator<I> implements Iterator<I> {
	GenericList<I>.Node<I> head;
	public GLIterator(GenericList<I>.Node<I> h) {
		// TODO Auto-generated constructor stub
		
		head = h; //copy the current head pointer. 
		
	}
	//check if there is a next elements 
	public boolean hasNext() {
		// if head is null or 1 element, return false; 
		if(head==null) {
			//System.out.println("hasNext() list is empty");
			return false;
			
		}
		
		else {
			//System.out.println("hasNext()"+head.data);
			return true;
		}
	}
	//advance head to next node and return data. 
	public I next() {
		// if head is null or 1 element, return null; 
		if(head==null) {
			//System.out.println("next() list is empty");
			return null;
			
		}

		else {
			//System.out.println("next()");
			I value  =  head.data;
			head = head.next;
			return value;
		}
	}

}

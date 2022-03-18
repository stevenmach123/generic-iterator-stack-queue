
//GenericQueue inherit GenericLists with additional write of abstract methods 
public class GenericQueue<I> extends GenericList<I> {
	Node<I> tail;
	public GenericQueue(I a) {
		// TODO Auto-generated constructor stub			
		Node<I> init = new Node<I>(a);		
		setHead(init);	
		tail = init; //tail to add nodes at rear 
		setLength(getLength()+1);	
	}
	
	public void add(I d){
		Node<I> n = new Node<I>(d);
		if(getHead()==null) {
			tail = n;
			setHead(n);
		}
		else {
			tail.next = n;
			tail = n;
			
		}
		setLength(getLength()+1);

		
	}
	////First in, first out 
	public I delete() {
		if(getHead() !=null) {
			Node<I> h = getHead();
			setHead(h.next);
			if(h.next ==null) {
				tail = null;
			}
			setLength(getLength()-1);
			return h.data;
		}
		else {
			System.out.println("GenericQueue.delete() is already empty");
			return null;
		}
		
	}
	public void enqueue(I data){
		add(data);
	}
	public I dequeue() {
		return delete();
	}
}

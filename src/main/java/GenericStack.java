
public class GenericStack<I> extends GenericList<I> {
	
	public GenericStack(I a) {
		// TODO Auto-generated constructor stub			
		Node<I> init = new Node<I>(a);		
		setHead(init);		
		setLength(getLength()+1);	
	}
	//First in, Last out
	public void add(I d) {
		Node<I> init = new Node<I>(d);
		init.next = getHead();
		setHead(init);	
		setLength(getLength()+1);	
	}
	
	public I delete() {
		if(getHead()!=null) {
			Node<I> h = getHead();
			setHead(h.next);
			setLength(getLength()-1);
			return h.data;
		}
		else {
			System.out.println("GenericStack.delete() is already empty");
			return null;
		}
		
	}
	//add() is support of push();
	void push(I data){
		add(data);
	}
	//delete() is support of add();
	public I pop(){
		
		return delete();
	}
	

}

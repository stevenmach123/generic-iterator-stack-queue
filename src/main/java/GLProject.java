import java.util.Iterator;

import java.util.ArrayList;
public class GLProject   {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericStack<Integer> s1 = new GenericStack<Integer>(2);
		s1.push(4);
		s1.push(6);
		s1.push(8);
		
		GenericStack<Integer> s2= s1;
		
		/* ArrayList<Integer> t_s1 = s1.dumpList();
		for(Integer a: t_s1) {
			System.out.println(a);
		}        */ 
		/*
		Iterator<Integer> iter = s2.createIterator(); 
		for(int i=0;i<6;i++) {
			if(iter.hasNext() != false) {
				 System.out.println(iter.next());
			}
		}   
		
		
		while(s2.getHead()!=null) {
			System.out.println(s2.pop()+" "+s2.getLength());		
		}
		
		System.out.println("s2 length "+s2.getLength());
		s2.pop();
		s2.push(10);
		s2.push(12);
		System.out.println(s2.pop() + " "+s2.getLength());
		System.out.println(s2.pop()+" "+s2.getLength());	
		
		*/
		
		/*
		GenericQueue<Integer> q1 = new GenericQueue<Integer>(1);
		q1.add(3);
		q1.add(5);
		q1.add(7);
		
		GenericQueue<Integer> q2= q1;
						
		while(q2.getHead()!=null) {
			System.out.println(q2.dequeue()+" "+q2.getLength());		
		}
		
		System.out.println("q length "+q1.getLength()+" "+q2.getLength());
		System.out.println(q2.getHead()+ " "+q2.getHead() );
		q2.dequeue();
		q2.enqueue(11);
		q2.enqueue(13);
		System.out.println(q2.dequeue()+" "+q2.getLength());		
		System.out.println(q2.dequeue()+" "+q2.getLength());		
		
		
		*/
		
		
		
		
		GenericQueue<Integer> q1 = new GenericQueue<Integer>(1);
		q1.add(3);
		q1.add(5);
		q1.add(7);
		for(Integer a: q1) {
			System.out.println(a);
		}   
		
		Iterator<Integer> iter =  q1.iterator();
		System.out.println(iter.next());
		
		
		//Iterator<Integer> a = new GenericList<Integer>(1);
		q1.forEach((Integer name) -> {
	            System.out.println(name);
	        });   
		
		
		
		
	}    

}

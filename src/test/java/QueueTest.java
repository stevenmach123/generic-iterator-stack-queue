import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QueueTest {

	GenericQueue<Integer> q;
	
	
	@BeforeEach
	void init() {
		q = new GenericQueue<Integer>(2);

	}
	
	@Test

	void testclass() {
	
		assertEquals("GenericQueue", q.getClass().getName(),"init failed on GQ");   
	}
	
	@Test
	void en10() { // add 10 element on array, and loop to compare single nodes on queue.  
		
		Integer[] p = new Integer[10];			
		p[0] =2;
		for(int i=1;i<=9;i++) {
			q.enqueue(2+i*2); //arranged 2 4 6 8 10
			p[i] = 2+i*2; // add 2 4 6 8 10
		}
		ArrayList<Integer> t = q.dumpList();
		for(int i=0;i<0;i++) {
			assertEquals(p[i],t.get(i),"wrong push10() @"+i);
			
		}
	}
	@Test 
	void en10de5() { //do enqueue and dequeue,then compare q arrays and expected array
		ArrayList<Integer> p = new ArrayList<>();
	    
	    
		for(int i=1;i<=9;i++) {
			q.enqueue(2+i*2);	
		}
		for(int i=12;i<=20;i+=2) {
			q.dequeue();	
			p.add(i);
		}	
		ArrayList<Integer> t = q.dumpList();
		
		assertArrayEquals(p.toArray(),t.toArray(), "wrong push10pop5()");
		
	}
	@Test 
	void enAlldeAll() { ////concern if successively delete all elements 
		
		ArrayList<Integer> p = new ArrayList<>();
		
		for(int i=1;i<=9;i++) {
			q.enqueue(2+i*2);	
		}
		for(int i=1;i<11;i++) {
			Integer num = 2*i;
			assertTrue(num.equals(q.dequeue()), "pushAllpopAll() @"+i);	
		}
		ArrayList<Integer> t = q.dumpList();

		assertTrue(t.equals(p), "wrong pushAllpopAll() Array");
		
	}
	@Test 
	void en_de_en_de() {//do enqueue and dequeue interchange, then test a final delete.	
		for(int i=1;i<=9;i++) {
			q.enqueue(2+i*2);	
		}
		for(int i=1;i<6;i++) {
		
			assertEquals(2*i,q.dequeue(),"wrong dequeue @"+i);
		}
		for(int i=1;i<=3;i++) {
			q.enqueue(1);	
		}
		assertEquals(12,q.dequeue(),"12 not deleted");
		
	}
	@Test 
	void en_deAll_en(){ //case concern with renovate nodes after deletes all nodes.
		for(int i=1;i<=3;i++) {
			q.enqueue(2+i*2);	
		}
		for(int i=0;i<4;i++) {
			q.dequeue();	
		}
		for(int i=1;i<=3;i++) {
			q.enqueue(i*2);	
		}
		assertNotNull(q.getHead());
		
		ArrayList<Integer> t = q.dumpList();
		Integer[] p = {2,4,6};
		assertArrayEquals(p,t.toArray(),"wrong en_deAll_en() ");
	}
	@Test 
	void checkArrayListLength() { //check length of arrayList 
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		ArrayList<Integer> t = q.dumpList();
		assertEquals(3+1,t.size());
	}
		
	@Test 
	void sameObject() { // check head successfully passed to stack or queue
		GenericList<Integer> a = q; 
		assertSame(a,q);
		assertSame(q.getHead(),a.getHead());		
	}
    
	@ParameterizedTest   //do new test concern what head value after head supposed to null when list empty
	@ValueSource(ints = {4,6,8,9})	
	void repeatNull(Integer v){
		q.enqueue(v);
		assertNotNull(q.getHead());
		q.dequeue();
		q.dequeue();
		assertNull(q.getHead());
	}
   

}

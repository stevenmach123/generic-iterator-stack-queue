import static org.junit.jupiter.api.Assertions.*;



import java.util.ArrayList;

import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.jupiter.ArrayComparisonFailure;

class ListTest {
	
	GenericStack<Integer> s;
	@BeforeEach
	void init() {
		s = new GenericStack<Integer>(2);

	}
	
	@Test

	void testclass() {
		
		assertEquals("GenericStack", s.getClass().getName(),"init failed on GS");   
	}
	/*
	
	@Test
	void push10() {  // add 10 element on array, and loop to compare single nodes on stack.  
		
		Integer[] p = new Integer[10];			
		p[0] =2;
		for(int i=1;i<=9;i++) { // add 2 4 6 8 10
			s.push(2+i*2);
			p[i] = 2+i*2;
		}
		ArrayList<Integer> t = s.dumpList();
		for(int i=10;i>0;i--) {
			assertEquals(p[i-1],t.get(10-i),"wrong push10() @"+i);
			
		}
	}
	@Test 
	void push10pop5() {	//do push and pop,then compare s arrays and expected array
		ArrayList<Integer> p = new ArrayList<>();
	    
	    
		for(int i=1;i<=9;i++) {
			s.push(2+i*2);	
		}
		for(int i=10;i>0;i-=2) {
			s.pop();	
			p.add(i);
		}	
		ArrayList<Integer> t = s.dumpList();
		
		assertArrayEquals(p.toArray(),t.toArray(), "wrong push10pop5()");
		
	}
	@Test 
	void pushAllpopAll() { //concern if success pop all elements 
		
		ArrayList<Integer> p = new ArrayList<>();
		
		for(int i=1;i<=9;i++) {
			s.push(2+i*2);	
		}
		for(int i=0;i<10;i++) {
			s.pop();	
		}
		ArrayList<Integer> t = s.dumpList();

		assertTrue(t.equals(p), "wrong pushAllpopAll()");
		
	}
	@Test 
	void push_pop_push_pop() { //do push and pop interchange, then test a final pop.
		for(int i=1;i<=9;i++) {
			s.push(2+i*2);	
		}
		for(int i=0;i<6;i++) {
		
			assertEquals(20-2*i,s.pop(),"wrong pop @"+i); //check elements poped on middle way of ll
		}
		for(int i=1;i<=3;i++) {
			s.push(10+2*i);	
		}
		assertEquals(16,s.pop(),"16 not poped");
		
	}
	@Test 
	void push_popAll_push(){ // case concern with renovate nodes after deletes all nodes.
		for(int i=1;i<=3;i++) {
			s.push(2+i*2);	
		}
		for(int i=0;i<4;i++) {
			s.pop();	
		}
		for(int i=1;i<=3;i++) {
			s.push(i*2);	
		}
		assertNotNull(s.getHead());
		
		ArrayList<Integer> t = s.dumpList();
		Integer[] p = {6,4,2};
		assertArrayEquals(p,t.toArray(),"wrong push_popAll_push() ");
	}
	@Test 
	void checkArrayListLength() { //check length of arrayList 
		s.push(1);
		s.push(2);
		s.push(3);
		ArrayList<Integer> t = s.dumpList();
		assertEquals(3+1,t.size());
	}
		
	@Test 
	void sameObject() { // check head successfully passed to stack or queue
		GenericList<Integer> a = s; 
		assertSame(a,s);
		assertSame(s.getHead(),a.getHead());		
	}
    
	@ParameterizedTest
	@ValueSource(ints = {4,6,8,9})	//do new test concern what head value after head supposed to null when list empty
	void repeatNull(Integer v){
		s.add(v);
		assertNotNull(s.getHead());
		s.pop();
		s.pop();
		assertNull(s.getHead());
	}
   */
   

}  


	
  
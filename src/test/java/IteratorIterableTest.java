import static org.junit.jupiter.api.Assertions.*;



import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import java.util.Random; 


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Iterator;

import org.junit.jupiter.api.RepeatedTest;



class IteratorIterableTest{
	

	GenericStack<Integer> s = new GenericStack<Integer>(2);
	GenericQueue<Integer> q = new GenericQueue<Integer>(2);
	Iterator<Integer> iterQ ; 
	Iterator<Integer> iterS;
   @BeforeEach
   void ElementsAdd() { //add 2 4 6 8 10
	   for(int i=1;i<=4;i++) {
		   s.add(2+2*i);
		   q.add(2+2*i);
	   }
	    
   }
  
   @BeforeEach
   void iterCreated(){    
	    iterQ = q.createIterator();
	    iterS = s.createIterator();
	   assertEquals("GLIterator", iterQ.getClass().getName(),"init failed on iterQ");
	   assertEquals("GLIterator", iterS.getClass().getName(),"init failed on iterS");
   }
   
   @Test 
   void basic() {   //if success advance to next element
	   assertEquals(2,iterQ.next());
	   assertEquals(10,iterS.next());
	   
   }
   
   @Test
   void iter4Elements() {   //do basic next() successively
	   for(int i=0;i<4;i++) {
		   assertEquals(2*(i+1),iterQ.next())  ;
	   }
	   
	   for(int i=0;i<4;i++) {
		   assertEquals(10-2*(i),iterS.next())  ;
	   }
	   
   }
   
  @Test 
  void hasNext4_next(){ //test hasNext() and next() work good together before next() on null edge
	  for(int i=0;i<4;i++) { // at 4 iteration, head on last nodes
		  
		  assertTrue(iterQ.hasNext());
		  assertTrue(iterS.hasNext());
		  iterQ.next();
		  iterS.next();
	  }
	  
  }
  @Test
  void hasNext_edge() { // similar to hasNext4_next
	  for(int i=0;i<4;i++) {
		  iterQ.hasNext();
		  iterQ.next();
	  }
	  assertTrue(iterQ.hasNext());//hasNext() do last true, 
	  assertEquals(10,iterQ.next()); //return last node,head =null
	  assertFalse(iterQ.hasNext()); 
  }
  @Test
  void Queue_NextofLastValue(){// after hasNext_edge(), now do hasNext() until null edge, while next() to test how queue arranged in GLIterator  
	  int i=2;
	  while(iterQ.hasNext()==true) {
		  assertEquals(i,iterQ.next());
		  i +=2;
	  }
  }
  @Test
  void Stack_NextofLastValue(){// do hasNext() until null edge, while next() to test how queue arranged in GLIterator 
	  int i=10;
	  while(iterS.hasNext()==true) {
		  assertEquals(i,iterS.next());
		  i -=2;
	  }
  }
  @Test
  void foreach() { //foreach iterable test
	  int z =0;
	 
	  for(Integer a : s) { // similar to foreach, but able to check single elements with for
		  assertEquals(10-2*z,a);
		  z++;
	  }
	  z=0;
	  for(Integer b : q) {
		 assertEquals(2+2*z,b);
		 z++;
		 
	  }
	  
	  s.forEach((Integer i) -> {
		  System.out.println(i);
      });  
	  q.forEach((Integer i) -> {
		  System.out.println(i);
      }); 
	
	  
  }
  
  
   @RepeatedTest(20)
   void StressTest() {  // let do stress on add() of both stack and queue, but advance head by next() 
	    GenericQueue<Integer> q1;
	    GenericStack<Integer> s1;
	    s1 = new GenericStack<Integer>(2);
	    q1 = new GenericQueue<Integer>(2);
	    
	   
	   
	   ArrayList<Integer> l  = new  ArrayList<Integer>();
	   l.add(2);
	   Random random = new Random();
	   int x= random.nextInt(20-7)+7;
	   int ele;  
	   
	   for(int i=0;i<x;i++) {
		  ele = random.nextInt(100)+100;
		  l.add(ele);
		  s1.push(ele);
		  q1.enqueue(ele);
	   }
	   
	   Iterator<Integer> iters1 = s1.createIterator();
	   Iterator<Integer> iterq1  =q1.createIterator();
	   
	   for(int i=0;i<x+1;i++) {
		  assertTrue(iters1.hasNext());
		  
		  assertEquals(l.get(x-i),iters1.next(),"falseS @"+i);
		  assertEquals(l.get(i),iterq1.next(),"falseQ @"+i);
	  }
	   assertFalse(iters1.hasNext());
	   
	   
   }
   
   
   
}
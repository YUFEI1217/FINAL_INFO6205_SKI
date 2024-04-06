package edu.neu.dataStore;import java.util.Arrays;import java.util.EmptyStackException;/**    A class of stacks whose entries are stored in an array.*/public class ArrayStack<T> implements StackInterface<T>{   private T[] stack;    // Array of stack entries   private int topIndex; // Index of top entry   private boolean initialized = false;   private static final int DEFAULT_CAPACITY = 50;   private static final int MAX_CAPACITY = 10000;     public ArrayStack()   {      this(DEFAULT_CAPACITY);   } // end default constructor     public ArrayStack(int initialCapacity)   {      checkCapacity(initialCapacity);            // The cast is safe because the new array contains null entries      @SuppressWarnings("unchecked")      T[] tempStack = (T[])new Object[initialCapacity];      stack = tempStack;      topIndex = -1;      initialized = true;   } // end constructor     /**     * Throws an exception if this object is not initialized.    */   private void checkInitialization()   {       if (!initialized)            throw new SecurityException("ArrayBag object is not initialized properly.");   }      // Throws an exception if the client requests a capacity that is too large.   private void checkCapacity(int capacity)   {      if (capacity > MAX_CAPACITY)         throw new IllegalStateException("Attempt to create a bag whose " +                                         "capacity exeeds allowed " +                                         "maximum of " + MAX_CAPACITY);   } // end checkCapacity      public void push(T newEntry)   {      checkInitialization();      ensureCapacity();      stack[topIndex + 1] = newEntry;      topIndex++;   } // end push   private void ensureCapacity()   {      if (topIndex >= stack.length - 1) // If array is full, double its size      {         int newLength = 2 * stack.length;         checkCapacity(newLength);         stack = Arrays.copyOf(stack, newLength);      } // end if   } // end ensureCapacity   public T pop()   {      checkInitialization();      if (isEmpty())         throw new EmptyStackException();      else      {         T top = stack[topIndex];         stack[topIndex] = null;         topIndex--;         return top;      } // end if   } // end pop   public T peek()   {      checkInitialization();      if (isEmpty())         throw new EmptyStackException();      else         return stack[topIndex];   } // end peek   public boolean isEmpty()   {      return topIndex < 0;   }  // end isEmpty   public void clear() {	  // ADD YOUR CODE HERE	   	   while(!isEmpty( )) {		   pop();	   }	     }      public String toString(){	   	  // ADD YOUR CODE HERE	   	   String result = "stack contain: ";	   for(int i = 0; i <= topIndex; i++) {		   result += stack[i] + " ";	   }	   	   return result;      }      public static void main(String[] args){		  // ADD YOUR CODE HERE	   	   ArrayStack<String> newStack = new ArrayStack<String>();	   	   newStack.push("Apple");	   newStack.push("Orange");	   newStack.push("Banana");	   System.out.println(newStack.toString());	   newStack.clear();	   System.out.println(newStack.toString());	      }  } // end ArrayStack
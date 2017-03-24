package StacksAndQueues;

import java.io.*;
import java.util.*;

/*
 * Implement a class "MyQueue" which implements a queue using two stacks
 *
 * Methods (must have at least these. you may add more): 
 *  size(): returns an int of the queue's size
 *  add(T value): adds an element to the queue
 *  peek(): returns the value at the front of the queue
 *  remove(): removes the value at the front of the queue
 */

class MyQueue<T> {
  
    /*for quicker sequences of adds or removes, I will keep one empty at all times*/
    
    /*not empty when adding*/
    public Stack<T> stackOrder = new Stack<>();
  
    /*not empty when removing or peeking?... maybe*/
    public Stack<T> queueOrder = new Stack<>();
  
  
    /**
    * empty contents of Stack a into Stack b
    */
    public void pourStackAintoStackB(Stack<T> a, Stack<T> b){
      while(!a.empty()){
       b.push(a.pop()); 
      }   
    }


    public T peek(){
        if(!stackOrder.empty()){
          this.pourStackAintoStackB(stackOrder,queueOrder);
        }
      return queueOrder.peek();
    }
  
    public void add(T a){
        if(!queueOrder.empty()){
          this.pourStackAintoStackB(queueOrder,stackOrder);
        }
        stackOrder.push(a);
    }
  
    public T remove(){
        if(!stackOrder.empty()){
          this.pourStackAintoStackB(stackOrder,queueOrder);
        }
        return queueOrder.pop();
    }
  
    public int size(){
      if(!stackOrder.empty()){
          return stackOrder.size();
      }else{
          return queueOrder.size();
      }
    }
  
    public String toString(){
      if(!stackOrder.empty()){
          this.pourStackAintoStackB(stackOrder,queueOrder);
        }
      
      StringBuilder queueSTR = new StringBuilder();
      
      
      while(!queueOrder.empty()){
        T element = queueOrder.pop();
        queueSTR = queueSTR.append("\n"+"["+element.toString()+"]");
        stackOrder.push(element); 
      }  
      
     return queueSTR.toString();
    }
  








  public static void main(String[] args) {
    
    MyQueue<String> q = new MyQueue<>();
    
     q.add("1");
     q.add("2");
     q.add("3");
     q.add("4");
     q.add("5");
    
    
    System.out.println(q);
    System.out.println("Size is: "+q.size());
    
    String firstInLine = q.remove();
    
    System.out.println("The first removed: "+firstInLine);
    System.out.println("Size is: "+q.size());
    
    q.add("X");
    
    System.out.println(q);
    System.out.println("Size is: "+q.size());
    
    System.out.println("peeking: "+q.peek());
    System.out.println("Size is: "+q.size());
    
  }
}

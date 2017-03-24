package DP;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


class LinkedListDP {
  
  public HashMap<Node, HashMap<Node, Boolean>> memo = new HashMap<>();
  
  public class Node{
    public Node next;
    public int data;
    
    public Node(int data){
     this.data = data; 
    }
    
    public String toString(){
     return data+""; 
    }
  }
  
  public void putInMemo(Node a, Node b, Boolean value){
    
    if(a == null || b == null)
      return;
    
      HashMap<Node, Boolean> map = memo.get(a);
    
      if(map == null){
        map = new HashMap<>(); 
      }
    
      map.put(b,value);
      memo.put(a,map);
  }
  
  public Boolean getMemoValue(Node a, Node b){
    return memo.get(a).get(b);
  }
  
  public Boolean inMemo(Node a, Node b){
    
    if(a == null || b == null)
      return false;
   
    HashMap<Node, Boolean> map = memo.get(a);
    
    if(map == null){
      return false;
    }else{
      return true;    
    }
    
  }

  
  public boolean intersect(Node list1, Node list2){
    
    if(inMemo(list1,list2)){
     return getMemoValue(list1,list2);
    }
    
    if(list1 != null && list2 != null)
      System.out.println(list1 +" =?= "+ list2);

    if(list1 != null){
        if(list1 == list2){
            return true;
        }else{
            boolean found1 = false;
            boolean found2 = false;
            boolean found3 = false;
          
            if(list1 != null){
              found1 = intersect(list1.next, list2);
              this.putInMemo(list1.next,list2, found1);
            }
          
            if(list2 != null){
              found2 = intersect(list1, list2.next);
              this.putInMemo(list1,list2.next, found2);
            }
          
            if(list1 != null && list2 != null){
              found3 = intersect(list1.next, list2.next);
              this.putInMemo(list1.next,list2.next, found3);
            }
          
          
          
          return found1 || found2 || found3;
        }
    }
    
     
    return false;
    
     
      
      
  }
  
  
  public boolean NodeRefsEqual(Node z, Node q){
    return z == q;
  }
  
  public static void main(String[] args) {

    LinkedListDP s = new LinkedListDP();
    
    //list 1
     Node a = s.new Node(1);
     Node b = s.new Node(2);
     Node c = s.new Node(3);
     Node d = s.new Node(4);
     Node e = s.new Node(5);
    
     a.next = b;
     b.next = c;
     c.next = d;
     d.next = e;
    
    
    
//     //list 2
     Node a2 = s.new Node(6);
     Node b2 = s.new Node(7);
     Node c2 = s.new Node(8);
     Node d2 = s.new Node(9);
     Node e2 = s.new Node(10);
    
     a2.next = b2;
     b2.next = c2;
     c2.next = d2;
     d2.next = e2;
    
    
    System.out.println(s.intersect(a,a2));
    
    

    
    
  }
}

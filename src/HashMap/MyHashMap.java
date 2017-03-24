package HashMap;

import java.io.*;
import java.util.*;

/*
 * Create a Hash Map where the keys are strings
 */



  class MyHashMap{
  
  int lengthOfArray = 11;//some prime

  Node[] array = new Node[lengthOfArray]; // I guess we can not create  generic arrays...

  
  int primeFactor = 31;//magic prime giving more distirbution of keys = less collisions
  
  public MyHashMap(){
   Arrays.fill(array,null); 
  }
    
    
    //just trying linked list for now
    //need to store keys with all data so that if there is a collision
    // we can make a list
  class Node{
    Object data;
    String key;
    Node next;
    
    public String toString(){
     StringBuilder sb = new StringBuilder("("+key+" : "+data.toString()+")");
      
      if(next != null){
       sb.append(" -> "+next.toString()); 
      }
      
      return sb.toString();
      
    }
  }
    
  public void insert(Node head, Node newTail){
    
    Node temp = head;
    Node current = temp;
    while(temp != null){
     current = temp;
     temp = temp.next; 
    }
    
    current.next = newTail;
  }

 
  public void put(String key, Object object){
    int hashValue = mapStringToIndex(key,lengthOfArray);
    
    
    Node node = new Node();
    node.data = object;
    node.key = key;
    
    Node head = array[hashValue];
    //collision detection
    if(head == null){
      array[hashValue] = node;
    }else{
      this.insert(head, node);
    }

  }
    
  public Object get(String key){
    int hashValue = mapStringToIndex(key,lengthOfArray);
    
    Node head = array[hashValue];
    
    Node temp = head;
    while(temp != null){
     if(temp.key.equals(key)){
       break;
     }
      temp = temp.next;
    }
    
    return temp.data;
    
  }
  
  
  public int mapStringToIndex(String key, int mod){
   
    long score = 0;
    int size = key.length();
    
    for(char c: key.toCharArray()){
      //playing with different score functions
      //score = += c*(int)Math.pow(10,size)*primeFactor;
      // same code when compiled though :/ but looks nicer!
      score += c*Math.pow(10,size); // haha, thanks... you are right
      size = size-1;
    }
    
    return (int)(score%mod);
    
  }
  
  public String toString(){
    StringBuilder sb = new StringBuilder("");
    
    for(int i = 0;i < lengthOfArray; i++){
      sb.append("["+array[i]+"]"+"\n");
    }

    return sb.toString();
  }




  
  public static void main(String[] args){
   
    
    MyHashMap map = new MyHashMap();
    
    map.put("dog", new SomeObject("Frank"));
    
    System.out.println(map);
    
    map.put("cat", new SomeObject("Ted"));
    
    System.out.println("Get value at key: dog");
    
    System.out.println(map);
    
    SomeObject obj = (SomeObject)map.get("dog");
    
    System.out.println("Got value: "+obj);
    
    
    map.put("dogd", new SomeObject("Frank2"));
    
    System.out.println(map);
    
    
    SomeObject obj2 = (SomeObject)map.get("dogd");
    System.out.println("Got value: "+obj2);
    
    SomeObject obj3 = (SomeObject)map.get("cat");
    System.out.println("Got value: "+obj3);
    
    
  }

}
  
  class SomeObject{
	  
	  String name;
	  SomeObject(String name){
	   this.name = name; 
	  }
	  
	  public String toString(){
	   return name; 
	  }
	}


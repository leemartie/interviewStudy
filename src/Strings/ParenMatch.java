package Strings;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class ParenMatch {
  
  /**
  *
  *Given a string containing just the characters 
  *'(', ')', '{', '}', '[' and ']', determine if the input    string is valid.
  */
  public static boolean valid(char[] str, int index,
                                   int p1Left, int p1Right,  
                                   int p2Left, int p2Right, 
                                   int p3Left, int p3Right){
    
    
    //failure conditions... basically no way to close a right
    //when you have too many lefts
    if(p1Right < p1Left)
      return false;
    if(p2Right < p2Left)
      return false;
    if(p3Right < p3Left)
      return false;
    
    //parsed everything successfully 
    if(index >=str.length)
      return true;
    
    
    char p = str[index];
    
    if(p == '(')
      p1Left--;
    if(p == ')')
      p1Right--;
   
    if(p == '{')
      p2Left--;
    if(p == '}')
      p2Right--;
    
    if(p == '[')
      p3Left--;
    if(p == ']')
      p3Right--;
    
    
    index++;
    
    return valid(str, index, p1Left,p1Right,p2Left,p2Right,p3Left,p3Right);
    
    
    
  }
  
  public static boolean valid(String str){
    char[] s = str.toCharArray();
    int index = 0;
    int p1Left = count(s,'(');
    int p1Right = count(s,')');
    
    int p2Left = count(s,'{');
    int p2Right = count(s,'}');
    
    int p3Left = count(s,'[');
    int p3Right = count(s,']');
    
    if(p1Left != p1Right || p2Left != p2Right || p3Left != p3Right)
      return false;
    else return valid(s,index,p1Left,p1Right,p2Left,p2Right,p3Left,p3Right);
    
    
  }
  
  
  public static int count(char[] s, char comp){
   int count = 0;
    for(char ch: s){
      if(ch == comp)
        count++;
    }
    return count;
  }
  
  
  public static boolean valid2(String str){
   char [] chars = str.toCharArray();
    
    Stack<Character> stack = new Stack<Character>();
    
    for(char c: chars){
     
      if(c == '{' || c == '(' || c == '['){
        stack.push(c);
      }else{
        
        if(stack.empty())
          return false;
        
        
        char peek = stack.peek();
        
        if((peek == '{' && c == '}') || (peek == '[' && c == ']') || (peek == '(' && c == ')')){
         stack.pop(); 
        }else{
         return false; 
        }
        
        
      }
      
      
    }
    
    //:)
    // hehe, gotta simplify that code
    // although i forgot if empty or isempty is the correct method
    //I think  they are the same
    // yeah, i think so too
    return stack.empty();
    
    
  }
  
  
  //done?
  // can you think of a data structure that would be good for this question?
  //hmm...
  // maybe a data structure that once you find the end brace, you don't need
  // to check the beginning brace?

  
  // so for example, in [({})], once you get to }, all you need to check is 
  // if the previous one is a {
  // if so, then you can completely ignore the curly braces and focus on the 
  // other ones
  // then check that ) closes (
  // then check that ] closes [
  //
  //
  // I think i see... 
  // [(]) <-- is this valid? k no
  // then i think a stack might work :) winner!
  // you could push onto the stack when you see [, (, or {
  // and you can pop when you see }, ), ]
  // and check that what you popped matches what the closing brace is using
  // a map
  // ill try to code this 
  public static void main(String[] args) {
   System.out.println(valid("[]"));
    
    System.out.println(valid("()"));
    
    System.out.println(valid("{}"));
    
    System.out.println(valid("}{"));
    
    System.out.println(valid("{}]"));
    
    System.out.println(valid("[({})]"));
    
    
    
    
    System.out.println("=================");
    
    
    
    System.out.println(valid2("[]"));
    
    System.out.println(valid2("()"));
    
    System.out.println(valid2("{}"));
    
    System.out.println(valid2("}{"));
    
    System.out.println(valid2("{}]"));
    
    System.out.println(valid2("[({})]"));
    
  }
}


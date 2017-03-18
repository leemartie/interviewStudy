package CountingChoicesWithRecursion;

import java.io.*;
import java.util.*;

/*
 * Start time: 2:24
 * End time: 3:24
 *
 * Given the following menu:
 *
 * Name                Price
 * Mixed Fruit         2.15
 * French Fries        2.75
 * Side Salad          3.35
 * Hot Wings           3.55
 * Mozzarella Sticks   4.20
 * Sampler Plate       5.80
 *
 * Find all combinations of items that will be worth exactly 15.05.
 * You may use items more than once in a combination.
 */

class CountingMenuItems {
  
  

	  
	  

	  /**
	  *items on the menu
	  */
	  public class MenuItem implements Comparable<MenuItem>{
	   public String name;
	   public int price;
	    
	    public MenuItem(String name, int price){
	      this.name = name;
	      this.price = price;
	    }
	    
	    public String toString(){
	     return name+" "+price; 
	    }
	    
	    public int hashCode(){
	     return name.hashCode();
	    }
	    
	    public boolean equals(Object o){
	     if(o instanceof MenuItem){
	      MenuItem temp = (MenuItem)o;
	       
	       if(temp.name.equals(this.name) && temp.price == this.price){
	        return true; 
	       }
	     }
	      return false;
	    }
	    
	    public int compareTo(MenuItem other){
	     return name.compareTo(other.name);
	    }
	    
	    
	  }
	  
	  /*menu*/
	  public ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	  
	  /**
	  *populate the menu
	  */
	  public void init(){
	    menu.add(new MenuItem("Mixed Fruit",215));
	    menu.add(new MenuItem("French Fries",275));
	    menu.add(new MenuItem("Side Salad",335));
	    menu.add(new MenuItem("Hot Wings",355));
	    menu.add(new MenuItem("Mozzarella Sticks",420));
	    menu.add(new MenuItem("Sampler Plate",580));
	  }
	  

	  /*matching combos equaling targetPrice*/
	  public ArrayList<ArrayList<MenuItem>> matchingCombos = new ArrayList<>();
	  
	  int targetPrice = 1505;
	  
	  /**
	  * Sum a list of menu items
	  * 
	  */
	  public int total(ArrayList<MenuItem> items){
	    int total = 0;
	    
	    for(MenuItem item: items){
	     total = total+item.price; 
	    }
	    
	    return total;
	  }
	  
	  /**
	  * Finding those combos now... super size?
	   *unique solutions needed...
	  */
	  public void findThoseCombos(ArrayList<MenuItem> combo, ArrayList<MenuItem> menu){
	   
	  //  System.out.println(combo);
	    
	    if(total(combo) > targetPrice){
	     return; // sad times! 
	    }else if(total(combo) == targetPrice){
	     // System.out.println("order found "+total(combo));
	     matchingCombos.add(combo); 
	      return; // food!
	    }

	    
	    //combination with repetition so j==i
	    for(int i = 0; i< menu.size(); i++){
	      combo.add(menu.get(i));
	      
	      ArrayList<MenuItem> subMenu = new ArrayList<MenuItem>();
	      for(int j = i;j<menu.size(); j++){
	       subMenu.add(menu.get(j)); 
	      }
	      
	      findThoseCombos(new ArrayList<MenuItem>(combo), subMenu);
	      combo.remove(menu.get(i));
	    }
	    
	    
	  }
	  
	  
	  /**
	  * This is a hck...hack is fine
	  */
	  public HashSet<ArrayList<MenuItem>> getUnique(ArrayList<ArrayList<MenuItem>> combos){
	    HashSet<ArrayList<MenuItem>> uniqueItems = new HashSet<>();
	    
	    for(ArrayList<MenuItem> combo: combos){
	      
	      Collections.sort(combo);
	      
	      uniqueItems.add(combo);
	      
	    }
	    
	    return uniqueItems;
	  }
	  
	  public void printNice(ArrayList<ArrayList<MenuItem>> combos){
	   
	    for(ArrayList<MenuItem> combo: combos){
	     System.out.println(combo); 
	    }
	    
	  }
	  
	    public void printNice(HashSet<ArrayList<MenuItem>> combos){
	   
	    for(ArrayList<MenuItem> combo: combos){
	     System.out.println(combo); 
	    }
	    
	  }
	  
	  
	  
	  public static void main(String[] args) {
	    
		  CountingMenuItems s = new CountingMenuItems();
	    s.init();
	    
	    System.out.println("menu");
	    System.out.println(s.menu);
	    
	    System.out.println("--========================--");
	    System.out.println("found combos: ");
	    s.findThoseCombos(new ArrayList<MenuItem>(), s.menu);
	    s.printNice(s.matchingCombos);
	    
	    //This is a filter hack..... :|
	    //s.printNice(s.getUnique(s.matchingCombos));
	    

	  }
}

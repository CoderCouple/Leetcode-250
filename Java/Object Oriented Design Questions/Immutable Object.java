import java.lang.Math;
import java.util.*;

final class Immuatble
{
  private final double PI;
  private final String Name;
  private final int value=5;
  private final ArrayList<Integer> list;
  
  public Immuatble(){
  	PI=3.14;
    Name="Sunil";
    list = new ArrayList<Integer>();
    list.add(value);
  }
  
  public Immuatble(double PI,String Name,int value){
  	this.PI=PI;
    this.Name=Name;
    list = new ArrayList<Integer>();
    list.add(value);
  }
  
  public double getPI(){
  		return PI;
  }
  
  public String getName(){
  		return Name;
  }
  
  public ArrayList<Integer> getList(){
   		ArrayList<Integer> copy = new ArrayList<Integer>();
    	copy.addAll(list);
  		return copy;
  }
  
}


public class Helper{

  public static void main(String args[]){
  	  Immuatble obj = new Immuatble();
      System.out.println(obj.getPI());
      System.out.println(obj.getName());
      System.out.println(Arrays.toString(obj.getList().toArray()));
    
      ArrayList<Integer> temp = obj.getList();
      temp.add(2);
  	  System.out.println(Arrays.toString(temp.toArray()));
      System.out.println(Arrays.toString(obj.getList().toArray()));
  }
 
}

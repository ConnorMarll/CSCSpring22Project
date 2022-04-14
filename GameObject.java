import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import java.io.*;
import java.awt.event.*;
public class GameObject 
{
   //create protected variables 
   protected int x;
   protected int y;
   protected Color color;
   //create array lists of arraylists
   ArrayList<ArrayList<GameObject>> map = new ArrayList<ArrayList<GameObject>>();
   ArrayList<GameObject> innerList = new ArrayList<GameObject>();
   //create game object method
   public GameObject(int x, int y, Color color)
   {
      this.x=x;
      this.y=y;
      this.color=color;
      
   
   
   }
   //create collides method 
   public boolean collides(GameObject go)
   {
     
      if ((go.getX()==x)&&
          (go.getY()==y)&&
          (go.getColor()==color))
         return false;
      
      else
      {
         int topthis = y+13;
         int bottomthis = y-12;
         int leftthis = x-13;
         int rightthis = x+12;
         int topother = go.getY()+13;
         int bottomother = go.getY()-12;
         int leftother = go.getX()-13;
         int rightother = go.getX()+12;
         return !((bottomthis < topother) ||
                                  (topthis > bottomother) ||
                                  (leftthis > rightother) ||
                                  (rightthis < leftother));
                
      }
   }
   //get x point
   public int getX()
   {
      return x;
   }
  //get y point 
   public int getY()
   {    
      return y;
   }
  //get color 
   public Color getColor()
   {
      return color;
   }
   
  
  //draw the background 
   public void draw(Graphics g)
   {
      g.setColor(getColor());
      g.fillRect(getX()+10,getY()+10, 25, 25);
   
   
   }
  



}

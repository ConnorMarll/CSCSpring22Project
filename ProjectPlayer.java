import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class ProjectPlayer extends GameObject 
{
   
   //create player constuctor for the player object
   public ProjectPlayer (int x, int y, Color color)
   {
      super(x,y,color);
      
      
   } 
   
   boolean ground = false;
   int X=super.getX()/25;
   int Y=super.getY()/25;
 
   //create is on ground method to check if it is on the ground 
   public boolean isOnGround(ArrayList<ArrayList<GameObject>> map)//take in array list of array list 
   {
      
      if(ProjectPlayer.super.collides(map.get(X).get(Y-1)))//call the collides method from game object
      {
         y=y-1;
         ground=false;//if it collides return false
         return ground;
         
         
      }
      else
         y=y-1;
      ground=true;
      return ground;
         
   
   
   
   }
    //create move method that looks at area around it so it doesnt collide
   public boolean move(int h, int v, ArrayList<ArrayList<GameObject>> map)
   {
      boolean horizontal;
      boolean vertical;
      x=x+h;
      y=y+v;
      if (h==0)  
      { 
         horizontal= true;
      }
      else if (ProjectPlayer.super.collides(map.get(Y).get(X)))
      {
         x=x+h;
         return false;
      }
      else 
      {
         horizontal= true;
      }
      
      y=v+y;
      if (v==0)
      {
         vertical= true;
      }
      else if (ProjectPlayer.super.collides(map.get(Y).get(X)))
      {
         y=y+v;
         return false;
      }
      else
      {
         vertical=true;
      }
      return (horizontal && vertical);
      
   }
     
      
   //create collides method for player class
   public boolean collides(ArrayList<ArrayList<GameObject>> map)
   {
      if(
         (ProjectPlayer.super.collides((map.get(Y+1).get(X))) || (ProjectPlayer.super.collides(map.get(Y-1).get(X))) ||
         (ProjectPlayer.super.collides(map.get(Y).get(X+1)) ||
         ProjectPlayer.super.collides(map.get(Y).get(X-1)) ||
         ProjectPlayer.super.collides(map.get(Y+1).get(X+1))||
         ProjectPlayer.super.collides(map.get(Y-1).get(X+1))||
         ProjectPlayer.super.collides(map.get(Y+1).get(X-1))||
         ProjectPlayer.super.collides(map.get(Y-1).get(X-1)))))
         return true;
      else
         return false;
   }
   
   
  
   
  
    
  





}


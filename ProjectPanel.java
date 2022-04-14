import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ProjectPanel extends JPanel
{
   //instantiate player 
   ProjectPlayer player;
   
   //create variables for panel
   int ySize;
   int xSize;
   int playerX;
   int playerY;
         //initialize the array list of array lists
   ArrayList<ArrayList<GameObject>> map = new ArrayList<ArrayList<GameObject>>();
   ArrayList<GameObject> innerList = new ArrayList<GameObject>();//create array list 
      
   public ProjectPanel()
   {
   
      super();
      //add keylistener and timer to take in keybaord inputs 
      addKeyListener(new KeyEventDemo());
      setFocusable(true);
      Timer t = new Timer(10, new TimeListener());
      
      
     //try to make sure file works
      try
      {
         Scanner read = new Scanner(new File("projectfile.txt"));
         playerX=read.nextInt();
         playerY=read.nextInt();
           
           
         xSize=read.nextInt();
         ySize=read.nextInt();
         
               //fill array
         for(int i=0; i<xSize;i++)
         {
            map.add(innerList);
                  
         } 
              
         for (int i=0; i<xSize; i++)
         {
            for(int j=0; j<ySize; j++)
            {
               int check=read.nextInt();  
               //create player box
               if (i==playerX && j==playerY)
               {
                  player = new ProjectPlayer(playerX*25,playerY*25,Color.RED);
                  
               }
               //create victory box
               else if (check==2)
               {
                  GameObject victory = new GameObject(j*25,i*25,Color.GREEN);
                  map.get(i).add(victory);
               }
               //create blue boxes 
               else if(check==1)
               {
                  GameObject block = new GameObject(j*25,i*25,Color.BLUE);
                  map.get(i).add(block);
               }
            }
         }
               
      }
      catch (FileNotFoundException fnfe)//print if there is a file error 
      {
         System.out.println("File does not exist");
      }
     
      
   //use a timer 
      t.start();
      setPreferredSize(new Dimension(820,620));    
          
   } 
   //paint component needed      
   public void paintComponent(Graphics g)
   {  
      super.paintComponent(g);
      g.fillRect(0,0,800,10);
      g.fillRect(0,0,10,600);
      g.fillRect(790,0,790,600);
      g.fillRect(0,590,850,650);
      g.setColor(Color.GRAY);
      g.fillRect(10,10,780,580);
   //draw map
      for (int i=0; i<innerList.size(); i++)
      {
         for(int j=0; j<map.size(); j++)
         {
            map.get(j).get(i).draw(g);
         }
      }
      //draw player 
      player.draw(g);
   }
   
      //crearte key board inputs
      //create boolean variables for directions 
   boolean up;
   boolean down;
   boolean right;
   boolean left;
   boolean jump;
   boolean gravity=true;
   
   
   //create key released and typed class
   public class KeyEventDemo implements KeyListener
   {
      public void keyTyped(KeyEvent e){}
      public void keyReleased(KeyEvent e)
      {
         if (e.getKeyCode() == KeyEvent.VK_W)
         {
            up=false;
         }
         if (e.getKeyCode() == KeyEvent.VK_S)
         {
            down=false;
         }
         if (e.getKeyCode() == KeyEvent.VK_A)
         {
            left=false;
         }
         if (e.getKeyCode() == KeyEvent.VK_D)
         {
            right=false;
         }
         repaint();
      } 
       
      public void keyPressed(KeyEvent e)
      {
        
         if (e.getKeyCode() == KeyEvent.VK_W)
         {
            up=true;
         }
         if (e.getKeyCode() == KeyEvent.VK_S)
         {
            down=true;
         }
         if (e.getKeyCode() == KeyEvent.VK_A)
         {
            left=true;
         }
         if (e.getKeyCode() == KeyEvent.VK_D)
         {
            right=true;
         }
         
         repaint();
         
      } 
   
   }
   //crearte action listener to move the player
   public class TimeListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         if (up)//jump up
         {
            player.move(0,-1*7,map);
             
         }
            
         if (down)//go down on s
         {
            player.move(0,1,map);
            
              
         }
         if (left)
         {
            player.move(-1,0,map);//move right
               
         }
         if (right)
         {
            {
               player.move(1,0,map);//move right 
            }
               
             
         }
         else 
         {
            player.move(0,3,map);//else fall for gravity
            
         }
            
         
         repaint();//repaint after
      }
      
      
      
   } 
}
      

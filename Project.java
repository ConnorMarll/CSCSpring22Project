import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class Project extends JFrame 
{

   public Project()
   {
      super("Project");
      Container contents = getContentPane();
       
      contents.add(new ProjectPanel());
      setSize(825,645); 
      setVisible(true); 
           
   }
      
   public static void main(String[] args)
   {
      Project theFrame = new Project();
      theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
}
package frames;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



 
@SuppressWarnings("serial")
public class GraphTablePanel extends JFrame {
	
    Container c;
    int[] data = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] percent = { 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0};
    int[] arc = { 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0};
    Color[] col = { Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.BLACK, Color.CYAN, Color.DARK_GRAY
    		,Color.GREEN, Color.PINK, Color.LIGHT_GRAY};
    String[] score = {
            "0~9", "10~19", "20~29", "30~39", "40~49", "50~59", "60~69", "70~79","80~89", "90~100"
    };
    
   
   ScoreManager s=new ScoreManager();
  
    GraphTablePanel() {
        setTitle("그래프 그리기");
        s.setVisible(false);
        c = getContentPane();
        
       
        c.setLayout(new BorderLayout());

    
        
    
        ChartPanel chartPanel = new ChartPanel();
        c.add(chartPanel, BorderLayout.CENTER);
        
        setBounds(400, 400, 1300, 600);
      
        int sum = 0;
     
        for(int i = 0; i < data.length; i++){
        sum += s.Num().get(i);
        }
        for(int i = 0; i < data.length; i++){
            percent[i] = (int) Math.round((double)s.Num().get(i)/ sum * 100);
            
        }
        for(int i = 0; i < data.length; i++){
            arc[i] = 360 * percent[i] / 100;
        
            
             this.setVisible(true); 
               
        }
    }
 
   
    class ChartPanel extends JPanel {
        ChartPanel() {
            
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int startAngle = 0;
        
            g.setFont(new Font("malgun", Font.BOLD, 15));
            for (int i = 0; i < data.length; i++) {
                g.setColor(col[i]);
                g.drawString(score[i] + ":" + percent[i] 
                + "" + " %", 20 + (i * 120), 50);
                g.fillArc(150, 150, 200, 200, startAngle, arc[i]);
                startAngle += arc[i];
            }
            
        }
    }
 
   
}
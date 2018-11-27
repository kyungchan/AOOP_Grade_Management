package frames;


import java.awt.*;
import java.awt.event.*;
 
import javax.swing.*;
 
 
@SuppressWarnings("serial")
public class GraphTablePanel extends JFrame {
    Container c;
    int[] data = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] percent = { 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0};
    int[] arc = { 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0};
    Color[] col = { Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.BLACK, Color.CYAN, Color.DARK_GRAY
    		,Color.GREEN, Color.PINK, Color.LIGHT_GRAY};
    String[] score = {
            "0~9", "10~19", "20~29", "30~39", "40~49", "50~59", "60~69", "70~79","80~89", "90~100"
    };
    
    JTextField[] textFields = new JTextField[10];
    
    MyActionListener lis = new MyActionListener();
    
    GraphTablePanel() {
        setTitle("그래프 그리기");
        
        c = getContentPane();
        

        c.setLayout(new BorderLayout());

        InputPanel inputPanel = new InputPanel();
        inputPanel.setBackground(Color.LIGHT_GRAY);
        c.add(inputPanel, BorderLayout.NORTH);
        
    
        ChartPanel chartPanel = new ChartPanel();
        c.add(chartPanel, BorderLayout.CENTER);
        
        setBounds(400, 400, 1300, 600);
        setVisible(true);
    }
    
    class MyActionListener implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {

            int sum = 0;
            for(int i = 0; i < data.length; i++){
                String text = textFields[i].getText();
                try{
                data[i] = Integer.parseInt(text);
                } catch(NumberFormatException nfe){
                    textFields[i].setText("0");
                    return;
                }
                sum += data[i];
                System.out.println(data[i]);
            }
            for(int i = 0; i < data.length; i++){
                percent[i] = (int) Math.round((double)data[i] / sum * 100);
                System.out.println(percent[i]);
            }
            for(int i = 0; i < data.length; i++){
                arc[i] = 360 * percent[i] / 100;
                System.out.println(arc[i]);
            }
            repaint();
        }
    }
    
    class InputPanel extends JPanel {
       
        JLabel[] labels = new JLabel[data.length];
        
        
        
        InputPanel() {
            for (int i = 0; i < labels.length; i++) {
                labels[i] = new JLabel(score[i]);
                textFields[i] = new JTextField(5);
                textFields[i].setText("");
                textFields[i].addActionListener(lis);
                add(labels[i]);
                add(textFields[i]);
            }
        }
    }
    
    class ChartPanel extends JPanel {
        ChartPanel() {
            
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int startAngle = 0;
         //   int drawAngle = 90;
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
 

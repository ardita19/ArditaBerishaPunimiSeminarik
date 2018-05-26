
import java.awt.*;
import javax.swing.*;
import java.text.*;

public class AppointmentsWritter extends JPanel
{ private int WIDTH = 500;
    private int DEPTH = 300;
    private int distance;

    private String output = "";
    private String output1 = "";
    private String output2= "";
    private String output3 = "";
    private String output4 = "";
    private String output5 = "";
    private String output6 = "";
    public AppointmentsWritter(String title)
    {
        JFrame my_frame = new JFrame();
        my_frame.getContentPane().add(this);
        my_frame.setTitle(title);
        my_frame.setSize(WIDTH, DEPTH);
        my_frame.setVisible(true);
    }
    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
    public void paintComponent(Graphics g)
    { g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, DEPTH);
        g.setColor(Color.black);
        int text_margin = 50;
        int text_baseline =50;

        drawString(g,output+"\n"+output1+"\n"+output2+"\n"+output3+"\n"+output4+"\n"+output5+"\n"+output6, text_margin, text_baseline );
    }

    public void print(String message,String message1,String message2,String message3,String message4,String message5,String message6)
    {
        output = message + " ";
        output1 = message1 + " ";
        output2 = message2 + " ";
        output3 = message3 + " ";
        output4 = message4 + " ";
        output5 = message5 + " ";
        output6 = message6 + " ";
        this.repaint();
    }
    public void error(String message)
    {
        JOptionPane.showMessageDialog(null,message);
    }
}
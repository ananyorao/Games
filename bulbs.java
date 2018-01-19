import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.Applet;
public class bulbs extends Applet implements KeyListener
{
    byte row[]=new byte[5];
    byte col[]=new byte[5];
    public void init()
    {
        addKeyListener(this);
        requestFocus();        
    }
    public void keyTyped(KeyEvent ke)
    {
        char h=ke.getKeyChar();
        int ch=(int)h-48;
        switch(ch)
        {
            case 0:if(row[ch]==1)row[ch]=0;else row[ch]++;break;
            case 1:if(row[ch]==1)row[ch]=0;else row[ch]++;break;
            case 2:if(row[ch]==1)row[ch]=0;else row[ch]++;break;
            case 3:if(row[ch]==1)row[ch]=0;else row[ch]++;break;
            case 4:if(row[ch]==1)row[ch]=0;else row[ch]++;break;
            case 5:if(col[ch-5]==1)col[ch-5]=0;else col[ch-5]++;break;
            case 6:if(col[ch-5]==1)col[ch-5]=0;else col[ch-5]++;break;
            case 7:if(col[ch-5]==1)col[ch-5]=0;else col[ch-5]++;break;
            case 8:if(col[ch-5]==1)col[ch-5]=0;else col[ch-5]++;break;
            case 9:if(col[ch-5]==1)col[ch-5]=0;else col[ch-5]++;break;
        }
        repaint();
    }
    public void keyPressed(KeyEvent ke)
    {        
    }
    public void keyReleased(KeyEvent ke)
    {
    }    
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(0,0,800,800);
        for(int a=45,b=0;b<5;a+=60,b++)
        {
            g.setColor(Color.white);
            String r=""+b;
            String c=""+(b+5);
            g.drawString(r,20,a);
            g.drawString(c,a,350);
            if(row[b]==1)g.setColor(Color.yellow);
            else g.setColor(Color.black);
            g.drawLine(20,a,300,a);
            if(col[b]==1)g.setColor(Color.yellow);
            else g.setColor(Color.black);
            g.drawLine(a+2,30,a+2,340);
            for(int d=0,y=45;d<5;y+=60,d++)
            {
                g.setColor(Color.yellow);
                if(row[b]==1&&col[d]==1)g.fillOval(y-15,a-15,30,30);
                else{
                    /*g.setColor(Color.red);
                    g.fillOval(y-15,a-15,30,30);*/
                    g.setColor(Color.black);
                    g.drawOval(y-15,a-15,30,30);
                }
            }
        }
    }
}
        
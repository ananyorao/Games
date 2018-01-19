import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.Applet;
public class balls extends Applet implements KeyListener
{
    int key;
    char ch;
    int draw;
    int x=100;
    byte fg=0;
    public void init()
    {
        while(dx1<1||dx1>4){dx1=(int)(Math.random()*10);}
        while(dy1<1||dy1>4){dy1=(int)(Math.random()*10);}
        addKeyListener(this);
        requestFocus();
    }
    public void keyTyped(KeyEvent ke)
    {
        /*ch=ke.getKeyChar();
        t1+=ch;
        if(t1.length()>25)t1="";
        t="key typed";
        repaint();*/
    }
    public void keyPressed(KeyEvent ke)
    {
        if(fg==1)return;
        key=ke.getKeyCode();
        /*if(key==ke.VK_F1)t2="f1 pressed";
        if(key==ke.VK_SHIFT)t3="shift pressed";*/
        if(key==ke.VK_LEFT&&(x>=a1)){x--;}
        if(key==ke.VK_RIGHT&&(x+100<=a2)){x++;}
        //t="key pressed";
        repaint();
    }
    public void keyReleased(KeyEvent ke)
    {
        /*t="key released";
        repaint();*/
    }    
    int dx1=0,dy1=0;//chinge val in co-ordis
    int x1=101,y1=101;//co-ordis of circle
    int y=275;//y cordi of obstacle
    int a1=100,a2=400,b1=100,b2=300;//co-ordis of the sq
    public void paint(Graphics g)
    {
        if(fg==1)return;
        int d=20;//diameter
        g.setColor(Color.red);
        g.fillRect(0,0,500,500);
        for(int a=0;a<5;a++){             
            g.setColor(Color.blue);
            g.fillRect(a1,b1,a2-a1,b2-b1);      
            g.setColor(Color.black);
            g.fillRect(x,y,100,25);
            if(x1+d>=a2||x1<=a1)dx1=-dx1;
            if(y1+d>=b2||y1<=b1||(y1+d>=y&&(x1+d>x&&x1<x+100)))dy1=-dy1;            
            x1+=dx1;y1+=dy1;
            if(y1+d>=b2){
                g.setColor(Color.red);
                g.fillRect(a1,b1,a2-a1,b2-b1); 
                g.setColor(Color.blue);
                g.drawString("GAME OVER",200,200);
                fg++;
                return;
            }
            g.setColor(Color.green);
            g.fillOval(x1,y1,d,d);
            int e=0;
            for(int b=0;b<30000000;b++)e+=10-10+1-1;
        }
    }
}
        
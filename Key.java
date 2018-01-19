import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Key extends Applet implements KeyListener
{
    String t1="",t2="",t3="",t="";
    int key;
    char ch;
    int draw;
    int x=0;
    public void init()
    {
        addKeyListener(this);
        requestFocus();
    }
    public void keyTyped(KeyEvent ke)
    {
        ch=ke.getKeyChar();
        t1+=ch;
        t="key typed";
        repaint();
    }
    public void keyPressed(KeyEvent ke)
    {
        key=ke.getKeyCode();
        if(key==ke.VK_F1)t2="f1 pressed";
        if(key==ke.VK_SHIFT)t3="shift pressed";
        if(key==ke.VK_LEFT){t3="left pressed";x--;}
        if(key==ke.VK_RIGHT){t3="right pressed";x++;}
        t="key pressed";
        repaint();
    }
    public void keyReleased(KeyEvent ke)
    {
        t="key released";
        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawString(t,20,20);
        g.drawString(t1,20,40);
        g.drawString(t2,20,60);
        g.drawString(t3,20,80);
        String t4=""+x;
        g.drawString(t4,20,100);
        showStatus("key events");
    }
}
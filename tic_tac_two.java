import java.applet.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
public class tic_tac_two extends Applet implements MouseListener,MouseMotionListener
{
    char[]ar=new char[9];byte[]ar1=new byte[9];byte fg=0;int op=0;byte player=0;
    int x,y,count=0;
    public void init()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void mouseEntered(MouseEvent me)
    {
    }
    public void mouseExited(MouseEvent me)
    {
    }
    public void mouseDragged(MouseEvent me)
    {
    }
    public void mousePressed(MouseEvent me)
    {
        x=me.getX();
        y=me.getY();
        switch(op)
        {
            case 0:count=0;
                    if(x>80&&x<220&&y>20&&y<70)op=1;
                   else if(x>40&&x<290&&y>120&&y<170)op=2;
                   else if(x>80&&x<220&&y>220&&y<270)op=3;
                   break;                   
            
            case 1:count=0;
                   if(x>140&&x<220&&y>370&&y<410){
                       for(int b=0;b<9;ar1[b]=0,ar[b++]='Q',count=0);op=0;player=0;break;}
                   if(x>20&&x<130&&y>370&&y<410){
                       for(int b=0;b<9;ar1[b]=0,ar[b++]='Q',count=0);op=1;player=0;break;}
                    if(count>=9)break;
                    //for(int a=0;a<9&&fg==0;)
                    {                        
                        int z=0;
                        if(x>30&&x<130&&y>30&&y<130)z=1;
                        else if(x>130&&x<230&&y>30&&y<130)z=2;
                        else if(x>230&&x<330&&y>30&&y<130)z=3;
                        else if(x>30&&x<130&&y>130&&y<230)z=4;
                        else if(x>130&&x<230&&y>130&&y<230)z=5;
                        else if(x>230&&x<330&&y>130&&y<230)z=6;
                        else if(x>30&&x<130&&y>230&&y<330)z=7;
                        else if(x>130&&x<230&&y>230&&y<330)z=8;
                        else if(x>230&&x<330&&y>230&&y<330)z=9;
                        if((ar1[z-1]==0)&&(z<10)){
                        if(player==0)
                        {
                            player=1;
                            ar[z-1]='X';ar1[z-1]=(byte)z;count++;
                        }
                        else if(player==1)
                        {
                            player=0;
                            ar[z-1]='O';ar1[z-1]=(byte)z;count++;
                        }}
                        check();
                    }
                    if(fg==1)
                        op=4;
                   break;
            case 2:count=0;
                    if(x>20&&x<170&&y>370&&y<420)op=0;
                    break;
            case 4:if(x>140&&x<220&&y>370&&y<410){
                       for(int b=0;b<9;ar1[b]=0,ar[b++]='Q',count=0);op=0;player=0;break;}
                   if(x>20&&x<130&&y>370&&y<410){
                       for(int b=0;b<9;ar1[b]=0,ar[b++]='Q',count=0);op=1;player=0;break;}
        }
        repaint();
    }
    public void mouseReleased(MouseEvent me)
    {
    }
    public void mouseClicked(MouseEvent me)
    {
    }
    public void mouseMoved(MouseEvent me)
    {
    }
    public void check()
    {
        int co=0;fg=0;
        for(int a=0;a<3;a++)
        {
            if((ar[co]=='X')||(ar[co]=='O'))
            {
                if((ar[co]==ar[co+1])&&(ar[co]==ar[co+2])){fg++;break;}
                else co+=3;
            }
            if((ar[a]=='X')||(ar[a]=='O'))
            {
                if((ar[a]==ar[3+a])&&(ar[a]==ar[6+a])){fg++;break;}   
            }
        }
        if((ar[4]=='X')||(ar[4]=='O'))
        {
            if((ar[0]==ar[4])&&(ar[0]==ar[8]))fg++;
            if((ar[2]==ar[4])&&(ar[2]==ar[6]))fg++;
        }
    }
    public void paint(Graphics g)
    {
        switch(op)
        {
            case 0:g.setColor(Color.red);
                g.fillRect(0,0,500,500);
                Font font = new Font("Arial",Font.BOLD,30);
                g.setFont(font);
                FontMetrics fm = g.getFontMetrics();
                g.setColor(Color.blue);
                g.fillRect(80,20,140,50);
                g.fillRect(80,220,140,50);
                g.fillRect(40,120,250,50);
                g.setColor(Color.yellow);
                g.drawString("START",100,50);
                g.drawString("  EXIT",100,250);
                g.drawString("HOW TO PLAY",50,150);
                break;
                
            case 1:g.setColor(Color.red);
                g.fillRect(0,0,500,500);
                g.setColor(Color.blue);
                font = new Font("Arial",Font.BOLD,20);                
                g.setFont(font);
                if(player==0) g.drawString("player 1",400,30);
                else g.drawString("player 2",400,30);
                g.fillRect(20,370,110,40);
                g.fillRect(140,370,80,40);
                g.setColor(Color.yellow);
                g.fillRect(30,30,300,300);
                g.drawString("RESTART",30,400);
                g.drawString("HOME",150,400);
                g.setColor(Color.black);
                g.drawLine(130,30,130,330);
                g.drawLine(230,30,230,330);
                g.drawLine(30,130,330,130);
                g.drawLine(30,230,330,230);
                font = new Font("Arial",Font.BOLD,50);                
                g.setFont(font);
                int co=0,co1=1;
                for(int a=0;a<3;a++)
                {
                    for(int b=0;b<3;b++,co++)
                    if(ar[co]=='X'&&ar1[co]!=0)g.drawString("X",(50+100*b),(100+100*a));
                    else if(ar[co]=='O'&&ar1[co]!=0)g.drawString("O",(50+100*b),(100+100*a));
                }
                break;
            case 2:g.setColor(Color.red);
                g.fillRect(0,0,500,500);
                font = new Font("Arial",Font.BOLD,30);
                g.setFont(font);
                g.setColor(Color.blue);
                g.drawString("Get sets of 3:",50,100);
                g.drawString("-> Horizonatally,",50,150);
                g.drawString("-> Vertically, or",50,200);
                g.drawString("-> Diagonally",50,250);
                g.fillRect(20,370,150,50);
                g.setColor(Color.yellow);
                g.drawString(" HOME",30,400);
                break;
            case 3:g.setColor(Color.red);
                g.fillRect(0,0,500,500);
                font = new Font("Arial",Font.BOLD,30);
                g.setFont(font);
                g.setColor(Color.blue);
                g.drawString("THANK YOU FOR PLAYING",50,150);
                break;   
            
            case 4:g.setColor(Color.red);
                g.fillRect(0,0,500,500);                
                font = new Font("Arial",Font.BOLD,30);
                g.setFont(font);
                g.setColor(Color.blue);
                g.fillRect(20,370,110,40);
                g.fillRect(140,370,80,40);
                g.setColor(Color.yellow);
                g.drawString("CONGATULATIONS",50,50);
                if(player==0)g.drawString("    PLAYER "+2,50,100);
                if(player==1)g.drawString("    PLAYER "+1,50,100);
                g.drawString("YOU WON IT!!!!",50,150);
                font = new Font("Arial",Font.BOLD,20);
                g.setFont(font);
                g.drawString("RESTART",30,400);
                g.drawString("HOME",150,400);
                break;
        }
    }
}
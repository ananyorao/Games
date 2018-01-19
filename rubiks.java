import java.io.*;
import java.awt.*;
class rubiks extends java.applet.Applet
{
    int[][][]cube=new int[6][3][3];
    public void init()
    {
        resize(500,500);
    }
    public void paint(Graphics g)
    {
    }
    public void main()
    {
        int[][][]cub={{{2,1,2},{1,3,4},{1,5,3}},{{3,2,6},{5,1,3},{2,4,2}},{{1,2,6},{6,2,4},{3,4,1}},
        {{6,6,3},{5,6,2},{1,5,6}},{{5,2,4},{6,5,3},{4,3,4}},{{5,3,5},{1,4,6},{4,1,5}}};
        for(int a=0;a<6;a++)
            for(int b=0;b<3;b++)
                for(int c=0;c<3;c++)cube[a][b][c]=cub[a][b][c];
    }
}
import java.io.*; 
class connect4
{
    char[][]ar=new char[8][8];int[]co=new int[8];
    int skip=0,go=0,a=0;
    void main()throws IOException
    {
        System.out.println("PLAYER 1 - A\nPLAYER 2 - V\n\nENTER ROW NUMBER TO CONTINUE THE GAME\n");
        disp();
        for(go=64;go>0&&skip==0;go--)
        {
            input();check();disp();if(a>8)go++;if(a==0)break;       
        } 
        if(skip!=0)
        {            
            System.out.println("GAME OVER\nPLAYER "+ar[8-co[a-1]][a-1]+" WINS");
        }
    }
    void input()throws IOException
    {
        BufferedReader rao=new BufferedReader(new InputStreamReader(System.in));
        a=Integer.parseInt(rao.readLine());
        if((a>8)||(a<=0)||(co[a-1]==8))
        {
            System.out.println("\nTOO WIERD FOR A ROW NUMBER\n\n");go++;
        }
        else
        {
        if(go%2==0)
            ar[7-co[a-1]][a-1]='A';
        else
            ar[7-co[a-1]][a-1]='V';
        co[a-1]++;
        }
    }
    void disp()
    {
        for(int b=0;b<8;b++)            
            System.out.print((b+1)+"  ");
        System.out.println();
        for(int a=0;a<8;a++)
        {
            for(int b=0;b<8;b++)
            if(ar[a][b]=='A'||ar[a][b]=='V')
                System.out.print(ar[a][b]+"  ");
            else
                System.out.print("-  ");
            System.out.println();
        }
    }
    void check()
    {        
        for(int a=7;a>=0;a--)
        {
            for(int b=7;b>2;b--)
            {
                if((ar[a][b]=='A')||(ar[a][b]=='V'))//row
                {
                    int r=(int)ar[a][b];
                        if((r==ar[a][b-1])&&(r==ar[a][b-2])&&(r==ar[a][b-3]))
                            skip++; 
                }
                if((ar[b][7-a]=='A')||(ar[b][7-a]=='V'))//column
                {
                    int r=ar[b][7-a];
                        if((r==ar[b-1][7-a])&&(r==ar[b-2][7-a])&&(r==ar[b-3][7-a]))
                            skip++;
                }
                if(((ar[a][b]=='A')||(ar[a][b]=='V'))&&(a>2))//diagonal 1
                {
                    int r=(int)ar[a][b];
                        if((r==ar[a-1][b-1])&&(r==ar[a-2][b-2])&&(r==ar[a-3][b-3]))
                            skip++; 
                }
                if(((ar[a][7-b]=='A')||(ar[a][7-b]=='V'))&&(a>2))//diagonal 2
                {
                    int r=(int)ar[a][7-b],co=7-b;
                        if((r==ar[a-1][co+1])&&(r==ar[a-2][co+2])&&(r==ar[a-3][co+3]))
                            skip++; 
                }                                     
            }          
        }        
    }    
}
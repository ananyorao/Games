import java.io.*;
class chem_bal
{
    static float[][]ar;
    static byte cel=-1,comp;
    static void main()throws IOException
    {
        BufferedReader rao=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter de reactants");
        String r=rao.readLine();r=r.trim();
        System.out.println("enter de products");
        String p=rao.readLine();p=p.trim();
        byte ele=0;
        comp=2;//elements and conpounds
        for(int a=0;a<r.length();a++) 
            if(r.charAt(a)>='A'&&r.charAt(a)<='Z')ele++;
            else if(r.charAt(a)=='+')comp++;
        for(int a=0;a<p.length();a++) if(p.charAt(a)=='+')comp++;
        String[]el=new String[ele+1];
        String r1=r;
        cel=-1;
        byte sh=0;
        while(r1.length()>0){
            if(r1.charAt(0)>='A'&&r1.charAt(0)<='Z'){
                sh=0;                
                byte fg=0;
                for(int b=0;b<cel&&cel!=0;b++)
                    if(r1.startsWith(el[b]))fg++;
                if(fg==0){cel++;el[cel]="";el[cel]+=r1.charAt(0);sh++;}
                r1=r1.substring(1);
            }
            else if(r1.charAt(0)>='a'&&r1.charAt(0)<='z'){
                if(sh==1)el[cel]+=r1.charAt(0);
                r1=r1.substring(1);
            }
            else    r1=r1.substring(1);
        }
        r1=p;
        while(r1.length()>0){
            if(r1.charAt(0)>='A'&&r1.charAt(0)<='Z'){
                sh=0;                
                byte fg=0;
                for(int b=0;b<cel&&cel!=0;b++)
                    if(r1.startsWith(el[b]))fg++;
                if(fg==0){cel++;el[cel]="";el[cel]+=r1.charAt(0);sh++;}
                r1=r1.substring(1);
            }
            else if(r1.charAt(0)>='a'&&r1.charAt(0)<='z'){
                if(sh==1)el[cel]+=r1.charAt(0);
                r1=r1.substring(1);
            }
            else    r1=r1.substring(1);
        }
        ar=new float[cel][comp];//row X col => ele x comp
        for(int a=0;a<cel;a++)
            for(int b=0;b<comp;b++)
                ar[a][b]=0;
        r1=r;
        byte row=0,col=0;//index for filling matrix
        while(r1.length()>0){
            if(r1.charAt(0)>='A'&&r1.charAt(0)<='Z'){
                String e="";                
                e=""+r1.charAt(0);r1=r1.substring(1);//single alpha
                if(r1.length()>0)if(r1.charAt(0)>='a'&&r1.charAt(0)<='z') //float alpha
                    {e+=r1.charAt(0);r1=r1.substring(1);}
                for(row=0;row<cel;row++){
                    if(e.equals(el[row]))break;}
            }
            if(r1.length()!=0)if(r1.charAt(0)>='A'&&r1.charAt(0)<='Z')ar[row][col]=1;
            else if(r1.length()!=0)if(r1.charAt(0)>='0'&&r1.charAt(0)<='9')//no of atoms in the comp
            {
                int val=(int)(r1.charAt(0)-48);
                r1=r1.substring(1);
                if(r1.length()>0)if(r1.charAt(0)>='0'&&r1.charAt(0)<='9'){
                    val=val*10+(int)(r1.charAt(0)-48);
                    r1=r1.substring(1);
                }
                ar[row][col]=val;
            }
            else if(r1.length()==0)ar[row][col]=1;
            if(r1.length()>0)if(r1.charAt(0)=='+'){col++;r1=r1.substring(1);}
        }
        r1=p;col++;
        while(r1.length()>0){
            if(r1.charAt(0)>='A'&&r1.charAt(0)<='Z'){
                String e="";                
                e=""+r1.charAt(0);r1=r1.substring(1);//single alpha
                if(r1.length()>0)if(r1.charAt(0)>='a'&&r1.charAt(0)<='z') //float alpha
                    {e+=r1.charAt(0);r1=r1.substring(1);}
                for(row=0;row<cel;row++){
                    if(e.equals(el[row]))break;}
            }
            if(r1.length()!=0)if(r1.charAt(0)>='A'&&r1.charAt(0)<='Z')ar[row][col]=-1;
            else if(r1.length()!=0)if(r1.charAt(0)>='0'&&r1.charAt(0)<='9')//no of atoms in the comp
            {
                int val=(int)(r1.charAt(0)-48);
                r1=r1.substring(1);
                if(r1.length()>0)if(r1.charAt(0)>='0'&&r1.charAt(0)<='9'){
                    val=val*10+(int)(r1.charAt(0)-48);
                    r1=r1.substring(1);
                }
                ar[row][col]=-val;
            }
            if(r1.length()==0&&ar[row][col]==0)ar[row][col]=-1;
            if(r1.length()>0)if(r1.charAt(0)=='+'){col++;r1=r1.substring(1);}
        }
        float inv=0;//inverse of leading 1
        boolean[]nonp=new boolean[comp];//non pivot col
        for(int a=0;a<comp;a++)nonp[a]=true;
        row=0;col=0;
        byte row1=0,col1=0;
        while(row1<cel&&col1<comp){
            if(ar[row1][col1]!=0){ //direct leading 1 encountered
                nonp[col1]=false;
                inv=1/ar[row1][col1];
                for(int a=0;a<comp;a++)ar[row1][a]*=inv;
                for(int a=row1+1;a<cel;a++){
                    inv=ar[a][col1]/ar[row1][col1];
                    for(int b=0;b<comp;b++)
                        ar[a][b]=ar[a][b]-inv*ar[row1][b];
                }
                for(int a=row1-1;a>=0;a--){
                    inv=ar[a][col1]/ar[row1][col1];
                    for(int b=0;b<comp;b++)
                        ar[a][b]=ar[a][b]-inv*ar[row1][b];
                }
                row1++;
                col1++;
            }
            else{
                boolean fg=true;  //row not swaped flag
                for(int a=row1+1;a<cel;a++)
                    if(ar[a][col1]!=0){
                        for(int b=0;b<comp;b++){
                            float swap=ar[a][b];
                            ar[a][b]=ar[row1][b];
                            ar[row1][b]=swap;
                        }
                        fg=false;
                        break;
                    }
                if(fg)col1++;
            }
        } 
        
        for(int a=0;a<cel;a++)
        {
            System.out.println();
            for(int b=0;b<comp;b++)System.out.print(ar[a][b]+"\t");
        }
        float[]val=new float[comp];        
        for(int a=0;a<comp;a++) //take non pivot col whole nos ===> edit line 151 - 169
        {
            if(nonp[a]){
                float b=1;
                for(;;b++){
                    byte d=0;
                    for(int c=0;c<cel;c++){
                        float e=Math.abs(ar[c][a]*b);
                        int f=(int)e;
                        e-=f;
                        if((e>=0&&e<0.0001)||(e>=0.99999&&e<1.0))d++;}
                    if(d==cel)break;
                }
                val[a]=b;
            }
            else val[a]=0;
        }        
        double[]bal=new double[comp];
        for(int a=0;a<comp;a++){
            bal[a]=0;
            if(!nonp[a]){
                for(int b=0;b<cel;b++)
                    if(ar[b][a]!=0){
                        for(int c=0;c<comp;c++)bal[a]-=ar[b][c]*val[c];
                        break;
                    }
            }
            else bal[a]=val[a];
        }       
        //for(int a=0;a<comp;a++)bal[a]=Math.rint(bal[a]);
        System.out.print("\n\n"+bal[0]+" ");
        int b=1;
        for(int a=0;a<r.length();a++){            
            System.out.print(r.charAt(a));
            if(r.charAt(a)=='+')System.out.print(" "+bal[b++]+" ");
        }
        System.out.print(" --> "+bal[b++]+" ");
        for(int a=0;a<p.length();a++){
            System.out.print(p.charAt(a));
            if(p.charAt(a)=='+')System.out.print(" "+bal[b++]+" ");
        }
    }
}
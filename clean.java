class clean
{    
    static int c=30,r=30,len=4;
    static int[][]ar=new int[r][c];
    static int r1=0,c1=0,r2=0,c2=0;
    static void main()
    {
        obstacle();
        for(int a=0;a<r;a++)
            for(int b=0;b<c;b++)
            {
                if(ar[a][b]==0) t_box(a,b);
            }
        for(int a=0;a<r;a++)
            for(int b=0;b<c;b++)
                if(ar[a][b]==3)ar[a][b]=0;
        r2=(len-1);
        c1=3;c2=3;
        box();
        dis();
        for(int a=0;a<r;a++)
            for(int b=0;b<c;b++)
                if(ar[a][b]==0)
                {
                    System.out.println("\na="+a+"b="+b+"\n");
                    next(a,b);
                    disp();
                    box();
                }
        disp();
    }
    static void dis(){}
    static void next(int tr,int tc)
    {
        if(tc==c1-len+1)  //level 0:1
        {
            int fg=0;
            for(int a=r1;a<=tr;a++)
                for(int b=tc;b<=c1;b++)if(ar[a][b]==4)fg++;
            if(fg==0)
            {
                rt();
                if(tr+len<r)ar[tr+len][tc]=2;
                fd();
                while(r1!=tr+len-1)
                {
                    int temp=(r1+1);
                    for(int c=0;c<len;c++)
                        ar[r1+1][c2+c]=0;
                    fd();
                    for(int c=0;c<len;c++)
                        ar[temp][c2+c]=2;
                }
                lt();
                if(tr+len<r)ar[tr+len][tc]=0;
                return;
            }
        }
        
        if(tr>r1&&tc>c1-len+1)    //level 1:1,3
        {
            int fg=0;
            for(int a=r1;a<=r2;a++)   //level 1:1
                for(int b=c1;b<tc+len-1;b++)if(ar[a][b]==4)fg++;
            if(fg==0)
            {
                for(int a=r1;a<=tr+len-1;a++)
                    for(int b=tc;b<tc+len-1;b++)if(ar[a][b]==4)fg++;
                if(fg==0)
                {
                    int temp1=0;
                    if(tc+len<c){temp1=ar[r1][tc+len];ar[r1][tc+len]=2;}
                    fd();
                    while(c1!=tc+len-1)
                    {
                        int temp=(c1+1);
                        for(int c=r1;c<=r2;c++)
                            ar[c][c1+1]=0;
                        fd();
                        for(int c=r1;c<=r2;c++)
                            ar[c][temp]=2;
                    }
                    if(tc+len<c)ar[r1][tc+len]=temp1;
                    rt();
                    if(tr+len<r)ar[tr+len][tc]=2;
                    fd();
                    while(r1!=tr+len-1)
                    {
                        int temp=(r1+1);
                        for(int c=0;c<len;c++)
                            ar[r1+1][c2+c]=0;
                        fd();
                        for(int c=0;c<len;c++)
                            ar[temp][c2+c]=2;
                    }
                    lt();
                    if(tr+len<r)ar[tr+len][tc]=0;
                    return;
                }
            }
            fg=0;
            for(int a=r1;a<tr+len-1;a++)   //level 1:3
                for(int b=(c1-len+1);b<=c1;b++)if(ar[a][b]==4)fg++;
            if(fg==0)
            {
                for(int a=tr;a<tr+len;a++)
                    for(int b=c1;b<tc+len-1;b++)if(ar[a][b]==4)fg++;
                if(fg==0)
                {
                    rt();
                    int temp1=0;
                    if(tr+len<r){temp1=ar[tr+len][c1];ar[tr+len][c1]=2;}
                    fd();
                    while(r1!=tr+len-1)
                    {
                        int temp=(r1+1);
                        for(int c=0;c<len;c++)
                            ar[r1+1][c2+c]=0;
                        fd();
                        for(int c=0;c<len;c++)
                            ar[temp][c2+c]=2;
                    }                    
                    if(tr+len<r)ar[tr+len][c1]=temp1;
                    lt();
                    if(tc+len<c){temp1=ar[r1][tc+len];ar[r1][tc+len]=2;}
                    fd();
                    while(c1!=tc+len-1)
                    {
                        int temp=(c1+1);
                        for(int c=r1;c<=r2;c++)
                            ar[c][c1+1]=0;
                        fd();
                        for(int c=r1;c<=r2;c++)
                            ar[c][temp]=2;
                    }
                    if(tc+len<c)ar[r1][tc+len]=temp1;
                    return;
                }
            }
        }                
        if(tr>r1&&tc<c1)    //level 1:2,4
        {
            int fg=0;
            for(int a=r1;a<=r2;a++)        //level 1:2
                for(int b=c1;b>=tc;b--)if(ar[a][b]==4)fg++;
            if(fg==0)
            {
                for(int a=r1;a<tr+len-1;a++)
                    for(int b=tc;b<tc+len-1;b++)if(ar[a][b]==4)fg++;
                if(fg==0)
                {
                    rt();rt();
                    int temp1=0;
                    if(tc>0){temp1=ar[r1][tc-1];ar[r1][tc-1]=2;}
                    fd();
                    while(c1!=tc)
                    {
                        int temp=(c1-1);
                        for(int c=r2;c<=r1;c++)
                            ar[c][c1-1]=0;
                        fd();
                        for(int c=r2;c<=r1;c++)
                            ar[c][temp]=2;
                    }
                    if(tc>0)ar[r1][tc-1]=temp1;
                    lt();
                    if(tr+len<r)ar[tr+len][tc]=2;
                    fd();
                    while(r1!=tr+len-1)
                    {
                        int temp=(r1+1);
                        for(int c=0;c<len;c++)
                            ar[r1+1][c2+c]=0;
                        fd();
                        for(int c=0;c<len;c++)
                            ar[temp][c2+c]=2;
                    }
                    lt();
                    if(tr+len<r)ar[tr+len][tc]=0;
                    return;
                }
            }
            fg=0;
            for(int a=r1;a<tr+len-1;a++)   //level 1:4
                for(int b=(c1-len+1);b<=c1;b++)if(ar[a][b]==4)fg++;
            if(fg==0)
            {
                for(int a=tr;a<tr+len;a++)       
                    for(int b=c1;b>=tc;b--)if(ar[a][b]==4)fg++;
                if(fg==0)
                {
                    rt();
                    if(tr+len<r)ar[tr+len][c1]=2;
                    fd();
                    while(r1!=tr+len-1)
                    {
                        int temp=(r1+1);
                        for(int c=0;c<len;c++)
                            ar[r1+1][c2+c]=0;
                        fd();
                        for(int c=0;c<len;c++)
                            ar[temp][c2+c]=2;
                    }
                    if(tr+len<r)ar[tr+len][c1]=1;
                    rt();
                    int temp1=0;
                    if(tc>0){temp1=ar[r1][tc-1];ar[r1][tc-1]=2;}
                    fd();
                    while(c1!=tc)
                    {
                        int temp=(c1-1);
                        for(int c=r2;c<=r1;c++)
                            ar[c][c1-1]=0;
                        fd();
                        for(int c=r2;c<=r1;c++)
                            ar[c][temp]=2;
                    }
                    if(tc>0)ar[r1][tc-1]=temp1;
                    rt();rt();
                    return;
                }
            }
        }
        if(tc>c1)   //level 2:1,5
        {
            for(int a=0;r1-a>=0;a++)
            {
                int fg=0;                
                for(int b=r1;b<=r2;b++)
                    for(int c=(c1-len+1);c<tc+len;c++)if(ar[b-a][c]==4)fg++;
                if(fg==0)
                {
                    for(int b=r1;r1-b<=a;b--)
                        for(int c=(c1-len+1);c<=c1;c++)if(ar[b][c]==4)fg++;
                    if(fg==0)
                    {
                        for(int b=tr;b>=r1-a;b--)
                            for(int c=tc;c<=tc+len;c++)if(ar[b][c]==4)fg++;
                        if(fg==0)
                        {
                            lt();
                            int temp1=0;
                            int sr=(r1-a-1);
                            if(r1-a-1>0){temp1=ar[r1-a-2][c1];ar[r1-a-2][c1]=2;} 
                            while(r1!=sr)
                            {
                                int temp=(r1-1);
                                for(int c=0;c<len;c++)
                                    ar[r1-1][c1+c]=0;
                                fd();
                                for(int c=0;c<len;c++)
                                    ar[temp][c1+c]=2;
                            }
                            if(sr>0)ar[sr-1][c1]=temp1;
                            rt();                            
                            if(tc+len<c){temp1=ar[r1][tc+len];ar[r1][tc+len]=2;}
                            fd();
                            while(c1!=tc+len-1)
                            {
                                int temp=(c1+1);
                                for(int c=r1;c<=r2;c++)
                                    ar[c][c1+1]=0;
                                fd();
                                for(int c=r1;c<=r2;c++)
                                    ar[c][temp]=2;
                            }
                            if(tc+len<c)ar[r1][tc+len]=temp1;
                            rt();
                            if(tr+len<r){temp1=ar[tr+len][c1];ar[tr+len][c1]=2;}
                            fd();
                            while(r1!=tr+len-1)
                            {
                                int temp=(r1+1);
                                for(int c=0;c<len;c++)
                                    ar[r1+1][c2+c]=0;
                                fd();
                                for(int c=0;c<len;c++)
                                    ar[temp][c2+c]=2;
                            }                            
                            if(tr+len<r)ar[tr+len][c1]=temp1;
                            lt();
                            return;
                        }
                    }
                }
            }            
            for(int a=0;r2+a<r;a++)
            {
                int fg=0;                
                for(int b=r1;b<=r2;b++)//horizontal movement
                    for(int c=(c1-len+1);c<tc+len;c++)if(ar[b+a][c]==4)fg++;
                if(fg==0)
                {
                    for(int b=r2;b-r2<=a;b++)//verti original
                        for(int c=(c1-len+1);c<=c1;c++)if(ar[b][c]==4)fg++;
                    if(fg==0)
                    {
                        for(int b=(tr+len-1);b<=r2+a;b++)//verti final
                            for(int c=tc;c<tc+len;c++)if(ar[b][c]==4)fg++;
                        if(fg==0)
                        {
                            rt();
                            int temp1=0;
                            int sr=(r2+a+1);
                            if(sr+1<r){temp1=ar[sr+1][c1];ar[sr+1][c1]=2;} 
                            while(r2!=sr)
                            {
                                int temp=(r2+1);
                                for(int c=0;c<len;c++)
                                    ar[temp][c1+c]=0;
                                fd();
                                for(int c=0;c<len;c++)
                                    ar[temp][c1+c]=2;
                            }
                            if(sr+1<r)ar[sr+1][c1]=temp1;
                            lt();
                            if(tc+len<c){temp1=ar[r1][tc+len];ar[r1][tc+len]=2;}
                            fd();
                            while(c1!=tc+len-1)
                            {
                                int temp=(c1+1);
                                for(int c=r1;c<=r2;c++)
                                    ar[c][c1+1]=0;
                                fd();
                                for(int c=r1;c<=r2;c++)
                                    ar[c][temp]=2;
                            }
                            if(tc+len<c)ar[r1][tc+len]=temp1;
                            lt();
                            if(tr>0){temp1=ar[tr-1][c1];ar[tr-1][c1]=2;}
                            fd();
                            while(r1!=tr)
                            {
                                int temp=(r1-1);
                                for(int c=0;c<len;c++)
                                    ar[temp][c2+c]=0;
                                fd();
                                for(int c=0;c<len;c++)
                                    ar[temp][c2+c]=2;
                            }                            
                            if(tr>0)ar[tr-1][c1]=temp1;
                            rt();
                            return;
                        }
                    }
                }
            }
        }
        
        if(tc<c1)   //level 2:2,6
        {
            for(int a=0;r1-a>=0;a++)  //level 2:2
            {
                int fg=0;                
                for(int b=r1;b<=r2;b++)
                    for(int c=(c1-len+1);c<tc+len;c++)if(ar[b-a][c]==4)fg++;
                if(fg==0)
                {
                    for(int b=r1;r1-b<=a;b--)
                        for(int c=(c1-len+1);c<=c1;c++)if(ar[b][c]==4)fg++;
                    if(fg==0)
                    {
                        for(int b=tr;b>=r1-a;b--)
                            for(int c=tc;c<=tc+len;c++)if(ar[b][c]==4)fg++;
                        if(fg==0)
                        {
                            lt();
                            int temp1=0;
                            int sr=(r1-a-1);
                            if(r1-a-1>0){temp1=ar[r1-a-2][c1];ar[r1-a-2][c1]=2;} 
                            while(r1!=sr)
                            {
                                int temp=(r1-1);
                                for(int c=0;c<len;c++)
                                    ar[r1-1][c1+c]=0;
                                fd();
                                for(int c=0;c<len;c++)
                                    ar[temp][c1+c]=2;
                            }
                            if(sr>0)ar[sr-1][c1]=temp1;
                            lt();                            
                            if(tc+len<c){temp1=ar[r1][tc+len];ar[r1][tc+len]=2;}
                            fd();
                            while(c1!=tc+len-1)
                            {
                                int temp=(c1+1);
                                for(int c=r1;c<=r2;c++)
                                    ar[c][c1+1]=0;
                                fd();
                                for(int c=r1;c<=r2;c++)
                                    ar[c][temp]=2;
                            }
                            if(tc+len<c)ar[r1][tc+len]=temp1;
                            lt();
                            if(tr+len<r){temp1=ar[tr+len][c1];ar[tr+len][c1]=2;}
                            fd();
                            while(r1!=tr+len-1)
                            {
                                int temp=(r1+1);
                                for(int c=0;c<len;c++)
                                    ar[r1+1][c2+c]=0;
                                fd();
                                for(int c=0;c<len;c++)
                                    ar[temp][c2+c]=2;
                            }                            
                            if(tr+len<r)ar[tr+len][c1]=temp1;
                            lt();
                            return;
                        }
                    }
                }
            }            
            for(int a=0;r2+a<r;a++)  //level 2:6
            {
                int fg=0;                
                for(int b=r1;b<=r2;b++)//horizontal movement
                    for(int c=(c1-len+1);c<tc+len;c++)if(ar[b+a][c]==4)fg++;
                if(fg==0)
                {
                    for(int b=r2;b-r2<=a;b++)//verti original
                        for(int c=(c1-len+1);c<=c1;c++)if(ar[b][c]==4)fg++;
                    if(fg==0)
                    {
                        for(int b=(tr+len-1);b<=r2+a;b++)//verti final
                            for(int c=tc;c<tc+len;c++)if(ar[b][c]==4)fg++;
                        if(fg==0)
                        {
                            rt();
                            int temp1=0;
                            int sr=(r2+a+1);
                            if(sr+1<r){temp1=ar[sr+1][c1];ar[sr+1][c1]=2;} 
                            while(r2!=sr)
                            {
                                int temp=(r2+1);
                                for(int c=0;c<len;c++)
                                    ar[temp][c1+c]=0;
                                fd();
                                for(int c=0;c<len;c++)
                                    ar[temp][c1+c]=2;
                            }
                            if(sr+1<r)ar[sr+1][c1]=temp1;
                            rt();
                            if(tc+len<c){temp1=ar[r1][tc+len];ar[r1][tc+len]=2;}
                            fd();
                            while(c1!=tc+len-1)
                            {
                                int temp=(c1+1);
                                for(int c=r1;c<=r2;c++)
                                    ar[c][c1+1]=0;
                                fd();
                                for(int c=r1;c<=r2;c++)
                                    ar[c][temp]=2;
                            }
                            if(tc+len<c)ar[r1][tc+len]=temp1;
                            rt();
                            if(tr>0){temp1=ar[tr-1][c1];ar[tr-1][c1]=2;}
                            fd();
                            while(r1!=tr)
                            {
                                int temp=(r1-1);
                                for(int c=0;c<len;c++)
                                    ar[temp][c2+c]=0;
                                fd();
                                for(int c=0;c<len;c++)
                                    ar[temp][c2+c]=2;
                            }                            
                            if(tr>0)ar[tr-1][c1]=temp1;
                            rt();
                            return;
                        }
                    }
                }
            }
        }
        
        
    }
    static void t_box(int tr,int tc)//make temporary boxes
    {
        int fg=0;
        int max=0;
        for(int a=tc;a<c;a++)
        {
            if(ar[tr][a]==0)max++;
            else break;
        }
        int a;
        for(a=tr;a<r&&fg==0;a++)
        {
            int b;
            for(b=tc;b<tc+max;b++)
                if(ar[a][b]!=0){fg++;break;}
            for(b=tc;b<tc+max;b++)
                ar[a][b]=3;
            if(b<c)
                if(ar[a][b-1]!=4)ar[a][b-1]=2;
        }
        if(a<r)
        {
            int b;
            for(b=tc;b<tc+max;b++)
                if(ar[a-1][b]!=4)ar[a-1][b]=2;
        }
    }
    static void obstacle()//set obstacle
    {
        /*for(int a=0;a<10;a++)
            for(int b=10;b<20;b++)ar[a][b]=4;*/
        int a,b;        //box 1
        for(a=0;a<10;a++)
            for(b=10;b<15;b++)ar[a][b]=4;
        
    }
    static void box()//clean within boxes
    {        
        while(true)
        {
            fd();
            if(r2+len >=r)break;
            rt();
            int fg=0;
            for(int a=r1;a<=r1+len;a++)if(ar[a][(c1+c2)/2]>1)fg++;
            if(fg==0){
                int temp=ar[r1+len][(c1+c2)/2];
                ar[r1+len][(c1+c2)/2]=2;
                fd();
                System.out.println("\n\n"+temp+"   "+(r1+1)+"\n\n");
                ar[r1+1][(c1+c2)/2]=temp;
            }
            else fd();
            rt();
            fd();
            if(fg>0)break;
            if(r1+len >=r)break;
            lt();
            fg=0;
            for(int a=r1;a<=r1+len;a++)if(ar[a][(c1+c2)/2]>1)fg++;
            if(fg==0){
                int temp=ar[r1+len][(c1+c2)/2];
                System.out.println("\n\n"+temp+"   "+(r1+1)+"\n\n");
                ar[r1+len][(c1+c2)/2]=2;
                fd();
                ar[r1+1][(c1+c2)/2]=temp;
            }
            else fd();
            lt();
            if(fg>0)break;
        }
        fd();      
        if(r1>r2){lt();fd();lt();fd();}
        else if(r2>r1){rt();fd();rt();fd();}
        if(r2>r1){rt();rt();fd();}
        rt();fd();rt();
    }
    static void fd()
    {
        while(true)
        {
            int fg=0;
            if(r1==r2)
            {
                while(c1<c2)
                {
                    if(r1==0)return;
                    for(int a=c1;a<=c2;a++)
                        if(ar[r1-1][a]>1)return;
                    r1--;
                    r2--;
                    for(int a=c1;a<=c2;a++)
                        ar[r1][a]=1;                    
                }
                while(c2<c1)
                {
                    if(r1==r-1)return;
                    for(int a=c2;a<=c1;a++)
                        if(ar[r1+1][a]>1)return;
                    r1++;
                    r2++;
                    for(int a=c2;a<=c1;a++)
                        ar[r1][a]=1;                    
                }
            }     
            if(c1==c2)
            {
                while(r1<r2)
                {
                    if(c1==c-1)return;
                    for(int a=r1;a<=r2;a++)
                        if(ar[a][c1+1]>1)return;
                    c1++;
                    c2++;
                    for(int a=r1;a<=r2;a++)
                        ar[a][c1]=1;                    
                }
                while(r2<r1)
                {
                    if(c1==0)return;
                    for(int a=r2;a<=r1;a++)
                        if(ar[a][c1-1]>1)return;
                    c1--;
                    c2--;
                    for(int a=r2;a<=r1;a++)
                        ar[a][c1]=1;                    
                }
            }
        }
    }
    static void rt()
    {
        if(r1==r2)
        {
            if(c1<c2)
            {
                r1=r2;
                c1=c2;
                r2=(r1+len-1);
            }
            else if(c2<c1)
            {
                r1=r2;
                c1=c2;
                r2=(r1-len+1);
            }
        }
        else if(c1==c2)
        {
            if(r1<r2)
            {
                r1=r2;
                c1=c2;
                c2=(c1-len+1);
            }
            else if(r1>r2)
            {
                r1=r2;
                c1=c2;
                c2=(c1+len-1);
            }    
        }
    }
    static void lt()//probs
    {
        if(r1==r2)
        {
            if(c1<c2)
            {
                c2=c1;
                r2=r1;
                r1=(r2+len-1);
            }
            else if(c2<c1)
            {
                r2=r1;
                c2=c1;
                r1=(r2-len+1);
            }
        }
        else if(c1==c2)
        {
            if(r1<r2)
            {
                r2=r1;
                c2=c1;
                c1=(c2-len+1);
            }
            else if(r1>r2)
            {
                r2=r1;
                c2=c1;
                c1=(c2+len-1);
            }    
        }
    }
    static void disp()
    {
        System.out.println("\n\nr1="+r1+"    c1="+c1+"   r2="+r2+"    c2="+c2+"\n\n");
        for(int a=0;a<r;a++)
        {
            System.out.println();
            for(int b=0;b<c;b++)
                System.out.print("  "+ar[a][b]);
        }
    }
}          
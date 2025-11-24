import java.util.*;

public class Hamming {
    static int parity(int[] b, int p){
        int x=0;
        for(int i=p;i<b.length;i+=2*p)
            for(int j=i;j<i+p && j<b.length;j++)
                x ^= b[j];
        return x;
    }

    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        System.out.print("Data bits: ");
        String d=s.next();

        int m=d.length(), r=0;
        while(Math.pow(2,r) < m+r+1) r++;

        int[] b=new int[m+r+1];  // 1-indexed

        for(int i=1,j=0;i<b.length;i++)
            if((i & (i-1))!=0)
                b[i]=d.charAt(j++)-'0';

        for(int i=0;i<r;i++){
            int p=(int)Math.pow(2,i);
            b[p]=parity(b,p);
        }

        System.out.print("Hamming Code: ");
        for(int i=1;i<b.length;i++) System.out.print(b[i]);
        System.out.println();

        // receiver
        System.out.print("Received: ");
        String recv=s.next();
        int[] rcv=new int[recv.length()+1];
        for(int i=1;i<rcv.length;i++) rcv[i]=recv.charAt(i-1)-'0';

        int err=0;
        for(int i=0;i<r;i++){
            int p=(int)Math.pow(2,i);
            if(parity(rcv,p)!=0) err+=p;
        }

        System.out.println(err==0 ? "No Error" : "Error at position "+err);
    }
}

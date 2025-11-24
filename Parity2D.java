import java.util.*;

public class Parity2D {
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        int r,c;
        r=s.nextInt(); c=s.nextInt(); // matrix size
        int[][] m=new int[r][c];

        // input
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                m[i][j]=s.nextInt();

        // sender: add row parity & column parity
        int[] rp=new int[r], cp=new int[c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++){
                rp[i]^=m[i][j];
                cp[j]^=m[i][j];
            }

        System.out.println("Row Parity: " + Arrays.toString(rp));
        System.out.println("Col Parity: " + Arrays.toString(cp));

        // receiver: recheck
        int[] rr=new int[r], cr=new int[c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++){
                rr[i]^=m[i][j];
                cr[j]^=m[i][j];
            }

        System.out.println(Arrays.equals(rp,rr) && Arrays.equals(cp,cr)
                ? "No Error" : "Error Detected");
    }
}

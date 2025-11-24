import java.util.*;

public class LeakyBucket {
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);

        System.out.print("Bucket size: ");
        int b=s.nextInt();
        System.out.print("Output rate: ");
        int r=s.nextInt();
        System.out.print("Number of incoming packets: ");
        int n=s.nextInt();

        int stored = 0;

        for(int i=0;i<n;i++){
            System.out.print("Incoming packet size: ");
            int pkt=s.nextInt();

            if(pkt + stored <= b){
                stored += pkt;
                System.out.println("Bucket stored: " + stored);
            } else {
                System.out.println("Packet of size " + pkt + " DROPPED");
            }

            stored = Math.max(0, stored - r);
            System.out.println("After leaking: " + stored + "\n");
        }
    }
}

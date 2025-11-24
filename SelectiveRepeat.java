import java.util.*;

public class SelectiveRepeat {
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        System.out.print("Total Frames: ");
        int n=s.nextInt();
        System.out.print("Window Size: ");
        int w=s.nextInt();

        Random r=new Random();
        boolean[] ack=new boolean[n];

        int base=0;

        while(base<n){
            System.out.println("\nSender Window: " + base + " to " + Math.min(base+w-1,n-1));

            // SENDER sends window frames
            for(int i=base;i<Math.min(base+w,n);i++){
                if(!ack[i]) 
                    System.out.println("Sender: Sending Frame " + i);
            }

            // RECEIVER processes frames
            for(int i=base;i<Math.min(base+w,n);i++){
                if(!ack[i]){
                    boolean lost = r.nextInt(4)==0; // 25% loss
                    if(lost){
                        System.out.println("Receiver: Frame " + i + " LOST -> NACK");
                    } else {
                        ack[i]=true;
                        System.out.println("Receiver: Frame " + i + " received -> ACK");
                    }
                }
            }

            // slide window
            while(base<n && ack[base]) base++;
        }

        System.out.println("\nAll Frames Sent Successfully!");
    }
}

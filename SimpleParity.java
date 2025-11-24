import java.util.*;

public class SimpleParity {
    static int parity(String d){
        int c=0; for(char x:d.toCharArray()) if(x=='1') c++;
        return c%2; // even parity: 1 if odd count
    }
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);

        System.out.print("Data: ");
        String data=s.next();

        int p = parity(data);          // sender parity bit
        String sent = data + p;
        System.out.println("Sent: " + sent);

        System.out.print("Received: ");
        String recv = s.next();

        int rp = parity(recv.substring(0, recv.length()-1));
        System.out.println(rp == recv.charAt(recv.length()-1)-'0'
                ? "No Error" : "Error Detected");
    }
}

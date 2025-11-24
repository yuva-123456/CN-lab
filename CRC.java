import java.util.*;

public class CRC {
    static String xor(String a, String b){
        String r=""; 
        for(int i=1;i<a.length();i++) r+= (a.charAt(i)==b.charAt(i))?'0':'1';
        return r;
    }
    static String divide(String msg, String poly){
        int n=poly.length();
        String tmp=msg.substring(0,n);
        for(int i=n;i<msg.length();i++){
            tmp = (tmp.charAt(0)=='1') ? xor(poly,tmp)+msg.charAt(i) : xor("0".repeat(n),tmp)+msg.charAt(i);
        }
        return (tmp.charAt(0)=='1') ? xor(poly,tmp) : xor("0".repeat(n),tmp);
    }
    public static void main(String[] a){
        Scanner s=new Scanner(System.in);
        System.out.print("Data: ");
        String data=s.next();
        System.out.print("Polynomial: ");
        String poly=s.next();

        int m=poly.length()-1;
        String senderData = data + "0".repeat(m);
        String crc = divide(senderData, poly);

        System.out.println("CRC: " + crc);
        String transmitted = data + crc;
        System.out.println("Transmitted: " + transmitted);

        // Receiver
        String remainder = divide(transmitted, poly);
        System.out.println("Receiver Remainder: " + remainder);
        System.out.println(remainder.equals("0".repeat(m)) ? "No Error" : "Error Detected");
    }
}

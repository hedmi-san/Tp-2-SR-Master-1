package process1;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Process1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                DatagramSocket ds = new DatagramSocket(9000);
                InetAddress adrP2 = InetAddress.getByName("192.168.100.16");
                System.out.println("Message sent : ");
                String mytext = scan.nextLine();
                byte[] messageSen = mytext.getBytes();
                DatagramPacket packetSend = new DatagramPacket(messageSen, messageSen.length, adrP2, 8000);
                ds.send(packetSend);
                // ======Partie resevoir un message
                byte[] messageResive = new byte[1000];
                DatagramPacket packetResieved = new DatagramPacket(messageResive, messageResive.length);
                System.out.println("Resiever start");
                ds.receive(packetResieved);
                String message = new String(packetResieved.getData());
                System.out.println(message);
                ds.close();
            } catch (UnknownHostException eee) {
            } catch (SocketException e) {
            } catch (IOException ee) {
            }
        }
    }

}

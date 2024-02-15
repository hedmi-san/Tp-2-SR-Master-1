package process2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Process2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                DatagramSocket dtS = new DatagramSocket(8000);
                byte[] messageRes = new byte[1000];
                DatagramPacket packetRes = new DatagramPacket(messageRes, messageRes.length);
                System.out.println("Resiever start : ");
                dtS.receive(packetRes);
                String message = new String(packetRes.getData());
                System.out.println(message);
                // =======Patrie envoyer un message
                String textSend = scan.nextLine();
                byte[] messageSend = textSend.getBytes();
                InetAddress adrP1 = InetAddress.getByName("192.168.100.10");
                DatagramPacket pacetSend = new DatagramPacket(messageSend, messageSend.length, adrP1, 9000);
                System.out.println("Message sent : ");
                dtS.send(pacetSend);
                dtS.close();
            } catch (UnknownHostException eee) {
            } catch (SocketException e) {
            } catch (IOException ee) {
            }
        }
    }

}

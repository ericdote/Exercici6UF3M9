package exercici6u1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 *
 * @author Eric
 */
public class MulticastClient {

    private static final int PORT = 5487;
    private static final String HOST = "231.0.0.8";

    public static void main(String[] args) throws UnknownHostException, IOException {
        MulticastSocket socket = new MulticastSocket(PORT);
        InetAddress inet = InetAddress.getByName(HOST);
        DatagramPacket dp;
        String cadena;
        socket.joinGroup(inet);
        byte[]dades, dades2;
        do{
            dades = new byte[512];
            dp = new DatagramPacket(dades, dades.length);
            socket.receive(dp);
            int dades2Long = dp.getLength();
            dades2 = new byte[dades2Long];
            System.arraycopy(dades, 0, dades2, 0, dades2Long);
            cadena = new String(dades2);
            System.out.println(cadena);
        }while(!cadena.equals("exit"));
        socket.leaveGroup(inet);
    }
    
}

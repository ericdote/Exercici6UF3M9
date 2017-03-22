package exercici6u1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author Eric
 */
public class MulticastServer {

    private static final int PORT = 5487;
    private static final String HOST = "231.0.0.8";

    public static void main(String[] args) throws IOException {
        MulticastSocket socket = new MulticastSocket(PORT);
        InetAddress inet =  InetAddress.getByName(HOST);
        byte[] dades = new byte[0];
        DatagramPacket dp = new DatagramPacket(dades, dades.length, inet, PORT);
        String cadena;
        do{
            cadena = JOptionPane.showInputDialog("Introdueix una cadena:");
            dades = cadena.getBytes();
            dp.setData(dades);
            dp.setLength(dades.length);
            socket.send(dp);
        } while(!cadena.equals("exit"));     
        
        
    }
    
}

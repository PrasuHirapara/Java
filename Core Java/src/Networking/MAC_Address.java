package Networking;

import java.net.NetworkInterface;
import java.net.SocketException;

public class MAC_Address {
    public static void main(String[] args) {

        try {
            NetworkInterface network = NetworkInterface.getByName("ethernet_1");
            System.out.println(network);

            byte[] macAddress = network.getHardwareAddress();

            // Display the MAC address in standard format
            StringBuilder macString = new StringBuilder();
            for (int i = 0; i < macAddress.length; i++) {
                macString.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
            }
            System.out.println("MAC Address: " + macString);

        } catch (SocketException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

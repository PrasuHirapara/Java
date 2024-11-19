package Networking;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;

public class ListNetworkInterfaces {
    public static void main(String[] args) {
        try {
            System.out.println("Available Network Interfaces:");
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                System.out.println(networkInterface.getName());
            }
        } catch (SocketException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

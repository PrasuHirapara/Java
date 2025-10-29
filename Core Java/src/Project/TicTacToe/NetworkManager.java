package Project.TicTacToe;

import java.io.IOException;
import java.net.*;

public class NetworkManager {
    private final int port;

    public NetworkManager(int port) {
        this.port = port;
    }

    /**
     * Host: start ServerSocket and wait for a single client connection.
     * Returns a connected Socket.
     */
    public Socket hostAndAccept() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setReuseAddress(true);
        // print local IP for the host to share
        String localIp = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Host started. Local IP: " + localIp + "  Port: " + port);
        System.out.println("If you are behind a router and want to play over the internet, share your public IP and forward port " + port);
        System.out.println("Waiting for opponent to connect...");
        Socket client = serverSocket.accept();
        // We don't need serverSocket after accepted (close it)
        try { serverSocket.close(); } catch (IOException ignored) {}
        System.out.println("Opponent connected from: " + client.getRemoteSocketAddress());
        return client;
    }

    /**
     * Join: connect to hostIp at the configured port.
     */
    public Socket join(String hostIp) throws IOException {
        System.out.println("Connecting to " + hostIp + ":" + port + " ...");
        Socket socket = new Socket();
        // timeout of 10 seconds for connection attempt
        socket.connect(new InetSocketAddress(hostIp, port), 10000);
        System.out.println("Connected to host: " + socket.getRemoteSocketAddress());
        return socket;
    }

    /**
     * Utility: get public IP suggestion (best-effort via InetAddress). Real public IP requires external service.
     */
    public static String getLocalIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            return "127.0.0.1";
        }
    }
}

package Project.TicTacToe;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        // IMPORTANT: create ObjectOutputStream first and flush to avoid deadlock
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.out.flush();
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public synchronized void sendMove(Move m) throws IOException {
        out.writeObject(m);
        out.flush();
    }

    public synchronized Move receiveMove() throws IOException, ClassNotFoundException {
        Object obj = in.readObject();
        if (obj instanceof Move) {
            return (Move) obj;
        }
        return null;
    }

    public void close() {
        try { if (out != null) out.close(); } catch (IOException ignored) {}
        try { if (in != null) in.close(); } catch (IOException ignored) {}
        try { if (socket != null) socket.close(); } catch (IOException ignored) {}
    }
}

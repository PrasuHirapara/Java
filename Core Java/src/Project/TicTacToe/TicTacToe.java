package Project.TicTacToe;

import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;

public class TicTacToe {
    private final int dimension = 3;
    private Scanner input;
    private char[][] board;
    private boolean flag;
    private int x, y;

    public TicTacToe() {
        this.input = new Scanner(System.in);
        this.board = new char[dimension][dimension];
        this.flag = true;
        this.x = 0;
        this.y = 0;
    }

    private void setBoard() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = '_';
            }
        }
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < dimension; i++) {
            System.out.print("\t\t");
            for (int j = 0; j < dimension; j++) {
                System.out.print("\t" + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean validateCoordinates(char[][] board, int x, int y) {
        // safer bounds check: valid indices are 0..dimension-1
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            return false;
        }
        return board[x][y] == '_';
    }

    //    O(N*N)
    private boolean checkWin(char[][] board, char ch) {
//        checking i == j
        if(board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) {
            return true;
        }

//        checking for i + j == 2
        if(board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) {
            return true;
        }

        for (int i = 0; i < dimension; i++) {
//            checking rows
            for (int j = 0; j < dimension; j++) {
                if(board[j][0] == ch && board[j][1] == ch && board[j][2] == ch) {
                    return true;
                }
            }

//            checking columns
            for (int j = 0; j < dimension; j++) {
                if(board[0][j] == ch && board[1][j] == ch && board[2][j] == ch) {
                    return true;
                }
            }
        }

        return false;
    }

    public void play1V1() {
        setBoard();
        printBoard(board);

        for(int i = 0; i < 9; i++) {
            if(flag) {
                System.out.print("Enter X Co-ordinates : ");
                x = input.nextInt();
                y = input.nextInt();

                while(!validateCoordinates(board, x, y)) {
                    System.out.print("Enter valid X Co-ordinates : ");
                    x = input.nextInt();
                    y = input.nextInt();
                }

                board[x][y] = 'X';

                printBoard(board);

                if(checkWin(board, board[x][y])) {
                    System.out.println("Player X Wins !!!");
                    setBoard();
                    return;
                }

                flag = !flag;
            } else {
                System.out.print("Enter O Co-ordinates : ");
                x = input.nextInt();
                y = input.nextInt();

                while(!validateCoordinates(board, x, y)) {
                    System.out.print("Enter valid O Co-ordinates : ");
                    x = input.nextInt();
                    y = input.nextInt();
                }

                board[x][y] = 'O';

                printBoard(board);

                if(checkWin(board, board[x][y])) {
                    System.out.println("Player X Wins !!!");
                    setBoard();
                    return;
                }

                flag = !flag;
            }

            if(i == 8) {
                System.out.println("Game Draw !!!");
                setBoard();
                return;
            }
        }
    }

    /**
     * - Host runs server and waits; Join connects to host IP.
     * - Host will be 'X' and start first.
     */
    public void playOnline() {
        final int PORT = 5000;
        NetworkManager nm = new NetworkManager(PORT);
        System.out.println("Online mode selected.");
        System.out.println("Choose: (h)ost or (j)oin ?");
        char choice = input.next().toLowerCase().charAt(0);

        Socket socket = null;
        Connection conn = null;
        boolean iAmHost = false;

        try {
            if (choice == 'h') {
                iAmHost = true;
                // host: start server and accept
                socket = nm.hostAndAccept();
            } else {
                // join: display local IP (for user's info) and ask for host IP
                System.out.println("Your local IP (for reference): " + NetworkManager.getLocalIP());
                System.out.print("Enter host IP to connect: ");
                String hostIp = input.next();
                socket = nm.join(hostIp);
            }

            conn = new Connection(socket);

            // Setup game
            setBoard();
            printBoard(board);

            // decide symbol: host -> X and starts; join -> O and waits
            char mySymbol = iAmHost ? 'X' : 'O';
            char remoteSymbol = iAmHost ? 'O' : 'X';
            boolean myTurn = iAmHost; // host starts

            System.out.println("You are '" + mySymbol + "'. Game starting...");

            for (int turn = 0; turn < 9; turn++) {
                if (myTurn) {
                    // local input, validate, place and send
                    System.out.print("Enter your (" + mySymbol + ") coordinates: ");
                    int lx = input.nextInt();
                    int ly = input.nextInt();

                    while (!validateCoordinates(board, lx, ly)) {
                        System.out.print("Enter valid coordinates: ");
                        lx = input.nextInt();
                        ly = input.nextInt();
                    }

                    board[lx][ly] = mySymbol;
                    printBoard(board);

                    // send move
                    Move mv = new Move(lx, ly, mySymbol);
                    try {
                        conn.sendMove(mv);
                    } catch (IOException ioe) {
                        System.out.println("Failed to send move: " + ioe.getMessage());
                        break;
                    }

                    if (checkWin(board, mySymbol)) {
                        System.out.println("You (" + mySymbol + ") WIN!");
                        break;
                    }
                } else {
                    // wait for opponent move
                    System.out.println("Waiting for opponent's move...");
                    try {
                        Move remote = conn.receiveMove();
                        if (remote == null) {
                            System.out.println("Received invalid object. Ending game.");
                            break;
                        }
                        System.out.println("Opponent moved: " + remote);
                        // apply
                        if (validateCoordinates(board, remote.x, remote.y)) {
                            board[remote.x][remote.y] = remote.symbol;
                        } else {
                            // if remote sent invalid move, still place (or could skip)
                            board[remote.x][remote.y] = remote.symbol;
                        }
                        printBoard(board);

                        if (checkWin(board, remote.symbol)) {
                            System.out.println("Opponent (" + remote.symbol + ") WINS!");
                            break;
                        }
                    } catch (ClassNotFoundException cnfe) {
                        System.out.println("Error receiving move: " + cnfe.getMessage());
                        break;
                    } catch (IOException ioe) {
                        System.out.println("Connection error while receiving move: " + ioe.getMessage());
                        break;
                    }
                }

                myTurn = !myTurn;

                if (turn == 8) {
                    System.out.println("Game Draw!!!");
                }
            }

        } catch (IOException e) {
            System.out.println("Network error: " + e.getMessage());
        } finally {
            if (conn != null) conn.close();
            else {
                try { if (socket != null) socket.close(); } catch (IOException ignored) {}
            }
            setBoard();
        }
    }
}

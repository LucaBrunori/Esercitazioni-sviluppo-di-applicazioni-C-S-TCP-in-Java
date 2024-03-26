package org.example;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    public Server(int porta){
        try {
            serverSocket = new ServerSocket(porta);
        } catch (BindException e) {
            System.err.println("Porta occupata");
        } catch (IOException e) {
            System.err.println("Errore");
        }
    }
    public Socket attendi(){
        if (serverSocket!=null){
            try {
                return serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Errore collegamento al client");
            }
        }

        return null;
    }
     public void scrivi(){

     }

     public void leggi(){

     }
}

package org.example;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    public Server(int porta) {
        try {
            serverSocket = new ServerSocket(porta);
        } catch (BindException e) {
            System.err.println("Porta occupata");
        } catch (IOException e) {
            System.err.println("Errore");
        }
    }

    public Socket attendi() {
        if (serverSocket != null) {
            try {
                clientSocket = serverSocket.accept();
                return clientSocket;
            } catch (IOException e) {
                System.err.println("Errore collegamento al client");
            }
        }

        return null;
    }

    public void scrivi(String messaggio) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(messaggio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leggi() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void chiudi() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
                System.out.println("Connessione chiusa");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
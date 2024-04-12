package org.example;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    int nome;
    int porta;
    Socket socket;
    BufferedReader input;
    PrintWriter output;

    public Client(String nomeServer, int portaServer) {
        this.nome = nome;
        this.porta = porta;
    }

    public void connetti(String nomeServer, int portaServer){
        try {
            socket = new Socket(nomeServer, portaServer);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connesso al server");
        } catch (UnknownHostException e) {
            System.err.println("Indirizzo IP non raggiungibile");
        } catch (IOException e) {
            System.err.println("Impossibile collegarsi al server");
        }
    }

    public void scrivi(String messaggio){
        output.println(messaggio);
    }

    public String leggi(){
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void chiudi(){
        try {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
            if (socket != null) {
                socket.close();
                System.out.println("Connessione chiusa");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
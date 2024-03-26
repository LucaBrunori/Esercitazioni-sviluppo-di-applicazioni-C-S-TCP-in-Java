package org.example;

import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Client {
    String nome;
    String colore;

    Socket socket;
    public Client (String nomeDefault, String coloreDefault){
        this.nome = nomeDefault;
        this.colore = coloreDefault;
    }

    public void connetti(String nomeServer, int portaServer){
        try {
            socket = new Socket(nomeServer, portaServer);
        } catch (UnknownHostException e) {
            System.err.println("Indirizzo IP non raggiungibile");
        } catch (IOException e) {
            System.err.println("Impossibile collegarsi al server");
        }
    }
    public void scrivi(){

    }

    public void leggi(){

    }

    public void chiudi(){

    }
}

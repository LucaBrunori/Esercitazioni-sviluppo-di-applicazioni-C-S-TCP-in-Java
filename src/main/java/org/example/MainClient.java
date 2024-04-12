package org.example;

public class MainClient {
    public static void main(String[] args) {
        String nomeServer = "127.0.0.1";
        int portaServer = 11169;
        Client client = new Client(nomeServer, portaServer);
        client.connetti("127.0.0.1", 11169);
        client.scrivi("Sono il client mandami...");
        String messaggioDalServer = client.leggi();
        System.out.println("Messaggio dal server: " + messaggioDalServer);
        client.chiudi();
    }
}
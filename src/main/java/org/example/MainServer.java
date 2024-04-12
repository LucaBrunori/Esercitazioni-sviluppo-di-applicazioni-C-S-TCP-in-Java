package org.example;

public class MainServer {
    public static void main(String[] args) {
        int portaServer = 11169;
        Server server = new Server(portaServer);
        System.out.println("Server in attesa di connessioni...");

        server.attendi();
        System.out.println("Connessione accettata.");

        String messaggioDalClient = server.leggi();
        System.out.println("Messaggio dal client: " + messaggioDalClient);

        server.scrivi("Messaggio ricevuto correttamente dal server.");

        server.chiudi();
    }
}
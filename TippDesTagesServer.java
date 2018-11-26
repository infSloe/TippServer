// aus Java von Kopf bis Fuß
// 

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TippDesTagesServer {

    String[] tippListe = {"Nimm kleinere Bissen zu dir.", 
            "Heute schon gelacht?", 
            "Mit einem Wort: unmöglich!", 
            "Sei ehrlich, nur heute mal.", 
            "Denk doch noch mal über diesen Haarschnitt nach."};
    int portNummer;

    public TippDesTagesServer()
    {
        portNummer = 4242;

    }

    public void los() {

        try {
            ServerSocket serverSock = new ServerSocket(portNummer);

            while(true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String tipp = getTipp();
                writer.println(tipp);
                writer.close();
                //System.out.println(tipp);
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    } // los() schließen

    private String getTipp() {
        int random = (int) (Math.random() * tippListe.length);
        return tippListe[random];
    }

    public static void main(String[] args)
    {
        TippDesTagesServer server = new TippDesTagesServer();
        server.los();
    }
}


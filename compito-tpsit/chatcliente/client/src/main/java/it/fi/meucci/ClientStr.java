package it.fi.meucci;

import java.io.*;
import java.net.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import main.java.it.fi.meucci.Messaggio;
import main.java.it.fi.meucci.Persona;

public class ClientStr {
    String nomeServer="localhost";
    int portaServer = 7777;
    Socket miosocket;
    BufferedReader tastiera; 
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalSever;

    public Socket connetti(){
        System.out.println("2 CLIENT partito in esecuzione: ");
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new Socket(nomeServer, portaServer);
            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalSever = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
        }

        catch (UnknownHostException e){
            System.err.println("Host sconosciuto");
        }

        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione");
            System.exit(1);
        }

        return miosocket;
    }

    public void comunica(){
        try{
            for(;;){
                XmlMapper Messaggio = new XmlMapper();
                System.out.println("creazione lista: "+'\n');
                Messaggio.writeValue(new File("messaggio.xml"), aggiungi_persone());
                System.out.println("invio lista: "+'\n');
                outVersoServer.writeBytes(Messaggio+'\n');

                //stringaRicevutaDalServer= inDalSever.readLine();
                //System.out.println("8 risposta del server" + '\n'+stringaRicevutaDalServer);
            }
            //System.out.println("9 CLIENT: termina nelaborazione e chiude connessione");
            //miosocket.close();
        }

        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione");
            System.exit(1);
        }
        }

        Messaggio aggiungi_persone(){
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            Persona p = Persona();
            Messaggio m = new Messaggio();
            System.out.println("Scelta nazionalità"+'\n');
            stringaUtente = tastiera.readLine();
            m.setNazioneRichiesta(stringaUtente);

            if(m.getNazioneRichiesta()== null){
            int i=0;
            while (tastiera.readLine() == "stop") {
                i++;
                System.out.println("inserimento Persona numero: " + i +'\n');
                System.out.println("Nome"+'\n');
                stringaUtente = tastiera.readLine();
                p.setNome(stringaUtente);
                System.out.println("Cognome"+'\n');
                stringaUtente = tastiera.readLine();
                p.setCognome(stringaUtente);
                System.out.println("Nazionalita' persona"+'\n');
                stringaUtente = tastiera.readLine();
                p.setNazioneDiResidenza(stringaUtente);
                m.add(p);
            }
            }
            return m;
            }

}

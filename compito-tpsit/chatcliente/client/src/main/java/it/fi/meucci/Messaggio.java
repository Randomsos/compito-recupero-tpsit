package main.java.it.fi.meucci;

import java.util.ArrayList;

public class Messaggio {

    String nazioneRichiesta;
    ArrayList<Persona> persone = new ArrayList<>();

    public Messaggio(String nazioneRichiesta) {
        this.nazioneRichiesta = nazioneRichiesta;
    }

    public Messaggio() {
    }

    //GETTER E SETTER

    public String getNazioneRichiesta() {
        return nazioneRichiesta;
    }

    public void setNazioneRichiesta(String nazioneRichiesta) {
        this.nazioneRichiesta = nazioneRichiesta;
    }

    public ArrayList<Persona> getPersone() {
        return persone;
    }

    public void setPersone(ArrayList<Persona> persone) {
        this.persone = persone;
    }
    
    //METODI
    
    public void add(Persona p){
        persone.add(p);
    }
    
}

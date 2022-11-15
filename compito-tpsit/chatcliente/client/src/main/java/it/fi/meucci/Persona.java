package main.java.it.fi.meucci;

public class Persona {

    String nome;
    String cognome;
    String nazioneDiResidenza;

    public Persona() {
    }
    public Persona(String nome, String cognome, String nazioneDiResidenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazioneDiResidenza = nazioneDiResidenza;
    }

    //GETTER E SETTER

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getNazioneDiResidenza() {
        return nazioneDiResidenza;
    }
    public void setNazioneDiResidenza(String nazioneDiResidenza) {
        this.nazioneDiResidenza = nazioneDiResidenza;
    }
    
}

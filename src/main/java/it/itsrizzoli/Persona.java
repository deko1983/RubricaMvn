package it.itsrizzoli;

import java.io.Serializable;

public class Persona implements Serializable {

    String nome;
    String cognome;
    String telefono;

    public Persona(String nome, String cognome)  {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Persona(String nome, String cognome, String telefono)  {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persona)  {
            Persona p = (Persona) obj;

            return this.nome.equalsIgnoreCase(p.nome) && this.cognome.equalsIgnoreCase(p.cognome);
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: " + this.nome).append("\n")
        .append("Cognome: " + this.cognome).append("\n")
        .append("Telefono: " + this.telefono);

        return sb.toString();
    }
}

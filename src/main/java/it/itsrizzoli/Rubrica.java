package it.itsrizzoli;

import java.io.Serializable;

public class Rubrica implements Serializable {

    Persona[] elenco;
    int ultimoContattoInserito = 0;

    public Rubrica(int maxContatti)  {
        elenco = new Persona[maxContatti];
    }

    public Rubrica()  {
        elenco = new Persona[50];
    }

    public void printAll()  {
        for (int i=0; i < elenco.length; i=i+1)  {
            if (elenco[i] != null)  {
                System.out.println("Contatto " + i );
                System.out.println(elenco[i] + "\n");
            }
                
        }
            
    }

    public void addContatto(Persona contatto)  {
        elenco[ultimoContattoInserito] = contatto;
        ultimoContattoInserito = ultimoContattoInserito+1;
    }

    public Persona cercaContattoPerCognome(String cognome)  {
        for (int i=0; i < elenco.length; i=i+1)  {
            if (elenco[i] != null && elenco[i].cognome.equalsIgnoreCase(cognome))
                return elenco[i];
        }

        return null;
    }

    public Persona cercaContattoPerNome(String nome)  {
        return null;   
    }

    public Persona[] cercaContattiPerCognome(String cognome)  {
        int contattiTrovati = 0;
        Persona[] contattiCorrispondenti = null;
        // conto gli elementi corrispondenti alla ricerca
        for (int i=0; i < elenco.length; i=i+1)  {
            if (elenco[i] != null && elenco[i].cognome.equalsIgnoreCase(cognome))
                contattiTrovati = contattiTrovati+1;
        }

        if (contattiTrovati > 0)  {
            contattiCorrispondenti = new Persona[contattiTrovati]; 
            // popolo l'array di ritorno (contattiCorrispondenti)
            int j=0;
            for (int i=0; i < elenco.length; i=i+1)  {
                if (elenco[i] != null && elenco[i].cognome.equalsIgnoreCase(cognome))  {
                    contattiCorrispondenti[j] = elenco[i];
                    j = j+1;
                }
            }
        }

        return contattiCorrispondenti;
    }

    public Persona[] cercaContattiPerNome(String nome)  {
        int contattiTrovati = 0;
        Persona[] contattiCorrispondenti = null;
        // conto gli elementi corrispondenti alla ricerca
        for (int i=0; i < elenco.length; i=i+1)  {
            if (elenco[i] != null && elenco[i].nome.equalsIgnoreCase(nome))
                contattiTrovati = contattiTrovati+1;
        }

        if (contattiTrovati > 0)  {
            contattiCorrispondenti = new Persona[contattiTrovati]; 
            // popolo l'array di ritorno (contattiCorrispondenti)
            int j=0;
            for (int i=0; i < elenco.length; i=i+1)  {
                if (elenco[i] != null && elenco[i].nome.equalsIgnoreCase(nome))  {
                    contattiCorrispondenti[j] = elenco[i];
                    j = j+1;
                }
            }
        }

        return contattiCorrispondenti;
    }
    // ... a seguire, o il nome o il cognome del contatto deve iniziare
    // con il carattere ricevuto da parametro
    public Persona[] cercaContattiPerIniziale(char iniziale)  {
        iniziale = Character.toLowerCase(iniziale);
        int contattiTrovati = 0;
        Persona[] contattiCorrispondenti = null;
        // conto gli elementi corrispondenti alla ricerca
        for (int i=0; i < elenco.length; i=i+1)  {
            if (elenco[i] != null 
                && (elenco[i].nome.toLowerCase().charAt(0) == iniziale || 
                    elenco[i].cognome.toLowerCase().charAt(0) == iniziale))
                contattiTrovati = contattiTrovati+1;
        }

        if (contattiTrovati > 0)  {
            contattiCorrispondenti = new Persona[contattiTrovati]; 
            // popolo l'array di ritorno (contattiCorrispondenti)
            int j=0;
            for (int i=0; i < elenco.length; i=i+1)  {
                if (elenco[i] != null 
                    && (elenco[i].nome.toLowerCase().charAt(0) == iniziale || 
                        elenco[i].cognome.toLowerCase().charAt(0) == iniziale)) {
            
                    contattiCorrispondenti[j] = elenco[i];
                    j = j+1;
                }
            }
        }

        return contattiCorrispondenti;
    }

    // ... a seguire, o il nome o il cognome del contatto deve contenere
    // la stringa ricevuta da parametro (pattern dev'essere lunga almeno 3 caratteri)
    // altrimenti non faccio la ricerca e ritorno null
    public Persona[] cercaContattiPerPattern(String pattern)  {
        if (pattern == null || pattern.length() < 3)
            return null;

        int contattiTrovati = 0;
        Persona[] contattiCorrispondenti = null;
        // conto gli elementi corrispondenti alla ricerca
        for (int i=0; i < elenco.length; i=i+1)  {
            if (elenco[i] != null 
                && (elenco[i].nome.toLowerCase().indexOf(pattern.toLowerCase()) > 0 || 
                    elenco[i].cognome.toLowerCase().indexOf(pattern.toLowerCase()) > 0))
                contattiTrovati = contattiTrovati+1;
        }

        if (contattiTrovati > 0)  {
            contattiCorrispondenti = new Persona[contattiTrovati]; 
            // popolo l'array di ritorno (contattiCorrispondenti)
            int j=0;
            for (int i=0; i < elenco.length; i=i+1)  {
                if (elenco[i] != null 
                    && (elenco[i].nome.toLowerCase().indexOf(pattern.toLowerCase()) > 0 || 
                    elenco[i].cognome.toLowerCase().indexOf(pattern.toLowerCase()) > 0)) {
            
                    contattiCorrispondenti[j] = elenco[i];
                    j = j+1;
                }
            }
        }

        return contattiCorrispondenti;
    }
}

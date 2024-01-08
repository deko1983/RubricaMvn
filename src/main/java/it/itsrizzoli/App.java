package it.itsrizzoli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    private static String FILE_NAME = "rubrica.ser";
    
    public static void main(String[] args) throws Exception {
        
        MenuManager menuManager = new MenuManager();
        Rubrica rubrica = null;
        
        File f = new File(FILE_NAME);
        if (f.exists())    
            rubrica = deserializzaCollezione(FILE_NAME);
        else
            rubrica = new Rubrica();

        menuManager.runMenu(rubrica);

        serializzaCollezione(rubrica, FILE_NAME);
        System.out.println("Collezione serializzata su file: " + FILE_NAME);
    }

    // Metodo per serializzare a file
    private static void serializzaCollezione(Rubrica rubrica, String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(rubrica);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo per deserializzare una collezione da file
    private static Rubrica deserializzaCollezione(String nomeFile) {
        Rubrica rubrica = new Rubrica();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            rubrica = (Rubrica) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rubrica;
    }
}

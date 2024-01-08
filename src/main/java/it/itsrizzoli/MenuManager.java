package it.itsrizzoli;

import java.util.Scanner;

public class MenuManager {

    // Metodo per eseguire il menu
    public void runMenu(Rubrica rubrica) {
        Scanner scanner = new Scanner(System.in);
    
        int choice;
        do {
            char keyPressed;
            // Visualizzazione delle opzioni del menu
            displayMenu();

            // Lettura della scelta dell'utente
            System.out.print("Inserisci il numero dell'opzione desiderata: ");
            choice = scanner.nextInt();

            scanner.nextLine();

            // pulisco la console
            clearConsole();
            // Gestione della scelta dell'utente
            switch (choice) {
                case 1:
                    rubrica.addContatto(formNuovaPersona(scanner));
                    break;
                case 2:
                    formRicercaPerCognome(rubrica);
                    System.out.println("Premi 'q' per tornare al menù principale");
                    keyPressed = scanner.next().charAt(0);
                    if (keyPressed == 'q')
                        break;
                case 3:
                    System.out.println("Hai scelto l'opzione 3: Esegui Azione 3");
                    break;
                case 4:
                    rubrica.printAll();
                    System.out.println("Premi 'q' per tornare al menù principale");
                    keyPressed = scanner.next().charAt(0);
                    if (keyPressed == 'q')
                        break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }

            clearConsole();
           
        } while (choice != 0);

        // Chiudi lo scanner
        scanner.close();
    }

    private void formRicercaPerCognome(Rubrica rubrica) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci cognome da ricercare: ");
        String cognome = scanner.nextLine();

        Persona[] rubricaFiltrata = rubrica.cercaContattiPerCognome(cognome);

        if (rubricaFiltrata != null)
            Rubrica.print(rubricaFiltrata);
        else
            System.out.println("Nessun risultato trovato");

    }

    // Metodo per visualizzare le opzioni del menu
    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Aggiungi contatto");
        System.out.println("2. Ricerca per cognome");
        System.out.println("3. Ricerca per nome");
        System.out.println("4. Vedi tutto");
        System.out.println("0. Esci");
    }

    private void clearConsole() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private Persona formNuovaPersona(Scanner scanner) {
        //Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();

        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

        return new Persona(nome, cognome, telefono);
    }
}

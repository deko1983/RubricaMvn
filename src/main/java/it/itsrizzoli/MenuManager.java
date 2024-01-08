import java.util.Scanner;

public class MenuManager {

    // Metodo per eseguire il menu
    public void runMenu(Rubrica rubrica) {
        Scanner scanner = new Scanner(System.in);
    
        int choice;
        do {
            // Visualizzazione delle opzioni del menu
            displayMenu();

            // Lettura della scelta dell'utente
            System.out.print("Inserisci il numero dell'opzione desiderata: ");
            choice = scanner.nextInt();

            // pulisco la console
            clearConsole();
            // Gestione della scelta dell'utente
            switch (choice) {
                case 1:
                    rubrica.addContatto(formNuovaPersona());
                    break;
                case 2:
                    System.out.println("Hai scelto l'opzione 2: Esegui Azione 2");
                    break;
                case 3:
                    System.out.println("Hai scelto l'opzione 3: Esegui Azione 3");
                    break;
                case 4:
                    rubrica.printAll();
                    System.out.println("Premi 'q' per tornare al menù principale");
                    char keyPressed = scanner.next().charAt(0);
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

    private Persona formNuovaPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();

        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

        return new Persona(nome, cognome, telefono);
    }
}

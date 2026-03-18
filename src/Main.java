import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduceți numărul de deplasare pozitiv(dreapta)/negativ(stanga): ");
        int shift = sc.nextInt();
        sc.nextLine();

        AlphabetShifter shifter = new AlphabetShifter();
        shifter.shiftAlphabet(shift);

        System.out.print("Al doilea vector cu literele mutate: ");
        for (String letter : shifter.getShiftedAlphabet()) {
            System.out.print(letter + " ");
        }
        System.out.println();

        String parola;
        boolean esteValida;
        do {
            System.out.print("Introduceti parola: ");
            parola = sc.nextLine();
            esteValida = ValidareParola.esteValida(parola);

            if (!esteValida) {
                System.out.println("Parola introdusă nu este validă. Introduceți doar litere alfabetice.");
            }
        } while (!esteValida);

        CriptareThread criptareThread = new CriptareThread(parola, shifter);
        criptareThread.start();

        try {
            criptareThread.join();
        } catch (InterruptedException e) {
            System.out.println("Eroare la așteptarea thread-ului de criptare: " + e.getMessage());
        }

        String parolaCriptata = criptareThread.getParolaCriptata();

        DecriptareThread decriptareThread = new DecriptareThread(shifter);
        decriptareThread.setParolaCriptata(parolaCriptata);
        decriptareThread.start();
    }
}
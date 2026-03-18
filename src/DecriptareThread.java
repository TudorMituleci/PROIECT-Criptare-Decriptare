import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DecriptareThread extends Thread {
    private AlphabetShifter shifter;
    private String parolaCriptata;

    public DecriptareThread(AlphabetShifter shifter) {
        this.shifter = shifter;
    }

    public void setParolaCriptata(String parolaCriptata) {
        this.parolaCriptata = parolaCriptata;
    }

    @Override
    public void run() {
        System.out.println("DecriptareThread a început execuția.");
        try (BufferedReader reader = new BufferedReader(new FileReader("parola_criptata.txt"))) {
            // Citește parola criptată din fișier
            parolaCriptata = reader.readLine();
            if (parolaCriptata == null || parolaCriptata.isEmpty()) {
                throw new IOException("Fișierul parola_criptata.txt este gol sau invalid.");
            }

            // Crearea unei instanțe Decriptare și decriptarea parolei
            Decriptare decriptare = new Decriptare(shifter);
            String parolaDecriptata = decriptare.modificaText(parolaCriptata);

            // Afișează rezultatul
            System.out.println("Parola după decriptare este: " + parolaDecriptata);
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Eroare în DecriptareThread: " + e.getMessage());
        }
        System.out.println("DecriptareThread a terminat execuția.");
    }
}
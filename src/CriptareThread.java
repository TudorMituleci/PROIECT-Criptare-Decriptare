import java.io.FileWriter;
import java.io.IOException;

public class CriptareThread extends Thread {
    private String parola;
    private AlphabetShifter shifter;
    private String parolaCriptata;

    public CriptareThread(String parola, AlphabetShifter shifter) {
        this.parola = parola;
        this.shifter = shifter;
    }

    @Override
    public void run() {
        System.out.println("CriptareThread a început execuția.");
        try {
            Criptare criptare = new Criptare(shifter);
            parolaCriptata = criptare.modificaText(parola);

            System.out.println("Parola dupa criptare este: " + parolaCriptata);

            String fisier = "parola_criptata.txt";
            try (FileWriter writer = new FileWriter(fisier)) {
                writer.write(parolaCriptata);
                System.out.println("Parola criptata a fost scrisa in fisierul " + fisier);
            }
        } catch (Exception e) {
            System.out.println("Eroare in CriptareThread: " + e.getMessage());
        }
        System.out.println("CriptareThread a terminat execuția.");
    }


    public String getParolaCriptata() {
        return parolaCriptata;
    }
}

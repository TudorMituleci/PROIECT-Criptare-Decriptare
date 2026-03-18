import java.util.Scanner;

public class AlphabetShifter {
    private String[] alphabet;
    private String[] shiftedAlphabet;

    public AlphabetShifter() {
        this.alphabet = new String[] {
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
        };
        this.shiftedAlphabet = new String[alphabet.length];
    }

    public void shiftAlphabet(int shift) {
        int length = alphabet.length;
        for (int i = 0; i < length; i++) {
            int newIndex = ((i + shift) % length + length) % length;
            shiftedAlphabet[newIndex] = alphabet[i];
        }
    }

    public String[] getShiftedAlphabet() {
        return shiftedAlphabet;
    }

    public String[] getAlphabet(){
        return alphabet;
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class CriptareDecriptareTest {
    @Test
    public void testCriptareDecriptare(){
        AlphabetShifter shifter = new AlphabetShifter();
        shifter.shiftAlphabet(3);

        Criptare criptare = new Criptare(shifter);
        Decriptare decriptare = new Decriptare(shifter);

        String textOriginal = "parola";
        String textCriptat = criptare.modificaText(textOriginal);
        String textDecriptat = decriptare.modificaText(textCriptat);

        assertEquals(textOriginal, textDecriptat);
    }
}

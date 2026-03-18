import org.junit.Test;
import static org.junit.Assert.*;

public class ValidareParolaTest {
    @Test
    public void testParolaValida(){
        ValidareParola validator = new ValidareParola();
        assertTrue(validator.esteValida("parola"));
        assertTrue(validator.esteValida("Testare"));
    }

    @Test
    public void testParolaInvalida(){
        ValidareParola validator = new ValidareParola();
        assertFalse(validator.esteValida("parola123"));
        assertFalse(validator.esteValida("test!@#"));
    }
}

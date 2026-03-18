public class Criptare {
    private AlphabetShifter shifter;

    public Criptare(AlphabetShifter shifter) {
        this.shifter = shifter;
    }

    public String modificaText(String inputText) {
        StringBuilder modificaText = new StringBuilder();

        for (char c : inputText.toCharArray()) {
            boolean isUpperCase = Character.isUpperCase(c);

            char cLower = Character.toLowerCase(c);
            String cAsString = String.valueOf(cLower);

            boolean found = false;

            for (int i = 0; i < shifter.getAlphabet().length; i++) {
                if (cAsString.equals(shifter.getAlphabet()[i])) {
                    if (isUpperCase) {
                        modificaText.append("#");
                    }
                    modificaText.append(shifter.getShiftedAlphabet()[i]);
                    found = true;
                    break;
                }
            }
        }
        return modificaText.toString();
    }
}
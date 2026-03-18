public class Decriptare {
    private AlphabetShifter shifter;

    public Decriptare(AlphabetShifter shifter) {
        this.shifter = shifter;
    }

    public String modificaText(String inputText) {
        StringBuilder modificaText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);

            if (c == '#') {
                i++;
                if (i >= inputText.length()) {
                    break;
                }
                c = inputText.charAt(i);
                char cLower = Character.toLowerCase(c);
                String cAsString = String.valueOf(cLower);

                boolean found = false;

                for (int j = 0; j < shifter.getShiftedAlphabet().length; j++) {
                    if (cAsString.equals(shifter.getShiftedAlphabet()[j])) {
                        modificaText.append(Character.toUpperCase(shifter.getAlphabet()[j].charAt(0)));
                        found = true;
                        break;
                    }
                }

            } else {
                char cLower = Character.toLowerCase(c);
                String cAsString = String.valueOf(cLower);

                boolean found = false;

                for (int j = 0; j < shifter.getShiftedAlphabet().length; j++) {
                    if (cAsString.equals(shifter.getShiftedAlphabet()[j])) {
                        modificaText.append(shifter.getAlphabet()[j]);
                        found = true;
                        break;
                    }
                }
            }
        }
        return modificaText.toString();
    }
}
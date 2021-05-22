import java.util.HashMap;

public class QuickFoxSort {

    private static final String SENTENCE = "the quick brown fox jumps over the lazy dog";

    private static class AssignedChar{

        public char c;
        public int weight;

        public AssignedChar(char c, int weight){
            this.c = c;
            this.weight = weight;
        }
    }

    public static String sort(CharSequence input){
        int[] weightValues = assignValues(input);

        AssignedChar[] assignedChars = new AssignedChar[weightValues.length];

        for (int i = 0; i < weightValues.length; i++) {
            assignedChars[i] = new AssignedChar(input.charAt(i), weightValues[i]);
        }

        quickSort(assignedChars, 0, assignedChars.length - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < assignedChars.length; i++) {
            sb.append(assignedChars[i].c);
        }

        return  sb.toString();
    }

    private static void quickSort(AssignedChar[] assignedChars, int begin, int end){
        if (begin < end) {
            int partitionIndex = partition(assignedChars, begin, end);

            quickSort(assignedChars, begin, partitionIndex-1);
            quickSort(assignedChars, partitionIndex+1, end);
        }
    }

    private static int partition(AssignedChar[] assignedChars, int begin, int end) {
        AssignedChar pivot = assignedChars[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (assignedChars[j].weight <= pivot.weight) {
                i++;

                AssignedChar temp = assignedChars[i];
                assignedChars[i] = assignedChars[j];
                assignedChars[j] = temp;
            }
        }

        AssignedChar temp = assignedChars[i+1];
        assignedChars[i+1] = assignedChars[end];
        assignedChars[end] = temp;

        return i+1;
    }

    private static int[] assignValues(CharSequence input){
        int[] output = new int[input.length()];

        HashMap<Character, Integer> searchAfter = new HashMap<>();

        for (int i = 0; i < output.length; i++) {
            char c = Character.toLowerCase(input.charAt(i));
            if (c == ' ' || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                Integer minDex = searchAfter.get(c);

                if (minDex == null){
                    minDex = 0;
                }

                int index = SENTENCE.indexOf(c, minDex + 1);

                if (index < 0){
                    index = SENTENCE.indexOf(c);
                }

                searchAfter.put(c, index);
                output[i] = index;

            } else {
                output[i] = c + 128;
            }
        }

        return output;
    }
}

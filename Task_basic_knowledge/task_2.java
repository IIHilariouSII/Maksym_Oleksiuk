public class task_2 {
    private static char firstNonRepeatingLetter(String str) {
        String lowerStr = str.toLowerCase();
        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);
            String subString1 = lowerStr.substring(0, i);
            String subString2 = lowerStr.substring(i + 1);
            if (!subString1.contains(Character.toString(ch)) && !subString2.contains(Character.toString(ch))) {
                return ch;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingLetter("stress"));
    }
}
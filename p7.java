public class p7 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        String T = preprocess(s);
        char[] S = T.toCharArray();
        int[] P = new int[S.length];

        int c = 0, r = 0;

        for (int i = 1; i < S.length - 1; i++) {
            int m = 2 * c - i;

            if (i < r)
                P[i] = Math.min(r - i, P[m]);

            while (S[i + 1 + P[i]] == S[i - 1 - P[i]])
                P[i]++;

            if (i + P[i] > r) {
                c = i;
                r = i + P[i];
            }
        }

        int max = 0, idx = 0;
        for (int i = 1; i < P.length - 1; i++) {
            if (P[i] > max) {
                max = P[i];
                idx = i;
            }
        }

        int start = (idx - max) / 2;
        return s.substring(start, start + max);
    }

    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#$");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bababaab"));
    }
}

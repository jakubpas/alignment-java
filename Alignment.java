import java.util.List;

public class Alignment {

    public static List<String> align(List<String> fasta) {

        String seq1 = fasta.get(1);
        String seq2 = fasta.get(3);

        int[][] TraceBack = new int[seq1.length() + 1][seq2.length() + 1];

        for (int i = 0; i <= seq1.length(); i++) {
            TraceBack[i][0] = i;
        }

        for (int i = 0; i <= seq2.length(); i++) {
            TraceBack[0][i] = i;
        }

        for (int i = 1; i <= seq1.length(); i++) {
            for (int j = 1; j <= seq2.length(); j++) {
                if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
                    TraceBack[i][j] = TraceBack[i - 1][j - 1];
                } else {
                    TraceBack[i][j] = Math.min(TraceBack[i - 1][j], TraceBack[i][j - 1]) + 1;
                }
            }
        }

        StringBuilder aln1 = new StringBuilder(), aln2 = new StringBuilder();

        for (int i = seq1.length(), j = seq2.length(); i > 0 || j > 0; ) {
            if (i > 0 && TraceBack[i][j] == TraceBack[i - 1][j] + 1) {
                aln1.append(seq1.charAt(--i));
                aln2.append("-");
            } else if (j > 0 && TraceBack[i][j] == TraceBack[i][j - 1] + 1) {
                aln2.append(seq2.charAt(--j));
                aln1.append("-");
            } else if (i > 0 && j > 0 && TraceBack[i][j] == TraceBack[i - 1][j - 1]) {
                aln1.append(seq1.charAt(--i));
                aln2.append(seq2.charAt(--j));
            }
        }

        fasta.set(1, aln1.reverse().toString());
        fasta.set(3, aln2.reverse().toString());
        return fasta;
    }
}

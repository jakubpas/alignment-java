# Java pairwise global alignment

(c) 2005 by Jakub Pas

* Java implementation of global alignment using a variation of Levenshtein[1] distance
* Rewritten to Java
* It takes first two sequences from fasta[2] file (one sequence per line) and returns aligned sequences
also in fasta format.

##Usage:

`javac *.java`

`java -cp . Main alignment.fas`

Or create jar file:

`javac *.java`

`jar cvfm alignment.jar manifest.txt *.class`

`java -jar alignment.jar alignment.fas`

[1]  Levenshtein, Vladimir I (1965).
    Binary codes capable of correcting deletions, insertions, and reversals.
    Soviet Physics Doklady. 10 (8): 707–710.

[2] Pearson W.R. and Lipman D.J. (1988)
    Improved tools for biological sequence comparison.
    Proc. Natl. Acad. Sci. USA 85(8): 2444-2448.

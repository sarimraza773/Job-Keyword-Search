import java.io.*;
import java.util.*;

public class ResumeKeywordAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Resume Keyword Analyzer ===");
        System.out.print("Enter resume file path (e.g. resume.txt): ");
        String resumePath = sc.nextLine();

        System.out.print("Enter job description file path (e.g. job.txt): ");
        String jobPath = sc.nextLine();

        try {
            // Read and process both files
            Set<String> resumeWords = extractKeywords(readFile(resumePath));
            Set<String> jobWords = extractKeywords(readFile(jobPath));

            // Calculate overlap
            Set<String> common = new HashSet<>(resumeWords);
            common.retainAll(jobWords);

            double matchPercent = (double) common.size() / jobWords.size() * 100;

            // Find missing keywords
            Set<String> missing = new HashSet<>(jobWords);
            missing.removeAll(resumeWords);

            System.out.println("\n=== ANALYSIS REPORT ===");
            System.out.println("Match Score: " + String.format("%.2f", matchPercent) + "%");
            System.out.println("\nCommon Keywords: " + common);
            System.out.println("\nMissing Keywords: " + missing);

            // Save output to file
            saveReport(matchPercent, common, missing);
            System.out.println("\nReport saved as 'report.txt'");

        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }

    // Read file and return content as a string
    public static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(" ");
        }
        br.close();
        return sb.toString();
    }

    // Extract cleaned keywords from text
    public static Set<String> extractKeywords(String text) {
        Set<String> keywords = new HashSet<>();
        String[] words = text.toLowerCase()
                             .replaceAll("[^a-z0-9 ]", " ")
                             .split("\s+");
        for (String word : words) {
            if (word.length() > 2 && !isStopWord(word)) {
                keywords.add(word);
            }
        }
        return keywords;
    }

    // Filter out common stopwords
    public static boolean isStopWord(String word) {
        String[] stopWords = {"the", "and", "for", "you", "are", "with", "from", "that", "this", "have", "was", "not", "but", "all", "your", "our"};
        return Arrays.asList(stopWords).contains(word);
    }

    // Save results to a text report
    public static void saveReport(double score, Set<String> common, Set<String> missing) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"));
        writer.write("=== Resume Keyword Analyzer Report ===\n");
        writer.write("Match Score: " + String.format("%.2f", score) + "%\n\n");
        writer.write("Common Keywords:\n" + common + "\n\n");
        writer.write("Missing Keywords:\n" + missing + "\n");
        writer.close();
    }
}

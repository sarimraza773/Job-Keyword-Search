# Resume Keyword Analyzer (Java)

A simple Java tool that compares your resume with a job description and provides a match score,
highlighting **common** and **missing** keywords.

## 💡 Features
- Reads text from two files (`resume.txt` and `job.txt`)
- Cleans and tokenizes words
- Calculates keyword overlap
- Displays match percentage
- Exports a `report.txt` file automatically

## ⚙️ How to Run
1. Open terminal / command prompt inside the project folder.
2. Compile the Java file:
   ```bash
   javac ResumeKeywordAnalyzer.java
   ```
3. Run the program:
   ```bash
   java ResumeKeywordAnalyzer
   ```
4. Enter:
   ```
   resume.txt
   job.txt
   ```

## 📈 Example Output
```
=== Resume Keyword Analyzer ===
Enter resume file path (e.g. resume.txt): resume.txt
Enter job description file path (e.g. job.txt): job.txt

=== ANALYSIS REPORT ===
Match Score: 60.00%
Common Keywords: [java, algorithms, development]
Missing Keywords: [structures, data, front, end, intern]
```

## 🧩 Future Improvements
- Weighted scoring for technical terms (e.g., Java > Python > HTML)
- GUI interface using JavaFX
- PDF input using Apache PDFBox

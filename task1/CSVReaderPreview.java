package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String path = "assignment1-csvpreview-chsreelaasya/dataset/dataset.csv";
        String line;
        String sep = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty CSV file.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            String[] cols = header.split(sep);
            System.out.println("Columns:");
            for (String col : cols) {
                System.out.print(col + " ");
            }

            System.out.println("\nTotal columns: " + cols.length);
            System.out.println("\nFirst 5 Records:\n");

            int cnt = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(sep);
                System.out.println(String.join(" ", row));
                if (++cnt == 5) break;
            }

            while (br.readLine() != null) cnt++;

            System.out.println("\nTotal Records (excluding header): " + cnt);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

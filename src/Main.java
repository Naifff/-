import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String csvFile = "example.csv";
        String csvOutputFile = "out.csv";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line = "";
        String cvsSplitBy = ";";
        String[][] matrix = new String[5][5];
        int counter = 0;
        Parser p = new Parser();

        try {
            bw = new BufferedWriter(new FileWriter(csvOutputFile));
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {


                String[] string = line.split(cvsSplitBy);

                for (int i = 0; i < string.length; i++) {
                    if (p.setDone(string[i]).equals("peremennaya")) {
                        System.out.print(string[i] + "=");
                        String[] arr = p.parsVar(string[i]).split(";");
                        matrix[counter][i] = matrix[Integer.valueOf(arr[0])][Integer.valueOf(arr[1])];
                        System.out.println(matrix[counter][i]);
                        bw.write(string[i]);
                        continue;
                    }

                    matrix[counter][i] = string[i];
                    bw.write(string[i]);

                }
                System.out.println();
                bw.newLine();
                bw.flush();
                counter++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}

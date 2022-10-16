import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;





public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        //File outf = new File("OutputFile");

        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                //System.out.println(line);
                File outF = new File("outFile");
                PrintWriter out = new PrintWriter(outF);

                ArrayList<Object> list = new ArrayList<>();  // for each line return list of number, operation, string
                list = FileProcessor.processLine(line);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }

    }

    /**
     *
     * @param line
     * @return ArrayList of Listnodes of numbers high order to low. char containing operator. String containing left hand
     * side of = sign of output
     */
    public static ArrayList<Object> processLine(String line) {
        ArrayList<Object> listy = new ArrayList<>();
        LinkedList number = new LinkedList();
        String out = "";
        for(char ch: line.toCharArray()) {
            if(ch== '+' || ch =='*' || ch == '^') {
                listy.add(number);
                number = new LinkedList();          // reset number
                listy.add(ch);
                out += (" " + ch + " ");
                continue;

            }
           if(Character.isDigit(ch)) {
               int val = ch - '0';
               number.appendNode(val);
               out += ch;
               continue;
           }
        }

        listy.add(number);
        if(out.length() > 0) {
            out += " = ";
            listy.add(out);
            System.out.println(out);
        }
        return listy;
    }


}

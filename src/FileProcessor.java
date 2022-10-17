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

        try (Scanner scan = new Scanner(infile)) {
            File outF = new File("outFile");
            PrintWriter out = new PrintWriter(outF);
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                if(line.length() == 0) {                    // skip empty lines
                    continue;
                }
                ArrayList<Object> list = new ArrayList<>();  // for each line return list of number, operation, string
                list = FileProcessor.processLine(line);

                String reformatInput = (String) list.get(3);          // useful variable names
                LinkedList num1 = (LinkedList) list.get(0);
                LinkedList num2 = (LinkedList) list.get(2);
                char operator = (char)list.get(1);
                int total = 0;
                switch (operator) {
                    case '+':
                        total = num1.addLinkedList(num2);
                        break;
                    case '*':
                        //total = num1.multiplyLinkedList(num2);
                        break;
                    case '^':
                        //total = num1.exponentiateLinkedList(num2);
                        break;
                    default:
                        System.out.println("Bad operator");
                }
                out.println(reformatInput + total);
            }
            out.close();

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
        ArrayList<Object> listy = new ArrayList<>();                // list containts [linkedlist, operator, linkedlist, string]
        LinkedList number = new LinkedList();
        String out = "";
        String strDigit = "";
        for(char ch: line.toCharArray()) {
            if(ch== '+' || ch =='*' || ch == '^') {
                for(int index = strDigit.length(); index > 0; index--) {
                    int val = strDigit.charAt(index-1)-'0';
                    number.appendNode(val);
                }
                listy.add(number);
                number = new LinkedList();          // reset for next number
                strDigit = "";
                listy.add(ch);
                out += (" " + ch + " ");
                continue;

            }
           if(Character.isDigit(ch)) {
               strDigit += ch;
               out += ch;
               continue;
           }
        }
        for(int index = strDigit.length(); index > 0; index--) {
            int val = strDigit.charAt(index-1)-'0';
            number.appendNode(val);
        }
        listy.add(number);
        if(out.length() > 0) {
            out += " = ";
            listy.add(out);
        }
        return listy;
    }


}

import java.util.*;
import java.io.*;

/**************************************
 *              Project 1
 *               CIS 263
 *      Prof. Christian Trefftz
 *
 *   Project: Given a dictionary, find
 *    the largest set of anagram words
 *
 * @author Evan Johns
 **************************************/
public class Project1 {

    public Map<String, LinkedList<String>> map = new HashMap<>();


    /**
     * readData() reads and saves the data from a given file into a map
     * @param filename file to be read
     */
    public void readData(String filename) {
        Scanner inFS;
        FileInputStream fileByteStream;

        try {
            System.out.println("[LOG] Opening file...");
            // open the File and set delimiters
            fileByteStream = new FileInputStream(filename);
            inFS = new Scanner(fileByteStream);
            inFS.useDelimiter("[,\r\n]+");

            System.out.println("[LOG] Reading file...");
            // continue while there is more data to read
            while(inFS.hasNext()) {
                String word = inFS.next();
                word = word.toLowerCase();
                String key = convertToKey(word);
                if (!map.containsKey(key)) {
                    LinkedList <String> words = new LinkedList<>();
                    words.add(word);
                    map.put(key, words);
                }
                else {
                    map.get(key).add(word);
                }
            }
            System.out.println("[LOG] Closing file...");
            fileByteStream.close();

            // error while reading the file
        } catch(IOException error1) {
            System.out.println("[ERROR] Oops! Error related to: " + filename);
        }
    }


    /**
     * convertToKey() sorts the string alphabetically and returns it
     * @param word string to be sorted
     * @return sorted string
     */
    public String convertToKey(String word) {
        char [] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    /**
     * findMaxSize() finds the largest set of anagrams in the Map
     */
    public void findMaxSize() {
        System.out.println("[LOG] Finding max size set...");
        LinkedList<String> largestValue = new LinkedList<>();
        String largestKey = "";
        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > largestValue.size()) {
                largestValue = entry.getValue();
                largestKey = entry.getKey();
            }
        }
        System.out.println("[LOG] Printing max size set...");
        printMaxSize(largestValue, largestKey);
    }


    /**
     * printMaxSize() prints the largest set of anagrams in the Map
     * @param value Largest set of anagrams
     * @param key Key to the largest set of anagrams
     */
    public void printMaxSize(LinkedList<String> value, String key) {
        System.out.println("Set:");
        System.out.printf("\tSize: %s\n", value.size());
        System.out.printf("\tKey: %s\n", key);
        System.out.println("\tValues:");
        for (String temp : value) {
            System.out.printf("\t\t%s\n", temp);
        }
    }


    public static void main(String[] args) {
        Project1 p1 = new Project1();
        p1.readData("words.txt");
        p1.findMaxSize();
    }
}
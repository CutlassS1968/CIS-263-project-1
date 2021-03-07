import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Set;
public class Project1 {
    // Use a map to store the keys and the associated keys
    
    public void readData(String filename) {
        Scanner inFS = null;
        FileInputStream fileByteStream = null;

        try {
            // open the File and set delimiters
            fileByteStream = new FileInputStream(filename);
            inFS = new Scanner(fileByteStream);
            inFS.useDelimiter("[,\r\n]+");
           
            // continue while there is more data to read
            while(inFS.hasNext()) {
                String word = inFS.next();
                String key = convertToKey(word);
                // if (map.containsKey(key)) {
                    
                //}
                //else {
                    
                //}
                    
            }
            fileByteStream.close();

            // error while reading the file
        }catch(IOException error1) {
            System.out.println("Oops! Error related to: " + filename);
        }
    }
    // This method traverses the entire map and looks for the largest set
    // After traversing the entire map, it prints:
    //  - The key for the largest set
    //  - The size of the set
    //  - The elements in the set
    public void findMaxSize() {
             
    }
    // This method might be helpful. 
    // It takes a string and converts it into an array of characters
    // It sorts the array of characters
    // It creates a new String with that array of characters
    // All the words that are anagrams will have the same key
    public String convertToKey(String word) {
        char [] chars = word.toCharArray();
        Arrays.sort(chars);
        String result = new String(chars);
        return result;
    }
    
    public static void main(String args[]) {
        Project1 p1 = new Project1();
        p1.readData("words.txt");
        p1.findMaxSize();
    }
}
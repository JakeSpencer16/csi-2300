import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class count_words {
        public static void main(String[] args) {
            @SuppressWarnings("resource") // stops scanner warning
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the input file name: "); //allows the program to test any txt file
            String inputFile = scan.nextLine();
    
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) //Output file name is "output.txt"
                 { 
                Map<String, Integer> wordCounts = new HashMap<>();
    
                String line;
                while ((line = reader.readLine()) != null)
                 {
                    line = line.toLowerCase();
                    if (wordCounts.containsKey(line)) 
                    {
                        wordCounts.put(line, wordCounts.get(line) + 1);// if the word appers again, count is plus one
                    } else {
                        wordCounts.put(line, 1); //or just is left as one
                    }
                }
    
                for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) 
                {
                    writer.write(entry.getKey() + " " + entry.getValue());// puts all words and there counts in a list like format
                    writer.newLine();
                }
    
            } catch (IOException e) 
            {
                System.err.println("Error reading or writing files: " + e.getMessage()); // if file is weird or does not exist
            }
        }
    }
    

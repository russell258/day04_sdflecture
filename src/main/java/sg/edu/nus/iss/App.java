package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {

        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath+File.separator+fileName;

        File newDir = new File(dirPath);
        if (newDir.exists()){
            System.out.println(dirPath + " directory already exists");
        }else{
            newDir.mkdir();
        }

        File newFile = new File(dirPathFileName);
        if (!newFile.exists()){
            System.out.println(dirPathFileName + " file does not exist");
            System.exit(0);
        }else{
            newFile.createNewFile();
        }


        //1. Use FileReader and BufferedReader to read file

        FileReader fr = new FileReader(new File(dirPathFileName));
        BufferedReader br = new BufferedReader(fr);

        StringBuilder sbFileContent = new StringBuilder();
        String lineInput = "";

        //2. while loop to read file into a string variable
        while ((lineInput = br.readLine())!=null){
            sbFileContent.append(lineInput);
        }
        


        //3. close the reader
        br.close();
        fr.close();

        //print out the SB object sbFileContent
        // make sure we read all the content from the txt
        System.out.println(sbFileContent);

        //convert string to all uppercase and print to screen
        System.out.println(sbFileContent.toString().toUpperCase());

        //convert StringBuilder to string
        // so that i can use String function to perform other tasks
        String fileContent = sbFileContent.toString();
        fileContent = fileContent.replace(',',' ');
        fileContent = fileContent.replace('.',' ');
        fileContent = fileContent.replace('(',' ');
        fileContent = fileContent.replace(')',' ');
        fileContent = fileContent.replace('[',' ');
        fileContent = fileContent.replace(']',' ');
        fileContent = fileContent.replace('"',' ');
        fileContent = fileContent.replace('?',' ');
        fileContent = fileContent.replace('!',' ');

        System.out.println(fileContent);

        // store all unique words read
        //split the string into array
        String[] fileContentArray = fileContent.split(" ");
        
        // List<String> words = new ArrayList<>();


        // for (String word: fileContentArray){
        //     if(!words.contains(word)){
        //         words.add(word);
        //     }
        // }

        // System.out.println(words.size());
        //use hashmap to store String, Integer, where we can see the number of occurrences on top of unique values
        Map<String, Integer> words = new HashMap<>();
        for (String word: fileContentArray){
            Integer wordExists = words.get(word);

            if (wordExists==null){
                //new word found
                words.put(word,1);
            }else{
                //the word exists in the Map/HashMap collection
                words.put(word, wordExists+1);
            }
        }

        System.out.println(words);

    }
}

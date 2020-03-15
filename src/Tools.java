import java.io.*;
import java.util.*;

public class Tools {

    String string;
    String[] words = null;
    int lineCounter;
    int wordCounter = 0;
    int charCounter;

    Map<String, Integer> map = new HashMap<>();
    File file = new File("C:\\Users\\Victor Petersen\\IdeaProjects\\TextTool\\src\\Alice");



    public void findWordsBuffered() throws FileNotFoundException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Victor Petersen\\IdeaProjects\\TextTool\\src\\Alice"));
        try{
            String current = bufferedReader.readLine();
            while ((string=current)!=null) {
                lineCounter++;
                words=string.split(" ");
                wordCounter = wordCounter+words.length;
                for (String word : words) {

                    charCounter = charCounter + word.length();
                }
                current = bufferedReader.readLine();
            }
            bufferedReader.close();
            System.out.println("line count: " + lineCounter);
            System.out.println("Word count: " + wordCounter);
            System.out.println("Char count: " + charCounter);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getChars() {
        System.out.println(file.length());
    }


    public void instances() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Victor Petersen\\IdeaProjects\\TextTool\\src\\Alice"));
        Scanner input = new Scanner(file);
        while(bufferedReader.readLine() != null){
            String line = input.nextLine();
            String [] words = line. split(" ");


            for (String word : words) {

                word = word.replace(".","");
                word = word.replace(",","");
                word = word.replace("'","");
                word = word.replace(":","");
                word = word.replace("-","");
                word = word.replace(";","");
                word = word.replace("(","");
                word = word.replace(")","");
                word = word.replace("!","");
                word = word.replace("?","");
                word = word.replace("\"","");
                word = word.replace("*", "");
                word = word.replace("]","");
                word = word.replace("[","");
                word = word.replace("_","");
                word = word.toLowerCase();

                String finalWord = word;

                if (map.containsKey(finalWord)){
                    int count = map.get(finalWord);
                    map.put(finalWord, count+1);
                } else {
                    map.put(finalWord, 1);
                }

            }
        }
        Set<String> nrWordsMap = map.keySet();
        Set<String> nrWords = new TreeSet<>(nrWordsMap);
        for (String result : nrWords) {
            System.out.println("The word: " + result + ", occurs in the text: " + map.get(result) + " time(s).");

        }

    }

}

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Tools alice = new Tools();
        try{
           alice.getChars();
           alice.findWordsBuffered();
           alice.instances();

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}

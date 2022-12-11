import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    public static void main(String[] args) {
        HamletParser parser = new HamletParser();
        System.out.println(parser.getHamletData().replaceAll("(?i)Hamlet","Leon"));
        System.out.println(parser.getHamletData().replaceAll("(?i)Horatio","Tariq"));

    }
    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String replaceText(String replace, String text, String replaceWith) {
        Pattern p1 = Pattern.compile(replace);
        Matcher m1 = p1.matcher(text);
        return m1.replaceAll(replaceWith);
    }

}

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class EncryptDecrypt {
    public static void main(String[] args) {
        //We are reading from the String[] args so, we are not using scanner.
        //The scanner that was created was just to try by typing in command.
        //Scanner scanner = new Scanner(System.in);
        String mode = "enc";
        int key = 0;
        String text = "";

        //First, we are assuming that the data provided is false. If the data is provided,
        //then we have changed the data provided to true. We can do the other way round too.
        boolean dataProvided = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                text = args[i + 1];
                dataProvided = true;
            }
        }

        //First, we are getting the path to the file which we are reading from, in String 'inPathToFile'
        //Then, we are getting the path to the file which we will write to and we are storing it in 'outPathToFile'
        String inPathToFile = "";
        String outPathToFile = "";
        if (!dataProvided) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-in")) {
                    inPathToFile = args[i + 1];
                }
                if (args[i].equals("-out")) {
                    outPathToFile = args[i + 1];
                }
            }
        }

        //Checking if the selected algorithm is shift or unicode
        //By default, if no algorithm is specified, shift algorithm is used.
        String algorithm = "shift";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-alg")) {
                algorithm = args[i + 1];
            }
        }


        //Here, the logic is if it's encryption or decryption and the data is provided then,
        //we are favouring it so we don't have to create file even if both data is provided and
        //file is also provided.
        String result = "";
        if (mode.equals("enc") && dataProvided) {
            result = encryption(text, key, algorithm);
            System.out.println(result);
        } else if (mode.equals("dec") && dataProvided) {
            result = decryption(text, key, algorithm);
            System.out.println(result);
        } else if (mode.equals("enc") && !inPathToFile.equals("")) {
            String read = readFromFile(inPathToFile);
            writeToFile(outPathToFile, encryption(read, key, algorithm));
        } else if (mode.equals("dec") && !inPathToFile.equals("")) {
            String read = readFromFile(inPathToFile);
            writeToFile(outPathToFile, decryption(read, key, algorithm));
        }
    }


    public static String encryption(String input, int key, String algorithm) {
        String newText = "";
        if (algorithm.toLowerCase().equals("unicode")) {
            for (int i = 0; i < input.length(); i++) {
                char single = input.charAt(i);
                newText = newText + (char) (single + key);
            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                char single = input.charAt(i);
                if (single >= 'A' && single <= 'Z') {
                    single = (char) (single + key);

                    if (single > 'Z') {
                        single = (char) (single - 'Z' + 'A' - 1);
                    }
                    newText = newText + single;
                } else if (single >= 'a' && single <= 'z') {
                    single = (char) (single + key);

                    if (single > 'z') {
                        single = (char) (single - 'z' + 'a' - 1);
                    }
                    newText = newText + single;
                } else {
                    newText = newText + single;
                }
            }
        }
        return newText;
    }


    public static String decryption(String input, int key, String algorithm) {
        String newText = "";
        if (algorithm.toLowerCase().equals("unicode")) {
            for (int i = 0; i < input.length(); i++) {
                char single = input.charAt(i);
                newText = newText + (char) (single - key);
            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                char single = input.charAt(i);
                if (single >= 'A' && single <= 'Z') {
                    single = (char) (single - key);

                    if (single < 'A') {
                        single = (char) (single + 'Z' - 'A' + 1);
                    }
                    newText = newText + single;
                } else if (single >= 'a' && single <= 'z') {
                    single = (char) (single - key);

                    if (single < 'a') {
                        single = (char) (single + 'z' - 'a' + 1);
                    }
                    newText = newText + single;
                } else {
                    newText = newText + single;
                }
            }
        }
        return newText;
    }

    //A separate method to read data from file
    public static String readFromFile(String inPathToFile) {
        String newText = "";
        try (Scanner fileScanner = new Scanner(Paths.get(inPathToFile))) {
            while (true) {
                String line = fileScanner.nextLine();
                newText += line;
                if (!fileScanner.hasNext()) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return newText;
    }

    //A separate method to write data to files
    public static void writeToFile(String outPathToFile, String lines) {
        try (PrintWriter printWriter = new PrintWriter(outPathToFile)) {
            //At first we are just providing space.
            printWriter.print("");
            printWriter.print(lines);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

/**
 * Created by ST on 24.04.2017.
 */

import java.util.*;

public class FileSystem {
    private static Scanner scan = new Scanner(System.in);
    private static List<File> files = new ArrayList<>();
    private static String filedata;

    public static void fileDataEditer() {
        System.out.print("Please insert File data --> ");
        filedata = scan.nextLine();
    }

    private static boolean containsString(String testString, List<String> list) {
        return list.contains(testString);
    }

    public static void createFile() {
        System.out.print("Please insert File name ,remember that the File name can't contain any of the following characters(/ \\ : \" ? < > | *)--> ");
        String fileName = scan.nextLine();
        while (WorkingTools.check(fileName)) {
            System.out.print("Please Enter correct file name,remember that the file name can't contain any of the following characters(/ \\ : \" ? < > | *) -->  ");
            fileName = scan.nextLine();
        }

        /*while (containsString(fileName,filesnames)){
            System.out.print("File name doublicate,Please Enter another file name --> ");
            fileName=scan.nextLine();
        }*/
        fileDataEditer();
        Inode simpleInode = new Inode();
        simpleInode.dataBlockCreator(filedata);
        File someFile = new File(fileName, simpleInode);
        files.add(someFile);
        if (WorkingTools.askingQuestion()){
            simpleInode.viewDataBlocks();
        }


    }


}

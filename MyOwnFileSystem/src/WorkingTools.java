/**
 * Created by ST on 22.04.2017.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkingTools {
    private static Scanner scan = new Scanner(System.in);

    public static boolean check(String fileName) {
        char arr[] = fileName.toCharArray();
        for (int i = 0; i < fileName.length(); i++) {
            if (arr[i] == '/' || arr[i] == '\\' || arr[i] == '*' || arr[i] == '\"' || arr[i] == '<'
                    || arr[i] == '>' || arr[i] == ':' || arr[i] == '?' || arr[i] == '|') {
                fileName = fileName.replace(arr[i], '!');
                System.out.println("We are changed unallowable simbol " + arr[i] + " to --> " + fileName);
                System.out.println("Finally we have directory name -->" + fileName);
                return true;
            }
        }
        return false;
    }

    public static Boolean askingQuestion() {
        System.out.print("Do you want to view dataBlocks? Please answer yes/no--> ");
        String answer = scan.next();
        while (!answer.equals("yes") && !answer.equals("YES") && !answer.equals("Yes") && !answer.equals("No") && !answer.equals("no") && !answer.equals("NO")) {
            System.out.print("Please insert in correct form (yes,Yes,NO,No,no,YES) --> ");
            answer = scan.next();
        }
        if (answer.equals("yes") || answer.equals("YES") || answer.equals("Yes")) {
            return true;
        } else {
            return false;
        }
    }

    public static void mainQuestion(){

        Scanner scanner=new Scanner(System.in);
        System.out.print("If you want to create file please insert \"yes\",\"Yes\" or \"YES\" --> ");
        String ans=scanner.next();
        while(!ans.equals("yes") && !ans.equals("YES") && !ans.equals("Yes")){
            System.out.print("Please insert in correct form (\"yes\",\"Yes\" or \"YES\") --> ");
            ans=scanner.next();
        }
        while (ans.equals("yes") || ans.equals("YES") || ans.equals("Yes")){
            FileSystem.createFile();
            System.out.print("Do you want to create one more file --> ");
            ans=scanner.next();
        }
    }

}



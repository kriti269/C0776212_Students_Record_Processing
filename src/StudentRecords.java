import java.io.*;
import java.util.Scanner;

public class StudentRecords {

    static String readFile(String fileName){
        String records = "";
        try{
            File studentRecords = new File("students.txt");
            Scanner scannedFile = new Scanner(studentRecords);
            while(scannedFile.hasNext()){
                records = records + scannedFile.nextLine() + "\n";
            }
            scannedFile.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            return records;
        }
    }

    static void separateFileRecords(String records, String gender){
        try{
            PrintWriter printWriter = new PrintWriter(gender.toLowerCase()+"_Students.txt");
            String recordList[] = records.split("\n");
            for(String record:recordList){
                String genderColumn = record.split("\t")[4];
                if(genderColumn.equalsIgnoreCase(gender) || genderColumn.equalsIgnoreCase("gender")){
                    printWriter.println(record);
                }
            }
            printWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    static void fileEmailRecords(String records){
        try{
            PrintWriter printWriter = new PrintWriter("students_email.txt");
            String recordList[] = records.split("\n");
            for(String record:recordList){
                printWriter.println(record.split("\t")[3]);
            }
            printWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String records = readFile("students.txt");
        separateFileRecords(records,"Male");
        separateFileRecords(records,"Female");
        fileEmailRecords(records);
    }
}

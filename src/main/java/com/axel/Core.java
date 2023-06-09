package com.axel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import java.io.FileReader;

public class Core {
    
    public
    String path = "C:\\AxelDICE\\src\\main\\java\\com\\resources\\scripts\\",filename = "C:\\AxelDICE\\src\\main\\java\\com\\resources\\DefaultFile",fileType = "txt",batchType="";
    BufferedReader buffer;
    Process process;

    public void fileChooser()
    {   
        System.out.println("Starting FileChooser...");

        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
        
        if(response == JFileChooser.APPROVE_OPTION)
        {
            path = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println("Path :"+path);
        }
        System.out.println("Ended FileChooser Successfully...");
    }

    public void languageDetector(String source)
    {
        System.out.println("Language Detector Started");
        filename = "C:\\AxelDICE\\src\\main\\java\\com\\resources\\DefaultFile";
         if (source.matches("(?s).*\\b(#include|printf|scanf)\\b.*"))
             setFileInfo(".c", "cbatch.bat");
         else if (source.matches("(?s).*\\b(#include|R\\.)\\b.*"))
             setFileInfo(".R", "rbatch.bat");
         else if (source.matches("(?s).*\\b(package|func|var|const)\\b.*"))
             setFileInfo(".go", "gobatch.bat");
         else if (source.matches("(?s).*\\b(#include|std::cout|<<|>>|std::|std::cin|printf|scanf)\\b.*"))
             setFileInfo(".cpp", "cppbatch.bat");
         else if (source.matches("(?s).*\\b(function|if|else|end|local)\\b.*"))
             setFileInfo(".lua", "luabatch.bat");
         else if (source.matches("(?s).*\\b(<\\?php|echo|class|function)\\b.*"))
             setFileInfo(".php", "phpbatch.bat");
         else if (source.matches("(?s).*\\b(fn|let|println!|match|use)\\b.*"))
             setFileInfo(".rs", "rsbatch.bat");
         else if (source.matches("(?s).*\\b(import|class|void|main|print)\\b.*"))
             setFileInfo(".dart", "dartbatch.bat");
         else if (source.matches("(?s).*\\b(class|def|module|end|puts)\\b.*"))
             setFileInfo(".rb", "rubybatch.bat");
         else if (source.matches("(?s).*\\b(use|sub|print|if|foreach)\\b.*"))
             setFileInfo(".pl", "perlbatch.bat");
         else if (source.matches("(?s).*\\b(public static void main|Scanner|import java.|javax|System\\.out\\.println)\\b.*"))
             setFileInfo(".java", "javabatch.bat");
         else if (source.matches("(?s).*\\b(IDENTIFICATION DIVISION|PROCEDURE DIVISION|DISPLAY|COMPUTE)\\b.*"))
             setFileInfo(".cobol", "cobolbatch.bat");
         else if (source.matches("(?s).*\\b(<html>|<body>|<head>|<script>|console\\.)\\b.*"))
             setFileInfo(".html", "htmlbatch.bat");
         else if (source.matches("(?s).*\\b(import scala\\.|def|val|var|class|object)\\b.*"))
             setFileInfo(".scala", "scalabatch.bat");
         else if (source.matches("(?s).*\\b(import Swift|func|var|let|class)\\b.*"))
             setFileInfo(".swift", "swiftbatch.bat");
         else if (source.matches("(?s).*\\b(import|from|def|print|range|len|input|sys\\.)\\b.*"))
             setFileInfo(".py", "pybatch.bat");
         else if (source.matches("(?s).*\\b(function|if|for|while|plot)\\b.*"))
             setFileInfo(".m", "matlabbatch.bat");
         else if (source.matches("(?s).*\\b(import|fun|var|class)\\b.*"))
             setFileInfo(".kt", "ktbatch.bat");
         else if (source.matches("(?s).*\\b(PROGRAM|INTEGER|REAL|WRITE|READ)\\b.*"))
             setFileInfo(".f90", "fortranbatch.bat");
         else if (source.matches("(?s).*\\b(console\\.|function|require|module\\.exports)\\b.*"))
             setFileInfo(".js", "jsbatch.bat");
         else if (source.matches("(?s).*\\b(#import|@interface|@implementation|@property|NSLog)\\b.*"))
             setFileInfo(".m", "objcbatch.bat");
         else if (source.matches("(?s).*\\b(/usr|bin|bash||echo|read|cat|<<|wc|cd|ls|$|#!|; do|echo $|;;|-eq|grep|cwd)\\b.*"))
             setFileInfo(".sh", "bashshell.bat");
         else if (source.matches("(?s).*\\b(import|export|class|function|interface)\\b.*"))
             setFileInfo(".ts", "tsbatch.bat");
         else if (source.matches("(?s).*\\b(Imports|Module|Sub|Function|Console\\.WriteLine|End)\\b.*"))
             setFileInfo(".vb", "vbbatch.bat");
         else if (source.matches("(?s).*\\b(MOV|ADD|SUB|JMP|CMP|LOOP)\\b.*"))
             setFileInfo(".asm", "assemblybatch.bat");
        else if (source.matches("(?s).*\\b(using|namespace|class|void Main)\\b.*"))
             setFileInfo(".cs", "csbatch.bat");
         else if (source.matches("(?s).*\\b(SELECT|FROM|WHERE|JOIN)\\b.*"))
             setFileInfo(".sql", "sqlbatch.bat");
         else if (source.matches("(?s).*\\b(module|import|do|where|case)\\b.*"))
             setFileInfo(".hs", "haskellbatch.bat");
    }

    public void setFileInfo(String fileType , String batchType)
    {
        System.out.println("Detected : "+fileType.substring(1));
        filename = filename.concat(fileType);
        this.batchType = batchType;
    }

    public void saveAs(String Result)
    {
        System.out.println("Starting SaveAs");
        fileChooser(); //gets the new filepath to save 
        if(path.equals("null"))
        {
            System.out.println("Path Equals Nulll Returned!");
            return;
        }

        System.out.println("Saving At Given Path : "+path);

        //Writing The Result to File
        System.out.println("Writing Into File Path : "+path);
        try (FileWriter writer = new FileWriter(path)) 
        {
            writer.write(Result + System.lineSeparator());
            writer.close();
            
        } 
        catch (IOException e) {e.printStackTrace();}
        System.out.println("Saved");
    }
    
    public String openFile()
    {
        String filePath = "";
        System.out.println("Started opeFile");
        System.out.println("FileChooser Started");
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION)
        { 
            filePath = fileChooser.getSelectedFile().getAbsolutePath(); //gets filepath form the user
            System.out.println("FilePath : "+filePath);
        }
    
        StringBuilder contentBuilder = new StringBuilder();

        System.out.println("Reading Data Form :"+filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                contentBuilder.append(line).append("\n");
            }//read the data form the file
        } catch (FileNotFoundException e) {e.printStackTrace();}
          catch (IOException e) {e.printStackTrace();}

          System.out.println("Data Successfully Readed Form :"+filePath);
          System.out.println("Sending Data To Editor :"+filePath);

        return contentBuilder.toString();//return to data for the file to editor
    }

    public void savetoFile(String Result)
    {
        System.out.println("Started SaveToFile");

        System.out.print("Checking If The Path Is Default Path :");
        if(path == "C:\\AxelDICE\\src\\main\\java\\com\\resources\\") //check if the path is default path 
        {
            System.out.print("True");
            fileChooser(); //if default path is set then user given new path
        }
        System.out.print("False");

        System.out.println("Saving At Given Path : "+path);
        //Writing The Result to File
        System.out.println("Writing Into File");
        try (FileWriter writer = new FileWriter(path)) 
        {
            writer.write(Result + System.lineSeparator());
            writer.close();
            
        } 
        catch (IOException e) {e.printStackTrace();}
        System.out.println("Successfuly Written Into File");
    }
    
    public void fileWriter(String source)
    {
        System.out.println("Writing Into File");

        try (FileWriter writer = new FileWriter(filename)) 
        {
            writer.write(source + System.lineSeparator());
        } catch (IOException e) {e.printStackTrace();}

        System.out.println("Succesfuly Writeted");
    }

    public void start(String source)
    {
        System.out.println("Axel Started");
        languageDetector(source);
        fileWriter(source);
        try 
        {
            startProcess();
        } catch (InterruptedException e) {e.printStackTrace();}
    }
    
    public void printDeatials()
    {
        System.out.println("Printing Details");
        String line = " ";
        try 
        {
           while ((line = buffer.readLine()) != null) 
            {  
                System.out.println(line);
            }
            process.waitFor();
       } catch (IOException | InterruptedException e) { e.printStackTrace();}

    }

    public void startProcess() throws InterruptedException
    {   
        System.out.println("Started Procces");
        System.out.println("Script Path : C:\\AxelDICE\\src\\main\\java\\com\\resources\\scripts");
        System.out.println("Batch Type :"+batchType);
        
        ProcessBuilder processBuilder =null;
        try 
        {   
            File directory = new File("C:\\AxelDICE\\src\\main\\java\\com\\resources\\scripts");
            processBuilder = new ProcessBuilder("cmd.exe", "/C", "Start",batchType);
            processBuilder.directory(directory);
            process = processBuilder.start();
            buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
        }catch (IOException e) {e.printStackTrace();} 
        System.out.println("Procces SuccessFul");

        System.out.println("Printing Details");
        String line;
        try 
        {
            while ((line = buffer.readLine()) != null) 
            {
                System.out.println(line);
            }
        } 
        catch (IOException e) {e.printStackTrace();}

        int exitCode = process.waitFor();
        System.out.println("Process exited with code " + exitCode);
    
    }
}




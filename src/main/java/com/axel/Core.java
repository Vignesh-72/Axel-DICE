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
    String path = "C:\\AxelDICE\\src\\main\\java\\com\\resources\\scripts\\",filename = "C:\\AxelDICE\\src\\main\\java\\com\\resources\\DefaultFile",fileType = "txt",batchType="",lang="null";
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
        System.out.println("source:"+source+":sdaasd");
        System.out.println("Lang"+this.lang);
        filename = "C:\\AxelDICE\\src\\main\\java\\com\\resources\\DefaultFile";
        if(this.lang.contains("null"))
            if (source.matches("(?s).*\\b(public static void main|Scanner|import java.|javax|System\\.out\\.println)\\b.*")) 
               setFileInfo(".java", "javabatch.bat");
            else if (source.matches("(?s).*\\b(def|print|range|in|:)\\b.*")) 
               setFileInfo(".py", "pybatch.bat");
            else if (source.matches("(?s).*\\b(#include|std::cout|<<|>>|std::|std::cin|printf|scanf)\\b.*")) 
               setFileInfo(".cpp", "cppbatch.bat");
            else
               return;
        if (this.lang == "C++")
             setFileInfo(".cpp", "cppbatch.bat");
          if (this.lang == "C")
             setFileInfo(".c", "cbatch.bat");
          if (this.lang == "Python")
             setFileInfo(".py", "pybatch.bat");
          if (this.lang == "R")
             setFileInfo(".r", "rbatch.bat");
          if (this.lang == "Go")
             setFileInfo(".go", "gobatch.bat");
          if (this.lang == "Lua")
             setFileInfo(".lua", "luabatch.bat");
          if (this.lang == "PHP")
             setFileInfo(".php", "phpbatch.bat");
          if (this.lang == "Rust")
             setFileInfo(".rs", "rsbatch.bat");
          if (this.lang == "Dart")
             setFileInfo(".dart", "dartbatch.bat");
          if (this.lang == "Ruby")
             setFileInfo(".rb", "rubybatch.bat");
          if (this.lang == "Perl")
             setFileInfo(".pl", "perlbatch.bat");
          if (this.lang == "Java")
             setFileInfo(".java", "javabatch.bat");
          if (this.lang == "Cobol")
             setFileInfo(".cobol", "cobolbatch.bat");
          if (this.lang == "HTML")
             setFileInfo(".html", "htmlbatch.bat");
          if (this.lang == "Scala")
             setFileInfo(".scala", "scalabatch.bat");
          if (this.lang == "Swift")
             setFileInfo(".swift", "swiftbatch.bat");
          if (this.lang == "MATLAB")
             setFileInfo(".m", "matlabbatch.bat");
          if (this.lang == "Kotlin")
             setFileInfo(".kt", "ktbatch.bat");
          if (this.lang == "Fortran")
             setFileInfo(".f90", "fortranbatch.bat");
          if (this.lang == "JavaScript")
             setFileInfo(".js", "jsbatch.bat");
          if (this.lang == "Objective-C")
             setFileInfo(".ob", "objcbatch.bat");
          if (this.lang == "Shell (Bash)")
             setFileInfo(".sh", "bashshell.bat");
          if (this.lang == "TypeScript")
             setFileInfo(".ts", "tsbatch.bat");
          if (this.lang == "Visual Basic")
             setFileInfo(".vb", "vbbatch.bat");
          if (this.lang == "Assembly language")
             setFileInfo(".asm", "assemblybatch.bat");
         if (this.lang == "C#")
             setFileInfo(".cs", "csbatch.bat");
          if (this.lang == "SQL")
             setFileInfo(".sql", "sqlbatch.bat");
          if (this.lang == "Haskel")
             setFileInfo(".hs", "haskellbatch.bat");
    }

    public void setFileInfo(String fileType , String batchType)
    {
        System.out.println("Detected : "+fileType.substring(1));
        this.fileType =fileType;
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




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

    String path = "C:\\AxelDICE\\src\\main\\java\\com\\resources\\scripts\\",filename = "C:\\AxelDICE\\src\\main\\java\\com\\resources\\DefaultFile",ALD_FILETYPE = "txt",ALD_BATCH="";
    BufferedReader buff;
    Process p = null;


    public void saveFile()
    {   
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        int repose = fileChooser.showOpenDialog(null);
        if(repose == JFileChooser.APPROVE_OPTION)
        {
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }
    
    }
    public void ALD_CreateFile()
    {
        filename = filename.concat(ALD_FILETYPE);
        
    }

    public String openFile()
    {
        String filePath = "";

        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getAbsolutePath();
        }
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();}

        return contentBuilder.toString();
    }

    public void Axel_ALD(String source)
    {
        filename = "C:\\AxelDICE\\src\\main\\java\\com\\resources\\DefaultFile";

        if (source.matches("(?s).*\\b(public static void main|Scanner|import java.|javax|System\\.out\\.println)\\b.*")) 
            ALD_SetFileDetails(".java", "javabatch.bat");

        else if (source.matches("(?s).*\\b(def|print|range|in|:)\\b.*")) 
            ALD_SetFileDetails(".py", "pybatch.bat");

        else if (source.matches("(?s).*\\b(#include|std::cout|<<|>>|std::|std::cin|printf|scanf)\\b.*")) 
            ALD_SetFileDetails(".cpp", "batch.bat");

        else if(source.matches("(?s).*\\b(/usr|bin|bash||echo|read|cat|<<|wc|cd|ls|$|#!|; do|echo $|;;|-eq|grep|cwd)\\b.*"))
            ALD_SetFileDetails(".sh", "bashshell.bat");
        
        ALD_CreateFile();
    }

    private void ALD_SetFileDetails(String fileType , String batchType){
        ALD_FILETYPE = fileType;
        ALD_BATCH = batchType;
    }
    public void saveastofile(String Result){
        saveFile();
        if(path.equals("null"))
        return;
    
        //Writing The Result to File
        System.out.println("Saving At Given Path : "+path);
        try (FileWriter writer = new FileWriter(path)) 
        {
                writer.write(Result + System.lineSeparator());
            writer.close();
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        System.out.println("Saved");
    }

    public void savetoFile(String Result){

        if(path == "C:\\AxelDICE\\src\\main\\java\\com\\resources\\"){
            saveFile();
        }
        //Writing The Result to File
        System.out.println("Saving At Given Path : "+path);
        try (FileWriter writer = new FileWriter(path)) 
        {
                writer.write(Result + System.lineSeparator());
            writer.close();
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        System.out.println("Saved");
    }
    
    public void wirteDefault(String source)
    {
        System.out.println("Writing Into File");
        try (FileWriter writer = new FileWriter(filename)) 
        {
            writer.write(source + System.lineSeparator());
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        System.out.println("Succesfuly Writeted");
    }
    public void run(String source)
    {
        System.out.println("Run");
        Axel_ALD(source);
        wirteDefault(source);
        try {
            process();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        //print();
    }
    public void print(){

        String line = " ";
        try 
        {
           while ((line = buff.readLine()) != null) 
            {  
                System.out.println(line);
            }
            p.waitFor();
       } catch (IOException | InterruptedException e) 
       { 
            e.printStackTrace();
       }
    }

    public void process() throws InterruptedException{
        ProcessBuilder pb =null;
        try 
        {   
        File dir = new File("C:\\AxelDICE\\src\\main\\java\\com\\resources\\scripts");
        pb = new ProcessBuilder("cmd.exe", "/C", "Start",ALD_BATCH);
        pb.directory(dir);
        p = pb.start();
        buff = new BufferedReader(new InputStreamReader(p.getInputStream()));
    }
    catch (IOException e) 
    {
        e.printStackTrace();
    }
    
    String line;
    try {
        while ((line = buff.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    int exitCode = p.waitFor();
    System.out.println("Process exited with code " + exitCode);
    
    }
    }




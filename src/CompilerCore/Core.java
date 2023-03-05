package CompilerCore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;

public class Core {

    String path = "C:/dev/AxelCompiler/src/CompilerCore",filename = "C:/dev/AxelCompiler/src/CompilerCore/DefaultFile.cpp";
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
    public void savetoFile(String Result){
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
        wirteDefault(source);
        process();
        print();

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

    public void process(){
        ProcessBuilder pb =null;
        try 
        {   
            //Excuting Command in termial 
            File dir = new File("C:/dev/AxelCompiler/src/CompilerCore");
            pb = new ProcessBuilder("cmd.exe", "/C", "Start","batch.bat");
            pb.directory(dir);
            p = pb.start();
            buff = p.inputReader();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
            
        }
        
        BufferedReader buff = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
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
     
}


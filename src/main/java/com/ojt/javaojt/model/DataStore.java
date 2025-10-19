
package com.ojt.javaojt.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class DataStore<T extends PrintFile> {
    private final String filePath;
    
    public DataStore(String fileString) {
        this.filePath = fileString;
    }
    
   public void saveAll(List<T> object) {
       try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
           oos.writeObject(object);
           System.out.println("Save " + object.size() + "file pash" + filePath);
       } catch (IOException e) {
           System.out.println("");
       }
   }

   public List<T> loadAll() {
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
           return (List<T>) ois.readObject();
       } catch (IOException | ClassNotFoundException e) {
           System.out.println("No find link");
           return new ArrayList<>();
       }
   }
    
   public List<T> loadFromFile(String fileName, FileParser<T> fileParser) {
       List<T> list = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(fileName));){
           String line;
           while ((line = reader.readLine()) != null) {               
               list.add(fileParser.parser(line));
           }
            
           System.out.println("Thanh cong");
           return list;
       } catch (IOException e) {
           System.err.println(e);
           return new ArrayList<>();
       }
   }
   
   public void saveToFile(String fileName, List<T> listObjectTs) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));){
                  
           for (T listObjectT : listObjectTs) {
               writer.write(listObjectT.printFile());
               writer.newLine();
           }
       } catch (IOException e) {
           System.err.println(e);
       }
   }
   
   public interface FileParser<T> {
       T parser(String object);
   }
}

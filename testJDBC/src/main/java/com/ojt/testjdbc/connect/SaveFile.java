
package com.ojt.testjdbc.connect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class SaveFile<T> {
    public void saveAll(String file, List<T> list) {
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(file))){
            oop.writeObject(list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<T> loadAll(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }
}

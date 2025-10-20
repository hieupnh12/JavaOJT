
package com.ojt.javaojt.model;

import java.util.List;


public class ListObject<T> {
    private List<T> listObject;

    public ListObject() {
    }

    public ListObject(List<T> listObject) {
        this.listObject = listObject;
    }

    public List<T> getListObject() {
        return listObject;
    }

    public void setListObject(List<T> listObject) {
        this.listObject = listObject;
    }
    
    public void addObject(Object object) {
        listObject.add((T) object);
    }
}

package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PrintingHelper<T> {

    public void printArray(T [] array){

        for(int i = 0; i < array.length; i++  ){
            if(array[i] == null) break;
            System.out.println(array[i].toString());
        }
    }

    public void printArray(char [] array){

        for(int i = 0; i < array.length; i++  ){
            System.out.println(array[i]);
        }
    }

    public void printArray(int [] array){

        for(int i = 0; i < array.length; i++  ){
            System.out.println(array[i]);
        }
    }

    public void printList(List list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public void printMap(HashMap map){
        Collection c = map.keySet();
        Iterator iter = c.iterator();

        while(iter.hasNext()){
            Object key = iter.next();
            System.out.println(key + " " + map.get(key));
        }
    }
}

package Arrays_Strings.main;

import java.util.List;

public class PrintingHelper<T> {

    void printArray(T [] array){

        for(int i = 0; i < array.length; i++  ){
            if(array[i] == null) break;
            System.out.println(array[i].toString());
        }
    }

    void printArray(char [] array){

        for(int i = 0; i < array.length; i++  ){
            System.out.println(array[i]);
        }
    }

    void printArray(int [] array){

        for(int i = 0; i < array.length; i++  ){
            System.out.println(array[i]);
        }
    }

    void printList(List list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

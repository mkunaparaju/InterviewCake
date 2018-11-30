package main.Heap;

import java.util.Arrays;

public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;
    int [] items = new int [capacity];



    private int getLeftChildIndex(int parentIndex) { return 2*parentIndex + 1;    }
    private int getRightChildIndex(int parentIndex) { return 2*parentIndex + 2;    }
    private int getParentIndex(int index) { return (index - 1)/2;     }

    private boolean hasLeftChild(int parentIndex) { return getLeftChildIndex(parentIndex) < size ; }
    private boolean hasRightChild(int parentIndex) { return getRightChildIndex(parentIndex) < size ; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0 ; }

    private int leftChild(int parentIndex){ return items[getLeftChildIndex(parentIndex)]; }
    private int rightChild(int parentIndex){ return items[getRightChildIndex(parentIndex)]; }
    private int parent(int index){ return items[getParentIndex(index)]; }

    int peek(){
        return items[0];
    }

    int poll(){

        int item = items[0];
        items[ 0] = items[size - 1];
        size--;

        return item;
    }

    public static void main(String[] args) {

    }
}

package main.StacksAndQueues;

import java.util.*;

class QueueWithStacks {


    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    QueueWithStacks(){
        inputStack = new Stack<Integer>();
        outputStack = new Stack<Integer>();
    }

    void enqueue(int n) {
        inputStack.push(n);
    }

    int dequeue(){
        if(inputStack.isEmpty() && outputStack.isEmpty()) {
            throw new NullPointerException("No more elements left in the Queue");
        }
        else if (outputStack.isEmpty()){
            while (!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }
}

public class QueueImpl{

    public static void main(String[] args) {

    }
}

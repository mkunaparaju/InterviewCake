package main.DPRecursionMemoization;

import com.sun.corba.se.pept.transport.ReaderThread;
import sun.security.tools.keytool.CertAndKeyGen;

import java.util.HashSet;

public class CakeThief {

    HashSet<Integer> indexConsidered = new HashSet<>();
    int maxValue = 0;
    public static void main(String[] args) {
        CakeType[] cakeTypes = new CakeType[] {
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };
        int capacity = 20;
        CakeThief cakeThief = new CakeThief();
        System.out.println(cakeThief.getMaxBagValue(cakeTypes, capacity));
    }

    private int getMaxBagValue(CakeType[] cakeTypes, int capacity) {
        if(capacity <= 0) return 0;


        int index = getMaxUnitValue(cakeTypes);
        int weight = cakeTypes[index].getWeight();
        int value = cakeTypes[index].getValue();
        int timesOfMaxWeight = capacity/weight;
        int capRemaining = capacity - weight*timesOfMaxWeight;




        maxValue= maxValue + (value*timesOfMaxWeight) + getMaxBagValue(cakeTypes, capRemaining );

        return maxValue;
    }

    private int getMaxUnitValue(CakeType[] cakeTypes) {
        float maxValue = 0;
        int maxIndex = 0;
        for(int i = 0; i < cakeTypes.length; i++){
            if(indexConsidered.contains(i)) continue;
            int weight = cakeTypes[i].getWeight();
            int value = cakeTypes[i].getValue();
            float unitValue = (value/weight);
            if(unitValue > maxValue) {
                maxValue = unitValue;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

class CakeType{
    final int weight;
    final int value;

    public CakeType(int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }


    public int getValue() {
        return value;
    }

}

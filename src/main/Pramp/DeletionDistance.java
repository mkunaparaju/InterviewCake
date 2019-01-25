package main.Pramp;

public class DeletionDistance {
    public static void main(String[] args) {

        String str1 = "dog", str2 = "frog";
        String str3 = "some", str4 = "some";
        String str5 = "some", str6 = "thing";
        String str7 = "", str8 = "";

        System.out.println(deletionDistance(str1, str2, str1.length() -1, str2.length() -1));
    }

    static int deletionDistance(String str1, String str2, int index1, int index2) {
        if(index1 == 0) return index2;
        if(index2 == 0) return index1 ;

        if(str1.charAt(index1) == str2.charAt(index2)){
            return deletionDistance(str1,str2, index1 -1, index2 - 1);
        }

        return  1+ Math.min(deletionDistance(str1, str2, index1 -1, index2),
                deletionDistance(str1,str2,index1, index2 - 1));

    }


}

package main.HashMapImplementation;

import java.io.File;
import java.util.*;

//main point here  is to fine the equality of the fie contents and add them to the hashmap and then extract them
//once extracted we need to construct original and duplicate based on the file last updated.
// these assumptions I am making for now.

public class GetDuplicateFiles {

    private static List<FilePaths> getDuplicateFilePaths(String startPath){
        List<FilePaths> filePathsList = new ArrayList<>();
        List<File> fileQueue = new LinkedList<>();

        HashMap<File, File> originalFileSet = new HashMap<>();
        File startFile = new File(startPath);

        //if starting path is a file we cannot loop through this. We can only go inside a directory
        if(!startFile.isDirectory()) return Collections.emptyList();
        fileQueue = Arrays.asList(startFile.listFiles());

        for(File file : fileQueue){

            //adding all files in the dir to queue
            if(file.isDirectory()) fileQueue.addAll(Arrays.asList(file.listFiles()));
            //somehow containskey uses the content of the file to make sure of equality
            if(!originalFileSet.containsKey(file)) originalFileSet.put(file,file);
            else{
                //get the original and dupilicate
                File f1 =  originalFileSet.get(file);
                File f2 = file;

                //assuming f1 is original and f2 is duplicate
                //ideally we need to check for last updated time.
                FilePaths fp = new FilePaths(f1.toPath(), f2.toPath());
                filePathsList.add(fp);
            }

        }
        return filePathsList;
    }
}
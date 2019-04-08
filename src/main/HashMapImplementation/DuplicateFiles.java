package main.HashMapImplementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


///unfinished FINISH IT
public class DuplicateFiles {

    static List<FilePaths> getFilePaths(Path start) throws IOException {
        List<FilePaths> dupFiles = new ArrayList<>();
        HashMap<String, FileInfo> fileSeen = new HashMap<>();
        Queue<Path> filePaths = new LinkedList<Path>();
        ((LinkedList<Path>) filePaths).push(start);

        while (!filePaths.isEmpty()){
            Path current = filePaths.poll();
            File f = current.toFile();

            //put child file in stack
            if(f.isDirectory()) {
                for (File files : f.listFiles()){
                    ((LinkedList<Path>) filePaths).push(files.toPath());
                }
            }

            byte[] encodedFile = Files.readAllBytes(current);
            String fileContents = new String(encodedFile, "UTF-8");
            long lastEditTime = f.lastModified();

            if(fileSeen.containsKey(fileContents)){
                FileInfo fileInSeen = fileSeen.get(fileContents);
                if(fileInSeen.timeLastEdited > lastEditTime){
                    FilePaths newFilePaths = new FilePaths(f.toPath(), fileInSeen.path);
                }
            }

        }
        return dupFiles;
    }
}

class FilePaths {

    private Path duplicatePath;
    private Path originalPath;

    public FilePaths(Path duplicatePath, Path originalPath) {
        this.duplicatePath = duplicatePath;
        this.originalPath = originalPath;
    }

    public Path getDuplicatePath() {
        return duplicatePath;
    }

    public Path getOriginalPath() {
        return originalPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilePaths filePaths = (FilePaths) o;
        return Objects.equals(duplicatePath, filePaths.duplicatePath) &&
                Objects.equals(originalPath, filePaths.originalPath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(duplicatePath, originalPath);
    }
}

class FileInfo {

    long timeLastEdited;
    Path path;

    FileInfo(long timeLastEdited, Path path) {
        this.timeLastEdited = timeLastEdited;
        this.path = path;
    }
}
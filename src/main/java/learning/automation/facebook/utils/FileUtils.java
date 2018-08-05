package learning.automation.facebook.utils;

import java.io.File;

public class FileUtils {

  public static void createDir(String dir) {
    File f = new File(dir);
    boolean flag = f.mkdirs();
    System.out.println("Directory created (T/F)? " + flag);
  }
  
  public static void moveFile() {
    
  }
  
  public static void deleteFile() {
    
  }
  
  public static void deleteFilesFromDir() {
    
  }
}

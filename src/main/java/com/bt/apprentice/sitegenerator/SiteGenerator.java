package com.bt.apprentice.sitegenerator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class SiteGenerator {
  public static void main(String[] args) throws IOException {
    File[] files = new File("site").listFiles();
    for (File file : files) {
      String path = file.getAbsolutePath();
      String content = FileUtils.readFileToString(file, "UTF-8");
      System.out.println(content);
    }
  }
}

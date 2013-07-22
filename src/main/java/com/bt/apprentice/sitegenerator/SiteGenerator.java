package com.bt.apprentice.sitegenerator;

import java.io.File;

public class SiteGenerator {
  public static void main(String[] args) {
    File[] files = new File("site").listFiles();
    for (File file : files) {
      System.out.println(file.getAbsolutePath());
    }
  }
}
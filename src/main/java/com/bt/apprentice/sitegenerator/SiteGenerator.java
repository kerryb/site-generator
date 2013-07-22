package com.bt.apprentice.sitegenerator;

import java.io.File;
import java.io.IOException;


public class SiteGenerator {
  public static void main(String[] args) throws IOException {
    File[] files = listFiles();
    for (File file : files) {
      new Page(file).writeCompiledFile();
    }
  }

  private static File[] listFiles() {
    return new File("site").listFiles();
  }
}

package com.bt.apprentice.sitegenerator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.pegdown.PegDownProcessor;

public class SiteGenerator {
  public static void main(String[] args) throws IOException {
    File[] files = listFiles();
    for (File file : files) {
      writeCompiledFile(file);
    }
  }

  private static File[] listFiles() {
    return new File("site").listFiles();
  }

  private static void writeCompiledFile(File file) throws IOException {
    String path = file.getAbsolutePath();
    String newPath = path.replaceAll(".markdown$", ".html");
    File newFile = new File(newPath);
    FileUtils.writeStringToFile(newFile, compile(file));
  }

  private static String compile(File file) throws IOException {
    PegDownProcessor processor = new PegDownProcessor();
    String compiled = processor.markdownToHtml(readFile(file));
    return compiled;
  }

  private static String readFile(File file) throws IOException {
    return FileUtils.readFileToString(file, "UTF-8");
  }
}

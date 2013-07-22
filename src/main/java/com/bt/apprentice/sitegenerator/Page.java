package com.bt.apprentice.sitegenerator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.pegdown.PegDownProcessor;

class Page {
  private File file;

  public Page(File file) {
    this.file = file;
  }
  
  void writeCompiledFile() throws IOException {
    File newFile = new File(newPath());
    FileUtils.writeStringToFile(newFile, compile());
  }

  private String newPath() {
    String path = file.getAbsolutePath();
    String newPath = path.replaceAll(".markdown$", ".html");
    return newPath;
  }

  private String compile() throws IOException {
    PegDownProcessor processor = new PegDownProcessor();
    String compiled = processor.markdownToHtml(readFile());
    return compiled;
  }

  private String readFile() throws IOException {
    return FileUtils.readFileToString(file, "UTF-8");
  }
}
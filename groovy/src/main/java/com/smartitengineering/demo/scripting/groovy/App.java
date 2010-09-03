package com.smartitengineering.demo.scripting.groovy;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    String[] roots = new String[]{"src/main/resources/"};
    try {
      GroovyScriptEngine engine = new GroovyScriptEngine(roots);
      Binding binding = new Binding();
      binding.setVariable("input", "SITEL");
      engine.run("test.groovy", binding);
      System.out.println(binding.getVariable("$output"));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}

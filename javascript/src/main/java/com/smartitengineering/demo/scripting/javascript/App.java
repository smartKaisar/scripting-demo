package com.smartitengineering.demo.scripting.javascript;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) throws IOException {

    InputStream inputStream = App.class.getClassLoader().getResourceAsStream("java-script.js");
    Context context = Context.enter();
    Scriptable scriptable = context.initStandardObjects();
    String script = IOUtils.toString(inputStream);
    Function function = context.compileFunction(scriptable, script, "java-script.js", 0, null);
//    System.out.println("Function " + function);
    System.out.println(function.call(context, scriptable, scriptable, null));
  }
}

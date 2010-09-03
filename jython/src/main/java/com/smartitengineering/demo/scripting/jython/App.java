package com.smartitengineering.demo.scripting.jython;

import java.io.IOException;
import java.io.InputStream;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) throws IOException {
    String fileName = "jython-script.py";
    InputStream scriptStream = App.class.getClassLoader().getResourceAsStream(fileName);
    PythonInterpreter interpreter = new PythonInterpreter();
    interpreter.execfile(scriptStream);
    PyObject x = interpreter.get("x");
    System.out.println("X: " + x);
    scriptStream.close();
    String file2Name = "jython-script_1.py";
    scriptStream = App.class.getClassLoader().getResourceAsStream(file2Name);
    //String script = IOUtils.toString(scriptStream);
    interpreter = new PythonInterpreter();
    PyObject object = null;
    try {
      interpreter.execfile(scriptStream);
      PyObject object1 = interpreter.get("test");
      System.out.println(object1);
    }
    catch (Throwable th) {
      th.printStackTrace();
    }
    System.out.println("Object" + object);
  }
}

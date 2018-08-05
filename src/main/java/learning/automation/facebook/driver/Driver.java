package learning.automation.facebook.driver;

import learning.automation.facebook.functional.TestNGLauncher;

public class Driver {

  public static void main(String[] args) {
    TestNGLauncher testng = new TestNGLauncher();
    testng.invokeTestNG();
  }
}

package learning.automation.facebook.assertion;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import learning.automation.facebook.enums.AssertionType;

public class AssertionContext extends Assert {
  public static Assert assertion;
  public static AssertionType assertionType;
  public static SoftAssert softAssert = new SoftAssert();
  
  static public Assert getAssertion() {
    return assertion;
  }
  
  static public void setAssertionType(AssertionType assertType) {
    assertionType = assertType;
  }
  
  static public AssertionType getAssertionType() {
    return assertionType;
  }
  
  static public void assertFalse(boolean condition, String message) {
    if (assertionType == AssertionType.SOFT) {
      softAssert.assertFalse(condition, message);
    } else {
      Assert.assertFalse(condition, message);
    }
  }

  static public void fail(String message, Throwable realCause) {
  }

  static public void fail(String message) {
    
  }

  static public void fail() {
    fail(null);
  }

  static public void assertEquals(Object actual, Object expected, String message) {
    
  }
  
  static public void assertAll() {
    
  }
  
  static public void postAssert() {
    ExtentManager.logPass("def");
  }
  
  static public void assertTrue(Boolean condition) {
    postAssert();
  }
}
package learning.jenkins.facebook;

import org.junit.Test;

public class Driver {

    public static void main( String[] args )
    {
    	System.out.println(args[0]+args[1]);
    	TestNGLauncher testng = new TestNGLauncher();
        testng.invokeTestNG();
    }  
}

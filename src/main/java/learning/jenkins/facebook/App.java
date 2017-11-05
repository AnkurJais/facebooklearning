package learning.jenkins.facebook;

import org.junit.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Test  dfs");
    	TestNGLauncher testng = new TestNGLauncher();
        testng.invokeTestNG();
    }
    
    @Test
    public void test12(){
    	System.out.println("Runnin--------");
    }
}

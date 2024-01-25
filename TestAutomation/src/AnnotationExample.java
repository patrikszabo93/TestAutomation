import org.testng.annotations.*;

public class AnnotationExample {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("After Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("After Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("After Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("After Method");
    }


    @Test
    public void Test(){
        System.out.println("Lets do some test as well");
    }
    @Test
    public void Test2(){
        System.out.println("Lets do some test as well");
    }


}

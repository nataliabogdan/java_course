package plopik.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeTest
    public void setUp() throws Exception {
        app.init();

    }

    @AfterTest
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}

package plopik.test.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import plopik.test.applicationManager.ApplicationManager;

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

package tests.base;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Listener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String screenshotName = context.getTestMethod().get().getName() + String.valueOf(System.currentTimeMillis()).substring(9, 13);
        TakesScreenshot ts = (TakesScreenshot) ((BaseTest) context.getRequiredTestInstance()).driver;

        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("build/reports/tests/" + screenshotName + ".png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        attachScrrenshotToAllure(ts);
    }

    @Attachment
    public byte[] attachScrrenshotToAllure(TakesScreenshot takesScreenshot) {
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }
}

package utility;

import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload {


    public void fileUpload(String filePath, WebElement element) throws AWTException, InterruptedException {
        // Click the label to open the file chooser dialog
        element.click();
        Robot robot = new Robot();
        //Thread.sleep(2000); // Wait for the dialog to appear
        robot.delay(2000);

        // Set the file path in the system clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Use Robot class to simulate keyboard actions


        // Press CTRL + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Thread.sleep(1000); // Wait for the path to be pasted

        // Press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}

package appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
/**
 * Hello world!
 *
 */

public class App 
{
	public DesiredCapabilities capabilities;
	public static AndroidDriver<?> driver;
	//public static TouchActions action;
	
	
    public static void main( String[] args ) throws InterruptedException, MalformedURLException, NoSuchElementException
    {
        System.out.println( "Hello World!" );
        DesiredCapabilities capabilities;
        AndroidDriver<?> driver;
        try {
    		capabilities= new DesiredCapabilities();
    		capabilities.setCapability("instrumentApp", true);
        	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RedmiNote5Pro");
        	driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        	//driver= new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        	driver.executeScript("client:client.deviceAction(\"Home\")");
        	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	//driver.setLogLevel(Level.INFO);
        	List loveBtn;
        	//TouchActions action = new TouchActions(driver);
        	//JavascriptExecutor js=(JavascriptExecutor)driver;
        	System.out.println(driver.getDeviceTime());
        	System.out.println(driver.isAppInstalled("WhatsApp"));
        	driver.findElement(By.xpath("//*[@text='Social']")).click();
        	driver.findElement(By.xpath("//*[@text='Instagram']")).click();
        	Thread.sleep(5000);
        	//loveBtn=driver.findElementsByXPath("//*[@id='row_feed_button_like']");
        	//scroll();
        	boolean btn;
        	int varbtn;
        	//btn=driver.findElementByXPath("//*[@contentDescription='Like' and @knownSuperClass='android.widget.ImageView']").isDisplayed();
        	
        	btn=true;
        	driver.swipe(540, 540, 540, 0, 0);
        	while(btn=true) {
        	//while(driver.findElementByXPath("//*[@contentDescription='Like' and @knownSuperClass='android.widget.ImageView']")!=null || driver.findElementByXPath("//*[@class='android.widget.ImageView' and @contentDescription='Liked']")!=null) {
        		//ScrollToElement(js,driver.findElementByXPath("//*[@contentDescription='Like' and @knownSuperClass='android.widget.ImageView']"));
        		varbtn=driver.findElements(By.xpath("//*[@contentDescription='Like' and @knownSuperClass='android.widget.ImageView']")).size();
        		System.out.println("varbtn: "+varbtn);
        		if(varbtn>0) {
        			driver.findElementByXPath("//*[@contentDescription='Like' and @knownSuperClass='android.widget.ImageView']").click();
            		//driver.swipe(0, starty, endx, endy, duration);
            		driver.swipe(540, 1512, 540, 0, 0);
        		}
        		else {
        			driver.swipe(540, 1680, 0, 0, 0);
        			
        		}
        		if(driver.findElementsByXPath("//*[@contentDescription='Scroll to top' and @top='true']").size()<=0) {
        			Thread.sleep(5000);
        			System.out.println("IN BREAK");
        			driver.executeScript("client:client.deviceAction(\"Back\")");
        			//driver.findElementByXPath("//*[@id='back']").click();
        			System.out.println("BREAK");
        			//break;
        			
        		}

        		
        		System.out.println("Scroll");
        		/*if (btn=true) {
        			System.out.println("Next button found");
        		}
        		else {
        			driver.swipe(540, 1512, 540, 0, 2000);
        			btn=driver.findElementByXPath("//*[@contentDescription='Like' and @knownSuperClass='android.widget.ImageView']").isDisplayed();
        		}
        		System.out.println("Next button found"+btn);*/
        				
        	}
        	driver.executeScript("client:client.deviceAction(\"Back\")");
        	driver.close();
        	//
        	//action.perform();
        	
    	}
    	catch(Exception e) {
    		System.out.println(e);
    		//AssertJUnit.fail(e.getMessage());
    	}
    }
    public void getDeviceConnect() {
    	try {
    		capabilities= new DesiredCapabilities();
        	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RedmiNote5Pro");
        	driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        	driver.executeScript("client:client.deviceAction(\"Home\")");
        	driver.setLogLevel(Level.INFO);
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	
    }
    
    public static void scroll() throws InterruptedException
	{
		//Dimension dimensions = driver.manage().window().getSize();
    	System.out.println("Calling scroll function");
		for(int i=1; i<4; i++)
		{
			Double screenHeightStart = 2160 * 0.5;

			int scrollStart = screenHeightStart.intValue();

			Double screenHeightEnd = 2160 * 0.2;

			int scrollEnd = screenHeightEnd.intValue();

			driver.swipe(0, scrollStart, 0, -scrollEnd, 2000);
			System.out.println("Call scroll function"+i);
			
		}
	}
}
package myrp.library;


import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.net.URL;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

@SuppressWarnings("unused")
public class TestInitReference extends FunctionReference {
    private static final Logger LOGGER = Logger.getLogger(TestInitReference.class);

    public String record = rxml.data("record");
    public static String environment = rxml.data("environment");
    public String remoteUrl = rxml.data("remoteUrl");
    public String chromeDriverPath = rxml.data("chromeDriverPath");
    public static final String USERNAME = "tooltwist";
    public static final String AUTOMATE_KEY = "9quC1U5hBNqMfkAByiyp";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
    
    public String url = rxml.data(environment + "_url");
    protected String ipAddress;

    @SuppressWarnings("static-access")
	@Parameters(value = "IPAddress")
    @BeforeClass()
    public void Startup(@Optional String ipAddress) throws Exception {
        this.ipAddress = ipAddress;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browser.contains("Firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setEnableNativeEvents(true);
            //driver = new FirefoxDriver(new FirefoxBinary(), profile);
            capabilities.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
            //driver = new RemoteWebDriver(new URL(URL), capabilities);//for  browserStack testing
            driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
            //driver.get(remoteUrl);
        }
        if (browser.contains("HTMLUnit")) {
            capabilities = DesiredCapabilities.htmlUnit();
            capabilities.setBrowserName("firefox");
            capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
            driver = new HtmlUnitDriver(capabilities);
        }
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        }
        if (browser.equals("WinChrome")) {
          capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
          capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
          driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
        }
        if (browser.contains("Safari")) {
            driver = new RemoteWebDriver(new URL(remoteUrl), capabilities.safari());
        }
        if (browser.contains("InternetExplorer")) {
        	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        	capabilities.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
        	capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");
            driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
        }
        if (browser.contains("Remote")) {
            try {
                driver = new RemoteWebDriver(new URL(ipAddress), capabilities.chrome());
            } catch (Exception e) {
                driver = new RemoteWebDriver(new URL(remoteUrl), capabilities.chrome());
                LOGGER.warn("Cannot connect to RemoteWebDriver at: " + ipAddress + ". Defaulting to: " + remoteUrl);
            }
            driver.manage().deleteAllCookies();
        }

        if(!browser.contains("HTMLUnit")){
        	browser = ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase().equalsIgnoreCase
                    ("internet explorer") ? "InternetExplorer" : browser;
        }
        
        driver.get(url);
        driver.manage().window().maximize();
        
        if (record.equalsIgnoreCase("Yes")) {
            startRecording();
        }
        
    }

    @AfterClass
    public void teardown() throws Exception {
        if (record.equalsIgnoreCase("Yes")) {
            stopRecording();
        }
        driver.quit();
    }
    
    public void startRecording() throws Exception {
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
        this.screenRecorder = new ScreenRecorder(gc,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null);

        this.screenRecorder.start();
    }

    public void stopRecording() throws Exception {
        if (record.equalsIgnoreCase("Yes")) {
            this.screenRecorder.stop();
        }
    }

    
}

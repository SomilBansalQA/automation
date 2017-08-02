package com.qait.automation;

import static com.qait.automation.utils.ConfigPropertyReader.getProperty;
import static com.qait.automation.utils.YamlReader.getYamlValue;
import static com.qait.automation.utils.YamlReader.setYamlFilePath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.yaml.snakeyaml.Yaml;

import com.coach.keywords.*;
import com.qait.automation.WebDriverFactory;
import com.qait.automation.utils.ConfigPropertyReader;
import com.qait.automation.utils.TakeScreenshot;
import com.qait.automation.utils.TestDataHandler;
import com.qait.automation.utils.WikiPageData;


public class TestSessionInitiator {

	// protected WebDriver driver;
	protected WebDriver driver;
	private final WebDriverFactory wdfactory;
	String browser;
	String seleniumserver;
	String seleniumserverhost;
	String appbaseurl;
	String applicationpath;
	String chromedriverpath;
	String datafileloc = "";
	static int timeout;
	Map<String, Object> chromeOptions = null;
	DesiredCapabilities capabilities;
	public Map<?, ?> config;
    public Map<String, WikiPageData> testData;
  

	/**
	 * Initiating the page objects
	 */

	
	public TopBanner topBanner;
	public MainHeader homeheader;
	public ProductResultPage prodctresult;
	public ProductDetailsPage prodctdetails;
	public ShopingBagPage shopngbagpage;
	public MenSection menSection;
	public Search search;
	public ProductShipingPage shipngpage;
	public ProductPaymentPage paymentpage;
	public OrderReviewPage  ordereviewpage;
	public AccountPage accountPage;
	public HomeLandingPage landingPage;
	public Footer footer;
	public StoreLocator storeLocator;
	public Cart cartpage;
	public CustomerCarePage customerCarePage;
	public AddMonogramPage monogramPage;
	public QuickBuyPage quickbuy;
	public WishList wishlistpage;
	public GiftCard giftCard;
	public MTO mto;

	public TakeScreenshot takescreenshot;
	
	private String testname;
	  public static String tier;
	
	public Random randomGenerator;

	public WebDriver getDriver() {
		return this.driver;
	}

	private void _initPage() {
		homeheader =new MainHeader(driver);
		prodctresult=new ProductResultPage(driver);
		prodctdetails=new ProductDetailsPage(driver);
		shopngbagpage=new ShopingBagPage(driver);
		menSection = new MenSection(driver);
		search = new Search(driver);
		shipngpage=new ProductShipingPage(driver);
		paymentpage=new ProductPaymentPage(driver);
		ordereviewpage=new OrderReviewPage(driver);
		topBanner = new TopBanner(driver);
		accountPage = new AccountPage(driver);
		landingPage = new HomeLandingPage(driver);
		footer = new Footer(driver);
		storeLocator = new StoreLocator(driver);
		cartpage=new Cart(driver);
		customerCarePage = new CustomerCarePage(driver);
		monogramPage = new AddMonogramPage(driver);
		quickbuy= new QuickBuyPage(driver);
		wishlistpage= new WishList(driver);	
		giftCard= new GiftCard(driver);
		mto= new MTO(driver);
	}

	public void modify_java_file()
	{
	
		File log= new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qait\\hbp\\ereader\\keywords\\AnnotationHighlightActions.java");
		String search = "WebDriver driver";
		String replace = "AndroidDriver driver";
		String search1= "AndroidDriver driver";
		String replace1="WebDriver driver";
		List<String> list1=new ArrayList<String>();

		try{
		    FileInputStream fr = new FileInputStream(log);
		    String s;
		    try (BufferedReader br = new BufferedReader(new InputStreamReader(fr))) {

		        while ((s = br.readLine()) != null) {
		        	if(ConfigPropertyReader.getProperty("browser").equals("mobile"))
		        	   s=s.replaceAll(search, replace);
		        	else
		        	   s=s.replaceAll(search1, replace1);
		        	list1.add(s);
		        }
		        //totalStr = totalStr.;
		        FileWriter fw = new FileWriter(log);
		        BufferedWriter bw=new BufferedWriter(fw);
		        for(String s1:list1)
		        	{
		        	  bw.write(s1);
		        	  bw.newLine();
		        	}
		        
		        br.close();
		    bw.close();
		    }
		}catch(Exception e){
		    e.printStackTrace();
		}
		
			  
	}
	
	
	/**
	 * Page object Initiation done
	 *
	 * @param testname
	 */
	public TestSessionInitiator(String testname) {
		wdfactory = new WebDriverFactory();
		testInitiator(testname);
		this.testname = testname;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TestSessionInitiator(String testname, String browserName){
		if (System.getProperties().containsKey("browser")) {
			browserName = System.getProperty("browser");
		}

		try {
			testConfigutationPath();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wdfactory = new WebDriverFactory(browserName);
		try {
			initTestData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testInitiator(testname);
		this.testname = testname;

	}
	  
	
	  private void testConfigutationPath() throws FileNotFoundException {
		  config = new HashMap();
          Yaml yaml = new Yaml();
	    	String tierFromConfigFile = getProperty("Config.properties", "tier").trim();
	    	tier = System.getProperty("environment",tierFromConfigFile);
	    	  if (tier.equalsIgnoreCase("dev")) {
	    		  String yamlpath=   "src/test/resources/testdata/DEV_TestData.yml";
	    		  config = (Map<?,?>) yaml.load(new FileInputStream(new File(yamlpath)));
	          } else if (tier.equalsIgnoreCase("dev2")){
	        	  String yamlpath=   "src/test/resources/testdata/DEV2_TestData.yml";
	        	  config = (Map<?,?>) yaml.load(new FileInputStream(new File(yamlpath)));
	          } else if (tier.equalsIgnoreCase("stage")){
	        	  String yamlpath=   "src/test/resources/testdata/STAGE_TestData.yml";
	        	  config = (Map<?,?>) yaml.load(new FileInputStream(new File(yamlpath)));
	          } 
	          
	          else if (tier.equalsIgnoreCase("stage2")){
	        	  String yamlpath=   "src/test/resources/testdata/STAGE2_TestData.yml";
	        	  config = (Map<?,?>) yaml.load(new FileInputStream(new File(yamlpath)));
	          }
	          else if (tier.equalsIgnoreCase("prod") || tier.equalsIgnoreCase("production")) {
//	        	  File file	=	new File("src/test/resources/testdata/PROD_TestData.yml");
//	        	  String yamlpath=  file.getAbsolutePath();
	        	  String yamlpath=   "src/test/resources/testdata/PROD_TestData.yml";
	        	  config = (Map<?,?>) yaml.load(new FileInputStream(new File(yamlpath)));
	          } else {
	              Reporter.log("YOU HAVE PROVIDED WRONG TIER IN CONFIG!!! using dev test data", true);
	          }
	}

	private void initTestData() throws Exception{
	        TestDataHandler testDataHandler = new TestDataHandler(config);
	        testData = testDataHandler.testDataMap();
	    }
	  

	private void testInitiator(String testname) {
		setYamlFilePath();
		_configureBrowser();
		_initPage();
		takescreenshot = new TakeScreenshot(testname, this.driver);
	}

	private void _configureBrowser() {
		driver = wdfactory.getDriver(_getSessionConfig());
		if(!(_getSessionConfig().get("browser").toLowerCase().contains("mobile"))){
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
		driver.manage()
				.timeouts()
				.implicitlyWait(Integer.parseInt(getProperty("timeout")),
						TimeUnit.SECONDS);
	}

	private Map<String, String> _getSessionConfig() {
		String[] configKeys = { "tier", "browser", "seleniumserver",
				"seleniumserverhost", "timeout", "driverpath", "appiumServer",
				"mobileDevice" };
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, getProperty("./Config.properties", string));
		}
		return config;
	}

	

	public void launchApplication(String base_url) {
		Reporter.log("\n[INFO]: The application url is :- " + base_url, true);
		driver.manage().deleteAllCookies();
		
		driver.get(base_url);
		
	}
	
	
//	public void login_Into_CB_and_Launch_EPub(String baseURL)
//	{
//		//1. launch login URL
//	    loginAndEPubLaunchingPage.is_User_Able_To_Launch_Login_URL(baseURL);
//		
//	    //2. Enter user name and pass word
//		loginAndEPubLaunchingPage.enter_UserName_And_PassWord(
//				YamlReader.getData("users.student.username2"), YamlReader.getData("users.student.password2"));
//		
//		//3. launch login URL
//	    loginAndEPubLaunchingPage.is_user_Able_To_Login_Into_Application();
//	    
//	    //1. launch login URL
//	    loginAndEPubLaunchingPage.is_User_Able_To_Navigate_To_Coursepacks_Page();
//	    
//	    //1. launch login URL
//	    loginAndEPubLaunchingPage.is_User_Able_To_Navigate_To_Particular_Coursepack(YamlReader.getData("CoursePackName"));
//	    
//	    String epubNameReadFromYAML=YamlReader.getData("ePub");
//	    epubNameReadFromYAML=epubNameReadFromYAML.replace("_",": ");
//	    Reporter.log("[INFO]: EPUB title is : "+epubNameReadFromYAML,true);
//	    
//	    //1. launch login URL
//	    loginAndEPubLaunchingPage.is_User_Able_To_Click_View_Document_Link_For_EPUB(epubNameReadFromYAML);
//		
//	}
	public void openUrl(String url) {
		driver.get(url);
	}

	public void closeBrowserSession() {
		Reporter.log("[INFO]: The Test: " + this.testname.toUpperCase() + " COMPLETED!"
				+ "\n", true);
		try{
			driver.quit();
		}
		catch(RuntimeException e){
		System.out.println("Exception caught while closing the browser");
		}
		
	}

	public void closeTestSession() {
		closeBrowserSession();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	
	
	
	public void stepStartMessage(String testStepName) {
        Reporter.log(" ", true);
        Reporter.log("***** STARTING TEST STEP:- " + testStepName+ " *****", true);
        Reporter.log(" ", true);
    }
	
	
	
	
}

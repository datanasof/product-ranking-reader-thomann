package server;

public class Credentials {
	
	private static String usbPage1 = "https://www.thomann.de/intl/bg/usb_audio_interfaces.html?ls=100";
	private static String usbPage2 = "https://www.thomann.de/intl/bg/usb_audio_interfaces.html?pg=2";
	private static String usbPage3 = "https://www.thomann.de/intl/bg/usb_audio_interfaces.html?pg=3";
	private static String usbPage4 = "https://www.thomann.de/intl/bg/usb_audio_interfaces.html?pg=4";
	public static String[] THcategory = {"https://www.thomann.de/intl/bg/thunderbolt_interfaces.html?ls=100"};
	public static String[] USBcategory = {usbPage1, usbPage2, usbPage3, usbPage4};
	public static String reportsCategory = "reports";
	public static String reportFilePath = "reports/";
	public static String productsToCheck = "products.txt";
	public static String USER_NAME = "antelope.reports";  // GMail user name (just the part before "@gmail.com")
	public static String PASSWORD = "AntelopeAudio123"; // GMail password
	public static String RECIPIENTS = "email_recipients.txt"; // contains recipients of the report
	public static final String priceParserTag = "span[itemprop=\"price\"]";
   
}

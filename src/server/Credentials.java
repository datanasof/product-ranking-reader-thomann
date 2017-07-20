package server;

public class Credentials {
	
	private static String usbPage1 = "https://www.thomann.de/de/usb_audio_interfaces.html?ls=100";
	private static String usbPage2 = "https://www.thomann.de/de/usb_audio_interfaces.html?pg=2&ls=100";
	private static String usbPage3 = "https://www.thomann.de/de/usb_audio_interfaces.html?pg=3&ls=100";
	private static String usbPage4 = "https://www.thomann.de/de/usb_audio_interfaces.html?pg=4&ls=100";
	public static String[] THcategory = {"https://www.thomann.de/de/thunderbolt_interfaces.html?ls=100"};
	public static String[] USBcategory = {usbPage1, usbPage2, usbPage3, usbPage4};
	public static String reportsCategory = "reports";
	public static String reportFilePath = "reports/";
	public static String productsToCheck = "products.txt";

}

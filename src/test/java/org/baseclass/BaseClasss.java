package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasss {

	static WebDriver driver;
	WebElement element;
	Actions actions;
	Alert alert;
	Select select;
	JavascriptExecutor executor;
	// 1

	public static void launchUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2
	public static void getUrl(String url) {
		driver.get(url);

	}

	// 3
	public void toMaximize() {
		driver.manage().window().maximize();
	}

	// 4
	public void toMinimize() {
		driver.manage().window().minimize();
	}

	// 5
	public void toNavigateurl(String url) {
		driver.navigate().to(url);
	}

	// 6
	public void toForward() {
		driver.navigate().forward();
	}

	// 7
	public void toBackword() {
		driver.navigate().back();
	}

	// 8
	public void toRefresh() {
		driver.navigate().refresh();
	}

	// 9
	public void toClick(WebElement element) {
		element.click();
	}

	// 10
	public String toGetTittle(String tiitle) {
		String title = driver.getTitle();
		return title;
	}

	// 11
	public void toSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	// 12 LOCATORS
	public WebElement toFindById(String attributevalue) {
		element = driver.findElement(By.id(attributevalue));
		return element;
	}

	// 13
	public WebElement toFindByName(String attributevalue) {
		element = driver.findElement(By.name(attributevalue));
		return element;
	}

	// 14
	public WebElement toFindByClassName(String attributevalue) {
		element = driver.findElement(By.className(attributevalue));
		return element;
	}

	// 15
	public WebElement toFindByXpath(String attributevalue) {
		element = driver.findElement(By.xpath(attributevalue));
		return element;
	}

	// 16 Actions
	public void toDragAndDrop(WebElement element, WebElement element2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element, element2).perform();
	}

	// 17
	public void toMoveToOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	// 18
	public void todoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	}

	// 19
	public void toRightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}

	// 20 Keys
	public void toKeyup(WebElement element) {
		Actions action = new Actions(driver);
		action.keyUp("key").perform();
	}

	// 21
	public void keyDown(WebElement element) {
		Actions action = new Actions(driver);
		action.keyDown("Key").perform();
	}

	// 22 ALERT
	public void toSimpleAlert(WebElement element) {
		alert = driver.switchTo().alert();
		alert.accept();
	}

	// 23
	public void toConformAlert(WebElement element) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 24
	public void toPromptAlert(String text) {
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}

	// 25 SCREENSHOT
	public void toScreenshotAs(String pathName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File s = takesScreenshot.getScreenshotAs(OutputType.FILE);

		File d = new File(pathName + ".png");
		FileUtils.copyFile(s, d);
	}

	// 26 JAVASCRIPTEXECUTOR
	public void executorLaunch(String url) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("windows.locations='url'");
	}

	// 27
	public void jsInsertValue(String text) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
	}

	// 28
	public Object getAttributeValue(WebElement element) {
		executor = (JavascriptExecutor) driver;

		Object executeScript = executor.executeScript("return arguments[0].getAttributeValue('value')", element);
		return executeScript;
	}

	// 29
	public void javaScriptClick(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	// 30
	public void javaScriptScrollDown(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView('true')", element);
	}

	// 31
	public void javaScriptScrollUp(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView('false')", element);
	}

	// 32 SELECT
	public void toSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 33
	public void toSelectByIndex(WebElement element, int value) {
		select = new Select(element);
		select.selectByIndex(value);
	}

	// 34
	public void toSelectByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 35
	public List<WebElement> toGetOption(WebElement element) {
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	// 36
	public List<WebElement> toSelectallOption(WebElement element) {
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	// 37
	public WebElement toGetFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement options = select.getFirstSelectedOption();
		return options;
	}

	// 38
	public void toDeselectByValue(WebElement element, String value) {
		select = new Select(element);
		select.deselectByValue(value);
	}

	// 39
	public void toDeselectByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 40
	public void toDeselectByIndex(WebElement element, int value) {
		select = new Select(element);
		select.deselectByIndex(value);
	}

	// 41
	public void toDeslectedValue(WebElement element) {
		select = new Select(element);
		select.deselectAll();
	}

	// 42
	public boolean toIsMultiple(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// 43 FRAMES
	public void frameByIndex(int i) {
		driver.switchTo().frame(i);
	}

	// 44
	public void frameById(String id) {
		driver.switchTo().frame(id);
	}

	// 45
	public void frameByElement() {
		driver.switchTo().frame(element);
	}

	// 46
	public void parentFrame() {
		driver.switchTo().parentFrame();
	}

	// 47
	public void returnFrame() {
		driver.switchTo().defaultContent();
	}

	// 48
	public String getParentwindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	// 49
	public Set<String> getAllWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	// 50
	public static void toClose() {
		driver.close();
	}

	// 51
	public void toCloseAllWWindow() {
		driver.quit();
	}

	// 52 FRAME WORK

	public void writeData(String name, int rowNo, int cellNo, String data) throws IOException {

		File file = new File("C:\\Users\\User\\eclipse-workspace\\TestNG\\Excel\\TestNG....Adactin..Order.xlsx");

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("name");

		Row row = sheet.createRow(rowNo);

		Cell cell = row.createCell(cellNo);

		cell.setCellValue(data);

		FileOutputStream outputStream = new FileOutputStream(file);

		workbook.write(outputStream);
	}

	// 53
	public static String getData(String sheetname, int rownum, int cellnum) throws IOException {
		String res = null;

		File file = new File("C:\\Users\\91967\\eclipse-workspace\\MavenLaunch_1day\\Excel\\excelsheet2.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		switch (type) {

		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				dateFormat.format(dateCellValue);
			} else {
				double d = cell.getNumericCellValue();

				BigDecimal num = BigDecimal.valueOf(d);
				res = num.toString();
			}
		default:
			break;
		}
		return res;
	}

	// 55
	public void updateData(String sheetname, int rownum, int cellnum, String olddata, String newdata)
			throws IOException {

		File file = new File("C:\\Users\\MANGAI\\eclipse-workspace\\JUNIT\\Excel\\HariSheets 1.xlsx");

		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();

		String value = cell.getStringCellValue();

		if (value.equals(olddata)) {
			cell.setCellValue(newdata);

			FileOutputStream out = new FileOutputStream(file);

			workbook.write(out);
		}
	}

	// 56
	public void fullscreen() {
		driver.manage().window().fullscreen();
	}

	// 57
	public String Prop(String url) throws IOException {
		Properties prop = new Properties();
		FileReader reader = new FileReader(
				new File("C:\\Users\\91967\\eclipse-workspace\\MavenLaunch_1day\\Properties"));
		prop.load(reader);

		String string = prop.get(url).toString();
		return string;
	}

	// 58
	public void implicitWait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}

	// 59
	public void webDriverWait(Duration seconds) {
		WebDriverWait driverwait = new WebDriverWait(driver, seconds);
	}

	// 60
	public void selectOptionbyIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	// 61
	public String toGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 62
	public void toClear() {
		element.clear();
	}

	// 63
	public String getAttributeValue1(WebElement element, String string) {
		String data = element.getAttribute("value");
		return data;
	}
}

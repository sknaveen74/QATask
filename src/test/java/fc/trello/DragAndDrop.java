package fc.trello;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DragAndDrop {
	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trello.com/en");
		//Login into trello
		WebElement login = driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']"));
		login.click();
		WebElement loginid = driver.findElement(By.id("user"));
		loginid.sendKeys("s.k.naveensurya97@gmail.com"+Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement loginpass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		loginpass.sendKeys("naveen742277"+Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Creating new board
		WebElement createBoard = driver.findElement(By.xpath("//div[@class='board-tile mod-add']"));
		createBoard.click();
		WebElement boardName = driver.findElement(By.xpath("//input[@data-test-id='create-board-title-input']"));
		boardName.sendKeys("QATask"+Keys.ENTER);
		
		//Creating list A and list B
		WebElement listAdd1 = driver.findElement(By.xpath("//span[@class='placeholder']"));
		listAdd1.click();
		WebElement listNameA = driver.findElement(By.xpath("//input[@class='list-name-input']"));
		listNameA.sendKeys("ListA"+Keys.ENTER);
		WebElement listNameB = driver.findElement(By.xpath("//input[@placeholder='Enter list title…']"));
		listNameB.sendKeys("ListB"+Keys.ENTER);
		
		//Adding the card in list A
		WebElement addCard = driver.findElement(By.xpath("(//span[@class='js-add-a-card'])[4]"));
		addCard.click();
		WebElement cardName = driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"));
		cardName.sendKeys("Task"+Keys.ENTER);
		WebElement closeCard = driver.findElement(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"));
		closeCard.click();
		
		//Drag and Drop
		WebElement dragCard = driver.findElement(By.xpath("//div[@class='list-card-details js-card-details']"));
		WebElement dropCard = driver.findElement(By.xpath("(//a[@class='open-card-composer js-open-card-composer'])[5]"));
		Actions action = new Actions(driver);
		action.dragAndDrop(dragCard, dropCard).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//To get the card coordinates
		WebElement cardCoordinates = driver.findElement(By.xpath("//div[@class='list-card-details js-card-details']"));
		Point coord = cardCoordinates.getLocation();
		System.out.println("The X-Coordinate is "+coord.getX());
		System.out.println("The Y-Coordinate is "+coord.getY());
		driver.quit();
	}
	}



package com.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.todo.util.BasePage;

public class TodosPage extends BasePage {

	public TodosPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	/* Locators */

	final static String INPUT_TEXT = "//input[@type='text']";
	final static String BOUTTON_SUBMIT = "//button[@type='submit']";
	final static String ELEMENT_TODO_1 = "/html/body/ul/li/span";
	final static String CHECKBOX = "//input[@type='checkbox']";

	final static String ELEMENT1 = "//span[@data-id='text.todo_description-1']";
	final static String ELEMENT2 = "//span[@data-id='text.todo_description-2']";
	final static String ELEMENT3 = "//span[@data-id='text.todo_description-3']";
	final static String ELEMENT4 = "//span[@data-id='text.todo_description-4']";
	final static String CHECKBOX2 = "//input[@data-id='input.checkbox.done-2']";
	final static String CHECKBOX3 = "//input[@data-id='input.checkbox.done-3']";
	
	final static String SELECT1 = "//input[@data-id='input.radio.category_Personnel']";
	final static String SELECT2 = "//input[@data-id='input.radio.category_Professionnel']";
	final static String SELECT3 = "//input[@data-id='input.radio.category_Tout']";

	final static String BOUTTON_REMOVE = "ul .au-target:nth-child(3)";
	final static String DROPDOWN = "//select[@data-id='select.category']";
	final static String TODO_1 = "//li[@data-id='todo-1']";
	final static String TODO_2 = "//li[@data-id='todo-2']";
	final static String TODO_3 = "//li[@data-id='todo-3']";
	final static String TODO_4 = "//li[@data-id='todo-4']";

	/* @FindBy */

	@FindBy(how = How.XPATH, using = INPUT_TEXT)
	public static WebElement inputText;
	@FindBy(how = How.XPATH, using = BOUTTON_SUBMIT)
	public static WebElement submitBoutton;
	@FindBy(how = How.XPATH, using = ELEMENT_TODO_1)
	public static WebElement elementTodo1;
	@FindBy(how = How.XPATH, using = CHECKBOX)
	public static WebElement checkbox;

	@FindBy(how = How.XPATH, using = ELEMENT1)
	public static WebElement element1;
	@FindBy(how = How.XPATH, using = ELEMENT2)
	public static WebElement element2;
	@FindBy(how = How.XPATH, using = ELEMENT3)
	public static WebElement element3;
	@FindBy(how = How.XPATH, using = ELEMENT4)
	public static WebElement element4;
	
	
	@FindBy(how = How.XPATH, using = CHECKBOX2)
	public static WebElement checkbox2;
	@FindBy(how = How.XPATH, using = CHECKBOX3)
	public static WebElement checkbox3;
	
	@FindBy(how = How.XPATH, using = SELECT1)
	public static WebElement select1;
	@FindBy(how = How.XPATH, using = SELECT2)
	public static WebElement select2;
	@FindBy(how = How.XPATH, using = SELECT3)
	public static WebElement select3;
	

	@FindBy(how = How.CSS, using = BOUTTON_REMOVE)
	public static WebElement buttonRemove;
	@FindBy(how = How.XPATH, using = DROPDOWN)
	public static WebElement dropDown;
	@FindBy(how = How.XPATH, using = TODO_1)
	public static WebElement todo1;
	@FindBy(how = How.XPATH, using = TODO_2)
	public static WebElement todo2;
	@FindBy(how = How.XPATH, using = TODO_3)
	public static WebElement todo3;
	@FindBy(how = How.XPATH, using = TODO_4)
	public static WebElement todo4;

	/* Methods */

	public void submitTodo(String todo) {

		writeText(inputText, todo);
		click(submitBoutton);
	}

	public void clickCheckbox() {

		click(checkbox);
	}

	public void removeTodo() {

		click(buttonRemove);
	}

	public Boolean isElementDisplayed(WebElement element) {

		Boolean isElementTextDisplayed = element.isDisplayed();
		return isElementTextDisplayed;
	}

	public Boolean isCheckboxSelected(WebElement element) {

		Boolean isCheckboxSelected = element.isSelected();
		return isCheckboxSelected;
	}

	public String checkElementContain(WebElement element) {

		String elementTodo = element.getText();
		return elementTodo;
	}

	public String getPageSource() {

		String element = driver.getPageSource();
		return element;
	}

	public void selectCategory(String category) {

		WebElement element = dropDown;
		Select select = new Select(element);
		select.selectByValue(category);
	}
	
	public void selectPrivate() {

		WebElement element = select1;
		element.click();
	}
	
	public void selectProfessionnal() {

		WebElement element = select2;
		element.click();
	}
	
	public void selectTout() {

		WebElement element = select3;
		element.click();
	}
	
	

}

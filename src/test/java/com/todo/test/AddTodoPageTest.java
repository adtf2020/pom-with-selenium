package com.todo.test;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.pages.TodosPage;
import com.todo.util.Setup;

public class AddTodoPageTest extends Setup {

	public AddTodoPageTest() throws IOException {
		super();
	}

	TodosPage todosPage;

	@Test()
	public void iCanAddTodo() throws IOException {

		todosPage = new TodosPage();
		boolean elementText = todosPage.isElementDisplayed(TodosPage.inputText);
		Assert.assertTrue(elementText);
		todosPage.submitTodo(prop.getProperty("TODO1"));
		String elementTodo = todosPage.checkElementContain(TodosPage.element1);
		Assert.assertTrue(elementTodo.contains(prop.getProperty("TODO1")));
		boolean checkbox = todosPage.isCheckboxSelected(TodosPage.checkbox);
		Assert.assertFalse(checkbox);
	}

}

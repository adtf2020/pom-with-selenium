package com.todo.test;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.pages.TodosPage;
import com.todo.util.Setup;

public class RemoveTodoPageTest extends Setup {

	public RemoveTodoPageTest() throws IOException {
		super();
	}

	TodosPage todosPage;

	@Test()
	public void iCanRemoveTodo() throws IOException {

		todosPage = new TodosPage();
		todosPage.submitTodo(prop.getProperty("TODO4"));
		boolean buttonRemove = todosPage.isElementDisplayed(TodosPage.buttonRemove);
		Assert.assertTrue(buttonRemove);
		todosPage.removeTodo();
		String element = todosPage.getPageSource();
		Assert.assertFalse(element.contains(prop.getProperty("TODO4")));

	}

}

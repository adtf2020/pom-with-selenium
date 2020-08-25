package com.todo.test;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.pages.TodosPage;
import com.todo.util.Setup;

public class CategorizeTodoPageTest extends Setup {

	public CategorizeTodoPageTest() throws IOException {
		super();
	}

	TodosPage todosPage;

	@Test()
	public void iCanAddTodo() throws IOException {

		todosPage = new TodosPage();
		todosPage.submitTodo(prop.getProperty("TODO5"));
		String elementTodo1 = todosPage.checkElementContain(TodosPage.todo1);
		Assert.assertFalse(elementTodo1.contains(prop.getProperty("PRIVATE")));
		Assert.assertFalse(elementTodo1.contains(prop.getProperty("PROFESSIONNAL")));
		todosPage.selectCategory(prop.getProperty("PRIVATE"));
		todosPage.submitTodo(prop.getProperty("TODO6"));
		String elementTodo2 = todosPage.checkElementContain(TodosPage.todo2);
		Assert.assertTrue(elementTodo2.contains(prop.getProperty("PRIVATE")));
		todosPage.submitTodo(prop.getProperty("TODO7"));
		String elementTodo3 = todosPage.checkElementContain(TodosPage.todo3);
		Assert.assertTrue(elementTodo3.contains(prop.getProperty("PRIVATE")));
		todosPage.selectCategory(prop.getProperty("PROFESSIONNAL"));
		todosPage.submitTodo(prop.getProperty("TODO8"));
		String elementTodo4 = todosPage.checkElementContain(TodosPage.todo4);
		Assert.assertTrue(elementTodo4.contains(prop.getProperty("PROFESSIONNAL")));
	}

}

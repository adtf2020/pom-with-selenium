package com.todo.test;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.pages.TodosPage;
import com.todo.util.Setup;

public class SelectTodoPageTest extends Setup {

	public SelectTodoPageTest() throws IOException {
		super();
	}

	TodosPage todosPage;

	@Test()
	public void iCanSelectTodo() throws IOException {

		todosPage = new TodosPage();
		todosPage.submitTodo(prop.getProperty("TODO1"));
		todosPage.submitTodo(prop.getProperty("TODO2"));
		todosPage.submitTodo(prop.getProperty("TODO3"));
		String elementTodo1 = todosPage.checkElementContain(TodosPage.element1);
		Assert.assertTrue(elementTodo1.contains(prop.getProperty("TODO1")));
		String elementTodo2 = todosPage.checkElementContain(TodosPage.element2);
		Assert.assertTrue(elementTodo2.contains(prop.getProperty("TODO2")));
		String elementTodo3 = todosPage.checkElementContain(TodosPage.element3);
		Assert.assertTrue(elementTodo3.contains(prop.getProperty("TODO3")));
		todosPage.clickCheckbox();
		boolean checkbox = todosPage.isCheckboxSelected(TodosPage.checkbox);
		Assert.assertTrue(checkbox);
		boolean checkbox2 = todosPage.isCheckboxSelected(TodosPage.checkbox2);
		Assert.assertFalse(checkbox2);
		boolean checkbox3 = todosPage.isCheckboxSelected(TodosPage.checkbox3);
		Assert.assertFalse(checkbox3);

	}
}

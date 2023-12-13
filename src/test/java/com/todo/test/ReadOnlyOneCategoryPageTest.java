package com.todo.test;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.pages.TodosPage;
import com.todo.util.Setup;

public class ReadOnlyOneCategoryPageTest extends Setup {

	public ReadOnlyOneCategoryPageTest() throws IOException {
		super();
	}

	TodosPage todosPage;

	@Test()
	public void iCanReadOnlyOneCategoryOfTodos() throws IOException {

		todosPage = new TodosPage();
		todosPage.submitTodo(prop.getProperty("TODO9"));
		todosPage.selectCategory(prop.getProperty("PROFESSIONNAL"));
		todosPage.submitTodo(prop.getProperty("TODO10"));
		todosPage.selectCategory(prop.getProperty("PRIVATE"));
		todosPage.submitTodo(prop.getProperty("TODO11"));
		todosPage.selectCategory(prop.getProperty("PROFESSIONNAL"));
		todosPage.submitTodo(prop.getProperty("TODO12"));
		String elementTodo1 = todosPage.checkElementContain(TodosPage.element1);
		Assert.assertTrue(elementTodo1.contains(prop.getProperty("TODO9")));
		String elementTodo2 = todosPage.checkElementContain(TodosPage.element2);
		Assert.assertTrue(elementTodo2.contains(prop.getProperty("TODO10")));
		String elementTodo3 = todosPage.checkElementContain(TodosPage.element3);
		Assert.assertTrue(elementTodo3.contains(prop.getProperty("TODO11")));
		String elementTodo4 = todosPage.checkElementContain(TodosPage.element4);
		Assert.assertTrue(elementTodo4.contains(prop.getProperty("TODO12")));
		todosPage.selectPrivate();
		String elementTodo31 = todosPage.checkElementContain(TodosPage.element3);
		Assert.assertTrue(elementTodo31.contains(prop.getProperty("TODO11")));
		todosPage.selectProfessionnal();
		String elementTodo22 = todosPage.checkElementContain(TodosPage.element2);
		Assert.assertTrue(elementTodo22.contains(prop.getProperty("TODO10")));
		String elementTodo42 = todosPage.checkElementContain(TodosPage.element4);
		Assert.assertTrue(elementTodo42.contains(prop.getProperty("TODO12")));
		todosPage.selectTout();
		String elementTodo13 = todosPage.checkElementContain(TodosPage.element1);
		Assert.assertTrue(elementTodo13.contains(prop.getProperty("TODO9")));
		String elementTodo23 = todosPage.checkElementContain(TodosPage.element2);
		Assert.assertTrue(elementTodo23.contains(prop.getProperty("TODO10")));
		String elementTodo33 = todosPage.checkElementContain(TodosPage.element3);
		Assert.assertTrue(elementTodo33.contains(prop.getProperty("TODO11")));
		String elementTodo43 = todosPage.checkElementContain(TodosPage.element4);
		Assert.assertTrue(elementTodo43.contains(prop.getProperty("TODO12")));

	}

}

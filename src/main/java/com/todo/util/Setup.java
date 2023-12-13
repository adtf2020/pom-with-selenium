package com.todo.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Setup extends BasePage {

	public Setup() throws IOException {
		super();

	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void setupTest(String browser) throws IOException {

		initialization(browser);
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertThat(driver.getTitle(), is("Aurelia Navigation Skeleton"));
		Dimension d = new Dimension(600, 300);
		driver.manage().window().setSize(d);
	}

	@AfterMethod
	public void cleanTest() {

		driver.navigate().refresh();
		driver.quit();
	}
}

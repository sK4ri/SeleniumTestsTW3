#TODO (code review notes)

- TestBase class -> base URL, environment variables (username, password), WebDriver instance (could be a singleton for future use in different environments)
- ProjectPages class -> constructor gets the project ID as a parameter
- similar methods and elements -> same thing, except @FindBy can't be parameterized -> use driver.findElement()
- our POM keywords are too high level at the moment -> smaller keywords (e.g. setUsername, setPassword, clickLoginButton)
- return Page instances instead of void methods -> one long method call: setUsername().setPassword().clickLoginButton()
- no need to create CSV for one line of data -> environment variable -> TestBase!

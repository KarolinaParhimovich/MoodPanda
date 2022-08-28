package tests;

import constants.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        boolean isMainPageDisplayed = loginPage
                .login(Credentials.USERNAME, Credentials.PASSWORD)
                .isPostUpdateDisplayed();
        Assert.assertTrue(isMainPageDisplayed, "User didn't log in");
    }

    @Test
    public void hugTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Credentials.USERNAME, Credentials.PASSWORD);
        MainPage mainPage = new MainPage();
        boolean isHugDisplayed = mainPage
                .isNameOfUserDisplayed();
        Assert.assertTrue(isHugDisplayed, "User didn't hug");
    }

    @Test
    public void deletePost() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Credentials.USERNAME, Credentials.PASSWORD);
        MainPage mainPage = new MainPage();
        mainPage.creatingPost();
        boolean isPostDeleted = mainPage.deletePost();
        Assert.assertTrue(isPostDeleted, "Post was not deleted");
    }

    @Test
    public void updatingFirstName() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Credentials.USERNAME, Credentials.PASSWORD);
        MainPage mainPage = new MainPage();
        boolean isFirstNameChanged = mainPage.changeFirstName();
        Assert.assertTrue(isFirstNameChanged,"Firstname was not changed");
    }
    @Test
    public void updatingLastName() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Credentials.USERNAME, Credentials.PASSWORD);
        MainPage mainPage = new MainPage();
        boolean isLastNameChanged = mainPage.changeLastName();
        Assert.assertTrue(isLastNameChanged,"Lastname was not changed");
    }
}

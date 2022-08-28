package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import constants.Urls;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement postUpdate = $(new ByText("Post update"));
    private SelenideElement hugButton = $(By.xpath("//a[text()='Hug']"));
    private SelenideElement nameOfUser = $(By.xpath("//span[contains(., 'Karolina P') and contains(@class, 'tag is-white is-medium')]"));
    private SelenideElement messageButton = $(new ByText("friends"));
    private SelenideElement updateButton = $(By.xpath("//a[contains(text(),'Update to 5')]"));
    private SelenideElement actionWithPost = $(By.xpath("//div[contains(., 'Karolina') and contains(@class, 'card is-warning')]//a[@aria-controls='dropdown-menu3']"));
    private SelenideElement deleteButton = $(new ByText("Delete"));
    private SelenideElement homeButton = $(By.xpath("//a[contains(text(),'Home')]"));
    private SelenideElement dashboardButton = $(new ByText("Your dashboard"));
    private SelenideElement editProfile =$(By.xpath("//ul[@class='menu-list']//a[contains(text(),'Edit profile ')]"));
    private SelenideElement firstName = $(By.xpath("//input[contains(@placeholder,'e.g Jake')]"));
    private SelenideElement newFirstName=$(new ByText("Kira P"));
    private SelenideElement lastName = $(By.xpath("//input[contains(@placeholder,'e.g. S')]"));
    private SelenideElement newLastName=$(new ByText("Kira G"));
    private SelenideElement saveIdentity = $(new ByText("Save identity"));
    private SelenideElement deletingMessage=$(By.xpath("//div[contains(@class, 'is-success')]"));

    public boolean isPostUpdateDisplayed() {
        postUpdate.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return postUpdate.isDisplayed();
    }

    public boolean isNameOfUserDisplayed() {
        hugButton.click();
        nameOfUser.shouldBe(Condition.visible, Duration.ofSeconds(20));
        return nameOfUser.isDisplayed();
    }

    public void creatingPost() throws InterruptedException {
        postUpdate.click();
        messageButton.click();
        updateButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        updateButton.click();
        Thread.sleep(10000);
        open(Urls.HOME_URL);
    }

    public boolean deletePost() throws InterruptedException {
                while(!actionWithPost.isDisplayed()){
            Selenide.refresh();
            Thread.sleep(1000);
        }
        actionWithPost.click();
        deleteButton.shouldBe(Condition.visible, Duration.ofSeconds(20));
        deleteButton.click();
        deletingMessage.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return deletingMessage.isDisplayed();
    }

    public boolean changeFirstName() {
        dashboardButton.click();
        editProfile.shouldBe(Condition.visible, Duration.ofSeconds(20));
        editProfile.click();
        firstName.clear();
        firstName.sendKeys("Kira");
        saveIdentity.click();
        newFirstName.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return newFirstName.isDisplayed();
    }

    public boolean changeLastName() {
        dashboardButton.click();
        editProfile.shouldBe(Condition.visible, Duration.ofSeconds(20));
        editProfile.click();
        lastName.clear();
        lastName.sendKeys("G");
        saveIdentity.click();
        newLastName.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return newLastName.isDisplayed();
    }

}

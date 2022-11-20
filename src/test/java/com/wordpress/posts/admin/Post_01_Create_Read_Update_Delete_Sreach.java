  package com.wordpress.posts.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddnewPO;
import pageObject.wordpress.AdminPostSreachPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailPO;
import pageObject.wordpress.UserSreachPostPO;
@Listeners
public class Post_01_Create_Read_Update_Delete_Sreach extends BaseTest {
	 WebDriver driver;
	 AdminLoginPO adminLoginPage;
	 AdminDashboardPO adminDashboardPage;
	 AdminPostSreachPO adminPostSreachPage;
	 AdminPostAddnewPO adminPostAddnewPage;
	 UserHomePO userHomePage;
	 UserPostDetailPO userPostDetailPage;
	 UserSreachPostPO userSreachPostPage;
	String adminUsername, adminPassword;
	String sreachPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;
	String editPostTitle = "Edit Coding Title " + randomNumber;
	String editPostBody = "Edit Coding Body " + randomNumber;
	String authorName = "Automation FC";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();
	

	@Parameters({"browser", "urlAdmin", "urlUser"})
	@BeforeClass 
	 public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
	log.info("Pre-Condition - Step 01: Open browser and admin Url");
	this.adminUrl = adminUrl;
	this.endUserUrl = endUserUrl;
	driver = getBrowserDriver(browserName, this.adminUrl);
	adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	
	adminUsername = "automationfc";
	adminPassword = "automationfc";
	
	log.info("Pre-Condition - Step 02: Enter to Username textbox with value: " + adminUsername);
	adminLoginPage.enterToUsernameTextbox(driver, adminUsername);
	
	log.info("Pre-Condition - Step 03: Enter to Password textbox" + adminPassword);
	adminLoginPage.enterToPasswordTextbox(driver, adminPassword);
	
	log.info("Pre-Condition - Step 04: Click to Login Button");
	adminDashboardPage = adminLoginPage.clickToLoginButton();
} 
  @Test
  public void Post_01_Create_New_Post() {
	  log.info("Create_Post - Step 01: Click to 'Posts' menu link");
	  adminPostSreachPage = adminDashboardPage.clickToPostMenuLink();
	 
	  log.info("Create_Post - Step 02: Get 'Sreach Post' page Url");
	  sreachPostUrl = adminPostSreachPage.getPageUrl(driver);
	  
	  log.info("Create_Post - Step 03: Click to 'Add new' button");
	  adminPostAddnewPage = adminPostSreachPage.clickToAddnewButton();
	  
	  log.info("Create_Post - Step 04: Enter to post title");
	  adminPostAddnewPage.enterToAddnewPostTitle(postTitle);
	  
	  log.info("Create_Post - Step 05: Enter to body");
	  adminPostAddnewPage.enterToAddnewPostBody(postBody);
	  
	  log.info("Create_Post - Step 06: Click to 'Publish' button");
	  adminPostAddnewPage.clickToPublishOrUpdateButton();
	  
//	  log.info("Create_Post - Step 07: Click to 'Pre Publish' button");
//	  adminPostAddnewPage.clickToPrePublishButton();
	  
	  log.info("Create_Post - Step 08: Verify 'Post Published' message is displayed");
	  verifyTrue(adminPostAddnewPage.isPostPublishMessageDisplayed("Post published."));
  }
  
  @Test
  public void Post_02_Sreach_Post() {
	  log.info("Sreach_Post - Step 01: Open 'Sreach Post' page");
	  adminPostSreachPage = adminPostAddnewPage.openSreachPostPageUrl(sreachPostUrl);
	  
	  log.info("Sreach_Post - Step 02: Enter to Sreach Textbox");
	  adminPostSreachPage.enterToSreachTextbox(postTitle);
	  
	  log.info("Sreach_Post - Step 03: Click to Sreach Posts button");
	  adminPostSreachPage.clickToSreachPostsTextbox();
	  
	  log.info("Sreach_Post - Step 04: Verify Sreach table contains '" + postTitle + "'");
	  verifyTrue(adminPostSreachPage.isPostSreachTableDisplayed("title", postTitle));
	  
	  log.info("Sreach_Post - Step 05: Verify Author table contains '" + authorName + "'");
	  verifyTrue(adminPostSreachPage.isPostSreachTableDisplayed("author", authorName));
	  
	  log.info("Sreach_Post - Step 06: Open End User site");
	  userHomePage = adminPostSreachPage.openEndUserSite(driver, this.endUserUrl);
	  
	  log.info("Sreach_Post - Step 07: Verify post infor displayed at Home page");
	  verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
	  verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postBody));
	  verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
	  verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));
	  
	  log.info("Sreach_Post - Step 08: Click to Post Title");
	  userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
	  
	  log.info("Sreach_Post - Step 09: Verify post infor displayed at Post detail page");
	  verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
	  verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postBody));
	  verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
	  verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));
	 
  }
  
  
  @Test
  public void Post_03_Edit_Post() {
	  log.info("Edit_Post - Step 01: Open Admin site");
	  adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);
	  
	  log.info("Edit_Post - Step 02: Click to 'Posts' menu link");
	  adminPostSreachPage = adminDashboardPage.clickToPostMenuLink();
	  
	  log.info("Edit_Post - Step 03: Enter to Sreach Textbox");
	  adminPostSreachPage.enterToSreachTextbox(postTitle);
	  
	  log.info("Edit_Post - Step 04: Click to Sreach Posts button");
	  adminPostSreachPage.clickToSreachPostsTextbox();
	  
	  log.info("Edit_Post - Step 05: Click to post title link and navigate to Edit post page");
	  adminPostAddnewPage = adminPostSreachPage.clickToPostTitleLink(postTitle);
	  
	  log.info("Edit_Post - Step 06: Enter to post title");
	  adminPostAddnewPage.enterToAddnewPostTitle(editPostTitle);
	  
	  log.info("Edit_Post - Step 07: Enter to body");
	  adminPostAddnewPage.enterToEditPostBody(editPostBody);
	  
	  log.info("Edit_Post - Step 08: Click to 'Publish' button");
	  adminPostAddnewPage.clickToPublishOrUpdateButton();
	 
	  log.info("Edit_Post - Step 09: Verify 'Post updated.' message is displayed");
	  verifyTrue(adminPostAddnewPage.isPostPublishMessageDisplayed("Post updated."));
	  
	  log.info("Edit_Post - Step 10: Open 'Sreach Post' page");
	  adminPostSreachPage = adminPostAddnewPage.openSreachPostPageUrl(sreachPostUrl);
	  
	  log.info("Edit_Post - Step 11: Enter to Sreach Textbox");
	  adminPostSreachPage.enterToSreachTextbox(editPostTitle);
	  
	  log.info("Edit_Post - Step 12: Click to Sreach Posts button");
	  adminPostSreachPage.clickToSreachPostsTextbox();
	  
	  log.info("Edit_Post - Step 13: Verify Sreach table contains '" + editPostTitle + "'");
	  verifyTrue(adminPostSreachPage.isPostSreachTableDisplayed("title", editPostTitle));
	  
	  log.info("Edit_Post - Step 14: Verify Author table contains '" + authorName + "'");
	  verifyTrue(adminPostSreachPage.isPostSreachTableDisplayed("author", authorName));
	  
	  log.info("Edit_Post - Step 15: Open End User site");
	  userHomePage = adminPostSreachPage.openEndUserSite(driver, this.endUserUrl);
	  
	  log.info("Edit_Post - Step 16: Verify post infor displayed at Home page");
	  verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(editPostTitle));
	  verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(editPostBody));
	  verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(editPostTitle, authorName));
	  verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(editPostTitle, currentDay));
	  
	  log.info("Sreach_Post - Step 17: Click to Post Title");
	  userPostDetailPage = userHomePage.clickToPostTitle(editPostTitle);
	  
	  log.info("Sreach_Post - Step 18: Verify post infor displayed at Post detail page");
	  verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editPostTitle));
	  verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editPostBody));
	  verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(editPostTitle, authorName));
	  verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDay(editPostTitle, currentDay));
	  
  }
  
  @Test
  public void Post_04_Delete_Post() {
	  log.info("Delete_Post - Step 01: Open Admin site");
	  adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);
	  
	  log.info("Delete_Post - Step 02: Click to 'Posts' menu link");
	  adminPostSreachPage = adminDashboardPage.clickToPostMenuLink();
	  
	  log.info("Delete_Post - Step 03: Enter to Sreach Textbox");
	  adminPostSreachPage.enterToSreachTextbox(editPostTitle);
	  
	  log.info("Delete_Post - Step 04: Click to Sreach Posts button");
	  adminPostSreachPage.clickToSreachPostsTextbox();
	  
	  log.info("Delete_Post - Step 05: Select Post detail checkbox");
	  adminPostSreachPage.selectPostCheckboxByTitle(editPostTitle);
	  
	  log.info("Delete_Post - Step 06: Select 'Move to trash' item in dropdown");
	  adminPostSreachPage.selectTextItemActionropdown("Move to Trash");
	  
	  log.info("Delete_Post - Step 07: Click to 'Apply' button");
	  adminPostSreachPage.clickToApplyButton();
	  
	  log.info("Delete_Post - Step 08: Verify '1 post moved to the Trash.' message is displayed");
	  verifyTrue(adminPostSreachPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));

	  log.info("Delete_Post - Step 09: Enter to Sreach Textbox");
	  adminPostSreachPage.enterToSreachTextbox(editPostTitle);
	  
	  log.info("Delete_Post - Step 10: Click to Sreach Posts button");
	  adminPostSreachPage.clickToSreachPostsTextbox();
	  
	  log.info("Delete_Post - Step 11: Verify 'No posts found.' message is displayed");
	  verifyTrue(adminPostSreachPage.isNoPostFoundMessageDisplayed("No posts found."));
	  
	  log.info("Delete_Post - Step 12: Open End User site");
	  userHomePage = adminPostSreachPage.openEndUserSite(driver, this.endUserUrl);
	  
	  log.info("Delete_Post - Step 13: Verify post title undisplayed at Home page");
	  verifyTrue(userHomePage.isPostInforUnDisplayedWithPostTitle(editPostTitle));
	 
	  log.info("Delete_Post - Step 14: Enter to Sreach Textbox");
	  userHomePage.enterToSreachTextbox(editPostTitle);
	  
	  log.info("Delete_Post - Step 15: Click to Sreach button");
	  userSreachPostPage = userHomePage.clickSreachButton();
	  
	  log.info("Delete_Post - Step 16: Verify 'Nothing Found' message is displayed");
	  verifyTrue(userSreachPostPage.isNothingFoundMessageDisplayed("Nothing Found"));
	  
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	 closeBrowserAndDriver();
  }


}



	

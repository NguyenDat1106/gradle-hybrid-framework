package commons;

import java.io.File;

public class GlobalConstants {
public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com";
public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com";

public static final String PROJECT_PATH = System.getProperty("user.dir");
public static final String OS_NAME = System.getProperty("os.name");
public static final String JAVA_VERSION = System.getProperty("java,version");
public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserLogs";
public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;
public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "extentV2" + File.separator;


public static final String DB_DEV_URL = "32.18.252.185:9860";
public static final String DB_DEV_USER = "automationfc";
public static final String DB_DEV_PASS = "P@ssw0rld1@";

public static final String DB_TEST_URL = "32.18.195.23:9860";
public static final String DB_TEST_USER = "automationfc";
public static final String DB_TEST_PASS = "P@ssw0rld1!";

public static final long SHORT_TIMEOUT = 5;
public static final long lONG_TIMEOUT = 30;
public static final long RETRY_TEST_FAILE = 3;

public static final String USER_LOGIN_DEV_URL_LIVEGURU = "http://live.techpanda.org/index.php/customer/account/login/";
public static final String ADMIN_DEV_URL_LIVEGURU = "http://live.techpanda.org/index.php/backendlogin/";
public static final String ADMIN_DEV_URL_LIVEGURU_MANAGE = "http:live.techpanda.org/index.php/backendlogin/customer/";




}

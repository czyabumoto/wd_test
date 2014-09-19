import scala.collection.JavaConversions._
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.{ By, WebElement }

object Test {

  def main(args: Array[String]) = {
    val url = "http://stg-agency.i-mobile.co.jp/login.aspx"
    request(url)
  }

  def request(url: String): Unit = {
    val driver = new HtmlUnitDriver()
    driver.get(url)
    scrape(driver)
  }

    private def scrape(driver: HtmlUnitDriver): Unit = {
      this putElement driver.findElementByXPath("//input[@id='__VIEWSTATE']")
      this putElement driver.findElementByXPath("//input[@id='__EVENTVALIDATION']")
    }

    private def putElement(we: WebElement) = println(s"${we.getAttribute("id")}: ${we.getAttribute("name")} -> ${we.getAttribute("value")}")
}


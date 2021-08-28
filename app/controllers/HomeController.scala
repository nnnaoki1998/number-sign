package controllers

import global.ResultSupport.RichResult
import javax.inject._
import play.api.db._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(dbApi: DBApi, val controllerComponents: ControllerComponents) extends BaseController{

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index(): Action[AnyContent] = Action {Ok(getFullList()).enableCors}
//  Request[AnyContent] =>
//    Ok(views.html.index())
//}

  def getFullList(): String = {
    val db = dbApi.database("default")
    val con = db.getConnection()
    try {
      val stmt = con.createStatement
      val rs = stmt.executeQuery("SELECT * FROM applicant")
      var a= ""
      while (rs.next) {
        val applicantName = rs.getString("applicant_name")
        a += applicantName
      }
      a
    } finally {
      con.close()
    }
  }
}

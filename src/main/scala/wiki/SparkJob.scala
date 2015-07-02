package wiki

/**
 * Created by erisa on 02/07/15.
 */

import com.typesafe.config.Config
import org.apache.spark.SparkContext

trait SparkJob extends spark.jobserver.SparkJob with spark.jobserver.NamedRddSupport with RddBuilder {
  val DOMAIN = "domain"
  val DATE = "date"
  //val END_DATE = "end.date"
  val S3_HOME_DIR = "s3n://wikipedia2015/pagecounts-"
  def validate(sc: SparkContext, config: Config): spark.jobserver.SparkJobValidation = spark.jobserver.SparkJobValid

  //format should be like: pagecounts-20150428-030000
  def getS3InputPath(date: String)= S3_HOME_DIR + date
}



object GetMostClickedPage extends SparkJob {

  override def runJob(sc: SparkContext, config: Config) = {
    val pageClicks = buildRdd(sc,config.getString(getS3InputPath(config.getString(DATE))))
    pageClicks.filter(rdd => rdd._1.equals(config.getString(DOMAIN)))
  }
}




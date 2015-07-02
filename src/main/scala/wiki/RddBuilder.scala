package wiki

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * Created by erisa on 02/07/15.
 */
trait RddBuilder {

  def buildRdd(sc: SparkContext, inputPath: String): RDD[(String, (String, Int))] = {
    sc.textFile(inputPath).
      map(line => {val recordList = line.split("/")
      val pageAndClicks = recordList(1).split(",")
      (recordList(0),(pageAndClicks(0), pageAndClicks(1).toInt))}
      )
  }
}

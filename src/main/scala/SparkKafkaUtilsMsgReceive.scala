import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.Duration
import org.apache.spark.{SparkConf}

/**
 * Created by Siori on 15/05/22.
 */
object SparkKafkaUtilsMsgReceive {
  def main(args: Array[String]): Unit = {

    // https://spark.apache.org/docs/latest/quick-start.html
    val conf = new SparkConf().setAppName("Spark Kafka Sample1")

    //https://spark.apache.org/docs/latest/submitting-applications.html#master-urls
    //http://www.ne.jp/asahi/hishidama/home/tech/scala/spark/SparkContext.html
    conf.setMaster("local[*]")

    // https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.streaming.kafka.KafkaUtils$
    val ssc = new StreamingContext(conf, Seconds(1))

    val topics = List(("test", 1)).toMap
    // Default Groupid
    // http://kafka.apache.org/07/configuration.html
    // https://spark.apache.org/docs/1.3.0/streaming-kafka-integration.html
    // OSX: home brew
    //      cat /usr/local/etc/kafka/consumer.properties
    //      group.id=test-consumer-group
    val topicLines = KafkaUtils.createStream(ssc, "localhost:2181", "test-consumer-group" ,topics)

    topicLines.print()

    ssc.start()

    ssc.awaitTermination()

  }
}
import java.util.Properties

import kafka.producer.{Producer, KeyedMessage, ProducerConfig}

/**
 * Created by AKB428 on 2015/06/05.
 *
 * ref: Learning Apache Kafka - Second Edition No.1794
 */
object KafkaSendMsg {

  def main(args: Array[String]): Unit = {


    val props = new Properties();

    props.put("metadata.broker.list","127.0.0.1:9092")
    props.put("serializer.class", "kafka.serializer.StringEncoder")
    props.put("request.required.acks", "1")

    val config = new ProducerConfig(props);

    val producer = new Producer[String,String](config)

    val topic = args(0)
    val message = args(1)


    val data = new KeyedMessage[String,String](topic,message)
    producer.send(data)

    producer.close()

  }

}

#SparkStreaming KafkaUtil Sample

## 事前準備 Kafkaのインストール

Kafka、zookeeperをインストールしtestという名前でtopicを作成する。

以下の記事を参照

Mac OSXにApache Kafkaをインストールして使えるようにするまで
http://qiita.com/AKB428/items/50d8c597c8c6e0f4fb1e

## メッセージ受信

### KafkaMsgReceive

test topicのメッセージを受信する

## メッセージ送信

### KafkaSendMsg

SparkStreamingのKafkaUtilはメッセージ受信機構しかないのでここではKafkaのネイティブクライアントであるJavaAPIをScalaで実行する

metadata.broker 127.0.0.1:9092に対してメッセージを送信

``run [topic] [msg]``

``run test 1:やはり俺の青春ラブコメはまちがっている。``

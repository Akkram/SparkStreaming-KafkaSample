name := "SparkKafkaSample"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.3.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.3.1"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.3.1"
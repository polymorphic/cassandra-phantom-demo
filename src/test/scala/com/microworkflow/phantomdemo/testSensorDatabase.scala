package com.microworkflow.phantomdemo

import com.microworkflow.phantomdemo.cassandra.{DatabaseProvider, SensorDatabase}
import com.websudos.phantom.connectors.ContactPoint

/**
  * Created by dam on 7/3/16.
  */
object TestSensorDatabase extends SensorDatabase(ContactPoint.embedded.keySpace("sensor_test"))

trait TestSensorDatabaseProvider extends DatabaseProvider {
  override def database = TestSensorDatabase

  implicit val session = database.session
  implicit val keyspace = database.space
}

package com.microworkflow.phantomdemo.cassandra

import com.websudos.phantom.connectors.KeySpaceDef
import com.websudos.phantom.dsl._

/**
  * Created by dam on 6/28/16.
  */
class SensorDatabase(override val connector: KeySpaceDef) extends Database(connector) {

  object sensorReadingTable extends ConcreteSensorReadingTable with connector.Connector
}

trait DatabaseProvider {

  def database: SensorDatabase

}

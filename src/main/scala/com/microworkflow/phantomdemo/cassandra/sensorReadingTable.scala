package com.microworkflow.phantomdemo.cassandra

import com.datastax.driver.core.Row
import com.microworkflow.phantomdemo.domain.SensorReading
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.connectors.RootConnector
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey

import scala.concurrent.Future

/**
  * Created by dam on 6/28/16.
  */
class SensorReadingTable extends CassandraTable[ConcreteSensorReadingTable, SensorReading] {

  // @formatter:off
  object id extends UUIDColumn(this) with PartitionKey[UUID]
  object timestamp extends LongColumn(this)
  object value extends DoubleColumn(this)
  // @formatter: on

  override def fromRow(r: Row): SensorReading =
  SensorReading(id(r), timestamp(r), value(r))
}

abstract class ConcreteSensorReadingTable extends SensorReadingTable with RootConnector {

  def store(reading: SensorReading):Future[ResultSet] =
    insert
      .value(_.id, reading.sensorId)
      .value(_.timestamp, reading.timestamp)
      .value(_.value, reading.value)
      .future()

  def getById(id: UUID): Future[Option[SensorReading]] =
    select.where(_.id eqs id).one()
}

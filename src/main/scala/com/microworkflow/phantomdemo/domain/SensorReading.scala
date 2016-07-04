package com.microworkflow.phantomdemo.domain

import java.util.UUID

/**
  * Created by dam on 6/28/16.
  */
case class SensorReading(sensorId: UUID, timestamp: Long, value: Double)

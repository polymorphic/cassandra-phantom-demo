package com.microworkflow.phantomdemo

import java.util.UUID

import com.microworkflow.phantomdemo.domain.SensorReading
import org.scalatest.FunSuite
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by dam on 7/3/16.
  */
class SensorDatabaseTest extends FunSuite with DatabaseTest {

  test("store/retrieve") {
    val id = UUID.randomUUID()
    val now = System.currentTimeMillis()
    val sensorReading = SensorReading(id, now, 42.0)

    val chain = for {
      store ← database.sensorReadingTable.store(sensorReading)
      retrieve ← database.sensorReadingTable.getById(id)
    } yield retrieve

    whenReady(chain) { stored ⇒
      stored shouldBe defined
      stored.value shouldEqual sensorReading
    }
  }

}

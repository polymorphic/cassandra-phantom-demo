package com.microworkflow.phantomdemo

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{BeforeAndAfterAll, Matchers, OptionValues, Suite}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
  * Created by dam on 7/3/16.
  */
trait DatabaseTest extends Suite
  with BeforeAndAfterAll
  with ScalaFutures
  with Matchers
  with OptionValues
  with TestSensorDatabaseProvider {

  override protected def beforeAll(): Unit = {
    super.beforeAll()
    Await.result(database.autocreate().future(), 5.seconds)
  }

  override protected def afterAll(): Unit = {
    super.afterAll()
    database.shutdown()
  }
}

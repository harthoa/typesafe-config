package com.hart

import com.typesafe.config.ConfigFactory

/**
  * Created at HART on 10/19/16.
  */
trait Configuration {
  val conf = ConfigFactory.load()

  val app = conf.getString("app")
  val world = conf.getString("world")
}

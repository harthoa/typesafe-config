package com.hart

import com.typesafe.config.ConfigFactory

/*
 *
 *
 * ConfigFactory.defaultApplication() vs ConfigFactory.defaultReference() vs ConfigFactory.defaultOverrides()
 *
 * ConfigFactory.load() - will load config in following order (first-listed are higher priority)
 *    System Properties
 *    application.conf (all resources on classpath with this name)
 *    application.json (all resources on classpath with this name)
 *    application.properties (all resources on classpath with this name)
 *    reference.conf (all resources on classpath with this name)
 *
 *    => application.conf can be REPLACED by using System Properties "config.resource", "config.file" or "config.url". Note:
 *    These System Properties specify a replacement for application.{conf,json,properties}, not addition. But we could use i
 *    include "application" to include the original default config file;
 *
 * ConfigFactory.laod("myconf") - sandwiches it between *default reference config* and *default overrides*, and then resolves it.
 *  Will load config in following order (first-listed are higher priority)
 *    System Properties
 *    myconf.conf (all resources on classpath with this name)
 *    reference.conf (all resources on classpath with this name)
 */
object Main extends App with Loggable {
  logger.info("Hello World")

  val config = ConfigFactory.load()
//  val config = ConfigFactory.load("myconf")

  val testProp = config.getInt("test")
  val helloProp = config.getString("hello")
  val appProp = config.getString("app")
  val hiProp = config.getString("hi")
  val superhiProp = config.getString("superhi")

  val mdrLegacySelectedDB = config.getInt("mdr.legacy.selected_db")
  val mdrLegacySelectedDBConfig = mdrLegacySelectedDB match {
    case 1 => "mdr.legacy_stjude.db_name"
    case 2 => "mdr.legacy_mission.db_name"
  }

  val mdrLegacyDBNameConfig = config.getString("mdr.legacy.db_name")
  val mdrLegacyMissionDBNameConfig = config.getString("mdr.legacy_mission.db_name")
  val mdrLegacySelectedDBName = config.getString(mdrLegacySelectedDBConfig)

  val region = config.getString("region")
  val dataSource = config.getString("data_source")

  val dataType = ConfigurationSpecific.dataType

  logger.info("testProp = {}", testProp)
  logger.info("helloProp = {}", helloProp)
  logger.info("appProp = {}", appProp)
  logger.info("hiProp = {}", hiProp)
  logger.info("superhiProp = {}", superhiProp)

  logger.info("mdrLegacyDBName = {}", mdrLegacyDBNameConfig)
  logger.info("mdrLegacyStJudeDBName = {}", mdrLegacyMissionDBNameConfig)
  logger.info("mdrLegacySelectedDBName = {}", mdrLegacySelectedDBName)

  logger.info("region = {}", region)
  logger.info("dataSource = {}", dataSource)
  logger.info("dataType = {}", dataType)
}
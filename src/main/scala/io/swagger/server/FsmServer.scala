package io.swagger.server

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import io.swagger.server.api.{DefaultApi, DefaultApiService}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._

import scala.io.StdIn
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.LoggerOps
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}

object FsmServer {
  def main() = {
    implicit val system = ActorSystem("default")
    val controller = new Controller(new DefaultApi((entityId: Int) => {
      println(entityId)
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "Test"))
    }))
  }
}

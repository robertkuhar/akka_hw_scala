package com.example.scala

import akka.actor.Actor
import akka.actor.actorRef2Scala

object Greeter {
  case object Greet
  case object Done
}

class Greeter extends Actor {
  def receive = {
    case Greeter.Greet =>
      println("Hello, world")
      sender ! Greeter.Done
  }
}

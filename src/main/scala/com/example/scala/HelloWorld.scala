package com.example.scala

import akka.actor.Actor
import akka.actor.Props
import akka.actor.actorRef2Scala

class HelloWorld extends Actor {

  override def preStart(): Unit = {
    // create the greeter actor
    val greeter = context.actorOf(Props[Greeter], "greeter")
    greeter ! Greeter.Greet
  }

  def receive = {
    // when the greeter is done, stop this actor and, with it, the application
    case Greeter.Done => context.stop(self)
  }
}
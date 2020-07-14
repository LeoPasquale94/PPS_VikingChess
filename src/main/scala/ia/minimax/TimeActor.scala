package ia.minimax

import java.util.concurrent.TimeUnit

import akka.actor.Actor

import scala.concurrent.duration.FiniteDuration


case class StartMsg()

case class TimeActor() extends Actor {
  import context._

  val delayTime: FiniteDuration = FiniteDuration(1000, TimeUnit.MILLISECONDS)

  override def receive: Receive = {
    case _: StartMsg =>  context.system.scheduler.scheduleOnce(delayTime, context.sender(), EndTimeMsg())

    }




}
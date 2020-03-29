package com.bt.tenpinbowling

import scala.util.Try

object Main extends App {

  import Bowling._

  val ballThrows = args.toList.map(i => Try(i.toInt).toOption).flatten

  lazy val frames = ballThrows.foldLeft(initial){
    case (state, pins) => throwBall(pins, state)
  }

  lazy val scores = score(frames)

  println(display(scores))

}

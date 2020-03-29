package com.bt.tenpinbowling

object Bowling {

  type Throw = Int
  type Frame = List[Int]
  type Game = List[List[Int]]
  type State = (Frame,Game)

  val initial: State = (Nil, Nil)
  case class BowlingFrame(frameLength: Int, frameLastElem: Int, frameTailSum: Int, frameTotalSum: Int)

  def throwBall(pins: Throw, state: State): State = {
    val curFrame: Frame = state._1
    val curGame: Game = state._2

    val newFrame = pins :: curFrame
    val newFrameSpecs = BowlingFrame(newFrame.length, newFrame.last, newFrame.tail.sum, newFrame.sum)

    newFrameSpecs match {
      case BowlingFrame(2, x, y, z) if(z<10) => (Nil, newFrame :: curGame) // Normal (when Framelength=2)
      case BowlingFrame(3, x, y, z) if(y<10) => (newFrame.head :: Nil, newFrame.tail :: curGame) // Normal (when Framelength=3)
      case BowlingFrame(3, 10, x, y) => (newFrame.init, newFrame :: curGame) // condition "Strike"
      case BowlingFrame(3, x, 10, y) => (newFrame.head::Nil, newFrame :: curGame) // condition "Spare"
      case _ => (newFrame, curGame)
    }
  }

  def score(state: State): List[(Int, List[Int])] =
    (state._2).map(frameScore(_))

  def frameScore(frame: Frame): (Int, Frame) =
    (frame.sum, frame)

  def display(scores: List[(Int, List[Int])]): String =
    "Frame Count => "+ scores.length + "\nList of Frames on this Game => " + scores.map(_._2).mkString("; ") + "\nScore on this game => " + scores.map(_._1).sum
}

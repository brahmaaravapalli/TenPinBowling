type Throw = Int
type Frame = List[Int]
type Game = List[List[Int]]
type State = (Frame,Game)

val initial: State = (Nil, Nil)

def throwBall(pins: Throw, state: State): State = {
  println()
  println("loop Started ...")

  val curFrame: Frame = state._1
  val curGame: Game = state._2
  println("curFrame: " + curFrame)
  println("curGame: " + curGame)

  val newFrame = pins :: curFrame
  println("newFrame => " + newFrame)

  var newFrames = scala.collection.mutable.ListBuffer.empty[List[Int]]
  //    if (curFrame.isEmpty) newFrames += newFrame
  //    if (curFrame.length == 1) newFrames += newFrame
  println("newFrames =>" + newFrames)

  var carryForward: Frame = Nil


  def _throwable(pins: Int, newFrame: List(List

  [Int
  ] ) ): newFrames[List[List[Int]]] = (newFrame.length, newFrame) match {

    case (3, newFrame.last == 10) => println("Strike Condition Triggered ...")
      newFrames += newFrame
      carryForward = newFrame.init
      println("newFrames => " + newFrames)

    case (3, newFrame.tail.sum == 10) => println("Spare Condition Triggered ...")
      newFrames += newFrame
      carryForward = newFrame.head :: Nil
      println("newFrames => " + newFrames)

    case (3, newFrame.tail.sum < 10) => println("Normal Condition when length=3 Triggered ...")
      newFrames += newFrame.tail
      carryForward = newFrame.head :: Nil
      println("newFrames => " + newFrames)

    case (2 & newFrame.sum < 10) => println("Normal Condition when length=2 Triggered ...")
      newFrames += newFrame
      println("newFrames => " + newFrames)

    case _ => Nil

  }
}


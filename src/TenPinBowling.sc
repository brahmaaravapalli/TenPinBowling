/*
val x = List(1.0, 2.0)
val y = List(20.0, 30.0)

println("addition of list x + y = " + (x, y).zipped.map(_ - _));
*/

//List(1,1,2,2,3,3,4,4,5,5,0,1,0,2,0,3,0,4,0,5,0).sliding(3,1).foldLeft(0)(_ + _.sum)

/*

def score_game(g:List[Int]):Int = {
  framescores(g).foldLeft(0)(_+_)
}

def framescores(game:List[Int]):List[Int] = {
  frames_for(game).take(10).map(l => l.foldLeft(0)(_+_))
}

def framesThrown(g:List[Int]) = {
  frames(g).length
}


var newFrames = scala.collection.mutable.ListBuffer.empty[List[Int]]

println("newFrames =>" + newFrames)

List(1,2,3).length

*/


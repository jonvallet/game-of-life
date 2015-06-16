package com.jonvallet.scala.life

/**
 * @author Jon Vallet
 */

trait State {
  def toInt(): Int
}
case object Alive extends State {
  override def toInt(): Int = 1
}
case object Dead extends State {
  override def toInt(): Int = 0
}

object Life {


  type Game = List[List[Int]]
  type Position = (Int, Int)

  def getState(n: Int): State = n match {
    case 0 => Dead
    case 1 => Alive
  }

  def generate(rows: Int, cols: Int): Game = {
    def random = math.random * 10 toInt

    List.fill(rows,cols)(if (random % 5 == 0) 1 else 0)
  }

  def neighbours(game: Game, cell: Position): Int = {
    val aSubMatrix = subMatrix(game, cell)
    val total = aSubMatrix.flatMap(x => x).sum - game(cell._1)(cell._2)
    total
  }

  def subMatrix(game: Life.Game, cell: Life.Position) = {
    val firstSlice = game.slice(cell._1-1, cell._1+2)
    firstSlice.map(list => list.slice(cell._2-1, cell._2+2))
  }

  def show (game: Game) = {
    for (row <- game) println(row map { case 1 => "█" case 0 => "░" } mkString (" "))
    println
  }

  def nextGeneration(game: Game): Game = {
    for {
      (row, i) <- game.zipWithIndex
    } yield row.zipWithIndex.map(elem => nextState(getState(elem._1), neighbours(game,(i,elem._2)))).map(state => state.toInt())
  }

  def nextState(initialState: State, neighbours: Int): State = (initialState, neighbours) match {
    case (Dead,3) => Alive
    case (Alive, 0) => Dead
    case (Alive, 1) => Dead
    case (Alive, 2) => Alive
    case (Alive, 3) => Alive
    case _ => Dead
  }

  def gameOfLife(initial: Game): Stream[Game] = initial #:: gameOfLife(nextGeneration(initial))


}

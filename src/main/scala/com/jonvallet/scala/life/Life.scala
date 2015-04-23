package com.jonvallet.scala.life

/**
 * @author Jon Vallet
 */
object Life {

  type Game = List[List[Int]]
  type Position = (Int, Int)


  def generate(rows: Int, cols: Int): Game = {
    def random = math.random * 10 toInt

    List.fill(10,10)(if (random % 5 == 0) 1 else 0)
  }

  def neighbours(game: Game, cell: Position): Int = {
    val subMatrix = game slice(cell._1-1, cell._1+2)
    val total = (subMatrix map(_ sum)).sum - subMatrix(cell._1)(cell._2)
    total
  }



  def show(game: Game): Unit = {
    for (row <- game) println(row map { case 1 => "█" case 0 => "░" } mkString (" "))
  }

}

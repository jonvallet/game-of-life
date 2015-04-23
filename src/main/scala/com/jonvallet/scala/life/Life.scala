package com.jonvallet.scala.life

/**
 * @author Jon Vallet
 */
object Life {

  def generate(rows: Int, cols: Int): List[List[Boolean]] = {
    def random = math.random * 10 toInt

    List.fill(10,10)(random % 5 == 0)
  }




  def show(game: List[List[Boolean]]): Unit = {
    for (row <- game) println(row map { case true => "█" case false => "░" } mkString (" "))
  }

}

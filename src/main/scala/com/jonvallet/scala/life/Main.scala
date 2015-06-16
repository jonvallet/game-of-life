package com.jonvallet.scala.life

import com.jonvallet.scala.life.Life._

/**
 * Created by jon on 16/06/15.
 */
object Main {
  def main(args: Array[String]): Unit = {
    val gameStream = gameOfLife(generate(100, 100))

    for (game <- gameStream) {
      show(game)
      Thread.sleep(100L)
    }

  }

}

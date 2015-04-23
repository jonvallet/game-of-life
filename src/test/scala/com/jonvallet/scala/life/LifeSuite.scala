package com.jonvallet.scala.life

import org.scalatest.{Matchers, FlatSpec}

/**
 * @author Jon Vallet
 */
class LifeSuite extends FlatSpec with Matchers {

  "Life.nighbours(List(List(0,0,0),List(0,1,0),List(0,0,0), (1,1)" should "return 0" in {
    val game = List(List(0,0,0),List(0,1,0),List(0,0,0))
    Life.neighbours(game, (1,1)) should be (0)
  }

  "Life.nighbours(List(List(0,1,0),List(0,1,0),List(0,1,0), (1,1)" should "return 2" in {
    val game = List(List(0,1,0),List(0,1,0),List(0,1,0))
    Life.neighbours(game, (1,1)) should be (2)
  }

  "Life.nighbours(List(List(0,1,0),List(0,1,0),List(0,1,0), (0,0)" should "return 2" in {
    val game = List(List(0,1,0),List(0,1,0),List(0,1,0))
    Life.neighbours(game, (0,0)) should be (2)
  }

}

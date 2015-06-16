package com.jonvallet.scala.life

import org.scalatest.{Matchers, FlatSpec}

/**
 * @author Jon Vallet
 */
class LifeSuite extends FlatSpec with Matchers {

  val example = List(List(0, 1, 0, 0, 0, 1, 0, 0, 0, 0), List(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), List(0, 0, 0, 0, 0, 0, 0, 1, 0, 0), List(1, 0, 0, 0, 0, 0, 1, 0, 0, 0), List(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), List(0, 0, 0, 0, 0, 0, 0, 1, 0, 0), List(0, 0, 1, 1, 0, 0, 0, 0, 0, 0), List(0, 1, 0, 0, 1, 0, 1, 0, 0, 0), List(1, 0, 1, 0, 0, 0, 0, 0, 0, 0), List(0, 0, 0, 1, 0, 0, 0, 0, 0, 0))


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

  "Life.nighbours(example, (0,0)" should "return 1" in {
    Life.neighbours(example, (0,0)) should be (1)
  }

  "Life.nextState(Dead, 0)" should "return Dead" in {
    Life.nextState(Dead, 0) should be (Dead)
  }

  "Life.nextState(Alive, 1)" should "return Dead" in {
    Life.nextState(Alive, 1) should be (Dead)
  }

  "Life.nextState(Alive, 2)" should "return Alive" in {
    Life.nextState(Alive, 2) should be (Alive)
  }

  "Life.nextState(Alive, 3)" should "return Alive" in {
    Life.nextState(Alive, 3) should be (Alive)
  }

  "Life.nextState(Alive, 4)" should "return Alive" in {
    Life.nextState(Alive, 4) should be (Dead)
  }

  "Life.nextState(Dead, 3)" should "return Alive" in {
    Life.nextState(Dead, 3) should be (Alive)
  }

  "Life.nextGeneration(List(List(0,1,0),List(0,1,0),List(0,1,0))" should "retunr List(List(0,0,0),List(1,1,1),List(0,0,0))" in {
    Life.nextGeneration(List(List(0,1,0),List(0,1,0),List(0,1,0))) should be (List(List(0,0,0),List(1,1,1),List(0,0,0)))
  }

}

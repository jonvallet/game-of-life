package com.jonvallet.scala.life

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.Timer

import scala.swing._
import scala.swing.event.ButtonClicked
import com.jonvallet.scala.life.Life._

object GameOfLifeSwing extends SimpleSwingApplication {

  val gameWindow = new TextArea
  var gameIterator = gameOfLife(generate(50, 100)).iterator

  def top = new MainFrame {

    val taskPerformer = new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = gameWindow.text = getString(gameIterator.next)
    }
    val timer = new Timer(100, taskPerformer)
    title = "My Frame"
    location = new Point(50, 50)
    contents = new BoxPanel(Orientation.Vertical) {
      gameWindow.text = getString(gameIterator.next)
      contents += gameWindow
      contents += new Button {
        text = "Start Game!"
        reactions += {
          case ButtonClicked(_) => timer.start
        }
      }
      contents += new Button {
        text = "Stop Game"
        reactions += {
          case ButtonClicked(_) => timer.stop
        }
      }
      contents += new Button {
        text = "Restart Game"
        reactions += {
          case ButtonClicked(_) => {
            timer.stop
            gameIterator = gameOfLife(generate(50, 100)).iterator
            gameWindow.text = getString(gameIterator.next)
          }
        }
      }
    }
    pack
  }
}

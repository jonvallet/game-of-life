import com.jonvallet.scala.life.Life._
import com.jonvallet.scala.life.Life

val game2 = List(List(0,0,0),List(1,1,1),List(0,1,0))
val cell = (1,1)
val subMatrix = game2 slice(cell._1-1, cell._1+2)
val total = (subMatrix map(_ sum)).sum - subMatrix(cell._1)(cell._2)
Life.show(game2)
List(1,2,3).sum

subMatrix(1)(1)
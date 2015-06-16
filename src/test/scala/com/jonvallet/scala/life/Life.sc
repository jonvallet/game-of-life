import com.jonvallet.scala.life.Life._

def gameOfLife(initial: Game): Stream[Game] = initial #:: gameOfLife(nextGeneration(initial))



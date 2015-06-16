import com.jonvallet.scala.life.Life._

def gameOfLife(initial: Game): Stream[Game] = initial #:: gameOfLife(nextGeneration(initial))

val initialGame = generate(10,10)

getString(initialGame)
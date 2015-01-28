//MasterMind.scala
/**
 * Created by Marcin on 2015-01-28.
 */
import scala.util.control.Breaks._

class MasterMind {

  var secretCode = new Array[Int](4)
  //var currentRow : Int = 0
  var right : Int = 0
  var misplaced : Int = 0

  def randomize(): Int = {
    var r = new scala.util.Random
    var rand = r.nextInt(6)
    println(rand)
    rand
  }

  def newGame() = {
    //currentRow = 0
    for (i <- 0 to 3) {
      secretCode(i) = randomize()
    }

    var Testnumbers = Array(1,0,2,3)

    check(Testnumbers)
  }

  //  def win() = {
  //    won = true
  //    println("You won!!!")
  //  }

  def check(numbers: Array[Int]): Array[Int] ={
    right = 0
    misplaced = 0
    var alreadyProcessed = List[Int]()
    for (i <- 0 to 3){
      if(secretCode(i)==numbers(i)) right+=1
    }
    for (color : Int <- secretCode){
      breakable {
        for (j <- 0 to 3) {
          if (color == numbers(j) && !alreadyProcessed.contains(j)) {
            alreadyProcessed = alreadyProcessed.::(j)
            misplaced += 1
            break()
          }
        }
      }

    }
    misplaced-=right
    println("right: "+right)
    println("misplaced: " + misplaced)
    val result =  new Array[Int](2)
    result(0) = right
    result(1) = misplaced
    result
  }

}



///Init.scala

object Init{
  def main(args: Array[String]) {
    val gra = new MasterMind()
    gra.newGame()
  }
}


/**
 * Created by Marcin on 2015-01-28.
 */
class MasterMind {

    var secretCode = new Array[Int](4)
    // var currentRow : Int

    def randomize(): Int = {
      var r = new scala.util.Random
      var rand = r.nextInt(6)
      println(rand)
      rand
    }

    def newGame(): Unit = {
      for (i <- 0 to 3) {
        secretCode(i) = randomize()
      }
    }
}

package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c == 0 || c == r) {
      1
    }
    else {
      val upperLeft = pascal(c-1, r-1)
      val upperRight = pascal(c, r-1)
      upperLeft + upperRight
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    balanceRecursively(0, chars) == 0
  }
  
  /*
   * Keeps track of the "level", which is the deepness of the nested brackets.
   * Aborts as soon as the level negative.
   */
  def balanceRecursively(bracketLevel: Int, chars: List[Char]) : Int = {
    if(chars.isEmpty) {
      return bracketLevel
    }

    val head = chars.head
    val newLevel: Int = head match {
      case '(' => bracketLevel + 1
      case ')' => bracketLevel - 1
      case _   => bracketLevel
    }

    if(newLevel < 0) {
      return newLevel
    }
    else {
        balanceRecursively(newLevel, chars.tail)
    }
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}

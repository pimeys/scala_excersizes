import scala.collection.mutable.HashMap

def encode(chars: List[Symbol]): List[(Int, Symbol)] = {
  def encode(chars: List[Symbol], result: List[(Int, Symbol)], counter: (Int, Symbol)): List[(Int, Symbol)] = chars match {
    case Nil => result
    case x :: Nil =>
      if (counter._2 == x)
        result ::: List((counter._1 + 1, x))
      else
        result ::: List(counter) ::: List((1, x))
    case x :: xs =>
      if (counter._2 == x) {
        encode(xs, result, (counter._1 + 1, x))
      }
      else {
        encode(xs, result ::: List(counter), (1, x))
      }
  }

  encode(chars, List(), (0, 'a))
}

Console.println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e, 'f)))

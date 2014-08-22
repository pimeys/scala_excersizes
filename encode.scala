import scala.collection.mutable.HashMap

def encode(chars: List[Symbol]): List[(Int, Symbol)] = {
  def encode(chars: List[Symbol], counts: List[(Int, Symbol)]): List[(Int, Symbpl)] = chars match {
    case Nil => chars
    case x :: Nil => chars
    case x :: xs =>
      counts match {
        case Nil => encode(xs, List((1, x)))
        case counter :: Nil =>
          if (counter._2 == x)
            encode(xs, List((counter._1 + 1, x)))
          else
            encode(xs, counter :: List((1, x)))
        case first :: counters :: last =>
          if (last._2 == x)
            encode(xs, first ::: counters ::: List((last._1 + 1, x)))
          else
            encode(xs, first ::: counters ::: last ::: List((1, x)))
      }

  }

  encode(chars, Nil)
}

Console.println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

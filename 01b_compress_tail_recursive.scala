def compress(chars: List[Symbol]): List[Symbol] = {
  def compress(chars: List[Symbol], result: List[Symbol], lastChar: Symbol, start: Boolean): List[Symbol] = {
    chars match {
      case Nil => result
      case x :: xs =>
        if (!start && x == lastChar)
          compress(xs, result, x, false)
        else
          compress(xs, result ::: List(x), x, false)
    }
  }

  compress(chars, Nil, null, true)
}

Console.println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

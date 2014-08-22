def compress(chars: List[Symbol]): List[Symbol] = chars match {
  case Nil => chars
  case x :: Nil => chars
  case x :: xs =>
    if (x == xs.head) compress(xs)
    else x :: compress(xs)
}

Console.println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

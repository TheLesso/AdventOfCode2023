import scala.collection.mutable.ArrayBuffer
@main def run = {
//Make list with extra spacing around of .
  import scala.io.Source.fromFile
  val length = fromFile("input.txt").getLines().toVector.head.length()
  var x = Vector() ++ (for (lines <- fromFile("input.txt").getLines())
    yield (lines.appended('.').prepended('.').toVector))
  x = x.appended(Vector.fill(length)('.'))
  x = x.prepended(Vector.fill(length)('.'))
  println(partTwo(x))
}

def partOne(input: Vector[Vector[Char]]): Int = {
  var sum = 0
  var digit = ""
  var symbol = false
  for (i <- 0 until input.length) {
    for (j <- 0 until input(i).length) {
      if (input(i)(j).isDigit) {
        digit += input(i)(j)
        if (!symbol) {
          symbol = checkAroundIf(input, i, j)
        }
      } else {
        if (symbol) {
          println(digit)
          sum += digit.toInt
          symbol = false
        }
        digit = ""
      }
    }
  }
  sum
}

def partTwo(input: Vector[Vector[Char]]): Int = {
  var map = collection.mutable.Map.empty[(Int,Int),Vector[Int]]
  var digit = ""
  var symbol = false
  var coordinates = (0,0)
  for (i <- 0 until input.length) {
    for (j <- 0 until input(i).length) {
      if (input(i)(j).isDigit) {
        digit += input(i)(j)
        if (!symbol) {
          symbol = checkAroundIf(input, i, j)
          coordinates = checkAroundIndex(input,i,j)
        }
      } else {
        if (symbol) {
          if(map.contains(coordinates)) {
            map(coordinates) = map(coordinates).appended(digit.toInt)
          } else {
            map += (coordinates -> Vector(digit.toInt))
          }
          symbol = false
        }
        digit = ""
      }
    }
  }
  map.filter(x => x(1).length == 2).map(x => x(1)(0) * x(1)(1)).sum
}

def checkAroundIf(input: Vector[Vector[Char]], x: Int, y: Int): Boolean = {
  var result = false
  for (i <- x - 1 to x + 1) {
    for (j <- y - 1 to y + 1) {
      if (!result) {
        result = input(i)(j).toString.matches("[^\\d.\\n]")
      }
    }
  }
  result
}

def checkAroundIndex(input: Vector[Vector[Char]], x: Int, y: Int): (Int,Int) = {
  var result = (0,0)
  var hasReturned = false
  for (i <- x - 1 to x + 1) {
    for (j <- y - 1 to y + 1) {
      if (!hasReturned && input(i)(j).toString.matches("[^\\d.\\n]")) {
        hasReturned = true
        result = (i,j)
        
      }
    }
  }
  result
}


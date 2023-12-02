@main def run = {
  import scala.io.Source.fromFile
  var sum = 0
  for (line <- scala.io.Source.fromFile("input.txt").getLines()) {
   sum += gameCheckTwo(line)
  }
  println(sum)
}

def gameCheckTwo(input:String) = {
  var maxRed = 0
  var maxBlue = 0
  var maxGreen = 0
  val newInput = input.drop(8)
  val matches = "(\\d{1,} red|(\\d{1,} green)|\\d{1,} blue)".r.findAllIn(newInput)
  while (matches.nonEmpty) {
    val x = matches.next()
    var amount = "\\d{1,}".r.findFirstIn(x).get.toInt
    x.drop(amount.toString().length()+1) match {
      case "blue" if(amount > maxBlue) => maxBlue = amount;
      case "red" if(amount > maxRed) => maxRed = amount;
      case "green" if(amount > maxGreen) => maxGreen = amount;
      case _ =>
    }
  }
  maxRed * maxGreen * maxBlue
}


def gameCheckOne(input:String) = {
  val maxRed = 12
  val maxBlue = 14
  val maxGreen = 13
  var success = true
  val gameNumber = "\\d{1,}".r.findFirstIn(input)
  val newInput = input.drop(8)
  val matches = "(\\d{1,} red|(\\d{1,} green)|\\d{1,} blue)".r.findAllIn(newInput)
  while (matches.nonEmpty && success) {
    val x = matches.next()
    var amount = "\\d{1,}".r.findFirstIn(x).get.toInt
    x.drop(amount.toString().length()+1) match {
      case "blue" if(amount > maxBlue) => success = false
      case "red" if(amount > maxRed) => success = false
      case "green" if(amount > maxGreen) => success = false
      case _ =>
    }
  }
  if(success) {
    gameNumber.get.toInt
  } else {
    0
  }
}
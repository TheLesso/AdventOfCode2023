package day1

@main def run = {
  import scala.io.Source.fromFile
  var sum = 0
  for (line <- scala.io.Source.fromFile("input.txt").getLines()) {
    sum += part2(line).toInt
  }
  println(sum)
}

def partOne = {
  import scala.io.Source.fromFile
  var sum = 0
  for (line <- scala.io.Source.fromFile("input.txt").getLines()) {
    val numbers = "[0-9]{1}".r.findAllIn(line).toSeq
      sum += (numbers.head + numbers.head).toInt
  }
  print(sum)
}

def wordsToNumber(word: String): String = {
  word match
    case "zero"  => "0"
    case "one"   => "1"
    case "two"   => "2"
    case "three" => "3"
    case "four"  => "4"
    case "five"  => "5"
    case "six"   => "6"
    case "seven" => "7"
    case "eight" => "8"
    case "nine"  => "9"
    case _ => word
}

def partTwo = {
  import scala.io.Source.fromFile
  var sum = 0
  for (line <- scala.io.Source.fromFile("input.txt").getLines()) {
    val first = wordsToNumber(("one|two|three|four|five|six|seven|eight|nine|\\d").r.findFirstIn(line).get)
    val last = wordsToNumber(("one|two|three|four|five|six|seven|eight|nine".reverse + "|\\d").r.findFirstIn(line.reverse).get.reverse)
    sum += (first + last).toInt
  }
  println(sum)
}

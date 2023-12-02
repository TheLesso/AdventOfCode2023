file://<WORKSPACE>/Main.scala
### java.lang.IllegalArgumentException: Comparison method violates its general contract!

occurred in the presentation compiler.

action parameters:
offset: 537
uri: file://<WORKSPACE>/Main.scala
text:
```scala
@main def run = {
  import scala.io.Source.fromFile
  var sum = 0
  for (line <- scala.io.Source.fromFile("input.txt").getLines()) {
   sum += gameCheck(line)
  }
  println(sum)
}



def gameCheck(input:String) = {
  val maxRed = 12
  val maxBlue = 14
  val maxGreen = 13
  var success = true
  val gameNumber = "\\d{1,}".r.findFirstIn(input)
  val newInput = input.drop(8)
  val matches = "(\\d{1,} red|(\\d{1,} green)|\\d{1,} blue)".r.findAllIn(newInput)
  while (matches.nonEmpty && success) {
    val x = matches.next()
    println(x@@)
    var amount = "\\d{1,}".r.findFirstIn(x).get.toInt
    x.drop(2) match {
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

```



#### Error stacktrace:

```
java.util.TimSort.mergeLo(TimSort.java:777)
	java.util.TimSort.mergeAt(TimSort.java:514)
	java.util.TimSort.mergeCollapse(TimSort.java:441)
	java.util.TimSort.sort(TimSort.java:245)
	java.util.Arrays.sort(Arrays.java:1438)
	scala.collection.SeqOps.sorted(Seq.scala:727)
	scala.collection.SeqOps.sorted$(Seq.scala:719)
	scala.collection.immutable.List.scala$collection$immutable$StrictOptimizedSeqOps$$super$sorted(List.scala:79)
	scala.collection.immutable.StrictOptimizedSeqOps.sorted(StrictOptimizedSeqOps.scala:78)
	scala.collection.immutable.StrictOptimizedSeqOps.sorted$(StrictOptimizedSeqOps.scala:78)
	scala.collection.immutable.List.sorted(List.scala:79)
	scala.meta.internal.pc.completions.Completions.completions(Completions.scala:210)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:86)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:123)
```
#### Short summary: 

java.lang.IllegalArgumentException: Comparison method violates its general contract!
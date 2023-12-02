file://<WORKSPACE>/Main.scala
### java.lang.AssertionError: NoDenotation.owner

occurred in the presentation compiler.

action parameters:
offset: 579
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
  var success = false
  val gameNumber = "\\d{1,}".r.findFirstIn(input)
  val newInput = input.drop(8)
  val matches = "(\\d{1,} red|(\\d{1,} green)|\\d{1,} blue)".r.findAllIn(newInput)
  matches.foreach(x => {
    val amount = "\\d{1,}".r.findFirstIn(x).get.toInt
    x.drop(2) match
      case "blue" ifam@@ <= maxBlue) => success = true 
      case "red" if(x(0).toInt <= maxRed) => success = true
      case "green" if(x(0).toInt <= maxGreen) => success = true
      case _ => 
  })
  if(success) {
    gameNumber.get.toInt
  } else {
    0
  }
}

```



#### Error stacktrace:

```
dotty.tools.dotc.core.SymDenotations$NoDenotation$.owner(SymDenotations.scala:2576)
	scala.meta.internal.pc.SignatureHelpProvider$.isValid(SignatureHelpProvider.scala:83)
	scala.meta.internal.pc.SignatureHelpProvider$.notCurrentApply(SignatureHelpProvider.scala:92)
	scala.meta.internal.pc.SignatureHelpProvider$.$anonfun$1(SignatureHelpProvider.scala:48)
	scala.collection.StrictOptimizedLinearSeqOps.loop$3(LinearSeq.scala:280)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile(LinearSeq.scala:282)
	scala.collection.StrictOptimizedLinearSeqOps.dropWhile$(LinearSeq.scala:278)
	scala.collection.immutable.List.dropWhile(List.scala:79)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:48)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:375)
```
#### Short summary: 

java.lang.AssertionError: NoDenotation.owner
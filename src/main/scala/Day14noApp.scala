//so application without extends

object Day14noApp {
  //so turns out we do not have to use extend App
  //so for application to run you need to define a main
  var myResult = 100

  //Java style exception catcher
  //https://alvinalexander.com/scala/how-cast-string-to-int-in-scala-string-int-conversion/
  def toInt(s: String): Int = {
    try {
      s.toInt //so if this fails we catch the exception
    } catch {
      case e: Exception => 0
    }
  }

  def toDouble(s: String): Double = {
    try {
      s.toDouble //so if this fails we catch the exception
    } catch {
      case e: Exception => 0
    }
  }

  def main(args:Array[String]) = {
    println("Starting main function")
    for (arg <- args) {
      //all arguments are strings we can cast them to something else if we want
      println(s"Going to do something with argument: $arg its type is ${arg.getClass}")
    }
    myResult += args(1).toInt //well we expect 2nd argument to be an integers
    println(myResult)
    myResult += toInt(args(0)) //so using my own toInt method on "Valdis"
    println(myResult)
    myResult += toDouble(args(2)).toInt //so using my own toInt method on 3.145926
    println(myResult) //so 145 because int from 3.1415926 is 3, the whole part
    println("All done")
  }
}

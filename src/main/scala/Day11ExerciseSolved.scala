object Day11ExerciseSolved extends App {
  //def means we define a function, we do not use it here
  //just like println or readLine or other functions
  //we say this function takes two strings
  def isPangram(text:String, alpha:String="abcdefghijklmnopqrstuvwxyz"):Boolean = {
    val charSet = text.toLowerCase.toSet
    val alphaSet = alpha.toSet //when compiling your program these internal values will be optimized away
    alphaSet.subsetOf(charSet) //last line of a function is what is being returned
  }

  def isGreaterThan(a:Int, b:Int):Boolean = {
    //FIXME
    a > b //this generates a boolean thus fullwilling our promise in the definition that we return a boolean
  }

  def add(a:Int, b:Int) = {
    a == b //Boolean and or course our name is now horrible, because that is not add!!!
  }

  //one liner a bit too long for a one liner but possible same as above
  //  def isPangram(text:String, alpha:String="abcdefghijklmnopqrstuvwxyz"):Boolean = alpha.toSet.subsetOf(text.toLowerCase.toSet)

  val myTestText = "The five boxing wizards jump quickly."
  println(isPangram(myTestText)) //should be true

  println(isPangram("Some random text"))

  //is same Set a subset of same set?
  println(Set(1,2,3).subsetOf(Set(1,2,3)))
  //so it is True meaning it is a <= type of relation between sets

  println(isPangram("abacca", "abc")) //should be true since all 3 letters of abc alphabet are represented here
  println(isPangram("abracadabra", "abc")) //should be true also since my alpha still only has 3 letters
  println(isPangram("abracadabra", "abcd")) //should be true also since my alpha still only has 4letters
  println(isPangram("abracadabra", "abcde")) //should be false also since my alpha still only has 5letters and we have no e

  val litTestText = "Įlinkusi fechtuotojo špaga blykčiodama gręžė apvalų arbūzą."

  val litAlpha = "Aa Ąą Bb Cc Čč Dd Ee Ęę Ėė Ff Gg Hh Ii Įį Yy Jj Kk Ll Mm Nn Oo Pp Rr Ss Šš Tt Uu Ųų Ūū Vv Zz Žž".replace(" ","").toLowerCase
  println(litAlpha)
  val litAlphaClean = litAlpha.toSet.mkString("")
  println(litAlphaClean)
  println(isPangram(litTestText, alpha = litAlphaClean))


}

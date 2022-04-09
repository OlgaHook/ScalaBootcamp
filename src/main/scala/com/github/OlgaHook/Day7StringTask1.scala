package com.github.OlgaHook

object Day7StringTask1 {

  def processString(text: String, uppercaseChars: String = "", needsTrim: Boolean = false): String = {
    //TOD first trim string if it needs trimming from the argument
    //TOD replace All characters in uppercaseChars with their uppercase versions
    //you will need to write a loop
    //you will probably want to use var to store a temporary string that you keep reweriting
    //return newly created string
    "FIXME" //FIXME
  }

  println(processString("abracadabra", "cr")) //should print abRaCadabRa
  println(processString("   abracadabra  ", "cr", needsTrim = true)) //should print abRaCadabRa
}

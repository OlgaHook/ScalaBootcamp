package com.github.OlgaHook

object Day13SongExerciseSolved extends App {
  println("Let's make and sing some Songs!")
  val lambada = new Song("Lambada",
    "Kaoma",
    Seq("Chorando se foi quem um dia só me fez chorar",
      "Chorando se foi quem um dia só me fez chorar",
      "Chorando estara ao lembrar de um amor",
      "Que um dia não soube cuidar",
      "Chorando estará ao lembrar de um amor",
      "Que um dia não soube cuidar",
      "A recordação vai estar com ele aonde for",
      "A recordação vai estar pra sempre aonde for"))

  val jingleBells = new Song("Jingle Bells",
    "James Pierpont",
    Array("Jingle bells, jingle bells",
      "Jingle all the way",
      "Oh what fun it is to ride",
      "In a one-horse open sleigh, hey!"))

  val journey = new Song("Don't Stop Believin'", "Journey",
    Seq("Just a small town girl",
      "Livin' in a lonely world",
      "She took the midnight train goin' anywhere",
      "Just a city boy",
      "Born and raised in south Detroit",
      "He took the midnight train goin' anywhere", "..."))


  jingleBells.sing(3)

  lambada.sing(2)

  journey.yell(3)

  lambada.sing(2).yell(3).whisper(2).sing() //I could chain more as long
  //as long as these methods return com.github.OlgaHook.Song object - in this case this very com.github.OlgaHook.Song


  val chaotic = new Rap("Chaotic",
    "Tate McRae",
    Array("I have this paralyzing fear that I'll maybe go nowhere",
      "But God forbid me ever admitting I could be scared"))

  chaotic.sing().yell(2).whisper(1) //this returns com.github.OlgaHook.Song so dropIt is not available
  chaotic.dropIt("Oh yea")

}

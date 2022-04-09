package com.github.OlgaHook

import scala.collection.mutable
//scala.collection.mutable.Set
//we can use now mutable.Map, mutable.Set, mutable.Seq etc
class Animal(val name:String,
             val animalType:String,
             var likes:mutable.Set[String],
             sound:String="", //by skipping val or var in parameter I can only use sound in constructor that's it not in methods
             //so we can use it for initialization or as a private variable
             var age:Int=0) {
  //  //BONUS
  //  //TODO add class method meet which has a parameter of contact:String
  //  //TODO this meet should decide whether to greet if they like the contact
  //  //TODO to run away if they do not like the contact

  //so private is not required but if we do not want outside access without method we make it private
  //here we are checking if parameter sound contains then we use that
  //if it is empty we create a new animalSound
  //a bit of overkill here
  private val animalSound = if (sound == "") //so if incoming sound is nothing we use pattern match to generate some sounds
    animalType match {
      case "dog" => "woof"
      case "dolphin" => "click"
      case "goose" => "cackle"
      case "fox" => "yelp"
      case "kangaroo" => "chortle"
      case "cat" => "meow"
      case _ => "brrrrrr" //for unknown animals
    } else sound
  //an alternative to match syntax we could have used a Map structrue with keys being animal Types and values being sounds


  def makeSound(): Unit = {
    println(animalSound) //so we print the our private variable
    println(sound) //so sound functions a private val essentially
  }

  def meet(contact:String): Unit = {
    if (likes(contact)) { //so if the contact is in the Set then this will be true
      println("Hello there, I like that \u263a \n") // ☺
    }
    else println("Nope. Byeeeee.\n")
  }

  //this is functional style something comes in and something comes out
  //completely fine , this method would work with Set from outside as well
  def addLike(newLike:String, likes:mutable.Set[String]): mutable.Set[String] = {
    likes += newLike
    likes //we return the new mutation
  }

  //oo style would be to adjust the value inside
  def adjustAge(delta:Int):Unit = {
    age += delta // so i am adjusting /mutating internal data inside the object
    //we return nothing
  }
}


object Day12AnimalTaskSolution extends App{
  println("Let's see some animals!")

  val tom = new Animal("Tom", "cat", mutable.Set("milk", "cookies"))
  tom.makeSound()
  val jerry = new Animal("Jerry","mouse", mutable.Set("cheese","sleep"), "squueek")
  jerry.makeSound()

  val myCat = new Animal("Autumn", "cat", mutable.HashSet("pets", "food", "snacks", "cuddles"), "meow", 12)
  val brothersDog = new Animal("Mūza", "dog", mutable.HashSet("food", "walks", "play"), "woof", 4)
  val streetCat = new Animal("Lialia", "cat", mutable.HashSet("attention", "pets"), "keke", 16)

  println("The animals have gathered:")
  myCat.makeSound()
  brothersDog.makeSound()
  streetCat.makeSound()

  var contact = "pets"
  println(s"I will give $contact to myCat:")
  myCat.meet(contact)
  println(s"I will give $contact to brothersDog:")
  brothersDog.meet(contact)
  println(s"I will give $contact to streetCat:")
  streetCat.meet(contact)


}

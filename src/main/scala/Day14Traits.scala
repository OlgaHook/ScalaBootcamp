//https://docs.scala-lang.org/overviews/scala-book/traits-interfaces.html
//https://www.amazon.com/Scala-Cookbook-Object-Oriented-Functional-Programming/dp/1492051543

//traits are building blocks for larger Scala applications
//allows code reuse
//build larger components
//two main uses of traits
//interface - contract
//mixin - add some already working code to your blueprint

trait HasTail {
  def startTail(): Unit //purely abstract definitions of a method
  def stopTail(): Unit
}

trait HasLegs {
  def startRunning(speed:Double): Unit
  def runForNSeconds(speed: Double, numSeconds: Int): Unit
}

trait HasEars {
  def wiggleEars(): Unit
}

//if we do not define our methods from traits we need to use an abstract
//then at some point I can use RealDog extends PlatonicDog
abstract class PlatonicDog extends HasTail with HasLegs with HasEars //second extends is with with
//you can not create objects from abstract classes


//at some point I need to create a RealDog that inherits from abstract class
class RealDog extends PlatonicDog {
  def startTail(): Unit = println("Really starting my Tail")
  def stopTail(): Unit = println("Really stopping my Tail")
  def startRunning(speed:Double): Unit = println(s"Really running at $speed miles per hour")
  def runForNSeconds(speed: Double, numSeconds: Int): Unit = {
    println(s"Really running at $speed miles per hour for $numSeconds")
  }
  def wiggleEars(): Unit = println("Really wiggling ears")
}
//Scala allows abstract classes but does not encourage them

//of course I could stop delaying the inevitable and actually create a blueprint for a dog
//in Scala 3 you can extends all of them without with
class Dog extends HasTail with HasLegs with HasEars {
  def startTail(): Unit = println("starting my Tail")
  def stopTail(): Unit = println("stopping my Tail")
  def startRunning(speed:Double): Unit = println(s"Running at $speed miles per hour")
  def runForNSeconds(speed: Double, numSeconds: Int): Unit = {
    println(s"Running at $speed miles per hour for $numSeconds")
  }
  def wiggleEars(): Unit = println("wiggling ears")
}

trait Pet {
  def speak():Unit = println("What's up!") //concrete ready to use
  def comeToMaster(): Unit //abstract to be implemented later
}

class DoggiePet extends Pet {
  def comeToMaster():Unit = println("I am coming master!")
}

class KittyPet extends Pet {
  //I can override already existing method in the trait
  override def speak():Unit = println("Meow")
  //comeToMaster had to be made in any case
  def comeToMaster():Unit = println("Not happening, nope!")
}


object Day14Traits extends App {
  println("Working with Traits!")

  val fido = new Dog()
  fido.startTail()
  fido.startTail()
  fido.startRunning(30)
  fido.runForNSeconds(25.7,48)
  fido.wiggleEars()

  val dzulbars = new RealDog()
  dzulbars.startTail()
  dzulbars.stopTail()
  dzulbars.wiggleEars()
  dzulbars.startRunning(45)
  dzulbars.runForNSeconds(28.9, 55)

  val fluffy = new DoggiePet()
  fluffy.speak()
  fluffy.comeToMaster()

  val minka = new KittyPet()
  minka.speak()
  minka.comeToMaster()

  println("Let's order lots of pizza")
  val smallPizza = new SmallPizza()
  println(smallPizza.maxNumToppings)
  val mediumPizza = new MediumPizza()
  println(mediumPizza.maxNumToppings)
  mediumPizza.maxNumToppings = mediumPizza.maxNumToppings + 5
  println(mediumPizza.maxNumToppings)
  //so above + 5 can be written in a shorter way
  mediumPizza.maxNumToppings += 12 //same as +5 line
  println(mediumPizza.maxNumToppings)
  val largePizza = new LargePizza()
  println(largePizza.maxNumToppings) //not val but method but result is the same - fixed result

  val customPizza = new CustomPizza(17)
  println(customPizza.maxNumToppings)
  val superCustomPizza = new AlsoCustomPizza(10)
  //println(superCustomPizza.myToppingCount) //no public access to parameters without var or val
  println(superCustomPizza.maxNumToppings)
  superCustomPizza.maxNumToppings += 77 // i can mutate since I set the field as var
  println(superCustomPizza.maxNumToppings)

}

object Day13CaseClasses extends App {
  println("Using case classes")
  val me = Person("Valdis", "myself", 180) //so for case classes new is not needed
  val sunflower = new Flower("sunflower", "yellow")
  //  val anotherFlower = sunflower.clone()
  println(me) //so case classes come in with prettyPrint basically
  //we also gain ability to pattern match by using case classes but about that later
  println(sunflower)

  //I have get access to all parameters
  println(me.name)
  println(me.relation)
  println(me.topSpeed)
  val myNewSpeed =  me.increaseSpeed(15) //we can extract the value as well
  println(myNewSpeed)
  println(s"Hello I am ${me.name} related as ${me.relation} with a top speed of ${me.topSpeed}")
  val myCopy = me.copy()
  println(me == myCopy) //so our contents are equal, but the objects are different

  val ede = Person("Ede", "daughter", 300)
  println(ede)
  //  ede.name = "NewEde" not possible since properties in case class are val by default
  ede.topSpeed = 400 //fine to mutate since I specified var in case class definition
  println(ede)

  //so mostly case classes are all about convenience
  //often a case class instance (object) will correspond an entry/row in a database, table etc
}

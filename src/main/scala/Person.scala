case class Person(name: String,
                  relation: String,
                  var topSpeed: Int) {
  println("Person creation started!")
  def increaseSpeed(delta: Int):Int =  {
    topSpeed += delta
    topSpeed //in functional style we return the new value in OOP style we would return nothing
  }
  println(s"Person has been created with name $name")
}
//for case classes the default is val (unlike regular class )
//var needs to be specified so we can change/mutate it
//often we do not add any methods to case class using as storage entries (the objects )


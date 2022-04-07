object Day14comandArguments extends App {
  println("Starting main function")
  for (arg <- args) {
    //all arguments are strings we can cast them to something else if we want
    println(s"Going to do something with argument: $arg its type is ${arg.getClass}")
  }
  println("All done")

  Day14noApp.main(Array("Oho","34234","120.7")) //we can in fact other object's main

}

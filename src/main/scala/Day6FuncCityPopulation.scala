import scala.io.StdIn.readLine

object Day6FuncCityPopulation extends App {
  object Day6CityPopulation extends App {
    //easy function
    //TODO write a function (name it yourself) to calculate Farenheit from Celsius
    //f = 32 + c*9/5

    //test it with 36.6

    //test it with 37
    //test it with 48.5
    def celsiusToFahrenheit(celsius: Double, precision: Int=2):Double= {
      //I could have done this in one line without curly braces
      MyUtil.myRound(32 + celsius*9/5, precision) //so I am returning already rounded and calculated value
    }

    //so idea is that readLine, println, all of those we would leave for other functions
    //our little conversion function would only worry about the calculations
    //  println(celsiusToFahrenheit(36.6))
    //  println(celsiusToFahrenheit(37))
    //  println(celsiusToFahrenheit(48.5))

    def temperatureCalculationApp(): Unit = {
      val celsius = readLine("What is temperature in Celsius? ").toDouble
      val fahrenheit = celsiusToFahrenheit(celsius) //it is often a good practice to keep the same names as we are passing
      //however i could have named this celsius something else
      println(s"$celsius of Celsius is $fahrenheit of Fahrenheit.")
    }
    //  temperatureCalculationApp() //no parameters required so no need for parenthesis

    //TODO 2nd main TASK - not really related to first task
    println("Function to calculate city growth")
    //TODO write a function getCityYear which takes the following 4 parameters
    //p0: Int - how many people are in beginning
    //perc: Int - yearly growth rate in percentages
    //delta: Int - how many people immigrate(+)/emigrate to the city each year
    //targetPopulation: Int - population we want to reach

    //we want to return the year city will reach targetPopulation
    //or we return -1 if the city will NEVER reach the population
    //it is a little bit tricky because we do not want to use return statements
    //we want to return the last line only
    //so you probably want to use some variable to hold the result
    //you will need a loop - while probably
    //you will need some if else statements
    //if we write comments /**
    //those are so called ScalaDoc style comments and they can be used by automatic tools to create documentation

    // */

    /**
     * getCityYear
     * @param p0 - original City population
     * @param percentage - yearly growth rate in percentages
     * @param delta - how many people immigrate(+)/emigrate to the city each year
     * @param targetPopulation - population we want to reach
     * @return number of years to reach , -1 if not reachable
     */
    def getCityYear(p0: Int, percentage: Double, delta: Int, targetPopulation: Int):Int = {
      //add some code here....
      var numberOfYears = 0
      var currentPop = p0
      //so we are going to cut off decimal values so 1052.34 humans will be 1052
      def nextYearPop(current: Int, percentage: Double, delta: Int):Int = (current*(1+percentage/100)+delta).toInt

      def checkTargetPopulation(currentPop:Int, targetPopulation:Int= targetPopulation, p0:Int=p0):Boolean = {
        if (p0 < targetPopulation) {
          currentPop < targetPopulation
        } else {
          currentPop > targetPopulation //we go the other way
        }
      }

      def checkCurrentPopulation(currentPop:Int, newPopulation:Int, targetPopulation:Int= targetPopulation, p0:Int=p0): Boolean = {
        if (p0 < targetPopulation) {
          currentPop < newPopulation
        } else {
          currentPop > newPopulation
        }
      }

      var newPopulation = nextYearPop(currentPop, percentage, delta)

      //lets check if we are losing people or stagnate on first year meaning nothing changes
      if (!(checkCurrentPopulation(currentPop, newPopulation)) && checkTargetPopulation(currentPop)) {
        numberOfYears = -1 //a bit of a workaround for our worst case scenario
      }

      //so while we are growing we are going to keep checking
      while (checkCurrentPopulation(currentPop, newPopulation) && checkTargetPopulation(currentPop)) {
        numberOfYears += 1
        currentPop = newPopulation
        newPopulation = nextYearPop(currentPop, percentage, delta)
      }
      //so if we stagnate

      numberOfYears //FIXME //right now it returns this 9000 all the time
    }

    println(getCityYear(1000,2,50,1200)) // should print 3
    println(getCityYear(1000,2,-50,1200)) // should print -1
    println(getCityYear(1500000,2.5,10000,2000000)) // should print 10
    //so searching for negative growth is currently not supported
    println(getCityYear(1000,2,-50,800)) //this will give us -1 when we actually would reach this
    println(getCityYear(1000,-2,-50,800)) //this will give us -1 when we actually would reach this

  }
}

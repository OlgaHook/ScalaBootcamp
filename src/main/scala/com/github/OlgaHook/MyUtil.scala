package com.github.OlgaHook

object MyUtil {
  //we are not going to use this directly thus not extends App
  //we will keep useful Utilities inside

  //let's make a our own round function
  //could come in handy
  def myRound(n: Double, precision: Int = 0): Double = {
    //so the trick would be to multiply by some power of 10 then divide by that mulitplier
    //so (n*100).round/100 would give us 2 points of precision
    //why because built in round gives us 0 precision
    //so if we have 100 that is 10 to the 2nd power(squared)
    //we can use the built in Math.pow to do that
    val multiplier = Math.pow(10, precision) //so precision 0 will give us 10 to 0 which is 1

    //    n.round //only 0 precision
    (n * multiplier).round / multiplier //we utilize the built in round
  }

  /**
   * Utility function to find delta from starting and stop time
   *
   * @param t0 - starting time
   * @param t1 - stop time
   * @return delta in milliseconds
   */
  def deltaMs(t0: Long, t1: Long, precision: Int = 3): Double = {
    myRound((t1 - t0) / 1_000_000.0, precision) //by default it will be 3
  }

  def printDeltaMs(t0: Long, t1: Long, taskName: String = "", precision: Int = 3): Unit = {
    val ms = deltaMs(t0, t1, precision = precision)
    println(s"It took $ms milliseconds to run the task: $taskName")
  }

}

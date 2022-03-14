object MyUtil {
  //we are not going to use this directly thus not extends App
  //we will keep useful Utilities inside

  //let's make a our own round function
  //could come in handy
  def myRound(n: Double, precision: Int=0):Double = {
    //so the trick would be to multiply by some power of 10 then divide by that mulitplier
    //so (n*100).round/100 would give us 2 points of precision
    //why because built in round gives us 0 precision
    //so if we have 100 that is 10 to the 2nd power(squared)
    //we can use the built in Math.pow to do that
    val multiplier = Math.pow(10, precision) //so precision 0 will give us 10 to 0 which is 1

    //    n.round //only 0 precision
    (n*multiplier).round/multiplier //we utilize the built in round
  }

}
trait PizzaTrait {
  def maxNumToppings: Int //so actually defining a method is the most flexible way to require some field
}

class SmallPizza extends PizzaTrait {
  val maxNumToppings = 4 //notice I used a val
}

class MediumPizza extends PizzaTrait {
  var maxNumToppings = 7
}

class LargePizza extends PizzaTrait {
  def maxNumToppings: Int = {
    //do some calculations to actually get count of toppings
    23
  }
}

//using a val or var would work as well as parameter
//difference between Custom and Medium Pizza is that Custom Pizza can receive specific number not just 7
class CustomPizza(val maxNumToppings: Int) extends PizzaTrait

class AlsoCustomPizza(myToppingCount: Int) extends PizzaTrait {
  var maxNumToppings:Int = myToppingCount //so longer way of doing the same as CustomPizza
  //could use var or val depending if you want change value
}

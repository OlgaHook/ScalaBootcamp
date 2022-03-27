object Day10Maps extends App {

  // Maps are a type of data structure holding a collection of key -> value pairs
  //There can be immutable and mutable
  //The main advantage over say a sequence is that we can access very quickly the value by the key
  //so we create a mapping between keys and values

  val myNumbers = (0 to 10).toArray
  println(myNumbers(3)) //so Indexed sequence we can look up values by their index
  println(myNumbers.mkString(","))

  //  //how would I go about storing my favorites, say food, car, color
  //  //well one way would be to create a mapping of food -> potatoes, car -> vw, color -> green
  //  //in other words we create a collection of key -> value pairs
  //
  //  //so maps require keys to be unique, but values can be duplicate
  //by default the Map will be immutable
  //this will be a String -> String mapping
  val myFavorites = Map(("food", "potatoes"),
    ("car", "vw"),
    ("color", "green"),
    ("shirt","green"),
    ("salad", "green")
  )
  println(myFavorites.mkString(","))
  //
  //  //alternative syntax for creating Maps using -> notation
  //  //in this case we map strings to integers
  // remember we use <- when looping
  //here we use -> to indicate relation between keys and values
  val anotherMap = Map("cats" -> 5, "dogs" -> 3, "kids" -> 3, "cars" -> 1)
  println(s"I have ${anotherMap("cats")} cats ")

  //so if I know the key i can get the value out instantly - even when we have billions of items
  //in Computer Science terms it is called constant time or O(1) in so called big O notation

  //  //you could even create a Map of integers mapping to strings, whic is kind of similar to indexed sequence,
  //  // //so it would be useful only if numbers tend to jump around with BIG gaps
  //
  val numericMap = Map(100 -> "heroes",
    300 -> "Spartans",
    9000 -> "enough",
    9001 -> "too much",
    2_000_000 -> "even more so")

  println(numericMap(300))
  println(numericMap(2_000_000))

  //  println(numericMap(5000)) //this will throw an exception
  //  println(myFavorites("drink")) //again will be an exception
  //

  //I can use contains to check for existence of key
  println(myFavorites.contains("food")) //so this is a very quick check if key named food exists
  println(myFavorites.contains("drink")) //so this is a very quick check if key named food exists

  //so we could use if to check for key existance
  //  val myKey = "food" // this could be coming in from readLine or outside
  val myKey = "drink" // this could be coming in from readLine or outside
  if (myFavorites.contains(myKey)) {
    println(s"Key $myKey -> ${myFavorites(myKey)}")
  } else {
    println(s"Sorry no key $myKey found")
  }

  //instead of writing if we usually want to use some sort of get , such as getOrElse
  val myValue = myFavorites.getOrElse(myKey, "no such key") // so if no key the 2nd argument is assigned to myValue

  println(s"Key $myKey -> $myValue")

  // so we can iterate/loop through both key and value at the same time
  for ((key,value) <- myFavorites) {
    println(s"my key: $key maps to -> $value")
    //I could do more with that particular key value pair here
  }


  val myValues = for ((_,value) <- myFavorites) yield value //I am using _ to indicate that key is not needed
  println(myValues)
  val myValuesToo = myFavorites.values // same thing as above

  val myKeys = myFavorites.keys.toSeq //keys actually is a Set which we have not covered

  println(s"My keys $myKeys")
  println(s"My values $myValues")

  //
  //
  //
  //  //I can filter values out of one Map into another
  val greenMap = for ((key,value) <- myFavorites if value == "green") yield (key,value)
  println(greenMap.mkString(","))
  //
  //  val greenKeys = (for ((key,value) <- myFavorites if (value == "green")) yield key).toArray
  //  println(greenKeys.mkString(","))
  //
  //  //about getting Values, what do we do if we are not sure
  //  //we could use contains
  //  //but also we could use get option
  val foodValue = myFavorites.get("food") //this gives us an Option
  println(foodValue)
  println(myFavorites.get("dessert")) //so Option is a way of handling possible None (null in other languages values)
  //null is considered the bane of programmers existance, leads to many bugs
  //in Scala it generally is avoided
  //  //Options are particularly useful if we might not get a usable value
  val foodValueContent = foodValue.getOrElse("no food found :(") //we can call getOrElse on Option as well
  println(foodValue)
  println(foodValueContent)

  //
  val badValue = myFavorites.get("not a real key")
  val badKeyContents = badValue.getOrElse("sorry no such key") //so if the option is None you will get the default text specified
  println(badValue)
  println(badKeyContents)
  //so we avoid those pesky Exceptions that Scala does not like
  //we could even throw an exception if we really wanted but that is more Java like
  //https://www.baeldung.com/scala/option-type

  //  //we can convert Sequences(Arrays etc) of two values(tuples) into Maps
  val mySeq = Seq(("one",10), ("two",20), ("three", 30), ("two", 2020))
  println(mySeq(1)) //will print ("two",20)
  val myMap = mySeq.toMap //so here the first two will be gone and overwritten by 2nd "two"
  println(mySeq)
  println(myMap)
  //
  for(((key,value), index) <- myMap.zipWithIndex) println(s"Item No.$index with $key -> $value") //zero based index
  //
  //  //we can skip the option part and use getOrElse immediately
  //  val againBadKeyLookup = myMap.getOrElse("some non existant key", "no key found sorry!").toString
  //  println(againBadKeyLookup)
  //  println(myMap.getOrElse("two", "hmm no two found?"))
  //
  //  //so since Maps are immmutable by default we will need to create a new map if we to add some elements
  //  //https://alvinalexander.com/scala/how-to-add-update-remove-elements-immutable-maps-scala/
  val myBiggerMap = myMap + ("four" -> 404)
  println(myBiggerMap)
  //
  val mergedMap = myMap ++ anotherMap //types have to match, both of the maps have string -> int type of mapping
  println(mergedMap)

  //
  //  //we could also creata a map as var, meaning we can overwrite the map
  var stateMap = Map("AL" -> "Alabama")
  //  // add one element
  stateMap += ("AK" -> "Alaska") //by using var we can overwrite our old map with new one meaning we add one element and overwrite
  //  //again use vars sparingly
  println(stateMap)
  //
  //  //not allowed for immutable Map
  //  //  myMap("two") = 2322432
  val muteMap = scala.collection.mutable.Map("cats" -> 5, "dogs" -> 3, "kids" -> 3, "cars" -> 1)
  println(muteMap)
  muteMap("birds") = 452 //so we can add keys to existing mutable map
  muteMap("dogs") = 101 //I can modify existing values
  println(muteMap)
  //
  //  //I can create a map out of Array with some yield fun
  //  //  val squareMap = for(n <- myNumbers) yield (n,n*n) //not such a great Map because indexed Sequence(Array ) would be fine
  val squareMap = (for (n <- myNumbers) yield (s"Number $n squared",n*n)).toMap //there is no specific order
  println(squareMap)
  //
  //  //we could also use map to create Maps (yield actually calls map underneath
  val squareArray = myNumbers.map(n => (s"Number $n squared", n*n))
  val squareMapAgain = squareArray.toMap //we could have called toMap immediately in the line above

  println(squareArray.mkString(","))
  println(squareMapAgain)
  //
  //  println(squareArray.length)
  //  println(squareArray.mkString(","))
  //  println(squareMapAgain)
  //  //so what is the difference between Array of Tuples(String,Int) and Map of String-> Int
  //  //Array you call by number index
  //  //Map you call directly by key (string here)
  //  println(squareArray(3))
  //  println(squareMapAgain.getOrElse("Number 3 squared", -1))
  //  //I can split keys from values into two iterables -> probably Arrays
  //  println(squareMapAgain.keys.mkString(",")) //we can get an array of Map keys
  //  val myKeys = squareMapAgain.keys.toArray
  //  val myValues = squareMapAgain.values.toArray
  //
  //  //we can remove key-value pairs by key only from mutable Maps
  println(muteMap)
  muteMap -= "cars" //removing by key, so that particular key-> value pair is gone
  //
  println(muteMap)
  muteMap("birds") += 987 //so I am updating the value of key "birds" by adding to previous value (452 in this example)
  println(muteMap)
  muteMap("kids") = muteMap("kids")*10 //same as muteMap("kids") *= 10
  println(muteMap)
  //
  //  //I can remove multiple key value pairs by specificing a sequence of keys
  muteMap --= Seq("birds", "cats") //List or Array would work too
  println(muteMap)

}

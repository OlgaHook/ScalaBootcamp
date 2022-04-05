//1. Song class
//create  a class Song
//
//The class constructor needs to have three additional 3 parameters
//
//title defaults to empty string
//
//author defaults to empty string
//
//lyrics by default empty Seq of strings
//
//inside constructor method:
//
// print on the screen "New Song made" - (try also printing here author and title!)
//
//Minimum:
//
//Write a method sing that prints the song line by line on the screen, first printing the author and title, if any.
//
//Write a method yell that prints the song in capital letters line by line on the screen, first printing the author and title, if any.
//you can write private helper methods if you think code is too similar..

//Bonus: create an additional parameter maxLines that prints only a certain number of lines for both sing and yell. Better do with some default value e.g. -1, at which all rows are then printed.
//
//Create multiple songs with lyrics
//
//Example:
//
//
//ziemelmeita = Song("Ziemeļmeita", "Jumprava", Array("Gāju meklēt ziemeļmeitu","Garu, tālu ceļu veicu"))
//
//ziemelmeita.sing(1)
//
// Outputs:
//
//Ziemeļmeita - Jumprava
//
//Gāju meklēt ziemeļmeitu //just one line since I specified sing(1)
//ziemelmeita.sing() //would print all lyrics

//
//
//2. Rap class
//For those feeling comfortable with class syntax, create a Rap class that inherits from Song
//
// add a new method breakIt with two default parameters max_lines=-1 and drop equal to "yeah",
// this breakIt which is similar to sing, but adds a drop after each word .
//
//Example:
//
//
//
//zrap = Rap("Ziemeļmeita", "Jumprava", Array("Gāju meklēt ziemeļmeitu"," Garu, tālu ceļu veicu"))
//
//
//
//zrap.breakIt(1, "yah")
//
//Ziemeļmeita - Jumprava
//
//Gāju YAH meklēt YAH ziemeļmeitu YAH


object Day13SongExercise extends App {
  println("Let's make some songs!")
  //create a couple of Songs
  //possibly some Rap songs as well :)
}

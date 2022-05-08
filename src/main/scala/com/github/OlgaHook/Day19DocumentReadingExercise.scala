package com.github.OlgaHook


import java.io.FileWriter
import scala.io.Source

//TODO create Document class (or case class whichever you prefer)
//class should contain following constant fields to be passed as parameters upon creation:
// title:String = ""
// author:String = ""
// url:String = ""
// rows:Array[String] = Array[String]()

// TODO upon creation in constructor (main body of class) - the following constant fields should be created
// rowCount:Int - rows.length
// wordCount:Int - contains a count of all the words in rows

//TODO add a single method save(dst:String = "", folder:String="src/resources/texts"):Unit
//will write to the folder/dst file - remember to add the extra slash
//will write s"URL: $url" as first row
// similarly will write Author: actual author as 2nd row
//will write Title: title as 3rd row
//will write 3 newlines
//will will write all rows
//if dst is empty string - create a file name
//if author AND title are non empty -
//create file name such as Doyle_Adventures.txt (10 letters max from author, 15 letters max from title
// bonus - add timestamp in file name
// something like this Doyle_Adventures_2022_4_16_15_06.txt
// https://stackoverflow.com/questions/48378006/how-to-get-current-timestamp-in-scala-as-a-string-without-spaces
class ExerciseClass(title: String = "", author: String= "", url:String = "", rows:Array[String] = Array[String]())
{
  val rowCount:Int = rows.length
  val wordCount:Int = MyUtil.getWordCountPerLine(rows).sum

  val localText = rows.mkString

  def saveText(dstPath: String, append:Boolean=false, verbose:Boolean=false):Unit = {
    if (verbose) println(s"Saving ${localText.length} characters to $dstPath")
    val fw = new FileWriter(dstPath, append)
    if (append) fw.write("\n")
    fw.write(localText)
    fw.close()
  }
}



object Day19DocumentReadingExercise extends App {


  //TODO create a program that reads web addresses from a file and downloads multiple files with some changes
  //check for system arguments (see Day14commandArguments )
  var iterator: Int = 0
  var FilePath: String = ""
  println("Starting main function")
  for (arg <- args) {
    iterator = iterator + 1
    println(s"Checking for argument: $arg its type is ${arg.getClass}")
    if (iterator == 1) {
      FilePath = arg
    }
  }
  if (FilePath == "") {
    FilePath = "src/resources/webPages.txt"
  }
  print("Opening file: ")
  println(FilePath)

  //opening file into myLines array

  val bufferedSource = Source.fromFile(FilePath)
  val myLines = bufferedSource.getLines().toArray
  bufferedSource.close()


  // here I analize each individual line found in the file
  // and determine the filename under which I will save the ebook

  // 1 URL --> 1 ebook

  var currentLine = ""
  var fileName = ""
  var fileNameFull = ""
  var currCharString = ""
  var currentChar: Char =_
  var startPos: Int = 0 //start position
  var endPos: Int = 0 //end position

  for( currentLine<-myLines ) {
    // new line from the TXT file with URLs
    // currentLine is URL string

//    println(currentLine)
//    val myText = new ExerciseClass()

    //I determine the file name from URL
    fileName = ""

    for( i <- 0 to currentLine.length()-1 ) {
      currentChar = currentLine.charAt(i)
      currCharString = currentChar.toString
      if ( currCharString == "/") {
        startPos = i
      }
      if ( currCharString == ".") {
        endPos = i
      }
    }

    for ( i <- startPos+1 to endPos-1 ) {
      fileName = fileName + currentLine.charAt(i)
    }

    fileName = fileName + ".txt"
    fileNameFull = "src/resources/" + fileName

    //file name is now determined

    print("Saving ")
    print(currentLine)
    print(" under filename: ")
    println(fileName)


    //fetch text from the Internet based on URL
    val text = MyUtil.getTextFromWeb(currentLine) //we make a get request on the web resource
    val content = Array( text )                   //we make it compatible with ExerciseClass parameter Array

    //we create an instance of ExerciseClass
    val result = new ExerciseClass(fileName, "Olga", currentLine, content )
    //and save it into the location specified in the fileNameFull by calling method saveText()
    result.saveText(fileNameFull)

  }




//  val text = MyUtil.getTextFromWeb(url) //we make a get request on the web resource
//  println(text.take(300))
//  val dst = "src/resources/ChristieA_Poirot_Investigates.txt"
//  val dst = "src/resources/DoyleAC_Adventures_of_Sherlock_Holmes.txt"
//  MyUtil.saveText(dst, text)


  //use first argument as filePath to process
  //otherwise default filePath will be src/resources/webPages.txt


  //TODO read all lines from filePath
  //assume each line is one URL


  //bonus: add https:// prefix if one is not present in each line - if http:// OR https:// is present DO NOTHING

  //TODO read all URLs - save into array of Document objects
  //TODO call save method on all members of the array
  //you can let save figure out the names automatically (if you made this functionality)
  //or you can pass some dst name here as well
  //Use slight delay between each URL read such as  Thread.sleep(200) //200ms delay

  //TODO test it by creating your own 10 URL text file (can use Project Gutenberg can use some other sites and saving it as src/resources/webPages.txt


}

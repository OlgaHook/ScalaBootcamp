package com.github.OlgaHook

import java.util.Calendar
import scala.xml.{Node, XML}

object Day22ParsingXML extends App{
  val src = "src/resources/xml/books.xml"

  val xml = XML.loadFile(src) //so we load the whole structure into xml Elem data type - so root element

  println(xml)

  //in Scala 2 i can still make XML directly, - XML is a first class citizen


  println(myOwnXMl)

  val books = xml \ "book" //i am saying get all book tags that are direct children of this xml element(catalog here)

  val firstBook = books.head
  println(firstBook)

  //we can get the contents of some attribute considering the fact that the atribute might not exist at all
  val id = firstBook.attribute("id").getOrElse("bk0").toString
  println(s"Our book id is $id")

  //get children tag text contents
  println((firstBook \ "author").text) //theoretically if we had multiple author tags we would get ALL the text from those tags
  println((firstBook \ "title").text)
  println((firstBook \ "genre").text)
  println((firstBook \ "price").text)

  def getBook(node: Node):BookUnit = {
    val id = node.attribute("id").getOrElse("bk0").toString
    val author = (node \ "author").text
    val title = (node \ "title").text
    val genre = (node \ "genre").text
    val price = (node \ "price").text.toDouble
    val publishDate = (node \ "publish_date").text
    val description = (node \ "description").text
    BookUnit(id, author, title, genre, price, publishDate, description)
  }

  val bookUnits = (for (book <- books) yield getBook(book)).toArray

  println(bookUnits.head)
  println(bookUnits.last)

  val genres = bookUnits.map(_.genre).distinct
  println(genres.mkString(","))

  //TODO find the 5 most expensive books
  val prices = bookUnits.map(_.price)
  val expBooks = bookUnits.sortBy(_.price)
  println(s"Here are 5 most expensive books:")
  //  expBooks.reverse.take(5).map(book => s"${book.price} $$ ${book.title} by ${book.author}").foreach(println)
  //we converted the above line into a method for the case class
  expBooks.reverse.take(5).map(_.getPriceTitleAuthor()).foreach(println)
  //TODO find the 5 cheapest expensive books
  expBooks.take(5).map(_.getPriceTitleAuthor()).foreach(println)

  //TODO find all romance books
  val romanceBooks = bookUnits.filter(_.genre == "Romance")
  println("Here are all romance books:")
  romanceBooks.foreach(println)

  //TODO get all distinct authors in alphabetical order
  val authors = bookUnits.map(_.author).distinct.sorted
  println("Here are all distinct authors:")
  authors.foreach(println)


  println(firstBook \ "editions")
  println((firstBook \ "editions" \ "second" \ "date").text)

  //with \ i only see direct children
  println(firstBook \ "date")

  //we can use \\ to search recursively for any descendants matching our tag
  val anyDescendants = (firstBook \\ "date").toArray
  anyDescendants.foreach(println)
  val publishingYears = anyDescendants.map(_.text.toInt)
  println(publishingYears.mkString(","))

  //Saving XML

  val myOwnXMl = <book id="bk305">
    <title>Best Fruit Cocktails
    </title>
    <author>Doe, John
    </author>
    <published>Rīga, Čiekurkalns</published>
  </book>

  scala.xml.XML.save("src/resources/xml/mybook.xml", myOwnXMl)

  println(bookUnits.head.getXML())

  val bookXMLCollections = bookUnits.map(_.getXML())

  val creationDate = "28-04-22"
  val name = "Valdis"
  val today = Calendar.getInstance().getTime()
  print(today)

  //again in Scala 2 XML is first class citizen meaning we do not need any " or anything we just write XML
  //and we use {myvariable} to include information
  //here bookXMlCollections is an Array of XMl Nodes and it is automatically expanded no need for you to write a loop or anything
  val collection = <collection creationDate={today.toString} creator={name}>
    {bookXMLCollections}
  </collection>

  println(collection)

  scala.xml.XML.save("src/resources/xml/bookCollection.xml", collection, xmlDecl = true) //if we want to have the header

  //the hard part with XML is that often it has namespaces meaning tags come under different organizations
  //so theoretically one XML can have multiple someTag under different namespaces
}


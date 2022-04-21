package com.github.OlgaHook

abstract class Notification //this type of class can not be used directly it has to be extended
//I could add some method definitions as well

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

case class WhatsUpMessage(contact: String, message: String, number: Int) extends Notification

object Day15CaseClassPatternMatching extends App {

  //https://docs.scala-lang.org/tour/pattern-matching.html
  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Valdis", "voicerecording.org/id/123")
  val someEmail = Email("valdis.s.coding@gmail.com", "Pattern Matching", "Are you up for some pattern matching?")
  val someWhatsUpMessage = WhatsUpMessage("Liga", "Come for supper!", 2911)
  val anotherWhatsUpMessage = WhatsUpMessage("Ruta", "Help with homework!", 2648)

  //since all three com.github.ValRCS.SMS, com.github.ValRCS.VoiceRecording and com.github.ValRCS.Email extend com.github.ValRCS.Notification
  // we can pass these
  // created objects to functions that take com.github.ValRCS.Notification as a parameter

  //I could not pass com.github.ValRCS.SMS to function that requires com.github.ValRCS.VoiceRecording

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case SMS(number, message) =>
        s"You got an com.github.ValRCS.SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name! Click the link to hear it: $link"
      case WhatsUpMessage("Liga", msg, _) =>
        s"You got an urgent message from Liga! it is $msg and number you know already"
      case WhatsUpMessage(name, msg, number) =>
        s"You got a WhatsUp Message: $msg from $name at number $number"
      case default  => s"Unknown com.github.ValRCS.Notification ${default.toString}"
    }
  }

  println(showNotification(someSms))
  println(showNotification(someVoiceRecording).toUpperCase) //we can yell after processing :)
  println(showNotification(someEmail))
  println(showNotification(someWhatsUpMessage))
  println(showNotification(anotherWhatsUpMessage))

  //so we can use Pattern Guards as advanced filtering logic

  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
        s"You got an email from special someone! that is from $sender"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        s"You got an com.github.ValRCS.SMS from special someone! That special someone is at number $number"
      case other =>
        showNotification(other) // nothing special, delegate to our original showNotification function
    }
  }

  val importantSMS = SMS("1888", "This is an ad! buy more ovaltine")
  val importantContacts = Array("2911", "112", "113", "1888", "valdis.s.coding@gmail.com")
  //we consider Array a type of Sequence so signature works fine
  println(showImportantNotification(importantSMS, importantContacts))
  println(showImportantNotification(someEmail, importantContacts))
  println(showImportantNotification(someSms, importantContacts))

  // more pattern matching fun

  // https://docs.scala-lang.org/overviews/scala-book/match-expressions.html

  //alternative to if statements
  //  val someVal = 33

  val someVal = 23
  someVal match {
    case a if 0 to 9 contains a => println("0-9 range: " + a)
    case b if 10 to 19 contains b => println("10-19 range: " + b)
    case c if 20 to 29 contains c => println("20-29 range: " + c)
    case _ => println("Hmmm...")
  }
  //the above would not be great on large ranges
  //like millions then regular if would be much beter
}

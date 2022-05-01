package com.github.OlgaHook

import scala.xml.Node

case class BookUnit(id:String,
                author:String,
                title:String,
                genre:String,
                price:Double,
                publish_date:String,
                description:String
               ) {
  def getPriceTitleAuthor():String = s"$$$price -  $title by $author"

  def getXML():Node= {
    <book id={id}>
      <author>{author}</author>
      <title>{title}</title>
      <genre>{genre}</genre>
      <price>{price}</price>
      <publish_date>{publish_date}</publish_date>
      <shortDescription>{description.take(20)}</shortDescription>
    </book>
  }
}

package com.clarity.mongo
import com.mongodb.{DB => MongoDB}
import scala.collection.JavaConversions._

class DB private(val underlying: MongoDB) { 
	def collectionNames = for(name <- new JSetWrapper(underlying.getCollectionNames)) 
		yield name	
}

object DB { 
	def apply(underlying: MongoDB) = new DB(underlying)
}
package com.clarity.mongo
import com.mongodb.{DB => MongoDB}
import scala.collection.JavaConversions._

class DB private(val underlying: MongoDB) { 
	private def collection(name: String) = underlying.getCollection(name)

	def readOnlyCollection(name: String) = new DBCollection(collection(name)) 
	def administrableCollection(name: String) = new DBCollection(collection(name)) with Administrable 
	def updatableCollection(name: String) = new DBCollection(collection(name)) with Updatable		
	
	def collectionNames = for(name <- new JSetWrapper(underlying.getCollectionNames)) 
		yield name			
}

object DB { 
	def apply(underlying: MongoDB) = new DB(underlying)
}
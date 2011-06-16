package com.clarity.mongo

import com.mongodb.{DBCollection => MongoDBCollection } 
import com.mongodb.DBObject

class DBCollection(override val underlying: MongoDBCollection) extends ReadOnly

trait ReadOnly { 
	val underlying: MongoDBCollection 
	def name = underlying getName 
	def fullName = underlying getFullName 
	def find(doc: DBObject) = underlying find doc 
	def findOne(doc: DBObject) = underlying findOne doc 
	def findOne = underlying findOne
 	def getCount(doc: DBObject) = underlying getCount doc
}

trait Administrable extends ReadOnly { 
	def drop: Unit = underlying drop
 	def dropIndexes: Unit = underlying dropIndexes
}

trait Updatable extends ReadOnly { 
	def -=(doc: DBObject): Unit = underlying remove doc
	def +=(doc: DBObject): Unit = underlying save doc
}
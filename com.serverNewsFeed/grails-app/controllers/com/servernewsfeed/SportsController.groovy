package com.servernewsfeed
import groovy.sql.Sql
import groovy.sql.*
import groovy.*

class SportsController {
def dataSource
	def index(){}
	def thehindu(){
		groovy.sql.Sql sql = new Sql(dataSource)
    	def queryResult = sql.execute '''
			select url,content
			from sportsarticle;
		'''
		def val = 2 ;
		List result = sql.rows("select url,content from sportsarticle where newspaperid = $val") 
		def json = new groovy.json.JsonBuilder()
		def root = json.article{
			result.each{
				row ->
				url: row.url
				content: row.content
			}
		}
		def result1 = json {
			article result
		}			
		render(json.toPrettyString())

		try
    	{
    		 	sql.close()

    	} catch(Exception e) {

       		println e     
    	}

	}

	def indianexpress(){
		groovy.sql.Sql sql = new Sql(dataSource)
    	def queryResult = sql.execute '''
			select url,content
			from sportsarticle;
		'''
		def val = 1 ;
		List result = sql.rows("select url,content from sportsarticle where newspaperid = $val") 
		def json = new groovy.json.JsonBuilder()
		def root = json.article{
			result.each{
				row ->
				url: row.url
				content: row.content
			}
		}
		def result1 = json {
			article result
		}			
		
		render(json.toPrettyString())
		try
    	{
    		 	sql.close()

    	} catch(Exception e) {

       		println e     
    	}

	}
}

package com.servernewsfeed
import groovy.sql.Sql
import groovy.sql.*
import groovy.*
import java.*

class NewsController {
	def dataSource
    def index() {
    	groovy.sql.Sql sql = new Sql(dataSource)
    	def qs = "select * from newspaper"
    	def queryResult = sql.execute '''
			select id, name,url
			from newspaper;
		'''
		def maxId = 3
			sql.eachRow("select id, name from newspaper where id < $maxId") { row ->
			if (row.id == 1) println row.name
			if (row.id == 2) println row.name
		}
		try
    	{
    		 	sql.close()

    	} catch(Exception e) {

       		println e     
    	}
    	
	//def driver = Class.forName("com.mysql.jdbc.driver", true, Thread.currentThread().contextClassLoader);
	//def properties = new Properties(); 
	//properties.setProperty("user","root"); 
	//properties.setProperty("password","root");
	//driver.connect("jdbc:mysql://localhost:3306/scraperdb", properties); 
	//Class.forName ("com.mysql.jdbc.Driver");
	//def connection = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/scraperdb","root","root" );
	//def db = [url:"jdbc:mysql://127.0.0.1:3306/scraperdb?useUnicode=yes&characterEncoding=UTF-8", user:"root", password:"root", driver:"com.mysql.jdbc.Driver"]
	//def ldf = Sql.newInstance(db.url, db.user, db.password,db.driver)	
	/*def dataSource
	String query = '''
		select id, name,url
		from newspaper;
	'''
//	def usedb = Sql.newInstance("use scraperdb;")
	def sqlWorks = Sql.newInstance(query)
	println sqlWorks

    }*/
	}
}
    //final Sql sql = new Sql(dataSource)
	//final results = sql.rows(query,search: searchString)
	//println results
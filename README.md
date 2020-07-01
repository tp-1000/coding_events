# coding_events
Java coding events web application -- ORM Database MVC

The first should describe the purpose of the app. 

This is a MVC for creating events.
Features include assigning events with tags,
and the creation of tags, events, and event catagories.
Users have CRUD availiblity for created events.
Users should also be able add new event categories and tags.

In essence this application can be used to create an event from a web application,
and add tags to it and also creates categories to witch the events belong.


Currenty, there are four entities being saved -- Event, Details, Tags, and Categories.
There is a a database server that needs to be linked with the application and
will need reconfiguring with new enviroment variables for application to function
otherwise application exists in un-jar-ed state and running handled from gradle bootrun.
Default port is set to localhost:8080 but can be reconfigued without ill effect.

Relationships:
Many Tags <-> Many Events
One Detail-> One Events
One Category <-> Many Events

The third and final section should describe the future improvements you want to make to the app including your notes about the Person class
Another feature is planned for the application. A person class, with login authenitication. The Events app would allow for the creation of
a user. A user would have the ablity to collect events they will be attending. There would also be an option for recomendations for new
events based on a list of tags the user follows.

a person class could look somehting like this:

public class Person extends AbstractEntity // extends base for all entities
	id
	name

	@Many to many relationship — DTO (person and events) 
	final list of events attending
	
  @Many to many  - DTO (person and tags)
  final list of tags interested in
	
	add an event to the list of events
	remove an event
  
	add to list of tags
	remove list of tags

  get list of recomended events based on interested tags 
  
  
  NOTE: This application was designed by LaunchCode, and my implementation would not have been possible without the help of many people at LaunchCode.
        Special thanks to Chirs Bay for his walk through videos.
  
  

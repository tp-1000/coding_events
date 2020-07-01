# coding_events
Java coding events web application -- ORM Database MVC

--basics--
An application for creating events based on MVC.
Features include: assign tags to events,
and the creation of tags, events, and event categories.
CRUD exists for created events.

In essence this web application can be used to create an event,
add tags to it, and also creates categories to which the events belong.

--Current State--
Currently, there are four entities being saved -- Event, Details, Tags, and Categories.
There is a a database server that needs to be linked with the application and
will need reconfiguring with new environment variables for application to function
otherwise application exists in un-jar-ed state and running handled from categories boot-run Gradle bootrun.
Default port is set to localhost:8080 but can be reconfigured without ill effect.

Relationships:
Many Tags <-> Many Events

One Detail-> One Events

One Category <-> Many Events

--Future--
Another feature is planned for the application. A person class, with login authentication. The Events app would allow for the creation of
a user. A user would have the ability to collect events they will be attending. There would also be an option for recommendations for new
events based on a list of tags the user follows.

a person class could look something like this:

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

  	get list of recommended events based on interested tags 
  
  
  ** other features could include the ability to create an event and have that event tied to the user. Granting management privileges
  	to the creator.
  
  
  NOTE: This application was designed by LaunchCode, and my implementation would not have been possible without the help of many people at LaunchCode.
        Special thanks to Chris Bay for his walk through videos.
  

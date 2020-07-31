# Stinky-bot

 An example discord bot for learning and for insulting my friends.

## Features

 Currently the bot can:

  - respond to a few users when they send something, with a defined message.
  - respond to certain message contents
  - toggle user responses with 'toggle stinky'

## Planned functionality

 In the next update, the bot will likely have:

  - Several other commands, such as for generating it's bot invite link.
  - Further user responses.
  - Potentially an overhaul of the response system, to allow more loosely coupled adding of user responses.
 
 Further planned features include:

  - Making the bot give it's responses either randomly or on a timeout, to prevent it constantly responding 
     to the defined users when running. This could be added as default, or as a separate mode.
  - A proper command system, akin to the response system
  - toggling of general, non-user responses
  - Any suggestions by friends.
  - Adding command line option to specify location of the token file

## Development

 To develop for the bot, first clone the repository, and add it to your preferred IDE as a Gradle project.
 After the project has been loaded and built, and you have filled your discord bot token in the `token.txt` 
 file, it should be ready to develop. The token file will need to be copied to wherever the project is being 
 run from, in the case of running a jar file for instance, although an option to specify the token file 
 path will be added in future. Similarly, the desired user or message responses should be added to the 
 responses class, following the example layouts. Lastly, it is recommended to add any IDE project files to 
 the `.gitignore`, to avoid git clutter.

 If any of this doesn't work, let me know, and I can correct this section, or provide setup help.

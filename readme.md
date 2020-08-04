# Stinky-bot

 An example discord bot for learning and for insulting my friends.

## Features

 Currently the bot can:

  - Respond to a few users when they send something, with a defined message, and toggle user responses with '.toggle stinky'.
  - Respond to certain message contents, and toggle with '.toggle message'
  - Display help, invites, and store and display suggestions.

## Planned functionality

 In the next update, the bot will have:

  - Persistent storage of configurations and bot suggestions, stored in a file (periodically? and) between up time.
 
 Further planned project features include:

  - Making the bot give it's responses either randomly or on a timeout, to prevent it constantly responding 
     to the defined users when running. This could be added as default, or as a separate mode.
  - Adding command line option to specify location of the token file
  - Potentially an overhaul of the response system, to allow more loosely coupled adding of user responses.

 And planned bot features/commands include:

  - Image processing, such as 'deep-frying' or distorting etc user supplied images.
  - Generating ''''server rules'''' supplied by users, parodying real server rules.
  - Voting system, such as for games-nights, or jokes, etc.
  - Any suggestions by friends.

## Development

 To develop for the bot, first clone the repository, and add it to your preferred IDE as a Gradle project.
 After the project has been loaded and built, and you have filled your discord bot token in the `token.txt` 
 file, it should be ready to develop. The token file will need to be copied to wherever the project is being 
 run from, in the case of running a jar file for instance, although an option to specify the token file 
 path will be added in future. Similarly, the desired user or message responses should be added to the 
 responses class, following the example layouts. Lastly, it is recommended to add any IDE project files to 
 the `.gitignore`, to avoid git clutter.

 If any of this doesn't work, let me know, and I can correct this section, or provide setup help.

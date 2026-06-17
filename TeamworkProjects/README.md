# Teamwork Projects

## Description

It's time for teamwork projects, and you are responsible for making the teams. First, you will receive an integer - the count of the teams you will have to register. You will be given a user and a team (separated with "-"). The user is the creator of that team.

For every newly created team, you should print a message:

"Team {team Name} has been created by {user}!"

Next, you will receive a user with the team (separated with "->") which means that the user wants to join that team. Upon receiving the command: "end of assignment", you should print every team, ordered by the count of its members (descending) and then by name (ascending). For each team (disband teams as well), you have to print its members sorted by name (ascending). However, there are several rules:

•	If a user tries to create a team more than once, a message should be displayed:

"Team {teamName} was already created!"

•	The creator of a team cannot create another team - the message should be thrown:

"{user} cannot create another team!"

•	If a user tries to join a currently non-existing team, a message should be displayed:

"Team {teamName} does not exist!"

•	A Member of a team cannot join another team - the message should be thrown:

"Member {user} cannot join team {team Name}!"

•	At the end (after teams' report), teams with zero members (with only a creator) should disband, ordered by name in ascending other.

•	 Every valid team should be printed ordered by name (ascending) in this format:

"{teamName}:

- {create}

-- {member}..."

# Server

Directory for server app

<p>Server API</p>
<p>
	<ul>
		<li>	
			Establishing Connection:
			<br>Server : "Hello, identify yourself"
			Client : "Hello, @{1}" 1 - Username
			If username is taken add number after username eg.  
		</li>
		<li>
			Change username:
			Client : "USERNAME @{1}" 1 - New Username
		</li>
		<li>
			If Username is taken
			Server : "Username, @{1} is taken already"
		</li>
		<li>
			Sending Message Client -> Chatroom:
			Client : "MSG {1}" 1 - Message Content
		</li>
		<li>
			Sending Message Server -> Client:
			Server : "@{1} MSG {2}" 1 - Username who sent msg, 2 - Message Content
		</li>
		<li>
			Changing chatroom:
			Client : "JOIN #{1}" 1 - Chatroom name
		</li>
		<li>
			Sending Private messages Client -> Server:
			Client : "PRIVMSG @{1} {2}" 1 - Username to recive priv msg, 2 - Message Content
		</li>
		<li>
			Sending Private messages Server -> Client:
			Client : "@{1} PRIVMSG {2}" 1 - Username to who sent priv msg, 2 - Message Content
		</li>
		<li>
			Create chatroom:
			Client : "CREATEROOM #{1}" 1 - Chatroom name
		</li>
		<li>
			Mute/Unmute User:
			Client : "MUTE @{1}" 1 - Username to be mute/unmuted
		</li>
		<li>
			Kick User:
			Client : "KICK @{1}" 1 - Username to be kicked
		</li>
		<li>
			Ban/Unban User:
			Client : "BAN @{1}" 1 - Username to be banned/unbanned
		</li>
		<li>
			Ping request:
			Server : "PING"
			Ping response
			Client : "PONG"
		</li>
		<li>
			Register Account:
			Client : "REGISTER @{1} {2}" 1 - Username to register, 2 - password
		</li>
		<li>
			Log In:
			Client : "LOGIN @{1} {2}" 1 - Username to login, 2 - password
		</li>
	</ul>
</p>

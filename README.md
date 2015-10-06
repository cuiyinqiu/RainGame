# RainGame
* The Game
The example game code is designed to help rehabilitate patients after a stroke or brain surgery.
The game idea is simple - type in the number that's falling down.
It needs additional features and that's where you come in.

By the way, here's some early feedback from testing with real patients-
0. The numbers always fall vertically and don't reset back to the top if they fall past the bottom of the screen"
1. They don't like the flicker (hint:  you can use Zen.flipBuffer - see the PongGame)
2. It's possible to make the game die with an exception:
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0
	at java.lang.String.charAt(String.java:686)
	at RainGame.main(RainGame:41)
3. It would be nice if the game got harder and more interesting.
e.g Some more visual distractions.
4. It would be useful if you could skip the easiest levels.

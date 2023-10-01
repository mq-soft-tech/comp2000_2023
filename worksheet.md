# Task 0

Clone this repository (well done!)

# Task 1

Take a look at the two repositories:

  * (A) https://bitbucket.org/altmattr/personalised-correlation/src/master/
  * (B) https://github.com/Whiley/WhileyCompiler

And answer the following questions about them:

  * These repositories are at two different websites - github and bitbucket - what are these sites?  What service do they provide? Which is better?
  * Who made the last commit to repository A?
  * Who made the first commit to repository A?
  * Who made the first and last commits to repository B?
  * Are either/both of these projects active at the moment? 🤔 If not, what do you think happened?
  * 🤔 Which file in each project has had the most activity?

# Task 2

The repository you just cloned is a VSCode project, so lets work with it.  It currently will print "Hello World" message to the console when run.

You will find "Run" and "Debug" commands over the `main` method.  Try them out.  You can also trigger them with `F5` for "Debug" and `Ctrl-F5` for "Run"

Modify the application so that instead it prints

~~~~~
Red vs. Blue
~~~~~

# Task 3

Draw a 20 by 20 grid on a 720x720 window.  Each cell in the grid should be 35 pixels high and wide and the grid should be drawn 10 pixels off the top and left borders of the screen.  To do this, you should use the `Graphics` class from the Java libraries.  Be sure to consult the tips video for this task (it is a link in iLearn).  Without it, you will be very confused.

# Task 4

The "grid" has no identity - it is just drawn.  Later on we will need to do lots of things "with" this grid.  We will modify it and adjust it and ask it questions.  Our task here is to refactor the program to give this grid an identity.  We will create an object to represent the grid and will give that object its own `paint` method for drawing the grid.

We will also need to give an identity to each "cell" of the grid and make each cell responsible for it's own painting to the screen.

Modify the program to make these things happen.  Make a `Grid` class and a `Cell` class and organise them in a sensible way.  What fields and methods should each class have?

# Task 5

Anything that is a `JFrame` or `JPanel` can find out the position of the mouse using `getMousePosition`.  Modify your program so that mousing over a cell will "highlight" it.  Highlighted cells should be drawn in grey.  You may have to think about how you will get the mouse position from the place you can read it, to the place it is needed (the `paint` method of a `Cell` object).

# Task 6

Our `Cell` class is really a specialised rectangle and the Java API already has a `Rectangle` class.  Have `Cell` inherit from `java.awt.Rectangle` (https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html).  It will be good to call `super` in the `Cell` constructor and to use the `contains` method that comes in `Rectangle` instead of your own.  NB:  The `contains` we wrote was graceful when given a `null` pointer for the point, the one from `Rectangle` is not, you will need to "protect" it in some way.

# Task 7

Define a `Stage` class that can contain one `Grid` object and many `Actor` objects.  There must be three separate actors, each a subclass of an `Actor` superclass and each must have its own `paint` method.  The `paint` method must take a `Graphics` parameter and draw the actor on that graphic.  Have the `paint` method specified in the `Actor` class and have each subclass define it.

Since `Actors`s are drawing themselves, they need to know where they are on the screen so each will have a `Cell` field (that is set in the constructor) indicating where on the grid they are.

Have the program start with 1 grid and 3 actors:

  * Cat (drawn blue)
  * Dog (drawn yellow)
  * Bird (drawn green)

You can place each of these three `Actor` objects in grid locations of your choosing.

# Task 8

Have a close look at your `Cat`, `Dog` and `Bird` classes.  If they are anything like mine they are _all the same except for the colour they use_.  This repetition is "a bad thing" because if the same thing is done in three different places, we need to remember that updating one requires us to update all three.

Is there a place that you could put all the common parts?

🤔 Will this work given what you currently have?  If not, what would we need to change?

# Task 9

Draw a picture of the inheritance hierarchy you have created.  You should (loosely) use [UML notation](http://umich.edu/~eecs381/handouts/UMLNotationSummary.pdf) for your diagram.  You are using UML In this case, and all through this course, only for "a rough sketch of an idea".

# Task 10

Did you notice the repetition in the stage paint method?  All three actors have the `paint` method called on them.  In fact, we might later want to have dozens of actors on the stage at any one time, we don't want dozens of calls to `someone.paint(g);`.  What we need is a collection to store all the actors, something like an array that we can put them all in.  Then we can just loop over that array and call  `paint` on every element.  _I think_ we should use an `ArrayList` (https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html).  Notice it is a generic collection?  You will need to use generics to make this work.  Put all the actors in a single array list called `actors` and then loop over this list to paint them.  Once you have done that you might like to add more actors to the stage.

🤔 In my solution, I will declare the actors list as a `List` instead of an `ArrayList`.  Any idea why?  Why does this even work?

# Task 11

Turns out you are not able to use colours to distinguish the different types of actors!  You are going to need to draw little shapes to represent them.  You have been told you can't use images, you have to draw with Java2D primitives so the game can scale up and down as required.  The `Graphics` objects we are painting on know how to draw `Polygon`s (https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/Polygon.html) so that is what we are going to use.  However, one polygon is not enough for each actor, we need each to be made of a list of polygons.  We will use `ArrayList` again!  Have the `Color` field of `Actor` changed to a list of polygons and initialise each subclass to an appropriate set of polygons.  You might find the following polygons a useful starting point where `location` is the top-left point of the actor (but I am sure you can do better as well - share your designs on the forums!):

## Cat

~~~~~
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 11, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 15);
    ear1.addPoint(loc.x + 7, loc.y + 15);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 22, loc.y + 5);
    ear2.addPoint(loc.x + 26, loc.y + 15);
    ear2.addPoint(loc.x + 18, loc.y + 15);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 5, loc.y + 15);
    face.addPoint(loc.x + 29, loc.y + 15);
    face.addPoint(loc.x + 17, loc.y + 30);
~~~~~

## Dog

~~~~~
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 5, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 5);
    ear1.addPoint(loc.x + 5, loc.y + 15);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 20, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 15);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 8, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 25);
    face.addPoint(loc.x + 8, loc.y + 25);
~~~~~

## Bird

~~~~~
    Polygon wing1 = new Polygon();
    wing1.addPoint(loc.x + 5, loc.y + 5);
    wing1.addPoint(loc.x + 15, loc.y + 17);
    wing1.addPoint(loc.x + 5, loc.y + 17);
    Polygon wing2 = new Polygon();
    wing2.addPoint(loc.x + 30, loc.y + 5);
    wing2.addPoint(loc.x + 20, loc.y + 17);
    wing2.addPoint(loc.x + 30, loc.y + 17);
    Polygon body = new Polygon();
    body.addPoint(loc.x + 15, loc.y + 10);
    body.addPoint(loc.x + 20, loc.y + 10);
    body.addPoint(loc.x + 20, loc.y + 25);
    body.addPoint(loc.x + 15, loc.y + 25);
~~~~~

# Task 12

In this task we will add a method to the grid class that returns whatever cell is under a particular location.

Such a method needs to take in a `Point` and return back a `Cell`.  It will do a simple calculation to turn the x and y coordinates into the right array indices and look them up.

However, there are some areas on our stage where there are no cells, not to mention what to do when a `null` point is passed in!

So, we need a method that _might_ return a `Cell`.  What should it do when it can't find a cell?  Return `null`?  Definitely not!!!!  You are just asking for a asking for null-pointer exception if you do that.  Instead, we will use the `Optional` generic container (https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Optional.html).  

Add the following method to `Grid` that will return whatever cell is located around the point that is passed in.

~~~~~
public Optional<Cell> cellAtPoint(Point p)
~~~~~

🤔 How about we improve the `cellAtColRow` method now we know about optional containers?

🤔 Now that we have `cellAtPoint`, lets use it.  Grow the app window to 1024x720 so we have some clear space to the right of the grid.  In this space, put the details of whatever cell we are hoving over.  For example, you might put the type of cell that is located there, and what it's elevation is.  There are many ways to do this, but one good way is to call `cellAtPoint` while painting the stage and use the resulting cell information.

# Task 13

Our task now is to add the ability to read in configuration data from a file.  Someone else at the company (person A) has tried and has committed some broken code.

A file is kept in a "data" folder called "stage1.rvb". That file has one line for each configuration item.  We begin with just the character locations.

This all seems OK, but they are getting an error on the build.  Track down the error and fix it for them.

# Task 14

At the moment, the file reading code will thrown an exception if it fails to read a file.  You should change this code so that _it handles a thrown an `IOException`_.  This means you will have to think hard about what to do on a failed file read.

# Task 15

Add the following method to the `Grid` class

~~~~~
    /**
     * Takes a cell consumer (i.e. a function that has a single `Cell` argument and
     * returns `void`) and applies that consumer to each cell in the grid.
     * @param func The `Cell` to `void` function to apply at each spot.
     */
    public void doToEachCell(Consumer<Cell> func) {
      // Your job to add the body
    }
~~~~~

 Notice that the method accepts a `Consumer` functional interface.

 Now use this method to turn the `paint` method of the `Grid` class into a single line of code.  I.e. remove the double-nested loop and replace it with a call to `doToEachCell`.

🤔 Can you find anywhere else this is useful?  🤔🤔 Can you make any other useful _higher order_ methods?

# Task 16

Currently, the game loop (in `Main.run`) is running as fast as it can.   This just burns CPU cycles and heats up your computer needlessly.  We need to "fix" the frame-rate so we are not pointlessly burning CPU power. You can do this by asking the current thread to sleep for a period of time using `Thread.sleep`. We want the frame-rate to be about 50 frames per second, that means we need the loop to take 20ms to complete.

Sleeping a thread throws an `InterruptedException` so that will need a try/catch to deal with that. In fact, we don't care about the thread being interrupted so the catch block should just report the fact it was interrupted, print out a representation (via `toString`) of the exception that was thrown, and continue on as normal.

🤔 Can you even cause the exception to be thrown?

We have made the necessary changes for you, but please go through them to understand what we have done.

# Task 17

The team has signed off on the game concept and it is time to start developing the gameplay.  The big-wigs at your company have decided the world needs a new turn-based strategy game in the spirit of famicom-wars, so we will build one of those.  The first step is to put in the turns!  We are going to need:
  * Characters on different teams (Humans vs Bots)
  * A way for the player to move their characters
  * A way for the computer to move the bot characters.

We have made all the changes for you, but please go through each one to understand what we have done.  I.e. your job for this task is to understand the code we have added rather than adding any code of your own.  I strongly encourage you to explore this commit on github or in VSCode using the GitLens addon where you can see exactly what lines were added/deleted/modified in making these changes.

If you play the game now, you will see there are three stages:
  * player chooses character
  * player chooses new location
  * computer moves its characters

Notice that the computer move is random every time.  The bot AI (such as it is) asks for all cells that actor can move to, and picks one at random to move to.

# Task 18

We are going to build some (very rudimentary) strategy into this turn-based strategy game.  At the moment, all the actors on the bot team will just move randomly.  Instead, we want their strategy to be determined by _which row they are on_.  If they are on an even-numbered then they should move randomly, but if they are on an odd-numbered row they should _always move to the left-most possible location_.  Note:  if it is not clear yet, you need the strategy pattern so implement this.  Why is is the right pattern for this task?

🤔 Task 18a

This task sits to the side of our other tasks. It is an experiment. Even after we get an answer, we won't build upon that answer in later tasks, i.e. we will use the Task 18 answer as the basis for Task 19. However, I think this is the most interesting task so far, it is certainly worth your time.

Can we make the strategy pattern we just created disappear with lambda expressions? More concretely, can I get rid of the strategy interface and its subclasses and still have dynamic behaviour at run-time? If so, implement it and discuss the pros and cons of this approach compared to a "real" strategy pattern.

# Task 19

Head office have demanded that all iteration be done with the ["enhanced for loop" - aka the "for each" loop](https://web.archive.org/web/20180113011535/blogs.oracle.com/corejavatechtips/using-enhanced-for-loops-with-your-classes).  You don't mind, this is a sensible-enough plan.

You go on a hunt for loops that might need changing.  First you find the nested for-loops in the `Grid` constructor but head-office allow old-style loops for building arrays.  However, there are _two_ other places in `Grid.java` where forbidden-looping techqniques are used.  The team has a discussion and decides the best solution is to add an iterator to `Grid` so that the enhanced for loop can be used.

Your job is to create such an iterator.  It must iterate over every cell in the grid, but the order it does so does not matter.  Then you should use that iterator to replace all the forbidden loops in `Grid`.

# 🤔 Task 20

Your boss has suggested the following new gameplay:  When one character moves on top of another, if they are on *different* teams the character that is moving merges with the character that is in the `Cell` being moved to. The combined player's `moves` will be the maximum `moves` of the two original players. That new "double-character" could then move onto another character to make a "triple-character", etc.  Your boss also thinks that the composite pattern is the way to implement this.

The composite pattern can be quite variable, and it is easy to stray from it in situations where you think it might be useful.  Come up with a design for the above suggestion that _is as close as possible to the composite pattern_.  Explain where it differs and whether you think that matters.  Is your solution a valid composite?

# Task 21

Do you know how the enemies in [mario bros. move along with the music?](https://www.youtube.com/watch?v=nQy-eJALZI0_).  Your team wants something like that for your game.  They want all actors in the game to animate along with a "beat".  All actors should be syncronised and it should be possible to adjust the beat during development so it can sync-up with whatever music gets used.

You have done some thinking and decided that a good solution is to have an `AnimationBeat` class that always knows where you are up to in the beat.  Other objects can query this object to find out where they are up to in the beat and adjust their animation accordingly.

Just like in Mario Bros. the music goes in repeating phases, say one long one, then two short ones.  A colleague has created a basic class that might achieve this

~~~~~
public class AnimationBeat {
    private long started;
    private long a; // length of phase a
    private long b; // length of phase b
    private long c; // length of phase c
   
    public AnimationBeat(){
        started = System.currentTimeMillis();
        this.a = 5000;
        this.b = 500;
        this.c = 500;
    }

    // returns which phase the animation is currently in
    public char inPhase() {
        long currTime = System.currentTimeMillis();
        long rem = (currTime - started) % (a + b + c);
        if (rem > a + b) {
            return 'c';
        } else if (rem > a) {
            return 'b';
        } else {
            return 'a';
        }
    }

    // returns a number (out of 100) showing the percentage completion of this phase
    public long phaseCompletion() { 
        long currTime = System.currentTimeMillis();
        long rem = (currTime - started) % (a + b + c);
        if (rem > a + b) {
            return ((rem -a - b) * 100) / c;
        } else if (rem > a) {
            return ((rem - a) * 100) / b;
        } else {
            return rem * 100 / a;
        }

    }
}
~~~~~

Notice that is implmenents a beat with three phases (`a`, `b`, and `c`) and that phase `a` goes for 5 seconds while phases `b` and `c` go for half-a second each.

Your task is to incorporate this code into the project _using the most appropriate design pattern_ to do so.  You will need to make some changes to your colleague's code to ensure you match the pattern.  Then incorporate the animation beat somewhere in the application to demonstrate that it is working.

# Task 22

A collegue has provided you with a library as a [jar file](https://docs.oracle.com/javase/tutorial/deployment/jar/index.html). Jar files are a way of distributing a collection of already compiled java code. You can use the classes embedded in a jar file just as you would any class for which you have the source available.

Your collegue's library contains only one class, called `Motif`.  This class allows you to load an image from a file and then draw it anywhere on the screen in the color of your choice (similar to a grayscale image, but any color can be chosen, not just gray).  An example of its use has been added to `Stage` (look for the instance variable called `torch`).

We would like to use this class to add new player types to the game, however `Motif` is not a subclass of `Actor`.  Use the adapter pattern to add a new `Actor` type called `Horse`.  Note that because `Actor` is an abstract base class and not a Java interface it will be easier if you vary the pattern slightly from what is shown in the textbook.  You should use the image file located at `assets/Chess_tile_nl.png`.

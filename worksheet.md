# Task 0

Clone this repository (well done!)?
I made a change


# Task 1

Take a look at the two repositories:

  * (A) https://bitbucket.org/altmattr/personalised-correlation/src/master/
  * (B) https://github.com/Whiley/WhileyCompiler

And answer the following questions about them:
I mde this chnge

  * These repositories are at two different websites - github and bitbucket - what are these sites?  What service do they provide? Which is better?

  These are version control websites which allow the use of Git to create repositories that store, manage and version control your code and projects.

  They provide similar services, being the hosting of repositories and such, so in other words, the collobartion of software projects

  They are both suited to different things. GitHub is better for public repositories ass it allows many collaborators on these, but limits the amount on prvate repositories, while for bitbucket it is the opposite

  * Who made the last commit to repository A?
  THE last commit was on 2022-08-18 by Matt Roberts, which was commit ac9cab3

  * Who made the first commit to repository A?
  That was Jon Mountjoy

  * Who made the first and last commits to repository B?
Dave Pearce made the first and last commits. the first was made in 2010!

  * Are either/both of these projects active at the moment? 🤔 If not, what do you think happened?
  Both of these projects have not been updated since 2022, so they may not be in development any more. With these VCS systems it easy to make small changes or commits over a small amount time, and a lack of these for over a year means it is  safe to assume these projects are not actively updated anymore. The developers may even have moved to a new build

  * 🤔 Which file in each project has had the most activity?
  In WhileyCompiler Repository B , build.num had the most activity
  In Repository A, app.py had the most changes. I used 
  
  '' git log --name-only  --pretty=format: | sort | uniq -c | sort -nr '', found on stack overflow


# Task 2

The repository you just cloned is a VSCode project, so lets work with it.  It currently will print "Hello World" message to the console when run.

You will find "Run" and "Debug" commands over the `main` method.  Try them out.  You can also trigger them with `F5` for "Debug" and `Ctrl-F5` for "Run"

Modify the application so that instead it prints

~~~~~
Red vs. Blue
~~~~~


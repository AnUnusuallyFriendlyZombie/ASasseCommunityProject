# ASasse Community Project
## Setting up the workspace
#### Downloading software
This project is built using Java, specifically Java 8 (Perhaps Java 9 soon).  
You can download java here [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
I am building this using the eclipse IDE.  
You can download the latest version of eclipse here [here](http://www.eclipse.org/downloads/)  
You also need git to push your changes to the project.
You can download that [here](https://git-scm.com/downloads)  
Make sure to install all of this before continuing.
#### Setting up eclipse
Before pulling or pushing stuff, you need to have eclipse setup.  
When you first boot eclipse it should ask for a workspace location.  
If you don't know what to set this to, then set it to a folder named "workspace" next to the eclipse binary.  
You can mark it as the default workspace location if you don't wanna enter this info every time you boot eclipse.  
After this, you may be presented with a welcome screen, if so just click "Workspace" in the top right hand corner.  
At this point you need to create a new java project, you can name it whatever you want.  
After this if you navigate into the workspace folder, you should see the project you just created.  
If you open your project folder you should see the folders "src" and possibly "bin", if you see these.  
This is where we will setup the git repo.
#### Setting up the repo
Now that you're in the right folder, you should be able to right click and see the option "Git Bash Here", click on that.  
type "git init ." this will simply create a local git repo on your computer, it will not be linked to your online fork yet.  
next type "git pull <your fork url>" example: "git pull https://github.com/ASasseCreations/ASasseCommunityProject/"  
this will get all the files you forked from the project  
now type "git remote add origin <your fork url>" this makes it so you dont have to specify the url everytime you push.  
You can now close git, we will return to it later.
#### Running the program
You're not done setting up eclipse yet.  
Highlight your project and refresh it or press F5, all the files you forked should be visible.  
You cant run the project like this though, the res folder needs some additional treatment.  
Right click your project and select "Build Path -> Configure Build Path..."  
(Not done yet)

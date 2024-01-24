REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.app.sharedboardapp\target\base.app.sharedboardapp-1.4.0-SNAPSHOT.jar;base.app.sharedboardapp\target\dependency\*;
REM call the java VM, e.g,
java -cp %BASE_CP% eapli.base.app.sharedboardapp.Client
REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.app.sharedboardserver\target\base.app.sharedboardserver-1.4.0-SNAPSHOT.jar;base.app.sharedboardserver\target\dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% eapli.base.tcpSrv.Server
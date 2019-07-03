Running jdk-8

to use:

1-Run "javac MyMain.java"
2-Run "javah MyMain"
3-Run "sh build.sh" (compiles c code and sets proper jdk path for jni)
4-Run "java MyMain" (If error occurs see step 5)

*5-Run "export LD_LIBRARY_PATH="$(pwd)" (fixes library path issue, repeat step 4 afterwards)

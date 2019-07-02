#include <stdio.h>
#include "MyMain.h"

//void cfxn()
JNIEXPORT void JNICALL Java_MyMain_cfxn (JNIEnv *env, jobject obj)
{
printf("IN C FXN\n");
}

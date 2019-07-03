#include <stdio.h>
#include "MyMain.h"

//void cfxn()
JNIEXPORT jint JNICALL Java_MyMain_cfxn (JNIEnv *env, jobject obj)
{
return 2+5;
}

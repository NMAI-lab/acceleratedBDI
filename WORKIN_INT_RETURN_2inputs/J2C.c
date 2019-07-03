#include <stdio.h>
#include "MyMain.h"

//void cfxn()
JNIEXPORT jint JNICALL Java_MyMain_cfxn (JNIEnv *env, jobject obj,int n1,int n2)
{
return n1+n2;
}

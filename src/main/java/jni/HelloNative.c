#include "HelloNative.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_HelloNative_greeting(JNIEnv * env, jclass jcl){
    printf("Hello Native !\n");
    return;
}

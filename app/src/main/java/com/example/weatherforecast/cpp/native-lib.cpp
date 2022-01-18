//
// Created by NC on 1/18/2022.
//

#include <jni.h>
#include <string>
extern "C" JNIEXPORT jstring
extern "C" JNICALL
Java_com_package_name_Keys_apiKey(JNIEnv *env, jobject object) {
    std::string api_key = "60c6fbeb4b93ac653c492ba806fc346d";
    return env->NewStringUTF(api_key.c_str());
}

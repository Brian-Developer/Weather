"# Weather" 
Weather Application Explanation 

1. Application was created by Android Studio with Kotlin programing language. 
	+ Only 1 activity contains all fragments.
2. App architecture : MVVM
	+ api folder: connect with server to retreive data.
	+ adapter folder: display response data from server into recycleView.
	+ ui folder: contains fragment and viewModel files.
	+ Library: Gson, Retrofit, Gson Converter, OkHttp.
3. Please create native-lib.cpp file under cpp folder with this code:
  + extern "C" JNIEXPORT jstring

  + JNICALL
  + Java_com_example_weatherforecast_model_Keys_apiKey(JNIEnv *env, jobject object) {
    + std::string api_key = "api_key";
    + return env->NewStringUTF(api_key.c_str());
  + }
4.
  + adapter can be crash, how to avoid and good reuse code? -> Sorry, I still can't handle all cases that make adapter crashed since any errors happen.
  + ViewModel why need more gson parsing? -> Convert ResponseBody -> ErrorResponse object to display error. This is my way for it, please guide if any mistakes 
  + I did the unit simple unit test for this application, I know still more to do (api test, UI test). But in my case, it take time to research. So it couldn't complete 100% for this application.
 
5. Checklist of item has done: 1, 2, 3, 4, 6a, 7, 8

THANKS FOR THIS TEST & GUYS CAN IMPROVE ME IF I GOT ANY MISTAKES

# react-native-dark-chatview
Inverted Chat for Android

Installation:

    npm install git+https://git@github.com/darknessproduction/react-native-dark-chatview.git

../android/settings.gradle


    include ':react-native-dark-chatview'
    project(':react-native-dark-chatview').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-dark-chatview/android')


../android/app/build.gradle

    compile project(':react-native-dark-chatview')
    implementation fileTree(dir: "libs", include: ["*.jar"])
    compile 'com.android.support:appcompat-v7:26.0.0'
    implementation "com.facebook.react:react-native:+"  // From node_modules
    
    
RN < ~0.53
Make sure new DarkChatViewPackage() is in your MainApplication.java

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new DarkChatViewPackage()
      );
    }

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
    
    
if RN < 0.53

Make sure new DarkChatViewPackage() is in your MainApplication.java

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new DarkChatViewPackage()
      );
    }

Code Example

    import React from "react";
    import { View, Image, Text, FlatList, TouchableOpacity, Platform, Dimensions } from "react-native";
    import { DarkChatView } from "react-native-dark-chatview";

    export default class MessageExample extends React.Component {
      constructor(props) {
        super(props);
        this.state = { 
          messages: [
            {id: 1, user: 'Ilya', create_date: 1567810220, message: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.'},
            {id: 2, user: 'Artem', create_date: 1567810220, message: 'Lorem Ipsum has been the industrys standard dummy text ever since the 1500s.'},
            {id: 3, user: 'Alexey', create_date: 1567810220, message: 'when an unknown printer took a galley of type and scrambled it to make a type specimen book.'},
            {id: 4, user: 'Alexey', create_date: 1567810220, message: 'It has survived not only five centuries,'},
            {id: 5, user: 'Alexey', create_date: 1567810220, message: 'but also the leap into electronic typesetting,'}
          ].reverse()
        }
      }
        addMsg = (addType) => {
            let nv = this.state.messages,
                secs = Math.floor(new Date().getTime()/1000);

            let len = nv.length+1;
            let new_mgs = [{id: len, user: 'Artem', create_date: secs, message: 'New message created in '+secs}, ...nv];

            this.setState({
              messages: new_mgs
            })

        }

      render() {
        return (
        <View style={{flex: 1}}>
          {Platform.OS == 'android' ? 
          <DarkChatView 
          inverted={true}
          ref={ref => (this.chat = ref)}
          style={{height: Dimensions.get('window').height-80}}>
            {this.state.messages.map((msg, index) =>
            <View key={'msg-'+msg.id} style={{ flex: 1, flexDirection: "row", alignItems: "center", transform: [{scaleY: -1}], marginBottom: 10, backgroundColor: '#ccc', paddingVertical: 10, paddingHorizontal: 20 }}>
              <View style={{ marginLeft: 4 }}>
                <Text style={{ fontSize: 14, color: '#000' }}>
                  <Text style={{fontWeight: 'bold'}}>{msg.id}</Text> {msg.message}
                </Text>
              </View>
            </View>
            )}
          </DarkChatView>
          : 
          <FlatList />
        }
                    <View style={{flexDirection: "row", borderWidth: 2, borderColor: '#3d9d9d9', width: '100%', height: 80}}>
                        <TouchableOpacity onPress={() => this.addMsg()} style={{width: '100%',height: 80}}>
                            <Text style={{color: '#000', fontWeight: "bold", paddingTop: 20, paddingLeft: 20}}>Add new message</Text>
                        </TouchableOpacity>
                    </View>
          </View>
        );
      }

    }

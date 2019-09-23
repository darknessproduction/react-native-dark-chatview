require "json"

package = JSON.parse(File.read(File.join(__dir__, "../package.json")))

Pod::Spec.new do |s|
  s.name         = "RNDarkChatView"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = "https://github.com/darknessproduction/react-native-dark-chatview"
  s.license      = package["license"]
  s.author       = { "darknessproduction" => "ilya@sarzhevsky.com" }
  s.platforms    = { :ios => "7.0", :tvos => "9.0" }
  s.source       = { :git => "https://github.com/darknessproduction/react-native-dark-chatview.git", :tag => s.version }
  s.source_files  = "DarkChatView/**/*.{h,m}"
  s.requires_arc = true

  s.dependency "React"
end

# MyRestaurants

#### An Android application that searches for restaurants through the Yelp API by zipcode, 04/04/2016

#### By Midori Bowen

## Description

MyRestaurants is an Android application where users can search for restaurants, by zipcode, through the Yelp API. Users can click on restaurants that show on the list and see more details. The User can click on the Yelp link and go to the Yelp app or Yelp.com in their browser. The User can click on the phone and call the number listed. The User can click the address and look it up in a Map app.
The User can click 'Save Restaurant' and it will appear on their My Saved Restaurants list. In My Saved Restaurants, the User can change the order of the restaurants listed and delete restaurants from their saved list.

## Setup/Installation Requirements
You will need the following programs installed on your computer.
* Android Studio
* Java JDK 8+
* Android SDK

### To Run MyRestaurants
* In a terminal window, navigate to ~/AndroidStudioProjects
* Run `git clone https://github.com/midoribowen/MyRestaurants.git`
* Navigate to ~/AndroidStudioProjects/MyRestaurants
* Run on either an emulator or an Android OS Device connected to a computer

##### To set up an emulator
* Select Run > Run 'app'
* Click 'Create New Emulator'
* Select the device you would like to emulate (Recommended: Nexus 6)
* Select the API level you would like to run - click 'Download' if not available (Recommended: Marshmallow - ABI: x86)
* Select configuration settings for emulator
 * Recommended:
 * Scale: 4dp on device = 1px on screen
 * Camera - Front: Webcam()
 * Camera - Back: Webcam()
* Click 'Finish' and allow Emulator to run

##### To Run on an Android OS Device
* Connect the device to the computer through its USB port
* Make sure USB debugging is enabled (this may pop up in a window when you connect the device or it may need to be checked in the phone's settings)
* Select Run > Run 'app'
* Select the device (If it does not show, USB debugging is probably not enabled)
* Click 'OK'
* Wait... it takes a little while the first time

## Known Bugs
None currently!

## Support and contact details

Contact through GitHub username: midoribowen

## Technologies Used

AndroidStudio, Firebase, AndroidSDK, Java v1.8, Gradle

### License
Copyright (c) 2016 Midori Bowen

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

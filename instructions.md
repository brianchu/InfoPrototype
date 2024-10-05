Act as a Android expert. Here's the job description, write out a complete Android TV app fulfill the job description completely.

I am looking to build a simple yet robust Android TV app aimed at analyzing the connectivity status of set-top boxes. 

- Develop an Android TV app with 5 main steps:
  + Show a screen of a button to start the test. The button can also use to show restart to restart the flow and also when error occurs.
  + Record set-top box network information (e.g., connectivity type, WiFi status).
  + Run connectivity tests: ping, HTTP download, and upload to different endpoints.
  + Display a form to gather user identification data.
  + Send the collected data to a provided endpoint.
- Provide feedback to users on each step within the app. for now, use a big font text as it will look good at TV.
- Request and manage necessary permissions for the app.
- Show a splash screen when app starts. (Use splash screen API from https://developer.android.com/develop/ui/views/launch/splash-screen)
- Use any open source library to ease the work. Do not reinvent the wheel.
- Use Compose and Kotlin

**Deliverables**
- Complete source code of the Android TV app.
- Instructions on how to compile the app.
- APK file ready for Play Store upload.
- Keystore used for signing the APK.

**What we can assume already exist and provide to us:**

- API endpoints for connectivity tests.
- API endpoint to save collected information.
- Designs for the app’s screens (initial, steps, form, and end screens). Assume any of them when list out the detail codes.
- Images for splash screen, icons, banner, and logos.
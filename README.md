# Test app for applying to Alif company

Technical stack
- Clean Architecture
- MVVM
- DI (Hilt)
- Jetpack Libraries
- Jetpack Compose
- Kotlin Coroutines
- Material Design
- Room
- Git
- Retrofit
- Flow
- Coil
- Build.gradle.kts

# Notes

- Api does not support pagination, but the task says that I should use pagination by 3 elements.
  I used paging library with room and get data from there.
  First, I save the data to the DB and display it to the presentation layer
- Api also doesn't open web site for the given url which in [Guide].
  (In the task written that, i should open this url in webView)
  I found the endpoint which takes full info about [Guide] using his id. 
  I decided to show this data in [DetailsScreen]
  Now on item click my app will navigate to the Details Screen and shows fetched data.
  Each network response is stores in Database.
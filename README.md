# Overview
WeatherRadar is an Android project for showing cities weather info using OpenWeather API (https://openweathermap.org/api). Project is written in Kotlin and applies principles of Clean Architecture.

<img src="https://serving.photos.photobox.com/6553462145f50daf1455fca0e94679b9ebc1d11f5e74c2572d0ae6fe48c95bd748298e3f.jpg" width="200" height="400" /> <img src="https://serving.photos.photobox.com/40576490d7e8524883b7a79e4b06f29f54b89cca2fb541e8bbdb2a892b4598e12f92ca53.jpg" width="200" height="400" />

###### ***Project for demonstartion purpose***

### Features
- Showing weather info according to current user's location (city).
- Showing weather info for the upcoming 7-days of the same city.
- Searching for other cities weather info.
- Ability to add to cities favorite list.
- Screen to view cities favorite list.
- Configure between fahrenheit and celsius units.

### Model-View-Intent (MVI) Architecture
Project implements MVI Architecture

<img src="https://miro.medium.com/max/841/1*u6DY_91Uu6RhwPfaeftggQ.png" width="700" height="400" />

### Clean Architecture
For applying single responsiblity and seperation of concerns principles, the project consists of three main modules;
- presentation module (app module); contains Android specific components, UI(activities, fragments), viewmodels and contracts(for intents and viewstates)
- data module; contains repositories and data sources implementations (database definition and its DAOs / network APIs definitions), mappers(for remote and item models)
- domain module; contains the definitions of the business logic of the app and the data model,

### Multi-Modular
Project is multi-modular, with a single source for dependencies management (buildSrc->Dependencies)

### Dependency Injection
Koin framework (https://github.com/InsertKoinIO/koin) is used for Dependency Injection. Koin modules are defined under presentation->base->di

### Kotlin Coroutines
Coroutines (https://kotlinlang.org/docs/coroutines-guide.html) is used for asynchronous programming.

### Networking layer
Retrofit (https://square.github.io/retrofit/) and OkHttp (https://square.github.io/okhttp/) are used for networks requests/intercept.

### Room Database
Room DB (https://developer.android.com/jetpack/androidx/releases/room) is used for caching/saving user's favorites.

### Memory leaks detecting
Leak Canary (https://github.com/square/leakcanary) is used for detecting memory leaks.

### Product flavors
Project consists of two different enviroments dev and production.

-------

##### Future Work
- Using Workmanager to periodically sync application data with the server and send timely notifications.

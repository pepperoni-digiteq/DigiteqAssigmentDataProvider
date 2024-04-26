Write an app that will read a data from this library, process it and display the result.

`DataProviderApi` will provide you with series of data sets. Each data set is an array of `n` non-negative integers representing an elevation map where the width of each bar is `1`. You need to compute how water will be trapped in each terrain after raining, and display it on the screen. 

App should consist of 2 screens:

 1. A list of all the processed data sets. Each element should consist of index (in order it was received from DataProvider) and time it took to compute the result (milliseconds to 5 decimal places). For example:
```
    | 1            0.00342 |
    | 2            0.00411 |
```
  Clicking on the item will open a detail screen.
    
 3. Detail screen that will display the elevation map and trapped water. Use the size of the screen to display data in full, without any scrolling. The representation doesnt need to be graphically advanced and can be as simple as black and blue squares representing terrain and water respectively. For example:

    ![image](https://github.com/pepperoni-digiteq/DigiteqAssigmentDataProvider/assets/165902639/38b0a544-584e-4aeb-9f65-009e79de7c56)


DataProvider library is equipt with `koinDPModule` and `DaggerDPModule`, to retrieve `DataProviderApi` using `koin`, `Dagger2` or `Hilt` at your choosing. Its essential to use DI, because its the only way to receive all the necessary data in your app.


To add DataProvider library to your project you need to do:
1. In your project level `build.gradle` or `settings.gradle`:
   ```
   repositories {
       mavenCentral()
       maven {
           url = uri("https://jitpack.io")
       }
   }
   ```

2. In your app level `build.gradle`:
   ```
   implementation("com.github.pepperoni-digiteq:DigiteqAssigmentDataProvider:1.4")
   ```

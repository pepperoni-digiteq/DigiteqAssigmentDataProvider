### Write an app that will read a data from this library, process it and display the result.

`DataProviderApi` will provide you with series of data sets. Each data set is a list of `n` non-negative integers representing an elevation map where the width of each bar is `1`. You need to compute how water will be trapped in each terrain after raining, and display it on the screen. 

### App should consist of 2 screens:

 1. **A list of all the processed data sets.** Each element should consist of name (included in the data set) and time it took to compute the result (milliseconds to 5 decimal places). For example:
```
    | Warsaw            0.00342 |
    | Prague            0.00411 |
```
  Clicking on the item will open a detail screen.
    
 3. **Detail screen that will display the elevation map and trapped water.** Use the size of the screen to display data in full, without any scrolling. The representation doesnt need to be graphically advanced and can be as simple as black and blue squares representing terrain and water respectively. For example:

    <img width="457" alt="image" src="https://github.com/pepperoni-digiteq/DigiteqAssigmentDataProvider/assets/165902639/2b5b99f5-52bc-410d-ad8e-3bd7c4bf48ae">



DataProvider library is equipt with `koinDPModule` and `DaggerDPModule`, to retrieve `DataProviderApi` using `koin`, `Dagger2` or `Hilt` at your choosing. Its essential to use DI, because its the only way to receive all the necessary data in your app.

In order to test your algorithmic solution use `assertAmount { ... }` tool from DataProvider library. **You must have a unit test in your project that passes this assertion.**


### To add DataProvider library to your project you need to do:
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
   implementation("com.github.pepperoni-digiteq:DigiteqAssigmentDataProvider:1.5")
   ```

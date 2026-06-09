

---

# Purpose of the Application

The purpose of this application is to help users store and manage weekly weather conditions. The app allows users to:

* Enter weather information for each day.
* Store data using arrays.
* Calculate the average weekly temperature.
* View detailed weather information.
* Navigate between multiple screens.

The app was developed in Kotlin using Android Studio.

---

# Application Features

## Splash Screen

The splash screen includes:

* App logo
* App name
* Student details
* Navigation buttons

Users can:

* Start the app
* Exit the app

---

## Main Screen

The main screen allows users to:

* Enter minimum temperatures
* Enter maximum temperatures
* Enter weather conditions
* Save weather data
* Calculate average weekly temperature
* Clear entered data
* Navigate to the detail screen

The application uses loops and arrays to process weather information.

---

## Detailed View Screen

The detailed view screen displays:

* Day name
* Minimum temperature
* Maximum temperature
* Weather condition

---

# Arrays Used

The app uses parallel arrays:

```kotlin
val days = arrayOf(...)
val minTemps = IntArray(7)
val maxTemps = IntArray(7)
val conditions = Array(7) { "" }
```

---

# Loop Used

```kotlin
for (i in maxTemps.indices) {
    total += (minTemps[i] + maxTemps[i]) / 2
}
```

This loop calculates the weekly average temperature.

---

# Error Handling

The app validates:

* Empty input
* Invalid numbers
* Incorrect day indexes

Toast messages are displayed when errors occur.

---

# Logging

The application uses Log.d() and Log.e() to demonstrate debugging and logging.

---

# Pseudocode

START APPLICATION

DISPLAY Splash Screen

IF Start Button clicked
OPEN Main Screen
ENDIF

IF Exit Button clicked
CLOSE Application
ENDIF

DECLARE arrays:
days
minTemps
maxTemps
conditions

INPUT weather data

STORE data in arrays

LOOP through arrays
CALCULATE average temperature
END LOOP

DISPLAY average temperature

IF View Details clicked
OPEN Detail Screen
ENDIF

DISPLAY detailed weather information

END APPLICATION

---

# Screenshots

Add screenshots here:

1. Splash Screen
2. Main Screen
3. Detail Screen
4. Error Messages

---

# GitHub Actions

GitHub was used for:

* Version control
* Code backups
* Commit history
* Project management

---

# Conclusion

This application successfully demonstrates:

* Kotlin programming
* Arrays
* Loops
* Error handling
* Navigation between screens
* Android UI design

This document provides a technical overview of the Nooro Weather Tracker Android application.
It details the project setup, architecture, technology stack, and implementation guidelines for developers.

## 1. Project Setup and Dependencies

This project is built using modern Android development tools and libraries. Ensure you have the following set up:

*   **IDE:** Android Studio (latest stable release, updated beyond 2023.1.1 recommended).
*   **Programming Language:** Kotlin 2.0.0.
*   **SDK Configuration:**
    *   `minSdkVersion 24` (Android 7.0 - Nougat)
    *   `targetSdkVersion 34` (Android 14 - Upside Down Cake)
    *   `compileSdkVersion 34`
*   **Build System:** Gradle (latest version compatible with the Android Studio version).
*   **Internet Connection:** Required for downloading project dependencies and fetching weather data from the API.

## 2. Technology Stack and Architecture

The application follows the **Model-View-ViewModel (MVVM)** architectural pattern, promoting a clean separation of concerns, testability, and maintainability.

## 3.  Core Libraries

*   **Jetpack Compose:** Declarative UI framework for building user interfaces.
*   **Dagger Hilt:** Dependency injection framework for managing and injecting dependencies.
*   **Room:** Persistence library for local data storage (SQLite).
*   **Retrofit:** Type-safe HTTP client for network communication.
*   **Coil:** Image loading library for efficient and optimized image handling.
*   **Kotlin Coroutines and Flow:** For asynchronous operations and reactive data streams.

## 4. Build and Run Instructions

1. **Clone the Repository:** Clone the project repository from the version control system.
2. **Open in Android Studio:** Open the project's root directory in Android Studio.
3. **Sync Project with Gradle Files:** Ensure all dependencies are downloaded and synced by clicking "Sync Project with Gradle Files" in the toolbar.
4. **API Key:** Obtain a weather API key from the chosen weather data provider and replace the placeholder `YOUR_API_KEY` in the code (likely in a `Constants` file or the Retrofit service interface) with your actual API key.
5. **Connect Device/Emulator:** Connect a physical Android device with USB debugging enabled or launch an Android emulator (API level 24 or higher).
6. **Build and Run:** Select the appropriate run configuration (usually `app`) and click the "Run" button in Android Studio.

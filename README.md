
# News Recommend
News Recommend is an Android application designed to use machine learning to recommend articles from the internet based on user preferences. The app currently fetches articles by category using an external API, with plans to incorporate advanced personalization features.





## Features

- Modern UI with Material Design 3: A clean interface with edge-to-edge support and Compose UI.
- Article Fetching by Category: Currently supports fetching articles in predefined categories such as "technology."
- Toast Notifications: Informs users of successful or failed article retrievals.



## Built With

 - Kotlin
 - Android Jetpack Compose
 - Retrofit for networking
 - Material Design 3



## Getting Started

To get a local copy up and running, follow these simple steps.

- Prerequisites

- Ensure you have the following installed:

- Android Studio Arctic Fox or later

- Android SDK version 21 or higher

- Internet access

## Installation

Clone the repo:

git clone https://github.com/yourusername/news-recommend.git

Open the project in Android Studio.

Get your API key from News API, and replace the placeholder key in MainActivity:

val apiKey = "YOUR_API_KEY_HERE"

Build and run the project on an Android device or emulator.

## Usage

Launch the app on your device.

View a greeting message on the home screen.

Articles will automatically fetch for the "technology" category.

If successful, a toast will notify you of the fetched articles.

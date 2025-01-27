
# News Recommend
News Recommend is an Android application designed to recommend articles from the internet based on user preferences. The app currently fetches articles by hardcoded categories and displays clickable titles that open the articles in the default browser. The project also includes plans to integrate advanced personalization features powered by a Python machine learning model.




## Features

-Modern UI: A clean and simple interface.

-Article Fetching by Category: Fetches 8 articles from hardcoded categories (e.g., "sports") and displays their titles.

-Clickable Article Titles: Users can click on a title to open the article in their default browser.

-Future Personalization: Planned integration of a Python machine learning model to recommend articles based on region, age, and gender.

-The model will analyze user reading habits and demographics to offer personalized suggestions.

-Articles will become more tailored as the user engages with specific categories.



## Built With

 - Kotlin: Core language for Android development.
-Android View System: Directly using XML layouts instead of Jetpack Compose.
-Retrofit: For networking and API integration.




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

Build and run the project on an Android device or emulator.

## Usage

Launch the app on your device.

Articles will automatically fetch from the default hardcoded category (e.g., "sports").

View the list of 8 article titles.

Click on a title to open the article in your default browser.

## Planned Updates

-Python Machine Learning Integration:
 Build a Python-based recommendation model to analyze user preferences.
 Recommend articles based on region, age, and gender.
 Dynamically adjust recommendations as users read more articles.

-Dynamic Categories:
 Transition from hardcoded categories to dynamic category selection in the app.

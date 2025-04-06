# Spam Detector Android App

An Android application that detects and deletes SMS spam messages while notifying the user. Compatible with Android 8.0 (Oreo) and above.

## Features

- **SMS Spam Detection & Auto-Deletion**:
  - Detects incoming spam messages based on predefined rules
  - Automatically deletes identified spam messages

- **User Notifications**:
  - Notifies user when a spam message is deleted
  - Customizable notification messages

- **Detailed Reports**:
  - Weekly, monthly, quarterly, half-yearly, and yearly reports
  - Visual data representation (graphs and tables)

- **User Management**:
  - Login screen with app feature highlights
  - Whitelist management
  - False positive reporting

## Technical Specifications

- **Minimum SDK**: 26 (Android 8.0 Oreo)
- **Target SDK**: 33 (Android 13)
- **Architecture Components**:
  - BroadcastReceiver for SMS detection
  - Room Database for message storage
  - Material Design components
  - ViewPager2 for reports

## Permissions Required

- READ_SMS
- RECEIVE_SMS
- DELETE_SMS
- POST_NOTIFICATIONS

## Installation

1. Clone the repository
2. Open in Android Studio
3. Build and run on device/emulator

## Screens

- Login Screen
- Main Screen (Spam List)
- Reports Screen
- Settings Screen

## Future Enhancements

- Machine learning integration for improved spam detection
- Cloud sync for whitelist/blacklist
- Multi-language support
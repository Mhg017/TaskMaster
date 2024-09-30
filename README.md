# TaskMaster
Introduction
TaskMaster is a task management mobile application developed for Android devices. It provides users with a robust and easy-to-use platform for managing their daily tasks, setting priorities, and receiving timely notifications about due tasks. TaskMaster also allows users to operate in offline mode and includes multi-language support, which is especially useful for diverse user bases.

This README outlines the key aspects of the application, its architecture, design considerations, and how GitHub is utilized for version control and CI/CD (Continuous Integration and Continuous Deployment) through GitHub Actions.

Purpose
The main purpose of TaskMaster is to simplify task management for users by providing a feature-rich application that can be used to create, update, and track tasks. The app is designed to:

Offer seamless task management in online and offline modes.
Allow users to sign in using Google authentication.
Enable push notifications for task reminders.
Support multiple languages, starting with English and Afrikaans.
Sync task data to a remote server using Retrofit.
The goal is to provide users with an intuitive and accessible platform for organizing their daily work and personal tasks, while keeping them notified and connected.

Design Considerations
The design of TaskMaster was carefully thought out to ensure user-friendliness, scalability, and reliability. Below are the main design considerations:

1. User-Centered Design
Simple and Intuitive UI: The app's interface is designed to minimize complexity, providing users with an easy-to-navigate layout and task management features.
Accessibility: We considered accessibility in the design by including large, easy-to-read fonts, appropriate color contrasts, and icons.
Offline-First Approach: Users should be able to use the app in an offline mode, with tasks syncing to the cloud when the connection is restored.
2. Data Storage and Syncing
The app uses RoomDB for local data storage, ensuring that users can access their tasks offline. When online, the app syncs with a backend server using Retrofit to update tasks.
3. Security
Authentication is handled by Firebase Authentication using Google Sign-In, which provides a secure and reliable way to manage user accounts.
4. Push Notifications
Push notifications are implemented using Firebase Cloud Messaging (FCM) to remind users about their upcoming or overdue tasks.
5. Multi-Language Support
TaskMaster supports both English and Afrikaans. Users can switch between languages from within the app.
6. Architecture
MVVM (Model-View-ViewModel) architecture was chosen to separate the data logic from UI elements, making the app more maintainable and easier to test.
Features
Task Management: Create, edit, delete, and view tasks.
Task Prioritization: Set priorities for tasks (e.g., high, medium, low).
Offline Mode: Work with tasks even when not connected to the internet.
Push Notifications: Get reminders for tasks nearing their due dates.
Google Authentication: Sign in securely using Google.
Multi-Language Support: Supports both English and Afrikaans.
Syncing: Task data is synced to a backend server when online.
Tech Stack
Frontend: Android (Kotlin, View Binding)
Backend: REST API using Retrofit
Database: RoomDB (Offline Mode)
Authentication: Firebase Authentication (Google Sign-In)
Push Notifications: Firebase Cloud Messaging (FCM)
Build Tools: Gradle, Android Studio
Offline Mode
TaskMaster uses RoomDB to store tasks locally. In offline mode, users can still create, edit, and view tasks. Once the app detects an active internet connection, it automatically syncs all pending tasks to the server using Retrofit.

To ensure data consistency, the app uses a queuing system to sync data changes with the server, updating the backend as soon as the device goes online.

Push Notifications
Push notifications are integrated using Firebase Cloud Messaging (FCM). Notifications are sent to users as reminders for upcoming or overdue tasks. This helps users stay on top of their task lists even if they aren't actively using the app.

Push notifications are triggered by the server, which keeps track of task due dates. Users can customize how and when they want to receive notifications.

Multi-Language Support
The app supports both English and Afrikaans. A user can switch languages through a settings menu. All strings are localized in the app, and additional languages can be easily added in the future.

TaskMaster detects the system language upon the first app launch. Users also have the option to manually select their preferred language from within the app's settings.

package com.example.taskmaster

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    // This method will be triggered when a message is received while the app is in the foreground
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Handle the FCM message here.
        Log.d("FCM", "From: ${remoteMessage.from}")

        // Check if the message contains data payload
        remoteMessage.data.isNotEmpty().let {
            Log.d("FCM", "Message data payload: ${remoteMessage.data}")
        }

        // Check if the message contains a notification payload
        remoteMessage.notification?.let {
            Log.d("FCM", "Message Notification Body: ${it.body}")
        }
    }

    // This method is triggered whenever a new token is generated (for instance, after the app is freshly installed)
    override fun onNewToken(token: String) {
        Log.d("FCM", "Refreshed token: $token")
        // Send the token to your server or save it locally
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String?) {
        // TODO: Implement this method to send the token to your server.
        Log.d("FCM", "Sending token to server: $token")
    }
}

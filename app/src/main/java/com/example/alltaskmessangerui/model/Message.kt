package com.example.alltaskmessangerui.model

import java.io.Serializable

data class Message(var profile:Int, var fullName: String, var message: String, var isOnline: Boolean = false) : Serializable

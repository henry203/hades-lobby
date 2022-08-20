package com.hadeslobby.lobbyv2.utils

interface StatusResponse {
    val playerOnline: Int
    val playerMax: Int
    val playerSample: Map<String?, String?>?
}
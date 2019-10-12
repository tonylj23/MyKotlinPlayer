package com.example.myplayer.service

interface IService {
    fun updatePlayState()
    fun isPlaying(): Boolean?
}
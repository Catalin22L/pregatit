package com.globant.mylibrary

enum class Mood(val moodMessage : String) {
    HAPPY("happy"),
    ANGRY("angry"),
    EXCITED("excited"),
    SCARED("scared"),
    SAD("sad");

    companion object {

        fun react(mood : Mood) :String {
            return when(mood) {
                HAPPY -> "I am happy"
                ANGRY-> "I am angry"
                EXCITED-> "I am excited"
                SCARED-> "I am scared"
                SAD-> "I am sad"
            }
        }

        fun react2(mood : Mood) : String = mood.moodMessage
    }
}
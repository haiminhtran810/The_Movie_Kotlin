package vn.home.app.themoviekotlin.data.source.local

interface PrefHelper {
    fun clear()
    fun getAccessToken():String
    fun setAccessToken(token:String)

}
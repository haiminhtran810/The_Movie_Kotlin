package vn.home.app.themoviekotlin.data.source.local

import android.content.Context

class AppPrefs constructor(mContext: Context) : PrefHelper {

    private var sharedPreferences = mContext.getSharedPreferences(mContext.packageName, Context.MODE_PRIVATE)

    companion object {
        private const val ACCESS_TOKEN = "access_token"
    }

    override fun setAccessToken(token: String) = sharedPreferences.edit().putString(ACCESS_TOKEN, token).apply()

    override fun getAccessToken(): String = sharedPreferences.getString(ACCESS_TOKEN, "")

    override fun clear() = sharedPreferences.edit().clear().apply()
}
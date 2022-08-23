package com.deyber.movie.core.sesion

import android.content.Context
import android.content.SharedPreferences
import com.deyber.movie.data.network.response.SessionResponse
import javax.inject.Inject

class SessionManager @Inject constructor(val context: Context) {

    companion object{
        const val preferenciesName="spMovie"
        const val sp_session:String = "session"
    }

    private var sp : SharedPreferences = context.getSharedPreferences(preferenciesName,Context.MODE_PRIVATE)

    fun saveSession(session: SessionResponse) = sp.edit().putString(sp_session, session.session_id).apply()


    fun getSession():String?=sp.getString(sp_session,null)
}
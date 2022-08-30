package com.deyber.movie.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deyber.movie._utils.constants.RetrofitConstants
import com.deyber.movie.core.Resouce.Resource
import com.deyber.movie.core.sesion.SessionManager
import com.deyber.movie.data.network.request.LogRequest
import com.deyber.movie.data.network.response.SessionResponse
import com.deyber.movie.data.network.response.TokenBody
import com.deyber.movie.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: Repository, private val sessionManager: SessionManager): ViewModel() {

    private val response = MutableLiveData<Resource<SessionResponse>>()

    fun getSession() = response

    fun onCreated(){
        response.postValue(Resource.Loading())
        if(sessionManager.getSession()!=null){
            val session = SessionResponse(true, sessionManager.getSession()!!)
            response.postValue(Resource.Success(session))

        }else{
            createSession()
        }
    }

    fun createSession(){
        viewModelScope.launch {
            try{
                val token = repository.getToken()
                if(token!=null){
                    try{
                        val validaToken = repository.validateToken(LogRequest(RetrofitConstants.user, RetrofitConstants.pass, token.token))
                        if(validaToken!=null){
                            try{
                                val session:SessionResponse? = repository.getSession(TokenBody(validaToken.token))
                                if(session!=null){
                                    sessionManager.saveSession(session)
                                    response.postValue(Resource.Success(session))
                                }else{
                                    response.postValue(Resource.Failure("Error: Session nulo", null))
                                }
                            }catch (io:Exception){
                                response.postValue(Resource.Failure("Error: Solicitud Session",io))
                            }
                        }else{
                            response.postValue(Resource.Failure("Error: Token no validado", null))
                        }
                    }catch (io:Exception){
                        response.postValue(Resource.Failure("Error: Solicitud de  validacion token", io))
                    }
                }else{
                    response.postValue(Resource.Failure("Error: Token nulo", null))
                }

            }catch (io:Exception){
                response.postValue(Resource.Failure("Error: Solcitud Token",io))
            }
        }
    }
}
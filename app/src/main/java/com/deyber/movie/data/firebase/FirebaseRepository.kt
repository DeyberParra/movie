package com.deyber.movie.data.firebase

import com.deyber.movie._utils.extensions.toMap
import com.deyber.movie.core.Resouce.Resource
import com.deyber.movie.data.firebase.model.MapModel
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseRepository @Inject constructor(private val firebase:FirebaseFirestore) {


    suspend fun getLocation(): QuerySnapshot? {
        return withContext(Dispatchers.IO){
            firebase.collection("map").get().await()
        }
    }


    suspend fun getFlowLocation(): Flow<Resource<List<MapModel>>> = callbackFlow {
        val eventDocument =firebase.collection("map")
        val suscription= eventDocument.addSnapshotListener{snapshot,_->
            if (snapshot != null) {
                if(!snapshot.isEmpty){
                    trySend(Resource.Success(snapshot.toMap())).isSuccess
                }
            }
        }
        awaitClose { suscription.remove() }
    }

    suspend fun createLocation(mapa:MapModel): DocumentReference? {
        return withContext(Dispatchers.IO){
            firebase.collection("map").add(mapa).await()
        }
    }

}
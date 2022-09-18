package com.deyber.movie._utils.extensions

import com.deyber.movie.data.firebase.model.MapModel
import com.google.firebase.firestore.QuerySnapshot


fun QuerySnapshot.toMap():List<MapModel>{
    val list = mutableListOf<MapModel>()
    this.documents.map{
        val map: MapModel = MapModel(it.getString("date"), it.getGeoPoint("location"))
        list.add(map)
    }
    return list
}
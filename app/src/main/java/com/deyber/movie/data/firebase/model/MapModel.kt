package com.deyber.movie.data.firebase.model

import com.google.firebase.firestore.GeoPoint

data class MapModel(var date: String? =null, var location: GeoPoint? =null )


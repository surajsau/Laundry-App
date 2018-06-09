package com.halfplatepoha.laundry.db

import io.realm.RealmList
import io.realm.RealmObject

open class Occasion: RealmObject() {

    var name: String? = null
    var date: Long? = null
    var cloths: RealmList<Cloth>? = null

}
package com.halfplatepoha.laundry.db

import io.realm.RealmObject

open class Cloth : RealmObject() {

    var name: String? = null
    var icon: String? = null
    var status: Int = 0
    var lastUpdated: Long = 0
    var isTop: Boolean = false

}

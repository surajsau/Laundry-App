package com.halfplatepoha.laundry.db

const val CLOTH_TABLE = "cloth"
const val CLOTH_NAME = CLOTH_TABLE.plus(".").plus("name")
const val CLOTH_ICON = CLOTH_TABLE.plus(".").plus("icon")
const val CLOTH_STATUS = CLOTH_TABLE.plus(".").plus("status")
const val CLOTH_LAST_UPDATED = CLOTH_TABLE.plus(".").plus("lastUpdated")
const val CLOTH_IS_TOP = CLOTH_TABLE.plus(".").plus("isTop")

const val OCCASION_TABLE = "occasion"
const val OCCASION_NAME = OCCASION_TABLE.plus(".").plus("name")
const val OCCASION_CLOTHS = OCCASION_TABLE.plus(".").plus("cloths")
const val OCCASION_DATE = OCCASION_TABLE.plus(".").plus("date")
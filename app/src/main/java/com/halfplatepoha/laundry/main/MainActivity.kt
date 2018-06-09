package com.halfplatepoha.laundry.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.halfplatepoha.laundry.OCCASION_RUNNING
import com.halfplatepoha.laundry.R
import com.halfplatepoha.laundry.STATUS_LAUNDRY_BASKET
import com.halfplatepoha.laundry.STATUS_RUN
import com.halfplatepoha.laundry.base.BaseActivity
import com.halfplatepoha.laundry.db.*
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var dailyAdapter: DailyAdapter

    lateinit var realm: Realm

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        realm = Realm.getDefaultInstance()

        dailyAdapter = DailyAdapter()

        rlDaily.adapter = dailyAdapter
        rlDaily.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        getDailyClothes()
    }

    private fun getDailyClothes() {
        val dailyRunTop: Cloth? = realm.where(Cloth::class.java)
                .equalTo(CLOTH_STATUS, STATUS_RUN)
                .equalTo(CLOTH_IS_TOP, true)
                .findFirst()

        val dailyRunBottom: Cloth? = realm.where(Cloth::class.java)
                .equalTo(CLOTH_STATUS, STATUS_RUN)
                .equalTo(CLOTH_IS_TOP, false)
                .findFirst()

        val dailyRunningModel: DailyModel = DailyModel()
        dailyRunningModel.top = dailyRunTop
        dailyRunningModel.bottom = dailyRunBottom
        dailyRunningModel.date = System.currentTimeMillis()
        dailyRunningModel.ocassion = OCCASION_RUNNING

        dailyAdapter.addCloth(dailyRunningModel)

        val currentOccasions: RealmResults<Occasion>? = realm.where(Occasion::class.java)
                .lessThan(OCCASION_DATE, System.currentTimeMillis())
                .findAll()

        if(currentOccasions != null) {
            for (occasion in currentOccasions) {
                val dailyRunningModel: DailyModel = DailyModel()

                dailyRunningModel.top = dailyRunTop
                dailyRunningModel.bottom = dailyRunBottom
                dailyRunningModel.date = occasion.date
                dailyRunningModel.ocassion = occasion.name
            }
        }
    }

}

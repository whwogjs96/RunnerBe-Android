package com.applemango.runnerbe.data.vo

data class MapFilterData(
    val genderTag : String,
    val jobTag : String,
    val minAge : Int,
    val maxAge : Int
) {
     val isFilterApply = !(genderTag == "A" && jobTag == "N" && minAge == 0 && maxAge == 100)
}

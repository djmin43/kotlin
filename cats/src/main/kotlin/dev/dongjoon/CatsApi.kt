package org.example.dev.dongjoon


import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.format.Moshi
import org.http4k.routing.bind
import org.http4k.routing.routes

fun CatService.toApi(): HttpHandler {
    return routes(
        "/v1/cats" bind Method.GET to  {
            val results = listCats().toTypedArray()
            Response(Status.OK).body(Moshi.asFormatString(results))
        }

    )

}

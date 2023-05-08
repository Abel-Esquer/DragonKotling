package mx.itson.dragon.interfaces

import mx.itson.dragon.entidades.Dragon
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DragonAPI {
    //Index
    @GET("dragon")
    fun getDragon() : Call<ArrayList<Dragon>>

    //create
    @FormUrlEncoded
    @POST("dragon")
    fun createDragon(@Field("nombre") nombre: String,
                     @Field("tipo") tipo: String,
                     @Field("descripcion") descripcion: String) : Call<Dragon>

    //show
    @GET("dragon/{id}")
    fun showDragon(@Path("id") id: Int) : Call<Dragon>

    //find
    @FormUrlEncoded
    @POST("dragon/find")
    fun findDragon(@Field("columna") columna: String,
                   @Field("texto") texto: String) : Call<ArrayList<Dragon>>

    //update
    @FormUrlEncoded
    @POST("dragon/update/{id}")
    fun updateDragon(@Path("id") id: Int?,
                     @Field("nombre") nombre: String,
                     @Field("tipo") tipo: String,
                     @Field("descripcion") descripcion: String) : Call<Dragon>

    //delete
    @DELETE("dragon/{id}")
    fun deleteDragon(@Path("id") id: Int) : Call<Boolean>
}
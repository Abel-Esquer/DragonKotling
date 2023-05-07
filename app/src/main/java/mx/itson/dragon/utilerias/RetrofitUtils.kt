package mx.itson.dragon.utilerias

import com.google.gson.GsonBuilder
import mx.itson.dragon.interfaces.DragonAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {
    fun getApi(): DragonAPI {
        val gson = GsonBuilder().create()
        val retrofit  = Retrofit.Builder().baseUrl("http://192.168.0.15:80/dragonAPI/public/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(DragonAPI::class.java)
    }

    fun getApi2(): DragonAPI {
        val retrofit  = Retrofit.Builder().baseUrl("http://192.168.0.15:80/dragonAPI/public/")
            .build()

        return retrofit.create(DragonAPI::class.java)
    }
}
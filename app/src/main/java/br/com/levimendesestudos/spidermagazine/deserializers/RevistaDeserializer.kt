package br.com.levimendesestudos.spidermagazine.deserializers

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Locale
import br.com.levimendesestudos.spidermagazine.model.Hero
import br.com.levimendesestudos.spidermagazine.model.Revista

/**
 * Created by 809778 on 21/12/2016.
 */

class RevistaDeserializer : JsonDeserializer<Any> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Any {
        val revistas = ArrayList<Revista>()
        val root = json.asJsonObject

        val data = root.getAsJsonObject("data")
        val results = data.getAsJsonArray("results")


        for (element in results) {
            val jsonObject = element.asJsonObject

            val id = jsonObject.get("id").asInt
            val description = joToString(jsonObject, "description")
            val issueNumber = jsonObject.get("issueNumber").asInt
            val title = jsonObject.get("title").asString
            val pageCount = jsonObject.get("pageCount").asInt

            val date = date(jsonObject.getAsJsonArray("dates").get(0))
            val price = price(jsonObject.getAsJsonArray("prices").get(0))

            val thumbnail = jsonObject.getAsJsonObject("thumbnail")
            val extension = thumbnail.get("extension").asString
            val thumbnailPath = thumbnail.get("path").asString

            val revista = Revista()

            revista.id = id
            revista.description = description
            revista.thumbnailPath = thumbnailPath
            revista.issueNumber = issueNumber

            revista.pageCount = pageCount
            revista.title = title
            revista.date = date
            revista.price = price

            revistas.add(revista)
        }

        val copyright = root.get("copyright").asString

        return Hero(revistas, copyright)
    }

    /**
     *
     * pega uma string dentro de um jsonobject
     * @param jo
     * @param fieldName
     * @return
     */
    private fun joToString(jo: JsonObject, fieldName: String): String? {
        try {
            val je = jo.get(fieldName)

            return if (je == null || je.toString() == "null") "Conteudo nao disponivel" else je.asString

        } catch (e: UnsupportedOperationException) {
            Log.e("joToString", "UnsupportedOperationException")
        }

        return null
    }

    private fun date(dates: JsonElement): String {
        try {
            //pega apenas o dia mes e ano
            val strDate = dates.asJsonObject.get("date").asString.substring(0, 10)
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(strDate)
            return SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date)

        } catch (e: ParseException) {
            Log.e("date", e.message, e)
        }

        return ""
    }

    private fun price(prices: JsonElement): Double {
        return prices.asJsonObject.get("price").asDouble
    }
}
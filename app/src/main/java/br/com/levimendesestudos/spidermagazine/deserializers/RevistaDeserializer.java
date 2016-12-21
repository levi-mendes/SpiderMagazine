package br.com.levimendesestudos.spidermagazine.deserializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.levimendesestudos.spidermagazine.model.Revista;

/**
 * Created by 809778 on 21/12/2016.
 */

public class RevistaDeserializer implements JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Revista> retorno = new ArrayList<>();
        JsonObject root = json.getAsJsonObject();
        JsonObject data = root.getAsJsonObject("data");
        JsonArray results = data.getAsJsonArray("results");

        for (JsonElement element : results) {
            JsonObject jsonObject   = element.getAsJsonObject();

            int     id          = jsonObject.get("id").getAsInt();
            String  description = jsonObject.get("description").getAsString();

            //JsonObject thumbnail = jsonObject.getAsJsonObject("thumbnail");
            //String thumbnailPath = thumbnail.get("path").getAsString();

            Revista revista = new Revista();

            revista.id            = id;
            revista.description   = description;
            //revista.thumbnailPath = thumbnailPath;

            retorno.add(revista);
        }

        return retorno;
    }

    /*

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject root = json.getAsJsonObject();
        JsonArray results = root.getAsJsonArray("results");

        JsonElement jsonElement = results.get(0);
        JsonObject jsonObject   = jsonElement.getAsJsonObject();

        JsonObject geometry    = jsonObject.getAsJsonObject("geometry");
        JsonObject location    = geometry.getAsJsonObject("location");

        double latitude  = location.get("lat").getAsDouble();
        double longitude = location.get("lng").getAsDouble();

        return new LatLng(latitude, longitude);
    }
     */
}
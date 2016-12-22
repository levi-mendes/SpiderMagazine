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

import br.com.levimendesestudos.spidermagazine.model.Hero;
import br.com.levimendesestudos.spidermagazine.model.Revista;

/**
 * Created by 809778 on 21/12/2016.
 */

public class RevistaDeserializer implements JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Hero retorno = new Hero();
        List<Revista> revistas = new ArrayList<>();
        JsonObject root = json.getAsJsonObject();
        retorno.copyright = root.get("copyright").getAsString();

        JsonObject data = root.getAsJsonObject("data");
        JsonArray results = data.getAsJsonArray("results");


        for (JsonElement element : results) {
            JsonObject jsonObject   = element.getAsJsonObject();

            int     id          = jsonObject.get("id").getAsInt();
            String  description = jsonObject.get("description").getAsString();
            int issueNumber     = jsonObject.get("issueNumber").getAsInt();

            JsonObject thumbnail = jsonObject.getAsJsonObject("thumbnail");
            String extension     = thumbnail.get("extension").getAsString();
            String thumbnailPath = thumbnail.get("path").getAsString();

            Revista revista = new Revista();

            revista.id            = id;
            revista.description   = description;
            revista.thumbnailPath = thumbnailPath + "/portrait_medium." + extension;
            revista.issueNumber   = issueNumber;

            revistas.add(revista);
        }

        retorno.revistas = revistas;

        return retorno;
    }
}
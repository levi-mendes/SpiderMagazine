package br.com.levimendesestudos.spidermagazine.deserializers;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

            int    id          = jsonObject.get("id").getAsInt();
            String description = joToString(jsonObject, "description");
            int    issueNumber = jsonObject.get("issueNumber").getAsInt();
            String title       = jsonObject.get("title").getAsString();
            int    pageCount   = jsonObject.get("pageCount").getAsInt();

            String date        = date(jsonObject.getAsJsonArray("dates").get(0));
            double price       = price(jsonObject.getAsJsonArray("prices").get(0));

            JsonObject thumbnail = jsonObject.getAsJsonObject("thumbnail");
            String extension     = thumbnail.get("extension").getAsString();
            String thumbnailPath = thumbnail.get("path").getAsString();

            Revista revista = new Revista();

            revista.id            = id;
            revista.description   = description;
            revista.thumbnailPath = thumbnailPath;
            revista.issueNumber   = issueNumber;

            revista.pageCount = pageCount;
            revista.title     = title;
            revista.date      = date;
            revista.price     = price;

            revistas.add(revista);
        }

        retorno.revistas = revistas;

        return retorno;
    }

    /**
     *
     * pega uma string dentro de um jsonobject
     * @param jo
     * @param fieldName
     * @return
     */
    private String joToString(JsonObject jo, String fieldName) {
        try {
            JsonElement je = jo.get(fieldName);

            if (je == null || je.toString().equals("null"))
                return "Conteudo nao disponivel";

            return je.getAsString();

        } catch (UnsupportedOperationException e) {
            Log.e("joToString", "UnsupportedOperationException");
        }

        return null;
    }

    private String date(JsonElement dates) {
        try {
            //pega apenas o dia mes e ano
            String strDate = dates.getAsJsonObject().get("date").getAsString().substring(0, 10);
            Date date      = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
            return new SimpleDateFormat("dd/MM/yyyy").format(date);

        } catch (ParseException e) {
            Log.e("date", e.getMessage(), e);
        }

        return "";
    }

    private double price(JsonElement prices) {
        return prices.getAsJsonObject().get("price").getAsDouble();
    }
}
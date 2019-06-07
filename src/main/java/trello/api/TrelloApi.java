package trello.api;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TrelloApi {

    public static final String KEY = "7f33e345b802fc0c9844d257db991924";
    public static final String TOKEN = "fb517dd4b0245eb701ba67e525dff219d7e4a2b704963ef9a7f0f845343af11e";

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build();

    public void getBoardLists(String boardId) throws IOException {

        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/" + boardId + "/lists?cards=all&card_fields=all&filter=open&fields=all&key=" + KEY + "&token=" + TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void createCard(String listId) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"name\":\"JACK SPARROW\"}");
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards?idList="+listId+"&keepFromSource=all&key="+KEY+"&token="+TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }
}

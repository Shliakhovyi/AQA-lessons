package trello.api;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import trello.api.models.Card;
import trello.api.models.TrelloBoard;
import trello.api.models.TrelloList;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrelloApi {

    Gson gson = new Gson();
    public static final String KEY = "7f33e345b802fc0c9844d257db991924";
    public static final String TOKEN = "fb517dd4b0245eb701ba67e525dff219d7e4a2b704963ef9a7f0f845343af11e";

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build();

    public List<TrelloList> getBoardLists(String boardId) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/" + boardId + "/lists?cards=all&card_fields=all&filter=open&fields=all&key=" + KEY + "&token=" + TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        Type type = new TypeToken<List<TrelloList>>(){}.getType();
        List<TrelloList> trelloLists = gson.fromJson(response, type);
        System.out.println(response);
        return trelloLists;
    }

    public void createCard(String listId, Card card) throws IOException {
        String json = gson.toJson(card);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards?idList="+listId+"&keepFromSource=all&key="+KEY+"&token="+TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void createList(String idBoard, TrelloList list) throws IOException {
        String json = gson.toJson(list);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/lists?idBoard="+idBoard+"&key="+KEY+"&token="+TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void createBoard(TrelloBoard board) throws IOException {
        String json = gson.toJson(board);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/"+"?key="+KEY+"&token="+TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void getBoard(TrelloBoard board) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/" + board.id + "?key=" + KEY + "&token=" + TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void deleteBoard(TrelloBoard board) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/" + board.id + "?key=" + KEY + "&token=" + TOKEN)
                .delete()
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void updateBoard(TrelloBoard board) throws IOException {
        String json = gson.toJson(board);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/" + board.id + "?key=" + KEY + "&token=" + TOKEN)
                .put(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void getList(TrelloList trelloList) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/lists/" + trelloList.id + "?key=" + KEY + "&token=" + TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void deleteList(TrelloList trelloList) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/lists/" + trelloList.id + "?key=" + KEY + "&token=" + TOKEN)
                .delete()
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }

    public void updateList(TrelloList list) throws IOException {
        String json = gson.toJson(list);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/lists/" + list.id + "?key=" + KEY + "&token=" + TOKEN)
                .put(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);
    }
}

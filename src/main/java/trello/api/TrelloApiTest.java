package trello.api;

import org.testng.annotations.Test;
import trello.api.models.Card;
import trello.api.models.TrelloBoard;
import trello.api.models.TrelloList;

import java.io.IOException;
import java.util.List;

public class TrelloApiTest {

    @Test
    public void tryIt() throws IOException {
        TrelloApi trelloApi = new TrelloApi();
        List<TrelloList> boardLists = trelloApi.getBoardLists("qV7DMMqm");

        TrelloList trelloList = new TrelloList();
        trelloList.name = "ListName";
        TrelloList trelloList1 = boardLists.get(0);
        trelloApi.createList(trelloList1.idBoard, trelloList);

        Card card = new Card();
        card.name = "CardName";
        card.desc = "CardDescription";
        trelloApi.createCard(trelloList1.id, card);

        //trelloApi.createCard("5cf69930690d8b5fc1f1e8cb");
    }
}

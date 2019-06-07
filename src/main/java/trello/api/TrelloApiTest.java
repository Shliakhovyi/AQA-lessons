package trello.api;

import org.testng.annotations.Test;

import java.io.IOException;

public class TrelloApiTest {

    @Test
    public void tryIt() throws IOException {
        TrelloApi trelloApi = new TrelloApi();
        trelloApi.getBoardLists("qV7DMMqm");

        trelloApi.createCard("5cf69930690d8b5fc1f1e8cb");
    }
}

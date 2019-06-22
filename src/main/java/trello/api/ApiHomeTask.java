package trello.api;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import trello.api.models.TrelloBoard;
import trello.api.models.TrelloList;

import java.io.IOException;

public class ApiHomeTask {

    private TrelloBoard trelloBoard;
    private TrelloApi trelloApi;
    private TrelloList trelloList;

    @BeforeTest
    public void setUp() {
        trelloApi = new TrelloApi();
        trelloBoard = new TrelloBoard();
        trelloBoard.name = "NewBoardName";
        trelloBoard.id = "5d0e77c40f99a822ff32c5b9";

        trelloList = new TrelloList();
        trelloList.name = "NewListName";
        trelloList.idBoard = trelloBoard.id;
        trelloList.id = "5d0e7cf9c3147447f7854b09";
    }

    //Board
    @Test
    public void createBoard() throws IOException {
        trelloApi.createBoard(trelloBoard);
    }

    @Test
    public void getBoard() throws IOException {
        trelloApi.getBoard(trelloBoard);
    }

    @Test
    public void deleteBoard() throws IOException {
        TrelloBoard trelloBoard = new TrelloBoard();
        trelloBoard.id = "5d0e72a2d4c7ac18019914fb";
        trelloApi.deleteBoard(trelloBoard);
    }

    @Test
    public void updateBoardName() throws IOException {
        trelloBoard.name = "NewNameFromApi22";
        trelloApi.updateBoard(trelloBoard);
    }

    //List
    @Test
    public void createList() throws IOException {
        trelloApi.createList(trelloList.idBoard, trelloList);
    }

    @Test
    public void getList() throws IOException {
        trelloApi.getList(trelloList);
    }

    @Test
    public void deleteList() throws IOException {
        TrelloList trelloList = new TrelloList();
        trelloList.id = "5d0e7f518cd1b05e011c13f6";
        trelloApi.deleteList(trelloList);
    }

    @Test
    public void updateListName() throws IOException {
        trelloList.name = "123NewNameFromApiForList";
        trelloApi.updateList(trelloList);
    }
}

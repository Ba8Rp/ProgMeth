package logic;

import java.util.ArrayList;

public class Region {
    String name;
    private ArrayList<Player> playersList;
    private ArrayList<Quest> questList;

    public Region(String name) {
        this.setName(name);
        playersList = new ArrayList<Player>();
        questList = new ArrayList<Quest>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            this.name = "Nowhere";
        } else {
            this.name = name;
        }
    }

    public int getPlayerCount() {
        return playersList.size();
    }

    public double getRegionRank() {
        double totalRank = 0;
        for (Player pp : playersList) {
            totalRank += pp.getRank();
        }
        totalRank /= playersList.size();
        return Math.round(totalRank * 100.0) / 100.0;
    }

    public ArrayList<Quest> getAvailableQuests(Player viewer){
        ArrayList<Quest> newList = new ArrayList<Quest>();
        for(Quest qq : questList){
            if(qq.getAuthor()==viewer)continue;
            if(qq.getStatus()==Status.AVAILABLE){
                newList.add(qq);
            }
        }
        return newList;
    }

    public ArrayList<Player> getPlayerList() {
        return playersList;
    }

    public void setPlayerList(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }

    public ArrayList<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(ArrayList<Quest> questList) {
        this.questList = questList;
    }
    public void addPlayerToRegion(Player p){
        this.playersList.add(p);
    }
    public void addQuestToRegion(Quest q){
        this.questList.add(q);
    }
}

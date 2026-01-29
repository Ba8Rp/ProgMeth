package logic;

import java.util.ArrayList;

public class Database {
    private ArrayList<Player> playerList;
    private ArrayList<Region> regionList;


    public Database() {
        playerList = new ArrayList<Player>();
        regionList = new ArrayList<Region>();
    }

    public Database(ArrayList<Player> playerList, ArrayList<Region> regionList) {
        this.playerList = playerList;
        this.regionList = regionList;
    }

    public Player addPlayer(String name, Region region) throws Exception {
        for (Player pp : playerList) {
            if (pp.getName().equals(name)) {
                throw new Exception("EIEI");
            }
        }
        Player newPlayer = new Player(name);
        playerList.add(newPlayer);
        if (region != null) {
            region.addPlayerToRegion(newPlayer);
        }
        return newPlayer;
    }

    public boolean addRegion(String name) {
        for(Region rr: regionList){
            if(rr.getName().equals(name)){
                return false;
            }
        }
        Region newRegion = new Region(name);
        regionList.add(newRegion);
        return true;

    }
    public Region getRegionByName(String name){
        for(Region rr: regionList){
            if(rr.getName().equals(name)){
                return rr;
            }
        }
        return null;
    }

    public void addQuest(Player author, Region region, String name, String description){
        Quest newQuest = new Quest(author,region,name,description);
        newQuest.getRegion().addQuestToRegion(newQuest);

    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }


}


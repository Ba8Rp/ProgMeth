package logic;

import java.util.ArrayList;

public class Server {
    private String name ;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    public Server(String name, User owner, TemplateType template){
        this.owner=owner;
        this.memberList = new ArrayList<User>();
        this.channelList = new ArrayList<Channel>();
        addUser(owner);
        this.setName(name);
        if(template == TemplateType.BASIC){
            addChannel(owner,"general");
        }
        if(template == TemplateType.GAMING){
            addChannel(owner,"gaming");
        }
        if(template == TemplateType.STUDY){
            addChannel(owner,"homework-help");
        }
    }
    public Channel addChannel(User user, String channelName){
            if(!user.equals(owner)){
                return null;
            }
            Channel newChannel = new Channel(channelName);
            channelList.add(newChannel);
            return newChannel;
    }
    public User addUser(User user){
        if(memberList.contains(user)){
            return null;
        }
        memberList.add(user);
        user.addJoinedServersList(this);
        return user;
    }

    public void setName(String name) {
        if(name.isBlank()){
            this.name =owner.getName()+" home";
        }else{
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }
    public boolean kickUser(User kicker,User kicked) throws Exception{
        if(!kicker.equals(getOwner())){
            throw new Exception();
        }
        if(kicker.equals(getOwner())&&kicked.equals(getOwner())||!memberList.contains(kicked)){
            return false;
        }
        kicked.getJoinedServersList().remove(this);
        memberList.remove(kicked);
        return true;
    }
    public boolean  isMemberInServer (User userToCheck){
            return memberList.contains(userToCheck);
    }
}

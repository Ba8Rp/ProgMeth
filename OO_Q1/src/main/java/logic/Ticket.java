package logic;

public class Ticket {
    private int type;
    private int priceperstation;

    private Station start;
    private Station end;

    public Ticket(int type, Station start, Station end) {
        setType(type);
        setStation(start, end);
        setPriceperstation(getPricePerStation());

    }

    public void setPriceperstation(int priceperstation) {
        this.priceperstation=priceperstation;

    }

    public int getType() {
        return type;
    }

    public int getPricePerStation() {
        return priceperstation;
    }

    public Station getStart() {
        return this.start;
    }

    public Station getEnd() {
        return this.end;
    }

    public void setType(int type) {
        if (type < 0 || type > 2) {
            this.type = 1;
        } else {
            this.type = type;
        }
        if(type==0){
            this.priceperstation=30;
        }else if(type==1){
            this.priceperstation=30;
        }else if(type==2){
            this.priceperstation=25;
        }
    }

    public void setStation(Station start, Station end) {
        this.start = start;
        this.end = end;
    }

    public double calculatePrice() {
        double dis=getStationDistance(start,end);
        double price=getPricePerStation()*dis;

       if(getType()==0){
           if(dis > 4){
               price -=price*0.2;
           }
       }else if(getType()==2){
           price-= price*0.4;
       }
        if(!isStationValid(start,end))return -1;

        return price;
    }

    public String getDescription() {
        String typename;

        switch (type) {

            case 0:
                typename = "Student";
                break;
            case 1:
                typename = "Adult";
                break;
            case 2:
                typename = "Invalid";
                if(isStationValid(start,end)) {
                    typename = "Elderly";
                }
            break;
            default:
                typename = "Invalid";
                break;
        }

        return typename + " Ticket, from " + getStart().getName() + " to " + getEnd().getName();
    }

    public boolean isStationValid(Station start, Station end) {
        if (type == 2 && this.getStationDistance(start, end) > 6) {
            return false;
        }

        if (start == end || start.getName().equals(end.getName())) {
            return false;
        }
        return true;
    }

    public int getStationDistance(Station start, Station end) {
        return Math.abs(start.getNumber() - end.getNumber());
    }

}

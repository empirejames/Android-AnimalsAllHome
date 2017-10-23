package com.james.animalsallhome;

/**
 * Created by James on 2017/8/31.
 */

public class Animals {
    String TAG = Animals.class.getSimpleName();
    String place;
    String pic;
    String status;
    String subid;
    String id;
    String foundplace;
    String update;
    String address;
    String tel;

    public Animals(String place, String pic, String status, String subid, String id, String foundplace, String update, String address, String tel) {
        this.place = place;
        this.pic = pic;
        this.status = status;
        this.subid = subid;
        this.id = id;
        this.foundplace = foundplace;
        this.update = update;
        this.address = address;
        this.tel = tel;
    }

    public String getPlace() {
        return place;
    }

    public String getPic() {
        return pic;
    }

    public String getStatus() {
        return status;
    }

    public String getSubid() {
        return subid;
    }

    public String getId() {
        return id;
    }
    public String getFoundplace() {
        return foundplace;
    }
    public String getUpdate() {
        return update;
    }
    public String getAddress() {
        return address;
    }
    public String getTel() {
        return tel;
    }
}

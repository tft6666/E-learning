package com.example.justloginregistertest;

public class Course {
    private int id;
    private String name;
    private String code;
    private String category_id;
    private String description;
    private int price;
    private String status;
    private String open_date;
    private String last_update_on;
    private String level;
    private int shared;
    private String share_url;
    private String avatar;
    private String big_avatar;
    private String certification;
    private String certification_duration;

    public Course(int id,
             String name,
             String code,
             String category_id,
             String description,
             int price,
             String status,
             String open_date,
             String last_update_on,
             String level,
             int shared,
             String share_url,
             String avatar,
             String big_avatar,
             String certification,
             String certification_duration
             ) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.category_id = category_id;
        this.description = description;
        this.price = price;
        this.status = status;
        this.open_date = open_date;
        this.last_update_on = last_update_on;
        this.level = level;
        this.shared = shared;
        this.share_url = share_url;
        this.avatar = avatar;
        this.big_avatar = big_avatar;
        this.certification = certification;
        this.certification_duration = certification_duration;



    }

    public int getId() { return id; }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public String getCategory_id() {
        return category_id;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }
    public String getStatus() { return status; }
    public String getOpen_date() {
        return open_date;
    }
    public String getLast_update_on() {
        return last_update_on;
    }
    public String getLevel() { return level; }
    public int getShared() { return shared; }
    public String getShare_url() {
        return share_url;
    }
    public String getAvatar() {
        return avatar;
    }
    public String getBig_avatar() {
        return big_avatar;
    }
    public String getCertification() {
        return certification;
    }
    public String getCertification_duration() {
        return certification_duration;
    }

}


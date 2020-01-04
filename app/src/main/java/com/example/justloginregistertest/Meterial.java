package com.example.justloginregistertest;

public class Meterial {
    private int id;
    private int course_id;
    private String mediatype;
    private String meterial_type;
    private String material_url;
    private String create_date;
    private String description;
    private int status;

    public Meterial(int id,int course_id,String mediatype,String meterial_type,String material_url,String create_date,String description,int status) {
        this.id = id;
        this.course_id = course_id;
        this.mediatype = mediatype;
        this.meterial_type = meterial_type;
        this.material_url=material_url;
        this.create_date=create_date;
        this.description=description;
        this.status=status;
    }

    public int getId() { return id; }

    public int getCourse_id() {
        return course_id;
    }
    public String getMediatype() {
        return mediatype;
    }
    public String getMeterial_type() {
        return meterial_type;
    }
    public String getMaterial_url() {
        return material_url;
    }
    public String getCreate_date() {
        return create_date;
    }
    public String getDescription() {
        return description;
    }
    public int getStatus() { return status; }

}
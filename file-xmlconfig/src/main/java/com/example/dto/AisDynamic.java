package com.example.dto;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AisDynamic {
//    private String area;
    private String mmsi;
    private Date ais_dt;
    private double m_latitude;
    private double m_longitude;
    private double sog;
    private float cog;
    private int heading;

    public AisDynamic() {
    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public AisDynamic(String mmsi, String ais_dt, String m_latitude, String m_longitude,
                      String sog, String cog, String heading) {

        this.mmsi = mmsi;
        try {
            this.ais_dt = formatter.parse(ais_dt);
        } catch(Exception ignored) {}
        this.m_latitude = Double.parseDouble(m_latitude);
        this.m_longitude = Double.parseDouble(m_longitude);
        this.sog = Double.parseDouble(sog);
        this.cog = Float.parseFloat(cog);
        this.heading = Integer.parseInt(heading);
    }


    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public Date getAis_dt() {
        return ais_dt;
    }

    public void setAis_dt(String ais_dt) {
        try {
            this.ais_dt = formatter.parse(ais_dt);
        } catch(Exception ignored) {}
    }

    public double getM_latitude() {
        return m_latitude;
    }

    public void setM_latitude(double m_latitude) {
        this.m_latitude = m_latitude;
    }

    public double getM_longitude() {
        return m_longitude;
    }

    public void setM_longitude(double m_longitude) {
        this.m_longitude = m_longitude;
    }

    public double getSog() {
        return sog;
    }

    public void setSog(double sog) {
        this.sog = sog;
    }

    public float getCog() {
        return cog;
    }

    public void setCog(float cog) {
        this.cog = cog;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }
}

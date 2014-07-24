package com.morgan.barcodescannerapp.scanner;

/**
 * Created by Eugene Kamadi on 7/2/2014.
 */
public class Staff {


    // private variables
    private int staffid;
    private int PfNo;
    private String staffcompserialno;
    private String name;
    private String model;


    public int getStaffid() {
        return staffid;
    }

    public void setstaffid (int staffid ) {
        this.staffid = staffid ;
    }


    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }


    public int getPfNo() {
        return PfNo;
    }

    public void setPfNo(int PfNo) {
        this.PfNo = PfNo;
    }



    public String getstaffcompserialno() {
        return staffcompserialno;
    }

    public void setCompserialno(String compserialno) {
        this.staffcompserialno = staffcompserialno;
    }




    public String getmodel() {
        return model;
    }

    public void setmodel(String model) {
        this.model = model;
    }


    // constructor
    public Staff( String name, String compserialno, int PfNo, String model) {
        //this.id = id;
        this.name = name;
        this.PfNo = PfNo;
        this.staffcompserialno =staffcompserialno;
        this.model = model;

    }




}



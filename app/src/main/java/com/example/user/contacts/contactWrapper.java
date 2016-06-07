package com.example.user.contacts;

/**
 * Created by user on 5/20/2016.
 */
public class contactWrapper {

    String  name, phoneNumbers,conatct_id;


    public contactWrapper() {
        // TODO Auto-generated constructor stub
    }

    public	void set_id(String idofcontact){

        this.conatct_id=idofcontact;

    }

    public	void set_name(String name){

        this.name=name;

    }


    public	void set_numbers(String mono){

        this.phoneNumbers=mono;

    }

    public	String get_id(){

        return this.conatct_id;

    }

    public	String get_name(){

        return this.name;

    }

    public	String get_numbers(){

        return this.phoneNumbers;

    }


}

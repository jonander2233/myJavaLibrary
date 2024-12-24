package org.jonander2233;

public enum Lang {
    ES("ES","es"),
    EN("EN","en");
    private String country;
    private String lang;

    Lang(String country,String lang){
        this.country = country;
        this.lang = lang;
    }
    public String getLang(){
        return lang;
    }
    public String getCountry(){
        return country;
    }
}


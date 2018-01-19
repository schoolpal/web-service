package com.schoolpal.consts;

public enum Gender {
    NA(0, "未知"), 
    Male(1, "男"), 
    Female(2, "女");

    private int _value;
    private String _name;

    private Gender(int value, String name)
    {
        _value = value;
        _name = name;
    }

    public int getValue()
    {
        return _value;
    }

    public String getName()
    {
        return _name;
    }
    
    public static Gender valueOf(Integer value){

        if(value == null) return NA;

        switch (value) {
        case 0:
            return NA;  
        case 1:
            return Male;  
        case 2:
            return Female;  
        default:
            return NA;  
        }  
    }
    
    public static Gender nameOf(String name){
        if(name == null) return NA;

        switch (name) {  
        case "未知":
            return NA;  
        case "男":
            return Male;  
        case "女":
            return Female;  
        default:
            return NA;  
        }  
    }
}

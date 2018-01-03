package com.schoolpal.consts;

public enum ParentRelation {
    NA(0, "未知"), 
    Father(1, "父亲"), 
    Mother(2, "母亲"),
    GrandPa(3, "爷爷／姥爷"),
    GrandMa(4, "奶奶／姥姥"),
    Other(5, "其他");

    private int _value;
    private String _name;

    private ParentRelation(int value, String name)
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
    
    public static ParentRelation valueOf(Integer value){
        switch (value) {  
        case 0:
            return NA;  
        case 1:
            return Father;  
        case 2:
            return Mother;  
        case 3:
            return GrandPa;  
        case 4:
            return GrandMa;
        case 5:
            return Other;  
        default:
            return NA;  
        }  
    }
    
    public static ParentRelation nameOf(String name){
        switch (name) {  
        case "未知":
            return NA;  
        case "父亲":
            return Father;  
        case "母亲":
            return Mother;  
        case "爷爷／姥爷":
            return GrandPa;  
        case "奶奶／姥姥":
            return GrandMa;  
        case "其他":
            return Other;  
        default:
            return NA;  
        }  
    }
}

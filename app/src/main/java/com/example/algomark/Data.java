package com.example.algomark;

public class Data  {

    private int id;
    private String name;
    private String longDesc;
    private String complexity;
    private String sComplexity;
    private String stability;

    public Data(int id, String name, String longDesc, String complexity, String sComplexity, String stability) {
        this.id = id;
        this.name = name;
        this.longDesc = longDesc;
        this.complexity = complexity;
        this.sComplexity = sComplexity;
        this.stability = stability;
    }

    public String getComplexity() {
        return "Complexity: "+complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public String getsComplexity() {
        return "Space Time Complexity: "+sComplexity;
    }

    public void setsComplexity(String sComplexity) {
        this.sComplexity = sComplexity;
    }

    public String getStability() {
        return "Stable: "+stability;
    }

    public void setStability(String stability) {
        this.stability = stability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", complexity='" + complexity + '\'' +
                ", sComplexity='" + sComplexity + '\'' +
                ", stability='" + stability + '\'' +
                '}';
    }
}

package com.schoolpal.db.model;

public class TIndex {
    private String cTable;

    private String cPrefix;

    private Long cCurrent;

    private Integer cStep;

    private Byte cBits;

    public String getcTable() {
        return cTable;
    }

    public void setcTable(String cTable) {
        this.cTable = cTable == null ? null : cTable.trim();
    }

    public String getcPrefix() {
        return cPrefix;
    }

    public void setcPrefix(String cPrefix) {
        this.cPrefix = cPrefix == null ? null : cPrefix.trim();
    }

    public Long getcCurrent() {
        return cCurrent;
    }

    public void setcCurrent(Long cCurrent) {
        this.cCurrent = cCurrent;
    }

    public Integer getcStep() {
        return cStep;
    }

    public void setcStep(Integer cStep) {
        this.cStep = cStep;
    }

    public Byte getcBits() {
        return cBits;
    }

    public void setcBits(Byte cBits) {
        this.cBits = cBits;
    }
}
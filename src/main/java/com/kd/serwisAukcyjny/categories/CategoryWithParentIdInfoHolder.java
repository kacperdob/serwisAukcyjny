package com.kd.serwisAukcyjny.categories;

public interface CategoryWithParentIdInfoHolder extends CategoryHolder{
    void setParentCatId(String id);
    String getParentCatId();
}

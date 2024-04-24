package com.example.pharmacy.management.Search;
import java.util.*;


public class KeywordSearchCriteria implements MedicineSearchCriteria {

    private String keyword;

    public KeywordSearchCriteria(String keyword) {
        this.keyword = keyword;
    }


    public String getkeyword() {
        return keyword;
    }

//    public void setkeyword(String keyword){
//        this.keyword=keyword;
//    }
}

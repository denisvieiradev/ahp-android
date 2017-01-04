package com.decisionsupport.domain.entity;

import java.io.Serializable;

/**
 * Created by denisvieira on 28/12/16.
 */
public class AssistMethod implements Serializable {

     private String mTitle;
     private String mDescription;
     private int mMethodId;

     public AssistMethod() {}

     public AssistMethod(String title, String description, int methodId) {
          this.mTitle      = title;
          this.mDescription = description;
          this.mMethodId = methodId;
     }

     public int getMethodId() {
          return mMethodId;
     }

     public String getTitle() {
          return mTitle;
     }

     public String getDescription() {
          return mDescription;
     }
}

package org.example.cradlehigh;

import org.example.cradlehigh.users.UserType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Base {
     // Base class properties

     protected String id;
     protected final String createdAt = LocalDateTime
             .now()
             .format(DateTimeFormatter
                             .ofPattern("yy-MM-dd"));


     private String updatedAt;

     // Getters
     public String getId() {
         return id;
     }
     public String getCreatedAt() {
         return createdAt;
     }

     public String getUpdatedAt() {
         return updatedAt;
     }

     protected abstract String setId(UserType category);

 }
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;

/**
 *
 * @author 846582
 */
public class Note implements Serializable {
    private String title, contents;


    public Note() {
        title="This is the title";
        contents="Contents go here";
    }

    public Note(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        contents = contents;
    }
    
    
    
}

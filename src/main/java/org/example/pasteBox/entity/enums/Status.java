package org.example.pasteBox.entity.enums;

public enum Status {

    PUBLIC("public"),
    UNLISTED("unlisted");

    Status(String name){}

    @Override
    public String toString(){
        return this.name();
    }
}

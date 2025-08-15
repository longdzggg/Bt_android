package model;

public class Note {
    private long id;
    private String content;

    public Note(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() { return id; }
    public String getContent() { return content; }
}

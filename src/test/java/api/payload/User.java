package api.payload;

public class User {
    private int user_id;
    private String title;
    private String body;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setTitle(String title){
        this.title= title;
    }
    public String getTitle(){
        return title;
    }
    public void setBody(String body){
        this.body= body;
    }
    public String getBody(){
        return body;
    }

}
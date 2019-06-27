package models;

/*
 * POJO for an Id object
 */
public class Id {

    private String id;
    private String name;
    private String github;

    public void setUserid(String userid) {
        this.userid = userid;
    }

    private String userid;

    public Id(String name, String id, String github){
        this.id = id;
        this.name = name;
        this.github = github;
    }

    public Id(String name, String githubId) {
        id = "-";
        this.name = name;
        this.github = githubId;
    }

    public Id(){};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }




    @Override
    public String toString() {
        return "{" +
                "userid:"  + id + '\'' +
                "name:" + name + '\'' +
                ", github:'" + github + '\'' +
                '}';
    }

    public String getUserid() {
        return userid;
    }
}

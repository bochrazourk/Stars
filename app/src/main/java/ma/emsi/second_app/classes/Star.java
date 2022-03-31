package ma.emsi.second_app.classes;

public class Star {
    private int id;
    private String name;
    private String img;
    private float star;

    private static int comp;

    public Star(String name, String img, float star) {
        this.id = ++comp;
        this.name = name;
        this.img = img;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public float getStar() {
        return star;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setStar(float star) {
        this.star = star;
    }
}

package pl.mj.yourbestartistapp;

public class Artist {
    private String name;
    private String url;
    private String images;

    public Artist() {
    }

    public Artist(String name, String url, String images) {
        this.name = name;
        this.url = url;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}

package sairamkrishna.relax.relaxsounds;


class Sounds {
    private final String title;
    private final String image;
    private final int ocean;

    public Sounds(String title, String image, int ocean) {
        this.title = title;
        this.image = image;
        this.ocean = ocean;
    }

    public String getTitle() {
        return title;
    }

    public String getimage() {
        return image;
    }


    public int getocean() {
        return ocean;
    }

}
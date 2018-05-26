package sairamkrishna.relax.relaxsounds;

/**
 * Created by Sai on 12/3/2017.
 */

public class NewsFeeds {

    private String imgURL, feedName, content;
    private int rating;

    public NewsFeeds(String name, String content, String imgurl, int rating) {
        this.feedName = name;
        this.content = content;
        this.imgURL = imgurl;
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getFeedName() {
        return feedName;
    }

    public int getRating() {
        return rating;
    }

}

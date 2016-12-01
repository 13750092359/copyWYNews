package pyk.com.copywynews.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * 评论实体类
 *
 * Created by pyk on 2016/12/1 0001.
 * QQ:543478509
 */
public class Comment {
    /*
    对应数据库表列名
     */
    public static final String COLUMN_FLAG = "flag",
    COLUMN_USERFLAG = "userFlag",
    COLUMN_CONTENT = "content",
    COLUMN_CREATEAT = "createAt";

    private String flag;    //评论标识：系统随机生成
    private String content; //评论内容
    private String createAt;//评论时间：系统生成
    private User user;      //用户实体

    /**
     * 评论实体的构造函数，生成评论插入数据库时使用
     * @param content
     */
    public Comment(String content,User user){
        //生成随机标识，这个随机标识准确来说应该是服务端生成得
        flag = UUID.randomUUID().toString();

        //生成系统时间，这个数据创建时间也应该是服务端生成
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss", Locale.getDefault());
        this.createAt = format.format(date);
        this.user = user;
        this.content = content;
    }

    /**
     * 评论实体的构造函数，从数据库获取评论数据并实例化对象时使用
     * @param flag      评论标识
     * @param content   评论用户的用户
     * @param createAt  评论内容
     * @param user      评论时间
     */
    public Comment(String flag, String content, String createAt, User user) {
        this.flag = flag;
        this.content = content;
        this.createAt = createAt;
        this.user = user;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

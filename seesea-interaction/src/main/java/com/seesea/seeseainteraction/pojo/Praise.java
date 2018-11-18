package com.seesea.seeseainteraction.pojo;

import java.io.Serializable;

public class Praise implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_praise.praise_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    private Long praiseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_praise.praise_user_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    private String praiseUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_praise.praise_book_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    private String praiseBookId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_praise.praise_comment_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    private String praiseCommentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_praise.praise_review_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    private String praiseReviewId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_praise
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_praise.praise_id
     *
     * @return the value of tb_praise.praise_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public Long getPraiseId() {
        return praiseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_praise.praise_id
     *
     * @param praiseId the value for tb_praise.praise_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public void setPraiseId(Long praiseId) {
        this.praiseId = praiseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_praise.praise_user_id
     *
     * @return the value of tb_praise.praise_user_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public String getPraiseUserId() {
        return praiseUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_praise.praise_user_id
     *
     * @param praiseUserId the value for tb_praise.praise_user_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public void setPraiseUserId(String praiseUserId) {
        this.praiseUserId = praiseUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_praise.praise_book_id
     *
     * @return the value of tb_praise.praise_book_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public String getPraiseBookId() {
        return praiseBookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_praise.praise_book_id
     *
     * @param praiseBookId the value for tb_praise.praise_book_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public void setPraiseBookId(String praiseBookId) {
        this.praiseBookId = praiseBookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_praise.praise_comment_id
     *
     * @return the value of tb_praise.praise_comment_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public String getPraiseCommentId() {
        return praiseCommentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_praise.praise_comment_id
     *
     * @param praiseCommentId the value for tb_praise.praise_comment_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public void setPraiseCommentId(String praiseCommentId) {
        this.praiseCommentId = praiseCommentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_praise.praise_review_id
     *
     * @return the value of tb_praise.praise_review_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public String getPraiseReviewId() {
        return praiseReviewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_praise.praise_review_id
     *
     * @param praiseReviewId the value for tb_praise.praise_review_id
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    public void setPraiseReviewId(String praiseReviewId) {
        this.praiseReviewId = praiseReviewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_praise
     *
     * @mbg.generated Tue Oct 02 16:46:59 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", praiseId=").append(praiseId);
        sb.append(", praiseUserId=").append(praiseUserId);
        sb.append(", praiseBookId=").append(praiseBookId);
        sb.append(", praiseCommentId=").append(praiseCommentId);
        sb.append(", praiseReviewId=").append(praiseReviewId);
        sb.append("]");
        return sb.toString();
    }
}
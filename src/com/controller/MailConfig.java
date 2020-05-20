package com.controller;

public class MailConfig {
    //发件人地址
    private String senderAddress;
    //发件人账户名
    private String senderAccount;
    //发件人账户密码
    private String senderPassword;
    /**
     * 收件人地址，多个以","隔开
     */
    private String recipientAddresses;
    /**
     * 抄送人地址，多个以","隔开
     */
    private String copyToAddresses;
    //邮件标题
    private String subject;
    //邮件正文
    private String content;
    //附件路径
    private String[] attachmentPaths;

    public String getSenderAddress() {
        return senderAddress;
    }
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
    public String getSenderAccount() {
        return senderAccount;
    }
    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }
    public String getSenderPassword() {
        return senderPassword;
    }
    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }
    public String getRecipientAddresses() {
        return recipientAddresses;
    }
    public void setRecipientAddresses(String recipientAddresses) {
        this.recipientAddresses = recipientAddresses;
    }
    public String getCopyToAddresses() {
        return copyToAddresses;
    }
    public void setCopyToAddresses(String copyToAddresses) {
        this.copyToAddresses = copyToAddresses;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String[] getAttachmentPaths() {
        return attachmentPaths;
    }
    public void setAttachmentPaths(String[] attachmentPaths) {
        this.attachmentPaths = attachmentPaths;
    }
}

package com.controller;

public class MailConfig {
    //�����˵�ַ
    private String senderAddress;
    //�������˻���
    private String senderAccount;
    //�������˻�����
    private String senderPassword;
    /**
     * �ռ��˵�ַ�������","����
     */
    private String recipientAddresses;
    /**
     * �����˵�ַ�������","����
     */
    private String copyToAddresses;
    //�ʼ�����
    private String subject;
    //�ʼ�����
    private String content;
    //����·��
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

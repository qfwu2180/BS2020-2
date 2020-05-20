package com.controller;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

import java.util.Date;
import java.util.Properties;
/**
 * @������ Levi
 * @�������� �ʼ����͹���
 * @����ʱ�� 2018-07-18 14:08:08
 */

public class MailUtil {

    /**
     * SMTP���������ü��ʼ�����
     * @throws Exception
     */
    public void sendMail(MailConfig mc) throws Exception {
        try{
            // �����ʼ��������Ĳ�������
            Properties props = new Properties();
            // �����û�����֤��ʽ
            props.setProperty("mail.smtp.auth", "true");
            // ���ô���Э��(JavaMail�淶Ҫ��)
            props.setProperty("mail.transport.protocol","smtp");
            // ���÷����˵�SMTP��������ַ
            props.setProperty("mail.smtp.host", "smtp.qq.com");
            //  ����SMTP�������˿� һ����д��25
            props.setProperty("mail.smtp.port","25");
            // ������������Ӧ�ó�������Ļ�����Ϣ�� Session ����
            Session session = Session.getInstance(props);
            // ���õ�����Ϣ�ڿ���̨��ӡ����
            session.setDebug(true);
            // �����ʼ���ʵ������
            Message msg = getMimeMessage(session,mc);
            // ����session�����ȡ�ʼ��������Transport
            Transport transport = session.getTransport();
            // ���÷����˵��˻���������
            if(mc.getSenderAccount()==null || mc.getSenderAccount().isEmpty()){
                throw new Exception("�������˻�Ϊ��");
            }
            if(mc.getSenderPassword()==null || mc.getSenderPassword().isEmpty()){
                throw new Exception("����������Ϊ��");
            }
            transport.connect(mc.getSenderAccount(), mc.getSenderPassword());
            // �����ʼ��������͵������ռ��˵�ַ��message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
            transport.sendMessage(msg,msg.getAllRecipients());
            // �ر��ʼ�����
            transport.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ�ʼ���ʵ������
     * @param session
     * @return MimeMessage
     * @throws MessagingException
     * @throws AddressException
     */
    private MimeMessage getMimeMessage(Session session,MailConfig mc) throws Exception{
        // ����һ���ʼ���ʵ������
        MimeMessage msg = new MimeMessage(session);

        // ���÷����˵�ַ
        if (mc.getSenderAddress()!=null && !mc.getSenderAddress().isEmpty()){
            msg.setFrom(new InternetAddress(mc.getSenderAddress()));
        }else{
            throw new Exception("�����˵�ַΪ��");
        }
        /**
         * �����ռ��˵�ַ���������Ӷ���ռ��ˡ����͡����ͣ�����������һ�д�����д����
         * MimeMessage.RecipientType.TO:����
         * MimeMessage.RecipientType.CC������
         * MimeMessage.RecipientType.BCC������
         */
        if (mc.getRecipientAddresses()!=null && !mc.getRecipientAddresses().isEmpty()){
            InternetAddress[] recipients = new InternetAddress().parse(mc.getRecipientAddresses());
            msg.setRecipients(MimeMessage.RecipientType.TO, recipients);
        }else{
            throw new Exception("�ռ��˵�ַΪ��");
        }
        if (mc.getCopyToAddresses()!=null && !mc.getCopyToAddresses().isEmpty()){
            InternetAddress[] copyTos = new InternetAddress().parse(mc.getCopyToAddresses());
            msg.setRecipients(MimeMessage.RecipientType.CC,copyTos);
        }
        // �����ʼ�����
        if (mc.getSubject()!=null && !mc.getSubject().isEmpty()){
            msg.setSubject(mc.getSubject(),"UTF-8");
        }else{
            throw new Exception("�ʼ�����Ϊ��");
        }
        //�����ʼ�����
        // ���ã��ı�+ͼƬ���� ���� �Ĺ�ϵ���ϳ�һ����Ļ��"�ڵ�" / Multipart ��
        MimeMultipart mm = new MimeMultipart();
        // ��Ϲ�ϵ
        mm.setSubType("mixed");
        // ��������"�ڵ�"
        MimeBodyPart body = new MimeBodyPart();
        if (mc.getContent()!=null && !mc.getContent().isEmpty()){
            body.setContent(mc.getContent(), "text/html;charset=UTF-8");
        }else{
            throw new Exception("�ʼ�����Ϊ��");
        }
        mm.addBodyPart(body);     // ����ж�����������Դ������������
        if(mc.getAttachmentPaths()!=null && mc.getAttachmentPaths().length>0){
            for (String attachmentPath: mc.getAttachmentPaths()) {
                // ��������"�ڵ�"
                MimeBodyPart attachment = new MimeBodyPart();
                // ��ȡ�����ļ�
                DataHandler dh = new DataHandler(new FileDataSource(attachmentPath));
                // ������������ӵ�"�ڵ�"
                attachment.setDataHandler(dh);
                // ���ø������ļ�������Ҫ���룩
                attachment.setFileName(MimeUtility.encodeText(dh.getName()));
                mm.addBodyPart(attachment);     // ����ж�����������Դ������������
            }
        }
        // ���������ʼ��Ĺ�ϵ�������յĻ��"�ڵ�"��Ϊ�ʼ���������ӵ��ʼ�����
        msg.setContent(mm);
        // �����ʼ��ķ���ʱ��,Ĭ����������
        msg.setSentDate(new Date());
        msg.saveChanges();
        return msg;
    }
}

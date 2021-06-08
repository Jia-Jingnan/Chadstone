package com.lilith.listener;


import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.testng.IExecutionListener;

import java.io.File;


public class TestNGListennerSendEmail extends LilithListener implements IExecutionListener {

    public void onExecutionStart() {

        log.info("ChadStone----------所有Case开始执行");
    }



    /**
     * Invoked once all the suites have been run.
     */
    public void onExecutionFinish() {

        // 获取报告名称
//        TestReport testReport = new TestReport();
//        String reportdate = testReport.getReportdate();
        System.out.println(reportdate);

        System.out.println("this is test----------------->");
        // 等待测试报告生成
        try {
            Thread.sleep(10000);
        } catch (Exception e){
            e.printStackTrace();
        }
        HtmlEmail mail = new HtmlEmail();
        mail.setHostName("smtp.163.com");
        mail.setAuthentication("knowit9527@163.com", "SWKMTTNRLQGGJGFE");
        try {
            mail.setFrom("knowit9527@163.com");
            // 添加多个收件人
            mail.addTo("875480307@qq.com");
            mail.addTo("m18268046852@126.com");
            mail.setSubject(reportdate + "自动化测试报告");
            mail.setCharset("UTF-8");
            mail.setHtmlMsg("Hi:附件为测试报告，请查收");
            EmailAttachment emailattachment = new EmailAttachment();
            emailattachment.setPath(System.getProperty("user.dir")+ "/test-report" + File.separator + reportdate+"-report.html");
            emailattachment.setName("TestReport.html");
            emailattachment.setDescription(EmailAttachment.ATTACHMENT);
            mail.attach(emailattachment);
            mail.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

}

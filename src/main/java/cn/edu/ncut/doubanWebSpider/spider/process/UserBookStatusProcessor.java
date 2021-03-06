package cn.edu.ncut.doubanWebSpider.spider.process;

import cn.edu.ncut.doubanWebSpider.model.UserBookStatus;
import org.apache.commons.lang.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by lixiwei on 2016/8/29.
 */
public class UserBookStatusProcessor implements PageProcessor
{
    public static final String COOKIE = "gr_user_id=f7ce0ee0-4ede-45c8-bca0-890ce7ff2886; bid=\"UlkkzTCvehw\"; ps=y; ll=\"108288\"; viewed=\"4736167_1440226_2020442_3897837_3821157_3590768_2297549_2130190_26414020\"; regfromurl=http://www.douban.com/people/i_m_huangz/; regfromtitle=%E9%BB%84%E5%81%A5%E5%AE%8F; dbcl2=\"142128977:lKgaClsIDDI\"; ck=\"uNFe\"; ap=1; __utmt=1; push_noty_num=0; push_doumail_num=1; __utmt_douban=1; __utma=30149280.699562146.1456221095.1457420579.1457434590.29; __utmb=30149280.3.10.1457434590; __utmc=30149280; __utmz=30149280.1457324439.26.6.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; __utmv=30149280.14212; __utma=81379588.483132861.1456221095.1457420579.1457434598.25; __utmb=81379588.1.10.1457434598; __utmc=81379588; __utmz=81379588.1457400869.23.2.utmcsr=douban.com|utmccn=(referral)|utmcmd=referral|utmcct=/misc/sorry; _pk_ref.100001.3ac3=%5B%22%22%2C%22%22%2C1457434598%2C%22http%3A%2F%2Fwww.douban.com%2Fmisc%2Fsorry%3Foriginal-url%3Dhttps%253A%252F%252Fbook.douban.com%252Ftag%252F%253Fview%253Dtype%2526icn%253Dindex-sorttags-all%22%5D; _pk_id.100001.3ac3=cb9226d49aa4d18e.1456220256.25.1457434598.1457420754.; _pk_ses.100001.3ac3=*";
    public static final String[] COOKIES = {
            "ll=\"108288\"; bid=2K6ma7aX0vI; gr_user_id=c19d1eb1-d082-4e08-9122-75b39a670114; OUTFOX_SEARCH_USER_ID_NCOO=1768112973.5807047; ps=y; ct=y; __utma=30149280.1676638126.1472372947.1472372947.1472380761.2; __utmz=30149280.1472372947.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); viewed=\"1770782_26382433_26698660_6082808_1008145_25862578_1500762_24375031_26381341_20491078\"; ap=1; _vwo_uuid_v2=830216B642EE2BD6652E58F5EC0BC07B|aabaf5de9b2e6c0aa8d39eb855b8bcc0; ue=\"13522781970@163.com\"; dbcl2=\"150649926:POGFKt9aff4\"; ck=razw; _pk_ref.100001.8cb4=%5B%22%22%2C%22%22%2C1472802630%2C%22https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3Do0xpiwdagqNjBEoIn4lrfBrTF4Y0n35GxR5o663MmVtnVMrtlsD-olMYlIqnuXWQ%26wd%3D%26eqid%3D9e325b84000240d50000000457be8a4f%22%5D; _pk_id.100001.8cb4=af8464f25c0c9491.1464750749.23.1472803998.1472793006.; _pk_ses.100001.8cb4=*; push_noty_num=0; push_doumail_num=0"
            ,"bid=tgP_U17GUTI; ps=y; dbcl2=\"142128977:wN3LSUeSbOE\"; ck=_zp9; push_noty_num=0; push_doumail_num=0; _pk_id.100001.8cb4=0020cb432ae0b56f.1473052539.1.1473052539.1473052539.; _pk_ses.100001.8cb4=*"
            ,"ll=\"108288\"; bid=6ld7uxLY1vg; _pk_ref.100001.8cb4=%5B%22%22%2C%22%22%2C1473056091%2C%22https%3A%2F%2Faccounts.douban.com%2Fregister_success%22%5D; gr_user_id=2e10b345-d1bc-479a-8a4f-1ee1f6e15c74; _pk_id.100001.8cb4=5bdf1b723b0e9ba3.1473056091.1.1473056102.1473056091.; _pk_ses.100001.8cb4=*; ps=y; ue=\"931185214@qq.com\"; dbcl2=\"150773536:FNWIBYuq4tc\"; ck=iMwv; gr_session_id_22c937bbd8ebd703f2d8e9445f7dfd03=0a09f9b3-48e0-44ba-a9d1-3826adc45f8a; gr_cs1_0a09f9b3-48e0-44ba-a9d1-3826adc45f8a=user_id%3A1; _vwo_uuid_v2=120B9F88F0B675777ABFB278A9A6BF43|281a908ea0d1b0bcde1f05721f78b8e4; push_noty_num=0; push_doumail_num=0; ap=1"};

    //	public static final String COOKIE = "bid=\"cLFu0ljxKRE\"; gr_user_id=71a8fed9-c730-4e6b-815f-813f99b450f4; ll=\"108288\"; ap=1; viewed=\"3283973_5257905\"; __utmt=1; dbcl2=\"142128977:lKgaClsIDDI\"; ck=\"uNFe\"; gr_session_id_22c937bbd8ebd703f2d8e9445f7dfd03=c78404b1-2e3a-4bb6-afd9-45e6cfdc0d41; __utmt_douban=1; __utma=30149280.1220747617.1453995829.1455611943.1456219113.6; __utmb=30149280.4.10.1456219113; __utmc=30149280; __utmz=30149280.1456219113.6.5.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; __utmv=30149280.14212; push_noty_num=0; push_doumail_num=1";
    public static final String[] AGENTS = new String[]{
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2471.2 Safari/537.36",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.109 Safari/537.36",
            "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6",
            "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.12 Safari/535.11",
            "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)",
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36"};
    // TODO:设置代理IP
    private Site site = Site.me().setRetryTimes(3).setCharset("UTF-8")
            .setUserAgent(AGENTS[new Random().nextInt(5)])
            .setSleepTime(0)
            .setRetryTimes(3)
            .setCycleRetryTimes(100)
            .addCookie("Cookie", COOKIE);


    @Override
    public Site getSite()
    {
        return site;
    }

    @Override
    public void process(Page page)
    {
        try
        {
            site.setUserAgent(AGENTS[new Random().nextInt(5)]);
            //Thread.sleep(new Random().nextInt(20)*100);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            String type = page.getUrl().toString().split("/")[5].split("\\?")[0];
            String userno = page.getUrl().toString().split("/")[4];
            List<String> bookNos = page.getHtml().xpath("//ul[@class='list-view']/li/@id").all();
            List<String> dates = page.getHtml().xpath("//ul[@class='list-view']/li/div[@class='item-show']/div[@class='date']/text()").all();

            for (int i = 0; i<bookNos.size(); i++)
            {
                try
                {
                    UserBookStatus userBookStatus = new UserBookStatus();
                    userBookStatus.setUserno(userno);
                    userBookStatus.setType(type);
                    userBookStatus.setBookno(bookNos.get(i).replaceAll("list",""));
                    try
                    {
                        userBookStatus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i).trim()));
                    }
                    catch (Exception e)
                    {
                        userBookStatus.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i).trim().substring(3)));
                    }
                    userBookStatus.setDbtime(new Date());
                    page.putField("userBookStatus" + i, userBookStatus);
                }
                catch (Exception e)
                {
                    System.out.println("转换异常" + e.getMessage());
                }
            }
            String nextPage = page.getHtml().xpath("//span[@class='next']/a/@href").get();
            if (!StringUtils.isBlank(nextPage))
                page.addTargetRequest(new Request(nextPage));

        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("用户-图书信息Xpath解析失败" + e.getMessage());
        }
    }
}

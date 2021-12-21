package mao.servlet_life_cycle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project name(项目名称)：Servlet_life_cycle
 * Package(包名): mao.servlet_life_cycle
 * Class(类名): MyServlet
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/21
 * Time(创建时间)： 19:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class MyServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private int initCount = 0;
    private int httpCount = 0;
    private int destoryCount = 0;

    @Override
    public void destroy()
    {
        destoryCount++;
        super.destroy();
        // 向控制台输出destory方法被调用次数
        System.out.println(
                "**********************************destroy方法：" + destoryCount + "*******************************");
    }

    @Override
    public void init() throws ServletException
    {
        initCount++;
        super.init();
        // 向控制台输出init方法被调用次数
        System.out.println("init方法：" + initCount);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        httpCount++;
        // 控制台输出doGet方法次数
        System.out.println("doGet方法：" + httpCount);
        // 设置返回页面格式与字符集
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        // 向页面输出
        writer.write("初始化次数:" + initCount + "<br/>" + "处理请求次数:" + httpCount + "<br/>" + "销毁次数:" + destoryCount);
        writer.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }
}

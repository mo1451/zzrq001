package com.zzrq.lom.login.controller;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.zzrq.lom.login.dto.User;
import com.zzrq.lom.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mo1451
 */
@Controller
public class LoginController {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @GetMapping(value = "login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "login")
    public ModelAndView checkLogin(HttpServletRequest httpServletRequest,String inputUser,String inputPassword,String inputCode) {
        ModelAndView andView = new ModelAndView();
        String verifyCode = (String) httpServletRequest.getSession().getAttribute("verifyCode");
        /* String parameter = httpServletRequest.getParameter("verifyCode"); */
        System.out.println("Session  verifyCode "+verifyCode+" form verifyCode "+inputCode);

        if (!verifyCode.equalsIgnoreCase(inputCode)) {
            andView.addObject("msg", "错误的验证码");
            andView.setViewName("login");
        } else {
            User user = userService.checkPassword(inputUser,inputPassword);
            if(user == null) {
                andView.addObject("msg", "用户名或密码错误");
                andView.setViewName("login");
            } else {
                andView.addObject("msg", "登录成功");
                httpServletRequest.getSession().setAttribute("user", user);
                andView.addObject("user", user);
                andView.setViewName("redirect:index");
            }

        }
        return andView;
    }

    @Autowired
    private DefaultKaptcha captchaProducer;
    /**
     * 获取验证码 的 请求路径
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            httpServletRequest.getSession().setAttribute("verifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * 验证的方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    public ModelAndView imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ModelAndView andView = new ModelAndView();
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        String parameter = httpServletRequest.getParameter("vrifyCode");
        System.out.println("Session  vrifyCode "+captchaId+" form vrifyCode "+parameter);

        if (!captchaId.equals(parameter)) {
            andView.addObject("info", "错误的验证码");
            andView.setViewName("index");
        } else {
            andView.addObject("info", "登录成功");
            andView.setViewName("success");
        }
        return andView;
    }
}

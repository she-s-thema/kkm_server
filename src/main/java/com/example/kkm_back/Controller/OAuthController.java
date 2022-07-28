package com.example.kkm_back.Controller;
import com.example.kkm_back.Service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OAuthController {
    @Autowired
    private KakaoService kakaoService;

    @RequestMapping("/kakaoLogin")
    public String KakaoLogin(@RequestParam(value="code", required = false) String code) throws Exception {
        System.out.println("받은 인가코드 : "+ code);
        String access_Token = kakaoService.getAccessToken(code);
        System.out.println("액세스 토큰 : "+access_Token);

        Map<String, Object> userInfo = kakaoService.getUserInfo(access_Token);

        System.out.println(userInfo);

        return "login success";
    }
}

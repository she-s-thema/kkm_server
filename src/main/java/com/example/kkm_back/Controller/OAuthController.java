package com.example.kkm_back.Controller;
import com.example.kkm_back.Domain.User;
import com.example.kkm_back.Repository.UserRepository;
import com.example.kkm_back.Service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OAuthController {
    @Autowired
    private KakaoService kakaoService;
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/user/kakaoLogin", method = RequestMethod.POST)
    public Map<String, Object> KakaoLogin(@RequestParam(value="code", required = true) String code) throws Exception {
        String access_Token = kakaoService.getAccessToken(code); // 액세스 토큰 얻기
        Map<String, Object> userInfo = kakaoService.getUserInfo(access_Token); // 액세스 토큰으로 카카오 사용자 정보 얻기
        Long k_id = Long.parseLong(String.valueOf(userInfo.get("id"))); // Object to long
        Map<String, Object> exist = userRepository.isExist(k_id); // user table에 존재하는가?

        if(exist == null) { // 회원 가입이 안 되어 있다면
            Map<String, Object> needMoreInfo = new HashMap<>();
            needMoreInfo.put("id", 1);
            needMoreInfo.put("message", "NEED MORE INFO");
            return needMoreInfo;
        } else { // 회원 가입이 되어있다면 유저 정보 보내기
            return exist; // user_id, nickname, k_id, k_img_url, k_email
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user/join", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public User Join(@ModelAttribute User user) throws Exception {
        userRepository.insertUser(user);
        return user;
    }
}
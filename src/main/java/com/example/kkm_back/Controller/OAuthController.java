package com.example.kkm_back.Controller;
import com.example.kkm_back.Domain.User;
import com.example.kkm_back.Repository.UserRepository;
import com.example.kkm_back.Service.JwtService;
import com.example.kkm_back.Service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OAuthController {
    @Autowired
    private KakaoService kakaoService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;

    // kakao user info 받기
    @RequestMapping(value = "/user/getKakaoUserInfo", method = RequestMethod.GET)
    public Map<String, Object> GetKakaoUserInfo(@RequestParam(value = "code", required = true) String code) throws Exception {
        Map<String, Object> userInfo = kakaoService.getUserInfo(kakaoService.getAccessToken(code)); // 액세스 토큰으로 카카오 사용자 정보 얻기
        return userInfo;
    }

    // user가 회원가입 되어 있는지 체크 후 true라면 로그인 처리 + JWT token 발급 false라면 회원가입 절차
    @RequestMapping(value = "/user/kakaoLogin", method = RequestMethod.POST)
    public String  KakaoLogin(@RequestParam(value="k_id", required = true) long k_id) throws Exception {
        Map<String, Object> exist = userRepository.isExist(k_id); // user table에 존재하면 존재하는 정보, 존재하지 않으면

        System.out.println(exist);
        if(exist == null) { // 회원 가입이 안 되어 있다면
            return "guest";
        } else { // 회원 가입이 되어있다면 JWT token 보내줘야 함
            User user = new User(exist.get("user_id").toString(),
                                    exist.get("nickname").toString(),
                                    exist.get("k_id").toString(),
                                    exist.get("k_img_url").toString(),
                                    Double.valueOf(exist.get("lat").toString()),
                                    Double.valueOf(exist.get("lon").toString()),
                                    exist.get("address").toString());

            String token = jwtService.createJWT(user);
            return token;
        }
    }

    // user 정보를 받아 회원가입
    @ResponseBody
    @RequestMapping(value = "/user/join", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String Join(@ModelAttribute User user) throws Exception {
        System.out.println(user);
        userRepository.insertUser(user);
        String token = jwtService.createJWT(user);
        return token;
    }

    //token 확인
    @ResponseBody
    @RequestMapping(value = "/checkJWT", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String CheckJWT(@RequestParam String token) throws Exception {
        Map<String, Object> check = jwtService.checkJWT(token);
        if(check == null) {
            return  "Required token";
        } else {
            return "Token is already exist";
        }
    }

}
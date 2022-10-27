package com.example.kkm_back.Service;

import com.example.kkm_back.Domain.Post;
import com.example.kkm_back.Repository.HeartRepository;
import com.example.kkm_back.Repository.PostRepository;
import com.example.kkm_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {
    @Autowired
    private HeartRepository heartRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

//    public List<Post> getHeart(String user_id) {
//        List<Double> LonLat = userRepository.getLonLat(user_id);
//        double lon = LonLat.get(0);
//        double lat = LonLat.get(1);
//        //사용자가 눌린 하트들의 포스트아이디
//        List<String> PostIdFromHeart = heartRepository.postIdListfromHeart(user_id);
//        List<String> heartsList = new ArrayList<>();
//        for (int i = 0; i < PostIdFromHeart.size(); i++) {
//            String post_id = PostIdFromHeart.get(i);
//            //사용자가 눌린 하트들에 대한 포스트에 하트를 누른 사람들의 아이디
//            List<String> pushHeartUserList = heartRepository.userListfromHeart(post_id);
//            for (int j = 0; j < pushHeartUserList.size(); j++) {
//                heartsList.addAll(heartRepository.postIdListfromHeartwithfiveKilo(pushHeartUserList.get(j),lon,lat));
//            }
//        }
//        for(int l=0; l < heartsList.size();l++){
//            List<String> usedHeartList = new ArrayList<>();
//            if(usedHeartList.contains(heartsList.get(l))) {
//                continue;
//            }
//            else{
//                int count = Collections.frequency(heartsList,heartsList.get(l));
//
//                usedHeartList.add(heartsList.get(l));
//            }
//
//        }
//        //맵 자료구조 반복된 횟수를 밸류 값으로, 원래 포스트 아이디를 키 값으로 중복 제거
//        Map<String, Integer> valueListMap = new HashMap<String, Integer>();
//        for (String str : heartsList) {
//            System.out.println("통3");
//            Integer count = valueListMap.get(str);
//            if (count == null) {
//                valueListMap.put(str, 1);
//            } else {
//                valueListMap.put(str, count + 1);
//            }
//        }
//        //엔트리 해서 밸류값 기준 오름차순
//        List<Map.Entry<String, Integer>> valueList = new ArrayList<>(valueListMap.entrySet());
//        valueList.sort(Map.Entry.comparingByValue());
//        //오름차순을 역순으로 하면 내림차순
//        Collections.reverse(valueList);
//        List<Post> returnPosts = new ArrayList<>();
//        for(int k=0;k<valueList.size();k++){
//            returnPosts.add(postRepository.getPostWithPostId(String.valueOf(valueList.get(k))));
//        }
//        return returnPosts;
//    }
}

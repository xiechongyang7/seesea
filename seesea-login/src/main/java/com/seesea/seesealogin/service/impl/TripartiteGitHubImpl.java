package com.seesea.seesealogin.service.impl;

import com.seesea.seeseacommon.Assert.Assert;
import com.seesea.seeseacommon.Base.BaseService;
import com.seesea.seeseacommon.Base.exception.BizException;
import com.seesea.seeseacommon.constant.ResultCode;
import com.seesea.seeseacommon.util.JsonUtil;
import com.seesea.seeseacommon.util.http.HttpUtils;
import com.seesea.seesealogin.model.vo.TripartiteVo;
import com.seesea.seesealogin.service.ITripartiteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/5 下午 10:44
 * @Author xiechongyang
 */
@Service
public class TripartiteGitHubImpl extends BaseService implements ITripartiteService {

    @Value("${client.id}")
    private String client_id;

    @Value("${client.secret}")
    private String client_secret;

    @Override
    public Map<String, Object> tripartiteLog(TripartiteVo tripartiteVo) {
        /**
         * 获取到这个code参数后，我会将这个code传到服务器的后台，然后后台调用 https://github.com/login/oauth/access_token 这个api，
         * 传入 client_id, client_secret, code 这三个参数，可以获取到一个 access_token。
         *
         * 获取到 access_token 后， 再调用 https://api.github.com/user?access_token=access_token 这个API，
         * 就可以获取到基本的用户信息了。 用户的基本信息内容如下所示， 根据第一步传入的不同的 scope，获取到的用户信息也是不同的。
         * 博客后台使用 login 字段作为用户的唯一标示，因为email 可能为空，之前用email发生了一些bug。
         *
         * 0 users
         *
         * Client ID
         * 8f693d407f5552b939fa
         * Client Secret
         * 0b052cf0c62785cbf006406ecffba94ef84a201b
         */
        try {
            //获取access_token
            StringBuilder str = new StringBuilder("https://github.com/login/oauth/access_token?client_id=");
            str.append(client_id);
            str.append("&client_secret=");
            str.append(client_secret);
            str.append("&code=");
            str.append(tripartiteVo.getAuthCode());

            byte[] bytes = HttpUtils.doGet(str.toString());
            Assert.isNull(bytes, ResultCode.ER_1108,ResultCode.ER_1108_MSG);
            String access_token = bytes.toString();


            //获取信息
            StringBuilder str2 = new StringBuilder(" https://api.github.com/user?access_token=");
            str2.append(access_token);
            byte[] bytes2 = HttpUtils.doGet(str.toString());
            Assert.isNull(bytes2, ResultCode.ER_1108,ResultCode.ER_1108_MSG);
            String userInfo = bytes2.toString();
            //返回信息
            /**
             * {
             *     "login":"xiechongyang7",
             *     "id":22980684,
             *     "node_id":"MDQ6VXNlcjIyOTgwNjg0",
             *     //头像
             *     "avatar_url":"https://avatars3.githubusercontent.com/u/22980684?v=4",
             *     "gravatar_id":"",
             *     "url":"https://api.github.com/users/xiechongyang7",
             *     "html_url":"https://github.com/xiechongyang7",
             *     "followers_url":"https://api.github.com/users/xiechongyang7/followers",
             *     "following_url":"https://api.github.com/users/xiechongyang7/following{/other_user}",
             *     "gists_url":"https://api.github.com/users/xiechongyang7/gists{/gist_id}",
             *     "starred_url":"https://api.github.com/users/xiechongyang7/starred{/owner}{/repo}",
             *     "subscriptions_url":"https://api.github.com/users/xiechongyang7/subscriptions",
             *     "organizations_url":"https://api.github.com/users/xiechongyang7/orgs",
             *     "repos_url":"https://api.github.com/users/xiechongyang7/repos",
             *     "events_url":"https://api.github.com/users/xiechongyang7/events{/privacy}",
             *     "received_events_url":"https://api.github.com/users/xiechongyang7/received_events",
             *     "type":"User",
             *     "site_admin":false,
             *     "name":"thewaiting",
             *     "company":null,
             *     "blog":"",
             *     "location":null,
             *     "email":"xiechongyang7@gmail.com",
             *     "hireable":null,
             *     "bio":"一类一世界",
             *     "public_repos":8,
             *     "public_gists":0,
             *     "followers":0,
             *     "following":0,
             *     "created_at":"2016-10-21T11:58:41Z",
             *     "updated_at":"2018-10-12T04:58:33Z"
             * }
             */
            logInfo(tripartiteVo.getReqId(),"github返回信息是",userInfo);
            Map map = JsonUtil.jsonToObj(userInfo,Map.class);

        }catch (BizException e){

        }

        return null;
    }

    @Override
    public Map<String, Object> getInfo() {
        return null;
    }
}

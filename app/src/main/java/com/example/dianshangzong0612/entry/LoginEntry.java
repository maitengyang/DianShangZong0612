package com.example.dianshangzong0612.entry;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/6/17
 *@Time:15:09
 *@Description:作用:
 * */public class LoginEntry {


    /**
     * result : {"headPic":"http://172.17.8.100/images/small/default/user.jpg","nickName":"OT_b85cp","phone":"15010563551","sessionId":"15607554821826393","sex":1,"userId":6393}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * nickName : OT_b85cp
         * phone : 15010563551
         * sessionId : 15607554821826393
         * sex : 1
         * userId : 6393
         */

        private String headPic;
        private String nickName;
        private String phone;
        private String sessionId;
        private String  sex;
        private String  userId;

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String  getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String  getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}

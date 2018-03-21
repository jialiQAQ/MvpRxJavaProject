package com.example.jiali.myapplication.network.responsebean;

// FIXME generate failure  field _$Data67
// FIXME generate failure  field _$Data278
/**
 * Created by socool on 2017/7/27.
 */

public class UserData {
    /**
     * code : 1
     * result : 成功
     * data : {"merchantId":1,"merchantUserId":1,"name":"x","address":"cc","mobile":"cc","mealStyle":1,"taxRate":0.88,"serviceCharge":0.1}
     */

    private String code;
    private String result;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * merchantId : 1
         * merchantUserId : 1
         * name : x
         * address : cc
         * mobile : cc
         * mealStyle : 1
         * taxRate : 0.88
         * serviceCharge : 0.1
         */

        private int merchantId;
        private int merchantUserId;
        private String name;
        private String address;
        private String mobile;
        private int mealStyle;
        private float taxRate;
        private float serviceCharge;
        private boolean isSuper;
        private String nickName;
        private String memberRole;
        private String memberEmail;
        private String memberMobile;
        private int roleId;
        private int priceIncloudTax;//20171115 HXQ
        private int rounding;//20171217 HXQ
        private int withStand;
        private int extraCharge;//额外的费用

        private String token ;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getExtraCharge() {
            return extraCharge;
        }

        public void setExtraCharge(int extraCharge) {
            this.extraCharge = extraCharge;
        }

        public int getWithStand() {
            return withStand;
        }

        public void setWithStand(int withStand) {
            this.withStand = withStand;
        }

        public int getRounding() {
            return rounding;
        }

        public void setRounding(int rounding) {
            this.rounding = rounding;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public int getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(int merchantId) {
            this.merchantId = merchantId;
        }

        public int getMerchantUserId() {
            return merchantUserId;
        }

        public void setMerchantUserId(int merchantUserId) {
            this.merchantUserId = merchantUserId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMealStyle() {
            return mealStyle;
        }

        public void setMealStyle(int mealStyle) {
            this.mealStyle = mealStyle;
        }

        public float getTaxRate() {
            return taxRate;
        }

        public void setTaxRate(float taxRate) {
            this.taxRate = taxRate;
        }

        public float getServiceCharge() {
            return serviceCharge;
        }

        public void setServiceCharge(float serviceCharge) {
            this.serviceCharge = serviceCharge;
        }

        public String getNickName() {
            return this.nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getMemberRole() {
            return memberRole;
        }

        public void setMemberRole(String memberRole) {
            this.memberRole = memberRole;
        }

        public String getMemberEmail() {
            return memberEmail;
        }

        public void setMemberEmail(String memberEmail) {
            this.memberEmail = memberEmail;
        }

        public String getMemberMobile() {
            return memberMobile;
        }

        public void setMemberMobile(String memberMobile) {
            this.memberMobile = memberMobile;
        }

        public boolean isSuper() {
            return isSuper;
        }

        public void setSuper(boolean aSuper) {
            isSuper = aSuper;
        }

        public int getPriceIncloudTax() {
            return priceIncloudTax;
        }

        public void setPriceIncloudTax(int priceIncloudTax) {
            this.priceIncloudTax = priceIncloudTax;
        }
    }


}

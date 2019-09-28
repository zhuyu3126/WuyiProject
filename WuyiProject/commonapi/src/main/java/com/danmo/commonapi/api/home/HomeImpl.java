package com.danmo.commonapi.api.home;

import android.content.Context;
import android.support.annotation.NonNull;

import com.danmo.commonapi.base.BaseImpl;
import com.danmo.commonutil.UUIDGenerator;

import org.greenrobot.eventbus.EventBus;

public class HomeImpl extends BaseImpl<HomeService> {

    public HomeImpl(@NonNull Context context, String baseUrl, int currentParse, EventBus eventBus) {
        super(context, baseUrl, currentParse,eventBus);
    }
/*
* 获取首页轮播图
* */
    public String selectBannerList(int channelType,String channelName,String recordId) {
        String uuid = UUIDGenerator.getUUID();
        sub(mService.selectBannerList(channelType,channelName,recordId),uuid);
        return uuid;
    }

    /*
    * 获取新闻列表
    * */

    public String getNewList(String news){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getNewList(news),uuid);
        return uuid;
    }
    /*
    * 查询新闻
    * */

    public String getNewInfo(int newsId){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getNewInfo(newsId),uuid);
        return uuid;
    }

    /*
    * 获取武校列表
    * */
    public String getSchoolList(String districtsName){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getSchoolList(districtsName),uuid);
        return uuid;
    }

    /**
     * 获取武校教练列表
     * @return
     */
    public String getCoachList(int businessType,int businessId ){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getCoachList(businessType,businessId),uuid);
        return uuid;

    }
/*
获取学校下的学生列表
*/

    public String getStudentList(int schoolID){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getStudentList(schoolID),uuid);
        return uuid;
    }
    /*
获取班级下的学生列表
*/

    public String getClassStudentList(int classID){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getClassStudentList(classID),uuid);
        return uuid;
    }

    /*
    * 获取学校下的视频列表
    * */
    public  String getVideoList(int videoType,int recordId){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getVideoList(videoType,recordId),uuid);
        return uuid;
    }


    /*
     * 获取班级列表
     * */
    public  String getClassList(int schoolId){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getClassList(schoolId),uuid);
        return uuid;
    }

    /*
     * 获取俱乐部列表
     * */
    public  String getClubList(int country){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getClubList(country),uuid);
        return uuid;
    }
    /*
    查询俱乐部下队员
    * */

    public  String getClubMemberList(String name){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getClubMemberList(name),uuid);
        return uuid;
    }

    /*
    * 获取特保人员
    * */
    public  String getBodyguard(String name){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getBodyguard(name),uuid);
        return uuid;
    }

    /*
     * 获取转会下的教练
     * */
    public  String getCoachListByClub(String name){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getCoachListByClub(name),uuid);
        return uuid;
    }

    /*
    获取俱乐部根据类型获取
    */
    public String getCoachListByClub(int dictType){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getCoachListByClub(dictType),uuid);
        return uuid;
    }
    /*
    * 获取班级下的教练列表
    * */
    public String selectCoachByClassId(int classId){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.selectCoachByClassId(classId),uuid);
        return uuid;
    }

    /*
    * 获取赛事列表根据类型
    * */

    public String getEventList(String type){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getEventList(type),uuid);
        return uuid;
    }
    /*
    * 获取俱乐部下的教练列表
    * */
    public String getCoachListByClubId(int businessType,int businessId ){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getCoachListByClubId(businessType,businessId),uuid);
        return uuid;
    }
    /*
     * 获取俱乐部下普通队员
     * */
    public String selectCommonClubMember(int clubId){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.selectCommonClubMember(clubId),uuid);
        return uuid;
    }
    /*
     * 获取俱乐部下明星队员
     * */
    public String selectStarClubMember(int clubId){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.selectStarClubMember(clubId),uuid);
        return uuid;
    }

    /*
    * 获取俱乐部下的VIP卡列表
    * */
    public String getVipCardList(int businessType,int businessId){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getVipCardList(businessType,businessId),uuid);
        return uuid;
    }

    /*
     * 获取健身房列表
     * */
    public String getGymList(String districtsName){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getGymList(districtsName),uuid);
        return uuid;
    }
    /*
    * 查询健身房下的课程列表
    * */
    public String getGymCourseItemList(int businessType,int businessId ){
        String uuid = UUIDGenerator.getUUID();
        sub(mService.getGymCourseItemList(businessType,businessId),uuid);
        return uuid;
    }
}

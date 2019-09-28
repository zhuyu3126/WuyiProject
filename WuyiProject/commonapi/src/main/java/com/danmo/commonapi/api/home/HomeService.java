package com.danmo.commonapi.api.home;

import com.danmo.commonapi.bean.BaseResponse;
import com.danmo.commonapi.bean.home.BannerItem;
import com.danmo.commonapi.bean.home.NewsInfo;
import com.danmo.commonapi.bean.home.club.BodyguardItem;
import com.danmo.commonapi.bean.home.club.ClubItem;
import com.danmo.commonapi.bean.home.club.ClubMember;
import com.danmo.commonapi.bean.home.club.CommounItem;
import com.danmo.commonapi.bean.home.club.EventItem;
import com.danmo.commonapi.bean.home.club.VipCardItem;
import com.danmo.commonapi.bean.home.gym.CourseItem;
import com.danmo.commonapi.bean.home.gym.GymItem;
import com.danmo.commonapi.bean.home.school.ClassItem;
import com.danmo.commonapi.bean.home.school.CoachItem;
import com.danmo.commonapi.bean.home.school.SchoolItem;
import com.danmo.commonapi.bean.home.school.StudentItem;
import com.danmo.commonapi.bean.home.school.VideoItem;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HomeService {
    /*
    * 获取首页轮播图片
    * */
    @GET("banner/selectBannerList")
    Observable<BaseResponse<BannerItem>> selectBannerList(@Query("channelType") int channelType,@Query("channelName") String channelName,@Query("recordId") String recordId);
    /*
    * 获取首页新闻资讯详情
    * */
    @GET("news/info")
    Observable<BaseResponse<NewsInfo>> getNewInfo(@Query("newsId") int newsId);
    /*
     * 新增电池
     * */
    @FormUrlEncoded
    @POST("news/list")
    Observable<BaseResponse<NewsInfo>> getNewList(@Field("News") String date);

    /*
    * 查询武校列表
    * */
    @FormUrlEncoded
    @POST("school/list")
    Observable<BaseResponse<SchoolItem>> getSchoolList(@Field("districtsName") String districtsName);


    /*
    * 查询学校下的教练
    * */

    @FormUrlEncoded
    @POST("coach/selectCoachListByBusiness")
    Observable<BaseResponse<CoachItem>> getCoachList(@Field("businessType") int  businessType,@Field("businessId") int businessId);
    /*
    * 获取学校队员学生列表
    * */

    @GET("students/selectStudentsBySchoolId")
    Observable<BaseResponse<StudentItem>> getStudentList(@Query("schoolId") int  schoolId );

    /*
     * 获取班级队员学生列表
     * */

    @GET("students/selectStudentsByClassId")
    Observable<BaseResponse<StudentItem>> getClassStudentList(@Query("classId") int  classId );


    /*
    获取视频列表
    */

    @FormUrlEncoded
    @POST("video/list")
    Observable<BaseResponse<VideoItem>> getVideoList(@Field("videoType") int  videoType , @Field("recordId") int recordId);

    /*
    * 获取班级根据学校
    * */

    @GET("schoolclass/selectSchoolClassBySchoolId")
    Observable<BaseResponse<ClassItem>> getClassList(@Query("schoolId") int  schoolId );

/*
* 获取俱乐部
* */
    @FormUrlEncoded
    @POST("club/list")
    Observable<BaseResponse<ClubItem>> getClubList(@Field("country") int  country );

    /*
    获取俱乐部成员
    */
    @GET("clubMember/selectAllClubMember")
    Observable<BaseResponse<CommounItem>> getClubMemberList(@Query("name") String  name );


    /*
    获取特保人员
    * */
    @FormUrlEncoded
    @POST("bodyguard/list")
    Observable<BaseResponse<CommounItem>> getBodyguard(@Field("name") String  name );

    /*
    * 获取转会下的教练
    * */
    @FormUrlEncoded
    @POST("coach/list")
    Observable<BaseResponse<CommounItem>> getCoachListByClub(@Field("name") String  name);

   /*
   获取不同类型的俱乐部
   */
    @GET("sysDictData/selectSysDictDataListBydictType")
    Observable<BaseResponse<ClubItem>> getCoachListByClub(@Query("dictType") int  dictType);

    /*
    获取对应班级下的教练
    * */
    @GET("coach/selectCoachByClassId")
    Observable<BaseResponse<CoachItem>> selectCoachByClassId(@Query("classId") int  classId);

    /*
    * 获取赛事列表根据数据类型
    * */
    @FormUrlEncoded
    @POST("eventApply/list")
    Observable<BaseResponse<EventItem>> getEventList(@Field("matchTypeId") String  matchTypeId);

    /*
    * 查询俱乐部对应的教练列表
    * */
    @FormUrlEncoded
    @POST("coach/selectCoachListByBusiness")
    Observable<BaseResponse<CoachItem>> getCoachListByClubId(@Field("businessType") int   businessType,@Field("businessId") int   businessId);

    /*
       获取俱乐部下的普通队员
    */
    @GET("clubMember/selectCommonClubMember")
    Observable<BaseResponse<ClubMember>> selectCommonClubMember(@Query("clubId") int   clubId);

    /*
    获取俱乐部下的普通队员
 */
    @GET("clubMember/selectStarClubMember")
    Observable<BaseResponse<ClubMember>> selectStarClubMember(@Query("clubId") int   clubId);

    /*
       获取俱乐部会员卡
    */
    @FormUrlEncoded
    @POST("vipCard/list")
    Observable<BaseResponse<VipCardItem>> getVipCardList(@Field("businessType") int   businessType, @Field("businessId") int   businessId);


    /*
     * 查询附件健身房列表
     * */
    @FormUrlEncoded
    @POST("gym/list")
    Observable<BaseResponse<GymItem>> getGymList(@Field("districtsName") String districtsName);
    /*
    * 查询健身房查询课程列表
    * */
    @FormUrlEncoded
    @POST("course/selectCourseListByBusiness")
    Observable<BaseResponse<CourseItem>> getGymCourseItemList(@Field("businessType") int businessType,@Field("businessId") int businessId);



}

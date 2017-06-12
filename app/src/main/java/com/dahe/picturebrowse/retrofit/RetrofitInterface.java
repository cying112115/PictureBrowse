package com.dahe.picturebrowse.retrofit;

import com.dahe.picturebrowse.constants.ApiConstants;
import com.dahe.picturebrowse.mvp.bean.BaseGenericResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface RetrofitInterface {

    /**
     * 删除素材 通过uuid 删除
     *
     * @param uuid
     * @return
     */
    @FormUrlEncoded
    @POST(ApiConstants.Urls.BaseUrl)
    Observable<BaseGenericResult> deleteMaterialByUuid(@Field("uuid") String uuid);
//
//    /**
//     * 选题获取相关线索列表
//     *
//     * @param topicId 选题Id
//     * @param page    当前页数
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_RELATE_CLUE)
//    Observable<BaseGenericResult<ClueObject>> getRelateClue(@Field("topicId") int topicId, @Field("page") int page);
//
//    /**
//     * 意见反馈
//     *
//     * @param title
//     * @param content
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.FEED_BACK)
//    Observable<BaseResult> feedBack(@Field("title") String title, @Field("content") String content);
//
//    /**
//     * 保存图片
//     *
//     * @param fileUrl
//     * @return
//     */
//    @GET
//    Observable<ResponseBody> downloadPicture(@Url String fileUrl);
//
//    /**
//     * 根据uuid查相应的素材
//     *
//     * @param uuid
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.GET_MATERIAL)
//    Observable<MaterialImageModel> getmaterial(@Field("uuid") String uuid);
//
//    @Multipart
//    @POST(ApiConstants.Urls.UPLOAD_IMAGE)
//    Call<BaseGenericResult<UploadImageResult>> upload(@Part MultipartBody.Part attach);
//
//    //修改头像
//    @Multipart
//    @POST(ApiConstants.Urls.AVATAR_REPLACE)
//    Call<BaseGenericResult> avatar(@Part MultipartBody.Part icon);
//
//    //头像的修改
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.AVATAR_REPLACE)
//    Observable<BaseGenericResult> updateicon(@Field("icon") String icon);
//
//    /**
//     * 视频单独上传
//     *
//     * @param attach
//     * @return
//     */
//    @Multipart
//    @POST(ApiConstants.Urls.VIDEO_UPLOAD)
//    Observable<BaseGenericResult<VideoUploadModel>> uploadVideo(@Part MultipartBody.Part attach);
//
//    /**
//     * 图片多张单独上传
//     *
//     * @param parts
//     * @return
//     */
//    @Multipart
//    @POST(ApiConstants.Urls.VIDEO_DATA_UPLOAD)
//    Call<BaseResult> uploadPicture(@Part("name") RequestBody name,
//                                   @Part("description") RequestBody description,
//                                   @Part("writer") RequestBody writer,
//                                   @PartMap Map<String, Object> maps,
//                                   @Part("type") int type,
//                                   @Part("typeSon") int typeSon,
//                                   @Part List<MultipartBody.Part> parts);
//
//    /**
//     * 音频单独上传
//     *
//     * @param attach
//     * @return
//     */
//    @Multipart
//    @POST(ApiConstants.Urls.AUDIO_UPLOAD)
//    Call<VideoUploadModel> uploadAudio(@Part MultipartBody.Part attach);
//
//    /**
//     * @param description 描述
//     * @param type        素材类型 0 为图片 1 为视频 2 为音频
//     * @param typeSon     子分类
//     * @param url         视频音频网址
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.VIDEO_DATA_UPLOAD)
//    Observable<BaseResult> uploadData(@FieldMap Map<String, Integer> map, @Field("description") String description, @Field("type") int type, @Field("typeSon") int typeSon, @Field("url") String url, @Field("name") String name, @Field("size") String size);
//
//    /**
//     * @param description 描述
//     * @param type        素材类型 0 为图片 1 为视频 2 为音频
//     * @param typeSon     子分类
//     * @param url         视频音频网址
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.VIDEO_DATA_UPLOAD_NEW)
//    Observable<BaseResult> uploadDataNew(@FieldMap Map<String, Integer> map, @Field("description") String description, @Field("type") int type, @Field("typeSon") int typeSon, @Field("url") String url, @Field("name") String name, @Field("size") String size);
//    /*TODO*******         xk  Add  Start                  ************/
//
//
//    /**
//     * 所有的联系人
//     * /mobile/user/allusers
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.CONTACT_ALL)
//    Observable<DepartmentResult> getAllContactData(@Field("placeholder") int placeholder);
//
//
//    /**
//     * 线索库又称公共线索
//     * /mobile/clue/clues
//     * keywords	String	否	搜索线索标题的关键词
//     * page	int	是	当前页的页码   从 1 开始
//     * level	int	否	0：普通，1：紧急，2：加急，默认全部
//     * day	int	否	几天内的线索，默认全部
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.CLUE_LIBRARY)
//    Observable<ClueResult> getPublicClueData(@Field("page") int page, @Field("keywords") String keywords, @Field("level") int level, @Field("day") int day);
//
//
//    /**
//     * 我的线索
//     * /mobile/clue/clues
//     * keywords	String	否	搜索线索标题的关键词
//     * page	int	是	当前页的页码   从 1 开始
//     * level	int	否	0：普通，1：紧急，2：加急，默认全部
//     * day	int	否	几天内的线索，默认全部
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.CLUE_OF_MINE)
//    Observable<BaseGenericResult<ClueObject>> getMyClueData(@Field("page") int page, @Field("keywords") String keywords, @Field("level") int level, @Field("day") int day);
//    //    Observable<ClueResult> getMyClueData(@Field("page") int page, @Field("keywords") String keywords);
//
//
//    /**
//     * 我的线索：删除线索
//     * /mobile/clue/delete/{id}
//     * id	int	是	需要删除的线索 id
//     * type : post
//     */
//    @POST(ApiConstants.Urls.CLUE_DEL_CLUE_OF_MINE + "{id}")
//    Observable<BaseGenericResult> getDelMyClueData(@Path("id") int id);
//
//
//    /**
//     * 删除选题
//     * id	int	是	需要删除选题 id
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_DELETE)
//    Observable<BaseGenericResult> delMyTopic(@Field("id") int id);
//
//
//    /**
//     * 线索取为选题
//     * /mobile/clue/totopic/{id}
//     * id	int	是	要取用为选题的线索 ID
//     * type : post
//     */
//    @POST(ApiConstants.Urls.CLUE_BE_USED_TOPIC + "{id}")
//    Observable<BaseResult> clue_Be_Used_Topic_Data(@Path("id") int id);
//
//
//    /**
//     * 线索加入选题
//     * /mobile/clue/jointopic/{clueId}/{topicId}
//     * clueId	int	是	要加入选题的线索 id
//     * topicId	int	是	要加入的选题 id
//     * type : post
//     */
//    @POST(ApiConstants.Urls.CLUE_JOIN_TOPIC + "{clueId}" + "/" + "{topicId}")
//    Observable<BaseResult> clue_Join_Topic_Data(@Path("clueId") int clueId, @Path("topicId") int topicId);
//
//
//    /**
//     * 涉豫新闻列表
//     * /mobile/yq/syNewsList
//     * <p>
//     * orderType	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * page	        String	是	页码	从1开始
//     * timeType	    int	是	时间筛选类型	0  → 今天（正整数，传几就查几天内的新闻）
//     * city         int 1000_全部，1001_郑州，1002_开封，1003_洛阳, 1004_商丘，1005_安阳，1006_新乡，1007_许昌，1008_鹤壁，1009_焦作，1010_濮阳，1011_漯河，1012_周口，1013_南阳，1014_信阳，1015_济源，1016_平顶山，1017_三门峡，1018_驻马店
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.NEWS_RELATE_TO_HENAN)
//    Observable<YuNewsResult> getRelateToHeNanNewsData(@Field("orderType") int orderType, @Field("timeType") int timeType,
//                                                      @Field("page") String page, @Field("city") int city);
//
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.NEWS_DETAIL)
//    Observable<BaseGenericResult<YuNewsModel>> newsDetail(@Field("id") int id, @Field("isHL") int isHL);
//
//    /**
//     * 指令详情
//     *
//     * @param id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.INSTRUCTION_DETAIL)
//    Observable<BaseGenericResult<InstructionModel>> instructionDetail(@Field("id") int id);
//
//    /**
//     * 涉豫热搜列表
//     * /mobile/yq/syHotList
//     * <p>
//     * orderType	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * page	String	是	页码	从1开始
//     * timeType	int	是	时间筛选类型	0  → 今天（正整数，传几就查几天内的新闻）
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.HOT_RELATE_TO_HENAN)
//    Observable<YuNewsResult> getRelateToHeNan_Hot_Data(@Field("orderType") int orderType, @Field("timeType") int timeType, @Field("page") String page);
//
//
//    /**
//     * 政务新闻列表
//     * /mobile/yq/cpNewsList
//     * <p>
//     * orderType	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * page	String	是	页码	从1开始
//     * timeType	int	是	时间筛选类型	0  → 今天（正整数，传几就查几天内的新闻）
//     * type : post
//     * current politics
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.CURRENT_POLITICS_NEWS)
//    Observable<YuNewsResult> getCurrentPoliticsNewsData(@Field("orderType") int orderType, @Field("timeType") int timeType, @Field("page") String page);
//
//
//    /**
//     * 民生热点
//     * /mobile/livelihood/list
//     * <p>
//     * pager	String	是	页码
//     * order	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻）-1_全部
//     * province	int	是	18地市	1001郑州，1002开封，1003洛阳1004商丘，1005安阳，1006新乡，1007许昌，1008鹤壁，1009焦作，1010濮阳，1011漯河，1012周口，1013南阳，1014信阳，1015济源，1016平顶山，1017三门峡，1018驻马店
//     * sourceType	int	否	来源
//     * <p>
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.LIVELIHOOD_HOT_NEWS)
//    Observable<BaseGenericResult<LivelihoodObject>> getLivelihoodHotNewsData(@Field("pager") String page, @Field("order") int orderType,
//                                                                             @Field("timeType") int timeType, @Field("province") int province); //  @Field("sourceType") int sourceType
//
//    /**
//     * 民生热点详情界面
//     * /mobile/livelihood/getlivelihood/{id}
//     * <p>
//     * id	int	是  新闻id
//     * <p>
//     * type : post
//     */
//    @POST(ApiConstants.Urls.LIVELIHOOD_HOT_NEWS_DETAIL + "{id}")
//    Observable<BaseGenericResult<LivelihoodModel>> getLivelihoodHotNewsDetail(@Path("id") int id);
//
//
//    /**
//     * 新华社电稿列表
//     * /mobile/ncna/ncnaList
//     * <p>
//     * orderType	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * page	String	是	页码	从1开始
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻）-1_全部
//     * international   int	是
//     *
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.XINHUA_NEWS_LIST)
//    Observable<BaseGenericResult<YuNewsObject>> getXinHuaSheNewsData(@Field("orderType") int orderType, @Field("timeType") int timeType, @Field("page") String page, @Field("international") int international);
//
//
//    /**
//     * 主流媒体列表
//     * /mobile/yq/mmNewsList
//     * <p>
//     * orderType	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * page	String	是	页码	从1开始
//     * timeType	int	是	时间筛选类型	0  → 今天（正整数，传几就查几天内的新闻）
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.MAIN_STREAM_MEDIA_NEWS)
//    Observable<YuNewsResult> getMainStreamMediaNewsData(@Field("orderType") int orderType, @Field("timeType") int timeType, @Field("page") String page);
//
//
//    /**
//     * 特殊新闻源列表
//     * /mobile/yq/specialnewslist
//     * orderType	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * page	String	是	页码	从1开始
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻）-1_全部
//     * source	String	是	来源名称	需要央视网的新闻列表就传“央视网”，微信的新闻列表需要传具体的微信号名字
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.SPECIAL_NEWS_LIST)
//    Observable<YuNewsResult> getSpecialNewsListData(@Field("page") String page, @Field("orderType") int orderType, @Field("timeType") int timeType, @Field("source") String source);
//
//
//    /**
//     * 舆情方案列表
//     * /mobile/consensusplan/planlist
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.YU_QING_PLAN_LIST)
//    Observable<YuQingResult> getYuQingPlanListData(@Field("page") int temp);
//
//
//    /**
//     * 舆情方案删除
//     * /mobile/consensusplan/del
//     * id	int	是	方案id
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.YU_QING_PLAN_DEL)
//    Observable<YuQingResult> getYuQingPlanDelData(@Field("id") int id);
//
//
//    /**
//     * 舆情方案对应的新闻列表
//     * /mobile/consensusplan/newslist
//     * <p>
//     * id	int	是	方案id
//     * timeType	int	是	时间查询类型	0_今天（正整数，传几就查几天内的新闻）
//     * sourceType	int	是	来源查询类型	0_网站、1_微博、2_微信、3_论坛、4_政务、5_报刊、6_APP
//     * orderType	int	是	按时间排序类型	0 按时间倒序、1 按时间正序
//     * sens	int	是	敏感查询类型	0 敏感、1 不敏感
//     * page	int	是	页码	从1开始
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.YU_QING_PLAN_NEWS_LIST)
//    Observable<YuQingNewsListResult> getYuQingNewsListData(@Field("id") int id, @Field("page") int page, @Field("timeType") int timeType,
//                                                           @Field("sourceType") int sourceType, @Field("orderType") int orderType, @Field("sens") int sens);
//
//
//    /**
//     * 公共选题列表
//     * /mobile/topic/topics
//     * <p>
//     * <p>
//     * day	    int	否	第一天第二天等等	无
//     * page	    int	是	分页用到的	1
//     * status	int	否	公共选题状态不传搜所有	参考选题状态吗
//     * sortType	int	否	倒序正序排列	无	0 是倒序（后端默认值） 1是正序排列
//     * keyword	String	关键字
//     * <p>
//     * <p>
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_LIBRARY)
//    Observable<BaseGenericResult<TopicObject>> getTopicLibraryData(@Field("page") int page, @Field("status") int status,
//                                                                   @Field("day") int day, @Field("sortType") int sortType,
//                                                                   @Field("keyword") String keyword);
//
//
//    /**
//     * 我的选题列表
//     * /mobile/topic/mytopic
//     * <p>
//     * day	    int	否	第一天第二天等等	无
//     * page	    int	是	分页用到的	1
//     * sortType	int	否	倒序正序排列	无	0 是倒序（后端默认值） 1是正序排列
//     * audit	int	是	新闻状态	参考选题状态码
//     * keyword	String	关键字
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_OF_MINE)
//    Observable<BaseGenericResult<TopicObject>> getTopicOfMineData(@Field("page") int page, @Field("audit") int audit,
//                                                                  @Field("day") int day, @Field("sortType") int sortType, @Field("keyword") String keyword);
//
//    /**
//     * 策划列表
//     * /mobile/plan/planlist/
//     * <p>
//     * page	int	第几页
//     * day	int	几天内（默认-1，全部）
//     * status	int	状态（默认-2，全部）
//     * keyword	String	关键字
//     * <p>
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.PLAN_LIBRARY)
//    Observable<BaseGenericResult<PlanObject>> getPlanLibraryData(@Field("page") int page, @Field("day") int day,
//                                                                 @Field("status") int status, @Field("keyword") String keyword);
//
//
//    /**
//     * 待审核选题列表
//     * /mobile/topic/noaudittopics
//     * <p>
//     * <p>
//     * page	不解释了	无
//     * sortType	int	0 倒序 1 正序
//     * day	int	天数	-1是全部
//     * keyword	String	关键字
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_WAIT_ADUIT)
//    Observable<BaseGenericResult<TopicObject>> getTopicWaitAduitMineData(@Field("page") int page, @Field("day") int day,
//                                                                         @Field("sortType") int sortType, @Field("keyword") String keyword);
//
//
//    /**
//     * 我的策划列表 （选题和策划是同一个接口，根据type值区分）
//     * /mobile/topic/mytopic
//     * <p>
//     * status	String	否	状态	4进行中：3已结束；默认为““
//     * day	int	是	几天的数据	默认为0
//     * page	int	是	当前页的页码	从1开始
//     * type	String	是	选题类型	0选题 1策划
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.PLAN_OF_MINE)
//    Observable<TopicResult> getPlanOfMineData(@Field("page") int page, @Field("type") String type, @Field("status") String status, @Field("day") int day);
//
//
//    /**
//     * 记者稿件列表接口
//     * /mobile/news/finddrafts
//     * <p>
//     * page	int	        是	当前页	从1开始
//     * sortType	int	    否	根据时间排序	0:倒序(默认),1:正序
//     * stetu	int	        否	稿件状态	-1:全部(默认),0：待发送，1:审核中，5：退稿，8：撤回
//     * timeType	int	    是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻）
//     * keyword	String	否	搜索关键字
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POSTS_PERSONAL_LIST)
//    Observable<PostResult> getPostOfMineListData(@Field("page") int page, @Field("timeType") int timeType,
//                                                 @Field("sortType") int sortType, @Field("stetu") int stetu,
//                                                 @Field("keyword") String keyword);
//
//    /**
//     * 部门稿件列表接口
//     * /mobile/news/getdepNews
//     * <p>
//     * page	int	        是	当前页	从1开始
//     * sortType	int	    否	根据时间排序	0:倒序(默认),1:正序
//     * stetu	int	        否	稿件状态	-1:全部(默认),0：待发送，1:审核中，5：退稿，8：撤回
//     * timeType	int	    是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻）
//     * keyword	String	否	搜索关键字
//     * <p>
//     * type : post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POSTS_OF_DEPARTMENT)
//    Observable<PostResult> getPostOfDepartmentListData(@Field("page") int page, @Field("timeType") int timeType,
//                                                       @Field("sortType") int sortType, @Field("stetu") int stetu, @Field("keyword") String keyword);
//
//
//    /**
//     * 公共稿库列表接口
//     * <p>
//     * page	int	是	当前页	从1开始
//     * sortType	int	否	根据时间排序	0:倒序(默认),1:正序
//     * sourceId	int	否	来源id	-
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻）
//     * keyword	String	否	搜索关键字
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POSTS_LIBRARY)
//    Observable<PostResult> getPostLibraryListData(@Field("page") int page, @Field("timeType") int timeType,
//                                                  @Field("sourceId") int sourceId, @Field("sortType") int sortType,
//                                                  @Field("keyword") String keyword);
//
//
//    /**
//     * 总稿库列表接口
//     * /mobile/news/getgeneraldraftnews
//     * <p>
//     * <p>
//     * page	    int	是	当前页	从1开始
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻） -1代表全部
//     * sortType	int	否	根据时间排序	0:倒序(默认),1:正序
//     * sourceId	int	否	新闻来源	默认值是0 搜索全部
//     * stetu	int	否	新闻状态	默认值是-1 搜索全部
//     * keyword	String	否	搜索关键字
//     * <p>
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.ZONG_GAO_KU)
//    Observable<PostResult> getZongGaoKuListData(@Field("page") int page, @Field("timeType") int timeType,
//                                                @Field("sortType") int sortType, @Field("sourceId") int sourceId,
//                                                @Field("stetu") int stetu, @Field("keyword") String keyword);
//
//
//    /**
//     * 我的审核列表接口(审稿平台)：
//     * /mobile/news/waitaudit
//     * <p>
//     * page	int	是	当前页	从1开始
//     * sortType	int	否	根据时间排序	0:倒序(默认),1:正序
//     * newsGrade	int	否	新闻紧急程度	-1:所有(默认),0:普通,1:紧急,2:加急
//     * audited	int	是	待审核或者已审	0是待审核 1 是已审核
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻）-1代表全部
//     * keyword	String	否	搜索关键字
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POSTS_WAIT_ADUIT)
//    Observable<PostResult> getPostWaitAduitListData(@Field("page") int page,
//                                                    @Field("timeType") int timeType, @Field("sortType") int sortType,
//                                                    @Field("newsGrade") int newsGrade, @Field("audited") int audited,
//                                                    @Field("keyword") String keyword);
//
//
//    /**
//     * 调度中心： 全部线索、用户
//     * https://rm.dahe.cn/lbs/usersandclues
//     * /lbs/usersandclues
//     * <p>
//     * type : GET
//     */
//    @GET(ApiConstants.Urls.LBS_COMMAND_CENTER)
//    Observable<CommandResult> getCommandCenterData();
//
//
//    /**
//     * 调度中心 → 附近的线索
//     * /lbs/nearbyclue
//     * lng	double	是	当前经度
//     * lat	double	是	当前纬度
//     * type : GET
//     */
//    @GET(ApiConstants.Urls.LBS_NEAR_BY_CLUE)
//    Observable<ClueNearByResult> getLbsNearByClueData(@Query("lng") double lng, @Query("lat") double lat);
//
//
//    /**
//     * 调度中心 → 附近的记者
//     * /lbs/nearbyuser
//     * <p>
//     * lng	double	是	当前经度
//     * lat	double	是	当前纬度
//     * <p>
//     * type : GET
//     */
//    @GET(ApiConstants.Urls.LBS_NEAR_BY_REPORTER)
//    Observable<ContactResult> getLbsNearByReporterData(@Query("lng") double lng, @Query("lat") double lat);
//
//
//    /**
//     * 根据分类查找相应的素材
//     * /mobile/material/getmaterialbytype
//     * <p>
//     * pager	int	否	分页参数
//     * type	String	是	素材类型 0 为图片 1 为视频 2 为音频
//     * typeson	String	否	素材子类型
//     * <p>
//     * overt	String	否	素材是否公开
//     * day	int	否	默认为0 查询当前
//     * userId	int	否	我的素材需添加
//     * clueId	String	否	线索id
//     * topicId	String	否	选题id
//     * planId	String	否	策划id
//     * title	String  否	素材名称
//     * <p>
//     * <p>
//     * type : POST
//     *
//     * @Field("userId") int userId, @Field("clueId") String clueId, @Field("overt") String overt
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.MATERIAL)
//    Observable<MaterialResult> getMaterialData(@Field("page") int pager, @Field("type") String type, @Field("typeson") String typeson,
//                                               @Field("day") int day, @Field("clueId") String clueId, @Field("topicId") String topicId,
//                                               @Field("planId") String planId, @Field("title") String title);
//
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.MATERIAL_OF_MINE)
//    Observable<MaterialResult> getMaterialOfMineData(@Field("page") int pager, @Field("type") String type, @Field("typeson") String typeson,
//                                                     @Field("day") int day, @Field("clueId") String clueId, @Field("topicId") String topicId,
//                                                     @Field("planId") String planId, @Field("title") String title, @Field("userId") int userId);
//
//    /**
//     * 微博新闻列表
//     * /mobile/yq/sinanewslist
//     * <p>
//     * orderType	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * page	String	是	页码	从1开始
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻）
//     * source	String	是	来源名称	传具体的微博用户名
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.WEIBO_NEWS_LIST)
//    Observable<YuNewsResult> getWeiBoNewsData(@Field("orderType") int orderType, @Field("timeType") int timeType,
//                                              @Field("page") String page, @Field("source") String source);
//
//
//    /**
//     * 特殊新闻源,微信公众号新闻列表
//     * /mobile/yq/sinanewslist
//     * <p>
//     * orderType	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * page	String	是	页码	从1开始
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻）
//     * source	String	是	来源名称	需要央视网的新闻列表就传“央视网”，微信的新闻列表需要传具体的微信号名字
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.SPECIALOR_WEIXIN_NEWS_LIST)
//    Observable<YuNewsResult> getSpecial_WeiXin_NewsData(@Field("orderType") int orderType, @Field("timeType") int timeType,
//                                                        @Field("page") String page, @Field("source") String source);
//
//
//    /**
//     * 用户所属的指令列表
//     * /mobile/instruction/list
//     * orderType	int	是	排序类型	0 按时间倒序、1 按时间正序
//     * page	String	是	页码	从1开始
//     * startTime	String	否	最早时间
//     * endTime	String	否	最晚时间
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.INSTRUCTION_LIST)
//    Observable<BaseGenericResult<InstructionObject>> getInstructionListData(@Field("page") String page, @Field("orderType") int orderType);
//
//
//    /**
//     * 传播效果新闻流接口
//     * /mobile/news/opennews
//     * <p>
//     * page	int	是	当前页	从1开始
//     * sortType	int	否	根据时间排序	0:倒序(默认),1:正序
//     * sourceId	int	否	来源id	-
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻） -1代表全部
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.NEW_SPREAD_LIST)
//    Observable<BaseGenericResult<NewsSpreadObject>> getNewsSpreadListData(@Field("page") int page, @Field("timeType") int timeType,
//                                                                          @Field("sortType") int sortType, @Field("sourceId") int sourceId);
//
//
//    /**
//     * 多平台预发(列表)
//     * /mobile/news/multiplatformnews
//     * <p>
//     * page	int	是	当前页	从1开始
//     * sortType	int	否	根据时间排序	0:倒序(默认),1:正序
//     * sourceId	int	否	来源id	-
//     * timeType	int	是	时间筛选类型	0_今天（正整数，传几就查几天内的新闻） -1代表全部
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.MULTI_PLATFORM_NEWS_LIST)
//    Observable<BaseGenericResult<NewsSpreadObject>> getMultiPlatformNewsListData(@Field("page") int page, @Field("timeType") int timeType,
//                                                                                 @Field("sortType") int sortType, @Field("sourceId") int sourceId);
//
//    /**
//     * 选题相关稿件列表
//     * /mobile/topic/newslist
//     * <p>
//     * topicId	int	是	选题Id	-
//     * page	int	是	当前页数	-
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_RELATE_POST_LIST)
//    Observable<BaseGenericResult<PostObject>> getPostRelateListData(@Field("topicId") int topicId, @Field("page") int page);
//
//
//    /**
//     * 选题相关稿件列表
//     * /mobile/plan/getnews
//     * <p>
//     * planId	int	策划的 id
//     * page	int	是	当前页数	-
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.PLAN_RELATE_POST_LIST)
//    Observable<BaseGenericResult<PostObject>> getPlanRelatePostListData(@Field("planId") int topicId, @Field("page") int page);
//
//
//    /**
//     * 选题相关素材列表
//     * /mobile/topic/materials
//     * <p>
//     * topicId	int	是	选题Id	-
//     * page	int	是	当前页数	-
//     * type	int	素材类型	0 图片 1是视频 2是音乐
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_RELATE_MATERIAL_LIST)
//    Observable<BaseGenericResult<MaterialObject>> getTopicRelateMaterialListData(@Field("topicId") int topicId, @Field("page") int page,
//                                                                                 @Field("type") int type);
//
//    /**
//     * 策划相关素材列表
//     * /mobile/plan/getmaterials
//     * <p>
//     * planId	int	是	策划Id	-
//     * page	int	是	当前页数	-
//     * type	int	素材类型	0 图片 1是视频 2是音乐
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.PLAN_RELATE_MATERIAL_LIST)
//    Observable<BaseGenericResult<MaterialObject>> getPlanRelateMaterialListData(@Field("planId") int planId, @Field("page") int page,
//                                                                                @Field("type") int type);
//
//    /**
//     * 策划相关线索列表
//     * /mobile/plan/getclues
//     * <p>
//     * planId	int	策划的 id
//     * page	int	是	当前页数	-
//     * <p>
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.PLAN_RELATE_CLUE_LIST)
//    Observable<BaseGenericResult<ClueObject>> getPlanRelateClue(@Field("planId") int planId, @Field("page") int page);
//
//
//    /**
//     * 选题管理：获得参加该选题的人员
//     * /mobile/topic/users
//     * topicId	int	是	选题Id	-
//     * type : POST
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_RELATE_USER_LIST)
//    Observable<BaseGenericResult<List<Contact>>> getContactRelateData(@Field("topicId") int topicId);
//
//    /**
//     * 策划管理：获得参加该策划的人员
//     *
//     * @param topicId 策划的 id
//     * @param page    页数
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_RELATE_GET_USERS_LIST)
//    Observable<BaseGenericResult<List<Contact>>> getPlanContactRelateData(@Field("planId") int topicId, @Field("page") int page);
//
//
//    /**
//     * 稿件发布选择一级栏目
//     * /mobile/dep/mediadep
//     * <p>
//     * type : GET
//     */
//    @GET(ApiConstants.Urls.POST_SING_SELECT_DEPARTMENT)
//    Observable<BaseGenericResult<List<SignDepartmentModel>>> getPostSignDepartmentData();
//
//
//    /**
//     * 发布新闻到某个栏目下
//     * /mobile/open/pushnews/{id}/{channel}
//     * channel	String	栏目的id	是
//     * id	int	新闻id	是
//     * type : POST
//     */
//    @POST(ApiConstants.Urls.POST_SING_HANDLER + "{id}" + "/" + "{channel}")
//    Observable<BaseGenericResult> handlerPostSign(@Path("id") int postId, @Path("channel") String channel);
//
//
//    /**
//     *  获得系统信息的列表
//     *  /mobile/systemnotice/systeminfolist
//     *  page	分页	是
//     *  sortType	倒序正序	否
//     *  timeType	天数	否
//     *  type : POST
//     *
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.SYS_NOTIFY)
//    Observable<BaseGenericResult<SysNotifyObject>> getSysNotifyData(@Field("page") int page, @Field("timeType") int timeType, @Field("sortType") int sortType);
//
//    /**
//     *  系统通知详情接口
//     *  /mobile/systemnotice/getsysinfo/{id}
//     *
//     *  type : GET
//     *
//     */
//    @GET(ApiConstants.Urls.SYS_NOTIFY_DETAIL)
//    Observable<BaseGenericResult<SysNotifyModel>> sysNotifyDetail(@Path("id") int id);
//
//
//
//
//    /**
//     * 示例代码
//     *
//     * @return
//     */
//    @GET(ApiConstants.Urls.MUTL + "{channelId}/{page}")
//    Observable<SheShiDuResult> getSheShiDuData(@Path("channelId") String channelId, @Path("page") int page);
//
//
//
//    /*TODO*******         xk  Add  End                  ************/
//
//
//    /**
//     * 登录
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.LOGIN)
//    Observable<BaseGenericResult<LoginObject>> login(@Field("phone") String phone, @Field("smsCode") String smsCode);
//
//
//    /**
//     * 扫描二维码登录PC端
//     * uuid	String	二维码扫出来的 UUID 值
//     * token	String	手机端登录后返回的 token
//     * type  post
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.ERCODE_PC_LOGIN)
//    Observable<BaseGenericResult> ercode_pc_login(@Field("uuid") String uuid, @Field("token") String token);
//
//
//    /**
//     * 短信验证码
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.SMS)
//    Observable<BaseGenericResult> getSms(@Field("phone") String phone);
//
//    /**
//     * 方案添加
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.BLUE_ADD)
//    Observable<BaseGenericResult> blueAdd(@Field("planName") String planName, @Field("areaKeyWord") String areaKeyWord, @Field("peopleKeyWord") String peopleKeyWord, @Field("eventKeyWord") String eventKeyWord, @Field("removeKeyWord") String removeKeyWord);
//
//    /**
//     * 方案编辑
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.BLUE_EDIT)
//    Observable<BaseGenericResult> blueEdit(@Field("id") int id, @Field("planName") String planName, @Field("areaKeyWord") String areaKeyWord, @Field("peopleKeyWord") String peopleKeyWord, @Field("eventKeyWord") String eventKeyWord, @Field("removeKeyWord") String removeKeyWord);
//
//    /**
//     * 线索添加
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.CLUE_ADD)
//    Observable<BaseResult> clueAdd(@Field("lng") double lng, @Field("lat") double lat, @Field("occurrenceAddress") String occurrenceAddress, @Field("level") int level, @Field("name") String name, @Field("content") String content, @Field("brokePeople") String broke_people, @Field("brokeMobile") String broke_mobile);
//
//    /**
//     * 上传素材：视频分类
//     */
//    @GET(ApiConstants.Urls.VIDEO_TYPE)
//    Observable<VideoTypeModel> getVideoType();
//
//    /**
//     * 上传素材：音频分类
//     */
//    @GET(ApiConstants.Urls.AUDIO_TYPE)
//    Observable<VideoTypeModel> getAudioType();
//
//    /**
//     * 上传素材：图片分类
//     */
//    @GET(ApiConstants.Urls.IMAGE_TYPE)
//    Observable<VideoTypeModel> getPictureType();
//
//
//    /**
//     * 添加选题
//     * /mobile/topic/add
//     * title	String	是	选题标题	否
//     * description	String	是	选题内容	否
//     * auditorId	int	是	审核人id	否 以上内容都在topic内	后端以对象接收
//     * topicNote	String	备注信息
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.UPLOAD_TOPIC)
//    Observable<BaseResult> uploadTopic(@Field("title") String title, @Field("description") String description,
//                                       @Field("topicNote") String topicNote, @Field("auditorId") int auditorId);
//
//    /**
//     *  添加指令通知
//     * @param title 指令標題
//     * @param content 指令内容
//     * @param ids 指令接收人id ，	多个人用英文“，”分割
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.ADD_INSTRUCTION)
//    Observable<BaseResult> addInstruction(@Field("title") String title, @Field("content") String content, @Field("ids") String ids);
//
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.UPLOAD_NEWS)
//    Observable<BaseResult> uploadNews(@Field("id") int id, @Field("title") String title, @Field("content") String content, @Field("topicId") int topicId, @Field("planId") int planId, @Field("videoLink") String videoLink, @Field("videoThumb") String videoThumb, @Field("wordCount") int wordCount, @Field("oldApp") int oldApp);
//
//    /**
//     * 选题详情
//     * @param id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_DETAIL)
//    Observable<BaseGenericResult<TopicDetailModel>> topicDetail(@Field("id") int id);
//
//    /**
//     * 策划详情
//     * @param id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.PLAN_DETAIL)
//    Observable<BaseGenericResult<TopicDetailModel>> planDetail(@Field("id") int id);
//
//    /**
//     * 稿件详情
//     *
//     * @param id
//     * @return
//     */
//    @GET(ApiConstants.Urls.POST_DETAIL)
//    Observable<BaseGenericResult<PostModel>> postDetail(@Path("id") int id);
//
//
//    /**
//     * 公共稿库查看单个(公共稿库详情)
//     */
//    @GET(ApiConstants.Urls.POST_LIBRARY_DETAIL)
//    Observable<BaseGenericResult<PostModel>> postLibraryDetail(@Path("id") int id);
//
//
//    /**
//     * 添加新闻稿件
//     */
//
//
//    /**
//     * 所有选题或策划
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPICS)
//    Observable<BaseGenericResult<List<TopicModel>>> topics(@Field("id") String id);
//
//    /**
//     * 审稿平台传稿
//     *
//     * @param ids        新闻id
//     * @param suggestion 审批意见
//     * @param sendUser   下级审核人
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POST_SEND)
//    Observable<BaseGenericResult> postSend(@Field("ids") int ids, @Field("suggestion") String suggestion, @Field("sendUser") int sendUser, @Field("box") int box);
//
//
//    /**
//     * 我的稿件传稿接口
//     *
//     * @param id        新闻ID
//     * @param newsGrade 新闻紧急程度	-1:所有(默认),0:普通,1:紧急,2:加急
//     * @param reviewMan 审核人ID
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POST_SENDONEEDIT)
//    Observable<BaseGenericResult> postSendoneedit(@Field("id") int id, @Field("newsGrade") int newsGrade, @Field("reviewMan") int reviewMan, @Field("remarks") String remarks);
//
//    /**
//     * 退稿
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POST_REJECT)
//    Observable<BaseGenericResult> postReject(@Field("id") int id, @Field("suggestion") String suggestion);
//
//    /**
//     * 发布
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POST_SIGN)
//    Observable<BaseGenericResult> postSign(@Path("id") int id);
//
//    /**
//     * 作废
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POST_DESTROY)
//    Observable<BaseGenericResult> postDestroy(@Field("id") int id, @Field("suggestion") String suggestion);
//
//    /**
//     * 作废
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POST_DEL)
//    Observable<BaseGenericResult> postDel(@Path("id") int id, @Field("temp") String temp);
//
//    /**
//     * 撤回
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.POST_RECALL)
//    Observable<BaseGenericResult> postRecall(@Field("ids") int ids, @Field("suggestion") String suggestion);
//
//    /**
//     * 选题审核
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_CHECK)
//    Observable<BaseGenericResult> topicCheck(@Field("id") int id, @Field("audit") int audit);
//
//    /**
//     * 获取用户信息
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.USER_INFO)
//    Observable<BaseGenericResult<LoginObject>> getUserInfo(@Field("id") int id);
//
//    /**
//     * 视频单独上传
//     *
//     * @param attach
//     * @return
//     */
//    @Multipart
//    @POST(ApiConstants.Urls.VIDEO_UPLOAD)
//    Observable<BaseGenericResult<UploadModel>> uploadV(@Part MultipartBody.Part attach);
//
//    /**
//     * 文件上传
//     *
//     * @param parts
//     * @return
//     */
//    @Multipart
//    @POST()
//    Observable<BaseGenericResult> uploadFile(@Url String url, @Part List<MultipartBody.Part> parts);
//
//    /**
//     * 传播效果详情
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.SPREAD_DETAIL)
//    Observable<BaseGenericResult<PostModel>> getSpreadDetail(@Field("id") int id);
//
//    /**
//     * 传播效果图表数据
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.SPREAD_CHART)
//    Observable<BaseGenericResult> getSpreadChart(@Field("id") int id);
//
//    /**
//     * 多平台取用
//     */
//    @GET(ApiConstants.Urls.MULTI_USE)
//    Observable<BaseGenericResult> multiUse(@Path("newsId") int newsId);
//
//    /**
//     * 多平台取用
//     */
//    @GET(ApiConstants.Urls.POST_USE)
//    Observable<BaseGenericResult> postUse(@Path("newsId") int newsId);
//
//    /**
//     * 取用之前进行判断（判断当前部门是否有人取用过该新闻）（公共稿库）
//     * /mobile/news/takenewsjudgment/{newsId}
//     * newsId	int	是	当前新闻的id
//     * 如果已取用 状态码 500	无人取用 状态码200
//     * 状态码是501 表示不能取用自己的新闻	状态码是502 表示不能重复取用
//     */
//    @GET(ApiConstants.Urls.CHECK_POST_CAN_BE_USE_OR_NOT)
//    Observable<BaseGenericResult> checkPostCanBeUseOrNot(@Path("newsId") int newsId);
//
//
//    /**
//     * 取用之前进行判断（判断当前部门是否有人取用过该新闻）（多平台预发）
//     * /mobile/news/takenewsinmany/{newsId}
//     * newsId	int	是	当前新闻的id
//     * 如果已取用 状态码 500	无人取用 状态码200
//     * 状态码是501 表示不能取用自己的新闻	状态码是502 表示不能重复取用
//     */
//    @GET(ApiConstants.Urls.CHECK_MUTIPLATFORM_POST_CAN_BE_USE_OR_NOT)
//    Observable<BaseGenericResult> checkMutiPlatformPostCanBeUseOrNot(@Path("newsId") int newsId);
//
//
//    /**
//     * 多平台详情
//     */
//    @GET(ApiConstants.Urls.MULTI_DETAIL)
//    Observable<BaseGenericResult<PostModel>> multiDetail(@Path("id") int id);
//
//    /**
//     * 位置上报
//     */
//    @GET(ApiConstants.Urls.LOCATION_UPLOAD)
//    Observable<BaseGenericResult> uploadLbs(@Query("lng") double lng, @Query("lat") double lat);
//
//    /**
//     * 联系人
//     */
//    @POST(ApiConstants.Urls.CONTACT)
//    @FormUrlEncoded
//    Observable<BaseGenericResult<DepartContactObject>> getContact(@Field("temp") int temp);
//
//    /**
//     * 新华社电稿详情
//     */
//    @POST(ApiConstants.Urls.XINHUAN_DETAIL)
//    @FormUrlEncoded
//    Observable<BaseGenericResult<YuNewsModel>> getXinHuaDetail(@Field("id") int id);
//
//    /**
//     * 选择审核人
//     */
//    @POST(ApiConstants.Urls.CHECK_USER)
//    @FormUrlEncoded
//    Observable<BaseGenericResult<DepartContactObject>> getCheck(@Field("id") int id);
//
//    /**
//     * 获取七牛token
//     */
//    @POST(ApiConstants.Urls.QINIU_TOKEN)
//    @FormUrlEncoded
//    Observable<BaseGenericResult<String>> getQiNiu(@Field("id") int id);
//
//    /**
//     * 添加选题参与人员
//     */
//    @POST(ApiConstants.Urls.ADD_CONTACT_MODEL)
//    @FormUrlEncoded
//    Observable<BaseGenericResult> addContactToServer(@Field("topicId") int topicId, @Field("userId") String userId);
//
//    /**
//     * 选题详情：送审（多级审核）
//     *
//     * @param id         选题id （必须）
//     * @param auditorId  送审给谁 类似于传稿 （必须）
//     * @param topicNotes 备注信息
//     * @param keyword    关键字
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_SEND)
//    Observable<BaseGenericResult> topicSend(@Field("id") int id, @Field("auditorId") int auditorId, @Field("topicNotes") String topicNotes, @Field("keyword") String keyword);
//
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_SEND_NEW)
//    Observable<BaseGenericResult> topicSendNew(@Field("id") int id, @Field("auditorId") int auditorId, @Field("topicNotes") String topicNotes, @Field("keyword") String keyword);
//
//    /**
//     * 审核选题
//     * @param map
//     *
//     *  id	int	 选题id
//        audit	int	 审核动作(1 是审核通过 -1审核未通过)
//        suggestion	审核意见	-
//        userId	String	下一人
//        逻辑：	-	-
//        不选择下一人 点击通过 表示 通过该选题进入进行中	topic的id+意见+audit=1
//        选择下一人 点击通过 表示 将该选题送审到下一人审核	topic的id+意见+userId+audit=1
//        不同意	选题id +意见+audit=-1
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TOPIC_SEND_NEW)
//    Observable<BaseGenericResult> topicPassOrNot(@FieldMap Map<String, Object> map);
//
//
//    /**
//     * 取用新闻 (取为稿件)
//     * <p>
//     * //     * @param title 新闻标题
//     * //     * @param content 新闻内容
//     * //     * @param id 新闻id (只有新华社电稿传值)
//     *
//     * @return
//     */
//    //    @FormUrlEncoded
//    //    @POST(ApiConstants.Urls.TO_NEWS)
//    //    Observable<BaseGenericResult> toNews(@Field("title") String title, @Field("content") String content, @Field("id") int id);
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TO_NEWS)
//    Observable<BaseGenericResult> toNews(@FieldMap Map<String, Object> map);
//
//    /**
//     * (取为线索)
//     *
//     * @param title   线索名称
//     * @param content 线索内容
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.TO_CLUES)
//    Observable<BaseGenericResult> toClues(@Field("title") String title, @Field("content") String content);
//
//    /**
//     * 登录页图片
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(ApiConstants.Urls.LOGIN_IMAGE)
//    Observable<BaseGenericResult<String>> getFirstPageImage(@Field("url") String url);
//
//    /**
//     * 获得未读消息
//     */
//    @GET(ApiConstants.Urls.UN_READ)
//    Observable<BaseGenericResult<ArrayList<UnreadModel>>> getUnread();
}

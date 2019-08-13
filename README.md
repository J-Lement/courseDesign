# courseDesign

### JavaWeb课程设计

基于mvc模式的图书推荐系统

* #### 基本管理子系统

  1. 对辅导书的录入、删除、修改、查询等操作；
  2. 学校管理、学校对应专业管理、专业对应课程管理；
  3. 管理员可以实时广播通知（向每一个客户端实时广播一条通知）；
  4. 管理员可以对评论管理、删除、显示是否违规（状态）;
  5. 用户查询与管理；
  6. 评论违规禁词规则字典上传与修改。
  7. 管理员对学生用户上传的参考书的审核；

* #### 参考书推荐子系统

  1. 推荐模块：基于学生在校课程，进行智能推荐（参考半衰期公式，自定义热度排序推荐算法，如下：

     m=M*(1/2)^(t/T)）课程的辅导书，筛选出5本最优的辅导书，同时根据当前学年推荐以及用户关注度推荐；

  （2）评分与评论模块：用户可以对使用过的课程辅导书进行打分（五分制），每个用户只有一次打分机会，并且也可以对该书进行互动评论，可以为其他用户提供有价值的信息；

* #### 日常使用子系统

  （1）书签模块：对正在使用的书籍，用户可以进行阅读精度提醒设置与取消，用户再次登录根据用户设置的时间发送一条阅读提醒通知提醒用户该阅读书籍，提高用户自主性；

  （2）关注与收藏模块：用户可以根据个人兴趣关注某个课程，系统会根据用户所关注的课程推荐相应最优该课程辅导书籍，用户可对关注课程进行取消关注；用户可以对自己喜欢的课程辅导书进行收藏与取消收藏，可以方便用户及时查看自己的兴趣以及使用书籍，无需重复检索；

  （3）课程检索模块：用户可以进行课程关键词检索，根据用户关键词显示相应课程以及该课程的相关辅导书推荐；

### spring课程设计

基于ssm框架的医院管理系统

1. 服务窗口：预约挂号、登记办卡、分配医生、收费。
2. 医生：诊断病人、化验检查、处方开药、静脉注射。
3. 药房：药厂信息管理、药品信息管理、药品分类、药品采购、药品领用、病人取药。
4. 管理员：科室维护、人员维护。
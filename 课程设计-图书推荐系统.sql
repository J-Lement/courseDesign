/*
 Navicat Premium Data Transfer

 Source Server         : DESKTOP-3OSQPGL
 Source Server Type    : SQL Server
 Source Server Version : 12002000
 Source Host           : DESKTOP-3OSQPGL:1433
 Source Catalog        : sd
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 12002000
 File Encoding         : 65001

 Date: 18/01/2019 15:28:24
*/


-- ----------------------------
-- Table structure for allUser
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[allUser]') AND type IN ('U'))
	DROP TABLE [dbo].[allUser]
GO

CREATE TABLE [dbo].[allUser] (
  [userId] int  NOT NULL,
  [username] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [password] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [userType] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[allUser] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of allUser
-- ----------------------------
INSERT INTO [dbo].[allUser]  VALUES (N'110', N'lee', N'123', N'管理员')
GO

INSERT INTO [dbo].[allUser]  VALUES (N'162012', N'lee', N'123', N'学生')
GO

INSERT INTO [dbo].[allUser]  VALUES (N'162013', N'月亮', N'321', N'学生')
GO

INSERT INTO [dbo].[allUser]  VALUES (N'162014', N'sdf', N'123', N'学生')
GO

INSERT INTO [dbo].[allUser]  VALUES (N'162015', N'ewe', N'123', N'学生')
GO

INSERT INTO [dbo].[allUser]  VALUES (N'162017', N'lee', N'', N'管理员')
GO


-- ----------------------------
-- Table structure for Book
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Book]') AND type IN ('U'))
	DROP TABLE [dbo].[Book]
GO

CREATE TABLE [dbo].[Book] (
  [bookId] int  NOT NULL,
  [bookName] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [bookAuthor] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [bookInfo] varchar(500) COLLATE Chinese_PRC_CI_AS  NULL,
  [bookAttach] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [bookSub] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [upTime] int  NULL
)
GO

ALTER TABLE [dbo].[Book] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Book
-- ----------------------------
INSERT INTO [dbo].[Book]  VALUES (N'1', N'数据结构', N'大学', N'C语言数据结构balabalabalabala', NULL, N'C语言', N'1')
GO

INSERT INTO [dbo].[Book]  VALUES (N'2', N'java程序基础', N'java作者', N'java程序设计基础balabala', NULL, N'java', N'2')
GO

INSERT INTO [dbo].[Book]  VALUES (N'3', N'数据库', N'数据', N'数据库基础', NULL, N'数据库', N'3')
GO

INSERT INTO [dbo].[Book]  VALUES (N'4', N'java web', N'高', N'Javaweb开发与实践', NULL, N'java', N'4')
GO

INSERT INTO [dbo].[Book]  VALUES (N'5', N'大是大非', N'盛大发售', N'速度符合当时看见回复', N'新建文本文档.txt', N'中文', N'5')
GO

INSERT INTO [dbo].[Book]  VALUES (N'6', N'java1', N'jv1', N'java基础简介balabala1', N'新建文本文档.txt', N'java1', N'6')
GO

INSERT INTO [dbo].[Book]  VALUES (N'7', N'大学语文', N'大学', N'大学语文balabala', N'新建文本文档.txt', N'中文', N'7')
GO

INSERT INTO [dbo].[Book]  VALUES (N'8', N'sdfsdf', N'sdfs', N'engeng', N'新建文本文档.txt', N'英语', N'8')
GO

INSERT INTO [dbo].[Book]  VALUES (N'9', N'c++', N'计算机', N'C语言基础', N'新建文本文档.txt', N'C语言', N'9')
GO

INSERT INTO [dbo].[Book]  VALUES (N'10', N'中', N'刚刚', N'即可很快就更好规划好几个', N'中文.txt', N'中文', N'10')
GO

INSERT INTO [dbo].[Book]  VALUES (N'31', N'大学英语', N'eng', N'大学英语基础balabala', NULL, N'英语', N'11')
GO


-- ----------------------------
-- Table structure for BookMark
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[BookMark]') AND type IN ('U'))
	DROP TABLE [dbo].[BookMark]
GO

CREATE TABLE [dbo].[BookMark] (
  [bookId] int  NOT NULL,
  [userId] int  NOT NULL,
  [reading] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [rTime] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[BookMark] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Collection
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Collection]') AND type IN ('U'))
	DROP TABLE [dbo].[Collection]
GO

CREATE TABLE [dbo].[Collection] (
  [userId] int  NOT NULL,
  [bookId] int  NOT NULL,
  [ifCol] int  NOT NULL
)
GO

ALTER TABLE [dbo].[Collection] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Collection
-- ----------------------------
INSERT INTO [dbo].[Collection]  VALUES (N'162012', N'1', N'1')
GO

INSERT INTO [dbo].[Collection]  VALUES (N'162012', N'3', N'1')
GO


-- ----------------------------
-- Table structure for Comment
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Comment]') AND type IN ('U'))
	DROP TABLE [dbo].[Comment]
GO

CREATE TABLE [dbo].[Comment] (
  [cId] int  IDENTITY(1,1) NOT NULL,
  [userId] int  NOT NULL,
  [bookId] int  NOT NULL,
  [content] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[Comment] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Comment
-- ----------------------------
SET IDENTITY_INSERT [dbo].[Comment] ON
GO

INSERT INTO [dbo].[Comment] ([cId], [userId], [bookId], [content]) VALUES (N'5', N'162012', N'1', N'sdfsdfsdfsdfsd')
GO

INSERT INTO [dbo].[Comment] ([cId], [userId], [bookId], [content]) VALUES (N'6', N'162012', N'1', N'这本书值得推荐')
GO

SET IDENTITY_INSERT [dbo].[Comment] OFF
GO


-- ----------------------------
-- Table structure for CommentNext
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[CommentNext]') AND type IN ('U'))
	DROP TABLE [dbo].[CommentNext]
GO

CREATE TABLE [dbo].[CommentNext] (
  [ucId] int  IDENTITY(1,1) NOT NULL,
  [cId] int  NOT NULL,
  [userId] int  NOT NULL,
  [contentNext] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[CommentNext] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of CommentNext
-- ----------------------------
SET IDENTITY_INSERT [dbo].[CommentNext] ON
GO

INSERT INTO [dbo].[CommentNext] ([ucId], [cId], [userId], [contentNext]) VALUES (N'1', N'5', N'162012', N'撒旦飞洒地方都是')
GO

SET IDENTITY_INSERT [dbo].[CommentNext] OFF
GO


-- ----------------------------
-- Table structure for Focus
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Focus]') AND type IN ('U'))
	DROP TABLE [dbo].[Focus]
GO

CREATE TABLE [dbo].[Focus] (
  [userId] int  NOT NULL,
  [subId] int  NOT NULL,
  [ifFoc] int  NOT NULL
)
GO

ALTER TABLE [dbo].[Focus] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Focus
-- ----------------------------
INSERT INTO [dbo].[Focus]  VALUES (N'162012', N'101', N'1')
GO

INSERT INTO [dbo].[Focus]  VALUES (N'162012', N'103', N'1')
GO


-- ----------------------------
-- Table structure for Illegal
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Illegal]') AND type IN ('U'))
	DROP TABLE [dbo].[Illegal]
GO

CREATE TABLE [dbo].[Illegal] (
  [illId] int  NOT NULL,
  [illText] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[Illegal] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for Major
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Major]') AND type IN ('U'))
	DROP TABLE [dbo].[Major]
GO

CREATE TABLE [dbo].[Major] (
  [majId] int  NOT NULL,
  [majName] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[Major] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Major
-- ----------------------------
INSERT INTO [dbo].[Major]  VALUES (N'11', N'软件工程')
GO

INSERT INTO [dbo].[Major]  VALUES (N'12', N'外语')
GO

INSERT INTO [dbo].[Major]  VALUES (N'13', N'文学')
GO

INSERT INTO [dbo].[Major]  VALUES (N'14', N'经管')
GO

INSERT INTO [dbo].[Major]  VALUES (N'15', N'土建')
GO

INSERT INTO [dbo].[Major]  VALUES (N'100', N'其它')
GO


-- ----------------------------
-- Table structure for Reference
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Reference]') AND type IN ('U'))
	DROP TABLE [dbo].[Reference]
GO

CREATE TABLE [dbo].[Reference] (
  [subId] int  NOT NULL,
  [bookId] int  NOT NULL,
  [numOfCol] int  NOT NULL,
  [numOfBro] int  NOT NULL,
  [avgScore] float(53)  NOT NULL,
  [Recommend] float(53)  NULL
)
GO

ALTER TABLE [dbo].[Reference] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Reference
-- ----------------------------
INSERT INTO [dbo].[Reference]  VALUES (N'101', N'1', N'202', N'626', N'4.3', N'16660')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'102', N'2', N'308', N'996', N'4.8', N'25960')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'104', N'3', N'1', N'0', N'0', N'35')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'102', N'4', N'0', N'0', N'0', N'0')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'105', N'5', N'0', N'0', N'0', N'0')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'102', N'6', N'0', N'0', N'0', N'0')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'105', N'7', N'0', N'0', N'0', N'0')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'103', N'8', N'0', N'0', N'0', N'0')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'101', N'9', N'0', N'0', N'0', N'0')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'105', N'10', N'0', N'0', N'0', N'0')
GO

INSERT INTO [dbo].[Reference]  VALUES (N'103', N'31', N'205', N'568', N'4.5', N'15920')
GO


-- ----------------------------
-- Table structure for School
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[School]') AND type IN ('U'))
	DROP TABLE [dbo].[School]
GO

CREATE TABLE [dbo].[School] (
  [schId] int  NOT NULL,
  [schName] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[School] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of School
-- ----------------------------
INSERT INTO [dbo].[School]  VALUES (N'1', N'南昌航空大学')
GO

INSERT INTO [dbo].[School]  VALUES (N'2', N'南昌大学')
GO

INSERT INTO [dbo].[School]  VALUES (N'3', N'江西师范大学')
GO

INSERT INTO [dbo].[School]  VALUES (N'4', N'江西财经大学')
GO

INSERT INTO [dbo].[School]  VALUES (N'5', N'华东交通大学')
GO

INSERT INTO [dbo].[School]  VALUES (N'100', N'其它')
GO


-- ----------------------------
-- Table structure for Score
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Score]') AND type IN ('U'))
	DROP TABLE [dbo].[Score]
GO

CREATE TABLE [dbo].[Score] (
  [bookId] int  NOT NULL,
  [userId] int  NOT NULL,
  [ifScore] int  NULL,
  [score] float(53)  NULL
)
GO

ALTER TABLE [dbo].[Score] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Score
-- ----------------------------
INSERT INTO [dbo].[Score]  VALUES (N'1', N'110', N'1', N'4.9')
GO

INSERT INTO [dbo].[Score]  VALUES (N'1', N'162012', N'1', N'4')
GO

INSERT INTO [dbo].[Score]  VALUES (N'2', N'110', N'1', N'4.8')
GO

INSERT INTO [dbo].[Score]  VALUES (N'3', N'110', N'1', N'4.9')
GO


-- ----------------------------
-- Table structure for Subject
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[Subject]') AND type IN ('U'))
	DROP TABLE [dbo].[Subject]
GO

CREATE TABLE [dbo].[Subject] (
  [subId] int  NOT NULL,
  [schId] int  NOT NULL,
  [majId] int  NOT NULL,
  [subName] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[Subject] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Subject
-- ----------------------------
INSERT INTO [dbo].[Subject]  VALUES (N'101', N'1', N'11', N'C语言')
GO

INSERT INTO [dbo].[Subject]  VALUES (N'102', N'1', N'11', N'java')
GO

INSERT INTO [dbo].[Subject]  VALUES (N'103', N'2', N'12', N'英语')
GO

INSERT INTO [dbo].[Subject]  VALUES (N'104', N'1', N'11', N'数据库')
GO

INSERT INTO [dbo].[Subject]  VALUES (N'105', N'2', N'13', N'中文')
GO

INSERT INTO [dbo].[Subject]  VALUES (N'106', N'100', N'100', N'园林')
GO

INSERT INTO [dbo].[Subject]  VALUES (N'107', N'1', N'14', N'经济')
GO

INSERT INTO [dbo].[Subject]  VALUES (N'108', N'1', N'15', N'土木')
GO


-- ----------------------------
-- Table structure for sysdiagrams
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sysdiagrams]') AND type IN ('U'))
	DROP TABLE [dbo].[sysdiagrams]
GO

CREATE TABLE [dbo].[sysdiagrams] (
  [name] sysname  NOT NULL,
  [principal_id] int  NOT NULL,
  [diagram_id] int  IDENTITY(1,1) NOT NULL,
  [version] int  NULL,
  [definition] varbinary(max)  NULL
)
GO

ALTER TABLE [dbo].[sysdiagrams] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for TempBook
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[TempBook]') AND type IN ('U'))
	DROP TABLE [dbo].[TempBook]
GO

CREATE TABLE [dbo].[TempBook] (
  [tempId] int  IDENTITY(1,1) NOT NULL,
  [userId] int  NOT NULL,
  [bName] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [bAuthor] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [bInfo] varchar(500) COLLATE Chinese_PRC_CI_AS  NULL,
  [ifCheck] varchar(5) COLLATE Chinese_PRC_CI_AS DEFAULT NULL NULL,
  [bSub] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [bAttach] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[TempBook] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of TempBook
-- ----------------------------
SET IDENTITY_INSERT [dbo].[TempBook] ON
GO

INSERT INTO [dbo].[TempBook] ([tempId], [userId], [bName], [bAuthor], [bInfo], [ifCheck], [bSub], [bAttach]) VALUES (N'1', N'162012', N'大学语文', N'大学', N'大学语文balabala', N'是', N'中文', N'新建文本文档.txt')
GO

INSERT INTO [dbo].[TempBook] ([tempId], [userId], [bName], [bAuthor], [bInfo], [ifCheck], [bSub], [bAttach]) VALUES (N'2', N'162012', N'高等数学', N'高等', N'高等数学基础教程', N'否', N'数学', N'新建文本文档.txt')
GO

INSERT INTO [dbo].[TempBook] ([tempId], [userId], [bName], [bAuthor], [bInfo], [ifCheck], [bSub], [bAttach]) VALUES (N'4', N'162012', N'sdfsdf', N'sdfs', N'engeng', N'是', N'英语', N'新建文本文档.txt')
GO

INSERT INTO [dbo].[TempBook] ([tempId], [userId], [bName], [bAuthor], [bInfo], [ifCheck], [bSub], [bAttach]) VALUES (N'5', N'162012', N'dsfs', N'sdfsad', N'', N'否', N'sdfsf', N'新建文本文档.txt')
GO

INSERT INTO [dbo].[TempBook] ([tempId], [userId], [bName], [bAuthor], [bInfo], [ifCheck], [bSub], [bAttach]) VALUES (N'6', N'162012', N'c++', N'计算机', N'C语言基础', N'是', N'C语言', N'新建文本文档.txt')
GO

INSERT INTO [dbo].[TempBook] ([tempId], [userId], [bName], [bAuthor], [bInfo], [ifCheck], [bSub], [bAttach]) VALUES (N'1006', N'162012', N'中', N'刚刚', N'即可很快就更好规划好几个', N'是', N'中文', N'中文.txt')
GO

INSERT INTO [dbo].[TempBook] ([tempId], [userId], [bName], [bAuthor], [bInfo], [ifCheck], [bSub], [bAttach]) VALUES (N'1007', N'162012', N'一念花开', N'一', N'一念花开', N'是', N'中文', N'新建文本文档.txt')
GO

SET IDENTITY_INSERT [dbo].[TempBook] OFF
GO


-- ----------------------------
-- Table structure for test
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[test]') AND type IN ('U'))
	DROP TABLE [dbo].[test]
GO

CREATE TABLE [dbo].[test] (
  [id] int  NOT NULL,
  [num] int  NULL
)
GO

ALTER TABLE [dbo].[test] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO [dbo].[test]  VALUES (N'1', N'18')
GO

INSERT INTO [dbo].[test]  VALUES (N'2', N'20')
GO

INSERT INTO [dbo].[test]  VALUES (N'3', N'22')
GO

INSERT INTO [dbo].[test]  VALUES (N'4', N'24')
GO

INSERT INTO [dbo].[test]  VALUES (N'5', N'26')
GO


-- ----------------------------
-- Procedure structure for sp_upgraddiagrams
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_upgraddiagrams]') AND type IN ('P', 'PC', 'RF', 'X'))
	DROP PROCEDURE[dbo].[sp_upgraddiagrams]
GO

CREATE PROCEDURE [dbo].[sp_upgraddiagrams]
	AS
	BEGIN
		IF OBJECT_ID(N'dbo.sysdiagrams') IS NOT NULL
			return 0;
	
		CREATE TABLE dbo.sysdiagrams
		(
			name sysname NOT NULL,
			principal_id int NOT NULL,	-- we may change it to varbinary(85)
			diagram_id int PRIMARY KEY IDENTITY,
			version int,
	
			definition varbinary(max)
			CONSTRAINT UK_principal_name UNIQUE
			(
				principal_id,
				name
			)
		);


		/* Add this if we need to have some form of extended properties for diagrams */
		/*
		IF OBJECT_ID(N'dbo.sysdiagram_properties') IS NULL
		BEGIN
			CREATE TABLE dbo.sysdiagram_properties
			(
				diagram_id int,
				name sysname,
				value varbinary(max) NOT NULL
			)
		END
		*/

		IF OBJECT_ID(N'dbo.dtproperties') IS NOT NULL
		begin
			insert into dbo.sysdiagrams
			(
				[name],
				[principal_id],
				[version],
				[definition]
			)
			select	 
				convert(sysname, dgnm.[uvalue]),
				DATABASE_PRINCIPAL_ID(N'dbo'),			-- will change to the sid of sa
				0,							-- zero for old format, dgdef.[version],
				dgdef.[lvalue]
			from dbo.[dtproperties] dgnm
				inner join dbo.[dtproperties] dggd on dggd.[property] = 'DtgSchemaGUID' and dggd.[objectid] = dgnm.[objectid]	
				inner join dbo.[dtproperties] dgdef on dgdef.[property] = 'DtgSchemaDATA' and dgdef.[objectid] = dgnm.[objectid]
				
			where dgnm.[property] = 'DtgSchemaNAME' and dggd.[uvalue] like N'_EA3E6268-D998-11CE-9454-00AA00A3F36E_' 
			return 2;
		end
		return 1;
	END
GO


-- ----------------------------
-- Procedure structure for sp_helpdiagrams
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_helpdiagrams]') AND type IN ('P', 'PC', 'RF', 'X'))
	DROP PROCEDURE[dbo].[sp_helpdiagrams]
GO

CREATE PROCEDURE [dbo].[sp_helpdiagrams]
	(
		@diagramname sysname = NULL,
		@owner_id int = NULL
	)
	WITH EXECUTE AS N'dbo'
	AS
	BEGIN
		DECLARE @user sysname
		DECLARE @dboLogin bit
		EXECUTE AS CALLER;
			SET @user = USER_NAME();
			SET @dboLogin = CONVERT(bit,IS_MEMBER('db_owner'));
		REVERT;
		SELECT
			[Database] = DB_NAME(),
			[Name] = name,
			[ID] = diagram_id,
			[Owner] = USER_NAME(principal_id),
			[OwnerID] = principal_id
		FROM
			sysdiagrams
		WHERE
			(@dboLogin = 1 OR USER_NAME(principal_id) = @user) AND
			(@diagramname IS NULL OR name = @diagramname) AND
			(@owner_id IS NULL OR principal_id = @owner_id)
		ORDER BY
			4, 5, 1
	END
GO


-- ----------------------------
-- Procedure structure for sp_helpdiagramdefinition
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_helpdiagramdefinition]') AND type IN ('P', 'PC', 'RF', 'X'))
	DROP PROCEDURE[dbo].[sp_helpdiagramdefinition]
GO

CREATE PROCEDURE [dbo].[sp_helpdiagramdefinition]
	(
		@diagramname 	sysname,
		@owner_id	int	= null 		
	)
	WITH EXECUTE AS N'dbo'
	AS
	BEGIN
		set nocount on

		declare @theId 		int
		declare @IsDbo 		int
		declare @DiagId		int
		declare @UIDFound	int
	
		if(@diagramname is null)
		begin
			RAISERROR (N'E_INVALIDARG', 16, 1);
			return -1
		end
	
		execute as caller;
		select @theId = DATABASE_PRINCIPAL_ID();
		select @IsDbo = IS_MEMBER(N'db_owner');
		if(@owner_id is null)
			select @owner_id = @theId;
		revert; 
	
		select @DiagId = diagram_id, @UIDFound = principal_id from dbo.sysdiagrams where principal_id = @owner_id and name = @diagramname;
		if(@DiagId IS NULL or (@IsDbo = 0 and @UIDFound <> @theId ))
		begin
			RAISERROR ('Diagram does not exist or you do not have permission.', 16, 1);
			return -3
		end

		select version, definition FROM dbo.sysdiagrams where diagram_id = @DiagId ; 
		return 0
	END
GO


-- ----------------------------
-- Procedure structure for sp_creatediagram
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_creatediagram]') AND type IN ('P', 'PC', 'RF', 'X'))
	DROP PROCEDURE[dbo].[sp_creatediagram]
GO

CREATE PROCEDURE [dbo].[sp_creatediagram]
	(
		@diagramname 	sysname,
		@owner_id		int	= null, 	
		@version 		int,
		@definition 	varbinary(max)
	)
	WITH EXECUTE AS 'dbo'
	AS
	BEGIN
		set nocount on
	
		declare @theId int
		declare @retval int
		declare @IsDbo	int
		declare @userName sysname
		if(@version is null or @diagramname is null)
		begin
			RAISERROR (N'E_INVALIDARG', 16, 1);
			return -1
		end
	
		execute as caller;
		select @theId = DATABASE_PRINCIPAL_ID(); 
		select @IsDbo = IS_MEMBER(N'db_owner');
		revert; 
		
		if @owner_id is null
		begin
			select @owner_id = @theId;
		end
		else
		begin
			if @theId <> @owner_id
			begin
				if @IsDbo = 0
				begin
					RAISERROR (N'E_INVALIDARG', 16, 1);
					return -1
				end
				select @theId = @owner_id
			end
		end
		-- next 2 line only for test, will be removed after define name unique
		if EXISTS(select diagram_id from dbo.sysdiagrams where principal_id = @theId and name = @diagramname)
		begin
			RAISERROR ('The name is already used.', 16, 1);
			return -2
		end
	
		insert into dbo.sysdiagrams(name, principal_id , version, definition)
				VALUES(@diagramname, @theId, @version, @definition) ;
		
		select @retval = @@IDENTITY 
		return @retval
	END
GO


-- ----------------------------
-- Procedure structure for sp_renamediagram
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_renamediagram]') AND type IN ('P', 'PC', 'RF', 'X'))
	DROP PROCEDURE[dbo].[sp_renamediagram]
GO

CREATE PROCEDURE [dbo].[sp_renamediagram]
	(
		@diagramname 		sysname,
		@owner_id		int	= null,
		@new_diagramname	sysname
	
	)
	WITH EXECUTE AS 'dbo'
	AS
	BEGIN
		set nocount on
		declare @theId 			int
		declare @IsDbo 			int
		
		declare @UIDFound 		int
		declare @DiagId			int
		declare @DiagIdTarg		int
		declare @u_name			sysname
		if((@diagramname is null) or (@new_diagramname is null))
		begin
			RAISERROR ('Invalid value', 16, 1);
			return -1
		end
	
		EXECUTE AS CALLER;
		select @theId = DATABASE_PRINCIPAL_ID();
		select @IsDbo = IS_MEMBER(N'db_owner'); 
		if(@owner_id is null)
			select @owner_id = @theId;
		REVERT;
	
		select @u_name = USER_NAME(@owner_id)
	
		select @DiagId = diagram_id, @UIDFound = principal_id from dbo.sysdiagrams where principal_id = @owner_id and name = @diagramname 
		if(@DiagId IS NULL or (@IsDbo = 0 and @UIDFound <> @theId))
		begin
			RAISERROR ('Diagram does not exist or you do not have permission.', 16, 1)
			return -3
		end
	
		-- if((@u_name is not null) and (@new_diagramname = @diagramname))	-- nothing will change
		--	return 0;
	
		if(@u_name is null)
			select @DiagIdTarg = diagram_id from dbo.sysdiagrams where principal_id = @theId and name = @new_diagramname
		else
			select @DiagIdTarg = diagram_id from dbo.sysdiagrams where principal_id = @owner_id and name = @new_diagramname
	
		if((@DiagIdTarg is not null) and  @DiagId <> @DiagIdTarg)
		begin
			RAISERROR ('The name is already used.', 16, 1);
			return -2
		end		
	
		if(@u_name is null)
			update dbo.sysdiagrams set [name] = @new_diagramname, principal_id = @theId where diagram_id = @DiagId
		else
			update dbo.sysdiagrams set [name] = @new_diagramname where diagram_id = @DiagId
		return 0
	END
GO


-- ----------------------------
-- Procedure structure for sp_alterdiagram
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_alterdiagram]') AND type IN ('P', 'PC', 'RF', 'X'))
	DROP PROCEDURE[dbo].[sp_alterdiagram]
GO

CREATE PROCEDURE [dbo].[sp_alterdiagram]
	(
		@diagramname 	sysname,
		@owner_id	int	= null,
		@version 	int,
		@definition 	varbinary(max)
	)
	WITH EXECUTE AS 'dbo'
	AS
	BEGIN
		set nocount on
	
		declare @theId 			int
		declare @retval 		int
		declare @IsDbo 			int
		
		declare @UIDFound 		int
		declare @DiagId			int
		declare @ShouldChangeUID	int
	
		if(@diagramname is null)
		begin
			RAISERROR ('Invalid ARG', 16, 1)
			return -1
		end
	
		execute as caller;
		select @theId = DATABASE_PRINCIPAL_ID();	 
		select @IsDbo = IS_MEMBER(N'db_owner'); 
		if(@owner_id is null)
			select @owner_id = @theId;
		revert;
	
		select @ShouldChangeUID = 0
		select @DiagId = diagram_id, @UIDFound = principal_id from dbo.sysdiagrams where principal_id = @owner_id and name = @diagramname 
		
		if(@DiagId IS NULL or (@IsDbo = 0 and @theId <> @UIDFound))
		begin
			RAISERROR ('Diagram does not exist or you do not have permission.', 16, 1);
			return -3
		end
	
		if(@IsDbo <> 0)
		begin
			if(@UIDFound is null or USER_NAME(@UIDFound) is null) -- invalid principal_id
			begin
				select @ShouldChangeUID = 1 ;
			end
		end

		-- update dds data			
		update dbo.sysdiagrams set definition = @definition where diagram_id = @DiagId ;

		-- change owner
		if(@ShouldChangeUID = 1)
			update dbo.sysdiagrams set principal_id = @theId where diagram_id = @DiagId ;

		-- update dds version
		if(@version is not null)
			update dbo.sysdiagrams set version = @version where diagram_id = @DiagId ;

		return 0
	END
GO


-- ----------------------------
-- Procedure structure for sp_dropdiagram
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_dropdiagram]') AND type IN ('P', 'PC', 'RF', 'X'))
	DROP PROCEDURE[dbo].[sp_dropdiagram]
GO

CREATE PROCEDURE [dbo].[sp_dropdiagram]
	(
		@diagramname 	sysname,
		@owner_id	int	= null
	)
	WITH EXECUTE AS 'dbo'
	AS
	BEGIN
		set nocount on
		declare @theId 			int
		declare @IsDbo 			int
		
		declare @UIDFound 		int
		declare @DiagId			int
	
		if(@diagramname is null)
		begin
			RAISERROR ('Invalid value', 16, 1);
			return -1
		end
	
		EXECUTE AS CALLER;
		select @theId = DATABASE_PRINCIPAL_ID();
		select @IsDbo = IS_MEMBER(N'db_owner'); 
		if(@owner_id is null)
			select @owner_id = @theId;
		REVERT; 
		
		select @DiagId = diagram_id, @UIDFound = principal_id from dbo.sysdiagrams where principal_id = @owner_id and name = @diagramname 
		if(@DiagId IS NULL or (@IsDbo = 0 and @UIDFound <> @theId))
		begin
			RAISERROR ('Diagram does not exist or you do not have permission.', 16, 1)
			return -3
		end
	
		delete from dbo.sysdiagrams where diagram_id = @DiagId;
	
		return 0;
	END
GO


-- ----------------------------
-- Function structure for fn_diagramobjects
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[fn_diagramobjects]') AND type IN ('FN', 'FS', 'FT', 'IF', 'TF'))
	DROP FUNCTION[dbo].[fn_diagramobjects]
GO

CREATE FUNCTION [dbo].[fn_diagramobjects]() 
	RETURNS int
	WITH EXECUTE AS N'dbo'
	AS
	BEGIN
		declare @id_upgraddiagrams		int
		declare @id_sysdiagrams			int
		declare @id_helpdiagrams		int
		declare @id_helpdiagramdefinition	int
		declare @id_creatediagram	int
		declare @id_renamediagram	int
		declare @id_alterdiagram 	int 
		declare @id_dropdiagram		int
		declare @InstalledObjects	int

		select @InstalledObjects = 0

		select 	@id_upgraddiagrams = object_id(N'dbo.sp_upgraddiagrams'),
			@id_sysdiagrams = object_id(N'dbo.sysdiagrams'),
			@id_helpdiagrams = object_id(N'dbo.sp_helpdiagrams'),
			@id_helpdiagramdefinition = object_id(N'dbo.sp_helpdiagramdefinition'),
			@id_creatediagram = object_id(N'dbo.sp_creatediagram'),
			@id_renamediagram = object_id(N'dbo.sp_renamediagram'),
			@id_alterdiagram = object_id(N'dbo.sp_alterdiagram'), 
			@id_dropdiagram = object_id(N'dbo.sp_dropdiagram')

		if @id_upgraddiagrams is not null
			select @InstalledObjects = @InstalledObjects + 1
		if @id_sysdiagrams is not null
			select @InstalledObjects = @InstalledObjects + 2
		if @id_helpdiagrams is not null
			select @InstalledObjects = @InstalledObjects + 4
		if @id_helpdiagramdefinition is not null
			select @InstalledObjects = @InstalledObjects + 8
		if @id_creatediagram is not null
			select @InstalledObjects = @InstalledObjects + 16
		if @id_renamediagram is not null
			select @InstalledObjects = @InstalledObjects + 32
		if @id_alterdiagram  is not null
			select @InstalledObjects = @InstalledObjects + 64
		if @id_dropdiagram is not null
			select @InstalledObjects = @InstalledObjects + 128
		
		return @InstalledObjects 
	END
GO


-- ----------------------------
-- Primary Key structure for table allUser
-- ----------------------------
ALTER TABLE [dbo].[allUser] ADD CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED ([userId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Triggers structure for table Book
-- ----------------------------
CREATE TRIGGER [dbo].[tri_book]
ON [dbo].[Book]
WITH EXECUTE AS CALLER
FOR INSERT
AS
begin
	declare @subId int;
	declare @bookId int;
	declare @bookSub varchar(50);
	
	select @bookSub = bookSub from inserted;
	select @bookId = bookId from inserted;
	select @subId = subId from Subject where subName=@bookSub;
	insert into Reference values(@subId,@bookId,0,0,0.0,0);
end
GO


-- ----------------------------
-- Primary Key structure for table Book
-- ----------------------------
ALTER TABLE [dbo].[Book] ADD CONSTRAINT [PK_Book] PRIMARY KEY CLUSTERED ([bookId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table BookMark
-- ----------------------------
ALTER TABLE [dbo].[BookMark] ADD CONSTRAINT [PK_BookMark] PRIMARY KEY CLUSTERED ([bookId], [userId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Triggers structure for table Collection
-- ----------------------------
CREATE TRIGGER [dbo].[tri_col]
ON [dbo].[Collection]
WITH EXECUTE AS CALLER
FOR INSERT
AS
begin
declare @bookId int;
select @bookId = bookId from inserted;

update Reference set numOfCol = numOfCol + 1 where bookId = @bookId;
end
GO


-- ----------------------------
-- Primary Key structure for table Collection
-- ----------------------------
ALTER TABLE [dbo].[Collection] ADD CONSTRAINT [PK_Collection] PRIMARY KEY CLUSTERED ([bookId], [userId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Comment
-- ----------------------------
ALTER TABLE [dbo].[Comment] ADD CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED ([cId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table CommentNext
-- ----------------------------
ALTER TABLE [dbo].[CommentNext] ADD CONSTRAINT [PK__CommentN__B80293332BB4046E] PRIMARY KEY CLUSTERED ([ucId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Focus
-- ----------------------------
ALTER TABLE [dbo].[Focus] ADD CONSTRAINT [PK_Focus] PRIMARY KEY CLUSTERED ([subId], [userId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Illegal
-- ----------------------------
ALTER TABLE [dbo].[Illegal] ADD CONSTRAINT [PK__Illegal__A3E3D07CE9AA9060] PRIMARY KEY CLUSTERED ([illId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Major
-- ----------------------------
ALTER TABLE [dbo].[Major] ADD CONSTRAINT [PK_Major] PRIMARY KEY CLUSTERED ([majId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Reference
-- ----------------------------
ALTER TABLE [dbo].[Reference] ADD CONSTRAINT [PK_Reference] PRIMARY KEY CLUSTERED ([bookId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table School
-- ----------------------------
ALTER TABLE [dbo].[School] ADD CONSTRAINT [PK_School] PRIMARY KEY CLUSTERED ([schId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Triggers structure for table Score
-- ----------------------------
CREATE TRIGGER [dbo].[tri_score]
ON [dbo].[Score]
WITH EXECUTE AS CALLER
INSTEAD OF INSERT
AS
declare @bookId int
declare @userId int
declare @ifScore int
select @bookId = bookId from inserted
select @userId = userId from inserted
select @ifScore = ifScore from Score where userId = @userId and bookId = @bookId
if @ifScore = 1
	begin
		print('您已经为这本书打过分了')
		rollback transaction
	end
else
	begin
		insert into Score select * from inserted
	end
GO


-- ----------------------------
-- Primary Key structure for table Score
-- ----------------------------
ALTER TABLE [dbo].[Score] ADD CONSTRAINT [PK_Score] PRIMARY KEY CLUSTERED ([bookId], [userId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Subject
-- ----------------------------
ALTER TABLE [dbo].[Subject] ADD CONSTRAINT [PK_Subject] PRIMARY KEY CLUSTERED ([subId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Uniques structure for table sysdiagrams
-- ----------------------------
ALTER TABLE [dbo].[sysdiagrams] ADD CONSTRAINT [UK_principal_name] UNIQUE NONCLUSTERED ([principal_id] ASC, [name] ASC)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sysdiagrams
-- ----------------------------
ALTER TABLE [dbo].[sysdiagrams] ADD CONSTRAINT [PK__sysdiagr__C2B05B61348DA846] PRIMARY KEY CLUSTERED ([diagram_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table TempBook
-- ----------------------------
ALTER TABLE [dbo].[TempBook] ADD CONSTRAINT [PK_TempBook] PRIMARY KEY CLUSTERED ([tempId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table test
-- ----------------------------
ALTER TABLE [dbo].[test] ADD CONSTRAINT [PK__test__3213E83F88B7C1C4] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table BookMark
-- ----------------------------
ALTER TABLE [dbo].[BookMark] ADD CONSTRAINT [FK_BookMark_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[allUser] ([userId]) ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE [dbo].[BookMark] ADD CONSTRAINT [FK_BookMark_Book] FOREIGN KEY ([bookId]) REFERENCES [dbo].[Book] ([bookId]) ON DELETE CASCADE ON UPDATE CASCADE
GO


-- ----------------------------
-- Foreign Keys structure for table Collection
-- ----------------------------
ALTER TABLE [dbo].[Collection] ADD CONSTRAINT [FK_Collection_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[allUser] ([userId]) ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE [dbo].[Collection] ADD CONSTRAINT [FK_Collection_Book] FOREIGN KEY ([bookId]) REFERENCES [dbo].[Book] ([bookId]) ON DELETE CASCADE ON UPDATE CASCADE
GO


-- ----------------------------
-- Foreign Keys structure for table Comment
-- ----------------------------
ALTER TABLE [dbo].[Comment] ADD CONSTRAINT [FK_Comment_Comment] FOREIGN KEY ([userId]) REFERENCES [dbo].[allUser] ([userId]) ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE [dbo].[Comment] ADD CONSTRAINT [FK_Comment_Book] FOREIGN KEY ([bookId]) REFERENCES [dbo].[Book] ([bookId]) ON DELETE CASCADE ON UPDATE CASCADE
GO


-- ----------------------------
-- Foreign Keys structure for table Focus
-- ----------------------------
ALTER TABLE [dbo].[Focus] ADD CONSTRAINT [FK_Focus_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[allUser] ([userId]) ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE [dbo].[Focus] ADD CONSTRAINT [FK_Focus_Subject] FOREIGN KEY ([subId]) REFERENCES [dbo].[Subject] ([subId]) ON DELETE CASCADE ON UPDATE CASCADE
GO


-- ----------------------------
-- Foreign Keys structure for table Reference
-- ----------------------------
ALTER TABLE [dbo].[Reference] ADD CONSTRAINT [FK_Reference_Book] FOREIGN KEY ([bookId]) REFERENCES [dbo].[Book] ([bookId]) ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE [dbo].[Reference] ADD CONSTRAINT [FK_Reference_Subject] FOREIGN KEY ([subId]) REFERENCES [dbo].[Subject] ([subId]) ON DELETE CASCADE ON UPDATE CASCADE
GO


-- ----------------------------
-- Foreign Keys structure for table Score
-- ----------------------------
ALTER TABLE [dbo].[Score] ADD CONSTRAINT [FK_Score_Book] FOREIGN KEY ([bookId]) REFERENCES [dbo].[Book] ([bookId]) ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE [dbo].[Score] ADD CONSTRAINT [FK_Score_User] FOREIGN KEY ([userId]) REFERENCES [dbo].[allUser] ([userId]) ON DELETE CASCADE ON UPDATE CASCADE
GO


-- ----------------------------
-- Foreign Keys structure for table Subject
-- ----------------------------
ALTER TABLE [dbo].[Subject] ADD CONSTRAINT [FK_Subject_Major1] FOREIGN KEY ([majId]) REFERENCES [dbo].[Major] ([majId]) ON DELETE CASCADE ON UPDATE CASCADE
GO

ALTER TABLE [dbo].[Subject] ADD CONSTRAINT [FK_Subject_School] FOREIGN KEY ([schId]) REFERENCES [dbo].[School] ([schId]) ON DELETE CASCADE ON UPDATE CASCADE
GO


-- ----------------------------
-- Foreign Keys structure for table TempBook
-- ----------------------------
ALTER TABLE [dbo].[TempBook] ADD CONSTRAINT [FK_TempBook_TempBook] FOREIGN KEY ([userId]) REFERENCES [dbo].[allUser] ([userId]) ON DELETE CASCADE ON UPDATE CASCADE
GO


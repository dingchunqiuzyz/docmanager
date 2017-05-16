#mysql user表
create table users(
	 user_id int  primary key auto_increment comment '用户表主键自增',
	 username varchar(40) not null unique comment '唯一账号，不可重复，不能为空' default '',
	 password varchar(40) not null comment '密码 不能为空' default '',
	 real_name varchar(40) not null comment '真实姓名' default '',
	 user_type varchar (2) not null default '2' comment '用户类型：1：代表管理员 2:代表文件录入员',
	 key index_username (username)
);


#教师表

create table teachers(
	teacher_id int  primary key auto_increment comment '教师主键自增',
	teacher_name varchar(30) not null default '' comment '教师姓名',
	teacher_code bigint not null unique comment '教师编号，唯一',
	college varchar(40) not null default '' comment '教师所在学院',
	major varchar(40) not null default '' comment '教师所在专业'
);

#论文表---学术论文
create table magazine(
	mag_uuid varchar(40)  primary key  comment '期刊表主键 uuid',
	mag_name varchar(100) not null default '' comment '题目',
	mag_level varchar(20) not null default '' comment '成果类别：国家级 省级 市级 学校级别',
	mag_pub_date date not null comment '发表时间',
	mag_teacher_order int  not null default '1' comment '本人排名',
	mag_school_order int  not null default '1' comment '本校排名',
	mag_deac varchar(255) not null default '' comment '检索情况',
	fk_teacher_code bigint comment '教师外键',
	FOREIGN KEY (fk_teacher_code ) REFERENCES teachers(teacher_code)
);



######################著作-书籍类
create table works(
	work_uuid char(36)  primary key  comment '著作表主键 uuid',
	work_name varchar(100) not null default '' comment '著作名称',
	work_publish varchar(50) not null default '' comment '出版社',
	work_isbn varchar(50) not null default '' comment '著作编号',
	work_date date not null comment '出版时间',
	work_char_number FLOAT NOT NULL   DEFAULT '0' COMMENT '字数',
	work_teacher_order int  not null default '1' comment '排名',
	work_type VARCHAR(50)   DEFAULT '' COMMENT '书籍类型',
	work_product_type VARCHAR(100)   DEFAULT '' COMMENT '成果类型',
	fk_teacher_code BIGINT  comment '教师外键',
	FOREIGN KEY (fk_teacher_code) REFERENCES teachers(teacher_code)
);


######################科研项目项目类---完成
create table projects(
	pro_uuid char(36)  primary key  comment '项目表主键 uuid',
	pro_name varchar(150) not null default '' comment '项目名称',
	pro_level varchar(50) not null default '' comment '成果类别:国家级 省市级 学校级',
	pro_start_date date not null comment '项目开始时间',
	pro_end_date date not null comment '项目结束时间',
	pro_source VARCHAR(50) NOT NULL COMMENT '项目来源',
	pro_funds FLOAT NOT NULL  DEFAULT '0' COMMENT '项目经费',
	pro_teacher_order int  not null default '1' comment '排名',
	fk_teacher_code bigint  comment '教师外键',
	FOREIGN KEY (fk_teacher_code) REFERENCES teachers(teacher_code)
);

######################专利类
create table patents(
	pat_uuid CHAR(36)  primary key  comment '专利表主键 uuid',
	pat_name varchar(150) not null default '' comment '专利名称',
	pat_type varchar(50) not null default '' comment '成果类别:科研类、工程类、管理类',
	pat_code varchar(100) not null comment '专利代码',
	pat_teacher_name VARCHAR(50) NOT NULL DEFAULT '' COMMENT '专利权人',
	pat_date date not null comment '申请专利时间',
	pat_teacher_order int  not null default '1' comment '排名',
	fk_teacher_code bigint  comment '教师外键',
	FOREIGN KEY (fk_teacher_code) REFERENCES teachers(teacher_code)
);


######################奖品类----获奖
create table prizes(
	pri_uuid char(36)  primary key  comment '奖品表主键 uuid',
	pri_name varchar(150) not null default '' comment '获奖名称',
	pri_org VARCHAR(50) NOT NULL DEFAULT '' COMMENT '颁奖单位',
	pri_rank varchar(40) not null default '' comment '奖品级别:国家级、省级、院校级',
	pri_date date not null comment '获奖时间',
	pri_teacher_order int  not null default '1' comment '排名',
	pri_school_order int NOT NULL  DEFAULT  '1' COMMENT '本校排名',
	pri_type varchar(40) not null default '' comment '成果类别',
	fk_teacher_code bigint  comment '教师外键',
	FOREIGN KEY (fk_teacher_code) REFERENCES teachers(teacher_code)
);




#########################查询缓存表:为了性能，做了一些冗余

create table query_cache(
	cache_id int  primary key auto_increment comment '缓存表主键自增',
	file_type varchar(40) not null default '' comment '文件类型:如：期刊 、专利、著作等',
	fk_teacher_code BIGINT not null comment '外键：教工编号，方便检索',
	file_name varchar(100) not null default '' comment '文件名',
	file_path varchar(200) not null default '' comment '保存路径',
	teacher_name varchar(20) not null default '' comment '作者姓名',
	project_name  varchar(100) not null default '' comment '项目名称',
	file_date date not null comment '文件发布日期等',
	orders int not null default '1' comment '该教师所在本项目中的排名',
	fk_file_uuid char(36) not null COMMENT '文件uuid',
	FOREIGN KEY (fk_teacher_code) REFERENCES teachers(teacher_code)
);


######################成果转化
create table honours(
	ho_uuid char(36)  primary key  comment '成果转化 uuid',
	ho_name varchar(50) not null default '' comment '名称',
	ho_rank varchar(40) not null default '' comment '成果类别:国家级、省级、院校级',
	ho_start_date date not null comment '起始时间',
	ho_end_date date not null comment '结束时间',
	ho_teacher_order int  not null default '1' comment '排名',
	ho_org varchar(255) comment '项目来源' DEFAULT '',
	ho_money FLOAT comment '学校获得转化金额' DEFAULT 0,
	fk_teacher_code bigint  comment '教师外键',
	FOREIGN KEY (fk_teacher_code) REFERENCES teachers(teacher_code)
);



#############论证报告

create table report(
	rep_uuid char(36)  primary key  comment '主键 uuid',
	rep_name varchar(50) not null default '' comment '名称',
	rep_rank varchar(40) not null default '' comment '成果类别:国家级、省级、院校级',
	rep_date date not null comment '采用世界',
	rep_teacher_order int  not null default '1' comment '排名',
	rep_org varchar(50) not null default '' comment '采用单位',
	fk_teacher_code bigint  comment '教师外键',
	FOREIGN KEY (fk_teacher_code) REFERENCES teachers(teacher_code)
);


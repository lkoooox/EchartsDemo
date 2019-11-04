package com.yiwu.main;

public class EntranceMain {
    //我先把hive建表,导数据,求top10先写在注释里了
    //user表没有分区  没有时间维度啊
    //set hive.exec.dynamic.partition = true;
    //set hive.exec.dynamic.partition.mode = nostrict;
    //create database if not exists EntertainmentDB
    //创建用户表
//    create external table user_data_table(
//     uid bigint,
//     screenname string,
//     province int,
//     remark string)
//    row format delimited
//    fields terminated by '\t'
    //
    //load data inpath '/hive/user_data.txt' into table user_data_table;
    //
    //创建评论原始文件临时表
//    create external table comment_data_temp_table(
//     uid bigint,
//     comment string,
//     dt string,
//     time string,
//     repostscount string,
//     commentscount string)
//    row format delimited
//    fields terminated by '\t';
    //
    //load data inpath '/hive/comment_data.txt' into table comment_data_temp_table;
    //创建评论表
//    create external table comment_data_table(
//     uid bigint,
//     time string,
//     comment string,
//     repostscount string,
//     commentscount string)
//     partitioned by (dt string)
//     row format delimited
//     fields terminated by '\t';
    //
    //将评论文件临时表导入评论表以time字段动态分区
//
//    insert into table comment_data_table partition (dt)
//    select uid,time,comment,repostscount,commentscount,dt from comment_data_temp_table ;
    //
    //SQL语句
    //1.求top10
//    create table result_comment_top10_table as
//    select temp_rc_a.remark as remark ,temp_rc_a.uid as uid ,temp_rc_a.commentscount as commentsCount from
//    (select a.uid as uid,b.commentscount as commentscount,a.remark as remark
//     from user_data_table a left join comment_data_temp_table b on a.uid=b.uid) temp_rc_a
//    left join
//     (select a.uid as uid,b.commentscount as commentscount1,a.remark as remark
//     from user_data_table a left join comment_data_temp_table b on a.uid=b.uid) temp_rc_b
//     on temp_rc_a.remark = temp_rc_b.remark where temp_rc_a.commentscount<temp_rc_b.commentscount1
//    group by temp_rc_a.remark,temp_rc_a.commentscount，temp_rc_a.uid having count(temp_rc_b.uid)<10
//    order by remark,commentscount desc;
    //
    //2.各类型评论回复量排行
//    create table result_reposts_comment_sort_table as
//    select a.remark as remark,a.uid as uid,(b.repostscount+b.commentscount) as activenum
//     from user_data_table a left join comment_data_temp_table b on a.uid=b.uid
//     order by remark,activenum desc;
//
    //
    //3.各类型活跃度排行
//    create table result_reamrk_sort_table as
//    select repo.remark ,(repostscountsum+commentscountsum) as activenumsum from
//    (select b.remark as remark,sum(a.repostscount) as repostscountsum
//    from comment_data_temp_table a join user_data_table b
//    on a.uid=b.uid
//    group by remark) repo
//    join
//    (select b.remark as remark,sum(a.commentscount) as commentscountsum
//    from comment_data_temp_table a join user_data_table b
//    on a.uid=b.uid
//    group by remark) comm
//    on repo.remark = comm.remark
//    order by activenumsum desc;
    //
    //使用sqoop导出数据
//    sqoop export
//    --connect jdbc:mysql://192.168.151.141:3306/EntertainmentDB?characterEncoding=UTF-8
//    --username root
//    --password 123456
//    --table result_comment_top10_table
//    --export-dir /hive/warehouse/entertainmentdb.db/result_comment_top10_table
//    --input-fields-terminated-by '\\t'
    //
    //
//    sqoop export
//    --connect jdbc:mysql://localhost:3306/EntertainmentDB?characterEncoding=UTF-8
//    --username root
//    --password strongs
//    --table result_reposts_comment_sort_table
//    --hcatalog-database EntertainmentDB
//    --export-dir result_reposts_comment_sort_table
    //
    //sqoop export
    //--connect jdbc:mysql://localhost:3306/EntertainmentDB?characterEncoding=UTF-8
    //--username root
    //--password strongs
    //--table result_reamrk_sort_table
    //--hcatalog-database EntertainmentDB
    //--export-dir result_reamrk_sort_table
    //--input-fields-terminated-by '\t'
//    --input-null-string '\\N'
//    --input-null-non-string '\\N'
    //
    //
}

-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

set
character_set_client='utf8';
set
character_set_connection='utf8';
set
character_set_database='utf8';
set
character_set_results='utf8';
set
character_set_server='utf8';
show
variables like 'char%';

/**
* 因為系統是 rotary sign-in, 取前墜 rs
*/
drop table if exists rs_participants;
create table rs_participants
(
    id          int         not null auto_increment comment '表 ID',
    participant varchar(64) not null comment '參與人',
    title       varchar(64) not null comment '職稱',
    club        varchar(128) comment '社團',
    device      varchar(512) comment '裝置',
    fingerprint varchar(128) comment '裝置唯一碼',
    sign_at     datetime comment '登記時間',
    version     int comment '版控',
    create_at   datetime comment '版控',
    update_at   datetime comment '版控',
    primary key (id)
) engine=innodb auto_increment=100 comment = '參與人登記表';

drop table if exists rs_happyandsmile;
create table rs_happyandsmile
(
    id          int         not null auto_increment comment '表 ID',
    participant varchar(64) not null comment '參與人',
    title       varchar(64) not null comment '職稱',
    club        varchar(128) comment '社團',
    device      varchar(512) comment '裝置',
    fingerprint varchar(128) comment '裝置唯一碼',
    price       Integer(10) comment '金額',
    paytype     int comment '支付方式 1:匯款 2:虛擬支付 3:現金 4:支票',
    remark      varchar(512) comment '祝福的話',
    sign_at     datetime comment '登記時間',
    version     int comment '版控',
    create_at   datetime comment '版控',
    update_at   datetime comment '版控',
    primary key (id)
) engine=innodb auto_increment=100 comment = '參與人登記表';
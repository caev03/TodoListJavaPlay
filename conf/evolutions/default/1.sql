# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tag (
  id                        bigint not null,
  label                     varchar(255),
  constraint pk_tag primary key (id))
;

create table task (
  id                        bigint not null,
  label                     varchar(255),
  notes                     varchar(255),
  priority                  integer,
  constraint pk_task primary key (id))
;

create sequence tag_seq;

create sequence task_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tag;

drop table if exists task;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tag_seq;

drop sequence if exists task_seq;


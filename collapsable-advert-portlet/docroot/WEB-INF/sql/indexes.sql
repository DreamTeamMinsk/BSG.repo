create index IX_6FDB9DF0 on Advert (groupId);
create index IX_F01FEC7A on Advert (uuid_);
create unique index IX_848EF170 on Advert (uuid_, groupId);
create table Advert (
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);
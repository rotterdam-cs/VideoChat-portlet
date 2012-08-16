create table VideoChat_ChatRoom (
	chatRoomId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	sessionId VARCHAR(255) null,
	name VARCHAR(75) null,
	description VARCHAR(255) null
);

create table VideoChat_ChatRoomGroup (
	chatRoomId LONG not null,
	chatRoomGroupId LONG not null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	type_ INTEGER,
	primary key (chatRoomId, chatRoomGroupId)
);

create table VideoChat_Configuration (
	apiKey VARCHAR(75) not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	apiSecret VARCHAR(255) null,
	type_ INTEGER
);
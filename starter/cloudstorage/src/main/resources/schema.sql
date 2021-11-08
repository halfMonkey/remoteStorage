CREATE TABLE IF NOT EXISTS USERS (
  userid INT PRIMARY KEY auto_increment,
  username VARCHAR(100),
  salt VARCHAR(100),
  password VARCHAR(100),
  firstname VARCHAR(20),
  lastname VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS NOTES (
    noteid INT PRIMARY KEY auto_increment,
    notetitle VARCHAR(20),
    notedescription VARCHAR (1000),
    userid INT,
    foreign key (userid) references USERS(userid)
);

CREATE TABLE IF NOT EXISTS FILES (
    fileid INT PRIMARY KEY auto_increment,
    filename VARCHAR(1000),
    contenttype VARCHAR(1000),
    filesize VARCHAR(1000),
    userid INT,
    filedata BLOB,
    foreign key (userid) references USERS(userid)
);

CREATE TABLE IF NOT EXISTS CREDENTIALS (
    credentialid INT PRIMARY KEY auto_increment,
    url VARCHAR(1000),
    username VARCHAR (200),
    token VARCHAR(1000),
    password VARCHAR(100),
    userid INT,
    foreign key (userid) references USERS(userid)
);
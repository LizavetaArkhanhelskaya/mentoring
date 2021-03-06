DROP TABLE POST_LIKES;
DROP TABLE POSTS;
DROP TABLE FRIENDSHIPS;
DROP TABLE USERS;

CREATE TABLE USERS
(
    ID NUMBER NOT NULL ENABLE,
	NAME VARCHAR2(4000) NOT NULL ENABLE,
	SURNAME VARCHAR2(4000) NOT NULL ENABLE,
	BIRTHDATE DATE NOT NULL ENABLE,
	CONSTRAINT USERS_PK PRIMARY KEY (ID) ENABLE
);

CREATE TABLE FRIENDSHIPS
(
    USER_ID1 NUMBER NOT NULL ENABLE,
	USER_ID2 NUMBER NOT NULL ENABLE,
	TIMESTAMP TIMESTAMP (6),
	CONSTRAINT FRIENDSHIPS_FK_1 FOREIGN KEY (USER_ID1) REFERENCES USERS (ID) ENABLE,
	CONSTRAINT FRIENDSHIPS_FK_2 FOREIGN KEY (USER_ID2) REFERENCES USERS (ID) ENABLE
);

CREATE TABLE POSTS
(
    ID NUMBER,
	USER_ID NUMBER,
	TEXT VARCHAR2(4000),
	TIMESTAMP TIMESTAMP (6),
	CONSTRAINT POSTS_PK PRIMARY KEY (ID) ENABLE,
	CONSTRAINT POSTS_FK FOREIGN KEY (USER_ID) REFERENCES USERS (ID) ENABLE
);

CREATE TABLE POST_LIKES
(
    POST_ID NUMBER,
	USER_ID NUMBER,
	TIMESTAMP TIMESTAMP (6),
	CONSTRAINT POST_LIKES_FK_1 FOREIGN KEY (POST_ID) REFERENCES  POSTS (ID) ENABLE,
	CONSTRAINT POST_LIKES_FK_2 FOREIGN KEY (USER_ID) REFERENCES  USERS (ID) ENABLE
);

COMMIT;
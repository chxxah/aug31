DROP TABLE IF EXISTS board;
CREATE TABLE board(
    bno 		IDENTITY PRIMARY KEY,
    btitle 		VARCHAR(50),
    bcontent 	VARCHAR(500),
    mname 		VARCHAR(10)
);
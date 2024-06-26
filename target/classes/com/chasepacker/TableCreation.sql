-- Don't immediately commit changes
BEGIN TRANSACTION;

-- Create the database

-- Create the User table
CREATE TABLE User (
    username VARCHAR(10) PRIMARY KEY
);

-- Create the DiaryEntry table
CREATE TABLE DiaryEntry (
    username VARCHAR(10),
    entry_date DATE,
    content VARCHAR(800),
    PRIMARY KEY (username, entry_date),
    FOREIGN KEY (username) REFERENCES User(username)
);



--Sample Create Diary Entry Statement (Eventually to put in code with parameters)
INSERT INTO DiaryEntry (username, entry_date, content) VALUES ('user1', '2020-01-01', 'This is the content of the entry');

--Sample Edit Existing Diary Entry Statement (Eventually to put in code with parameters)
UPDATE DiaryEntry SET content = 'This is the new content of the entry' WHERE username = 'user1' AND entry_date = '2020-01-01';

--Sample Delete Diary Entry Statement (Eventually to put in code with parameters)
DELETE FROM DiaryEntry WHERE username = 'user1' AND entry_date = '2020-01-01';

--Sample Get Diary Entry Statement (Eventually to put in code with parameters)
SELECT content FROM DiaryEntry WHERE username = 'user1' AND entry_date = '2020-01-01';

--Query to get list of dates in a month that have diaryentries, to be used in the calendar
SELECT entry_date FROM DiaryEntry WHERE username = 'user1' AND entry_date BETWEEN '2020-01-01' AND '2020-01-31';

COMMIT;
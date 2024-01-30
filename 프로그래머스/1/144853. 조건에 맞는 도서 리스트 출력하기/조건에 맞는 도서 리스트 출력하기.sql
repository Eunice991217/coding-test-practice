-- 코드를 입력하세요
# select * from book;
select book_id as BOOK_ID, left(published_date, 10) as PUBLISHED_DATE
from book
where category = '인문' and left(published_date, 4)='2021'
order by published_date;
-- 코드를 입력하세요
# select * from patient;
select pt_name as PT_NAME, pt_no as PT_NO, gend_cd as GEND_CD, age as AGE, ifnull(tlno, 'NONE') as TLNO
from patient
where age<=12 and gend_cd='w'
order by age desc, pt_name asc;

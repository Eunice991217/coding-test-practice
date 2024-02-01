select member_id as MEMBER_ID, member_name as MEMBER_NAME, gender as GENDER, left(date_of_birth, 10) as DATE_OF_BIRTH
from member_profile
where gender='w'and tlno is not null and date_of_birth like '%03%'
order by member_id;

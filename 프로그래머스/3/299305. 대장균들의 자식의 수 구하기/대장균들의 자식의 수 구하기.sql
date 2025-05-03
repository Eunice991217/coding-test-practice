# select * from ecoli_data;

# 대장균 개체의 ID, 자식의 수 출력하는 SQL 문
# 오름차순 정렬

select id, ifnull(
    (select count(*) from ecoli_data group by parent_id having parent_id = id), 0) as child_count
from ecoli_data
order by id;
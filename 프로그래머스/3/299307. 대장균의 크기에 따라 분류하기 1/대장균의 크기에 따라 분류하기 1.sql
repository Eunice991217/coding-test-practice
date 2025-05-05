# select * from ecoli_data;

# 대장균 개체 크기 size_of_colony
# 100 이하 LOW
# 100 초과 1000 이하 MEDIUM
# 1000 초과 HIGH 

select id, case when size_of_colony <= 100 then 'LOW' when size_of_colony> 100 and size_of_colony<=1000 then 'MEDIUM' else 'HIGH' end as size
from ecoli_data
order by id;
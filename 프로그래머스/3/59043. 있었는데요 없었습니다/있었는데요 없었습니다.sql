# select * from animal_ins;
# select * from animal_outs;

# 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회
# 보호 시작일이 빠른 순으로 조회 

select ins.animal_id, outs.name
from animal_ins as ins join animal_outs as outs
on ins.animal_id = outs.animal_id
where ins.datetime > outs.datetime
order by ins.datetime

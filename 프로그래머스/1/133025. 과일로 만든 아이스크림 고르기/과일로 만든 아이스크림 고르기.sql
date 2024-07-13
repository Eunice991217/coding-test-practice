# 상반기 아이스크림 총 주문량이 3000보다 높으면서 아이스크림의 주 성분이 과일 
# 총 주문량이 큰 순서대로 (내림차순)

select fh.FLAVOR 
from FIRST_HALF fh
join ICECREAM_INFO ii on fh.FLAVOR = ii.FLAVOR
where fh.TOTAL_ORDER > 3000 and ii.INGREDIENT_TYPE = 'fruit_based'
order by fh.TOTAL_ORDER desc;


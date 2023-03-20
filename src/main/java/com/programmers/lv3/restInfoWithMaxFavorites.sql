-- 코드를 입력하세요 v1
SELECT food_type, rest_id, rest_name, favorites
from rest_info
group by food_type
having favorites = max(favorites)
order by food_type desc;

-- 코드를 입력하세요 v2
SELECT food_type, rest_id, rest_name, favorites
from rest_info r1
group by food_type
having favorites = (select max(favorites) from rest_info r2 group by food_type having r1.food_type = r2.food_type)
order by food_type desc;

-- 코드를 입력하세요 2023.3.21(화) 2h5 v3 정답!
select s.food_type, r.rest_id, r.rest_name, s.favorites
from (select food_type, max(favorites) favorites from rest_info group by food_type) s, rest_info r
where s.food_type = r.food_type and s.favorites = r.favorites
order by food_type desc;

-- 코드를 입력하세요
SELECT ri.rest_id, rest_name, food_type, favorites, address, round(avg(review_score), 2) as 'score'
from rest_info ri
left join rest_review rv on ri.rest_id = rv.rest_id
where address like '서울%'
order by score desc, favorites desc;
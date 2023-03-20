-- 코드를 입력하세요
SELECT s.category, max_price, f.product_name
from (select category, max(price) max_price
     from food_product
     where category in ('과자', '국', '김치', '식용유')
     group by category) s, food_product f
where s.category = f.category and s.max_price = f.price
order by max_price desc;
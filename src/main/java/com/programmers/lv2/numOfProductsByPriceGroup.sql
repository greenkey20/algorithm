-- 코드를 입력하세요
SELECT price_group, count(*) products
from product
group by floor(price / 10000) * 10000 as 'price_group'
order by price_group;
-- 19h55 실행 결과 = SQL 실행 중 오류가 발생하였습니다. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'as 'price_group' order by price_group' at line 4
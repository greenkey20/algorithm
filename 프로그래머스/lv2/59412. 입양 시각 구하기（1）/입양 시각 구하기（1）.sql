-- 코드를 입력하세요
SELECT hour(datetime) hour, count(*) count
from animal_outs
group by hour
having hour between 9 and 19
order by hour;
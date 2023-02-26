-- 코드를 입력하세요
SELECT name, count
from animal_ins
where name is not null
group by name
having (select count(*) count from animal_ins where name is not null group by name) > 1;
-- 0h5 실행 결과 = SQL 실행 중 오류가 발생하였습니다. Unknown column 'count' in 'field list'
-- 코드를 입력하세요
SELECT id, name, p.host_id
from (select host_id, count(*) count from places group by host_id) s, places p
where count >= 2 and s.host_id = p.host_id
order by id;
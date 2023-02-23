-- 코드를 입력하세요
SELECT mcdp_cd '진료과코드', count(*) '5월예약건수'
from appointment
where year(apnt_ymd) = '2022' and month(apnt_ymd) = '05'
group by 진료과코드
order by 5월예약건수, 진료과코드;
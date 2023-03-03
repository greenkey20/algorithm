-- 코드를 입력하세요
SELECT month(start_date) month, car_id, count(*) records
from car_rental_company_rental_history
where year(start_date) = 2022 and month(start_date) between 8 and 10
group by car_id, month(start_date)
having count(*) >= 5 and count(*) != 0
order by month(start_date), car_id desc;
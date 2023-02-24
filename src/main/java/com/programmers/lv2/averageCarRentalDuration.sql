-- 코드를 입력하세요 v1
SELECT car_id, round(avg(end_date - start_date), 1) average_duration
from car_rental_company_rental_history
group by car_id
having avg(end_date - start_date) >= 7
order by average_duration desc, car_id desc;

-- 코드를 입력하세요 v2
SELECT car_id, round(avg(datediff(end_date, start_date)), 1) average_duration
from car_rental_company_rental_history
group by car_id
having avg(datediff(end_date, start_date)) >= 7
order by average_duration desc, car_id desc;

-- 코드를 입력하세요 v3
select car_id, round(average_duration, 1) average_duration
from (select car_id, avg(datediff(end_date, start_date)) average_duration
      from car_rental_company_rental_history
      group by car_id) s
where average_duration >= 7
order by average_duration desc, car_id desc;
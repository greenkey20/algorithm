-- 코드를 입력하세요 v1
SELECT car_id, case when '2022-10-16' between start_date and end_date then '대여중'
                    else '대여 가능'
    end availability
from car_rental_company_rental_history
group by car_id
order by car_id desc;

-- 코드를 입력하세요 v2
select car_id, case when start_date <= '2022-10-16' and end_date >= '2022-10-16' then '대여중'
-- SELECT car_id, case when '2022-10-16' between start_date and end_date then '대여중'
                    else '대여 가능'
    end availability
--        , start_date, end_date
from car_rental_company_rental_history
group by car_id
order by car_id desc;
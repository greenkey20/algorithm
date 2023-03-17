-- 코드를 입력하세요
SELECT book_id, author_name, date_format(published_date, '%Y-%d-%m') published_date -- 2023.3.18(토) 3h 발견 = 날짜 형식을 잘못 써서(year-day-month) 틀린 것이었음
from book b
left join author a on b.author_id = a.author_id
where category = '경제'
order by published_date;
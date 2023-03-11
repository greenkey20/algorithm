-- 코드를 입력하세요
SELECT book_id, author_name, date_format(published_date, '%Y-%d-%m') published_date
from book b
left join author a on b.author_id = a.author_id
where category = '경제'
order by published_date;
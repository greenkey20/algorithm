-- 코드를 입력하세요
SELECT b.author_id, author_name, category, sum(price * sales) total_sales
from book b
         left join author a on b.author_id = a.author_id
         left join book_sales s on b.book_id = s.book_id
group by author_id, category
order by author_id, category desc;
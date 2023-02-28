-- 코드를 입력하세요
SELECT member_name, review_text, date_format(review_date, '%Y-%m-%d') review_date
from rest_review r
         left outer join member_profile m on r.member_id = m.member_id
where member_name = (select member_name
                     from rest_review r
                              left outer join member_profile m on r.member_id = m.member_id
                     group by member_name
                     having max(count(*)))
order by review_date, review_text;

-- 우선, 회원별 리뷰 수 구하기
# select member_name, count(*)
# from rest_review r
# left outer join member_profile m on r.member_id = m.member_id
# group by member_name
# order by count(*) desc;

-- 리뷰 수가 가장 많은 회원 구하기
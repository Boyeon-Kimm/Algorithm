SELECT a.author_id AS AUTHOR_ID, a.author_name AS AUTHOR_NAME, b.category AS CATEGORY, SUM(b.price * s.sales) AS TOTAL_SALES
FROM author AS a
    LEFT JOIN book AS b ON b.author_id = a.author_id
    LEFT JOIN book_sales AS s ON s.book_id = b.book_id
WHERE s.sales_date LIKE '2022-01%'
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY author_id ASC, category DESC
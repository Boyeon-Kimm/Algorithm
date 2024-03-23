SELECT F.FLAVOR
FROM FIRST_HALF AS F
JOIN JULY AS J ON F.FLAVOR = J.FLAVOR
GROUP BY F.FLAVOR
ORDER BY (SUM(F.TOTAL_ORDER) + SUM(J.TOTAL_ORDER)) DESC
LIMIT 3
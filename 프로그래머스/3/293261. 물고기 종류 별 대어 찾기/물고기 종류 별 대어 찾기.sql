SELECT f.id AS ID
        , n.fish_name AS FISH_NAME
        , f.length AS LENGTH
FROM fish_info AS f
JOIN fish_name_info AS n
ON f.fish_type = n.fish_type
WHERE f.fish_type IN
(
    SELECT fish_type
    FROM fish_info
    GROUP By fish_type
    HAVING LENGTH = MAX(LENGTH)
)
ORDER BY ID
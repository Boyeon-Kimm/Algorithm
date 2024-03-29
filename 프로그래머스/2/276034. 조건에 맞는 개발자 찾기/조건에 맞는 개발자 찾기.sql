SELECT d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM DEVELOPERS d
WHERE d.SKILL_CODE &
(
SELECT CODE
FROM SKILLCODES
WHERE NAME = 'C#'
)
OR d.SKILL_CODE &
(
SELECT CODE
FROM SKILLCODES
WHERE NAME = 'Python'
)
ORDER BY ID
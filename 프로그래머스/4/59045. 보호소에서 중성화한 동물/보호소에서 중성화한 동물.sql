SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS I
LEFT JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE LIKE 'Intact %'
        AND (O.SEX_UPON_OUTCOME = 'Neutered Male'
        OR O.SEX_UPON_OUTCOME = 'Spayed Female')
ORDER BY I.ANIMAL_ID
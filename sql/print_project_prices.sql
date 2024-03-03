SELECT p.id, 
       SUM(w.SALARY) * (DATEDIFF('MONTH', p.START_DATE, p.FINISH_DATE)) AS PRICE
FROM project p
JOIN project_worker pw ON p.id = pw.PROJECT_ID
JOIN worker w ON pw.WORKER_ID = w.id
GROUP BY p.id
ORDER BY PRICE DESC;
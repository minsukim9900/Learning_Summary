USE SSAFY_CORPORATION;

# Q1. 모든 사용 모든 정보 검색
SELECT *
FROM EMP;

# Q2-1. 사원이 근무하는 부서 번호
SELECT DEPTNO
FROM EMP;

# Q2-2. 사원이 근무하는 부서 번호(중복 제거)
SELECT DISTINCT DEPTNO AS "부서번호"
FROM EMP;

# Q3. 사원의 이름, 부서번호, 업무 조회
SELECT ENAME, DEPTNO, JOB
FROM EMP;

# Q4. 사원의 이름, 사번, 급여*12 (연봉), 업무 조회
SELECT ename AS "이름", empno AS "사번", sal*12 AS "연봉", job AS "업무"
FROM EMP;

# Q5. 사원의 이름, 사번, 커미션, 급여, 커미션 포함 급여 조회
SELECT ename AS "이름", empno AS "사번", comm AS "커미션",
 sal AS "급여", sal + comm AS "커미션 포함 급여",
 sal + IFNULL(comm, 0) AS "커미션 포함 급여2"
FROM emp;

# Q6. 모든 사원의 사번, 이름, 급여, 급여 등급 조회(5000 이상 -> 높은 연봉, 2000 이상 -> 평균 연봉, 그 외 -> 낮은 연봉)
SELECT empno, ename, sal,
	CASE WHEN sal >= 5000 THEN "높은연봉"
		 WHEN sal >= 2000 THEN "평균연봉"
         ELSE "낮은연봉"
	END AS "연봉등급"
FROM emp;

# Q7. 부서번호가 30인 사원중 급여가 1500 이상인 사원의 이름, 급여, 부서번호 조회
SELECT ename, sal, deptno
FROM emp
WHERE deptno = 30
  AND sal >= 1500;

# Q8. 부서번호가 20 또는 30인 부서에서 근무하는 사원의 사번, 이름, 부서번호 조회
SELECT empno, ename, deptno
FROM emp
WHERE deptno = 20
   or deptno = 30;
   
# Q9. 부서번호가 20, 30이 아닌 부서에서 근무하는 사원의 사번, 이름, 부서번호 조회
SELECT empno, ename, deptno
FROM emp
WHERE deptno != 20
  AND deptno <> 30;
  
SELECT empno, ename, deptno
FROM emp
WHERE NOT (deptno = 30 OR deptno = 20);

# Q10. 업무가 MANAGER, ANALYST, PRESIDENT인 사원의 이름, 사번 업무 조회
SELECT ename, empno, job
FROM emp
WHERE job IN("MANAGER", "ANALYST", "PRESIDENT");

# Q11. 부서번호가 10, 20이 아닌 사원의 사번, 이름, 부서번호 조회
SELECT empno, ename, deptno
FROM emp
WHERE deptno NOT IN(10,20);

# Q12. 급여가 2000이상 3000이하 인 사람의 사람의 사번, 이름, 급여조회
SELECT empno, ename, sal
FROM emp
WHERE sal BETWEEN 2000 AND 3000;

# Q13. 입사일이 1981년인 직원의 사번, 이름, 입사일 조회
SELECT empno, ename, hiredate
FROM emp
WHERE hiredate BETWEEN '1981-01-01' AND '1981-12-31';

# Q14. 커미션이 NULL인 사원의 사번, 이름, 커미션 조회
SELECT empno, ename, comm
FROM emp
WHERE comm IS NULL;

# Q15. 커미션이 NULL이 아닌 사원의 사번, 이름, 업무, 커미션 조회
SELECT empno, ename, job, comm
FROM emp
WHERE comm IS NOT NULL;

# Q16. 이름이 'M'으로 시작하는 사원의 사번, 이름 조회
SELECT empno, ename
FROM emp
WHERE ename LIKE "M%";

# Q17. 이름에 E가 포함된 사원의 사번 이름 조회
SELECT empno, ename
FROM emp
WHERE ename LIKE '%E%';

# Q18. 이름의 세번째 알파벳이 'A'인 사람의 사번, 이름 조회
SELECT empno, ename
FROM emp
WHERE ename LIKE '__A%';

# Q19. 모든 직원의 모든 정보를 이름을 기준으로 내림차순 정렬
SELECT *
FROM emp
ORDER BY ename DESC;

# Q20. 모든 사원의 사번, 이름, 급여를 조회 (급여 내림차순)
SELECT empno, ename, sal
FROM emp
ORDER BY sal DESC;

# Q21. 20, 30번 부서에 근무하는 사원의 사번, 이름, 부서번호, 급여 조회(부서별 오름차순, 급여순 내림차순)
SELECT empno, ename, deptno, sal
FROM emp
WHERE deptno IN (20, 30)
ORDER BY deptno ASC, sal DESC;

# Q22. 모든 사원에 대하여 사원 수, 급여 총액, 평균 급여, 최고 급여, 최저 급여 조회
SELECT COUNT(*) "총 사원 수", SUM(sal) AS "급여 총액", AVG(sal) AS "평균 급여",
	   MAX(sal) AS "최고 급여", MIN(sal) AS "최저 급여"
FROM emp;

# Q23. 모든 사원에 대하여 부서, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별로 조회하고, 소수점 둘째자리 반올림
SELECT deptno AS "부서번호",  COUNT(*) AS "사원 수", SUM(sal) AS "급여총액", ROUND(AVG(sal),2) AS "평균급여", MAX(sal) AS "최고 급여", MIN(sal) AS "최저 급여"
FROM emp
GROUP BY deptno;

# Q24. 모든 사원에 대하여 부서, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별 직급별로 조회하고, 소수점 둘째자리 반올림
SELECT deptno AS "부서번호", job AS "직급",  COUNT(*) AS "사원 수", SUM(sal) AS "급여총액", ROUND(AVG(sal),2) AS "평균급여", MAX(sal) AS "최고 급여", MIN(sal) AS "최저 급여"
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

# Q25. 급여(커미션포함) 평균이 2000이상인 부서번호, 부서별 사원수, 평균 급여(커미션포함) 조회
SELECT deptno, COUNT(*), ROUND(AVG(sal+IFNULL(comm, 0)),2)
FROM emp
GROUP BY deptno
HAVING AVG(sal + IFNULL(comm, 0)) >= 2000;

# 플러스
SELECT *
FROM emp
ORDER BY sal DESC
LIMIT 5, 10;

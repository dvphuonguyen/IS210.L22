--BAI01:
--1:

CREATE USER SinhVien01 IDENTIFIED BY SV01;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien01;
--
CREATE USER SinhVien02 IDENTIFIED BY SV02;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien02;
--
CREATE USER SinhVien03 IDENTIFIED BY SV03;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien03;
--
CREATE USER SinhVien04 IDENTIFIED BY SV04;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien04;
--
CREATE USER SinhVien05 IDENTIFIED BY SV05;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien05;
--
CREATE USER SinhVien06 IDENTIFIED BY SV06;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien06;
--
CREATE USER SinhVien07 IDENTIFIED BY SV07;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien07;
--
CREATE USER SinhVien08 IDENTIFIED BY SV08;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien08;
--
CREATE USER SinhVien09 IDENTIFIED BY SV09;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien09;
--
CREATE USER SinhVien10 IDENTIFIED BY SV10;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien10;
--
CREATE USER SinhVien11 IDENTIFIED BY SV11;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien11;
--
CREATE USER SinhVien12 IDENTIFIED BY SV12;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien12;
--
CREATE USER SinhVien13 IDENTIFIED BY SV13;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien13;
--
CREATE USER SinhVien14 IDENTIFIED BY SV14;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien14;
--
CREATE USER SinhVien15 IDENTIFIED BY SV15;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien15;
--
CREATE USER SinhVien16 IDENTIFIED BY SV16;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien16;
--
CREATE USER SinhVien17 IDENTIFIED BY SV17;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien17;
--
CREATE USER SinhVien18 IDENTIFIED BY SV18;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien18;
--
CREATE USER SinhVien19 IDENTIFIED BY SV19;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien19;
--
CREATE USER SinhVien20 IDENTIFIED BY SV20;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien20;
--



select * from all_users;

select * from DBA_ROLE_PRIVS
where UPPER(GRANTEE) like '%SINHVIEN01%';

select * from DBA_ROLES;


select * from dba_sys_privs where grantee='ROLE_USER';
select * from dba_role_privs where grantee='ROLE_USER';


--2:
CREATE ROLE Role_QUANTRI IDENTIFIED BY RQT01;

GRANT connect, resource,
oem_monitor, dba TO Role_QUANTRI;

CREATE ROLE Role_NGUOIDUNG IDENTIFIED BY RND01;

GRANT connect, resource,
oem_monitor TO Role_NGUOIDUNG;

--3:
GRANT Role_QUANTRI TO SinhVien01;
GRANT Role_QUANTRI TO SinhVien02;
GRANT Role_QUANTRI TO SinhVien03;
GRANT Role_QUANTRI TO SinhVien04;
GRANT Role_QUANTRI TO SinhVien05;
GRANT Role_QUANTRI TO SinhVien06;
GRANT Role_QUANTRI TO SinhVien07;
GRANT Role_QUANTRI TO SinhVien08;
GRANT Role_QUANTRI TO SinhVien09;
GRANT Role_QUANTRI TO SinhVien10;


GRANT Role_NGUOIDUNG TO SinhVien11;
GRANT Role_NGUOIDUNG TO SinhVien12;
GRANT Role_NGUOIDUNG TO SinhVien13;
GRANT Role_NGUOIDUNG TO SinhVien14;
GRANT Role_NGUOIDUNG TO SinhVien15;
GRANT Role_NGUOIDUNG TO SinhVien16;
GRANT Role_NGUOIDUNG TO SinhVien17;
GRANT Role_NGUOIDUNG TO SinhVien18;
GRANT Role_NGUOIDUNG TO SinhVien19;
GRANT Role_NGUOIDUNG TO SinhVien20;

--BAI 2:
--1:
select ID Mã_Khách_Hàng, NAME Tên_Khách_Hàng
from s_customer
--2:
select userid
from s_emp
where id  = 23
--3:
select concat(concat(first_name, ' '),  last_name) Employees, dept_id
from s_emp
where dept_id in (10, 50)
--4:
SELECT *
FROM  s_emp
WHERE  (first_name like '%s%') OR (last_name like '%s');
---5:
select userid, START_DATE
FROM s_emp
where start_date in (TO_DATE('14/5/1990', 'DD/MM/YYYY'), TO_DATE('26/5/1991', 'DD/MM/YYYY'));
---6:
select concat(concat(first_name, ' '), last_name) as Employees, 
        salary
from s_emp
where salary between 1000 and 2000;
---7:
select concat(concat(first_name, ' '), last_name) as Employees_Name, 
        salary as  Monthly_Salary
from s_emp
where salary > 1350 and DEPT_ID in (31, 42, 60);
---8:
select concat(concat(first_name, ' '), last_name) as Employees_Name, 
        START_DATE
from s_emp
where extract(year from START_DATE) = 1991; 

--9:
select id, 
        concat(concat(first_name, ' '), last_name) as Employees_Name,
            salary
from s_emp
where COMMISSION_PCT = 15;

---10:
---11:
select name 
from s_product
where LOWER(name) like '%ski%';
---12:
select id, round(MONTHS_BETWEEN(SYSDATE, start_date), -1)
from s_emp;

---13:
select count(distinct MANAGER_ID)
from s_emp

---14:
select max(TOTAL) Hightest, min(TOTAL) LOWEST
from S_ord

---15:
select * from s_ord;
select * from s_product;
select * from s_inventory;
select * from s_customer;
---16:
select C.ID, O.ID
from s_customer C left join s_ord O
    on  C.ID = O.customer_id
---17:
select CUSTOMER_ID, count(ID)
from s_ord
where TOTAL > 100000
group by CUSTOMER_ID
---18:
select *
from s_emp
where id not in(
    select distinct MANAGER_ID
    from s_emp
    where MANAGER_ID is not null
    )

---19:
select NAME
from s_product 
where NAME like 'Pro%'
order by NAME asc;
--- 20:
select name, SHORT_DESC from s_product
where LOWER(SHORT_DESC) like '%bicycle%';
----21:
select SHORT_DESC
from s_product
---22:
select concat(concat(first_name, ' '), last_name) as Employees_Name,
        concat(concat('(', title), ')') as Tittle
from S_emp
---23: 
select s1.MANAGER_ID, count(s1.MANAGER_ID)
from s_emp s1
where MANAGER_ID is not null
group by s1.MANAGER_ID
order by s1.MANAGER_ID asc
--24:
select s1.MANAGER_ID, count(s1.MANAGER_ID)
from s_emp s1
where MANAGER_ID is not null
group by s1.MANAGER_ID
having count(s1.MANAGER_ID) >= 20
order by s1.MANAGER_ID asc
---25:
select s1.ID, s1.NAME, count(s2.ID)
from s_region s1 join s_dept s2   
    on s1.ID = s2.REGION_ID
group by s1.ID, s1.NAME 
order by s1.ID asc
---26:
select s1.ID, s1.NAME, count(s2.ID)
from s_customer s1 join s_ord s2
    on s1.ID = s2.CUSTOMER_ID
group by s1.ID, s1.NAME
---27:
select s1.ID, s1.NAME
from s_customer s1 join s_ord s2
    on s1.ID = s2.CUSTOMER_ID
group by s1.ID, s1.NAME
having count(s2.ID) >= (
    select max(count(s2.ID)) COUNTT 
    from s_customer s1 join s_ord s2
        on s1.ID = s2.CUSTOMER_ID
    group by s1.ID, s1.NAME
);
---28:
select s2.ID, s2.NAME, sum(TOTAL)
from s_ord s1 join s_customer s2
    on s1.CUSTOMER_ID = s2.ID
group by s2.ID, s2.NAME
having sum(TOTAL) = (
    select max(sum(TOTAL))
    from s_ord s1 join s_customer s2
    on s1.CUSTOMER_ID = s2.ID
    group by s2.ID, s2.NAME
)
---29:
--
---30:
select concat(concat(first_name, ' '), last_name) as Employees_Name, 
        start_date
from (
    select dept_id
    from s_emp
    where first_name = 'Eddie' 
    ) s2 join s_emp s1 on s2.dept_id = s1.dept_id
---31:
select id, 
        concat(concat(first_name, ' '), last_name) as Employees_Name,
            USERID
from (
    select avg(salary) as AVG_S
    from s_emp ) s1, s_emp
where salary  > AVG_S
---32:
select id, 
        concat(concat(first_name, ' '), last_name) as Employees_Name
         
from (
    select avg(salary) as AVG_S
    from s_emp ) s1, s_emp
where salary  > AVG_S and first_name like 'L%';

--33:
select *
from  s_customer s2 left join s_ord s1 
    on s1.CUSTOMER_ID = s2.ID
where s1.ID is null

--IV BTMR - VN:
--1
CREATE USER SinhVien01 IDENTIFIED BY SV01;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien01;
--
CREATE USER SinhVien02 IDENTIFIED BY SV02;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien02;
--
CREATE USER SinhVien03 IDENTIFIED BY SV03;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien03;
--
CREATE USER SinhVien04 IDENTIFIED BY SV04;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien04;
--
CREATE USER SinhVien05 IDENTIFIED BY SV05;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien05;
--
CREATE USER SinhVien06 IDENTIFIED BY SV06;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien06;
--
CREATE USER SinhVien07 IDENTIFIED BY SV07;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien07;
--
CREATE USER SinhVien08 IDENTIFIED BY SV08;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien08;
--
CREATE USER SinhVien09 IDENTIFIED BY SV09;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien09;
--
CREATE USER SinhVien10 IDENTIFIED BY SV10;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien10;
--
CREATE USER SinhVien11 IDENTIFIED BY SV11;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien11;
--
CREATE USER SinhVien12 IDENTIFIED BY SV12;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien12;
--
CREATE USER SinhVien13 IDENTIFIED BY SV13;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien13;
--
CREATE USER SinhVien14 IDENTIFIED BY SV14;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien14;
--
CREATE USER SinhVien15 IDENTIFIED BY SV15;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien15;
--
CREATE USER SinhVien16 IDENTIFIED BY SV16;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien16;
--
CREATE USER SinhVien17 IDENTIFIED BY SV17;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien17;
--
CREATE USER SinhVien18 IDENTIFIED BY SV18;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien18;
--
CREATE USER SinhVien19 IDENTIFIED BY SV19;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien19;
--
CREATE USER SinhVien20 IDENTIFIED BY SV20;
GRANT CONNECT, RESOURCE, oem_monitor
TO SinhVien20;
--2:
CREATE ROLE Role_QUANTRI IDENTIFIED BY RQT01;
GRANT CONNECT TO Role_QUANTRI;

GRANT SELECT, INSERT, UPDATE ON COURSE
TO Role_QUANTRI;

GRANT SELECT, INSERT, UPDATE ON STUDENT
TO Role_QUANTRI;

GRANT SELECT, INSERT, UPDATE ON CLASS
TO Role_QUANTRI;

GRANT SELECT, INSERT, UPDATE ON ENROLLMENT
TO Role_QUANTRI;

GRANT SELECT, INSERT, UPDATE ON INSTRUCTOR
TO Role_QUANTRI;

GRANT SELECT, INSERT, UPDATE ON GRADE
TO Role_QUANTRI;


CREATE ROLE Role_NGUOIDUNG IDENTIFIED BY RND01;

GRANT CONNECT TO Role_NGUOIDUNG;

GRANT SELECT ON COURSE
TO Role_NGUOIDUNG;

GRANT SELECT ON STUDENT
TO Role_NGUOIDUNG;

GRANT SELECT ON CLASS
TO Role_NGUOIDUNG;

GRANT SELECT ON ENROLLMENT
TO Role_NGUOIDUNG;

GRANT SELECT ON INSTRUCTOR
TO Role_NGUOIDUNG;

GRANT SELECT ON GRADE
TO Role_NGUOIDUNG;


--3:
GRANT Role_QUANTRI TO SinhVien01;
GRANT Role_QUANTRI TO SinhVien02;
GRANT Role_QUANTRI TO SinhVien03;
GRANT Role_QUANTRI TO SinhVien04;
GRANT Role_QUANTRI TO SinhVien05;
GRANT Role_QUANTRI TO SinhVien06;
GRANT Role_QUANTRI TO SinhVien07;
GRANT Role_QUANTRI TO SinhVien08;
GRANT Role_QUANTRI TO SinhVien09;
GRANT Role_QUANTRI TO SinhVien10;

--4:
GRANT Role_NGUOIDUNG TO SinhVien11;
GRANT Role_NGUOIDUNG TO SinhVien12;
GRANT Role_NGUOIDUNG TO SinhVien13;
GRANT Role_NGUOIDUNG TO SinhVien14;
GRANT Role_NGUOIDUNG TO SinhVien15;
GRANT Role_NGUOIDUNG TO SinhVien16;
GRANT Role_NGUOIDUNG TO SinhVien17;
GRANT Role_NGUOIDUNG TO SinhVien18;
GRANT Role_NGUOIDUNG TO SinhVien19;
GRANT Role_NGUOIDUNG TO SinhVien20;
--5:
REVOKE Role_QUANTRI FROM SinhVien01;
REVOKE Role_QUANTRI FROM SinhVien03;
REVOKE Role_QUANTRI FROM SinhVien05;
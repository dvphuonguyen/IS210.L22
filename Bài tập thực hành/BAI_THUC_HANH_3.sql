create table cau1
(
id number primary key,
name varchar2(20)
);

create sequence cau1seq
increment by 5
start with 1;

declare 
    v_name student.lastname%type;
    cursor cau_1_1_d is select s.lastname
                        from student s, enrollment e, class c
                        where s.studentid = e.studentid and e.classid = c.classid
                        group by s.studentid , s.lastname
                        having count(courseno) >= all ( select count(courseno)
                                                        from enrollment e1 , class c1
                                                        where e1.classid = c1.classid
                                                        group by e1.studentid
                                                        );
begin
    open cau_1_1_d;
    loop
        fetch cau_1_1_d into v_name;
        exit when cau_1_1_d%notfound;
        insert into cau1( id, name) values (cau1seq.nextval, v_name);
    end loop;
    exception
        when no_data_found then raise_application_error(-20000, 'Loi');
    close cau_1_1_d;
    savepoint a;
end;
select * from cau1;

declare 
    v_name student.lastname%type;
    cursor cau_1_1_e is select s.lastname
                        from student s, enrollment e, class c
                        where s.studentid = e.studentid and e.classid = c.classid
                        group by s.studentid , s.lastname
                        having count(courseno) <= all ( select count(courseno)
                                                        from enrollment e1 , class c1
                                                        where e1.classid = c1.classid
                                                        group by e1.studentid
                                                        );
begin
    open cau_1_1_e;
    loop
        fetch cau_1_1_e into v_name;
        exit when cau_1_1_e%notfound;
        insert into cau1( id, name) values (cau1seq.nextval, v_name);
    end loop;
    exception
        when no_data_found then raise_application_error(-20000, 'Loi');
    close cau_1_1_e;
    savepoint b;
end;
select * from cau1;

declare 
    v_name instructor.lastname%type;
    cursor cau_1_1_f is select i.lastname
                        from instructor i, class c
                        where i.instructorid = c.instructorid
                        group by i.instructorid, i.lastname
                        having count(courseno) >= all ( select count(courseno)
                                                        from class c1
                                                        group by c1.instructorid
                                                        );
begin
    open cau_1_1_f;
    loop
        fetch cau_1_1_f into v_name;
        exit when cau_1_1_f%notfound;
        insert into cau1( id, name) values (cau1seq.nextval, v_name);
    end loop;
    exception
        when no_data_found then raise_application_error(-20000, 'Loi');
    close cau_1_1_f;
    savepoint c;
end;
select * from cau1;

rollback savepoint c;

set serveroutput on;

declare 
    v_name instructor.lastname%type;
    type t_id is table of instructor.instructorid%type index by binary_integer;
    l_id t_id;
    l_id_count number := 0;
    l_id_count_1 number := 0;
    cursor cau_1_1_j is select i.lastname
                        from instructor i, class c
                        where i.instructorid = c.instructorid
                        group by i.instructorid, i.lastname
                        having count(courseno) >= all ( select count(courseno)
                                                        from class c1
                                                        group by c1.instructorid
                                                        );
   cursor cau_1_1_i is select i.lastname
                        from instructor i, class c
                        where i.instructorid = c.instructorid
                        group by i.instructorid, i.lastname
                        having count(courseno) <= all ( select count(courseno)
                                                        from class c1
                                                        group by c1.instructorid
                                                        );
begin
    open cau_1_1_j;
    loop
        fetch cau_1_1_j into v_name;
        exit when cau_1_1_j%notfound;
        l_id_count := l_id_count + 1;
    end loop;
    close cau_1_1_j;
    open cau_1_1_i;
    loop
        fetch cau_1_1_i into v_name;
        exit when cau_1_1_i%notfound;
        l_id_count_1 := l_id_count_1 + 1;
        if l_id_count_1 < l_id_count then
            insert into cau1 (id, name) values (l_id(l_id_count), v_name);
        else
            insert into cau1 (id, name) values (cau1seq.nextval, v_name);
        end if;
    end loop;
    exception
        when no_data_found then dbms_output.put_line('Loi');
        --raise_application_error(-20000, 'Loi');
    close cau_1_1_i;
end;
select * from cau1;

set serveroutput on;
declare
    v_id student.studentid%type;
    v_fn student.firstname%type;
    v_ln student.lastname%type;
    v_sl number;
begin
    v_id := &v_id;
    select s.firstname, s.lastname, count(e.classid) into v_fn, v_ln, v_sl
    from student s left join enrollment e on s.studentid = e.studentid
    where s.studentid = v_id
    group by s.studentid, s.firstname, s.lastname;
    dbms_output.put_line(v_fn || ' ' || v_ln || ' ' || v_sl);
    
    exception when no_data_found then 
        begin
        insert into student (studentid, lastname, firstname, address)
        values (v_id, '&lastname', '&firstname', '&address');
        end;
end;

--------------------------------------------------------------------------------------------------
set serveroutput on;
create or replace procedure cau_2_1 (v_id in instructor.instructorid%type)
is
    v_sl number;
begin
    select count(classid) into v_sl
    from class
    where v_id  = instructorid
    group by instructorid;
    
    if v_sl >= 5 then 
        dbms_output.put_line('Giao vien nay can duoc nghi noi');
    else
        dbms_output.put_line('So lop giao vien nay day la: ' || v_sl);
    end if;
end;
declare
    v_id instructor.instructorid%type;
begin
    v_id := &v_id;
    cau_2_1(v_id);
end;
select instructorid,  count(classid) from class group by instructorid;

create or replace procedure cau_2_2(s_id in student.studentid%type, c_id in class.classid%type)
is 
    diem char;
begin
    select case 
            when grade between 90 and 100 then 'A'
            when grade between 80 and 89 then 'B'
            when grade between 70 and 79 then 'C'
            when grade between 50 and 69 then 'D'
            else 'F'
            end 
            into diem
    from grade
    where studentid = s_id and classid = c_id;
    dbms_output.put_line('Sinh vien: ' || s_id ||' lop: '|| c_id || ' co diem la: '||diem);
    exception when no_data_found then
        raise_application_error(-20000, 'Ma lop hoac ma sinh vien khong ton tai');
end;
declare
    s_id student.studentid%type;
    c_id class.classid%type;
begin
    s_id := &s_id;
    c_id := &c_id;
    cau_2_2(s_id, c_id);
end;
select studentid, classid, grade
from grade;

------------------------------------------------------------------------------------------
create or replace procedure cau_3_1 (c_no in course.courseno%type)
is 
    c_d course.description%type;
    cl_id class.classid%type;
    v_sl number;
    cursor so_1 is select description
                    from course
                    where courseno = c_no;
    cursor so_2 is select cl.classid, count(studentid)
                   from class cl join enrollment e on cl.classid = e.classid
                   where courseno = c_no
                   group by cl.classid;
begin
    open so_1;
    loop
        fetch so_1 into c_d;
        exit when so_1%notfound;
        dbms_output.put_line(c_no|| ' ' || c_d);
        open so_2;
        loop
            fetch so_2 into cl_id, v_sl;
            exit when so_2%notfound;
            dbms_output.put_line('    Lop: '||cl_id||' co so luong sinh vien dang ky la: '||v_sl);
        end loop;
        close so_2;
    end loop;
    exception when no_data_found then
        dbms_output.put_line('Error');
    close so_1;
end;
    
declare 
    v_no course.courseno%type;
begin
    v_no := &v_no;
    cau_3_1(v_no);
end;
select c.courseno, c.description, cl.classid, count(studentid)
from course c join class cl on c.courseno = cl.courseno join enrollment e on e.classid = cl.classid
group by c.courseno, c.description, cl.classid
order by c.courseno;

create or replace procedure cau_3_2(c_no course.courseno%type)
is
    c_d course.description%type;
    cl_id class.classid%type;
    cl_sl number;
    cursor so_3 is select cl.classid, count(studentid)
                   from class cl join enrollment e on cl.classid = e.classid
                   where courseno = c_no
                   group by cl.classid;
begin 
    select description into c_d 
    from course
    where courseno = c_no;
    dbms_output.put_line(c_no|| ' ' || c_d);
    open so_3;
    loop
        fetch so_3 into cl_id, cl_sl;
        exit when so_3%notfound;
        dbms_output.put_line('    Lop: '||cl_id||' co so luong sinh vien dang ky la: '||cl_sl);
    end loop;
    exception when no_data_found then
        dbms_output.put_line('Error');
    close so_3;
end;
declare
    v_no course.courseno%type;
begin
    v_no := &v_no;
    cau_3_2(v_no);
end;

---------------------------------------------------------------------------------------
create or replace procedure find_sname(i_student_id in student.studentid%type, 
                                        o_first_name out student.firstname%type,
                                        o_last_name out student.lastname%type)
is
begin
    select firstname, lastname into o_first_name, o_last_name
    from student
    where studentid = i_student_id;
end;
declare 
    i_student_id student.studentid%type;
    o_first_name student.firstname%type;
    o_last_name student.lastname%type;
begin
    i_student_id := &i_student_id;
    find_sname(i_student_id, o_first_name, o_last_name);
    dbms_output.put_line('Ho: '|| o_last_name || ' ten: '|| o_first_name);
end;
select * from student;

create or replace procedure print_student_name (i_student_id in student.studentid%type)
is 
    o_first_name student.firstname%type;
    o_last_name student.lastname%type;
begin
     select firstname, lastname into o_first_name, o_last_name
    from student
    where studentid = i_student_id;
    dbms_output.put_line('Ho: '|| o_last_name || ' ten: '|| o_first_name);
end;
declare 
    i_student_id student.studentid%type;
begin
    i_student_id := &i_student_id;
    print_student_name(i_student_id);
end;

create or replace procedure discount
is
    v_no course.courseno%type;
    v_d course.description%type;
    cursor cau_4_2 is select c.courseno, c.description
                        from course c, class cl, enrollment e
                        where c.courseno = cl.courseno and cl.classid = e.classid
                        group by c.courseno, c.description
                        having count(studentid) > 15
                        order by c.courseno;
begin
    open cau_4_2;
    loop
        fetch cau_4_2 into v_no, v_d;
        exit when cau_4_2%notfound;
        update course
        set cost = cost*0.95
        where courseno = v_no;
        
        dbms_output.put_line('Ma mon hoc: '|| v_no|| ' ten mon hoc: ' || v_d);
    end loop;
    close cau_4_2;
end;
declare 
begin
    discount();
end;

create or replace function total_cost_for_student (i_student_id in student.studentid%type)
return course.cost%type
is
    tien course.cost%type;
begin
    select sum(cost) into tien
    from course c, class cl, enrollment e
    where c.courseno = cl.courseno and e.classid = cl.classid
        and studentid = i_student_id
    group by e.studentid;
    return tien;
    exception when no_data_found then
        return NULL;
end;
declare 
    i_student_id student.studentid%type;
    tien course.cost%type;
begin
    i_student_id := &i_student_id;
    tien := total_cost_for_student(i_student_id);
    dbms_output.put_line('Tong hoc phi cua sinh vien: '|| i_student_id || ' la: '|| tien);
end;
select studentid, sum(cost)
    from course c, class cl, enrollment e
    where c.courseno = cl.courseno and e.classid = cl.classid
    group by e.studentid
    order by 1;

------------------------------------------------------------------------------------------
select * from class;
create or replace trigger insert_class
before insert on class
for each row
begin
    if :new.classid is not null then
        :new.createdby := user;
        :new.modifiedby := user;
        :new.createdate := sysdate;
        :new.modifieddate := sysdate;
    end if;
end;

create or replace trigger update_class
before update on class
for each row
begin
    update class
    set :new.createdby = user,
        :new.modifiedby = user,
        :new.createdate = sysdate,
        :new.modifieddate = sysdate
    where classid = :new.classid;
end;
------ nhung cai khac lam tuong tu----------
create or replace trigger cau_5_2
before insert or update on enrollment
for each row
declare
    v_sl_1 number;
begin
    select count(classid) into v_sl_1
    from enrollment
    where studentid = :new.studentid;
    
    if v_sl_1 >= 4 then
        raise_application_error(-20000,'Moi sinh vien khong duoc dang ky qua 4 lop'); 
    else
        commit;
    end if;
end;


select studentid, count(classid)
from enrollment
group by studentid
order by 1;

select *
from enrollment
where studentid = 105
order by 1;

INSERT INTO enrollment VALUES (107,96,'02-FEB-99',NULL,'02-FEB-99','JAYCAF','03-NOV-99','CBRENNAN','12-DEC-99');
INSERT INTO enrollment VALUES (105,100,'02-FEB-99',NULL,'02-FEB-99','JAYCAF','03-NOV-99','CBRENNAN','12-DEC-99'); 

update enrollment
set studentid = 109
where studentid = 108;

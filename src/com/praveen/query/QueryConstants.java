package com.praveen.query;

public interface QueryConstants {
String insert_query="insert into Employee values(?,?,?)";
String create_query="create table Employee1(eno number(5),ename varchar2(20),esal varchar2(20))";
String select_query="select * from Employee where eno=?";
String modify_query="update Employee set ename=?,esal=? where eno=?";
String delete_query="delete from Employee where eno=?";

}

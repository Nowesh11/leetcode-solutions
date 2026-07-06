# Write your MySQL query statement below

select p.firstname, p.lastname, a.state, a.city from Person p left join Address a on p.personId = a.personId

# JPA_1plusN
예시
CountryEntity(one) <-> CityEntity(many)
Ex) korea: seoul, busan....

**Case 1. Country 조회**
- one 조회 후 many 접근 안 했을 때
 쿼리 한 번
- one 조회 후 many 접근 했을 때
 Country 조회 후 many 개수 만큼 쿼리 조회 ---> 1+N 문제

**Case 2. Country 조회**
- many 조회 후 one 접근 안 했을 때
  쿼리 두 번
- many 조회 후 one 접근 했을 때
  쿼리 두 번
==========================================================
JPA JOIN 별 기본 값
oneToOne: Eager
manyToOne: Eager
oneToMany: Lazy



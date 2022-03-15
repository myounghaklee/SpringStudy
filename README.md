## JPQL

JPA를 사용하면 엔티티 객체를 중심으로 개발한다.
select 조회 쿼리를 사용할때 테이블이 아닌 엔티티 객체를 대상으로 검색을한다. 
모든 DB의 데이터를 객체로 변환해서 검색하는것은 불가능하기 때문에 애플리케이션이 필요한 데이터만 DB에서 불러오려면 결국 검색조건이(where절, join, subQuery.. etc) 포함된 SQL이 필요하다. 

JPQL이 아닌 일반 Query를 사용하면 사용하면된다.

```sql
select * from Member
```

하지만 JPQL을 사용하면 아래처럼 Member 객체에서 m을 뽑아오는 쿼리로 작성해야된다. 

```java
List<Member> memberList = em.createQuery("select m from Member as m", Member.class).getResultList();
            for(Member m : memberList){
                System.out.println("findMember : " + m.getName());
            }
```



-----------

## DB설정

```xml
 <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
```

H2Dialect는 방언이라고 부르는데 이것은 OracleDialect와 같은 다르데이터베이스 방언으로 변경가능하다.
위의 옵션을 사용하여 쿼리를 날렸을때 Mysql의 Limit, Oracle의 rownum처럼 sql고유의 기능을 자동으로 변환처리 해준다.

----------------------

## 영속성 컨텍스트

기존에 포스팅을 한것들이 있는데 추가적으로 설명하고자한다.

**` em.persist(m)`** 을하면 영속상태로 변하게되는데 영속상태가 된다고해서  DB에 저장되는것이아니다. 
위에서 설명한것처럼 객체로 저장하기 때문에 엔티티객체를 쉽게 관리할 수 있는 1차캐시에 저장되고 쓰기지연SQL에 저장된게된다. 

그 후, **`transaction.commit()`** 을 하면 flush가 되면서 DB에 저장되게 된다.

<img width="671" alt="image" src="https://user-images.githubusercontent.com/43670838/158051678-f7872fb7-7d6f-407a-8e6f-d9f085f19473.png">

### Flush

영속성 컨텍스트의 변경내용을 데이터베이스에 반영

- 변경감지
- 수정된 Entity를 Lazy write SQL 저장소에 등록
- 쓰기 지연SQL 저장소의 쿼리를 DB에 전송(CUD)
- Flush하는 방법
  - EntiyManager.flush() 직접호출
  - transaction.commit() 을 하면 자동호출된다. 
  - JPQL 쿼리 실행하면서 자동으로 호출

```java
 findMember.setName("fkfkfkfkㅏㅏㅏㅏk");
//            em.persist(m1);
//            em.persist(m2);
            em.flush();
            System.out.println("!!!!!!!!!!!");
            tx.commit(); //commit시점에 DB저장됨
            System.out.println("-------------");
```

![image](https://user-images.githubusercontent.com/43670838/158187946-a10e4fc4-d005-4ea6-a7fb-29903bd04614.png)

위코드의 결과를 보면 commit전에 update쿼리가 실행된것을 볼 수 있다.


# PARRALLELISM & CONCURRENCY
### PARRALLELISM
- Chia 1 task thành nhiều sub-tasks chạy song song (cpu 1 core ko dùng đc )
- xử lý từng task riêng biệt
- cải thiện tốc độ tính toán

### CONCURRENCY
- handle multiple tasks  ( vd : trình duyệt chrome ...) (chưa chắc song song)
- switching
- nâng số lượng công việc hoàn thành 

### sự khác biệt giữa concurrency & parallelism 
https://www.geeksforgeeks.org/difference-between-concurrency-and-parallelism/
- nên hc cách kiểm soát nếu làm multithread với các nguồn ( memory, files, db ,..) (race condition)
    + https://stackoverflow.com/questions/34510/what-is-a-race-condition/34745#34745 
- Sử dụng đa luồng  (thread)
    + extend Thread
    + implements Runnable (thường dùng nếu muốn share thuộc tính giữa các luồng )
	+ sleep() , stop() -> doStop() : tự viết , chia các block synchronized bự thành các synchronized nhỏ để nhìu thread sử dụng hơn
- Đồng bộ đa luồng
    + synchronized (object hoặc phương thức) 
	+ immutableObject ( object bất biến)
	+ Semaphore (cho nhiều hơn 1 thread do dùng block)
link tham khảo: 
 + http://tutorials.jenkov.com/java-concurrency/index.html

### concurrency models (share state & separate state)
- parallel workers (vd: car factory): dễ hỉu, dễ thêm parallelization = thêm vào "workers"
    1. share state trở nên phức tạp
	+ một phần ko còn là parallel khi workers phải đợi phiên truy cập vào share data ( sử dụng non-blocking concurrency / persistent data structure)
	+ Stateless workers (việc reload (đọc) data nhiều lần) => chậm
	+ thứ tự thực hiện job ko xác định
+ Assembly line (=reactive systems = event driven systems:(Vert/x , akka,, node.js))( worker -> next worker -> ...) ( tương tự là: actor model và channel model) : các thread chạy ko share state, ko dùng non-blocking io, stateful worker nhanh hơn, thứ tự worker sắp xếp đc
    1. callback hell
	+ khó biết được workers đang  thực thi công việc ( code) nào
+ Functional Parallelism
	1. 
	
# DATABASE
 https://www.w3schools.in/mysql/ddl-dml-dcl/
 ![alt](https://github.com/Sammatha99/01SystemThinking/issues/2#issue-680724907)
### DDL (data  definition language)
- xác định cấu trức dữ liệu ( tạo, xóa, lược đồ  ... )
- 
### DML (data manipulation language)
- thao tác dữ liệu ( sử đổi, truy xuất, xóa, cập nhập ,... )

### DCL 
- điều khiển dữ liệu ( quyền truy cập, điều kiển dl của người dùng)

### TCL
- kiểm soát giao dịch

### SQL 
- cở sở dữ liệu quan hệ 
- dựa trên bảng
- mở rộng bằng cách tăng phần cứng, mở rộng theo chiều dọc
- vd : MySql, Oracle, Sqlite, Postgres, MS-SQL

### noSQL 
- cơ sở dữ liệu không liên quan (quan hệ) = cơ sở dữ liệu phân tán
- mở rộng bằng cách tăng số lượng máy chủ cơ sở dữ liệu, mở rộng theo chiều ngang
- big data , dữ liệu phân cấp 
- vd : MongoDB, BigTable, Redis, RavenDb, Cassandra, Hbase, Neo4j, CouchBd

### Redis (REmote DIctionary Server)
- loại noSQL 
- thường dùng cho lưu trữ bộ nhớ đệm, quản lý phiên, trò chuyện/nhắn tin









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
- Sử dụng đa luồng 
    + extend Thread
    + implements Runnable (thường dùng nếu muốn share thuộc tính giữa các luồng )
- Đồng bộ đa luồng
    + synchronized(object hoặc phương thức) 
link tham khảo: 
 + http://tutorials.jenkov.com/java-concurrency/index.html

### concurrency models (share state & separate state)
- parallel workers (vd: car factory): dễ hỉu, dễ thêm parallelization = thêm vào "workers"
    1. share state trở nên phức tạp
	2. một phần ko còn là parallel khi workers phải đợi phiên truy cập vào share data ( sử dụng non-blocking concurrency / persistent data structure)
	3. Stateless workers (việc reload (đọc) data nhiều lần) => chậm
	4. thứ tự thực hiện job ko xác định
+ Assembly line (=reactive systems = event driven systems:(Vert/x , akka,, node.js))( worker -> next worker -> ...) ( tương tự là: actor model và channel model) : các thread chạy ko share state, ko dùng non-blocking io, stateful worker nhanh hơn, thứ tự worker sắp xếp đc
    1. callback hell
	2. khó biết được workers đang  thực thi công việc ( code) nào
+ Functional Parallelism
	1. 
	

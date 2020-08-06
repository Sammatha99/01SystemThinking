# PARRALLELISM
- Chia 1 task thành nhiều sub-tasks chạy song song (cpu 1 core ko dùng đc )
- xử lý từng task riêng biệt
- cải thiện tốc độ tính toán, 

# CONCURRENCY
- handle multiple tasks  ( vd : trình duyệt chrome ...) (chưa chắc song song)
- switching 
- nâng số lượng công việc hoàn thành 

- sự khác biệt giữa concurrency & parallelism 
 + https://www.geeksforgeeks.org/difference-between-concurrency-and-parallelism/
- nên hc cách kiểm soát nếu làm multithread với các nguồn ( memory, files, db ,..) (race condition)
 + https://stackoverflow.com/questions/34510/what-is-a-race-condition/34745#34745 
 + 

- Sử dụng đa luồng 
 + extend Thread
 + implements Runnable (thường dùng nếu muốn share thuộc tính giữa các luồng )
- Đồng bộ đa luồng
 + synchronized(object hoặc phương thức) 
 + 
link tham khảo: 
 + http://tutorials.jenkov.com/java-concurrency/index.html


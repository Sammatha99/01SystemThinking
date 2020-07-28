# CTDL & GT
https://medium.com/databasss/on-disk-io-part-1-flavours-of-io-8e1ace1de017
### Btree (read)
https://viblo.asia/p/mot-it-ve-b-tree-XL6lAPPrZek
https://techtalk.vn/gioi-thieu-b-tree.html
- còn được gọi là cây mập, O(h)
- Btree bậc M, mỗi node ít nhất M/2 node con (-root), mỗi node M-1 khóa
- nó mập nên nó thấp, giảm số lượng truy cập hard 
- xóa keys ? 
- 

### LSMtree (long structured merge tree) (write))
http://www.benstopford.com/2015/02/14/log-structured-merge-trees/
compaction: https://www.datastax.com/blog/2011/10/leveled-compaction-apache-cassandra

![LSM](https://user-images.githubusercontent.com/38234300/88642046-2cc11f00-d0ea-11ea-9889-8d0ec1720cda.png)
- (luôn sorted trc khi ghi): mỗi file chứa 1 loạt các thay đổi trong 1 khoản time -> update mới đc đưa vào file mới khác -> đọc tất cả file -> các tập tin sẽ đc định merge(basic/levelled compaction) lại để số lượng file giảm xuống
- thường sử dụng bloom filters, paging index trong này

### Bloom Filters (false positive) > Hash table
https://lqm.now.sh/posts/bloom-filter-la-cai-veo-gi/
- xác định phẩn tử có trong tập ?
- cấu trúc dữ liệu xác xuất
- băm ( n lần) -> dãy bits 
- dùng : hệ thống cache, csdl, kiểm tra tồn tại dữ liệu,.... 

### HyperLogLog (chỉ đếm)
https://viblo.asia/p/analytic-cho-nguoi-nong-dan-bai-toan-dem-so-aWj53L0GK6m
https://odino.org/my-favorite-data-structure-hyperloglog/
- cấu trúc dữ liệu xác xuất (đếm phong cách xác xuất))
- dự đoán đếm số lượng lớn các yếu tốt riêng biệt (đếm số người dùng)
- hash (phù hợp ??) & bucket(chữ số đầu): dùng cái maximun -> tính trung bình ra kết quả
- càng nhiều bucket càng chính xác
# OOP
https://quangnle.com/15-cau-hoi-thuong-gap-ve-oop/
- đóng gói :private/public/protected        
- kế thừa : public
- trừ tượng : abstract class
- đa hình : phương thức giống tên, những có cách thực hiện khác nhau dựa theo từng class
    + over loading: cùng tên hàm, khác tham số truyền vào
    + over riding: cùng tên hàm, khác cách hoạt động

# SOLID (design pattern)
( dễ hiểu, dễ duy trì, linh hoạt mở rộng)
https://topdev.vn/blog/solid-la-gi/
- Single responsibility principle: 1 class - 1 trách nhiệm ( kế thừa - no AND)
- Open-Closed principle : open for extension but closed for modification (khó tiên đoán trc được)
- Liskov substitution principle: con thay thế cha nhưng không được gây ra lỗi (kế thừa đúng đắn)
- Interface segregation principle:1 interface lớn -> nhiều interface nhỏ với nhiều mục đích cụ thể
- Dependency inversion principle:module cấp cao không nên phụ thuộc các module cấp thấp. abs không nên phụ thuộc vào chi tiết (đa hình + kế thừa)


Câu hỏi ?
phần ctdl&gt:
- có thư viện nào thiết kế sẵn ko ?
- hyperloglog : khó hỉu cách tính kết quả xác xuất của nó ?
- 



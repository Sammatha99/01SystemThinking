# CTDL & GT
https://medium.com/databasss/on-disk-io-access-patterns-in-lsm-trees-2ba8dffc05f9
### Btree
https://viblo.asia/p/mot-it-ve-b-tree-XL6lAPPrZek
https://techtalk.vn/gioi-thieu-b-tree.html
- còn được gọi là cây mập, O(h)
- Btree bậc M, mỗi node ít nhất M/2 node con, mỗi node M-1 khóa
- nó mập nên nó thấp, giảm số lượng truy xuất xuống hard drive
- xóa keys ? 
- 
### LSMtree (long structured merge tree)
http://www.benstopford.com/2015/02/14/log-structured-merge-trees/
### Bloom Filters (false positive) > Hash table
https://lqm.now.sh/posts/bloom-filter-la-cai-veo-gi/
- xác định phẩn tử có trong tập ?
- cấu trúc dữ liệu xác xuất
- băm - dãy bits 
- dùng : hệ thống cache, csdl, kiểm tra tồn tại dữ liệu,.... 
### HyperLogLog
https://viblo.asia/p/analytic-cho-nguoi-nong-dan-bai-toan-dem-so-aWj53L0GK6m
https://ichi.pro/vi/post/2006913875381
- cấu trúc dữ liệu xác xuất
- dự đoán đếm số lượng lớn các yếu tốt riêng biệt (đếm số người dùng)
- 
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
- Single responsibility principle: 1 class - 1 trách nhiệm ( kế thừa)
- Open-Closed principle : open for extension but closed for modification (kế thừa )
- Liskov substitution principle: con thay thế cha nhưng không được gây ra lỗi
- Interface segregation principle:1 interface lớn -> nhiều interface nhỏ với nhiều mục đích cụ thể
- Dependency inversion principle:module cấp cao không nên phụ thuộc các module cấp thấp. abs không nên phụ thuộc vào chi tiết (đa hình + kế thừa)


# **TÌM HIỂU VỀ GIT**
 
*tên: Ngô Nha Trang (trangnn)
ngày: 10-07-2020*
 
## Git là gì
- Là một hệ thống quản lý phiên bản phân tán (Distributed version control system - DVCS) 
 
## Tại sao dùng git
 
- Hỗ trợ tốt cho teamwwork, những việc như phân chia task , tổng hợp code trở nên dễ dàng hơn
- Quản lý code và lịch sử thay đổi, có thể dễ dàng lẫy lại các version cũ nếu xảy ra sự cố ở phiên bản mới
 
## Git lưu data như thế nào ?
 
- trong Git có một cơ chế đặc biệt là: Snapshot. Đây là cơ chế lưu trữ phiên bản của git: sau mõi lần thực hiện trạng thái commit sẽ tạo ra một "ảnh chụp" lưu lại nội dung tất cả các tập tin, thư mục taị thời điểm đó rồi tạo tham chiếu tới snapshot đó. Trường hợp tập tin không có thay đổi, git không lưu trữ tập tin đó lại mà chỉ tạo liên kết với tập tin gốc đã tồn tại trước đó 
 
- Trong git repository là nơi lưu trữ, quản lý tất cả những thông tin cần thiết (thư mục, tập tin, ảnh, video,...) cũng như các sửa đổi và lịch sử toàn bộ dự án. các máy khách sao chép toàn bộ kho chứa (repository). nên khi xảy ra sự cố với mảy chủ, ta vẫn có những bản sao đầy đủ của dự án từ các máy khách khác
 
## Khái niệm cần biết
 
* **Branch**
-Branch được dùng để phân nhánh và ghi lại luồng của lịch sử. Branch đã phân nhánh sẽ không ảnh hưởng đến branch khác nên có thể tiến hành nhiều thay đổi đồng thời trong cùng 1 repository.
-Giúp tách riêng các tính năng của dự án, thửu nghiệm các tính năng mới hay cũng có thể dùng nhánh dể khắc phục, hoàn chỉnh lỗi nào đó của dự án 
-Các câu lệnh thông dụng:
    + `git checkout -b <tên nhánh>`: tạo nhánh mới và tự động chuyển qua nhánh đó 
    + `git checkout <tên nhánh>`: quay lại nhánh đó 
    + `git branch -d <tên nhánh>`: xóa nhánh đó
    + `git push origin --delete <ten nhanh> `: xoa nhanh do tren may remote
    + `git branch -m <tên cũ> <tên mới>`: đổi tên nhánh cũ thành tên mới
    + `git branch -m <tên mới>`: đổi tên nhánh đang chạy thành tên mới
    + `git push origin <tên branch>`: push branch lên máy chủ
    + `git push <tên remote> <tên branch máy local>:<tên branch máy chủ> `: push branch trên máy local lên branch máy chủ, trường hợp 2 branch này khác tên nhau
* **Commit**
-Là một hành động để Git lưu lại một bản chụp (snapshot) của các sự thay đổi trong thư mục làm việc, và các tập tin và thư mục được thay đổi đã phải nằm trong Staging Area
-Mỗi lần commit thì bản snapshot đó sẽ được lưu lại lịch sử chỉnh sửa của mã nguồn kèm theo tên và địa chỉ email của người commit 
-Nhờ commit sẽ dễ dàng khôi phục lại các thay đổi trước đó, lấy lại version cũ đã được lưu trong lịch sử commit
-Các câu lệnh thông dụng: 
(***Chủ ý !***: trước khi commit sẽ cần đưa tập tin đó vào staging area, phần tới sẽ nói rõ)
    + `git commit -m "lời nhắn ghi chú gì đấy" `: commit kèm ghi chú
    + `git commit -a -m "lời nhắn ghi chú gì đấy" `: commit bỏ qua luôn bước stage 
    + `git log`: coi lịch sử commit , chi tiết hơn dùng `git log -p`
    + `git commit --amend  -m "lời nhắn ghi chú" `: xóa bỏ một commit trước và undo để commit lại  
* **Tag**
-Là một cái tên dùng để đánh dấu một điểm nào đó trong lịch sử quá trình commit khi cho rằng điểm đó là quan trọng, cần chú ý
-khi cần xem bạn chỉ cần sử dụng lệnh` git show <tên tag>` là đã có thông tin rất rõ ràng, ngoài ra nó còn giúp bạn dễ dàng diff (đối chiếu) sau này khi không cần nhớ checksum của mỗi commit mà chỉ cần nhớ tag, cũng như có thể tạo thêm branch từ tag để bạn thuận tiện hơn trong việc phân nhánh
-Các câu lệnh thông dụng:
    + `git tag `: show hết tất cả tag hiện có
    + `git tag -a <tên tag> <tên checksum lần commit cũ nếu muốn> -m "lời nhắn tag"`: gắn tag annotated cho commit cũ 
    + `git tag <tên tag> <tên checksum lần commit cũ nếu muốn>`: gắn lightweight cho commit cũ
    + `git push --tags`: push tag lên repo
    + `git tag -am "ghi chú về tag" <tên tag>` : gắn annotated tag cho commit hiện đang trỏ tới 
* **remote**
-Repository nằm ngoài, có thể thao tác thông qua local repository. Có thể sử dụng trong trường hợp nhiều người thao tác , public trên internet 
-Các câu lệnh thông dụng :
    + `git remote rename <tên cũ> <tên mới> `: sđổi tên remote 
    + `git remote add <tên tự đặt> <URL>`:  add thêm một remote nữa 
 
## Một số câu lệnh khác 
   - `git pull` : cập nhập repo mới nhất từ máy chủ 
   - `git merge <tên nhánh >` : trộn nhánh khác vào nhánh đang hoạt động 
   - `git add <tên tập tin>` : sử lý xung đột khi trộn, thì phải add lại tập tin 
   - `git diff <nhánh nguồn> <nhánh mục tiêu>` :  trước khi trộn co thế coi trước 
   - `git rm -f "tên file"` : xóa file ra khỏi cả phần cứng 
   - `git reset HEAD <tên file>` : đưa tập tin ra khỏi staging area, để ko bị commit theo
   - `git rebase -i HEAD~n` : n là số lần commit gần nhất, chỉnh sửa gọp commit
   - `git fetch origin` : chỉ muốn coi nội dung chứu chưa muốn merge, một phát kéo hết cả origin vè, dùng `git log --oneline origin/<branch name> để coi sự khác biệt 
   - `git push --force-with-lease` : ? tốt hơn -f , nhưng vẫn chưa cover hết đc risk (https://viblo.asia/p/meo-nho-de-tranh-lam-mat-code-khi-su-dung-git-OeVKBxgQlkW)
   - `git bisect` : ??? 
 
   

# **KIẾN TRÚC WEB**
DNs -> load balancer -> web app serves -> database -> (caching service) -> job quêu -> job service -> full text search service -> service -> data firehouse -> data warehouse -> cloud storage -> load balancer -> CDN
## DNS – domain name system
-Ip adress <-> domain name
## Loa balancer
-Nên mở rộng theo chiều ngang (tăng số máy)
-có nhiểu app servers giống nhau, xử lý yêu cầu theo 1 cách để cân bằng tải
## Web application servers 
-cái lõi, liên lạc ở trung gian
## Database servers
-SQL(hầu hết mở chiều dọc) và noSQL( hợp với lượng dữ liệu lớn- có thể mở theo chiều ngang)
## Caching service
-Cung cấp việc lưu và tra cứu thông tin gần với thời gian O (1)
## Job queue & servers
-như cái tên, xử lý các công việc hậu trường bất đồng bộ, và servers phục vũ giải quyết việc đó
## Full-text search service
-nhập vào text input , trả về kết quả liên quan nhất 
## Services
-”services” chạy như các ứng dụng riêng biệt, app and các “services” khác tương tác với nó
## Data 
-Gửi data đến “firehose” (cung cấp giao diện truyền phát, xử lý dữ liệu) -> lưu vào cloud storage -> load vào datawarehouse(phân tích)
## Cloud storage
-Lưu , truy cập và share data dễ dãng
## CND (content delivery network)
- phân phối nội dung trên nhiều máy chủ “Edge” trên toàn thế giới để người dùng cuối tải xuống các tài sản từ các máy chủ “Edge” thay vì máy chủ gốc

# GIẢI QUYẾT ĐỤNG ĐỘ TRONG GIT
Merge 

Rebase 

Branch 

quay lại commit cũ 

https://codewithhugo.com/fix-git-failed-to-push-updates-were-rejected/ 

https://stackoverflow.com/questions/18328800/github-updates-were-rejected-because-the-remote-contains-work-that-you-do-not-h 

https://backlog.com/git-tutorial/vn/stepup/stepup2_8.html 

https://xuanthulab.net/lam-viec-voi-nhanh-branch-tao-nhanh-gop-nhanh-trong-git.html 

 

# SOFTWARE ARCHITECTURAL PATTERNS 

# 1. Layered pattern 

-layer dưới cung cấp service cho layer cao hơn 

-UI -> service->domain->persisitence 

-layer1-layer2-…-layer.n 

? Tài sao thường dùng cho các web thương mại điện tử ? 

# 2. Client-server pattern 

-a server – clients 

# 3. Master – slave pattern 

-master <-> slaves 

# 4. Pipe-filter pattern 

-gọt mài dũa luồng data 

-luồng data đc proccess đi qua pipes, dùng để buffering hay đồng bộ hóa nó 

# 5. borken pattern 

-hệ thống phân tán 

-clients-broker–decouples components 

-broker như kẻ chỉ đường đi phù hợp với request của clients 

# 6. Peer-to-peer pattern 

-(clients-server) <-> (clients-server) 

-nhanh hơn nếu có nhiều người dùng 

# 7. Event-bus pattern 

-hiểu nôm na là ai subcribe cái gì thì sẽ đc cái gì gửi message lại khi có event 

# 8. Model-view-controller pattern 

-functionality & data – displays(view) - handle the input 

-giúp tái sử dụng mã hiệu quả 

# 9. Blackboard pattern 

??? Về đọc lại 

# 10.Interpreter pattern 

??? Về đọc lại 





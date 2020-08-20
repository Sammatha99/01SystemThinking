# BÀI 1 : GIT FLOW
 
## feature
- start
git checkout -b myfeature/<tên feature> <develop>
- publish
git push origin myfeature/<tên feature>
- pull
git pull origin myfeature/<tên feature>
- finish
git checkout <develop>
git merge --no-ff myfeature/<tên feature>
(commit & push develop)
git push origin --delete myfeature/<tên feature>
 
## release
- start
-git checkout -b version/<tên ver>
-./bump-version.sh <tên version>
- publish
-git commit -a -m "bump <tên ver>"
-git push origin version/<tên ver>
- finish
-git checkout master
-git merge --no-ff version/<tên ver>
(commit & push master, làm tương tự với develop)
-git push origin --delete version/<tên ver>
## hotfix
- start
-git checkout -b hotfix/<tên fix> master
-./bump-version.sh <tên fix> 
-git commit -a -m "bump <tên fix>"
(tiền hành các quá trình code fix)
-git commit -a -m "fix ...."
- finish
-git checkout master 
-git merge --no-ff hotfix/<tên fix>
-git tag -a <tên fix>
-git push --tags
(commit và push master)
(làm tương tự với develop nhưng không cần tag)
-git branch -d hotfix/<tên fix>
 
# BÀI 2 : SHELL
các bước đầu tiên
- chuyển vào thư mục chứa file nguồn: cd....
- tạo file đáp án: touch trang.txt
- lưu nd web vào file
$ curl www.google.com > <tên file>
- đếm số dòng trong file: 
$ wc -l temp.txt 
- đếm số từ trong file:
$ wc -w temp.txt
- đếm số từ cụ thể xuất hiện trong file:
$ grep -o "\b[[:alpha:]]\b" temp.txt | wc -c 
- thay đổi 1 từ trong file bằng từ khác và lưu vào file mới
$ Sed ‘s/(từ cần thay)/(từ mới)/1’ <file gốc> >  <file mới>
 
# VÀI LỆNH CƠ BẢN  TRONG SHELL:
- mkdir <tên folder> 
- touch <tên file>
- mv file /thư mục
- mv file <tên file mới> : rename
- cp file1 file2 : copy file1 -> file 2
- rm <file>  
- rm -r <folder>
- 
## regex 
- grep "^từ" file : từ đó đầu dòng
- grep "từ$" file : từ đó cuối dòng
- grep "..từ" file : 
- grep "t[ua]b" file : kiếm từ tub và tab
- [^ ký từ] : ngoại trừ các ký tự
- []* : cho phép lặp lại
- /b : các cụm dính nhau, tìm từ đó ở vtri (cuối -đầu)
- /B : các cụm dính nhau, tìm từ đó ở NGOẠI vtri (cuối -đầu)
- sed : thay the / xoa / in
- awk : 
- curl : url
- wc : dem
- grep : tim tu

https://quantrimang.com/regular-expression-trong-unix-linux-156644
https://www.regular-expressions.info/wordboundaries.html

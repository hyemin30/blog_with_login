swagger 적용

| 기능 | API URL | Method | Request Header | Request | Response | Response Header |
| --- | --- | --- | --- | --- | --- | --- |
| 회원가입 | /register | POST |  | {
  "adminToken": "string",
  "password": "string",
  "role": "USER",
  "username": "string"
} | {
"msg": "회원가입 성공",
"statusCode": 200
} |  |
| 로그인 | /login | POST |  | {
  "adminToken": "string",
  "password": "string",
  "role": "USER",
  "username": "string"
} | {
"msg": "로그인 성공",
"statusCode": 200
} | Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoeWVtaW4xIiwiZXhwIjoxNjcyNDgwNTA3LCJpYXQiOjE2NzI0NzY5MDd9.FduPR16joOUAWey5L-xXVMDyZ4MF-E0E_PG8SmDc4gA |
| 전체 글 조회 | /postings | GET |  |  | {
"username": "hyemin1",
"title": "제목이다!!!",
"content": "내용이다",
"id": 3,
"createdAt": “localDateTime”
"modifiedAt":  “localDateTime”
},
{
"id": 4,
"content": "string",
"postingMember": "hyemin1",
"commentMember": "hyemin2"
} |  |
| 게시글 1개 조회
(댓글포함) | /postings/{id} | GET |  | {
  “id”: 1
} | {
"username": "hyemin1",
"title": "제목이다!!!",
"content": "내용이다",
"id": 3,
"createdAt": “localDateTime”
"modifiedAt":  “localDateTime”
},
{
"id": 4,
"content": "string",
"postingMember": "hyemin1",
"commentMember": "hyemin2"
} |  |
| 게시글 등록 | /postings | POST | Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoeWVtaW4xIiwiZXhwIjoxNjcyNDgwNTA3LCJpYXQiOjE2NzI0NzY5MDd9.FduPR16joOUAWey5L-xXVMDyZ4MF-E0E_PG8SmDc4gA | {
  "content": "string",
  "id": 0,
  "title": "string",
  "username": "string"
} | {
"username": "hyemin1",
"title": "제목이다!!!",
"content": "내용이다",
"id": 3,
"createdAt": “localDateTime”
"modifiedAt":  “localDateTime”
} |  |
| 게시글 수정 | /postings/{id} | PUT | Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoeWVtaW4xIiwiZXhwIjoxNjcyNDgwNTA3LCJpYXQiOjE2NzI0NzY5MDd9.FduPR16joOUAWey5L-xXVMDyZ4MF-E0E_PG8SmDc4gA | {
  "content": "string",
  "id": 0,
  "title": "string",
  "username": "string"
} | {
"username": "hyemin1",
"title": "제목이다!!!",
"content": "내용이다",
"id": 3,
"createdAt": “localDateTime”
"modifiedAt":  “localDateTime”
} |  |
| 게시글 삭제 | /postings/{id} | DELETE | Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoeWVtaW4xIiwiZXhwIjoxNjcyNDgwNTA3LCJpYXQiOjE2NzI0NzY5MDd9.FduPR16joOUAWey5L-xXVMDyZ4MF-E0E_PG8SmDc4gA | {
  “id”: 1
} | {
”msg": "삭제성공"
} |  |
| 댓글작성 | /comments/{id}  | POST | Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoeWVtaW4xIiwiZXhwIjoxNjcyNDgwNTA3LCJpYXQiOjE2NzI0NzY5MDd9.FduPR16joOUAWey5L-xXVMDyZ4MF-E0E_PG8SmDc4gA | {
  “id”: 1  
  "content": "string",
} | {
"id": 6,
"content": "ecomments@",
"postingMember": "hyemin1",
"commentMember": "hyemin2"
} |  |
| 댓글수정 | /comments/{id} | PUT | Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoeWVtaW4xIiwiZXhwIjoxNjcyNDgwNTA3LCJpYXQiOjE2NzI0NzY5MDd9.FduPR16joOUAWey5L-xXVMDyZ4MF-E0E_PG8SmDc4gA | {
  “id”: 1  
  "content": "string",
} | "id": 6,
"content": "comment",
"postingMember": "hyemin1",
"commentMember": "hyemin2” |  |
| 댓글삭제 | /comments/{id} | DELETE | Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoeWVtaW4xIiwiZXhwIjoxNjcyNDgwNTA3LCJpYXQiOjE2NzI0NzY5MDd9.FduPR16joOUAWey5L-xXVMDyZ4MF-E0E_PG8SmDc4gA | {
  “id”: 1
} | {
”msg": "삭제성공"
} |  |

![image](https://user-images.githubusercontent.com/116478121/210031217-a5c41e9e-59fc-4e2e-a441-a7c45cdad8fc.png)

# 주석

# 변수와 기본 타입
team_name = '오지라퍼스'  # str (문자열)
price = 123_456         # int (정수) 숫자가 길 때 언더바로 가독성을 높일 수 있음
is_activate = True      # bool (논리형)
user_data = None        # 값이 없음을 나타내는 NoneType

print(team_name)
# f-string : 문자열 앞에 f를 붙이고, 중괄호 {}안에 변수명을 넣으면 그 값이 문자열에 자동 삽입.
print(f"팀 이름 : {team_name}")
print(f"가격 : {price}")

# List : 순서가 있는 가변 배열
scores = [88,90, 67]
print(f"점수 리스트 : {scores}, 첫 번째 점수: {scores[0]}")

# 리스트에 값 추가
scores.append(100)      # 맨 뒤에 추가
scores.insert(2, 75)    # 2번 인덱스에 삽입
print(f"추가 후 점수 {scores}")

last_score = scores.pop()   # 인덱스를 주지 않으면 맨 뒤 요소를 꺼내고 제거
print(f"꺼낸 점수: {last_score}, 수정된 점수: {scores}")

# Dict : Key:Value 쌍의 가변 맵
user = {'name': '홍길동', 'age': 30}
print(f"사용자 정보: {user}, 이름: {user['name']}") # 사용자 정보: {'name': '홍길동', 'age': 30}, 이름: 홍길동

# 키가 없으면 새로 추가되고, 있으면 기존 값을 덮어씀
user['job'] = '의적'
user['age'] = 33
print(f"수정된 정보:{user}") # 수정된 정보:{'name': '홍길동', 'age': 33, 'job': '의적'}

# 존재하지 않는 키로 값을 조회하면 keyError가 발생하며 프로그램이 죽음
# print(user['email'])

# 안전하게 값 조회하기 : .get(키, 기본값) -> Key가 없어도 에러 대신 기본값 반환
email = user.get('email', '정보 없음')
print(f"사용자 이메일: {email}") # 사용자 이메일: 정보 없음

# List와 Dict 조합
users = [
    {'name': '홍길동', 'age': 30},
    {'name': '신사임당', 'age': 45, 'job': 'Artist'}
]
print(f"첫 번째 사용자 이름: {users[0]['name']}")

# 얕은 복사와 깊은 복사

prices = [10000, 20000]

# [얕은 복사] : 주소값만 복사
# prices_shallow_copy = prices
# prices_shallow_copy[0] = 9999
# print(f"[얕은 복사] 원본 : {prices}")

# [깊은 복사] .copy()를 사용. 값 자체를 복사한 새 객체 생성
new_prices = prices.copy()
new_prices[0] = 9999
print(f"깊은 복사 원본 : {prices}, 복사본: {new_prices}") # 원본은 그대로 유지

# .copy()도 내부에 리스트가 또 들어있으면 완벽하게 복사되지는 않는 '얕은 복사'의 일종이지만,
# 우리가 다룰 1차원 데이터에서는 '깊은 복사'처럼 동작한다
# ( 완전한 깊은 복사는 import copy 후 copy.deepcopy()를 사용하면 된다. )
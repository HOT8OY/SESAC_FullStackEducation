# 문자열 핵심 기능
# 슬라이싱 : 문자열의 일부를 잘라낸다. [시작인덱스:끝인덱스]
# 끝 인덱스는 포함되지 않는다.
txt = "helloWorld"
print(f"슬라이싱[0:5]: {txt[:5]}")  # 시작을 생략하면 처음부터
print(f"슬라이싱[5:0]: {txt[5:]}") # 끝을 생략하면 끝까지
print(txt[:])       # 처음부터 끝까지
print(txt[::2])     # 세번째 인자는 STEP. n번 건너뛰어서 가져온다
print(txt[::-1])    # step을 -1로 주면 뒤에서부터 가져온다.

# .split() : 긴 텍스트를 문장 단위로 나누거나, CSV 데이터를 콤마(,)기준으로 나눌 때 많이 사용
# 문자열을 특정 기준으로 나눠 [리스트]로 만든다.
csv_data = "홍길동,20,서울"
user_list = csv_data.split(',')
print(f"split 결과 : {user_list}, 이름: {user_list[0]}") # split 결과 : ['홍길동', '20', '서울'], 이름: 홍길동

# 제어문 : if, for
score = 85

# 파이썬은 중괄호 대신 들여쓰기로 코드 블록을 구분한다
# if문이나 for문 선언 끝에 콜론(:)을 찍고, 그 다음줄에 들여쓰기 된 부분 전체가 하나의 코드 블럭으로 인식된다.

# if 조건문:
#   들여쓰기 한 다음 블록에서 조건에 맞을 때 실행할 블록을 적음
# else:
#   들여쓰기 한 다음 블록에서 조건에 맞을 때 실행할 블록을 적음
if score >= 90:
    grade = 'A'
elif score >= 80:   # else-if = elif
    grade = 'B'
else:
    grade = 'F'
print(f"점수 : {score}, 등급: {grade}")
# for 단일값 in 순회할 값들
foods = ['햄버거', '피자', '보쌈']
for food in foods:
    print(f"오늘의 메뉴: {food}")

user_info = {'name': '판다', 'age': '5'}
# .keys() : key 값을 가져온다.
# .values() : value 값을 가져온다.
# .items() : key와 value를 한 쌍으로 가져온다.
for key, value in user_info.items():
    print(f"- {key}: {value}") # - name: 판다 - age: 5
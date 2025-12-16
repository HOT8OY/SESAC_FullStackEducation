# 1. 기본 함수와 Type Hint
def create_greeting(name: str, age: int = 20) -> str: # str, int 는 Type Hint | = 20은 기본값 | -> str은 반환값의 Type Hint
    """이 함수는 이름과 나이를 받아 인사말을 생성합니다."""  # docstring: 함수 설명문
    return f"안녕하세요, {age}세 {name}님."

print(create_greeting("홍길동", 30))
# 키워드 인자
print(create_greeting(age=45, name="신사임당")) # 키워드 인자는 순서가 바뀌어도 된다.
print(create_greeting("유관순")) # 기본값 작동 확인
print(create_greeting(123, "스무살")) # 파이썬에선 타입이 강제되지 않는다 | 안녕하세요, 스무살세 123님.

# 2. 가변인자(*args)와 키워드 가변 인자(**kwargs)
# *args는 몇개가 들어올 줄 모르는 인자들을 튜플로 받는다.
# 튜플 : '값을 바꿀 수 없는 리스트'
# **kwargs는 키워드 인자들을 딕셔너리로 받는다.

def call_llm_api(prompt: str, *args, **kwargs):
    """가상의 LLM API 호출 함수"""
    print(f"전송할 프롬프트: '{prompt}'")
    if args:
        print(f"부가 옵션(tuple: {args})")
    if kwargs:
        print(f"상세 설정(dict): {kwargs}")

call_llm_api(
    "오늘의 주요 뉴스 요약해줘",
    "3줄 요약",     # -> 가변 인자(args)에 들어감
    model="gpt-4o", # -> 키워드 가변 인자(kargs)에 들어감
    temperature=0.7 # -> 키워드 가변 인자(kargs)에 들어감
)
import streamlit as st

# streamlit : 파이썬 환경에서 간단한 웹 화면을 구현해줌.

st.title("Session State")

st.subheader("일반 변수 Count") # 일반 변수로 만든 변수는 매번 초기화 되기 때문에 count가 1을 넘기지 못한다.
count = 0

# if st.button(): : 해당 버튼을 누르면 다음 행위가 작동되도록 함.
if st.button("기본 버튼"):
    count += 1

st.write(f"Count: {count}")

# ===================================================== #
# session_state : 값을 임시로 보관하기 위한 창고

# 초기화 : 값이 없을 때만 0으로 설정
st.subheader("st.session_state Count")
if 'count' not in st.session_state:
    st.session_state['count'] = 0

if st.button('Session State 버튼'):
    st.session_state['count'] += 1

st.write(f"Count: {st.session_state['count']}")
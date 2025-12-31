import streamlit as st
import os
from dotenv import load_dotenv
from openai import OpenAI

load_dotenv()

client = OpenAI()

st.set_page_config(page_title="Fine-Tuning Playground", page_icon="🎮", layout="wide")

st.title("Fine-Tuning Playground")
st.markdown("내가 만든 **커스텀 모델(fine-tuned)**과 **기본 모델(Base)**의 말투를 비교해보자!!")

# 사이드바 : 모델 설정
with st.sidebar:
    st.header("모델 설정")

    # Base Model
    base_model = st.text_input("Base Model ID", value="gpt-4o-mini")

    # Fine-tuned Model
    ft_model = st.text_input("Fine-tuned Model ID", help="학습 완료 후 받은 모델 ID를 입력하세요.(ft:gpt-3.5-turbo-0125:academy:sunjoonkim:CsfACm0H)")

    system_prompt = st.text_area("시스템 프롬프트", value="너는 트렌디하고 친절한 인스타 마케터 봇이야.")

# 채팅 기록 세션 초기화
if "messages" not in st.session_state:
    st.session_state.messages = []  # messages[]의 형태는 {"role":"user","content":"안녕!"} 같은 형식

# 채팅 화면 표시
for message in st.session_state.messages:
    with st.chat_message(message["role"]):  # st.chat_message는 말풍선 형식으로 출력해줌
        st.markdown(message["content"])

# 사용자 입력 처리
# :=(월러스 연산자) : 입력값이 None이 아니면 if문 실행
if prompt := st.chat_input("질문을 입력하세요!!(예: 립스틱 추천해줘!!)"):

    # 사용자 질문을 화면에 표시
    st.session_state.messages.append({"role":"user","content":prompt})
    with st.chat_message("user"):
        st.markdown(prompt)

    col1, col2 = st.columns(2)

    with col1:
        st.subheader("Base Model")
        with st.spinner("생성 중..."):
            try:
                response_base = client.chat.completions.create(
                    model=base_model,
                    messages=[
                        {"role":"system","content": system_prompt},
                        {"role":"user","content": prompt}
                    ],
                    temperature=0.8
                )
                base_reply = response_base.choices[0].message.content
                st.info(base_reply)
            except Exception as e:
                st.error(f"Error: {e}")

    with col2:
        st.subheader("Fine-tuned Model")
        with st.spinner("생성 중..."):
            try:
                response_ft = client.chat.completions.create(
                    model=ft_model,
                    messages=[
                        {"role":"system","content": system_prompt},
                        {"role":"user","content": prompt}
                    ],
                    temperature=0.8
                )
                ft_reply = response_ft.choices[0].message.content
                st.success(ft_reply)

                st.session_state.messages.append({"role":"assistant","content":ft_reply})
            except Exception as e:
                st.error(f"Error: {e}")
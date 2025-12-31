import streamlit as st
from PIL import Image   # 이미지를 다룰 때 사용
import requests         # http 요청을 보낼 때 사용
from io import BytesIO   # 컴퓨터 메모리상에 가상의 파일을 만듦. requests로 0과 1로 된 바이트를 받아오는 이것을 변환해줌.
from ai_sommelier_rag import ai_sommelier_rag

# 화면에 표시될 웹페이지 제목
st.title("🍷AI Wine Sommelier🍾")
st.write("🍖음식 이미지 URL을 입력하면, 어울리는 🍷와인을 추천해드립니다.")

# 사용자 입력 폼
with st.form(key='img_form'):
    img_url = st.text_input("이미지 URL 입력:", placeholder="예 : https://example.com/food.jpg")
    submit_button = st.form_submit_button(label="제출(Submit)")

# 결과 처리 및 출력
if submit_button:
    if img_url:
        try:
            # URL에서 이미지 다운로드 및 화면 표시
            response = requests.get(img_url)    # img_url로 get 요청을 보내어 다운로드 받음
            response.raise_for_status()    # URL 에러 체크
            image = Image.open(BytesIO(response.content)) # 받아온 파일을 열어서 내부의 content를 감싸줌

            st.image(image) # 이미지 출력

            # AI 메세지 출력
            st.subheader("AI 와인 추천:")

            with st.spinner("와인 검색중..."): # st.spinner()와인이 검색되는 동안 로딩창을 보여줌

                # 우리가 만든 함수 호출
                response_stream = ai_sommelier_rag([img_url])

                # langchain의 stream 반환값과 호환된다
                st.write_stream(response_stream)    # 타자기처럼 글자가 한 글자씩 써지는 효과

        except Exception as e:
            st.error(f"이미지를 로드하는 중 오류가 발생했습니다 : {e}")
    else: # img_url이 없는 경우
        st.warning("이미지 URL을 입력해주세요.")
from fastapi import FastAPI

app = FastAPI()


@app.get("/")   # Spring의 GetMapping과 완전히 동일한 기능
async def root():
    return {"message": "Hello World"}   # dictionary 형식을 자동으로 json 형식으로 변환하여 클라이언트한테 응답을 한다.


@app.get("/hello/{name}")       # @PathVariable String name
async def say_hello(name: str): # (name: str) 같이 타입을 지정해두면 문서화 페이지에서 어떤 타입을 넣어줄지 보여준다.
    return {"message": f"Hello {name}"}
from fastapi import FastAPI, APIRouter
from pydantic import BaseModel

# pydantic의 BaseModel은 JAVA에서의 DTO 개념이라고 할 수 있다.

router = APIRouter(prefix='/request_body', tags=['request_body'])

class Item(BaseModel):  # DTO.
    name: str                       # 필수값
    description: str | None = None  # 기본값은 None. 선택값이라서 str일수도 None일수도 있음.
    price: float
    tax: float | None = None

# 요청본문
@router.post("/items/")
async def create_item(item: Item):  # 함수의 매개변수 (item: Item)에서 item은 Item을 상속받은 클래스 -> 알아서 RequestBody로 판단함.
    return item                     # 알어서 JSON으로 변환 후 반환함.


# 경로매개변수(item_id)/쿼리매개변수(item)/요청본문(q)을 섞어 사용해도 잘 구분한다.
# .put()은 @PutMapping에 해당함
@router.put("/items/{item_id}")
async def update_item(item_id: int, item: Item, q: str | None = None):
    result = {"item_id": item_id, **item.model_dump()}
    if q:
        result.update({"q": q})
    return result

# post, put은 docs로 확인 테스트 가능함.
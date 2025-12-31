from fastapi import APIRouter

router = APIRouter(prefix='/query_params', tags=['query_params'])

# 쿼리매개변수
# - 경로매개변수가 아닌 매개변수는 쿼리매개변수로 사용가능하다.
# - 자료형, 기본값 지정이 가능하다.
# - 기본값을 None으로 지정하지 않으면 필수값이다.
# - JAVA의 @RequestParam과 비슷한 기능
fake_items_db = [{"item_name": "Foo"}, {"item_name": "Bar"}, {"item_name": "Baz"}]

# @RequestParam같은걸 사용하지 않아도, 함수 매개변수에서 경로에 정의되지 않은 것들은 쿼리 매개변수로 자동인식 된다.
@router.get("/items/")              # '/items/?skip=0&limit=10'
async def read_item(skip: int = 0, limit: int = 10):
    return fake_items_db[skip : skip + limit]


@router.get("/products/{product_id}")   # product_id는 경로상에 있으므로 경로매개변수(필수값)
async def read_product(product_id: str, q: str | int = None):   # q는 경로에 없으므로 쿼리매개변수(옵셔널)
    if q:
        return {"product_id": product_id, "q": q}   # 만약 q값을 받았을 경우
    return {"product_id": product_id}               # q값을 받지 않았을 경우
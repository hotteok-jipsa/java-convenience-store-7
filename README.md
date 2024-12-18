# java-convenience-store-precourse

- [x] 행사 목록 파일을 통해 행사 목록을 불러온다.


- [x] 상품 목록 파일을 통해 상품 목록을 불러온다.


- [x] 환영 인사를 출력한다.

```css
안녕하세요. W편의점입니다.
현재 보유하고 있는 상품입니다.
``` 

- [x] 상품 목록을 출력한다.


- [x] 만약 상품 재고가 0개라면 `재고 없음`을 출력한다.


- [x] 구매 안내 문구를 출력한다.
    - `구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])`


- [x] 구매할 상품과 수량을 입력받는다.
    - [x] 사용자가 잘못된 값을 입력할 경우 예외를 발생시킨다.
        - [x] 상품명, 수량은 하이픈(-)으로, 개별 상품은 대괄호([])로 묶어 쉼표(,)로 구분한다.
        - [x] 수량이 숫자타입이 아니라면 예외를 발생시킨다.
        - [x] 중복된 상품을 구매할 경우 예외를 발생시킨다.
    - [x] 상품이 존재하지 않을 경우 예외를 발생시킨다.
    - [x] 상품의 재고가 부족할 경우 예외를 발생시킨다.
        - [x] 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.


- [x] 구매할 상품들을 결제한다.


- [x] 상품이 프로모션 기간인지 확인한다.


- [ ] 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 혜택 안내 메시지를 출력한다.
    - `현재 {상품명}은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)`


- [ ] 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 추가 여부를 입력받는다.
    - `Y` `N`
    - [ ] 사용자가 잘못된 값을 입력할 경우 예외를 발생시킨다.
        - [ ] 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.


- [ ] 프로모션 재고가 부족하여 일부 수량을 혜택 없이 결제하는 경우 일부 수량 정가로 결제 안내 메시지를 출력한다.
    - `현재 {상품명} {수량}개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)`


- [ ] 프로모션 재고가 부족하여 일부 수량을 혜택 없이 결제하는 경우 일부 수량 정가로 결제 여부를 입력받는다.
    - `Y` `N`
    - [ ] 사용자가 잘못된 값을 입력할 경우 예외를 발생시킨다.
        - [ ] 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.


- [ ] 멤버십 할인 적용 안내 문구를 출력한다.
    - `멤버십 할인을 받으시겠습니까? (Y/N)`


- [ ] 멤버십 할인 적용 여부를 입력 받는다.
    - `Y` `N`
    - [ ] 사용자가 잘못된 값을 입력할 경우 예외를 발생시킨다.
        - [ ] 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.


- [ ] 구매 상품 내역, 증정 상품 내역, 금액 정보를 출력한다.


- [ ] 추가 구매 안내 문구를 출력한다.
    - `감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)`


- [ ] 추가 구매 여부를 입력 받는다.
    - `Y` `N`
    - [ ] 사용자가 잘못된 값을 입력할 경우 예외를 발생시킨다.
        - [ ] 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

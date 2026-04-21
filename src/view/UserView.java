package view;

import exception.InputValidation;
import exception.MyException;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner;

    public UserView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void insert() throws MyException {
        System.out.println("== 전화번호 등록 ==");
        // 이름 올바른 값이 들어올 때까지 반복
        boolean nameOk = false;
        do {
            try {
                // 검증 클래스 생성
                InputValidation validation = new InputValidation();
                // 이름: 무조건 한글만, 중간 공백 없이
                System.out.println("이름: ");
                String name = scanner.next();
                validation.nameCheck(name);
                nameOk = true;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        } while (!nameOk);
        // 나이: 0~120세 사이값
        System.out.println("나이: ");
        int age = scanner.nextInt();
        // 주소
        System.out.println("주소: ");
        String address = scanner.next();
        // 전화번호: 010-XXXX-XXXX
        System.out.println("전화번호: ");
        String phone = scanner.next();
    }

    public void update() {
    }

    public void delete() {
    }

    public void searchAll() {
    }

    public void searchOne() {
    }
}

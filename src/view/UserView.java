package view;

import exception.InputValidation;
import exception.MyException;
import repository.TelBookRepository;
import service.TelBookService;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner;
    private final TelBookService service;

    public UserView(Scanner scanner, TelBookService service) {
        this.scanner = scanner;
        this.service = service;
    }

    // 검증 클래스 생성
    InputValidation validation = new InputValidation();


    public void insert() throws MyException {
        // 입력 자료 저장을 위한 변수 선언
        String name = "";
        int age = 0;
        String phone = "";
        String address = "'";
        System.out.println("== 전화번호 등록 ==");
        // 이름 올바른 값이 들어올 때까지 반복
        boolean nameOk = false;
        do {
            try {
                // 이름: 무조건 한글만, 중간 공백 없이
                System.out.println("이름: ");
                name = scanner.next();
                validation.nameCheck(name);
                nameOk = true;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        } while (!nameOk);
        // 나이: 0~120세 사이값
        boolean ageOk = false;
        do {
            try {
                System.out.println("나이: ");
                age = scanner.nextInt();
                validation.ageCheck(age);
                ageOk = true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (!ageOk);
        // 주소
        System.out.println("주소: ");
        address = scanner.next();
        // 전화번호: 010-XXXX-XXXX
        boolean phoneOk = false;
        do {
            try {
                System.out.println("전화번호: ");
                phone = scanner.next();
                validation.phoneCheck(phone);
                phoneOk = true;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        } while (!phoneOk);
        service.insert(name, age, address, phone);
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

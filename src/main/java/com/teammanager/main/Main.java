package com.teammanager.main;

import com.teammanager.auth.AuthController;
import com.teammanager.db.FirebaseInitialize; // [새로 추가됨]
import com.teammanager.db.ProjectDatabase;   // [새로 추가됨]
// TeamTask가 저장된 패키지명에 따라 아래 import를 확인하세요 (model 또는 team)
import com.teammanager.model.TeamTask;        // [새로 추가됨] 
// import com.teammanager.model.TeamTask; 

public class Main {
    public static void main(String[] args) {
        
        // ---------------------------------------------------------
        // 1. Firebase 초기화 (앱 켜질 때 가장 먼저 실행)
        // ---------------------------------------------------------
        try {
            System.out.println("⏳ Firebase 연결 시도 중...");
            FirebaseInitialize.initialize();
            System.out.println("✅ Firebase SDK 초기화 완료!");
        } catch (Exception e) {
            System.err.println("❌ Firebase 연결 실패!");
            e.printStackTrace();
            return; // DB 연결 안 되면 프로그램 종료
        }

        // ---------------------------------------------------------
        // 2. DB 연결 테스트 (테스트가 끝나면 이 부분은 나중에 지우거나 주석 처리하세요)
        // ---------------------------------------------------------
        System.out.println("--- DB 데이터 전송 테스트 시작 ---");
        ProjectDatabase db = new ProjectDatabase();
        
        // 테스트용 작업 생성 ("이름", "할일", "상태")
        TeamTask testTask = new TeamTask("TestUser", "Firebase 연동 확인", "진행중");
        
        // DB에 저장
        String result = db.addTask(testTask);
        System.out.println("결과 메시지: " + result);
        System.out.println("----------------------------------");


        // ---------------------------------------------------------
        // 3. 기존 프로그램 시작 화면 (원래 코드)
        // ---------------------------------------------------------
        System.out.println("============================");
        System.out.println("        수뭉이 팀플 관리       ");
        System.out.println("============================");
        
        // 로그인/회원가입 화면으로 이동
        AuthController auth = new AuthController();
        auth.start();
    }
}
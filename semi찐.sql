-- 1. 기존 테이블 삭제
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE challenge_participation CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE challenges CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- 2. 챌린지 테이블 생성
CREATE TABLE challenges (
    challenge_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR2(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    point_reward NUMBER,
    difficulty VARCHAR2(10) DEFAULT '초급',
    category VARCHAR2(50),
    CONSTRAINT chk_challenge_difficulty CHECK (difficulty IN ('초급', '중급', '고급'))
);

-- 3. 참여 테이블 생성 (challenge_id 참조)
CREATE TABLE challenge_participation (
  participation_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  user_id VARCHAR2(50) NOT NULL,
  challenge_id NUMBER NOT NULL,
  status VARCHAR2(10) DEFAULT '진행 중',
  joined_at DATE DEFAULT SYSDATE,
  completed_at DATE,
  earned_points NUMBER DEFAULT 0,
  CONSTRAINT fk_challenge FOREIGN KEY (challenge_id) REFERENCES challenges(challenge_id),
  CONSTRAINT chk_status CHECK (status IN ('진행 중', '완료', '취소'))
);

-- 4. 챌린지 데이터 전체 삽입


----------------------------

INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('물 2L 마시기', SYSDATE, SYSDATE + 30, 50, '초급', '건강');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('30분 걷기', SYSDATE, SYSDATE + 30, 50, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('계단 10층 오르기', SYSDATE, SYSDATE + 30, 60, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('팔 돌리기 30회', SYSDATE, SYSDATE + 30, 40, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('스쿼트 20회', SYSDATE, SYSDATE + 30, 50, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('무릎 대고 팔굽혀펴기 10회', SYSDATE, SYSDATE + 30, 40, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('허리 스트레칭 3세트', SYSDATE, SYSDATE + 30, 50, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('목 스트레칭 3세트', SYSDATE, SYSDATE + 30, 40, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('까치발 들기 30회', SYSDATE, SYSDATE + 30, 40, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('제자리 뛰기 2분', SYSDATE, SYSDATE + 30, 50, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('트위스트 동작 1분', SYSDATE, SYSDATE + 30, 40, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('벽에 기대고 앉기 1분', SYSDATE, SYSDATE + 30, 50, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('엉덩이 들고 버티기 30초', SYSDATE, SYSDATE + 30, 40, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('플랭크 30초', SYSDATE, SYSDATE + 30, 50, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('런지 10회', SYSDATE, SYSDATE + 30, 40, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('손목 돌리기 30초', SYSDATE, SYSDATE + 30, 30, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('누워서 자전거 타기 동작 30초', SYSDATE, SYSDATE + 30, 40, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('TV 보면서 스트레칭 10분', SYSDATE, SYSDATE + 30, 40, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('1km 걷기 or 트레드밀', SYSDATE, SYSDATE + 30, 50, '초급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('양발 벌리고 옆구리 늘리기 10회', SYSDATE, SYSDATE + 30, 40, '초급', '운동');

-- 중급 챌린지 (운동, 식단, 건강 관련)
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('팔굽혀펴기 20회', SYSDATE, SYSDATE + 30, 70, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('스쿼트 50회', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('플랭크 1분', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('런지 20회', SYSDATE, SYSDATE + 30, 70, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('계단 20층 오르기', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('자전거 타기 30분', SYSDATE, SYSDATE + 30, 90, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('줄넘기 300회', SYSDATE, SYSDATE + 30, 120, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('트레드밀 3km', SYSDATE, SYSDATE + 30, 110, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('복근 운동 루틴 10분', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('전신 스트레칭 15분', SYSDATE, SYSDATE + 30, 90, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('엉덩이 킥 20회', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('암 서클 1분', SYSDATE, SYSDATE + 30, 70, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('벽 스쿼트 1분 30초', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('점핑잭 50회', SYSDATE, SYSDATE + 30, 90, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('푸시업 플랭크 번갈아 1세트', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('크런치 30회', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('데드버그 20회', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('사이드 레그 레이즈 15회', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('하이 니 30초', SYSDATE, SYSDATE + 30, 70, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('무릎 당기기 런지 10회', SYSDATE, SYSDATE + 30, 70, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('버피 테스트 10회', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('타바타 루틴 4분', SYSDATE, SYSDATE + 30, 110, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('코어 강화 루틴 10분', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('하체 루틴 3세트', SYSDATE, SYSDATE + 30, 90, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('요가 기본 동작 5개', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('고정된 시간에 운동 루틴 수행', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('홈트레이닝 영상 따라하기 15분', SYSDATE, SYSDATE + 30, 110, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('스텝박스 10분', SYSDATE, SYSDATE + 30, 90, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('인터벌 걷기/달리기 15분', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('상체 루틴 3세트', SYSDATE, SYSDATE + 30, 90, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('복근 집중 루틴 3세트', SYSDATE, SYSDATE + 30, 90, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('와이드 스쿼트 40회', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('스트레칭 후 코어 3세트', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('전신 루틴 20분', SYSDATE, SYSDATE + 30, 110, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('싱글 레그 밸런스 버티기 30초', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('팔벌려 높이뛰기 100회', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('러시안 트위스트 50회', SYSDATE, SYSDATE + 30, 100, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('트위스트 런지 10회', SYSDATE, SYSDATE + 30, 80, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('플랭크 후 푸시업 번갈아 3세트', SYSDATE, SYSDATE + 30, 110, '중급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('리버스 런지 + 니업 10회', SYSDATE, SYSDATE + 30, 90, '중급', '운동');

-- 고급 챌린지 (운동, 식단, 건강 관련)
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('팔굽혀펴기 50회', SYSDATE, SYSDATE + 30, 150, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('스쿼트 100회', SYSDATE, SYSDATE + 30, 160, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('플랭크 3분', SYSDATE, SYSDATE + 30, 150, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('5km 러닝', SYSDATE, SYSDATE + 30, 200, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('런지 50회', SYSDATE, SYSDATE + 30, 150, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('버피 테스트 50회', SYSDATE, SYSDATE + 30, 180, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('줄넘기 1000회', SYSDATE, SYSDATE + 30, 250, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('자전거 10km', SYSDATE, SYSDATE + 30, 220, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('크런치 100회', SYSDATE, SYSDATE + 30, 180, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('HIIT 루틴 20분', SYSDATE, SYSDATE + 30, 200, '고급', '운동');
-- 고급 챌린지 (운동, 식단, 건강 관련)
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('풀업 10회', SYSDATE, SYSDATE + 30, 250, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('푸쉬업-플랭크 복합 3세트', SYSDATE, SYSDATE + 30, 230, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('하체 루틴 5세트', SYSDATE, SYSDATE + 30, 240, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('상체 루틴 5세트', SYSDATE, SYSDATE + 30, 240, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('인터벌 러닝 10세트', SYSDATE, SYSDATE + 30, 260, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('계단 30층 오르기', SYSDATE, SYSDATE + 30, 300, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('무산소 운동 30분', SYSDATE, SYSDATE + 30, 250, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('전신 스트레칭 30분', SYSDATE, SYSDATE + 30, 230, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('스텝업+런지 루틴 4세트', SYSDATE, SYSDATE + 30, 250, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('코어 복합 루틴 15분', SYSDATE, SYSDATE + 30, 270, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('전신 근력 루틴 5세트', SYSDATE, SYSDATE + 30, 280, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('요가 30분', SYSDATE, SYSDATE + 30, 220, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('암워킹 1분', SYSDATE, SYSDATE + 30, 200, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('푸시업 1분 동안 계속', SYSDATE, SYSDATE + 30, 250, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('하이 니 2분', SYSDATE, SYSDATE + 30, 220, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('마운틴 클라이머 100회', SYSDATE, SYSDATE + 30, 260, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('점프 스쿼트 3세트', SYSDATE, SYSDATE + 30, 270, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('풀업+푸쉬업 복합 루틴', SYSDATE, SYSDATE + 30, 300, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('전신 타바타 루틴 20분', SYSDATE, SYSDATE + 30, 320, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('스플릿 스쿼트 15회', SYSDATE, SYSDATE + 30, 250, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('점프 런지 20회', SYSDATE, SYSDATE + 30, 240, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('잭나이프 크런치 50회', SYSDATE, SYSDATE + 30, 230, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('러시안 트위스트 100회', SYSDATE, SYSDATE + 30, 260, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('바이시클 크런치 100회', SYSDATE, SYSDATE + 30, 250, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('리버스 플랭크 1분', SYSDATE, SYSDATE + 30, 240, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('스케이터 점프 30초', SYSDATE, SYSDATE + 30, 230, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('힙 브릿지 50회', SYSDATE, SYSDATE + 30, 220, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('싱글 레그 데드리프트 15회', SYSDATE, SYSDATE + 30, 230, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('브로드 점프 15회', SYSDATE, SYSDATE + 30, 240, '고급', '운동');
INSERT INTO challenges (title, start_date, end_date, point_reward, difficulty, category) VALUES ('코어 루틴 연속 수행 30분', SYSDATE, SYSDATE + 30, 250, '고급', '운동');

ALTER TABLE POSTS
ADD IS_NOTICE NUMBER DEFAULT 0;
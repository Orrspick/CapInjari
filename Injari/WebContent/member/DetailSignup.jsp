<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <main class="page contact-us-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">상세정보 입력</h2>
                    <p>회원님의 정보를 더 입력해주세요.<br></p>
                </div>
                <form action="MemberDetailupAction.do" method="post">
                    <div class="form-group">
                        <fieldset><label>성별</label></fieldset>
                        <div>
                            <fieldset>
                                <div class="custom-control custom-radio custom-control-inline"><input type="radio" id="gender" class="custom-control-input" name="gender" checked value="남성"><label class="custom-control-label" for="gender">남성</label></div>
                                <div class="custom-control custom-radio custom-control-inline"><input type="radio" id="gender" class="custom-control-input" name="gender" value="여성"><label class="custom-control-label" for="gender">여성</label></div>
                            </fieldset>
                        </div>
                    </div>
                    <div class="form-group"><label>전화번호</label><input class="form-control" type="text" id="phone" name="phone"></div>
                    <div class="form-group"><label>주소</label><input class="form-control" type="text" id="address" name="address"></div>
                    <div class="form-group"><label>전공</label><input class="form-control" type="text" id="major" name="major"></div>
                    <div class="form-group"><label>경력</label>
                        <div>
                            <fieldset>
                                <div class="custom-control custom-radio custom-control-inline"><input type="radio" id="career" class="custom-control-input" name="Career" checked="" value="신입"><label class="custom-control-label" for="career">신입</label></div>
                                <div class="custom-control custom-radio custom-control-inline"><input type="radio" id="career" class="custom-control-input" name="Career"><label class="custom-control-label" for="career">경력</label></div>
                            </fieldset>
                        </div>
                        <div class="dropdown"><button class="btn dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button">선택해주세요</button>
                            <div class="dropdown-menu"><a class="dropdown-item" href="#">1년 이하</a><a class="dropdown-item" href="#">1년 이상 3년 이하</a><a class="dropdown-item" href="#">3년 이상</a></div>
                        </div>
                    </div>
                    <div class="form-group"><button class="btn btn-primary btn-block" type="submit">확인</button></div>
                </form>
            </div>
        </section>
    </main>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
                                <div class="custom-control custom-radio custom-control-inline"><input type="radio" id="gender_man" class="custom-control-input" name="gender" checked="checked" value="남성"><label class="custom-control-label" for="gender_man">남성</label></div>
                                <div class="custom-control custom-radio custom-control-inline"><input type="radio" id="gender_woman" class="custom-control-input" name="gender" value="여성"><label class="custom-control-label" for="gender_woman">여성</label></div>
                            </fieldset>
                        </div>
                    </div>
                    <div class="form-group"><label>전화번호</label><input class="form-control" type="text"></div>
                    <div class="form-group"><label>주소</label><input class="form-control" type="email"></div>
                    <div class="form-group"><label>전공</label><input class="form-control" type="text"></div>
                    <div class="form-group"><label>경력</label>
                        <div>
                            <fieldset>
                                <div class="custom-control custom-radio custom-control-inline"><input type="radio" id="career_new" class="custom-control-input" name="career" checked="checked" value="신입" onchange="showcareer()"><label class="custom-control-label" for="career_new">신입</label></div>
                                <div class="custom-control custom-radio custom-control-inline"><input type="radio" id="career_old" class="custom-control-input" name="career" value="경력" onchange="showcareer()"><label class="custom-control-label" for="career_old">경력</label></div>
                                <div id="select_div" style="display: none;"><select class="form-control" style="width:176px" id="select_career" name="select_career"><option value="0" selected>선택해주세요</option><option value="1">1년 이하</option><option value="2">1년 이상</option><option value="3">2년 이상</option><option value="4">3년 이상</option><option value="5">5년 초과</option></select></div>
                                <div></div>
                            </fieldset>
                        </div>
                    </div>
                    <div class="form-group"><button class="btn btn-primary btn-block" type="submit">확인</button></div>
                </form>
            </div>
        </section>
    </main>
    <script type="text/javascript">
    function showcareer(){
   	 if($('input:radio[id=career_new]').is(':checked')){
         $('#select_div').hide();
         $("#select_career option:eq(0)").prop("selected", true);
     }else{
         $('#select_div').show();
     }
   }
    </script>
</body>
</html>
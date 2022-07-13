<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Comatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="hotel.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Dongle&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>
    &nbsp; <a href="http://192.168.0.50:8009/hotel1/hotel1.jsp"><b>예약관리</b></a>
    <a href="http://192.168.0.50:8009/hotel1/hotel2.jsp"><b>객실관리</b></a>
<form method="post" class="form-inline">
<div class="form-group w-100">
    <table class="table table-primary table-bordered border-primary w-100" style="width:100%">
        <tr>
            <td id="a1" style="width:35%">
                <table>
                    <tr>
                        <td>
                            체크인
                        </td>
                        <td>
                            <input type="date" class="form-control w-100" id="date1">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            체크아웃
                        </td>
                        <td>
                            <input type="date" class="form-control w-100" id="date2">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            숙박인원
                        </td>
                        <td>
                            <input type="number" class="form-control" id="people1" style="width:90%"> 명
                        </td>
                    </tr>
                    <tr>
                        <td>
                            객실종류
                        </td>
                        <td>
                            <select class="form-select form-control w-100" id="room1">
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <center>
                                <button type="button" class="btn btn-outline-secondary btn-sm" id="btn1">찾기</button>
                            </center>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            예약가능객실
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select size="5" class="form-select" id="hotel1">
                            </select>
                        </td>
                    </tr>
                </table>
            </td>
            <td style="width:30%">
                <table>
                    <tr>
                        <td>
                            예약번호
                        </td>
                        <td>
                            <input type="number" class="form-control form-control-sm w-100" id="ordernum" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            객실명
                        </td>
                        <td>
                            <input type="text" class="form-control form-control-sm w-100" id="roomname" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            객실종류
                        </td>
                        <td>
                            <select class="form-select form-control-sm" id="room2" readonly>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            숙박예정인원
                        </td>
                        <td>
                            <input type="number" class="form-control form-control-sm" id="people" style="width:90%"> 명
                        </td>
                    </tr>
                    <tr>
                        <td>
                            체크인
                        </td>
                        <td>
                            <input type="date" class="form-control" id="date3" style="width:100%" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            체크아웃
                        </td>
                        <td>
                            <input type="date" class="form-control" id="date4" style="width:100%" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            예약자
                        </td>
                        <td>
                            <input type="text" class="form-control form-control-sm w-100" id="leader">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            모바일
                        </td>
                        <td>
                            <input type="number" class="form-control form-control-sm w-100" id="mobile">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            숙박총액
                        </td>
                        <td style="color:red">
                            <input type="number" class="form-control form-control-sm w-100" id="price">
                            대실 절반할인
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        <center>
                            <button type="button" class="btn btn-primary btn-sm" id="btn2">예약등록</button> &nbsp; <button type="button" class="btn btn-danger btn-sm" id="btn3">예약취소</button> &nbsp;
                        <button type="button" class="btn btn-secondary btn-sm" id="btn4">비우기</button>
                        </center>
                        </td>
                    </tr>
                </table>
            </td>
            <td style="width:35%">
                <table>
                    <tr>
                        <td id="a3">
                            <h3>예약내역</h3>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select size="10" class="form-select" id="order">
                            </select>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
</form>
<script src="js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<script type="text/javascript" src="hotel1.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Comatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="hotel2.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Dongle&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>
    <a href="http://192.168.0.50:8009/hotel1/hotel1.jsp"><b>예약관리</b></a>
    <a href="http://192.168.0.50:8009/hotel1/hotel2.jsp"><b>객실관리</b></a>
    <form method="post" class="form-inline">
        <div class="form-group w-100">
            <table class="table table-primary table-bordered border-primary" style="width:100%">
                <tr>
                    <td id="a1" style="width:50%">
                        <table style="width:100%">
                            <tr >
                                <td id="a3">
                                    <h3>
                                        객실목록
                                    </h3>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <select size="8" class="form-select" id="hotel">
                                        <option> test</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td style="width:50%; height:100%">
                        <table style="width:100%;">
                            <tr>
                                <td>
                                    <h5>
                                        객실명
                                    </h5>
                                </td>
                                <td style="width: 100%;">
                                    <input type="text" class="form-control w-100" id="name">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5>
                                        객실종류
                                    </h5>
                                </td>
                                <td>
                                    <select class="form-select w-100" id="type">
                                        <option value="2"> SuiteRoom</option>
                                        <option value="3"> DeluxeRoom</option>
                                        <option value="4"> FamilyRoom</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5>숙박가능인원</h3>
                                </td>
                                <td>
                                    <input type="number" class="form-control" id="people" style="width:92%"> 명
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5>1박요금</h5>
                                </td>
                                <td>
                                    <input type="number" class="form-control" id="price" style="width:92%"> 원
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <center>
                                    <button type="button" class="btn btn-primary btn-sm" id="btn1">추가</button> &nbsp; <button type="button" class="btn btn-danger btn-sm" id="btn2">삭제</button> &nbsp; 
                                    <button type="button" class="btn btn-secondary btn-sm" id="btn3">비우기</button>
                                    </center>
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
<script type="text/javascript" src="hotel2.js"></script>
</body>
</html>
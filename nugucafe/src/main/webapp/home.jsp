<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>카페</title>
    <link rel="stylesheet" href="cafe.css" />
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

</head>
<body>
    <center>
        <h1>ㄴㄱ 카페</h1>
        <br><br><br>
    <table>
        <tr>
            <td>
                <table style="height: 500px;">
                    <tr>
                        <td style="background-color: #ffffff; height: 30px;">
                            <label>메뉴목록</label>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 200px;">
                            <select id="coffee" size="10">
                                <option>에스프레소:2000</option>
                                <option>라떼:3000</option>
                                <option>아메리카노:2500</option>
                                <option>카푸치노:3500</option>
                                <option>모카:3600</option>
                                <option>그린티:2300</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            메뉴 : <input type="text" id="cofme" readonly><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            수량 : <input type="number" id="cofco"><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            가격 : <input type="number" id="cofsel" readonly><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button id="btn1">추가</button> &nbsp;
                            <button id="btn2">취소</button>
                        </td>
                    </tr>
                </table>
            </td>
            <td>
                <table style="height: 500px;">
                    <tr>
                        <td style="background-color: #ffffff; height: 30px;">
                            <label>
                                주문목록
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 200px;">
                            <select size="10" id="call">

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            모바일번호 : <input type="text" id="num">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            총액 : <input type="number" id="sell" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button id="btn3">주문완료</button> &nbsp;
                            <button id="btn4">취소</button>
                        </td>
                    </tr>
                </table>
            </td>
            <td>
                <table style="height: 500px;">
                    <tr>
                        <td style="background-color: #ffffff; height: 30px;">
                            <label>
                                매출
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 200px;">
                            <select size="10" id="money">

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            매출합계: <label id="last"></label>원
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

    <div id="dvMenu" style="display:none;">
        <table>
            <tr>
                <td>
                    <select id="selMenu1" size="20" style="width:200px">
                    </select>
                </td>
                <td>
                    <input type="hidden" id="optype" value="add" readonly>
                    <table>
                        <tr><td>메뉴명&nbsp;<input type=text id=_name></td></tr>
                        <tr><td>가격&nbsp;<input type=number id=_price></td></tr>
                        <tr><td>&nbsp;</td></tr>
                        
                        <tr><td><input type="button" id="btnAdd" value="추가"><button id="btnDelete">삭제</button></td></tr>
                        <tr><td><button id="btnRemove">지우기</button><button id=btnCancel>취소</button></td></tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
    
<button id="btn6"><b>메뉴관리</b></button>
</center>
</body>
<script type="text/javascript" src="caffee.js"></script>
</html>
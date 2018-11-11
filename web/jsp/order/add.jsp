<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>点菜</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/order/addOrder.html"
		method=post>
		

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：点餐管理 &gt; 点餐</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>选择菜品 ：</td>
								<td colspan="3">
									<c:forEach items="${vageList}" var="vage">
										<input name="ids" type="checkbox" value="${vage.vageId}"> ${vage.vageName}
									</c:forEach>
								</td>
							</TR>
							<TR>
								<td>用餐房间 ：</td>
								<td>
									<select id='room' onchange="selectRoom(this.value)" style="WIDTH: 180px" maxLength=50 name="room.roomId">
										<c:forEach items="${roomList}" var="room">
											<option value="${room.roomId}">${room.roomName}</option>
										</c:forEach>
									</select>
								</td>
								<td>选择餐桌 ：</td>
								<td>
									<select id='desk' style="WIDTH: 180px" maxLength=50 name="desk.deskId">

									</select>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>

<script>
	function selectRoom(id) {
        var Ivalue = "{\"roomId\":\""+id+"\"}";
        $.ajax({
            url : "${pageContext.request.contextPath}/desk/getDeskListByRoom.action",
            data : Ivalue,
            contentType : "application/json;charset=UTF-8",
            type : "post",
            dataType : "json",
            success : function(dep){
                var deskList = eval(dep.data);
                //获得第二个菜单节点
                var select2 = document.getElementById("desk");
                //先确定第二个菜单节点中是否有值，如果有就进行清空操作
                //获得第二个菜单下的option节点
                var optionArrays = select2.getElementsByTagName("option");
                //清除操作
                for(var i=0;i<optionArrays.length;i++){
                    select2.removeChild(optionArrays[i]);
                    i--;//此处的i--是因为当删除一个optionArrays中的一个数据，它的长度就会减一，
                        //如果没有进行着操作的话，就会导致清除的效果不佳，使得有些选项没有被删除
                }
                for(var i = 0; i < deskList.length; i++) {
                    $("#desk").append("<option id='" + deskList[i].deskId + "' value='" + deskList[i].deskId + "'>" + deskList[i].deskName  + "</option");
                }
            }
        });
    }

    window.onload = function() {
	    var id = $('#room').val();
	    selectRoom(id)
	}
</script>
</HTML>

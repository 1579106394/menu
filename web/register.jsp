<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <STYLE type=text/css>
        BODY {
            FONT-SIZE: 12px;
            COLOR: #ffffff;
            FONT-FAMILY: 宋体
        }

        TD {
            FONT-SIZE: 12px;
            COLOR: #ffffff;
            FONT-FAMILY: 宋体
        }
    </STYLE>

    <META content="MSHTML 6.00.6000.16809" name=GENERATOR>
    <script type="text/javascript">
        window.onload = function () {

            if (window.parent != window) {// 如果是在框架中
                //就让框架页面跳转到登陆页面
                window.parent.location.href = "${pageContext.request.contextPath}/login.jsp";
            }

        };
    </script>

</HEAD>
<BODY>
<FORM id=form1 name=form1 action="${pageContext.request.contextPath}/user/register.html" method=post>

    <DIV id=UpdatePanel1>
        <DIV id=div1
             style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
        <DIV id=div2
             style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


        <DIV>&nbsp;&nbsp;</DIV>
        <DIV>
            <TABLE bgcolor="#00008b" cellSpacing=0 cellPadding=0 width=900 align=center border=0>
                <TBODY>

                <TR>
                    <TD height=300>
                        <TABLE cellPadding=0 width=900 border=0>
                            <TBODY>
                            <TR align="center">
                                <TD colSpan=2 height=35><h2>注册页面</h2></TD>
                            </TR>
                            <TR>
                                <TD width=360></TD>
                                <TD>
                                    <TABLE cellSpacing=0 cellPadding=2 border=0>
                                        <TBODY>
                                        <TR>
                                            <TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
                                            <TD style="HEIGHT: 28px" width=150><INPUT id=txtName
                                                                                      style="WIDTH: 130px"
                                                                                      name="username"></TD>
                                            <TD style="HEIGHT: 28px" width=370><SPAN
                                                    id=RequiredFieldValidator3
                                                    style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入登录名</SPAN>
                                            </TD>
                                        </TR>
                                        <TR>
                                            <TD style="HEIGHT: 28px">登录密码：</TD>
                                            <TD style="HEIGHT: 28px"><INPUT id=txtPwd style="WIDTH: 130px"
                                                                            type=password name="password"></TD>
                                            <TD style="HEIGHT: 28px"><SPAN id=RequiredFieldValidator4
                                                                           style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</SPAN>
                                            </TD>
                                        </TR>
                                        <TR>
                                            <TD style="HEIGHT: 18px" colspan="2"><font color="red">${error}</font></TD>
                                            <TD style="HEIGHT: 18px"></TD>
                                        </TR>
                                        <TR>
                                            <TD></TD>
                                            <TD>
                                                <INPUT type=button onclick="toLogin();" value="登录" name=btn>
                                                <INPUT type=submit value="注册" name=btn>
                                            </TD>
                                        </TR>
                                        </TBODY>
                                    </TABLE>
                                </TD>
                            </TR>
                            </TBODY>
                        </TABLE>
                    </TD>
                </TR>

                </TBODY>
            </TABLE>
        </DIV>
    </DIV>


</FORM>
<s:debug></s:debug>
</BODY>
<script>
    function toLogin() {
        window.location.href = "${pageContext.request.contextPath}/login.jsp"
    }
</script>
</HTML>

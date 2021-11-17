<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<c:if test="${!empty msg}">
	<script>
	alert("${msg}");
	</script>
	</c:if>
    <script type="text/javascript">
        $(document).ready(function () {
        	
        	
        	$("#mvRegisterBtn").click(function () {
                location.href = "${root}/notice/register";
            });
        	
        });
    </script>
   
    <div class="container text-center mt-3">
        <div class="col-lg-8 mx-auto">
            <h2 class="p-3 mb-3 shadow bg-light"><mark class="sky">글목록</mark></h2>
            <div class="m-3 text-right">
                <button type="button" id="mvRegisterBtn" class="btn btn-link">글작성</button>
            </div>
            
		<c:if test="${!empty articles}">
			<c:forEach var="article" items="${articles}">
			<table class="table table-active text-left">
				<tbody>
					<tr class="table-info">
						<td>작성자 : ${article.userId}</td>
						<td class="text-right">작성일 : ${article.regTime}</td>
					</tr>
					<tr>
						<td colspan="2" class="table-danger">
							<strong>${article.articleNo}. ${article.subject}</strong>
						</td>
					</tr>
					<tr>
						<td class="p-4" colspan="2">
							${article.content}
						</td>
					</tr>
					<c:if test="${userinfo.userId eq article.userId}">
					<tr>
						<td colspan="2" class="text-right">
							<a href="${root}/notice/modify?articleno=${article.articleNo}">수정</a>
							<a href="${root}/notice/delete?articleno=${article.articleNo}">삭제</a>
						</td>
					</tr>
					</c:if>
				</tbody>
			</table>
			</c:forEach>
			<div class="m-3 row justify-content-center">${navigation.navigator}</div>
		</c:if>
		<c:if test="${empty articles}">
			<table class="table table-active text-center">
				<tr class="table-info">
					<td>작성한 글이 없습니다.</td>
				</tr>
			</table>
		</c:if>
		</div>
    </div>
</body>
</html>
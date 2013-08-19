<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function update(triggerName,triggerGroup,action){
	location.href="quartz/update/"+action+"/"+triggerName+"/"+triggerGroup;
}
</script>
        <div class="span9">
          <div class="hero-unit">
            <table class="table">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Trigger Name</th>
                  <th>Trigger Group</th>
                  <th>Job Name</th>
                  <th>Job Group</th>
                  <th>Trigger State</th>
                  <th>Start Time</th>
                  <th>End Time</th>
                     <th>操作</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${quartzTriggerList}" var="quartzTrigger" varStatus="s">
                <tr>
                <td>${s.index}</td>
                  <td>${quartzTrigger.triggerName}</td>
                  <td>${quartzTrigger.triggerGroup}</td>
                   <td>${quartzTrigger.jobName}</td>
                   <td>${quartzTrigger.jobGroup}</td>
                   <td>${quartzTrigger.triggerState}</td>
                   <td>${quartzTrigger.startTime}</td>
                   <td>${quartzTrigger.endTime}</td>
                  <td>
                 <c:if test="${quartzTrigger.triggerState eq 'ACQUIRED'}">
                   <button class="btn btn-primary " type="button" onclick="update('${quartzTrigger.triggerName}','${quartzTrigger.triggerGroup}','pause');">暂停</button> 
                   <button class="btn btn-primary disabled" type="button"  disabled="disabled">恢复</button>
                   </c:if>
                    <c:if test="${quartzTrigger.triggerState ne 'ACQUIRED'}">
                   <button class="btn btn-primary disabled" type="button"  disabled="disabled">暂停</button> 
                   <button class="btn btn-primary" type="button" onclick="update('${quartzTrigger.triggerName}','${quartzTrigger.triggerGroup}','resume');">恢复</button>
                   </c:if>
                   </td>
                </tr>
               </c:forEach>
              </tbody>
            </table>
          
          </div><!--/row-->
        </div><!--/span-->
    
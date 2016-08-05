<%@ page language="java" import="java.net.URL" pageEncoding="UTF-8"%>

<div id="err" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" style="display: none;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content text-warning">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="mySmallModalLabel">警告信息</h4>
            </div>
            <div class="modal-body"></div>
        </div>
    </div>
</div>
<div id="info" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" style="display: none;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content text-info">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="mySmallModalLabel">提示信息</h4>
            </div>
            <div class="modal-body"></div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value='/js/jquery-2.2.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/default.js'/>"></script>

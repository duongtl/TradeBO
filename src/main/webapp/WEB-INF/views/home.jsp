<%@ page contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="base" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>

<html
        lang="en"
        class="light-style layout-menu-fixed"
        dir="ltr"
        data-theme="theme-default"
        data-assets-path="../assets/"
        data-template="vertical-menu-template-free"
>
<head>
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Support Trade - Pro</title>

    <meta name="description" content=""/>

    <link rel="icon" type="image/x-icon" href="${base}/assets/img/favicon/favicon.ico"/>

    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />

    <link rel="stylesheet" href="${base}/assets/vendor/fonts/boxicons.css"/>

    <link rel="stylesheet" href="${base}/assets/vendor/css/core.css" class="template-customizer-core-css"/>
    <link rel="stylesheet" href="${base}/assets/vendor/css/theme-default.css" class="template-customizer-theme-css"/>
    <link rel="stylesheet" href="${base}/assets/css/demo.css"/>

    <link rel="stylesheet" href="${base}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>


    <script src="${base}/assets/vendor/js/helpers.js"></script>

    <script src="${base}/assets/js/config.js"></script>


    <style>
        body::-webkit-scrollbar {
            width: 0;
        }

        .custom-scroll::-webkit-scrollbar {
            width: 6px !important;
            background-color: transparent;
            color: #03b0d4;
        }

        .custom-scroll::-webkit-scrollbar-track {
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
        }

        .no-data {
            display: flex;
            height: 72vh;
            justify-content: center;
            align-items: center;
        }

        #dataRender {
            overflow: auto;
        }

        #dataRender::-webkit-scrollbar {
            width: 5px !important;
        }

        #dataRender::-webkit-scrollbar-thumb {
            background: #373f8b;
            border-radius: 10px;
        }

        #dataRender::-webkit-scrollbar-track {
            box-shadow: inset 0 0 5px grey;
            border-radius: 10px;
        }

        #dataRender code {
            /*-webkit-user-modify: read-write-plaintext-only;*/
            font-size: 100%;
            color: #000000;
        }

        pre {
            word-break: normal;
            font-size: 100%;
        }

    </style>


    <style type="text/css">
        @keyframes ldio-vrjokh5kei8-o {
            0% {
                opacity: 1;
                transform: translate(0 0)
            }
            49.99% {
                opacity: 1;
                transform: translate(40px, 0)
            }
            50% {
                opacity: 0;
                transform: translate(40px, 0)
            }
            100% {
                opacity: 0;
                transform: translate(0, 0)
            }
        }

        @keyframes ldio-vrjokh5kei8 {
            0% {
                transform: translate(0, 0)
            }
            50% {
                transform: translate(40px, 0)
            }
            100% {
                transform: translate(0, 0)
            }
        }

        .ldio-vrjokh5kei8 div {
            position: absolute;
            width: 40px;
            height: 40px;
            border-radius: 50%;
            top: 30px;
            left: 10px;
        }

        .ldio-vrjokh5kei8 div:nth-child(1) {
            background: #e90c59;
            animation: ldio-vrjokh5kei8 1s linear infinite;
            animation-delay: -0.5s;
        }

        .ldio-vrjokh5kei8 div:nth-child(2) {
            background: #46dff0;
            animation: ldio-vrjokh5kei8 1s linear infinite;
            animation-delay: 0s;
        }

        .ldio-vrjokh5kei8 div:nth-child(3) {
            background: #e90c59;
            animation: ldio-vrjokh5kei8-o 1s linear infinite;
            animation-delay: -0.5s;
        }

        .loadingio-spinner-dual-ball-qr05rr2c6h {
            width: 44px;
            height: 44px;
            display: inline-block;
            overflow: hidden;
            background: transparent;
        }

        .ldio-vrjokh5kei8 {
            width: 100%;
            height: 100%;
            position: relative;
            transform: translateZ(0) scale(0.44);
            backface-visibility: hidden;
            transform-origin: 0 0; /* see note above */
        }

        .ldio-vrjokh5kei8 div {
            box-sizing: content-box;
        }

        /* generated by https://loading.io/ */
    </style>
</head>

<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">

        <!-- Content wrapper -->
        <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y" style="padding-bottom: 0 !important;">
                <div class="row">
                    <div class="col-12">
                        <h6 class="text-muted" style="display: block;margin:0 auto">
                        </h6>
                        <div class="nav-align-top mb-4">
                            <ul class="nav nav-pills mb-3 nav-fill" role="tablist">
                                <li class="nav-item">
                                    <button type="button" class="nav-link active" role="tab" data-bs-toggle="tab"
                                            data-bs-target="#navs-pills-justified-home"
                                            aria-controls="navs-pills-justified-home" aria-selected="true">
                                        <i class="tf-icons bx bx-home"></i> Trang chủ
                                    </button>
                                </li>
                                <li class="nav-item">
                                    <button type="button" class="nav-link" role="tab" data-bs-toggle="tab"
                                            data-bs-target="#navs-pills-justified-profile"
                                            aria-controls="navs-pills-justified-profile" aria-selected="false">
                                        <i class="tf-icons bx bx-user"></i> Dữ liệu
                                    </button>
                                </li>
                                <li class="nav-item">
                                    <button type="button" class="nav-link" role="tab" data-bs-toggle="tab"
                                            data-bs-target="#navs-pills-justified-messages"
                                            aria-controls="navs-pills-justified-messages" aria-selected="false">
                                        <i class="tf-icons bx bx-message-square"></i> Tin nhắn
                                    </button>
                                </li>
                                <li class="nav-item">
                                    <button type="button" class="nav-link" role="tab" data-bs-toggle="tab"
                                            data-bs-target="#navs-pills-justified-messages"
                                            aria-controls="navs-pills-justified-messages" aria-selected="false">
                                        <i class="tf-icons bx bx-message-square"></i> No content
                                    </button>
                                </li>
                                <li class="nav-item">
                                    <button type="button" class="nav-link" role="tab" data-bs-toggle="tab"
                                            data-bs-target="#navs-pills-justified-messages"
                                            aria-controls="navs-pills-justified-messages" aria-selected="false">
                                        <i class="tf-icons bx bx-message-square"></i> No content
                                    </button>
                                </li>
                            </ul>
                            <div class="tab-content" style="padding: 0;background-color: transparent;box-shadow: none">
                                <div class="tab-pane fade active show" id="navs-pills-justified-home" role="tabpanel">
                                    <div class="col-xl-12">
                                        <div class="card mb-2 mt-2">
                                            <div class="card-header d-flex align-items-center justify-content-between">
                                                <h5 class="mb-0">Logging Basic</h5>
                                                <small class="text-muted float-end">Basic</small>
                                            </div>
                                            <div class="card-body">
                                                <div class="row justify-content-start">
                                                    <div class="col-sm-10">
                                                        <button type="submit" id="scanOnly" class="btn btn-primary">
                                                            <div id="loadScanOnly" style="display: none"
                                                                 class="spinner-border spinner-border-sm text-white"
                                                                 role="status">
                                                                <span class="visually-hidden">Loading...</span>
                                                            </div>
                                                            <p class="mb-0">Scan</p>
                                                        </button>
                                                        <button type="submit" id="scanSave" class="btn btn-primary">
                                                            <div id="loadScanSave" style="display: none"
                                                                 class="spinner-border spinner-border-sm text-white"
                                                                 role="status">
                                                                <span class="visually-hidden">Loading...</span>
                                                            </div>
                                                            <p class="mb-0">Scan & Save</p>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <!-- Basic with Icons -->
                                    <div class="col-xl-12">
                                        <div class="card mb-2 mt-2">
                                            <div class="card-header d-flex align-items-center justify-content-between">
                                                <h5 class="mb-0">Logging with input</h5>
                                                <small class="text-muted float-end">Medium</small>
                                            </div>
                                            <div class="card-body">
                                                <form autocomplete="off">
                                                    <div class="row mb-3">
                                                        <label class="col-sm-2 col-form-label"
                                                               for="basic-icon-default-21">Hệ số</label>
                                                        <div class="col-sm-10">
                                                            <div class="input-group input-group-merge">
                                                  <span id="basic-icon-default-21" class="input-group-text"><i
                                                          class="bx bx-user"></i>
                                                  </span>
                                                                <input id="he-so"
                                                                       value="1"
                                                                       required="required"
                                                                       oninvalid="this.setCustomValidity('Vui lòng nhập hệ số')"
                                                                       oninput="this.setCustomValidity('')"
                                                                       type="number"
                                                                       class="form-control"
                                                                       placeholder="Hệ số"
                                                                       aria-label="Hệ số"
                                                                       aria-describedby="basic-icon-default-fullname2"
                                                                />
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label class="col-sm-2 col-form-label"
                                                               for="bot-id">Phương pháp</label>
                                                        <div class="col-sm-10">
                                                            <div class="input-group input-group-merge">
                                                  <span id="basic-icon-default-23" class="input-group-text"><i
                                                          class="bx bx-user"></i>
                                                  </span>
                                                                <input style="border-right: inset;border-radius: 0.375rem;"
                                                                       class="form-control" list="datalistOptions"
                                                                       id="bot-id"
                                                                       onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                                                                       required="required"
                                                                       oninvalid="this.setCustomValidity('Vui lòng chọn phương pháp')"
                                                                       oninput="this.setCustomValidity('')"
                                                                       placeholder="Chọn phương pháp...">
                                                                <datalist id="datalistOptions">
                                                                    <%--@elvariable id="methods" type="java.util.List"--%>
                                                                    <c:forEach items="${methods}" var="item">
                                                                        <option value="${item.id}">${item.name}</option>
                                                                    </c:forEach>
                                                                </datalist>
                                                            </div>
                                                        </div>
                                                    </div>


                                                    <div class="row justify-content-end">
                                                        <div class="col-sm-10">
                                                            <button type="submit" id="scanOne" class="btn btn-primary">
                                                                <div id="loadScanOne" style="display: none"
                                                                     class="spinner-border spinner-border-sm text-white"
                                                                     role="status">
                                                                    <span class="visually-hidden">Loading...</span>
                                                                </div>
                                                                <p class="mb-0">Scan</p>
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <button id="btnShowModal"
                                                            data-bs-toggle="modal"
                                                            data-bs-target="#modalScrollable"
                                                            style="display: none">
                                                    </button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="navs-pills-justified-profile" role="tabpanel">
                                    <div class="col-xl-12">
                                        <div class="card mb-2 mt-2">
                                            <%--                                            <div class="card-header d-flex align-items-center justify-content-between">--%>
                                            <%--                                            </div>--%>
                                            <div class="card-body">
                                                <div id="dataRender" style="height: 70vh;overflow: auto">
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div class="tab-pane fade" id="navs-pills-justified-messages" role="tabpanel">
                                    <h1 class="no-data">No data</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div id="loadCommon" style="display: none" class="m-auto loadingio-spinner-dual-ball-qr05rr2c6h">
                <div class="ldio-vrjokh5kei8">
                    <div></div>
                    <div></div>
                    <div></div>
                </div>
            </div>


            <!-- / Content -->

            <div class="content-backdrop fade"></div>
        </div>
        <!-- Content wrapper -->
        <!-- / Layout page -->


    </div>

    <div class="buy-now">
        <div class="btn-group" style="position: fixed; bottom: 3rem;right: 1.625rem;z-index: 999999;">
            <button type="button" class="btn btn-primary btn-icon rounded-pill dropdown-toggle hide-arrow"
                    data-bs-toggle="dropdown" aria-expanded="false">
                <i class="bx bx-dots-vertical-rounded"></i>
            </button>
            <ul class="dropdown-menu dropdown-menu-end" style="">
                <li><a class="dropdown-item" id="clearLog" href="javascript:void(0);">Clear</a></li>
                <li><a class="dropdown-item" id="downloadFile" href="javascript:void(0);">Save</a></li>
            </ul>
        </div>
    </div>
    <!-- Overlay -->
    <div class="layout-overlay layout-menu-toggle"></div>
</div>


<script src="${base}/assets/vendor/libs/jquery/jquery.js"></script>
<script src="${base}/assets/vendor/libs/popper/popper.js"></script>
<script src="${base}/assets/vendor/js/bootstrap.js"></script>
<script src="${base}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="${base}/assets/vendor/js/menu.js"></script>

<script src="${base}/assets/js/main.js"></script>

<script async defer src="https://buttons.github.io/buttons.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
<script>
    let logs = '';

    $('#scanOnly').click(function () {
        disableBtn();
        $('#scanOnly p').attr('style', 'color: transparent;height: 0;');
        $('#loadScanOnly').removeAttr('style');
        $.ajax({
            url: "/scan",
            type: "get",
            success: function () {
                $('#loadScanOnly').attr('style', 'display: none');
                $('#scanOnly p').removeAttr('style');
                enableBtn();
                $('#loadData').attr('style', 'display: none');
            },
            error: function (jqXhr, textStatus, errorMessage) {
                console.log(errorMessage);
            }
        });
    })

    $('#scanSave').click(function () {
        disableBtn()
        $('#scanSave p').attr('style', 'color: transparent;height: 0;');
        $('#loadScanSave').removeAttr('style');
        $.ajax({
            url: "/save",
            type: "get",
            success: function () {
                $('#loadScanSave').attr('style', 'display: none');
                $('#scanSave p').removeAttr('style');
                enableBtn();
            },
            error: function (jqXhr, textStatus, errorMessage) {
                console.log(errorMessage);
            }
        });
    })

    const enableBtn = () => {
        $('#scanOne').prop("disabled", false);
        $('#scanSave').prop("disabled", false);
        $('#scanOnly').prop("disabled", false);
        $('#loadCommon').attr("style", "display: none");
    }

    const disableBtn = () => {
        $('#scanOne').prop("disabled", 'disabled');
        $('#scanSave').prop("disabled", 'disabled');
        $('#scanOnly').prop("disabled", 'disabled');
        $('#loadCommon').attr("style", "display: block");
    }


    function download(filename, text) {
        const element = document.createElement('a');
        element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
        element.setAttribute('download', filename);

        element.style.display = 'none';
        document.body.appendChild(element);

        element.click();

        document.body.removeChild(element);
    }

    $('#downloadFile').click(function () {
        if (logs === '') {
            return;
        }
        download(new Date().toLocaleString() + "_LOG_BO", logs)
    })

    $('#scanOne').click(function () {
        const id = $('#bot-id').val();
        const heSo = $('#he-so').val();
        if (id === '') {
            return;
        }
        disableBtn()

        $('#scanOne p').attr('style', 'color: transparent;height: 0;');
        $('#loadScanOne').removeAttr('style');
        $.ajax({
            url: "/scan/" + id + "/" + heSo,
            type: "get",
            success: function (result) {
                //download(new Date().toLocaleString() + "_PP_" + id, result);
                $('#loadScanOne').attr('style', 'display: none');
                $('#scanOne p').removeAttr('style');
                enableBtn();
            },
            error: function (jqXhr, textStatus, errorMessage) {
                console.log(errorMessage);
            }
        });
    })

    let socket = new WebSocket("ws://localhost:8080/ws");
    let timer = -1;

    socket.onopen = function (e) {
        console.log("[open] Connection established");
        console.log("start " + new Date());
    };

    $('#clearLog').click(function () {
        logs = '';
        $('#dataRender').html('');
    })

    socket.onmessage = function (e) {
        let data = e.data;
        logs = logs + data
        data = "<code><pre>" + data + "</pre><code>"
        let style = $('#modalScrollable').attr("style") + "";
        if (style.indexOf('none') !== -1) {
            $('#btnShowModal').click();
        }
        $('#dataRender').append(data).scrollTop(Number.MAX_SAFE_INTEGER);
        $('#loadData').attr('style', 'display: block');
    };

    socket.onclose = function (event) {
        if (event.wasClean) {
            console.log(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
            console.log("end " + new Date());
        } else {
            console.log('[close] Connection died');
        }
        if (timer !== -1) {
            clearInterval(timer);
            timer = -1;
        }
    };

    socket.onerror = function (error) {
        console.log(`[error] ${error.message}`);
        if (timer !== -1) {
            clearInterval(timer);
            timer = -1;
        }
    };

</script>


</body>
</html>

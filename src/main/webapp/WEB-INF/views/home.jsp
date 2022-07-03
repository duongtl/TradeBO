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

    <title>Horizontal Layouts - Forms | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

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
</head>

<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">

        <!-- Content wrapper -->
        <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
                <!-- Basic Layout & Basic with Icons -->
                <div class="row">
                    <!-- Basic Layout -->
                    <div class="col-xl-6">
                        <div class="card mb-4">
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
                    <div class="col-xl-6">
                        <div class="card mb-4">
                            <div class="card-header d-flex align-items-center justify-content-between">
                                <h5 class="mb-0">Logging with input</h5>
                                <small class="text-muted float-end">Medium</small>
                            </div>
                            <div class="card-body">
                                <form>
                                    <div class="row mb-3">
                                        <label class="col-sm-2 col-form-label" for="basic-icon-default-21">Hệ số</label>
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
                                        <label class="col-sm-2 col-form-label" for="basic-icon-default-22">Bot
                                            ID</label>
                                        <div class="col-sm-10">
                                            <div class="input-group input-group-merge">
                                                  <span id="basic-icon-default-22" class="input-group-text"><i
                                                          class="bx bx-user"></i>
                                                  </span>
                                                <input id="bot-id"
                                                       onkeypress="return event.charCode >= 48 && event.charCode <= 57"
                                                       required="required"
                                                       oninvalid="this.setCustomValidity('Vui lòng nhập Bot ID')"
                                                       oninput="this.setCustomValidity('')"
                                                       type="number"
                                                       class="form-control"
                                                       placeholder="Bot ID"
                                                       aria-label="Bot ID"
                                                       aria-describedby="basic-icon-default-22"
                                                />
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
                                    <button id="btnShowModal2"
                                            data-bs-toggle="modal"
                                            data-bs-target="#modalScrollable"
                                            style="display: none">
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!-- / Content -->

            <div class="modal fade" id="modalScrollable" tabindex="-1" style="display: none;" aria-hidden="true">
                <div class="modal-dialog modal-xl modal-dialog-scrollable" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modalScrollableTitle">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <canvas id="myCanvas" width="100%" height="100vh"
                                    style="width: 100%;height: 100%;border: 1px solid grey">
                                Your browser does not support the canvas element.
                            </canvas>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                                Close
                            </button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="content-backdrop fade"></div>
        </div>
        <!-- Content wrapper -->
        <!-- / Layout page -->
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

    $('#scanOnly').click(function () {
        $(this).attr('disabled', 'disabled');
        $('#scanOnly p').attr('style', 'color: transparent;height: 0;');
        $('#loadScanOnly').removeAttr('style');
        $.ajax({
            url: "/scan",
            type: "get",
            success: function () {
                $('#loadScanOnly').attr('style', 'display: none');
                $('#scanOnly p').removeAttr('style');
                enableBtn();
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
    }

    const disableBtn = () => {
        $('#scanOne').prop("disabled", 'disabled');
        $('#scanSave').prop("disabled", 'disabled');
        $('#scanOnly').prop("disabled", 'disabled');
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
                download(new Date().toLocaleString() + "_PP_" + id, result);

                // $('#modalScrollable .modal-body').html(result);
                //$('#btnShowModal').click();
                $('#loadScanOne').attr('style', 'display: none');
                $('#scanOne p').removeAttr('style');
                enableBtn();
            },
            error: function (jqXhr, textStatus, errorMessage) {
                console.log(errorMessage);
            }
        });
    })
</script>


</body>
</html>

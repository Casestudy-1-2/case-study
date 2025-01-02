<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 12/28/2024
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/utils/bootstrap.jsp" %>
<%@include file="/WEB-INF/utils/header.jsp" %>
<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&family=Poppins:wght@400;600&display=swap"-->
    rel="stylesheet"
        <style>
            .main-layout {
                display: flex;
                padding-top: 80px;
            }

            .main-content {
                flex: 3;
                background-color: #AAAAAA;
                padding: 5px;
            }

            .sidebar {
                flex: 1;
                background-color: #D3D3D3;
                padding: 10px;
            }

            .footer {
                background-color: #f8d7da;
                text-align: center;
                padding: 10px;
                clear: both;
            }

            .button:hover {
                background-color: #D3D3D3;
                transform: scale(1.05);
            }
        </style>
    </head>
    <body>
    <div class="container-fluid">
        <div class="main-layout">
            <main class="main-content">
                <div style="margin-top: 20px; font-family: 'Roboto', sans-serif;">
                    <p class="p" style="text-align: center; font-size: 32px; font-weight: 700; color: #333;">
                        <b>Chào mừng bạn đến với phòng gym hàng đầu của chúng tôi!</b>
                    </p>
                    <ul style="font-size: 18px; line-height: 1.6;">
                        <li>
                            <p style="font-weight: 400;">Hãy cùng chúng tôi khám phá hành trình cải thiện sức khỏe và thể
                                hình mỗi ngày.</p>
                        </li>
                        <li>
                            <p style="font-weight: 400;">Đội ngũ huấn luyện viên của chúng tôi là những chuyên gia hàng đầu
                                với hơn 10 năm kinh nghiệm quốc tế.</p>
                        </li>
                        <li>
                            <p style="font-weight: 400;">Với trang thiết bị tập luyện hiện đại nhất, bạn sẽ được trải nghiệm
                                những tiêu chuẩn cao nhất toàn cầu.</p>
                        </li>
                    </ul>
                </div>

                <div>
                    <img src="https://i.pinimg.com/originals/fe/e5/46/fee54690963240994bf2b3c6342bc89a.jpg"
                         class="img-fluid"
                         alt="...">
                </div>
                <div>
                    <hr>
                </div>
                <div>
                    <h2>Giới thiệu về trang thiết bị hiện đại đứng top toàn cầu : </h2>
                </div>

                <div style="display: flex; flex-wrap: wrap; gap: 20px; justify-content: center; margin-top: 25px">
                    <div class="card" style="width: 16rem;">
                        <img src="https://setupphonggym.vn/wp-content/uploads/2020/11/mau-thiet-ke-phong-gym-canh-gara.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                                the card's content.</p>
                        </div>
                    </div>
                    <div class="card" style="width: 16rem;">
                        <img style="height: 192px" src="https://wikisport.vn/uploads/2022/thiet-ke-phong-gym.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                                the card's content.</p>
                        </div>
                    </div>
                    <div class="card" style="width: 16rem;">
                        <img style="height: 192px"
                             src="https://i.pinimg.com/originals/59/ec/e4/59ece488df3efdea7c39f24174312c91.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                                the card's content.</p>
                        </div>
                    </div>
                    <div class="card" style="width: 16rem;">
                        <img style="height: 192px"
                             src="https://www.rchdesign.co.uk/wp-content/uploads/2019/09/gym-interior-design.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                                the card's content.</p>
                        </div>
                    </div>
                </div>

                <div>
                    <hr>
                </div>

                <div style="margin-top: 25px">
                    <h2>Các chuyên gia thể hình nổi tiếng :</h2>
                </div>
                <div style="display: flex; flex-wrap: wrap; gap: 30px; justify-content: center; margin-top: 25px">
                    <div class="card" style="width: 20rem;">
                        <img style="height: 300px"
                             src="https://i.pinimg.com/originals/b2/44/0c/b2440c02985281af3b3a8841de68db38.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                                the card's content.</p>
                        </div>
                    </div>
                    <div class="card" style="width: 20rem;">
                        <img style="height: 300px"
                             src="https://i.pinimg.com/736x/a9/08/a3/a908a3bf0031f4df291023a556a49443.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                                the card's content.</p>
                        </div>
                    </div>
                    <div class="card" style="width: 20rem;">
                        <img style="height: 300px"
                             src="https://i.pinimg.com/originals/b3/70/28/b370286f2408f53287527f6be5f55848.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                                the card's content.</p>
                        </div>
                    </div>
                </div>

            </main>

            <aside class="sidebar">
                <div class="container">
                    <form style="border: 2px solid white ; position: fixed; width: 21% ; background: black; border-radius:17px;">
                        <div style="padding: 5px; text-align: center">
                            <b style="color: yellow ; text-align: center">ĐĂNG KÍ TƯ VẤN MIỄN PHÍ</b>
                        </div>
                        <div style="padding: 5px" class="form-floating mb-2">
                            <input type="text" class="form-control" placeholder="">
                            <label>Họ tên</label>
                        </div>
                        <div style="padding: 5px" class="form-floating mb-2">
                            <input type="number" class="form-control" placeholder="">
                            <label>Điện thoại</label>
                        </div>
                        <div style="padding: 5px" class="form-floating mb-2">
                            <input type="email" class="form-control" placeholder="">
                            <label>Email</label>
                        </div>
                        <div style="padding: 5px" class="form-floating mb-2">
                            <input type="text" class="form-control" placeholder="">
                            <label>Tin nhắn</label>
                        </div>
                        <div style="padding: 5px; text-align: center" class="form-floating mb-2">
                            <button class="button" style="width: 96% ; height: 50px; background-color: #FFFF66">Đăng kí
                            </button>
                        </div>
                    </form>
                </div>
            </aside>
        </div>

        <aside style="background-color: blue" class="sidebar-bottom">

        </aside>

        <footer class="footer">
            <section class="bg-light py-3 py-md-5 py-xl-8">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="container-fluid">
                                <div class="row gy-3 gy-md-4">
                                    <div class="col-12 col-lg-4">
                                        <div class="card border-dark">
                                            <div class="card-body p-3 p-md-4 p-xxl-5 d-flex justify-content-center align-items-center">
                                                <div class="me-3 text-primary">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48"
                                                         fill="currentColor" class="bi bi-basket2-fill" viewBox="0 0 16 16">
                                                        <path d="M5.929 1.757a.5.5 0 1 0-.858-.514L2.217 6H.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h.623l1.844 6.456A.75.75 0 0 0 3.69 15h8.622a.75.75 0 0 0 .722-.544L14.877 8h.623a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1.717L10.93 1.243a.5.5 0 1 0-.858.514L12.617 6H3.383zM4 10a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0zm3 0a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0zm4-1a1 1 0 0 1 1 1v2a1 1 0 1 1-2 0v-2a1 1 0 0 1 1-1"/>
                                                    </svg>
                                                </div>
                                                <div>
                                                    <h4 class="mb-1">Free Shipping</h4>
                                                    <p class="m-0 text-secondary">Eliminates shipping costs</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-lg-4">
                                        <div class="card border-dark">
                                            <div class="card-body p-3 p-md-4 p-xxl-5 d-flex justify-content-center align-items-center">
                                                <div class="me-3 text-primary">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48"
                                                         fill="currentColor" class="bi bi-chat-left-heart-fill"
                                                         viewBox="0 0 16 16">
                                                        <path d="M2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm6 3.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132"/>
                                                    </svg>
                                                </div>
                                                <div>
                                                    <h4 class="mb-1">24/7 Support</h4>
                                                    <p class="m-0 text-secondary">Better shopping experience</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-lg-4">
                                        <div class="card border-dark">
                                            <div class="card-body p-3 p-md-4 p-xxl-5 d-flex justify-content-center align-items-center">
                                                <div class="me-3 text-primary">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48"
                                                         fill="currentColor" class="bi bi-folder-symlink-fill"
                                                         viewBox="0 0 16 16">
                                                        <path d="M13.81 3H9.828a2 2 0 0 1-1.414-.586l-.828-.828A2 2 0 0 0 6.172 1H2.5a2 2 0 0 0-2 2l.04.87a2 2 0 0 0-.342 1.311l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3M2.19 3q-.362.002-.683.12L1.5 2.98a1 1 0 0 1 1-.98h3.672a1 1 0 0 1 .707.293L7.586 3zm9.608 5.271-3.182 1.97c-.27.166-.616-.036-.616-.372V9.1s-2.571-.3-4 2.4c.571-4.8 3.143-4.8 4-4.8v-.769c0-.336.346-.538.616-.371l3.182 1.969c.27.166.27.576 0 .742"/>
                                                    </svg>
                                                </div>
                                                <div>
                                                    <h4 class="mb-1">Free Returns</h4>
                                                    <p class="m-0 text-secondary">Customer's peace of mind</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </footer>
    </div>
    </body>
    </html>

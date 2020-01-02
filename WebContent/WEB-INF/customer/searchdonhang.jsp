<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="container">
    <h3>Tìm kiếm nâng cao</h3>
<section >
    <div class="container">
        <form action="searchdonhang" method="post" novalidate="novalidate">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <input type="text" name="ID_DH" class="form-control search-slt" placeholder="ID Đơn Hàng">
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <input type="tel" name="SDT_Nhan" class="form-control search-slt" placeholder="SĐT người nhận">
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <select name="Tinh_Trang" class="form-control search-slt" id="exampleFormControlSelect1">
                                <option value="">Chọn tình trạng</option>
                                <option value="1">Đang Xử Lý</option>
                                <option value="2">Đang Nhận</option>
                                <option value="3">Đang Giao</option>
                                <option value="4">Thành Công</option>
                                <option value="5">Hủy</option>
                            </select>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <button type="submit" value="submit" name="submit"  class="btn btn-danger wrn-btn">Search</button>
                        </div>
                        <!-- <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <input type="date" class="form-control search-slt" placeholder="">
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <input type="date" class="form-control search-slt" placeholder="  ">
                        </div> -->
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
</div>
CREATE DATABASE QLTV_Project1
GO
USE QLTV_Project1
GO
--
CREATE TABLE NguoiDung(
	MaND NVARCHAR(10) NOT NULL,
	MatKhau NVARCHAR(50) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	GioiTinh BIT DEFAULT 1, -- 1 là nam, 0 là nữ
	NgaySinh DATE NOT NULL,
	DienThoai NVARCHAR(10) NOT NULL,
	QueQuan NVARCHAR(50) NOT NULL,
	Luong MONEY DEFAULT -1,
	VaiTro BIT DEFAULT 0, --0 là nhân viên, 1 là trưởng phòng
	PRIMARY KEY (MaND)
)
--
CREATE TABLE DocGia
(
	MaDG nvarchar(7) primary key,
	HoTen nvarchar(100) not null,
	GioiTinh bit not null,
	DiaChi nvarchar(255) not null,
	SDT nvarchar(12) not null,
	Email nvarchar(100) not null
)
GO
--
CREATE TABLE LS
(
	MaLoai int identity(1,1) primary key,
	TenLoai nvarchar(50) not null,
	Vitri nvarchar(50) not null
)
GO
--
CREATE TABLE Sach
(
	MaSach int identity(1,1) primary key,
	TenSach nvarchar(50) not null,
	MaLoai int not null,
	TenNXB nvarchar(50) not null,
	TacGia nvarchar(50) not null,
	SoLuong int not null,
	NoiDung nvarchar(500) not null,
	Hinh nvarchar(50) not null
	FOREIGN KEY (MaLoai) REFERENCES LS (MaLoai) ON DELETE NO ACTION ON UPDATE CASCADE,
)
GO
--
CREATE TABLE PHIEUMUON
(
	MaPM int identity(1,1) primary key,
	MaDG nvarchar(7) not null,
	NgayMuon date not null,
	NgayTra date not null,
	MaND nvarchar(10) not null,
	TrangThai nvarchar(20) not null,
	GhiChu nvarchar(255) not null,
	FOREIGN KEY (MaDG) REFERENCES DOCGIA(MaDG) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaND) REFERENCES NGUOIDUNG(MaND) ON DELETE NO ACTION ON UPDATE CASCADE,
)
GO
--
CREATE TABLE CHITIETPM
(
	MaPM int not null,
	MaSach int not null,
	TrangThai nvarchar(20) not null,
	SoLuong int not null,
	GhiChu nvarchar(255) not null,
	primary key (MaSach,MaPM),
	FOREIGN KEY (MaSach) REFERENCES Sach(MaSach) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaPM) REFERENCES PHIEUMUON(MaPM) ON DELETE NO ACTION ON UPDATE CASCADE
)
GO
--

--CAU LENH SQL
INSERT INTO NguoiDung(MaND, MatKhau, HoTen,GioiTinh, NgaySinh, DienThoai, QueQuan,Luong, VaiTro)
			VALUES ('Lamnt', '123', N'Nguyễn Trung Lam',1 ,'2001/05/16', '0987654321', 'Quảng Ngãi',10000 ,0)
INSERT INTO NguoiDung(MaND, MatKhau, HoTen,GioiTinh, NgaySinh, DienThoai, QueQuan,Luong, VaiTro)
			VALUES ('GiangLT', '123', N'Lê Trường Giang',0 ,'2001/05/16', '0987654321', 'Quảng Trị',10000 ,1)
UPDATE NguoiDung SET MatKhau=1234, HoTen=N'Lê Trường Giang' , GioiTinh=2,NgaySinh='2001/05/16',DienThoai='0987654321',QueQuan='Quảng Trị',Luong=10000,VaiTro=0 WHERE MaND='GiangLT'
DELETE FROM NguoiDung WHERE MaND='GiangLT'
SELECT * FROM NguoiDung WHERE  MaND='GiangLT'
SELECT * FROM NguoiDung
--
INSERT DocGia (MaDG, HoTen, GioiTinh, SDT, Email, DiaChi) VALUES
	(N'PD12345', N'NGUYỄN TRUNG LAM', 0, N'0967432689', N'cuonghc@gmail.com', N'TKTQ Q.Bình Tân'),
	(N'PD12654', N'LÊ TRƯỜNG GIANG', 1, N'0123454656', N'phuocnc@gmail.com', N'Q.12'),
	(N'PD03596', N'VÕ BÁ PHÚ', 0, N'0924696779','hiennt@gmail.com', N'Bình Dương')
SELECT * FROM DocGia
UPDATE DocGia SET HoTen =N'VÕ BÁ PHÚ', GioiTinh = 1, SDT = N'0924696779', Email ='hiennt@gmail.com', DiaChi = N'Quảng Ngãi'WHERE MaDG = 'PD03596'
DELETE FROM DocGia WHERE MaDG = 'PD03596'
SELECT * FROM DocGia WHERE MaDG='PD03596'
--
SET IDENTITY_INSERT Sach ON
INSERT Sach(MaSach, TenSach, MaLoai,TenNXB,TacGia,SoLuong, NoiDung,Hinh) VALUES
	(14, N'Chiến Thuật Makerting',3,N'58 Quang Trung',N'Đình Văn', 9, N'Chiến Thuật Makerting', N'Chiến Thuật Makerting.jpg')

	UPDATE Sach SET TenSach='Việt Nam Hôm Nay',TenNXB='57 Quang Trung',SoLuong='3',NoiDung='Nội Dung về Pháp Luật Việt Nam',Hinh='Pháp Luật Viet Nam.jpg' WHERE MaSach='2'
	DELETE FROM SACH WHERE MaSach = '6'
	SELECT * FROM SACH WHERE MaSach='10'
	SELECT * FROM SACH
	select * from SACH where TenSach like'%C%'
--
SET IDENTITY_INSERT PHIEUMUON ON
GO
INSERT PHIEUMUON (MaPM, MaDG, NgayMuon, NgayTra, MaND, TrangThai, GhiChu) VALUES
	(8, N'PS045', '2020-09-01', '2020-09-15', N'GiangLT', N'Chưa trả', N'Chưa trả')
	INSERT PHIEUMUON (MaPM, MaDG, NgayMuon, NgayTra, MaND, TrangThai, GhiChu) VALUES
	(9, N'PS1234', '2020-09-20', '2020-09-30', N'Lamnt', N'Đã trả', N'Đã trả')
	INSERT PHIEUMUON (MaPM, MaDG, NgayMuon, NgayTra, MaND, TrangThai, GhiChu) VALUES
	(10, N'PS12345', '2020-10-10', '2020-10-15', N'PhuNM', N'Chưa Trả', N'Chưa Trả')
	INSERT PHIEUMUON (MaPM, MaDG, NgayMuon, NgayTra, MaND, TrangThai, GhiChu) VALUES
	(11, N'PS1245', '2020-10-20', '2020-10-30', N'SonDT', N'Đã Trả', N'Đã Trả')

GO
SET IDENTITY_INSERT PHIEUMUON OFF
GO
--
INSERT CHITIETPM (MaPM, MaSach, TrangThai, SoLuong, GhiChu) VALUES 
	(4, 4, N'Chưa trả', 2, N'Chưa trả')
GO
UPDATE ChiTietPM SET MaSach = 1, TrangThai = N'Đã Trả', SoLuong = 3, GhiChu = N'Đã Trả' WHERE MaPM = 1
select * from CHITIETPM
select top 3 TenSach, Sum(ct.SoLuong) as SL from CHITIETPM ct inner join SACH s on ct.MaSach = s.MaSach group by TenSach order by Sum(ct.SoLuong) desc
select count(MaSach) as MaSach,MONTH(NgayTra) as NM from CHITIETPM ct inner join  PHIEUMUON pm  on ct.MaPM = pm.MaPM where pm.GhiChu like N'%Quá hạn%' and Year(NgayTra) = 2021 group by MONTH(NgayTra)
--
SET IDENTITY_INSERT LS ON
INSERT Ls (MaLoai, TenLoai, ViTri) VALUES
	(1, N'Chính trị – pháp luật', N'Kệ 1'),
	(2, N'Truyện tranh', N'Kệ 2'),
	(3, N'Giáo trình', N'Kệ 3'),
	(4, N'Truyện ngắn', N'Kệ 4'),
	(5,N'Tâm lý - Kĩ năng sống',N'Kệ 2'),
	(6,N'Tiểu thuyết,Tiểu thuyết phiêu lưu',N'Kệ 4'),
	(7,N'Hư cấu kỳ ảo',N'Kệ 1')
GO
SET IDENTITY_INSERT LOAISACH OFF
GO
DELETE FROM LoaiSach WHERE MaLoai = 6;
UPDATE LoaiSach SET TenSach = N'CNTT Java6' , ViTri= N'Kệ 3' WHERE MaLoai = 12
SELECT * FROM LoaiSach WHERE MaLoai= 10
SELECT * FROM LoaiSach
--St1
CREATE PROC sp_PhieuMuon
AS BEGIN
	SELECT MaPM, pm.MaDG, HoTen, NgayMuon,NgayTra,TrangThai
	FROM PHIEUMUON pm inner join DocGia sv on pm.MaDG = sv.MaDG
END
GO
--
--st1
CREATE PROC sp_PhieuMuonDT
AS BEGIN
	SELECT MaPM, pm.MaDG, HoTen, NgayMuon,NgayTra,TrangThai
	FROM PHIEUMUON pm inner join DocGia sv on pm.MaDG = sv.MaDG
	where TrangThai like N'Đã trả'
END
GO
--st1
CREATE PROC sp_PhieuMuonCT
AS BEGIN
	SELECT MaPM, pm.MaDG, HoTen, NgayMuon,NgayTra,TrangThai
	FROM PHIEUMUON pm inner join DocGia sv on pm.MaDG = sv.MaDG
	where TrangThai like N'Chưa trả'
END
GO
--st1
CREATE PROC sp_NgayPM(@ngayBD varchar(50), @ngayKT varchar(50))
AS BEGIN 
 	SELECT MaPM, pm.MaDG, HoTen, NgayMuon,NgayTra,TrangThai
	FROM PHIEUMUON pm inner join DocGia sv on pm.MaDG = sv.MaDG
	where NgayMuon >= @ngayBD and NgayMuon <= @ngayKT
END 
go
--ST1
CREATE PROC sp_TopSachMuon
AS BEGIN 
	select top 3 s.MaSach,TenSach, Sum(ct.SoLuong) as SL from CHITIETPM ct 
	inner join PHIEUMUON pm on pm.MaPM = ct.MaPM
	inner join SACH s on ct.MaSach = s.MaSach 
	group by TenSach,s.MaSach order by Sum(ct.SoLuong) desc
END 
go
--
--
CREATE PROC sp_TopDGMuon
AS BEGIN 
	select top 3 pm.MaDG,HoTen,COUNT(pm.MaPM) as MaPM,COUNT(MaSach) as MaSach from PHIEUMUON pm 
	inner join DocGia sv on pm.MaDG = sv.MaDG
	inner join CHITIETPM ct on pm.MaPM = ct.MaPM
	group by pm.MaDG,HoTen
	order by COUNT(pm.MaPM) desc,COUNT(MaSach) desc
END 
go
--
CREATE PROC sp_SachMuon(@thang int, @nam int)
AS BEGIN 
	select top 3 s.MaSach,TenSach, Sum(ct.SoLuong) as SL from CHITIETPM ct 
	inner join SACH s on ct.MaSach = s.MaSach 
	inner join PHIEUMUON pm on pm.MaPM = ct.MaPM
	where MONTH(NgayMuon) = @thang and Year(NgayMuon) = @nam
	group by TenSach,s.MaSach order by Sum(ct.SoLuong) desc
END 
go
--
CREATE PROC sp_DGMuonSach(@thang int, @nam int)
AS BEGIN 
	select top 3 pm.MaDG,HoTen,COUNT(pm.MaPM) as MaPM,COUNT(MaSach) as MaSach from PHIEUMUON pm 
	inner join DocGia sv on pm.MaDG= sv.MaDG
	inner join CHITIETPM ct on pm.MaPM = ct.MaPM
	where MONTH(NgayMuon) = @thang and Year(NgayMuon) = @nam
	group by pm.MaDG,HoTen
	order by COUNT(pm.MaPM) desc,COUNT(MaSach) desc
END 
go
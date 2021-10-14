Create table KhachHang
(   
    maKH int GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    tenKH varchar2(30),
    cccdKH varchar2(30),
    sdtKH varchar2(30),
    diaChiKH varchar2(30),
    gioiTinhKH varchar2(30),
    ngaySinhKH date,
    quocTich varchar2(30),
    maLKH int GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    primary key (maKH)
);

INSERT INTO KhachHang(tenKH, cccdKH, sdtKH, diaChiKH ,gioiTinhKH , ngaySinhKH, quocTich ) VALUES 
('Toan', '123', '0934189092', 'Phuong 13 Quan 10' , 'Nam', '30-03-2000', 'VietNam');
INSERT INTO KhachHang (tenKH, cccdKH, sdtKH, diaChiKH ,gioiTinhKH , ngaySinhKH, quocTich) VALUES 
('Toan1', '1234', '0934189092', 'Phuong 13 Quan 10' , 'Nam', '30-03-2000', 'VietNam');
INSERT INTO KhachHang (tenKH, cccdKH, sdtKH, diaChiKH ,gioiTinhKH , ngaySinhKH, quocTich ) VALUES 
('UIT', '12345', '0934189092', 'Phuong 13 Quan 10' , 'Nam', '30-03-2000', 'VietNam');

delete from khachhang
select * from KhachHang
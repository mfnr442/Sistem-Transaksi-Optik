create tablespace M_FARKHAN_07078
datafile 'D:\KULIAH\Farkhan\basdat\modul1\praktikum\M_FARKHAN_07078.DBF'
size 30M;

create user M_FARKHAN_07078
IDENTIFIED BY FARKHAN
DEFAULT TABLESPACE M_FARKHAN_07078
QUOTA 30M ON M_FARKHAN_07078;

GRANT ALL PRIVILEGES TO M_FARKHAN_07078;

CONN M_FARKHAN_07078/FARKHAN;

create table Admin
(
Username VARCHAR2(15) not null,
Password VARCHAR2(15),
constraint PK_Admin primary key
(Username)
);

create table Karyawan
(
ID_karyawan INTEGER not null,
ID_transaksi INTEGER,
Nama_karyawan VARCHAR2(25),
constraint PK_Karyawan primary key
(ID_karyawan)
);

create table Transaksi
(
ID_transaksi INTEGER not null,
No_telp VARCHAR2(15),
ID_karyawan INTEGER,
Tanggal_pembelian DATE,
constraint PK_Transaksi primary key
(ID_transaksi)
);

create table Produk
(
ID_produk INTEGER not null,
Username VARCHAR2(16),
Merk VARCHAR2(20),
Jenis VARCHAR2(20),
Harga_satuan INTEGER,
constraint PK_Produk primary key
(ID_produk)
);

create table Pembeli
(
No_telp VARCHAR2(15) not null,
nama_pembeli VARCHAR2(25),
Jenis_kelamin CHAR(1),
constraint PK_Pembeli primary key
(No_telp)
);

create table Detail_transaksi
(
Jumlah_produk INTEGER,
Id_transaksi INTEGER,
Id_produk INTEGER
);

alter table Karyawan
add constraint FK_ID_transaksi foreign
key (ID_transaksi)
references Transaksi(ID_transaksi);

alter table Produk
add constraint FK_Username foreign key
(Username)
references Admin(Username);

alter table Transaksi
add constraint FK_No_telp foreign key
(No_telp)
references Pembeli(No_telp),
add constraint FK_Id_karyawan foreign key
(Id_karyawan)
references Karyawan(Id_karyawan);

alter table Detail_transaksi
add constraint FK_Id_karyawan foreign key
(Id_karyawan)
references Karyawan(Id_karyawan),
add constraint FK_Id_produk foreign key
(Id_produk)
references Produk(Id_produk);

insert into Admin values ('Farkhan', '1234');

insert into Produk values
(1, 'Farkhan', 'Red', 'Lensa', 10000);

insert into Produk values
(2, 'Farkhan', 'Blue','Lensa' , 20000);

insert all
into Pembeli values ('1111', 'Bayu', 'L')
into Pembeli values ('2222', 'Ilham', 'L')
into Pembeli values ('3333', 'Azrul', 'L')
into Pembeli values ('4444', 'Siska', 'P')
into Pembeli values ('5555', 'Siti', 'P')
select 1 from dual;

create sequence forId
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;



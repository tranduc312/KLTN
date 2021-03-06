USE [GiaoHang]
GO
/****** Object:  User [sa1]    Script Date: 12/26/2019 8:03:34 PM ******/
CREATE USER [sa1] FOR LOGIN [sa1] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[CTGD]    Script Date: 12/26/2019 8:03:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTGD](
	[ID_GD] [int] NOT NULL,
	[ID_DH] [int] NOT NULL,
 CONSTRAINT [PK_CTGD] PRIMARY KEY CLUSTERED 
(
	[ID_GD] ASC,
	[ID_DH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Don_Hang]    Script Date: 12/26/2019 8:03:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Don_Hang](
	[ID_DH] [int] IDENTITY(1,1) NOT NULL,
	[ID_Shop] [int] NOT NULL,
	[Ten_Nguoi_Nhan] [nvarchar](50) NOT NULL,
	[SDT_Nhan] [nvarchar](50) NOT NULL,
	[DC_Nhan] [nvarchar](50) NOT NULL,
	[Khoi_Luong] [int] NOT NULL,
	[Cao] [int] NOT NULL,
	[Rong] [int] NOT NULL,
	[Ngay_Lap] [datetime] NOT NULL,
	[Tien_Thu_Ho] [int] NOT NULL,
	[Cuoc_Phi] [int] NULL,
	[Tinh_Trang] [int] NULL,
 CONSTRAINT [PK_Don_Hang] PRIMARY KEY CLUSTERED 
(
	[ID_DH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Giao_Dich]    Script Date: 12/26/2019 8:03:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Giao_Dich](
	[ID_GD] [int] IDENTITY(1,1) NOT NULL,
	[ID_User] [int] NOT NULL,
	[ID_Shop] [int] NOT NULL,
	[Ngay_Tra] [datetime] NOT NULL,
 CONSTRAINT [PK_Giao_Dịc] PRIMARY KEY CLUSTERED 
(
	[ID_GD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Giao_Hang]    Script Date: 12/26/2019 8:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Giao_Hang](
	[ID_GH] [int] IDENTITY(1,1) NOT NULL,
	[ID_User] [int] NOT NULL,
	[ID_DH] [int] NOT NULL,
	[Ngay_Giao] [datetime] NOT NULL,
 CONSTRAINT [PK_Giao_Hang] PRIMARY KEY CLUSTERED 
(
	[ID_GH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Kho]    Script Date: 12/26/2019 8:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kho](
	[ID_Kho] [int] IDENTITY(1,1) NOT NULL,
	[Ten_Kho] [nvarchar](30) NOT NULL,
	[Dia_Chi] [nvarchar](50) NULL,
 CONSTRAINT [PK_Kho] PRIMARY KEY CLUSTERED 
(
	[ID_Kho] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lay_Hang]    Script Date: 12/26/2019 8:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lay_Hang](
	[ID_LH] [int] IDENTITY(1,1) NOT NULL,
	[ID_User] [int] NOT NULL,
	[Ngay_Lay] [datetime] NOT NULL,
	[ID_Kho] [int] NOT NULL,
	[ID_DH] [int] NULL,
 CONSTRAINT [PK_Lay_Hang] PRIMARY KEY CLUSTERED 
(
	[ID_LH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shop]    Script Date: 12/26/2019 8:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shop](
	[ID_Shop] [int] IDENTITY(1,1) NOT NULL,
	[Ten_Shop] [nvarchar](30) NOT NULL,
	[Dia_Chi] [nvarchar](50) NOT NULL,
	[ID_User] [int] NOT NULL,
	[SDT] [nvarchar](15) NULL,
	[Trang_Thai] [bit] NULL,
 CONSTRAINT [PK_Shop] PRIMARY KEY CLUSTERED 
(
	[ID_Shop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 12/26/2019 8:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[ID_User] [int] IDENTITY(1,1) NOT NULL,
	[Ten_User] [nvarchar](30) NOT NULL,
	[Mat_Khau] [nvarchar](30) NOT NULL,
	[SDT] [nvarchar](15) NOT NULL,
	[Email] [nvarchar](30) NULL,
	[Dia_Chi] [nvarchar](50) NULL,
	[ID_Role] [int] NOT NULL,
	[ID_Kho] [int] NULL,
	[Trang_Thai] [bit] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[ID_User] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vai_Tro]    Script Date: 12/26/2019 8:03:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vai_Tro](
	[ID_Role] [int] IDENTITY(1,1) NOT NULL,
	[Vai_Tro] [nvarchar](30) NULL,
 CONSTRAINT [PK_Vai_Tro] PRIMARY KEY CLUSTERED 
(
	[ID_Role] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CTGD] ([ID_GD], [ID_DH]) VALUES (2, 1003)
INSERT [dbo].[CTGD] ([ID_GD], [ID_DH]) VALUES (2, 1010)
INSERT [dbo].[CTGD] ([ID_GD], [ID_DH]) VALUES (11, 1011)
INSERT [dbo].[CTGD] ([ID_GD], [ID_DH]) VALUES (11, 1012)
SET IDENTITY_INSERT [dbo].[Don_Hang] ON 

INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1, 1, N'Đức', N'0774568406', N'Quảng Nam', 1, 10, 5, CAST(N'2019-10-15T12:00:00.000' AS DateTime), 10000, 30000, 5)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (2, 1, N'Nguyễn Tấn Dũng', N'0774568406', N'Đông Nam Bộ', 1, 5, 10, CAST(N'2019-10-31T15:00:00.000' AS DateTime), 20000, 30000, 2)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (3, 1, N'Nguyễn Minh Triết', N'0774568406', N'Hà Nội', 2, 5, 10, CAST(N'2019-10-31T17:00:00.000' AS DateTime), 15000, 30000, 3)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (4, 2, N'Nguyễn Xuân Phúc', N'0774568406', N'Quảng Nam', 3, 5, 10, CAST(N'2019-10-31T20:00:00.000' AS DateTime), 30000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1002, 1, N'Nguyễn Phú Trọng', N'774568406', N'Bắc Giang', 3, 5, 10, CAST(N'2019-11-02T20:00:00.000' AS DateTime), 20000, 30000, 1)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1003, 1, N'Lê Duẩn', N'774568406', N'Việt Nam', 5, 5, 10, CAST(N'2019-11-03T20:00:00.000' AS DateTime), 20000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1004, 1, N'David', N'774568406', N'Tây Ban Nha', 4, 4, 10, CAST(N'2019-11-03T22:00:00.000' AS DateTime), 15000, 30000, 3)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1005, 1, N'Leo', N'774568406', N'American', 4, 4, 10, CAST(N'2019-11-03T22:00:00.000' AS DateTime), 15000, 30000, 3)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1006, 1, N'Peter', N'774568406', N'Anh', 4, 4, 10, CAST(N'2019-11-05T10:00:00.000' AS DateTime), 12000, 30000, 2)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1007, 1, N'Leona', N'774568406', N'LOL', 4, 4, 10, CAST(N'2019-11-04T22:00:00.000' AS DateTime), 25000, 30000, 1)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1008, 2, N'Trump', N'774568406', N'Nhà Trắng', 10, 10, 10, CAST(N'2019-11-04T19:00:00.000' AS DateTime), 20000, 30000, 3)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1009, 2, N'C50', N'0774568406', N'Hà Nội', 10, 10, 10, CAST(N'2019-12-03T00:00:00.000' AS DateTime), 20000, 30000, 1)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1010, 1, N'Trần Văn A', N'19001080', N'Huế', 5, 5, 10, CAST(N'2019-10-31T20:00:00.000' AS DateTime), 50000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1011, 1, N'Trần Văn B', N'19001080', N'Huế', 6, 14, 10, CAST(N'2019-12-03T20:00:00.000' AS DateTime), 3000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1012, 1, N'Trần Văn C', N'19001080', N'Huế', 7, 13, 10, CAST(N'2019-12-01T20:00:00.000' AS DateTime), 10000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1013, 1, N'Trần Văn D', N'19001080', N'Huế', 8, 12, 10, CAST(N'2019-12-04T20:00:00.000' AS DateTime), 20000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1014, 1, N'Trần Văn E', N'19001080', N'Huế', 9, 11, 10, CAST(N'2019-12-20T20:00:00.000' AS DateTime), 40000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1015, 1, N'Trần Văn F', N'19001080', N'Huế', 10, 10, 10, CAST(N'2019-12-21T20:00:00.000' AS DateTime), 50000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1016, 1, N'Trần Văn G', N'19001080', N'Huế', 11, 9, 10, CAST(N'2019-12-20T20:00:00.000' AS DateTime), 60000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1017, 1, N'Trần Văn H', N'19001080', N'Huế', 12, 8, 10, CAST(N'2019-12-20T20:00:00.000' AS DateTime), 35000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1018, 1, N'Trần Văn J', N'19001080', N'Huế', 13, 7, 10, CAST(N'2019-12-24T20:00:00.000' AS DateTime), 20000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1019, 1, N'Trần Văn K', N'19001080', N'Huế', 14, 6, 10, CAST(N'2019-12-25T20:00:00.000' AS DateTime), 50000, 30000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1020, 1, N'Min', N'0774568406', N'Huế', 2, 4, 7, CAST(N'2019-12-19T17:59:39.820' AS DateTime), 15000, 20000, 4)
INSERT [dbo].[Don_Hang] ([ID_DH], [ID_Shop], [Ten_Nguoi_Nhan], [SDT_Nhan], [DC_Nhan], [Khoi_Luong], [Cao], [Rong], [Ngay_Lap], [Tien_Thu_Ho], [Cuoc_Phi], [Tinh_Trang]) VALUES (1021, 4, N'AQÙAINA', N'8934588063060', N'PESI', 10, 10, 12, CAST(N'2019-12-19T18:22:32.220' AS DateTime), 100000, 20000, 1)
SET IDENTITY_INSERT [dbo].[Don_Hang] OFF
SET IDENTITY_INSERT [dbo].[Giao_Dich] ON 

INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (2, 1, 1, CAST(N'2019-12-20T20:00:00.000' AS DateTime))
INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (3, 1, 1, CAST(N'2019-12-21T18:05:11.290' AS DateTime))
INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (4, 1, 1, CAST(N'2019-12-21T18:07:30.247' AS DateTime))
INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (5, 1, 1, CAST(N'2019-12-21T18:08:11.367' AS DateTime))
INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (6, 1, 1, CAST(N'2019-12-21T22:15:56.420' AS DateTime))
INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (7, 1, 1, CAST(N'2019-12-21T22:22:46.330' AS DateTime))
INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (8, 2, 1, CAST(N'2019-12-22T10:33:15.907' AS DateTime))
INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (9, 1, 1, CAST(N'2019-12-22T10:36:23.980' AS DateTime))
INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (10, 2, 1, CAST(N'2019-12-22T10:40:59.823' AS DateTime))
INSERT [dbo].[Giao_Dich] ([ID_GD], [ID_User], [ID_Shop], [Ngay_Tra]) VALUES (11, 1, 1, CAST(N'2019-12-22T12:18:06.693' AS DateTime))
SET IDENTITY_INSERT [dbo].[Giao_Dich] OFF
SET IDENTITY_INSERT [dbo].[Giao_Hang] ON 

INSERT [dbo].[Giao_Hang] ([ID_GH], [ID_User], [ID_DH], [Ngay_Giao]) VALUES (2, 4, 3, CAST(N'2019-10-15T15:00:00.000' AS DateTime))
INSERT [dbo].[Giao_Hang] ([ID_GH], [ID_User], [ID_DH], [Ngay_Giao]) VALUES (8, 7, 1004, CAST(N'2019-11-03T00:00:00.000' AS DateTime))
INSERT [dbo].[Giao_Hang] ([ID_GH], [ID_User], [ID_DH], [Ngay_Giao]) VALUES (9, 7, 1005, CAST(N'2019-11-02T00:00:00.000' AS DateTime))
INSERT [dbo].[Giao_Hang] ([ID_GH], [ID_User], [ID_DH], [Ngay_Giao]) VALUES (1003, 6, 1008, CAST(N'2019-11-16T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Giao_Hang] OFF
SET IDENTITY_INSERT [dbo].[Kho] ON 

INSERT [dbo].[Kho] ([ID_Kho], [Ten_Kho], [Dia_Chi]) VALUES (1, N'Huế', N'An cựu, Huế')
SET IDENTITY_INSERT [dbo].[Kho] OFF
SET IDENTITY_INSERT [dbo].[Lay_Hang] ON 

INSERT [dbo].[Lay_Hang] ([ID_LH], [ID_User], [Ngay_Lay], [ID_Kho], [ID_DH]) VALUES (1, 5, CAST(N'2019-12-10T00:00:00.000' AS DateTime), 1, 1)
INSERT [dbo].[Lay_Hang] ([ID_LH], [ID_User], [Ngay_Lay], [ID_Kho], [ID_DH]) VALUES (2, 4, CAST(N'2019-12-03T00:00:00.000' AS DateTime), 1, 1006)
INSERT [dbo].[Lay_Hang] ([ID_LH], [ID_User], [Ngay_Lay], [ID_Kho], [ID_DH]) VALUES (1002, 15, CAST(N'2019-11-13T00:00:00.000' AS DateTime), 1, 1008)
SET IDENTITY_INSERT [dbo].[Lay_Hang] OFF
SET IDENTITY_INSERT [dbo].[Shop] ON 

INSERT [dbo].[Shop] ([ID_Shop], [Ten_Shop], [Dia_Chi], [ID_User], [SDT], [Trang_Thai]) VALUES (1, N'Mina', N'1 Hồ Đắc Di, An Cựu, Huế', 2, N'0774568406', 0)
INSERT [dbo].[Shop] ([ID_Shop], [Ten_Shop], [Dia_Chi], [ID_User], [SDT], [Trang_Thai]) VALUES (2, N'Tadyyy', N'469 An Dương Vương', 3, N'0774568406', 0)
INSERT [dbo].[Shop] ([ID_Shop], [Ten_Shop], [Dia_Chi], [ID_User], [SDT], [Trang_Thai]) VALUES (4, N'ZARA', N'Huế', 2, N'0774568406', 0)
INSERT [dbo].[Shop] ([ID_Shop], [Ten_Shop], [Dia_Chi], [ID_User], [SDT], [Trang_Thai]) VALUES (5, N'Xiaomi', N'Trung Quốc', 2, N'0775678406', 1)
SET IDENTITY_INSERT [dbo].[Shop] OFF
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (1, N'Duc', N'123', N'0774568406', N'tranvanduc@gmail.com', N'Quảng Nam', 1, NULL, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (2, N'An', N'123', N'774568407', N'an@gmail.com', N'Quảng Trị', 2, NULL, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (3, N'Binh', N'123', N'0774568408', N'binh@gmail.com', N'Đà Nẵng', 2, NULL, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (4, N'Cuong', N'123', N'0774568409', N'cuong@gmail.com', N'Quảng Nam', 3, 1, 1)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (5, N'Dat', N'123', N'0774568400', N'dat@gmail.com', N'Huế', 3, 1, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (6, N'En', N'123', N'0774568401', N'en@gmail.com', N'Quảng Trị', 4, 1, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (7, N'Ha', N'123', N'0774568402', N'ha@gmail.com', N'Quảng Bình', 4, 1, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (8, N'Hương', N'null', N'0774568403', N'huong@gmail.com', N'Thanh Hóa', 5, 1, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (9, N'Ken', N'123', N'123456789', N'ken@gmail.com', N'Đà Nẵng', 2, NULL, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (11, N'Lien', N'123', N'0123456789', N'lien@gmail.com', N'Hà nội', 2, NULL, 1)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (15, N'Lê Duẫn', N'null', N'0774568406', N'dung@gmail.com', N'Thừa Thiên Huế', 3, 1, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (18, N'Aquafina', N'123', N'19001080', N'aqua@gmail.com', N'PESI', 2, NULL, 0)
INSERT [dbo].[User] ([ID_User], [Ten_User], [Mat_Khau], [SDT], [Email], [Dia_Chi], [ID_Role], [ID_Kho], [Trang_Thai]) VALUES (19, N'SaiGon', N'123', N'19001080', N'saigon@gmail.com', N'SaiGon', 2, NULL, 0)
SET IDENTITY_INSERT [dbo].[User] OFF
SET IDENTITY_INSERT [dbo].[Vai_Tro] ON 

INSERT [dbo].[Vai_Tro] ([ID_Role], [Vai_Tro]) VALUES (1, N'Admin')
INSERT [dbo].[Vai_Tro] ([ID_Role], [Vai_Tro]) VALUES (2, N'Shop')
INSERT [dbo].[Vai_Tro] ([ID_Role], [Vai_Tro]) VALUES (3, N'NV_Shipper')
INSERT [dbo].[Vai_Tro] ([ID_Role], [Vai_Tro]) VALUES (4, N'NV_Kho')
INSERT [dbo].[Vai_Tro] ([ID_Role], [Vai_Tro]) VALUES (5, N'NV_KT')
SET IDENTITY_INSERT [dbo].[Vai_Tro] OFF
ALTER TABLE [dbo].[CTGD]  WITH CHECK ADD  CONSTRAINT [FK_CTGD_Don_Hang] FOREIGN KEY([ID_DH])
REFERENCES [dbo].[Don_Hang] ([ID_DH])
GO
ALTER TABLE [dbo].[CTGD] CHECK CONSTRAINT [FK_CTGD_Don_Hang]
GO
ALTER TABLE [dbo].[CTGD]  WITH CHECK ADD  CONSTRAINT [FK_CTGD_Giao_Dich] FOREIGN KEY([ID_GD])
REFERENCES [dbo].[Giao_Dich] ([ID_GD])
GO
ALTER TABLE [dbo].[CTGD] CHECK CONSTRAINT [FK_CTGD_Giao_Dich]
GO
ALTER TABLE [dbo].[Don_Hang]  WITH CHECK ADD  CONSTRAINT [FK_Don_Hang_Shop] FOREIGN KEY([ID_Shop])
REFERENCES [dbo].[Shop] ([ID_Shop])
GO
ALTER TABLE [dbo].[Don_Hang] CHECK CONSTRAINT [FK_Don_Hang_Shop]
GO
ALTER TABLE [dbo].[Giao_Dich]  WITH CHECK ADD  CONSTRAINT [FK_Giao_Dich_Shop] FOREIGN KEY([ID_Shop])
REFERENCES [dbo].[Shop] ([ID_Shop])
GO
ALTER TABLE [dbo].[Giao_Dich] CHECK CONSTRAINT [FK_Giao_Dich_Shop]
GO
ALTER TABLE [dbo].[Giao_Dich]  WITH CHECK ADD  CONSTRAINT [FK_Giao_Dich_User] FOREIGN KEY([ID_User])
REFERENCES [dbo].[User] ([ID_User])
GO
ALTER TABLE [dbo].[Giao_Dich] CHECK CONSTRAINT [FK_Giao_Dich_User]
GO
ALTER TABLE [dbo].[Giao_Hang]  WITH CHECK ADD  CONSTRAINT [FK_Giao_Hang_Don_Hang] FOREIGN KEY([ID_DH])
REFERENCES [dbo].[Don_Hang] ([ID_DH])
GO
ALTER TABLE [dbo].[Giao_Hang] CHECK CONSTRAINT [FK_Giao_Hang_Don_Hang]
GO
ALTER TABLE [dbo].[Giao_Hang]  WITH CHECK ADD  CONSTRAINT [FK_Giao_Hang_User] FOREIGN KEY([ID_User])
REFERENCES [dbo].[User] ([ID_User])
GO
ALTER TABLE [dbo].[Giao_Hang] CHECK CONSTRAINT [FK_Giao_Hang_User]
GO
ALTER TABLE [dbo].[Lay_Hang]  WITH CHECK ADD  CONSTRAINT [FK_Lay_Hang_Don_Hang] FOREIGN KEY([ID_DH])
REFERENCES [dbo].[Don_Hang] ([ID_DH])
GO
ALTER TABLE [dbo].[Lay_Hang] CHECK CONSTRAINT [FK_Lay_Hang_Don_Hang]
GO
ALTER TABLE [dbo].[Lay_Hang]  WITH CHECK ADD  CONSTRAINT [FK_Lay_Hang_Kho] FOREIGN KEY([ID_Kho])
REFERENCES [dbo].[Kho] ([ID_Kho])
GO
ALTER TABLE [dbo].[Lay_Hang] CHECK CONSTRAINT [FK_Lay_Hang_Kho]
GO
ALTER TABLE [dbo].[Lay_Hang]  WITH CHECK ADD  CONSTRAINT [FK_Lay_Hang_User] FOREIGN KEY([ID_User])
REFERENCES [dbo].[User] ([ID_User])
GO
ALTER TABLE [dbo].[Lay_Hang] CHECK CONSTRAINT [FK_Lay_Hang_User]
GO
ALTER TABLE [dbo].[Shop]  WITH CHECK ADD  CONSTRAINT [FK_Shop_User] FOREIGN KEY([ID_User])
REFERENCES [dbo].[User] ([ID_User])
GO
ALTER TABLE [dbo].[Shop] CHECK CONSTRAINT [FK_Shop_User]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Kho] FOREIGN KEY([ID_Kho])
REFERENCES [dbo].[Kho] ([ID_Kho])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Kho]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Vai_Tro] FOREIGN KEY([ID_Role])
REFERENCES [dbo].[Vai_Tro] ([ID_Role])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Vai_Tro]
GO

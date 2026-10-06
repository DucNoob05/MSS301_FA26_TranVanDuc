# FUCinemaBookingSystem – Cinema Ticket Booking System using API Gateway

> **Công nghệ:** Java 21 · Spring Boot **4.1.0** · Spring Cloud **2025.1.3** · **SQL Server 2022 · MongoDB 7.0.5 · MySQL 8.3.0** (Docker) · Postman

---

## 1. Kiến trúc hệ thống

Hệ thống được xây dựng theo kiến trúc Microservices gồm API Gateway và 3 dịch vụ độc lập:

| Service | Port | Database | Công nghệ & Vai trò |
|---|---|---|---|
| **`api-gateway`** | **9000** | — | Single Entry Point, Spring Cloud Gateway (MVC), OAuth2 Resource Server verify Bearer JWT (HS256), inject headers `X-User-Id`, `X-User-Email`, `X-User-Role` |
| **`customer-service`** | **8081** | **SQL Server 2022** (`cinema_customer`) | Xác thực (Admin/Customer), cấp phát JWT, CRUD khách hàng, đổi mật khẩu BCrypt, hỗ trợ Unicode NVARCHAR tiếng Việt (BR16) |
| **`movie-service`** | **8082** | **MongoDB 7.0.5** (`cinema_movie`) | Quản lý thể loại, phòng chiếu, phim, suất chiếu; tính giờ kết thúc `endTime`, validate trùng lịch chiếu, lưu giá `Decimal128` |
| **`booking-service`** | **8083** | **MySQL 8.3.0** (`cinema_booking`) | Gọi trực tiếp `movie-service` qua **OpenFeign** (`GET /api/showtimes/{id}`), quản lý sơ đồ ghế, đặt vé (1–8 vé), chống trùng ghế (BR09), snapshot thông tin phim, hủy vé trước 2h, thống kê doanh thu |

---

## 2. Tài khoản kiểm thử

| Vai trò | Email | Mật khẩu | Ghi chú |
|---|---|---|---|
| **Admin** | `admin@fucinema.com` | `@@abc123@@` | Lưu trong `application.properties` của customer-service |
| **Customer** | `an@gmail.com` | `123456` | Khách hàng mẫu `ACTIVE` (`userId = 1`) |
| **Customer** | `binh@gmail.com` | `123456` | Khách hàng mẫu `ACTIVE` (`userId = 2`) |
| **Customer (Inactive)** | `chi@gmail.com` | `123456` | Khách hàng `INACTIVE` (`userId = 3`) – cấm đăng nhập (403) |

---

## 3. Hướng dẫn khởi chạy hệ thống

### Bước 1: Khởi động 3 Database bằng Docker Compose
```bash
cd fu-cinema
docker compose up -d
```
Đảm bảo 3 container đang chạy bình thường:
- `cinema-sqlserver` (Port 1433)
- `cinema-mongo` (Port 27017)
- `cinema-mysql` (Port 3306)

### Bước 2: Khởi động 4 Microservices (Theo thứ tự)

Mở 4 terminal riêng biệt (hoặc run trong IDE):

1. **Terminal 1 – Customer Service (8081):**
   ```bash
   cd fu-cinema/customer-service
   mvn spring-boot:run
   ```
2. **Terminal 2 – Movie Service (8082):**
   ```bash
   cd fu-cinema/movie-service
   mvn spring-boot:run
   ```
3. **Terminal 3 – Booking Service (8083):**
   ```bash
   cd fu-cinema/booking-service
   mvn spring-boot:run
   ```
4. **Terminal 4 – API Gateway (9000):**
   ```bash
   cd fu-cinema/api-gateway
   mvn spring-boot:run
   ```

---

## 4. Kiểm thử với Postman

Thư mục `fu-cinema/postman/` chứa đầy đủ collection và environment:
- `FUCinema-Local.postman_environment.json`: Environment biến môi trường (Gateway `http://localhost:9000`, tokens, sample IDs).
- `FUCinemaBookingSystem.postman_collection.json`: Collection với 8 folder (từ F1 đến F10).

### Chạy Collection Runner:
1. Mở Postman Desktop → Import cả 2 file trong `fu-cinema/postman/`.
2. Chọn Environment **`FUCinema-Local`**.
3. Chuột phải Collection `FUCinemaBookingSystem` → chọn **Run collection**.
4. Giữ nguyên thứ tự folder từ `01-Auth` đến `08-Report` và nhấn **Run FUCinemaBookingSystem**.
5. Kết quả: **216 / 216 Tests Passed (100% Passed)**.

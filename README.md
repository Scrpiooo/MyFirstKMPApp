# MyFirstKMPApp

## Identitas
Nama: Fadilla<br>
NIM: 124140136

## Screenshot
### Screenshot Dekstop
![Screenshot Dekstop](Screenshot%20Dekstop.png)

### Screenshot Android
![Screenshot Android](Screenshot%20Android.png)

## News Feed Simulator

Aplikasi News Feed Simulator menggunakan Kotlin Multiplatform untuk menerapkan konsep Coroutines, Flow, dan StateFlow.

### Fitur
- Flow untuk mensimulasikan data berita setiap 2 detik.
- Filter berita berdasarkan kategori.
- Transformasi data menggunakan `map`.
- StateFlow untuk menghitung jumlah berita yang dibaca.
- `async/await` untuk mengambil detail berita secara asynchronous.
- Error handling menggunakan `.catch` dan `try-catch`.
- Unit test untuk Flow dan Coroutine.

### Cara Menjalankan
1. Buka project `MyFirstKMPApp` di Android Studio.
2. Tunggu Gradle selesai melakukan sync.
3. Pilih target Android atau Desktop.
4. Jalankan aplikasi dengan tombol Run.

### Unit Test
Unit test terdapat pada:

`shared/src/commonTest/kotlin/org/example/project/NewsFeedTest.kt`

Untuk menjalankan unit test pada Windows:

```bash
.\gradlew.bat :shared:jvmTest
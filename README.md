# 🎮 CyberQuest: Istanbul 2081

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" alt="Java">
  <img src="https://img.shields.io/badge/License-MIT-blue?style=for-the-badge" alt="MIT License">
  <img src="https://img.shields.io/badge/Architecture-OOP%20%2F%20Clean%20Code-green?style=for-the-badge" alt="OOP">
</p>

---

## 🇹🇷 Mimari Yapı ve Proje Dokümantasyonu

### 📌 Proje Genel Bakış
**CyberQuest**, siberpunk tabanlı bir evrende geçen, metin arayüzlü ve olay güdümlü (event-driven) bir simülasyon/RPG motorudur. Bu projenin temel amacı, Java dilinin çekirdek mekanizmalarını kullanarak harici kütüphanelere bağımlı olmaksızın ölçeklenebilir (scalable), hafif ve yüksek performanslı bir oyun döngüsü mimarisi inşa etmektir.

### 🧱 Sistem Mimarisi (Separation of Concerns)
Proje, sorumlulukların tamamen ayrılması prensibine dayanarak katmanlı bir yapıda tasarlanmıştır:
* **`Character.java` (State & Model Layer):** Oyuncu metriklerini, envanter indekslerini ve karakter durumunu yönetir.
* **`Enemy.java` (Model Layer):** Dinamik tehdit unsurlarının ömür döngüsünü (lifecycle) ve hasar katsayılarını tutar.
* **`StoryEngine.java` (Business Logic Layer):** Savaş döngülerini, kullanıcı girdi yönetimini (`Scanner`) ve senaryo akışını kontrol eden ana orkestrasyon katmanıdır.

### 🛠️ Teknik Başarılar ve Tasarım Örüntüleri
* **Veri Kapsülleme ve Bütünlük (Data Encapsulation):** Tüm sınıflarda durum değişkenleri `private` olarak izole edilmiş, iş kuralları (Örn: Sağlık değerinin eksiye düşmemesi, negatif para girişinin engellenmesi) doğrudan kapsüllenmiş metotlar üzerinden valide edilmiştir.
* **Bellek Dostu Sabit Dizi Manipülasyonu:** `ArrayList` gibi dinamik koleksiyon yüklerinden kaçınılarak, sabit boyutlu Java dizileri (Array) üzerinde doğrusal arama (linear search) algoritmalarıyla bellek optimizasyonlu bir envanter yönetim sistemi simüle edilmiştir.
* **Mantıksal Güvenlik ve Durum Kilitleme (Exploit Prevention):** Savaş mekaniği içerisinde çalışma zamanı (runtime) açıklarını önlemek adına `isWeaponEquipped` bayrağı entegre edilmiş, böylece "sonsuz hasar artışı" (infinite damage stacking) mantık hatası mimari seviyede engellenmiştir.

---

## 🇬🇧 Architectural Design & Technical Documentation

### 📌 Project Overview
**CyberQuest** is a text-based, event-driven interactive simulation engine set in a dystopian future. The core objective of this project is to implement a scalable, lightweight, and high-performance game loop using native Java specifications, entirely free from external framework overhead.

### 🧱 Architectural Separation (Separation of Concerns)
The codebase strictly adheres to modular design patterns by isolating distinct domain responsibilities:
* **`Character.java` (State & Model Layer):** Governs player metrics, inventory mapping, and entity state mutations.
* **`Enemy.java` (Model Layer):** Models active threat entities, their lifecycles, and baseline damage matrices.
* **`StoryEngine.java` (Business Logic Layer):** Orchestrates transaction logs, runtime user input routing (`Scanner`), and the core combat state machine.

### 🛠️ Technical Implementation Details
* **Strict Data Encapsulation:** Zero direct access to entity states is permitted. Mutation boundaries are guarded via validation logic within setters (e.g., preventing out-of-bounds metrics and structural integrity validation for health counters).
* **Memory-Optimized Native Arrays:** Bypassed Java Collections API framework overhead by deploying explicit linear search optimization over fixed-size native Java arrays to handle inventory allocation streams.
* **State Machine Thread-Safety & Logic Guardrails:** Implemented strict state verification flags (`isWeaponEquipped`) inside the interactive combat loop execution layer to neutralize duplicate action exploits (e.g., multi-stacking weapon damage vectors).

---

## ⚙️ Execution / Nasıl Çalıştırılır?

```bash
# Clone the repository
git clone [https://github.com/KULLANICI_ADINIZ/CyberQuest.git](https://github.com/KULLANICI_ADINIZ/CyberQuest.git)

# Navigate and execute
cd CyberQuest/src
javac Main.java
java Main

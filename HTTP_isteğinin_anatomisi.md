HTTP (Hyper Text Transfer Protocol), server ile client arasındaki iletişimi sağlamak için tasarlanmış bir haberleşme protokolüdür. Client, server tarafına bir request gönderir ve bu içeriğine göre serverda bir karşılık bulur ardından server bu işlem için client’a bir response döner.

HTTP isteği (HTTP request), sunucuda bir eylem başlatmak ve erişilmek istenilen kaynağı yüklemek için ihtiyaç duyulan kaynakların yüklenebilmesi için istemci tarafından gönderilen mesajlardır.

HTTP İSTEĞİNİN ANATOMİSİ

Start Line
Başlangıç satırları 3 ana öğe içerir:
İstemci tarafından hedef kaynağa gönderilen isteğin, gerçekleştirmek istediği amacı açıklayan bir HTTP metodu.(POST, PUT, GET, DELETE)

Hedef kaynağın yanıt için kullanması için beklenen sürümün bir göstergesi olarak işlev gören, kalan iletinin yapısını tanımlayan HTTP versiyonu.

Genellikle bir URL olan istek veya protokolün, bağlantı noktasının ve etki alanının yolu, genellikle istek bağlamıyla biçimlendirilir. Bu istek hedefinin biçimi, farklı HTTP yöntemleri arasında değişiklik gösterir.

İstemci tarafından hedef kaynağa gönderilen isteğin sonunda '?' ve sorgu dizesi tarafından takip edilen mutlak bir yol:

  •	POST / HTTP/1.1

  •	GET /background.png HTTP/1.0

  •	OPTIONS /anypage.html HTTP/1.0

Headers

İstemci tarafından gelen istekler başlıklar içerir. Başlıklar bir sunucunun istemciden gelen isteklere nasıl yanıt vereceği konusunda ek bilgiler içerebilir.

•	General headers, başlık alanı mesajın tamamına uygulanır.

•	Request headers, başlık alanı isteklerin koşullu olarak kısıtlamayı ve değiştirmeyi sağlar.

•	Representation headers, başlık alanı mesaj verilerinin orijinal biçimini ve uygulanan herhangi bir kodlamayı tanımlar.

<img width="750" height="377" alt="Ekran Resmi 2026-04-13 11 18 26" src="https://github.com/user-attachments/assets/57771163-ba72-426e-9588-2b84d5123437" />


Body

•	İlgili istek talebinin en son aşaması gövde kısmıdır.


· Method (required) — (Example:GET)

· Host (required) — (Example: www.google.com)

· Path (required) — (Example: /search)

· HTTP version (required) — (Example: HTTP/2)

· Headers (optional) — (Example: Content-Type=application/json)

· Query String (optional) — (Example: ?q=test)

· Body (optional) — (Example:{“q”: ”test”})

  <img width="656" height="221" alt="public" src="https://github.com/user-attachments/assets/40f24aee-7d03-4883-ab2a-04fe27f17bc1" />


HTTP Metodları

HTTP sunucuya yapılacak olan isteğin tipini belirlemek için farklı methodlar kullanır.Bunlar:

Get: Sunucuda halihazırda bulunan bir kaynağa erişim için kullanılır.

Post: Sunucu üzerinde yeni bir kaynak oluşturmak için kullanılır. Post istekleri genellikle yeni oluşturulacak kaynağa ait bilgiyi de taşırlar.

Put: Sunucudaki bir kaynağı güncellemek için kullanılır. Bu istekler de genellikle üzerilerinde değiştirilmek istenen bilgiyi taşırlar.

Patch: Bu metot da sunucudaki bir kaynağı değiştirmek için kullanılır. Put ile arasındaki fark ise Put sunucudaki kaynağı yeni bir kaynak ile değiştirmek için kullanılır iken, Patch bu kaynağında bir kısmını değiştirmeye yarar.

Delete: Sunucudaki bir kaynağı silmeye yarar.

Daha az kullanılan metodlar:

Connect: Sunucu ile bir bağlantı oluşturma isteği gönderir. Sunucu bağlantılarını minimum yük ile test etme olanağı sağlar.

Head: Sunucuya aynı Get metodu gibi ancak sadece başlığı olan (Request Header), gövdesi olmayan(Request Body) bir istek gönderir. Genellikle sunucuda bir kaynak mevcut mu veya kaynağın en son güncellenme bilgisi için kullanılır.

Options: Sunucunun desteklediği metotları kontrol etmek için kullanılır.

Trace: Bu metod ile bir sunucuya istek gönderdiğinizde, aradaki tüm vekil sunucular (Proxy, Gateway) isteğin başlığına kendi IP veya DNS biglilerini eklerler. Genellikle hata ayıklama işleri için kullanılır.

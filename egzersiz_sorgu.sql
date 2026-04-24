-- Toplam cirosu 50k'dan büyük müşteriler 
SELECT c.contact_name, SUM(od.unit_price * od.quantity) AS total_ciro
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN order_details od ON o.order_id = od.order_id
GROUP BY c.customer_id, c.contact_name
HAVING SUM(od.unit_price * od.quantity) > 50000
ORDER BY total_ciro DESC;


-- Her kategori için en az 5 farklı ürün satan kategoriler
SELECT  c.category_name,COUNT(p.product_id) AS ürün_sayısı
FROM categories c
JOIN products p ON c.category_id = p.category_id
GROUP BY c.category_id, c.category_name
HAVING COUNT(p.product_id) >= 5
ORDER BY ürün_sayısı DESC;

-- Çalışan bazlı toplam satış tutarı
SELECT e.first_name,e.last_name, SUM(od.unit_price * od.quantity) AS total_sales
FROM employees e
JOIN orders o ON e.employee_id = o.employee_id
JOIN order_details od ON o.order_id = od.order_id
GROUP BY e.employee_id, e.first_name, e.last_name
ORDER BY total_sales DESC;
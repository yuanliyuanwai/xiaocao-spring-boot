1.使用jdk自带的 keytools 创建证书
keytool -genkey -alias tomcat -keyalg RSA -keystore ./server.keystore
2.將server.keystore複製到項目的根目錄
3.在application.properties中添加如下配置
server.port=443
server.ssl.key-store=server.keystore
server.ssl.key-alias=tomcat
server.ssl.enabled=true
server.ssl.key-store-password=123456
server.ssl.key-store-type=JKS
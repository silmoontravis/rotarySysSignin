# 扶輪社簡易報到系統

管理看板：https://trello.com/b/g9SoPcpv/%E7%B0%BD%E5%88%B0%E7%B3%BB%E7%B5%B1

## 版本號v1

* 簽到功能
* 查詢簽到記錄

## 運行需求 & 指令

* 安裝 [Docker](https://docs.docker.com/get-docker/) | [中文](https://www.runoob.com/docker/ubuntu-docker-install.html)
* 安裝 [Docker-compose](https://docs.docker.com/compose/install/)
  | [中文](https://www.runoob.com/docker/docker-compose.html)
* 在本資料夾路徑執行 docker-compose up -d
* 頁面路徑
    - http://docker.domain/
* 後端 API 文件
    - http://docker.domain:8080/doc.html
* 關閉指令為 docker-compose down
* 如需完全清除, 指令為 docker-compose down -v

## Windows docker 事前準備作業

* Windows 10 安裝 [WSL2](https://docs.microsoft.com/zh-tw/windows/wsl/install-win10)

## 開發測試需求 & 指令

* 安裝 [JDK11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
  | [中文](https://www.runoob.com/java/java-environment-setup.html)
    - PS. 因版權問題, 不一定非要 Oracle 版本 JDK,
      建議使用 [Amazon Corretto](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
* 安裝 [Docker](https://docs.docker.com/get-docker/) | [中文](https://www.runoob.com/docker/ubuntu-docker-install.html)
* 安裝 [Docker-compose](https://docs.docker.com/compose/install/)
  | [中文](https://www.runoob.com/docker/docker-compose.html)
* 執行 gradle docker (如果使用 IntelliJ, 有 Gradle Panel 可以直接點選 Tasks>distribution>docker)
* 執行 docker-compose -f develop-compose.yml build
* 執行 docker-compose -f develop-compose.yml up -d
* 關閉指令為 docker-compose -f develop-compose.yml down
* 如需完全清除, 指令為 docker-compose -f develop-compose.yml down -v
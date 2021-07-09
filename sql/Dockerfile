# 基础镜像
FROM mysql:5.7
ENV         TZ=Asia/Taipei
RUN         ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 执行sql脚本
ADD ./*.sql /docker-entrypoint-initdb.d/

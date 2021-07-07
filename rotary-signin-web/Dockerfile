# 基础镜像
FROM nginx
# author
MAINTAINER ruoyi

# 挂载目录
VOLUME /home/app/projects/web
# 创建目录
RUN mkdir -p /home/app/projects/web
# 指定路径
WORKDIR /home/app/projects/web
# 复制conf文件到路径
COPY ./conf/nginx.conf /etc/nginx/nginx.conf
# 复制html文件到路径
COPY ./html/dist /home/app/projects/web

# spring cloud 搭建的架构

springboot 2.7.10

springcloud 2021.0.5

cloud-platform-api 层放置 entity dto service接口定义

cloud-platform-controller 对外提供接口的聚合层 提供api服务

cloud-platform-service 基础服务层

cloud-platform-lib 项目中一些通用的工具类

开发标准
基础服务不允许调用基础服务
聚合层不允许调用聚合层
代码要规范 要有注释 具体查看 开发规范

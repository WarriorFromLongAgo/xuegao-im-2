// package com.sf.edu.config;
//
// import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
// import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
// import javax.sql.DataSource;
//
// @Configuration
// public class EduDataSource {
//
//     /**
//      * 返回data1数据库的会话工厂
//      */
//     @Bean(name = "dataSqlSessionFactory")
//     @Primary
//     public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//         // 解决 Invalid bound statement 问题
//         MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
//         // SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//
//         bean.setDataSource(dataSource);
//         //Intercept[] cept = new Intercept[2];
//         //cept[0] = new PaginationInterceptor();
//         bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
//         return bean.getObject();
//     }
//
//     /**
//      * 返回data1数据库的会话模板
//      */
//     @Bean(name = "data1SqlSessionTemplate")
//     @Primary
//     public SqlSessionTemplate sqlSessionTemplate(@Qualifier("dataSqlSessionFactory") SqlSessionFactory sessionFactory) throws Exception {
//         return new SqlSessionTemplate(sessionFactory);
//     }
//
//     /**
//      * 返回data1数据库的事务
//      */
//     @Bean(name = "data1TransactionManager")
//     @Primary
//     public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource ds) {
//         return new DataSourceTransactionManager(ds);
//     }
// }
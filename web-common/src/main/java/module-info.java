module web.common {

    requires static lombok;
    requires org.slf4j;
    requires java.desktop;

    exports com.cloud.common.model;
    exports com.cloud.common.util;

    exports com.cloud.common.constant;
    exports com.cloud.common.message.model;
    exports com.cloud.common.message.constant;

}
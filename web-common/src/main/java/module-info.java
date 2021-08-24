module web.common {

    requires static lombok;
    requires org.slf4j;
    requires java.desktop;

    exports com.cloud.common.common.model;
    exports com.cloud.common.common.util;

    exports com.cloud.common.common.constant;
    exports com.cloud.common.message.common.model;
    exports com.cloud.common.message.common.constant;

}
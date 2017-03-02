package com.blog.blogsit.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * JSON解析类
 *
 * @author hua.chen
 * @create 2016年11月15日11:43
 **/
public class JSONUtil {

    private static SerializeConfig config = null;

    private static ParserConfig parserConfig = null;

    static {
        config = new SerializeConfig();
        parserConfig = new ParserConfig();
    }

    public static final JSONProvider defaultJsonProvider = new JSONProvider() {

        @Override
        public String toJSONString(Object obj) {
            SerializeWriter out = new SerializeWriter(SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteEnumUsingToString, SerializerFeature.QuoteFieldNames,
                    SerializerFeature.SkipTransientField, SerializerFeature.DisableCircularReferenceDetect);
            try {
                JSONSerializer serializer = new JSONSerializer(out, config);
                serializer.getNameFilters().add(new NameFilter() {

                    @Override
                    public String process(Object object, String name, Object value) {
                        return name;
                    }
                });

                serializer.write(obj);

                String str = out.toString();

                return str;
            } finally {
                out.close();
            }
        }

        @Override
        public <T> T fromJSONString(String json, Class<T> clazz) {
            return (T) JSON.parseObject(json, clazz, parserConfig, JSON.DEFAULT_PARSER_FEATURE);
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> T fromJSONString(String json, TypeReference<T> typeRef) {
            return (T) JSON.parseObject(json, typeRef.getType(), parserConfig, JSON.DEFAULT_PARSER_FEATURE);
        }
    };

    public static String toJSONString(Object obj) {
        return defaultJsonProvider.toJSONString(obj);
    }

    public static <T> T fromJSONString(String json, Class<T> clazz) {
        return defaultJsonProvider.fromJSONString(json, clazz);
    }

    public static <T> T fromJSONString(String json, TypeReference<T> typeRef) {
        return defaultJsonProvider.fromJSONString(json, typeRef);
    }

}
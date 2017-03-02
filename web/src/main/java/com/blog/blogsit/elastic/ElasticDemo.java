package com.blog.blogsit.elastic;

import java.util.List;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import com.alibaba.fastjson.JSON;

public class ElasticDemo {
    private static TransportClient client;
    private static String hostName = "";

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.sniff", true).put("client.transport.ping_timeout", "50s")
                .put("client.transport.nodes_sampler_interval", "50s").put("client", true)
                .put("data", false).put("cluster.name", "ac_es_cluster").build();
        client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(hostName, 9200));
        SearchResponse response = client.prepareSearch("megacorp")
                .setTypes("employee")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("last_name", "chen"))             // Query
                .setPostFilter(FilterBuilders.rangeFilter("age").from(12).to(28))   // Filter
                .setFrom(0).setSize(60).setExplain(true)
                .execute()
                .actionGet();
        SearchHits searchHits =response.getHits();
        for (SearchHit searchHit : searchHits) {
            System.out.println(JSON.toJSONString(searchHit.getSourceAsString()));
        }
    }
    /**
     * 创建新的index  type
     * 功能描述：<br>
     * @param indexname
     * @param type
     * @param jsondata 
     * @author hua.chen 2015年10月28日 下午4:04:35 <br>
     * 修改记录:
     */
    public void createIndexResponse(String indexname, String type, List<String> jsondata){
        //创建索引库 需要注意的是.setRefresh(true)这里一定要设置,否则第一次建立索引查找不到数据
        IndexRequestBuilder requestBuilder = client.prepareIndex(indexname, type).setRefresh(true);
        for(int i=0; i<jsondata.size(); i++){
            requestBuilder.setSource(jsondata.get(i)).execute().actionGet();
        }     
         
    }
}

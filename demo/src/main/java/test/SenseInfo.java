package test;

import org.apache.commons.collections.FastHashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 845477519@qq.com on 2017/10/13 0013.
 */
public class SenseInfo {
    public static void main(String[] args) throws Exception {

        Map<String, String> map = new HashMap();
        map.put("corpCode", "LLY");
        map.put("accessToken", "072df906-669f-49cb-8c02-a36d4ebe");
        map.put("jobId", "2017101700001");
        map.put("phone", "15801882820");
        map.put("templateCode", "M0");
        map.put("timestarp", "1508223265029");
        map.put("jobData", "{\"loanUsername\":\"巴哥\",\"loanUserGender\":\"男\",\"loanChannel\":\"一键借\",\"loanOverdueDay\":\"3\",\"loanRepayAmount\":\"1100\"}");
        String result = HttpClientUtil.doPost("http://117.78.49.154:2437/external/openApi/job/build", map);
        System.out.println(result);
    }
}

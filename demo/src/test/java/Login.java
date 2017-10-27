

import cn.upenny.common.util.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 845477519@qq.com on 2017/8/2 0002.
 */
public class Login {
    public static void main(String[] args) throws Exception{
        Map header = new HashMap<String, String>();
        Map param = new HashMap<String, String>();

        String uuid = UUID.randomUUID().toString();

        //POST /uc/loginService?uuid=36c21338-779b-480f-baf0-5fef9782682b&ReturnUrl=https%3A%2F%2Fwww.jd.com%2F&r=0.3479202006988704&version=2015 HTTP/1.1
        header.put("Host","passport.jd.com");
        header.put("Connection","keep-alive");
        header.put("Accept","text/plain, */*; q=0.01");
        header.put("Origin","https://passport.jd.com");
        header.put("X-Requested-With","XMLHttpRequest");
        header.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36");
        header.put("Content-Type","pplication/x-www-form-urlencoded; charset=UTF-8");
        header.put("Referer","https://passport.jd.com/new/login.aspx?ReturnUrl=https%3A%2F%2Fwww.jd.com%2F");
        header.put("Accept-Encoding","gzip, deflate, br");
        header.put("Accept-Language"," zh-CN,zh;q=0.8");
        header.put("Cookie","_ntAhnrY=PFSrLhX2AE8UVWR5icE2YltHo5yrzZjdgSXFqBeUjfA=; user-key=551ac05a-9c80-4eb9-882b-4aa1f6b32352; _ntlRjdq=AgEPgE+SUkMB/b9a5oGytPKNfmuZC2pycElJ5a29To0=; _ntlBnJj=UbCr3MG7Vo4nag5qXjwwkxTYc/rIE/GMgrvIRu5iphw=; _nttbvsc=VnnlLpdcO6c+8tX5glj4dbQL6FfeNJ7rJqrhON7ZJFg=; _ntIshoU=pkuTysMdn6WRCjvo2uJ0MkPTS7v4tGxSDBC+Qh7dMwg=; _ntiGRrr=L/tXXQbc6HuGvKwj5fylJ1hLubocNXCv67ijNcwusgc=; _ntvrYcL=QA5CyynEvlB1YsAErfU7omsJnIyXjUjcba/8tf5Ygpc=; sid=2a53afc65d592254fb7bfc30f2c67caf; _ntgoyTB=lXVEAPbQOg/M4eyy5IO2KpBEDNL/3Luj/zXtDQNH24A=; _ntCXUCC=RuoJX9RYIJGg4aD18jc51RSewc3Su0tKPxyFyc+9u1Q=; _ntaVfRh=hz57K8R1t6gpsyEs7Czm/gOIijbXC82VHmjecfrM1vs=; _ntkUgjg=7dcOvd+YSII8F0Wc623I74sJD/xVJqskKo6GbWPjp40=; _ntOTgUv=L7n6qPc+o66/3naGG8qz0GtLBwPopCaEWqYtIL14grw=; _ntppCZI=rx//tajm2sGuUrP5dIahGd3ycW1Mk/gtfVBR37+q3Do=; _ntWpIkk=LC4cG8y2kxAXI78Rx5NeXjykFc7C3ZqUZzUd2FJrsOg=; _ntlsDZP=DvDHNPe2BJQFtNAV8po/y13HSvfwVBp4cjNVXtUfxlE=; _ntKZlHE=7ccnwKEdzT5yPdeGvKkzJ+N9Jrw8PCGFV8qRxN6SZc0=; _nttJwGX=hOGuH6HiNZy2/udXCn/Dn46kiO2WaDhhzYnXtdypC3Y=; _ntXbdzw=eh7gTmQPflhyqUaixg4BPol34c5vWpjSNvDRtNrQ4c8=; _ntvkSBr=vSDBI2+IDANFMFWmli7EsT6STzEjRdg0KQgOpofj3ng=; dmpjs=dmp-d548577124c5637e44d6dce1092e56b8bef3115; _ntRryLz=uA2eUBAdAd3HUELl1wSU/XbwRNyvkVBG/aSYoT4Wi2U=; _ntCpVCo=EbTRFuqIyZnt+0pTN8W/rbbXbfG5Zn4vc14eMKdV7xE=; _ntqLNgY=X8qlPztMugiOfs35AqvWpczpzNUqbK67M+dXLnlsqgE=; _ntNICfP=MBCSZzosM/Uo8stQ/p0wITUn7hgIBBWim6J/Ckqf7PA=; _ntFAFdH=/wA5HeZJDMznOAo6baxu+MMSyXJ79A1PSvNxyfZPoWI=; _ntjjsTn=dwAi62CpQywoV+p9aQBQPX1fxr1+URQhQ6OWiDTL8q0=; areaId=2; __jdv=122270672|google-union|t_262767352_googleunion|cpc|196279102548_0_0cca94f572a24e3d9c3a0141abdac856|1501496586139; unpl=V2_ZzNtbRFTQhB2XRUGKB5aUmILF11LBBdCIg0TA3pJDAU0BBcNclRCFXMUR11nGFwUZwIZXEVcRxZFCEJkeBhcBG8BEFhBX3MlfQAoV0saXDVnAhJtQlJKFXELR118EVgCYgMUWkFVRRBwD3Zkex9sB2cBEFRCUXPB9ICR8%2frO2b9XHxJtQ2dCJSNmRlV6GF0EZgMRWw9XRhx1DEVVch5UAWAGEltFVEETcA1BZHopXw%3d%3d; _ntgQbsy=49wIf6nkJmI29FYogatLrntZy6mFRzGo8w7B5Ux8qOk=; _nthDKvB=rDnz9a023NI4ChL8wL0IzUP5DRrVbhTTVVDbbDI10GI=; __utmz=122270672.1501554795.1.1.utmcsr=marathon.jd.com|utmccn=(referral)|utmcmd=referral|utmcct=/seckill/seckill.action; mp=13122868630; _ntunJdc=gh8O3LHVoPG+RmD44yjchSULGKqg0qPyeIjA0amAjTE=; _ntOXINo=GjgiD+bbCbkSIMt6xB532hSY14nbSehjOVcu+UQ3DmA=; TrackID=1MTJ7BjGFBRpr1nPjCyeqJ6M19X3vo--tVn1tUoG8uLd0JDQ4HZFyDHZf1o3_rqljl1OMOeDMN0HkKDlNIA20f1IEoPCf8osGLx6RhlHaXqY; pinId=EUfvzX33uL-xfrgeQLyag7V9-x-f3wj7; pin=jd_70619831cd90d; unick=jd_893470427; ol=1; _tp=BywC5N7f0gBMQCTja6%2B47crtAoGY6A4sqOdfTUqHofw%3D; _pst=jd_70619831cd90d; ceshi3.com=000; ipLoc-djd=7-549-556-39683.138823280; ipLocation=%u6cb3%u5357; cn=1; _ntYosVd=a0SsjQT7iqcQZKIKTg+Lil+j/EkkGmFRvlSEtnwlZFs=; _nttiCpM=3DsNzIxTTuZykA57FkOebhZwXwyVUcMzcQ77UZFHT80=; qr_t=c; alc=z6LOTT942OBXtidzEXZu9Q==; _ntVeOcI=wG1FGtHsKOS1RtXrnlpuLql/COWUTklvNCFGnS7WDBI=; __jda=122270672.1481520869564176237446.1481520870.1501639800.1501644095.140; __jdb=122270672.3.1481520869564176237446|140.1501644095; __jdc=122270672; _jrda=1; _jrdb=1501644253867; wlfstk_smdl=7l2vxiwkbr1y3n3p5zuiyz6gcg8xpeix; 3AB9D23F7A4B3C9B=PNSXOD4E2X3JXVNEGIMYZ6SKJKDTND3QWAGXXLG3YOOMZV4ZBQCWO6WCBMD7AGA4SXZHIPWMNQQV3IW4XIF7GQ7ARE; __jdu=1481520869564176237446");


        param.put("uuid",uuid);
        param.put("eid","PNSXOD4E2X3JXVNEGIMYZ6SKJKDTND3QWAGXXLG3YOOMZV4ZBQCWO6WCBMD7AGA4SXZHIPWMNQQV3IW4XIF7GQ7ARE");
        param.put("fp","fafd5bcf229d8e41e67c5a1e98f5a4d9");
        param.put("_t","_ntVeOcI");
        param.put("loginType","c");
        param.put("loginname","13122868630");
        param.put("nloginpwd","k4X/cj4Ml7E+lbeFC+zCauW/MhyZ7yOQ9medkSMCTsdfzBsWQ0q3EeT5tgYPYzabBcw33Ea7EOq9u+YCF03cd1wwLX8SXGp+HC1ql8UM3F7V7vcLll621McbbBFzKMEYcShEbaD5pfEzGEGt44jsxQujWVXIRSi01NczM0yqcyI=");
        param.put("chkRememberMe","");
        param.put("authcode","");
        param.put("pubKey","MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC7kw8r6tq43pwApYvkJ5laljaN9BZb21TAIfT/vexbobzH7Q8SUdP5uDPXEBKzOjx2L28y7Xs1d9v3tdPfKI2LR7PAzWBmDMn8riHrDDNpUpJnlAGUqJG9ooPn8j7YNpcxCa1iybOlc2kEhmJn5uwoanQq+CA6agNkqly2H4j6wIDAQAB");
        param.put("sa_token","B68C442BE645754F33277E701208059080DD726A94A73F76DEC3053A838549C06EB7D3797CE1C5BBE7C2B2EF9CA7D4676F3D489984B517943EA13575FA80C7E7ACE37FCFF6F535F07B6FF67F57EA6A0581BD84EA37554047DF10ECB7C873652D89DB5CAEE8F1090FB49A29547319CF16FBF33734EFA4BF8F86849797883219C3E197A604140E904BA7E538273F59893FDF9BFD6EBA3121C9E3CD43FCF0A83781637E82D45F8498284ACF6DBE6B9A2ECA93D841180E73641C35967A9B97DF494AD0259326D0ADEBBBD4BB7EC3EF55FD93296928D1A800A45923F778CCE16BD041DC404BE5596D65ADCBDE8241B0144FD60E5A218815766E661E1AF10BED828070BC36CF600F1D954D6ACE9614E19FDBA5E1EC521CC4119878D2441A5AE20D5DB6EB33805594E901E7AD412288548DF5B3ED7047CC6B07EE5D61D64E02CFD524CA2932414651779C9F0C97BEA6AC19EC6BCA21E92591CC1BF18D06310173B9F809B53E9A1676C30846EA19A58A48BEC331693E98AFC044185FB30FAB6C6BFF9B6A9DEF5732EC096E67AB81E3AF259669B0713DC47EFBA990601B2878807EEB23350ADE5D9F80BA745F1DC641EB027DE836A6FE2B2A54B0099547AB9EDC8AB512BF25A107FED8BDA48B84180734B831C0BE");
        param.put("seqSid","23");

        HttpClientUtils.setHeader(header);
        System.out.print(HttpClientUtils.doPost("https://passport.jd.com/uc/loginService?uuid="+ uuid +"&ReturnUrl=https%3A%2F%2Fwww.jd.com%2F&r=0.3479202006988704&version=2015", param));


    }
}

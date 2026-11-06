package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Order(4)
public class UserTestRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(UserTestRunner.class);
   private final UserService userService;
   private final PasswordEncoder encoder;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      log.info("用户导入更新开始............................................");
      String a1 = "\tA002171\t,\t孙德\t,\t0\t,\t13857178630\t+\tA002223\t,\t张俊杰\t,\t0\t,\t13306517939\t+\tA003614\t,\t程康\t,\t0\t,\t18605596609\t+\tA003621\t,\t汪仁华\t,\t0\t,\t18762993782\t+\tA003640\t,\t沈叶刚\t,\t0\t,\t13600533664\t+\tA003641\t,\t孟宪计\t,\t0\t,\t18732664646\t+\tA003727\t,\t陈建亚\t,\t1\t,\t18368030669\t+\tA005265\t,\t汤伟江\t,\t0\t,\t15268811448\t+\tA005342\t,\t周俊杰\t,\t0\t,\t13626732791\t+\tA005440\t,\t姜继军\t,\t0\t,\t18058944997\t+\tA005589\t,\t邵江锋\t,\t0\t,\t13362563022\t+\tA005854\t,\t方益清\t,\t0\t,\t13515814836\t+\tA007372\t,\t施小军\t,\t0\t,\t18072802258\t+\tA000267\t,\t曹本富\t,\t0\t,\t15988104358\t+\tA000325\t,\t孙嘉伟\t,\t0\t,\t15868137802\t+\tA000494\t,\t黄楚华\t,\t0\t,\t13735568890\t+\tA001340\t,\t郑国忠\t,\t0\t,\t13805720636\t+\tA001407\t,\t林书达\t,\t0\t,\t13777387282\t+\tA001562\t,\t姜风\t,\t0\t,\t17682320021\t+\tA001584\t,\t罗光乾\t,\t0\t,\t15398356545\t+\tA001585\t,\t习凡\t,\t0\t,\t18358106231\t+\tA001586\t,\t洪峰\t,\t0\t,\t13867159860\t+\tA001587\t,\t周荷枫\t,\t0\t,\t15157729936\t+\tA001592\t,\t王荣军\t,\t0\t,\t13967134516\t+\tA001593\t,\t董武才\t,\t0\t,\t13757136598\t+\tA001649\t,\t夏厚爽\t,\t0\t,\t15152104402\t+\tA001679\t,\t娄铁平\t,\t0\t,\t13754340061\t+\tA001680\t,\t周楼锋\t,\t0\t,\t15967122033\t+\tA001720\t,\t黄琪\t,\t0\t,\t15658002867\t+\tA001721\t,\t郑佳凯\t,\t0\t,\t17826824061\t+\tA001912\t,\t高杰\t,\t0\t,\t13588752919\t+\tA001981\t,\t佘尚华\t,\t0\t,\t15371312565\t+\tA002019\t,\t雍其\t,\t0\t,\t15168144887\t+\tA002020\t,\t张召\t,\t0\t,\t18721787085\t+\tA002138\t,\t刘国伟\t,\t0\t,\t18868878908\t+\tA002164\t,\t张忆锋\t,\t0\t,\t13758102828\t+\tA002174\t,\t洪佳烽\t,\t0\t,\t13606630433\t+\tA002175\t,\t周宇\t,\t0\t,\t17858698710\t+\tA002224\t,\t肖文星\t,\t0\t,\t13216105087\t+\tA002255\t,\t邱杭钦\t,\t0\t,\t18888645292\t+\tA002617\t,\t张一骥\t,\t0\t,\t15867042408\t+\tA002618\t,\t许睿\t,\t0\t,\t18042323111\t+\tA002620\t,\t彭煜喜\t,\t0\t,\t13858047342\t+\tA002621\t,\t汪立飞\t,\t0\t,\t13372403088\t+\tA002622\t,\t徐峰\t,\t0\t,\t15957176170\t+\tA002623\t,\t王金岭\t,\t0\t,\t15868159900\t+\tA002624\t,\t张四贵\t,\t0\t,\t15957142000\t+\tA002676\t,\t朱劲松\t,\t0\t,\t13940054832\t+\tA002677\t,\t王革锋\t,\t0\t,\t13676876069\t+\tA002678\t,\t汪国强\t,\t0\t,\t13735554378\t+\tA002686\t,\t沈永庆\t,\t0\t,\t13606630988\t+\tA002692\t,\t余雁飞\t,\t0\t,\t18268123939\t+\tA002734\t,\t李兴\t,\t0\t,\t17788567325\t+\tA002737\t,\t徐飞飞\t,\t1\t,\t13777469373\t+\tA002982\t,\t吴兵\t,\t0\t,\t18817232077\t+\tA003077\t,\t刘江\t,\t0\t,\t13958180563\t+\tA003144\t,\t宋子龙\t,\t0\t,\t18334739128\t+\tA003145\t,\t刘国旺\t,\t0\t,\t13867495188\t+\tA003147\t,\t沈建良\t,\t0\t,\t13357136883\t+\tA003148\t,\t范永康\t,\t0\t,\t13099110677\t+\tA003169\t,\t张云龙\t,\t0\t,\t18732298588\t+\tA003230\t,\t张永\t,\t0\t,\t18634415075\t+\tA003231\t,\t唐代刚\t,\t0\t,\t18786817818\t+\tA003325\t,\t王燕\t,\t1\t,\t13456923223\t+\tA003326\t,\t施琼燕\t,\t1\t,\t13616537491\t+\tA003327\t,\t吕灵芝\t,\t1\t,\t13906711959\t+\tA003410\t,\t汪焕铭\t,\t0\t,\t15858189019\t+\tA003411\t,\t谭爽\t,\t0\t,\t17816128305\t+\tA003510\t,\t余庆生\t,\t0\t,\t13349269905\t+\tA003511\t,\t杨基裕\t,\t0\t,\t13067703874\t+\tA003562\t,\t金来发\t,\t0\t,\t15258890797\t+\tA003809\t,\t褚伟\t,\t0\t,\t18314863976\t+\tA003867\t,\t余荣贵\t,\t0\t,\t18757003611\t+\tA003965\t,\t陈辉\t,\t0\t,\t13606711677\t+\tA003971\t,\t张晓辰\t,\t1\t,\t17706434046\t+\tA003977\t,\t郁展浓\t,\t0\t,\t18767365088\t+\tA004110\t,\t李春明\t,\t0\t,\t13757506510\t+\tA004129\t,\t罗祥\t,\t0\t,\t18969010213\t+\tA004364\t,\t王建国\t,\t0\t,\t18106573060\t+\tA004610\t,\t陈建云\t,\t1\t,\t13816940209\t+\tA004614\t,\t华琴\t,\t1\t,\t13811184815\t+\tA004623\t,\t周寅\t,\t0\t,\t15257143936\t+\tA004740\t,\t孝莹\t,\t0\t,\t15234069677\t+\tA004762\t,\t刘吉平\t,\t0\t,\t13758122469\t+\tA004934\t,\t沈传海\t,\t0\t,\t13805753426\t+\tA004983\t,\t楼晓东\t,\t0\t,\t13615789378\t+\tA004997\t,\t李志军\t,\t0\t,\t15729091812\t+\tA005060\t,\t颜海跃\t,\t0\t,\t13818816265\t+\tA005061\t,\t马新东\t,\t0\t,\t13821242717\t+\tA005068\t,\t许宏法\t,\t0\t,\t18268153145\t+\tA005175\t,\t沈强\t,\t0\t,\t13588424967\t+\tA005211\t,\t钱佳琪\t,\t1\t,\t15990101756\t+\tA005230\t,\t张博翔\t,\t0\t,\t13858950881\t+\tA005590\t,\t朱展鸿\t,\t0\t,\t13650881454\t+\tA005600\t,\t张家乐\t,\t0\t,\t19816004416\t+\tA005977\t,\t傅剑峰\t,\t0\t,\t15158151366\t+\tA005979\t,\t单提宏\t,\t0\t,\t18953226693\t+\tA005980\t,\t孙庆刚\t,\t0\t,\t15589308677\t+\tA005981\t,\t单淑丽\t,\t1\t,\t13864355969\t+\tA005982\t,\t单保行\t,\t0\t,\t13153377628\t+\tA006143\t,\t张玉龙\t,\t0\t,\t17614354698\t+\tA006261\t,\t黄锐\t,\t0\t,\t15390272102\t+\tA006503\t,\t王波\t,\t0\t,\t15168479688\t+\tA006898\t,\t凌磊磊\t,\t0\t,\t15178265860\t+\tA006940\t,\t黄文财\t,\t0\t,\t18322856491\t+\tA006967\t,\t邓继战\t,\t0\t,\t18258163251\t+\tA006969\t,\t韩鹏坚\t,\t0\t,\t14735015016\t+\tA000234\t,\t沈烈锋\t,\t0\t,\t18805818838\t+\tA000235\t,\t黄世晔\t,\t0\t,\t13967124925\t+\tA000242\t,\t姚磊\t,\t0\t,\t15858089707\t+\tA000284\t,\t汪军民\t,\t0\t,\t13336188081\t+\tA000776\t,\t孙杰\t,\t0\t,\t13967106687\t+\tA000858\t,\t戴飞特\t,\t0\t,\t13868183912\t+\tA000893\t,\t华萍\t,\t1\t,\t13867432707\t+\tA000905\t,\t童晓良\t,\t0\t,\t13336116633\t+\tA000956\t,\t吴文梁\t,\t0\t,\t13867184488\t+\tA001045\t,\t张俊\t,\t0\t,\t13706505001\t+\tA001077\t,\t戴国标\t,\t0\t,\t13968067108\t+\tA001150\t,\t金国灿\t,\t0\t,\t13588581373\t+\tA001297\t,\t李从生\t,\t0\t,\t18658156015\t+\tA001359\t,\t王红良\t,\t0\t,\t13868058555\t+\tA001408\t,\t黄志胜\t,\t0\t,\t13325862323\t+\tA001524\t,\t程福根\t,\t0\t,\t18858178978\t+\tA001596\t,\t谢红芳\t,\t1\t,\t18657518668\t+\tA001709\t,\t徐子城\t,\t0\t,\t13735050400\t+\tA001760\t,\t徐华英\t,\t1\t,\t13675757781\t+\tA001764\t,\t徐关春\t,\t0\t,\t17767156378\t+\tA001765\t,\t施凯佳\t,\t1\t,\t15888865281\t+\tA001807\t,\t周建欢\t,\t0\t,\t13867120788\t+\tA001814\t,\t谢海燕\t,\t1\t,\t15068871181\t+\tA001950\t,\t叶慧华\t,\t0\t,\t13656672816\t+\tA002018\t,\t熊军\t,\t0\t,\t13316705999\t+\tA002021\t,\t王亚锋\t,\t0\t,\t13967112168\t+\tA002067\t,\t金卫锋\t,\t0\t,\t13185714093\t+\tA002085\t,\t谢建军\t,\t0\t,\t13967121601\t+\tA002086\t,\t王保分\t,\t1\t,\t13867429978\t+\tA002087\t,\t陈永\t,\t0\t,\t13636262002\t+\tA002136\t,\t邓小强\t,\t0\t,\t18981406980\t+\tA002169\t,\t洪靖华\t,\t0\t,\t18057166999\t+\tA002173\t,\t姚银飞\t,\t1\t,\t18267187070\t+\tA002308\t,\t李成军\t,\t0\t,\t13906712709\t+\tA002435\t,\t胡建康\t,\t0\t,\t13506719020\t+\tA002675\t,\t郑永林\t,\t0\t,\t13906711836\t+\tA003257\t,\t逯柏林\t,\t0\t,\t13942637555\t+\tA003527\t,\t梁铭荣\t,\t0\t,\t18923715205\t+\tA004521\t,\t徐继红\t,\t0\t,\t13754259788\t+\tA004613\t,\t刘涛\t,\t0\t,\t13015508327\t+\tA004622\t,\t陈宏明\t,\t0\t,\t18767132904\t+\tA004896\t,\t王妙燕\t,\t1\t,\t13738136078\t+\tA005528\t,\t马小建\t,\t0\t,\t18605217283\t+\tA005699\t,\t杨晓兵\t,\t0\t,\t16696661089\t+\tA005700\t,\t马一丁\t,\t0\t,\t13758279072\t+\tA005978\t,\t单提卫\t,\t0\t,\t13053318660\t+\tA006279\t,\t颜庆党\t,\t0\t,\t13904907210\t+\tA007130\t,\t李燕\t,\t1\t,\t18005886432\t+\tA001583\t,\t刘莉\t,\t1\t,\t13616712828\t+\tA001991\t,\t许馥桂\t,\t1\t,\t18257530338\t+\tA001992\t,\t王海荣\t,\t1\t,\t15067188858\t+\tA002137\t,\t施亚芳\t,\t1\t,\t13067980407\t+\tA002307\t,\t俞小平\t,\t1\t,\t13184214088\t+\tA002598\t,\t陈爱君\t,\t1\t,\t13566993448\t+\tA002735\t,\t徐家丽\t,\t1\t,\t15867168433\t+\tA002802\t,\t孙翠红\t,\t1\t,\t13968018933\t+\tA002855\t,\t张雪梅\t,\t1\t,\t15888821992\t+\tA003495\t,\t赵文艺\t,\t1\t,\t13646859780\t+\tA003496\t,\t沈春敏\t,\t1\t,\t13968154745\t+\tA003519\t,\t宋丹学\t,\t1\t,\t13758542933\t+\tA003670\t,\t来银玲\t,\t1\t,\t13336026821\t+\tA004146\t,\t蒋安\t,\t1\t,\t13968193419\t+\tA004158\t,\t陈叶爽\t,\t1\t,\t13357053970\t+\tA005853\t,\t袁静波\t,\t0\t,\t15957166790\t+\tA006140\t,\t郑金魁\t,\t0\t,\t13986831238\t+\tA006141\t,\t张法\t,\t0\t,\t13777372613\t+\tA006280\t,\t刘宗将\t,\t0\t,\t18353718886\t+\tA006282\t,\t杨万里\t,\t0\t,\t18238214000\t+\tA007064\t,\t李少科\t,\t0\t,\t17797604346\t+\tA006331\t,\t俞桔红\t,\t1\t,\t13567192776\t+\tA006939\t,\t倪晶\t,\t1\t,\t13588062259\t+\tA000733\t,\t杨建峰\t,\t0\t,\t13750864791\t+\tA006968\t,\t来佳炳\t,\t0\t,\t19560161951\t+\tA007270\t,\t沈叶芳\t,\t1\t,\t18967123161\t+\tA007065\t,\t黄琴标\t,\t0\t,\t15858169865\t+";
      String[] split = a1.split("\\+");
      this.setUser(split);
      log.info("用户导入更新结束............................................");
   }

   private void setUser(String[] split) {
      for (String s : split) {
         String trim = s.trim();
         List<String> stringList = Arrays.asList(trim.split(","));
         String usernameNumber = stringList.get(0).trim();
         String name = stringList.get(1).trim();
         String sexName = stringList.get(2).trim();
         String phone = stringList.get(3).trim();
         if (phone.split("/").length > 1) {
            String[] split2 = phone.split("/");
            phone = split2[0];
         }

         User user = this.userService.getOne((Wrapper<User>)new LambdaQueryWrapper<User>().eq(User::getPhone, phone));
         if (user == null) {
            user = new User();
            user.setUsername(usernameNumber);
            user.setName(name);
            user.setPhone(phone);
            user.setSex(Integer.valueOf(sexName));
            user.setPassword(this.encoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")));
            user.setLastPasswordResetDate(LocalDateTime.now());
            user.setIsEnabled(Boolean.TRUE);
            user.setUserType(UserTypeEnum.COMMON_USER.getType());
            this.userService.save(user);
         } else {
            Boolean flag = false;
            if (!user.getName().equals(name)) {
               user.setName(name);
               flag = true;
            }

            if (!user.getUsername().equals(usernameNumber)) {
               user.setUsername(usernameNumber);
            }

            if (flag) {
               this.userService.updateById(user);
            }
         }
      }
   }

   public UserTestRunner(final UserService userService, final PasswordEncoder encoder) {
      this.userService = userService;
      this.encoder = encoder;
   }
}
